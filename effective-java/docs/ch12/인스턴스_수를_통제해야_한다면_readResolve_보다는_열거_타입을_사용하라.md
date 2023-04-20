# 인스턴스 수를 통제해야 한다면 readResolve보다는 열거 타입을 사용하라
다음은 아이템 3에서 소개한 싱글톤 패턴을 구현하는 방법 중 한 가지이다.
~~~java
public class Elvis {
    public static final Elvis INSTANCE = new Elvis();
    private Elvis() { ... }
    public void leaveTheBuild() { ... }
}
~~~

이 클래스에서 `implement Serializable`을 추가하는 순간 더 이상 싱글턴이 아니게 된다. 
어떤 readObject를 제공하더라도 이 클래스가 초기화될 때 만들어진 인스턴스와는 별개인 인스턴스를 반환하게 된다.

### readResolve 역직렬화여
readResolve 기능을 이용하면 readObject가 만들어낸 인스턴스를 다른 것으로 대체할 수 있다. 역직렬화한 객체의 클래스가 readResolve 메서드를 적절히 정의해뒀다면,
역직렬화 후 새로 생성된 객체를 인수로 이 메서드가 호출되고, 이 메서드가 반환한 객체 참조가 새로 생성된 객체를 대신해 반환된다.

~~~java
// 진짜 Elvis를 반환하고, 가짜 Elvis는 가비지 컬렉터에 맡긴다. 
private Object readResolve() {
    return INSTANCE;    
}
~~~
이 메서드는 역직렬화한 객체는 무시하고 클래스 초기화 때 만들어진 Elvis 인스턴스를 반환한다. 따라서 Elvis 인스턴스의 직렬화 형태는 아무런 실 데이터를 가질 이유가 없으니
모든 인스턴스 필드를 transiet로 선언해야 한다. 

**사실 readResolve를 인스턴스 통제 목적으로 사용한다면 객체 참조 타입 인스턴스 필드는 모두 transient로 선언해야 한다.** <br>
 -> 이는 역직렬화된 객체의 참조를 공격할 여지가 남지 않는다.

### 열거 타입 싱글턴
이처럼 readResolve 메서드를 사용해 '순간적으로' 만들어진 역직렬화된 인스턴스에 접근하지 못하게 하는 방법은 깨지기 쉽고 신경을 많이 써야 하는 작업이다.
열거 타입 싱글턴은 전통적인 싱글턴보다 직렬화 측면에서도 우수하다.
~~~java
public enum Elvis {
    INSTANCE;
    private String[] favoriteSongs = { "Hound Dog", "HeartBreak Hotel"};
    public void printFavorites() {
        System.out.println(Arrays.toString(favoriteSongs));
    }
}
~~~
이처럼 직렬화 가능한 인스턴스 통제 클래스를 열거 타입을 이용해 구현하면 선언한 상수 외의 다른 객체는 존재하지 않음을 자바가 보장해준다. 
하지만 열거 타입은 컴파일타임에 어떤 인스턴스들이 있는지 알 수 없는 상황이라면 열거 타입으로 표현하는 것이 불가능하며, 이때는 readResolve를 사용해야 한다. 

### readResolve 메서드의 접근성
1. final 클래스에서 readResolve 메서드는 private이어야 한다.
2. private으로 선언하면 하위 클래스에서 사용할 수 없다.
3. package-private으로 선언하면 같은 패키지에 속한 하위 클래스에서만 사용할 수 있다.
4. protected나 public으로 선언하면 이를 재정의하지 않은 모든 하위 클래스에서 사용할 수 있다. 
5. protected나 public이면서 하위 클래스에서 재정의하지 않았따면, 하위 클래스의 인스턴스를 역직렬화하면 상위 클래스의 인스턴스를 생성하여 ClassCaseException이 발생한다.


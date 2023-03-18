# clone 재정의는 주의해서 진행하라
 clone() 메서드는 객체를 복제하여 새로운 인스턴스를 생성하는 메서드이며 이를 오버라이딩 하기 위해서는 Cloneable을 상속해야 한다.
이상한 점은 clone 메서드가 cloneable이 아닌 Object에 정의되어 있고, 이 마저도 protected로 선언되어 있다. 
 메서드 하나 없는 Cloneable의 역할은 clone의 동작 방식을 결정한다. 즉, cloneable을 구현한 클래스의 인스턴스에서 clone을 호출하면 그 객체의 필드들을 하나하나 복사한
객체를 반환하며, 그렇지 않은 클래스의 인스턴스에서 호출하면 예외를 던진다. 

* 인터페이스를 구현한다는 것은 일밙거으로 해당 클래스가 그 인터페이스에서 정의한 기능을 제공한다고 선언하는 행위로 cloneable처럼 상위 클래스에 정의된 메서드의 동작 방식을 변경하는 것은 좋지 않다.
 
## clone 규약
1. x.clone() != x (true)
2. x.clone().getClass() == x.getClass()
3. x.clone().equals(x)

## 불변 객체의 clone 메서드
~~~java
@Override
public PhoneNumber clone() {
    try {
        return (PhoneNumber) super.clone();    
    } catch (CloneNotSupportedException e) {
        throw new AssertionError();    
    }
}
~~~
Object의 clone메서드는 Object를 반환하지만 여기서는 PhoneNumber처럼 구체화한 클래스를 리턴한다. (공변 반환 타이핑 - 권장 방법)
이렇게 구체 클래스를 반환하면 클라이언트가 형변환하지 않아도 된다. 

## 가변 객체의 clone 메서드
이 클래스를 clone 메서드를 이용하여 복제할 수 있도록 만들어보자. 
~~~java
public class Stack {
    private Object[] elements;
    private int size = 0;
    ...
}
~~~

만약 위와 동일하게 super.clone()결과를 그대로 반환하도록 한다면 elements 필드는 원본 Stack 인스턴스와 똑같은 배열을 참조하게 된다.
즉, 원본 인스턴스와 복제 인스턴스의 elements 변수는 같은 변수를 가리키게 된다. 이런 복사를 얕은 복사라고 한다.

clone은 원복 객체에 아무런 해를 끼치지 않는 동시에 복제된 객체의 불변식을 보장해야 한다. 이를 위해서는 elements 배열의 clone을 재귀적으로 호출해주는 것이다.
~~~java
@Override
public Stack clone() {
    try {
        Stack result = (Stack) super.clone();
        result.elements = elements.clone();
        return result;
    } catch (CloneNotSupportedException e) {
        throw new AssertionsError();    
    }
}
~~~

### 예외를 없애자
Object의 clone 메서드는 CloneNotSupportedxception을 던지지만 재정의한 메서드는 throws절을 없애는 것이 좋다.
그래야 그 메서드를 사용하기 편하다. 

### 스레드 세이프한 클래스 작성
멀티 쓰레드에서도 안전한 클래스를 만들기 위해서는 clone 메서드 역시 적절히 동기화해주어야 한다. 

## clone의 대체 방법
### 1. 복사 생성자
 자신과 같은 클래스의 인스턴스를 인수로 받는 생성자를 만든다. 

### 2. 복사 팩터리
 복사 생성자를 모방한 정적 팩터리를 만든다.

복제 기능은 생성자와 팩터리를 이용하는 것이 좋다. 단, 배열은 clone 메서드 방식이 가장 깔끔하다.

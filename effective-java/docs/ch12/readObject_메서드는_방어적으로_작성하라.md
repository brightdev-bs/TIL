# readObject 메서드는 방어적으로 작성하라

## readObject는 또 다른 생성자이다
readObject 메서드는 또 다른 public 생성자이다. 보통의 생성자처럼 readObject 메서드에서도 인수가 유효한지 검사해야 하고 필요하다면 매개변수를 방어적으로 복사해야 한다. 

readObject가 이 작업을 제대로 수행하지 못하면 공격자는 아주 손쉽게 해당 클래스의 불변식을 깨뜨릴 수 있다. 

### 객체의 유효성 검사
readObject 메서드가 defaultReadObject를 호출한 다음 역직렬화된 객체가 유효한지 검사하자. 이 유효성 검사에 실패하면 InvalidObjectException을 
던지게 하여 잘못된 역직렬화가 일어나는 것을 막을 수 있다.

~~~java
private void readObject(ObjectInputStream s) throw IOException, ClassNotFoundException {
    s.defaultReadObject();
    
    // 불변식을 만족하는지 검사한다.
    if(start.compareTo(end) > 0)
        throw new InvalidObjectException(start + " after " + end);
}
~~~

이 메서드에는 아직 악의적인 객체 참조를 읽어 객체 내부의 값을 수정할 수 있다.

### 객체의 방어적 복사
위의 코드로 불변식을 유지한 채 생성할 수는 있지만, 의도적으로 내부의 값을 수정할 수 있다. 이 인스턴스가 불변이라고 가정하는 클래스에 넘겨지면 엄청난 보안 문제를 일으킬 수 있다.

객체를 역직렬화할 때는 클라이언트가 소유해서는 안 되는 객체 참조를 갖는 필드를 모두 반드시 방어적으로 복사해야 한다.

~~~java
private void readObject(ObjectInputStream s) throw IOException, ClassNotFoundException {
    s.defaultReadObject();
    
    // 가변 요소들을 방어적으로 복사한다.
    start = new Date(start.getTime());
    end = new Date(end.getTime());
    
    // 불변식을 만족하는지 검사한다.
    if(start.compareTo(end) > 0)
        throw new InvalidObjectException(start + " after " + end);
}
~~~
참고로 final필드는 방어적 복사가 불가능하니 주의하자. readObject를 사용하기 위해서 final을 제거해야하지만 직렬화 공격 위험에 노출되는 것보다 낫다. 

## 기본 readObject 메서드를 써야 하는 경우
   transient 필드를 제외한 모든 필드의 값을 매개변수로 받아 유효성 검사 없이 필드에 대입하는 public생성자를 추가해도 괜찮은가? 의 답이 아니오라면 커스텀 readObject 메서드를 만들어
모든 유효성 검사와 방어적 복사를 수행하자. 

직접적이든 간접적이든, 재정의할 수 있는 메서드는 호출하지 말자.



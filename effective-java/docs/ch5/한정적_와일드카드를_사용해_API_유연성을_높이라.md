# 한정적 와일드카드를 사용해 API 유연성을 높이라
## 매개변수화 타입 = 불공변
 매개변수화 타입은 불공변이다. 즉, Type1과 Type2가 있을 때 List<Type1>는 List<Type2>의 하위 타입도 상위 타입도 아니다.
 예를 들어, List<String>은 List<Object>의 하위 타입이 아니다. 
 
하지만 때론 불공변 방식보다 유연한 방법이 필요할 수 있다. 

## 와일드 카드를 사용하지 않은 메서드의 결함
~~~java
public class Stack<E> {
    public Stack();
    public void push(E e);
    public E pop();
    public boolean isEmpty();
}

// 일련의 원소를 스택에 넣는 메서드 (생산자)
public void pushAll(Iterable<E> src) {
    for(E e : src) 
        push(e);
}

// 소비자
public void popAll(Collection<E> dst) {
    while (!isEmpty()) 
        dst.add(pop());
}
~~~
이 메서드는 컴파일은 잘 되지만 런타임 오류가 발생할 수 있다. 예를 들어 Stack<Number>로 선언한 후 pushAll(intVal)을 호출해보자.
Integer는 Number의 하위 타입이니 잘 동작해야할 것 같다. 하지만 실제로는 불공변 타입이기 때문에 오류 메세지가 뜬다. <br>
`Iterable<Integer> cannot be converted to Iterable<Number> `

## 한정적 와일드카드 타입 
자바는 이러한 상황을 해결하기 위해 한정적 와일드카드 타입이라는 특별한 매개변수화 타입을 지원한다. 
~~~java
public void pushAll(Iterable<? Extends E> src) {
    for(E e : src) 
        push(e)
}

public void popAll(Collection<? super E> src) {
    while (!isEmpty())
        dst.add(pop());
}
~~~

즉 유연성을 극대화하려면 원소의 생산자나 소비자용 입력 매개변수에 와일드카드 타입을 사용하라. 
하지만, 입력 매개변수가 생산자와 소비자 역할등 동시에 한다면 와일드 카드 타입을 안쓰는게 났다.
 > 펙스(PESC) : producer-extends, consumer-super


## 재귀적 타입 한정의 와일드 카드
재귀적 타입에서 와일드 카드를 쓰는 것은 복잡하지만 그만한 가치가 있다. 
~~~java
public class RecursiveTypeBound {
    public static<E extends Comparable<? super E>> E max(List<? extends E> list) {}
}
~~~

예를 들어 다음과 같이 상위 클래스에서 Comparable을 구현하고 다른 클래스에서는 이를 상속한고 해보자.
~~~java
public interface Comparable<E>
public interface Delayed extends Comparable<Delayed>
public interface ScheduledFuture<V> extends Delayed, Future<V>
~~~

만약 여기서 와일드 카드를 사용하지 않는다면 다음 코드는 동작하지 않는다.
~~~java
List<ScheduledFuture<?>> scheduledFutures = ...;
~~~

### comparable과 comparator
comparable과 comparator는 언제나 소비자이므로 와일드 카드를 사용하는 것이 좋다.
~~~java
Comparable<? super E>
Comparator<? super E>
~~~

## 타입 매개변수와 와일드카드 
타입 매개변수와 와일드카드는 공통되는 부분이 있어서, 메서드를 정의할 때 어느 것을 사용해도 괜찮을 때가 많다. 
~~~java
<E> : 특정할 수 있는 타입 
<?> : 특정할 수 없는 임의의 타입
~~~

다음과 같이 <?>만 쓰는 경우에는 타입 추론 능력이 제한된다. 
~~~java
public static void swap(List<?> list, int i, int j) {
    list.set(i, list.set(j, list.get(i)))
}
~~~

다음 코드는 ist.get(i)에서 오류가 난다. 꺼내기만 하는 경우에는 상관 없지만, 뭔가를 넣는다면 helper클래스를 재정의해야 한다.
~~~java
private static <E> void swapHelper(List<E> list, int i, int j) {
    list.set(i, list.set(j, list.get(i)));    
}
~~~

이런 경우에는 차라리 <E>를 쓰는 것이 더 좋은 것 같다.
~~~java
public static void <E> void swap(List<E> list, int i, int j) {
    list.set(i, list.set(j, list.get(i)))
}
~~~
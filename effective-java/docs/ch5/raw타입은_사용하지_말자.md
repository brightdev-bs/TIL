# raw 타입은 사용하지 말자
## 제네릭 클래스/인터페이스
   클래스와 인터페이스 선언에 타입 매개변수가 쓰이면 제네릭 클래스 혹은 제네릭 인터페이스라 한다.   
   제네릭 타입은 일련의 매개변수화 타입을 정의한다. => **List<String>**
   
### raw 타입
   제네릭 타입에서 타입 매개변수를 전혀 사용하지 않을 때를 말하며 List<String>에서 List가 raw 타입이다.
   
다음과 같이 raw타입으로 변수를 선언할 수 있다.
~~~java
private final Collection stamps = ...; 
~~~

하지만 이 코드를 사용하면 stamp대신 coin을 넣어도 아무 오류 없이 컴파일되고 실행된다. 이 에러가 발견되는 시점은 다음과 같이 
이 동전을 꺼낼 때이다.
~~~java
Stamp stamp = (Stamp) stamps.get(0); 
~~~

하지만 제네릭을 활용하면 이 정보가 주석이 아닌 타입 선언 자체에 녹아들기 때문에 더 안전한 프로그래밍이 가능해진다.
이런 raw타입은 하위 호환성 때문에 존재한다.

다음과 같이 List<Object> 처럼 임의 객체를 허용하는 매개변수화 타입은 괜찮다. <br> 
 -> 모든 타입을 허용한다는 의사를 컴파일러에게 명확히 전달한다.

### 비한정적 와일드카드 타입 (Unbounded wildcard type)
원소의 타입을 몰라도 되는 raw 타입을 쓰고 싶어질 수 있다. 
~~~java
static int numElementsInCommon(Set s1, Set s2) {
    int result = 0;
    for (Object o1 : s1) {
        if(s2.contains(o1))
            result++;
    return result;
~~~

이런 경우에는 동작은 하지만 타입 불변식을 훼손하기 쉽다. 이처럼 제네릭 타입을 쓰고 싶지만 실제 타입 매개변수가 무엇인지 신경 쓰고 싶지 않다면 물음표를 사용하자.
~~~java
static int numElementsInCommon(Set<?> s1, Set<?> s2) { ... }
~~~

### instanceof 연산자와 제네릭
런타임에는 제네릭 타입 정보가 지워지므로 instanceof 연산자는 비한정적 와일드카드 타입 이외의 매개변수화 타입에는 적용할 수 없다. 
또 raw 타입과 비한정적 와일드카드타입의 instanceof는 완전히 똑같이 동작한다. 따라서 제네릵 타입에 instanceof를 사용하는 경우에는 제네릭을 붙이지 않는 것이 깔끔하다. 
~~~java
if (o instanceof Set) {
    Set<?> s = (Set<?>) o;
}
~~~

o의 타입이 Set임을 확인한 다음 와일드카드 타입인 Set<?>로 형변환해야 한다. (컴파일러 경고가 안되기 때문)



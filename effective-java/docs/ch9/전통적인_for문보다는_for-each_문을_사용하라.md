# 전통적인 for 문보다는 for-each 문을 사용하라

## 전통적인 for 문을 이용한 컬렉션 순회
~~~java
for(Iterator<Element> i = c.iterator(); i.hasNext(); ) {
    Element e = i.next();    
}

for (int i = 0; i < n; i++) {
        ...// do sth with a[i]  
}
~~~

이러한 for문은 while 문 보다는 낫지만 가장 좋은 방법은 아니다. 
1. 박복자와 인덱스 변수는 모두 코드를 지저분하게 할 뿐 우리에게 진짜 필요한 건 원소들 뿐이다.
2. 잘못된 변수를 사용했을 때 컴파일러가 잡아주기 힘들다
3. 컬렉션이나 배열이냐에 따라 코드 형태가 달라진다.

### 중첩 for문의 찾기 어려운 버그
~~~java
enum Suit { CLUB, DIAMOND, HEART, SPADE }
enum Rank { ACE, DEUCE, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, JACK, QUEEN, KING }

static Collection<Suit> suits = Arrays.asList(Suit.values());
static Collection<Rank> ranks = Arrays.asList(Rank.values());
    
for (Iterator<Suit> i = suits.iterator(); i.hasNext(); )
    for (Iterator<Rank> j = ranks.iterator(); j.hasNext(); )
        deck.add(new Card(i.next(), j.next()));
~~~
이 for문의 문제는 첫 번째 for문에서 next()가 너무 많이 호출된다는 문제가 있다. 만약 Suit의 원소가 rank의 원소보다 적다면 NoSuchElementException을 던질 것이고
반대의 경우라면 예외를 던지지 않고 예상치 못한 결과와 함께 종료된다. 

이러한 문제를 해결하기 위해 바깥 반복문에 원소를 저장하는 변수를 하나 추가해야한다.
~~~java
for (Iterator<Suit> i = suits.iterator(); i.hasNext(); )
    Suit suit = i.next();
    for (Iterator<Rank> j = ranks.iterator(); j.hasNext(); )
        deck.add(new Card(suit, j.next()));
~~~

이러한 불편함을 해결하기 위해 등장한 것이 for-each 문이다. 

## for-each문
~~~java
for (Element e : elements) {
        ... // e로 뭔가 한다.    
}
~~~
1. 반복자와 인덱스 변수를 사용하지 않아 코드가 깔끔하고, 오류의 여지가 사라진다.
2. 하나의 관용구로 컬렉션과 배열을 동일하게 처리할 수 있다. 

### 중첩 반복을 위한 권장 관용구
~~~java
for(Suit suit : suits) 
    for(Rank rank : ranks)
        deck.add(new Card(suit, rank));
~~~

### for-each문을 사용할 수 없는 세 가지 상황
1. 파괴적인 필터링 : 컬렉션을 순회하면서 선택된 원소를 제거해야 한다면 반복자의 remove 메서드를 호출해야 한다. 
2. 변형 : 리스트나 배열을 순회하면서 그 원소의 값 일부 혹은 전체를 교체해야 한다면 반복자나 배열의 인덱스를 사용해야 한다.
3. 병렬 반복 : 여러 컬렉션을 병렬로 순회해야 한다면 각각의 반복자와 인덱스 변수를 사용해 엄격하고 명시적으로 제어해야 한다. 


for-each문은 컬렉션과 배열은 물론 Iterable 인터페이스를 구현한 객체라면 무엇이든 순회할 수 있다. Iterable을 처음부터 직접 구현하는 것은 어렵지만, 원소들의 묶음을 표현하는 타입을 작성해야 한다면
iterable을 구현하는 쪽으로 고민해보자.


# null이 아닌, 빈 컬렉션이나 배열을 반환하라
## 컬렉션이 비었으면 null을 반환하는 코드
~~~java
public List<Cheese> getCheeses() {
    return cheesesInStock.isEmpty() ? null : new ArrayList<>(cheeseInStock);
}
~~~

사실 재고가 없다고 해서 특별히 취급할 이유는 없다. 그럼에도 이 코드처럼 null을 반환한다면 클라이언트는 이 null 상황을 처리하는 코드를 추가로 작성해야 한다. 

## null을 반환하면 안되는 이유 
1. 성능 분석 결과 빈 컬렉션의 할당이 성능 저하의 주범이라고 확인되지 않는 한 이 정도의 성능 차이는 신경 쓸 수준이 못 된다.
2. 빈 컬렉션과 배열은 굳이 새로 할당하지 않고도 반환할 수 있다. 

빈 컬렉션을 반환하는 올바른 예 
~~~java
public List<Cheese> getCheeses() {
    return new ArrayList<>(cheesesInStock);    
}
~~~

### 빈 컬렉션 할당이 성능을 떨어뜨릴 경우
   매번 똑같은 빈 '불변' 컬렉션을 반환하면 된다. 불변 객체는 자우롭게 공유해도 안전하다. 
 >Collections.emptyList, Collections.emptySet, Collections.emptty

## 배열을 쓸 때도 길이가 0인 배열을 반환하자.
~~~java
public Chesse[] getCheeses() {
    return cheesesInStock.toArray(new Cheese[0]);    
}
~~~

이 방식이 성능을 떨어뜨릴 것 같다면 길이 0짜리 배열을 미리 선언해두고 매번 그 배열을 반환하면 된다. 길이 0인 배열은 모두 불변이다. 
~~~java
private static final Cheese[] EMPTY_CHEESE_ARRAY = new Cheese[0];

public Cheese[] getCheeses() {
    return cheesesInStock.toArrayy(EMPTY_CHEESE_ARRAY);    
}
~~~

단순히 성능을 개선할 목적이라면 toArray에 넘기는 배열을 미리 할당하는 건 추천하지 않는다. 오히려 성능이 떨어진다는 연구 결과가 있다. 



# 정확한 답이 필요하다면 float와 double은 피하라
## 부정확한 계산
float와 double 타입은 과학과 공학 계산용으로 설계되었다. 이진 부동소수점 연산에 쓰이며, 넓은 범위의 수를 빠르게 정밀한 '근사치'로 계산하도록 설계되었다. 

예를 들어 1.03달러에서 42센트를 썻을 때 남은 금액을 표현해보자.

~~~java
System.out.println(1.03 - 0.42) 
~~~

이 코드는 0.61000000000001을 출력한다. 


## 정확한 계산
이런 문제를 올바로 해결하려면 BigDecimal, int혹은 long을 사용해야 한다. 특히 금융권에서는 이 float와 double은 사용하지 말자.

### BigDecimal 
   앞의 코드를 double이 아닌 BigDecimal을 사용하면 문제가 해결된다.
하지만 기본 타입보다 쓰기 훨씬 불편하고 느리다는 단점이 있다.

BigDecimal의 대안으로 int 혹은 long타입을 쓸 수 있지만, 다룰 수 있는 값의 크기가 제한되고, 소수점을 직접 관리해야 한다. 위와 같은 예제에서는 달러 대신 센트로 수행하면 이 문제가 해결된다.

~~~java
public static void main(String[]args){
    int itemsBought = 0;
    int funds = 100;
    for (int price = 10; funds >= price; price += 10) {
        funds -= price;
        itemsBought++;
    }
}
~~~

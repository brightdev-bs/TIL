# equals를 재정의하려거든 hashcode도 재정의하라
## hashcode 규약
1. equals 비교에 사용되는 정보가 변경되지 않았다면 hashcode는 항상 같은 값을 리턴해야 한다. 
2. 두 객체에 대한 equals가 같다면, hashcode의 값도 같아야 한다. 
3. 두 객체의 equals가 다르더라도, 같은 hashcode값을 가질 수 있다. 더 좋은 성능을 위해 다른 값을 리턴하는 것이 더 좋기는 하다.

다음 예제를 통해 왜 hashcode를 같이 정의해야 하는지 이해해보자. phoneNumber에는 equlas규약에 맞춰 메소드가 잘 정의되어있다고 가정하자.
~~~java
public class HashMapTest {
    public static void main(String[] args) {
        Map<PhoneNumber, String> map = new HashMap<>();
        PhoneNumber number1 = new PhoneNumber(123, 456, 789);
        PhoneNumber number2 = new PhoneNumber(123, 456, 789);
        
        System.out.println(number1.equals(number2));
        System.out.println(number1.hashCode());
        System.out.println(number2.hashCode());
        
        map.put(number1, "mango");
        map.put(number2, "vanille");
        
        System.out.println(map.get(number2)); // => vanille 정상 출력
        System.out.println(map.get(new PhoneNumber(123, 456, 789))); // => null 출력 
        
    }
}
~~~

마지막의 출력을 확인해보면 같은 값을 넘김에도 불구하고 number2는 정상 출력을 하고 new PhoneNumber(123,456,789)는 null을 출력한다.
이를 위해 hashcode가 어떻게 동작하는지를 이해해야 한다.

<img src="../../../images/datastructure/해시테이블.png" width="300"> <br>
맵에 넣을 때 hashcode를 구해서 해시에 해당하는 버킷에 값을 저장하고 값을 찾을 때도 hashcode를 기준으로 버킷에 접근해서 이를 가져온다. 
따라서 같은 객체라면 반드시 같은 해시코드를 반환해야 한다.

하지만 다른 객체인데 어떻게 hashcode가 같은 값이 나오는 경우도 있다. 이를 해시 충돌이라고 한다. 해시함수의 충돌을 해결하는 방법은 두 가지가 있다. <br>
1. 체이닝 <br>
-> 충돌이 일어나면 버킷 내에서 연결리스트로 데이터들을 연결하는 방식이다. -> 해시 테이블이 채워질수록 성능 저하가 선형적으로 발생한다.
2. 개방 주소법 <br>
-> 다른 버킷에 데이터를 삽입하는 방식 -> 삽입 삭제시 오버헤드가 적다.

## 해시코드를 구현하는 방법
1. 핵심 필드의 해시코드 값을 구한다. <br>
 => `int result = Integer.hashCode("핵심필드1");`

2. 그 다음 필드 부터는 31을 곱한 뒤 더하는 형식으로 해시코드를 구한다. <br>
 => `31 * result + Integer.hashCode("핵심필드2");`

왜 31을 곱할까? <br>
=> 짝수를 쓰면 0이 채워지면서 많은 랜덤 숫자를 만들기 어려워진다. <br>
=> 31을 썻을 때 해시충돌이 적었다는 연구 결과가 있어 31을 쓴다. 

### 해시 캐싱
만약 객체가 불변객체이고 해시코드를 구하는데 많은 비용이 든다면 캐싱을 고려해볼 수 있다.
~~~java
private int hashCode;
@Override
public int hashcode() {
    int result = hashCode;
    if (result == 0) {
        result = Integer.hashCode("핵심필드1");
        result = 31 * result + Integer.hashCode("핵심필드2");
        hashCode = result;
    }
    return result;
}
~~~

이렇게 되면 쓰레드 세이프 하지 않게된다.(불변 객체는 상관없음) 이를 해결하는 가장 간단한 방법은 synchronized를 이용하는 것이다.
~~~java
public int synchronized hashCode() {}
~~~

이렇게 작성하면 이 메서드에는 한 쓰레드만 접근할 수 있으므로 성능이 느려진다. 따라서 더블 체킹 락을 이용할 수 잇따.
~~~java
// 데이터를 보통 캐시에 저장하는데, 캐시에서 데이터를 가져오게 되면 업데이트 되었는데도 이전 데이터를 가져올 수 있음.
private volatile int hashCode; // 메인메모리에서 데이터를 저장하고 가져온다.   

if(this.hashCode != 0) {
    return hashCode;
}
    synchronized (this){
        int result = hashCode;
        if (result == 0) {
           result = Integer.hashCode("핵심필드1");
           result = 31 * result + Integer.hashCode("핵심필드2");
           hashCode = result;
        }
    }
}
return result;
~~~

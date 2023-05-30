# int 상수 대신 열거 타입을 사용하라

   
## 정수 열거 패턴
   정수 상수를 한 묶음 선언해서 사용하는 패턴

~~~java
public static final int APPLE_FUJI = 0;
public static final int APPLE_PIPPIN = 1;
public static final int APPLE_GRANNY_SMITH = 2;

public static final int ORANGE_NAVEL = 0;
public static final int ORANGE_TEMPLE = 1;
public static final int ORANGE_BLOOD = 2;
~~~

정수 열거 패턴에는 다음과 같은 문제가 있다.
### 1. 타입 안전을 보장할 방법이 없다.

~~~java
public class IntegerEnumeration {

    public static void makeSauce(int orange) {
        if (ORANGE_NAVEL == 0) {
            System.out.println("ORANGE_NAVEL입니다.");
        } else if (ORANGE_TEMPLE == 1) {
            System.out.println("ORAGNE_TEMPLE입니다.");
        } else if (ORANGE_BLOOD == 2) {
            System.out.println("ORANGE_BLOOD");
        }
    }

    public static void main(String[] args) {
        makeSauce(APPLE_FUJI);
    }
}
~~~

### 2. 표현력이 좋지 않다.

~~~text
자바가 정수 열거 패턴을 위한 별도 이름공간을 지원하지 않기 때문에 접두어를 써서 이름 충돌을 방지한다.
e.g 영어로는 둘 다 mercury인 수은과 수성의 이름을 ELEMENT_MERCURY, PLANET_MERCURY로 접두어를 붙여 구분한다.
~~~

### 3. 정수 상수는 사용이 까다롭다.

~~~java
값을 출력하거나 디버거로 살펴보면 단지 숫자로만 보이기 때문에 도움이 되지 않는다. 즉, 문자열로 출력하기 힘들다. 
또한 정수 열거 그룹에 속한 모든 상수를 한 바퀴 순회하기 쉽지 않다.
~~~

## 열거 타입
   일정 개수의 상수 값을 정의한 다음, 그 외의 값은 허용하지 않는 타입이다. 
   열거 타입은 클래스이며, 상수 하나당 자신의 인스턴스를 하나씩 만들어 public static final 필드로 공개한다. 
   열거 타입은 밖에서 접근할 수 있는 생성자를 제공하지 않아 직접 생성하거나 확장 할 수 없어 싱글톤으로 존재한다.
   열거 타입은 다음과 같은 장점이 있다.

### 1. 컴파일타임 타입 안정성을 제공한다.
다음과 같이 사과와 관련된 상수 값만 인자로 넘길 수 있다.

<img src="/images/ch6/compile_time_check.png">

### 2. 열거 타입에는 임의의 메서드나 필드를 추가할 수 있고 임의의 인터페이스를 구현하게 할 수도 있다.
예를 들어 사과 종류마다 각기 다른 가격을 가진다고 해보자. 열거 타입을 이용하면 다음과 같이 인스턴스 필드와 메서드를 가질 수 있따.

~~~java
public enum Apple {
    FUJI(5000),
    PIPPIN(3000),
    GRANNY_SMITH(1000);

    private final int price;

    Apple(int price) {
        this.price = price;
    }
    
    public int getPrice() { return price; }
}
~~~

이런 표현은 다음과 같이 모든 Apple의 가격을 쉽게 조회할 수 있게 해준다. 열거 타입은 자신 안에 정의된 상수들의 값을 배열에 담아 반환하는 정적 메서드인 values를 제공한다.

~~~java
for (Apple apple : Apple.values()) {
    System.out.println(apple.name() + " : " + apple.getPrice());
}
~~~

### 유연성과 안정성의 제공
이번엔 FUJI사과가 잘 안 팔려서 팔지 않기로 했다고 해보자.

~~~java
public enum Apple {
    PIPPIN(3000),
    GRANNY_SMITH(1000);
    ...
}
~~~

이렇게 되면 FUJI를 사용하지 않는 클라이언트에는 아무런 영향이 없다. 제거된 상수를 사용하는 클라이언트들은 다시 컴파일하면 컴파일 타임에 오류가 발생하며, 다시 컴파일하지 않으면
런타임에 같은 예외가 발생할 것이다. 

### 상수별로 다르게 동작하는 코드를 구현할 수 있다.
~~~java
public enum Operation {
    
    PLUS { public double apply(double x, double y) {return x + y;}},
    MINUS { public double apply(double x, double y) { return x - y; }},
    TIMES { public double apply(double x, double y) { return x * y; }},
    DIVIDE { public double apply(double x, double y) { return x / y; }},
    
    public abstract double apply(double x, double y);
}
~~~
1. apply 메서드가 추상 메서드이므로 재정의하지 않았다면 컴파일 오류로 알려준다.
2. apply 메서드가 상수 선언 바로 옆에 붙어 있으니 새로운 상수를 추가할 대 apply도 재정의해야 한다는 사실을 깜빡하기 힘들다.

#### toString을 재정의해 해당 연사자의 기호를 반환할 수 있다.

~~~java
public enum Operation {

    PLUS("+") { public double apply(double x, double y) {return x + y;}},
    MINUS("-") { public double apply(double x, double y) { return x - y; }},
    TIMES("*") { public double apply(double x, double y) { return x * y; }},
    DIVIDE("/") { public double apply(double x, double y) { return x / y; }},
    
    private final String symbol;
    
    Operation(String symbol) { this.symbol = symbol; }
    @Override public String toString() { return symbol; }
    public abstract double apply(double x, double y);
}

~~~

### 전략 열거 타입
주중과 주말에 대한 잔업 수당 계산과 같이 열거 타입 상수 일부가 같은 동작을 공유한다면 전략 열거 타입 패턴을 사용할 수 있다.

~~~java
enum PayrollDay {
    MONDAY(WEEKDAY), TUESDAY(WEEKDAY), WEDNESDAY(WEEKDAY), THURSDAY(WEEKDAY), FRIDAY(WEEKDAY), SATURDAY(PayType.WEEKEND), SUNDAY(PayType.WEEKEND);

    private final PayType payType;

    PayrollDay(PayType payType) {
        this.payType = payType;
    }

    int pay(int minutesWorked, int payRate) {
        return payType.pay(minutesWorked, payRate);
    }

    enum PayType {
        WEEKDAY {
            int overtimePay(int minsWorked, int payRate){
                return minsWorked <= MINS_PER_SHIFT ? 0 : (minsWorked - MINS_PER_SHIFT) * payRate / 2;
            }
        },
        WEEKEND {
            int overtimePay(int minsWorked, int payRate){
                return minsWorked * payRate / 2;
            }
        };

        abstract int overtimePay(int minsWorked, int payRate);
        private static final int MINS_PER_SHIFT = 8 * 60;

        public int pay(int minsWorked, int payRate){
            int basePay = minsWorked * payRate;
            return basePay + overtimePay(minsWorked, payRate);
        }
    }

}
~~~


## 정리 
 > 필요한 원소를 컴파일타임에 다 알 수 있는 상수 집합이라면 항상 열거 타입을 사용하자. 

   

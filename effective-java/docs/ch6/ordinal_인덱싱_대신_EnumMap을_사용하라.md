# ordinal 인덱싱 대신 EnumMap을 사용하라

## ordinal의 잘못된 사용
이따금 배열이나 리스트에서 원소를 꺼낼 때 ordinal 메서드로 인덱스를 얻는 코드가 있다. 

~~~java
public class Plant {
    enum LifeCycle { ANNUAL, PERENNIAL, BIENNIAL }

    final String name;
    final LifeCycle lifeCycle;

    public Plant(String name, LifeCycle lifeCycle) {
        this.name = name;
        this.lifeCycle = lifeCycle;
    }

    @Override public String toString() {
        return name;
    }
}

public class Client {
    public static void main(String[] args) {
        Set<Plant>[] plantsByLifeCycle = (Set<Plant>[]) new Set[Plant.LifeCycle.values().length];
        for(int i = 0; i < LifeCycle.values().length; i++) {
            plantsByLifeCycle[i] = new HashSet<>();
        }
        for(Plant p : garden) {
            plantsByLifeCycle[p.lifeCycle.ordinal()].add(p);
        }
        
        for(int i = 0; i < plantsByLifeCycle.length; i++) {
            System.out.printf("%s: %s%n", Plant.LifeCyCle.values()[i], plantsByLifeCycle[i]); 
        }
    }
}
~~~

동작은 하지만 다음과 같은 문제가 있다.
1. 배열과 제네릭은 호환되기 어렵다.
 - 배열은 공변타입으로 타입 검사를 매번 실시하지만, 제네릭은 비공변타입으로 컴파일시에만 검사하며 런타임시에는 타입 자체를 모른다.

2. 배열은 인덱스의 의미를 알 수 없으므로 출력 결과에 직접 레이블을 달아야 한다.

3. 정확한 정숫값을 사용한다는 것을 보증해야 한다. 
 -> ArrayIndexOutOfBoundsException이 발생하거나 알 수 없는 잘못된 동작을 할 수 있다. 

## EnumMap
   위에서 배열은 실질적으로 열거 타입 상수를 값으로 매핑하는 일을 한다. 그래서 Map을 사용할 수 있는데, 자바에서는 열거 타입을 키로 사용하도록 설계한
아주 빠른 Map 구현체를 EnumMap이라고 한다.
~~~java
Map<Plant.LifeCycle, Set<Plant>> plantByLifeCycle = new EnumMap<>(Plant.LifeCycle.clss);
for(Plant.LifeCycle lc : Plant.LifeCycle.values()) 
    plantsByLifeCycle.put(lc, new HashSet<>());
for(Plant p : garden) 
    plantByLifeCycle.get(p.lifeCycle).add(p);
System.out.println(plantsByLifeCycle);
~~~

1. 안전하지 않은 형변환 코드가 없어졌다.
 >  Set<Plant>[] plantsByLifeCycle = (Set<Plant>[]) new Set[Plant.LifeCycle.values().length];

2. 맵의 키인 열거 타입이 그 자체로 출력용 문자열을 제공한다. 
3. 배열 인덱스를 계산하는 과정에서 오류가 날 가능성이 없다.
 > plantsByLifeCycle[p.lifeCycle.ordinal()].add(p);


EnumMap은 내부에서 배열을 사용하기 때문에 속도가 빠르며, 내부 구현 방식이 안으로 숨겨져 있기 때문에 타입 안정성도 있다.

### EnumMap과 Stream
이 코드는 EnumMap이 아닌 고유한 맵 구현체를 사용했기 때문에 EnumMap을 써서 얻은 공간과 성능 이점이 사라진다.
~~~java
System.out.println(Arrays.stream(garden).collect(GroupingBy(p -> p.lifeCycle)));
~~~

이를 해결하기 위해 mapFactory 매개변수에 원하는 맵 구현체를 명시해 호출할 수 있다.
~~~java
System.out.println(Arrays.stream(garden)
        .collect(groupingBy(p -> p.lifeCycle,
                () -> new EnumMap<>(LifeCycle.class), toSet())));
~~~

### 다차원 관계는 EnumMap<..., EnumMap<...>>을 이용하자
~~~java
public enum Phase {
    SOLID, LIQUID, GAS;

    public enum Transition {
        MELT(SOLID, LIQUID), FREEZE(LIQUID, SOLID),
        BOIL(LIQUID, GAS), CONDENSE(GAS, LIQUID),
        SUBLIME(SOLID, GAS), DEPOSIT(GAS, SOLID);

        private final Phase from;
        private final Phase to;

        Transition(Phase from, Phase to) {
            this.from = from;
            this.to = to;
        }

        private static final Map<Phase, Map<Phase, Transition>> m
                = Stream.of(values()).collect(
                        groupingBy(
                                t -> t.from,
                                () -> new EnumMap<>(Phase.class),
                                toMap(t -> t.to, t -> t, (x,y) -> y, () -> new EnumMap<>(Phase.class)))
        );
    }
}
~~~

## 정리
 > 배열의 인덱스를 얻기 위해 ordinal을 쓰지 말고 EnumMap을 사용하자.
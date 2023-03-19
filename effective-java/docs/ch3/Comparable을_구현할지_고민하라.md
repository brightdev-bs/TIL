# Comparable을 구현할지 고려하라
Comparable을 구현한다는 것은 그 클래스의 인스턴스들에 자연적인 순서를 부여하는 것이다. 알파벳, 숫자, 연대 같이 순서가 명확한 값 클래스를 작성할 때는 Comparable
인터페이스를 구현하는 것이 좋다. 

## Comparable 규약
~~~java
BigDecimal n1 = BigDecimal.valueOf(12312312);
BigDecimal n2 = BigDecimal.valueOf(22212322);
BigDecimal n3 = BigDecimal.valueOf(12312312);
BigDecimal n4 = BigDecimal.valueOf(22212322);

// 1. 반사성
n1.compareTo(n1) => true

// 2. 대칭성
n1.compareTo(n2) => -1
n2.compareTo(n1) => 1

// 3. 추이성
n1.compareTo(n2) > 0
n2.compareTo(n3) > 0 
=> n1.compareTo(n3) > 0

// 4. 권장사항
compareTo가 0을 리턴하면 equals는 true이여야 한다. (필수 아님)
 => 같지 않다면 문서화를 해주는 것이 좋다.
BigDecimal n1 = new BigDecimal("1.0");
BigDecimal n2 = new BigDecimal("1.00");
System.out.println(n1.compareTo(n2)); // 0출력 => treeset, hashset을 이용하면 원소가 하나만 들어간다.
System.out.println(n1.equals(n2));
~~~

## Comparable을 구현하는 방법
1. 클래스의 핵심 필드가 여러 개라면 가장 핵심적인 필드부터 비교한다.
~~~java
public class Point implements Comparable<Point> {

    int x, y, z;

    public Point(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    @Override
    public int compareTo(Point o) {
        int result = this.x - o.x;        // 가장 중요한 필드
        if(result == 0) {
            result = this.y - o.y;        // 두 번째로 중요한 필드
            if(result == 0) {
                result = this.z - o.z;    // 세 번째로 중요한 필드 
            }
        }
        return result;
    }
}
~~~

2. Comparable을 구현한 클래스를 확장하는 경우 
Comparable 인터페이스를 한 번더 상속하거나 compareTo의 Point 파라미터 타입을 변경할 수 없기 때문에 compareTo규약을 지킬 수 없다. 
~~~java
public class NamedPoint extends Point {
    
    String name;

    public NamedPoint(int x, int y, int z, String name) {
        super(x, y, z);
        this.name = name;
    }

    @Override
    public int compareTo(Point o) { // 파라미터 타입 변경 불가능
        return super.compareTo(o);
    }
}
~~~

이런 경우에는 Collection을 생성할 때 정렬 순서를 정할 수 있는 Comparator를 정의해주면 된다.
~~~java
TreeSet<NamedPoint> points = new TreeSet<>(new Comparator<NamedPoint>() {
    @Override
    public int compare(NamedPoint o1, NamedPoint o2) {
        int result = Integer.compare(o1.getX(), o2.getX());
        if(result == 0) {
            result = Integer.compare(o1.getY(), o2.getY());
            if(result == 0) {
                result = Integer.compare(o1.getZ(), o2.getZ());
            }
        }
        if(result == 0) {
            result = o1.name.compareTo(o2.name);
        }
        return result;
    }
});
~~~

또다른 방법으로 Composition을 사용할 수 있따. 상속 대신 독립된 클래스를 만들고, 이 클래스에 원래 클래스의 인스턴스를 가리키는 필드를 두면 된다.
~~~java
public class NamedCompositionPoint implements Comparable<NamedPoint> {
    
    private final Point point;
    private final String name;

    public NamedCompositionPoint(Point point, String name) {
        this.point = point;
        this.name = name;
    }
     
    // 뷰를 제공해준다.
    public Point getPoint() {
        return this.point;
    }

    @Override
    public int compareTo(NamedPoint o) {
        int result = this.point.compareTo(namedPoint.point);
        if(result == 0) {
            result = this.name.compareTo(namedPoint.name);
        }
        return result;
    }
}
~~~

## Comparator의 등장
자바8 이후 Comparator의 등장으로 일련의 비교자 생성 메서드와 팀을 꾸려 메서드 연쇄 방식으로 비교자를 생성할 수 있게 되었다.

1. Comparator에 정의된 정적 메서드를 사용하여 COMPARATOR를 생성한다.
~~~java
public int compareTo(PhoneNumber pn) {
    return COMPARATOR.compare(this, pn);    
}
~~~

2. 메서드 연쇄 방식을 이용해 비교
~~~java
private static final Comparator<PhoneNumber> COMPARATOR = 
        comparingInt((PhoneNumber pn) -> pn.areaCode)
            .thenComparingInt(pn -> pn.prefix)
            .thenComparingInt(pn -> pn.lineNum);
~~~

이 방식은 코드를 읽기 더 편하다는 장점이 있지만, 성능이 조금 느려지는 단점이 있다. 

### 주의 
'값의 차'를 기준으로 하는 비교자는 추이성을 위배할 수 있기 때문에 주의해야 한다.
~~~java
static Comparator<Object> hashCodeOrder = new Comparator<>() {
    public int compare(Object o1, Object o2) {
        return o1.hashCode() - o2.hashCode();    
    }    
}
~~~
이 방식은 정수 오버플로를 일으키거나 부동소수점 계산 방식에 따른 오류가 날 수 있다. 
다음 방식을 이용하자.
~~~java
// 방식 1
static Comparator<Object> hashCodeOrder = new Comparator<>() {
    public int compare(Object o1, Object o2) {
        return Integer.compare(o1.hashCode(), o2.hashCode());
    }
}

// 방식 2
static Comparator<Object> hashCodeOrder
        = Comparator.comparingInt(o -> o.hashCode());
}
~~~
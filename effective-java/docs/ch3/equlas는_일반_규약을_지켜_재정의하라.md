# equals는 일반 규약을 지켜 재정의하라 
## equals의 재정의가 필요 없는 경우
다음과 같은 상황에서는 equals 메서드의 재정의가 필요하지 않다.
1. 각 인스턴스가 본질적으로 고유하다. <br>
 => Thread와 같이 값을 표현하는 것이 아니라 동작하는 개체를 표현하는 클래스가 해당된다.
2. 인스턴스의 논리적 동치성을 검사할 일이 없다. <br>
3. 상위 클래스에서 재정의한 equals가 하위 클래스에도 딱 들어맞는다. 
4. 클래스가 private이거나 package-private이고 equals 메서드를 호출할 일이 없다. 다음과 같이 equals가 실수로 호출되는 것을 막을 수 있다. 

~~~java
@Override
public boolean equals(Object o) {
    throw new AssertionsError();
}
~~~

## equlas를 재정의해야 하는 경우 
1. 논리적 동치성 확인이 필요한 경우 <br>
 => 주로 값 클래스들이 여기 해당한다. 값 클래스란 Integer와 String처럼 값을 표현하는 클래스를 말한다. 이런 객체는 객체가 같읕지가 아니라 값이 같은지를 알고 싶어한다.
따라서 equlas 재정의가 필요하다. 이렇게 하면 Map의 키와 Set의 원소로도 사용할 수 있게 된다. <br> 
 => 값 클래스라 해도, 값이 같은 인스턴스가 둘 이상 만들어지지 않음을 보장하는 인스턴스 통제 클래스라면 equals 재정의는 필요 없다. (e.g Enum)

## equals는 규약을 지켜 재정의해야 한다.
### 1. 반사성
x.equals(x), 즉 객체는 자기 자신과 같아야 한다.

### 2. 대칭성
x.equals(y) == y.equals(x), 즉 결과가 같아야 한다. 다른 타입을 비교하는 순간 대칭성이 깨지게 된다.

~~~java
public final class CaseInsensitiveString{
    private final String s;
    
    public CaseInsensitiveString(String s) {
        this.s = Objects.requireNonNull(s);
    }
    
    @Override
    public boolean equals(Object o) {
        if(o instanceof CaseInsensitiveString) 
            return s.equalsIgnoreCase((CaseInsensitiveString) o).s);
        if(o instanceof String) // 문제의 코드
            return s.equalsIgnoreCase((String) o);
        return false;
    }
}
~~~

String은 CaseInsensitiveString의 존재 여부 자체를 모르기 때문에 대칭성이 성립하지 않는다.

~~~java
List<CaseInsesntiveString> list = new ArrayList<>();
list.add(new CaseInsensitiveString("test"));
System.out.println(list.contains("test")) // false를 출력한다.
~~~

이를 해결하기 위해선 String과의 equals 검사를 연결하지 않는 것이다.

~~~java
public boolean equals(Object o) {
    if(o instanceof CaseInsensitiveString) 
        return s.equalsIgnoreCase((CaseInsensitiveString) o).s);
}
~~~

### 3. 추이성
A == B이고 B == C이면 A == C이다.

다음과 같이 Point클래스와 이를 상속한 ColorPoint가 있다고 가정해보자.

~~~java
public class Point {
    
    public boolean equals(Object o) {...}
}

public class ColorPoint extends Point { }
~~~

이처럼 equlas을 구현하지 않으면 Point의 equlas규약을 따르게 되고 Color와 관련된 정보는 비교하지 않는 상황이 된다.
그러면 다음과 같이 비교 대상이 ColorPoint이고 위치와 색상이 같을 때만 true를 반환하게 만드는 방법을 생각할 수 있다.

~~~java
public boolean equals(Object o) {
    if(!(o instanceof ColorPoint)) return false;
    return super.equals(o) && ((ColorPoint) o).color == color;
}
~~~

이 경우 대칭성을 위배한다. 

~~~java
Point p = new Point(1, 2);
ColorPoint cp = new ColorPoint(1, 2 Color.RED);
~~~

이 대칭성을 해결하기 위해 ColorPoint.equals에서 Point와 비교할 때는 색상을 무시하도록 정의할 수 있다. 

~~~java
public boolean equals(Object o) {
    if(!(o instanceof Point)) return false;
    
    if(!(o instanceof ColorPoint)) return o.equals(this);
    
    return super.equals(o) && ((ColorPoint) o).color == color;
}
~~~

이 방식은 대칭성은 지키지만, 추이성을 깨버린다. 

~~~java
ColorPoint p1 = new ColorPoint(1, 2, Color.RED);
Point p2 = new Point(1, 2);
ColorPoint p3 = new ColorPoint(1, 2, Color.BLUE);
~~~

또 한 이런 방식은 무한 재귀에 빠질 위험이 있다. (e.g Point의 또 다른 하위 클래스를 만들고 equals는 같은 방식으로 구현 한 경우)
<br>
구체 클래스를 확장해 새로운 값을 추가하면서 대칭성과 추이성을 모두 지킬 수 있는 해법은 존재하지 않는다. instanceof 검사를 getClass 검사로 바꾸면 규약은 지킬 수 있지만
객체지향 원칙(리스코프치환 원칙)을 지킬 수 없게 된다. 

~~~java
public boolean equals(Object o) {
    if(o == null || o.getClass() != getClass()) return false;
    Point p = (Point) o;
    return p.x == x && p.y == y;
}

public class CounterPoint extends Point {
    Set<Point> unitCircle = Set.of(new Point(1, 0), new Point(0, -1));
    
    public static boolean onUnitCircle(Point p) {
        return unitCircle.contains(p);
    }
}
~~~

하지만 우회 방법으로 컴포지션을 사용할 수 있다. 
Point를 상속하지 않고 private 필드로 두고 Point를 반환하는 뷰 메서드를 public으로 추가하는 방식이다.

~~~java
import java.util.Objects;

public class ColorPoint {
 private final Point point;
 private final Color color;

 public ColorPoint(int x, int y, Color color) {
  point = new Point(x, y);
  this.color = Objects.requireNonNull(color);
 }
 
 // 이 ColorPoint의 Point 뷰를 반환한다.
 public Point asPoint() { return point; }
 
 @Override
 public boolean equals(Object o) {
     if(!(o instanceof ColorPoint)) return false;
     ColorPoint cp = (ColorPoint) o;
     return cp.point.equals(point) && cp.color.equals(color);
 }
}
~~~

포인트 뷰를 반환하지 않는 이유는 다음과 같다. 이전에는 Point 클래스를 상속했기 때문에 변수 타입을 Point로 받을 수 있었다.
하지만 지금은 상속을 하지 않았기 때문에 Point로 변수를 받을 수 없게 된다. 따라서 이 뷰를 제공한다.

~~~java
Point p = new ColorPoint(1, 2, Color.RED).asPoint();
~~~

### 4. 일관성
두 객체가 같다면 앞으로도 영원히 같아야 한다. (가변 객체의 경우 다르다). equals의 판단에 신뢰할 수 없는 자원이 끼어들게 해서는 안된다.
예를 들어 java.net.URL의 equals에는 google이라는 호스트 이름을 넘기면 이를 IP주소로 판단한다. 하지만 이 IP주소는 바뀔 수 있기 때문에 항상 같은 결과를 보장하지 않는다. 

### 5. NULL이 아니여야 한다. 
모든 객체는 null과 같지 않아야 한다. NullPointerException을 던지지 않도록 null인지를 확인해 자신을 보호해야 한다.

~~~java
// 다음과 같은 null검사를 명시적으로 할 필요는 없다.
if(o == null) return false;

// 보통 다음과 같이 매개변수의 타입을 검사하는데 이때 자연스럽게 걸러진다.
if(!(o instanceof MyType)) return false;
~~~

## equals를 정의하는 방법 
1. == 연산자를 사용해 입력이 자기 자신의 참조인지 확인한다. (성능 최적화용)
2. instanceof 연산자로 입력이 올바른 타입인지 확인한다.
3. 입력을 올바른 타입으로 형변환한다. (2번 단계를 거치기 때문에 100% 성공함)
4. 입력 객체와 자기 자신의 '핵심 필드'모두 일치하는지 확인한다. 이때, 비교하는 비용이 싸거나 다를 가능성이 큰 필드를 먼저 피교하면 유리하다.

~~~java
public boolean equals(Object o) {
    if( o == this) return true;
    if(!(o instanceof PhoneNumber)) return false;
    PhoneNumber pn = (PhoneNumber) o;
    return pn.lineNum == lineNum && pn.prefix == prefix && pn.areaCode == areaCode;
}
~~~

5. equals를 재정의할 때는 hashCode도 반드시 재정의해야 한다. 
6. Object 외의 타입을 매개변수로 받는 equals를 선언하지 않는다. (컴파일 오류가 나며 @Override를 지우고 파라미터를 바꾸면 다른 Collection 클래스의 동작에 영향을 주게 된다.)
만약 null도 정상 값으로 취급하고 싶다면 Objects.equals(null, null)로 비교해 NullPointerException 발생을 예방하자. 

# public 클래스에서는 public 필드가 아닌 접근자 메서드를 사용하라
## 퇴보한 클래스
~~~java
class Point {
    public double x;
    public double y;
}
~~~
다음과 같은 클래스는 필드에 직접 접근할 수 있으니 캡슐화의 이점을 제공하지 못한다. 
이 클래스는 API를 수정하지 않고는 내부 표현을 바꿀 수 없고, 불변식을 보장할 수 없으며, 유효성 검사와 같은 부가 작업이 어려워진다. 

## private필드와 접근자(getter)를 추가한다.
객체 지향 프로그래밍에서는 필드를 모두 private으로 바꾸고 public 접근자를 추가하는 것이 좋다.
~~~java
class Point {
    private double x;
    private double y;
    
    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }
    
    public double getX() {
        // 부가 작업 
        return x;
    }
    public double getY() {}
}
~~~


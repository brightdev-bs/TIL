# 멤버 클래스는 되도록 static으로 만들라
## 중첩 클래스
중첩 클래스란 다른 클래스 안에 정의된 클래스를 의미한다. 중첩 클래스는 자신을 감싼 바깥 클래스에서만 쓰여야 한다.

## 중첩 클래스의 종류
정적 멤버 클래스, 멤버 클래스, 익명 클래스, 지역 클래스가 있으며 이 중 첫 번째를 제외한 나머지는 내부 클래스에 해당한다.

### 1. 정적 멤버 클래스
   주로 바깥 클래스와 함께 쓰일 때만 유용한 public 도우미 클래스로 쓰인다.
~~~java
Calculator.Operation.PLUS
Calculator.Operation.MINUS
~~~

### 2. 비정적 멤버 클래스
비정적 멤버 클래스의 인스턴스는 바깥 클래스의 인스턴스와 암묵적으로 연결된다. 그래서 비정적 멤버 클래스의 인스턴스 메서드에서 
정규화된 this를 사용해 바깥 인스턴스의 메서드를 호출하거나 바깥 인스턴스의 참조를 가져올 수 있다.
~~~java
public class MySet<E> extends AbstractSet<E> {
    @Override
    public Iterator<E> iterator() {
        return new MyIterator();
    }

    @Override
    public int size() {
        return 0;
    }

    // 어댑터 패턴의 예
    private class MyIterator implements Iterator<E> {

        @Override
        public boolean hasNext() {
            return false;
        }

        @Override
        public E next() {
            return null;
        }
    }

}
~~~

=> 중첩 클래스의 인스턴스가 바깥 인스턴스와 독립적으로 존재할 수 있다면 정적 멤버 클래스로 만들어야 한다.
 - 멤버 클래스가 공개된 클래스의 public이나 protected 멤버라면 정적이냐 아니냐는 더 중요해진다. (멤버 클래스도 공개 API가 되기 때문)
 - 바깥 클래스의 인스턴스가 생성되어야 비정적 멤버 클래스도 사용할 수 있는데, 이 참조를 저장하기 위한 시간과 공간이 더 소비된다.
 - 가비지 컬렉션이 바깥 클래스의 인스턴스를 수거하지 못하는 메모리 누수가 생길 수 있다.

### 3. 익명 클래스
~~~java
public class IntArrays {
    static List<Integer> intArrayAsList(int[] a) {
        Objects.requireNonNull(a);

        // 다이아몬드 연산자를 이렇게 사용하는 건 자바 9부터 가능하다.
        // 더 낮은 버전을 사용한다면 <Integer>로 수정하자.
        return new AbstractList<>() {
            @Override
            public Integer get(int i) {
                return a[i];  // 오토박싱(아이템 6)
            }

            @Override
            public Integer set(int i, Integer val) {
                int oldVal = a[i];
                a[i] = val;     // 오토언박싱
                return oldVal;  // 오토박싱
            }

            @Override
            public int size() {
                return a.length;
            }
        };
    }
}
~~~

### 4. 지역 클래스
지역 클래스는 지역변수를 선언할 수 있는 곳이면 어디서든 선언할 수 있다. 하지만, 가독성이 좋지 않아 많이 쓰이지 않는다. 



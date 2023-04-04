# @Override 애너테이션을 일관되게 사용하라
## @Override를 사용하지 않았을 때 버그의 발생

~~~java
import java.util.HashSet;

public class Bigram {

    private final char first;
    private final char second;

    public boolean equals(Biagram b) {
        ...
    }

    public int hashCode() {
        return ...;
    }

    public static void main(String[] args) {
        Set<Biagram> s = new HashSet<>();
        for(int i = 0; i < 10; i++) {
            for(char ch = 'a'; ch <= 'z'; ch++) {
                s.add(new Biagram(ch, ch));
            }
        }
    }
}
~~~

다음은 a ~ z 알파벳을 10번씩 Set에 집어넣는 코드이다. Set은 중복이 허용되지 않기 때문에 Set에는 10개의 요소만 들어가야 하지만 그렇지 않다.
equals와 hashCode를 재정의했고 사용하는 것에도 문제가 없어보인다.

하지만 equals를 재정의 한게 아니라 사실은 오버로딩한게 되어 버렸다. Object의 equals를 재정의하려면 매개변수가 Object이여야 하는데 Biagram을 매개변수로 받았기 때문이다.

이런 오류는 @Override 어노테이션을 달면 컴파일러가 쉽게 에러를 찾을 수 있다. 상위 클래스의 메서드를 재정의하려는 모든 메서드에는 @Override 애너테이션을 달아야 한다.


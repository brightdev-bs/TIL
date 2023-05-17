# finalizer와 cleaner 사용을 피하라
## 두 가지 객체 소멸자
자바는 두 가지 객체 소멸자를 제공한다. 첫 번째는 finalizer이고, 두 번째는 cleaner이다. 
기본적으로 이 두가지 객체 소멸자는 가능한 사용을 지양해야 한다. 그 이유는 다음과 같다.
1. JVM 알고리즘에 따라 실행이 언제되는지 알 수 없다.
2. 수행 여부조차 보장하지 않는다. 
3. finalizer 동작 중 발생한 예외는 무시되며, 처리할 작업이 남아있어도 바로 종료된다. <br> 
   => fianlizer 공격에 노출되어 심각한 보안 문제를 일으키기도 한다. <br>
   => 예를 들어 생성자나 직렬화 과정에서 예외가 발생하면, 불안정하게 생성된 객체에서 악의적인 하위 클래스의 finalizer가 수행될 수 있게 된다. 

자바 9부터는 finalizer는 사용 자제 API로 지정하고 그 대안으로 cleaner를 소개한다. <br>
 -> cleaner는 자신의 스레드를 통제하기 때문에 3번의 문제가 생기지 않는다.

그럼에도 불구하고 이 두 가지 객체 소멸자가 존재하는 이유가 있다.
1. 자원의 소유자가 close 메서드를 호출하지 않는 것에 대비한 안정망 역할을 제공할 수 있다.
2. 자바의 객체가 아닌 네이티브 피어와 연결된 객체를 사용하는 경우가 있다. <br>
 => GC는 네이티브 피어의 존재를 알지 못하기 때문에 동작하지 않는다. 

## AutoCloseable
finalizer와 cleaner를 대신해줄 수 있는 것이 AutoCloseable을 구현하고, 클라이언트에서 인스턴스를 다 쓰고 나면 close 메서드를 호출하는 것이다.

~~~java
import java.io.FileNotFoundException;
import java.io.IOException;

public class AutoCloseablePractice implements AutoCloseable {
    private BufferedReader br;

    public AutoCloseablePractice(String path) {
        try {
            this.reader = new BufferedReader(new FileReader(path));
        } catch (FileNotFoundException e) {
            throw new IllegalArgumentException(path);
        }
    }

    @Override
    public void close() {
        try {
            reader.close();
        } catch (IOException e) { // Runtime예외임에도 불구하고 예외를 잡을 때는 가장 구체적인 예외로 잡는 것이 좋다.
            throw new RuntimeException(e);
        }
    }
}
~~~

이렇게 AutoCloseable을 구현하면 try-resource문을 이용하면 try문이 끝날 때 자동으로 자원을 반납해준다.

~~~java
public class Client {
    public static void main(String[] args) {
        try (AutoCloseablePractice acp = new AutoCloseablePractice("")) {
            ...
        }
    }
}
~~~
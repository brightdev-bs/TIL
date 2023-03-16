# try-finally보다는 try-with-resources를 사용하라

## close() 메서드 호출의 필요성
자바 라이브러리에는 InputStream, OutputStream처럼 close 메서드를 호출해 직접 닫아줘야 하는 자원이 많다.
자원 닫기는 클라이언트가 놓치기 쉬워서 예측할 수 없는 성능 문제로 이어진다. 이를 막이 위해, 이런 자원 중 상당수가 finalizr를 활용하고 있지만 
finalizer는 자원의 반환을 보장하지는 않는다.

## try-finally-catch 
전통적으로 자원이 제대로 닫힘을 보장하기 위해 try-finally가 사용되었다. 하지만 이 방식은 중첩 try-catch문이 생기면 코드가 지저분해지는 문제가 있다.

try-finally 문을 제대로 작성한 다음 코드에도 문제가 있다.
~~~java
static String firstLineOfFile(String path) throws IOException {
    BufferedReader br = new BufferedReader(new FileReader(path));
    try {
        return br.readLine();    
    } finally {
        br.close();    
    }
}
~~~

기기에 물리적인 문제가 생기면 readLine() 메서드가 예외를 던지고, 같은 이유로 close메서드도 실패한다. 이런 상황에서는 두 번째 예외가 첫 번째 예외를 덮어씌어 버리고
첫 번째 예외에 대한 정보를 찾을 수 없게 되어, 디버깅을 어렵게 만든다. 

## try-with-resources
위에서 언급한 "close() 호출을 까먹을 수 있다.", "코드의 복잡성 증가", "예외 디버깅의 어려움" 문제들을 자바7의 try-with-resources로 해결할 수 있다.
이를 사용하기 위해 AutoCloseable 인터페이스를 구현해야 한다. 

~~~java
static String firstLineOfFile(String path) throws IOException {
    
    try (BufferedReader br = new BufferedReader(new FileReader(path))
        OutputStream os = new FileOutputStream("")
        ) {
        return br.readLine();    
    } 
}
~~~

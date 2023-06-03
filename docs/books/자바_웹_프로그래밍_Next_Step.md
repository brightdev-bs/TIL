# 자바 웹 프로그래밍 Next Step
## 책을 읽는데 도움이 될 서적
1. 이펙티브 자바
2. 성공으로 이끄는 팀 개발 실천 기술(이케다 타카후미/김완섭 역)
   - 애플리케이션을 효과적으로 배포하고, 운영하기 위해 알아야 할 도구들과 각 도구들 간의 효과적인 활용 방법에 대해서 설명한다.
3. HTTP & Network : 그림으로 배우는 책으로 학습(우에노 센 저/이병억 역)
   - 웹 애플리케이션 개발자는 반드시 HTTP를 학습해야 한다. 
4. IT 인프라 구조 : 그림으로 공부하는(야마자키 야스시/김완섭 역)
   - 시스템과 운영체제, 서버와 아키텍처까지 전반적인 내용에 대해 이해할 수 있다.

## Ch2. 문자열 계산기 구현을 통한 테스트와 리팩토링
### Main()을 이용한 테스트의 문제점
1. 프로덕션 코드와 테스트 코드가 섞여버린다.
   - 테스트 코드는 서비스하는 시점에 같이 배포할 필요가 없다.
2. 프로덕션 코드의 복잡도가 증가할수록 main()메소드의 복잡도도 증가하고, 결과적으로 main() 메소드를 유지하는데 부담이 된다.
3. 콘솔에 출력된 값을 수동으로 체크해야 한다.

### Junit을 활용한 main() 메소드 문제점 극복
1. Junit을 사용하면 필요한 메소드에 대한 테스트만 할 수 있다. 

<img src="./images/junit1.png" width="500">

2. assertEquals() 메소드를 이용하여 실행 결과를 자동화하는 것이 가능하다.

~~~java
 @Test
 public void subtract() {
     Calculator cal = new Calculator();
     assertEquals(3, cal.subtract(6, 3));
 }
~~~

### 테스트 코드 중복 제거
중복을 제거하기 위해 Calculator를 생산하는 부분을 private 필드로 추출할 수 있다.

~~~java
public class CalculatorTest {

    private Calculator cal = new Calculator();
    
    @Test
    public void add() {
        assertEquals(9, cal.add(6, 3));
    }
    @Test
    public void subtract() {
        assertEquals(3, cal.subtract(6, 3));
    }
}
~~~

하지만 JUnit에서는 @Before 어노테이션을 활용해 다음과 같이 구현할 것을 추천한다.
~~~java
public class CalculatorTest {

    private Calculator cal;
    @BeforeEach
    public void setup() {
        cal = new Calculator();
    }

    @Test
    public void add() {
        assertEquals(9, cal.add(6, 3));
    }
    @Test
    public void subtract() {
        assertEquals(3, cal.subtract(6, 3));
    }
}
~~~
두 가지 모두 메소드를 실행할 때마다 새로운 객체를 생성한다는 점은 같다. 하지만 JUnit의 @RunWith, @Rule 같은 어노테이션을 사용하기 위해서는 @Before안이어야만 
접근할 수 있다는 제약사항이 있다. 

### 리팩토링
리팩토링이란 소스코드의 가독성을 높이고 유지보수를 편하게 하기 위해 소스코드의 구조를 변경하는 것을 의미한다. 다음 원칙을 지키려고 노력하면 일정 수준 깔끔한 코드 작성이 가능하다.
1. 메소드가 한 가지 책임만 가지도록 구현한다. 
2. 인덴트 깊이를 1단계로 유지한다.
   - 인덴트는 while 문과 if문을 사용할 경우 인덴트 깊이가 1씩 증가한다. 
   - 다음 소스코드의 인덴트 깊이는 2이다.

~~~java
void someMethod() {
    while(true) {
        if(true) {
            
        }
    }
}
~~~

3. else를 사용하지 마라. 프로그래밍을 구현할 때 else를 사용하지 않고 프로그래밍하는 것이 가능하다. 

### 추가학습 자료
1. 리팩토링 : 코드 품질을 개선하는 객체지향 사고법(마틴 파울러 저/김지원 역)
2. 정규식 : 손에 잡히는 정규 표현식 (벤 포터/김경수 역)

## Ch3. 개발 환경 구축 및 웹 서버 실습 요구사항
### 실습 3-1 : index.html 응답하기
1. BufferedReader를 이용한 데이터 읽기
 - 문자 인풋 스트림으로부터 데이터를 읽어오는 클래스
 - 데이터를 청크(chunk) 단위로 읽어옴으로써 I/O의 횟수를 줄일 수 있다. 읽어온 데이터 청크에 필요한 데이터가 있으면 버퍼에서 읽어온다.
 - 데코레이터 패턴을 사용하고 있다. 
      - 생성자의 파라미터로 Reader 인터페이스를 가지고 있다.
      - Reader의 모든 구현체를 파라미터로 받을 수 있기 때문에 유연하다.

2. HTTP 규약
 웹 클라이언트는 웹 서버와 데이터를 주고 받기 위해 HTTP라는 서로 간에 약속된 규약을 따른다. 

~~~text
POST /user/create HTTP/1.1                      ----> 요청 라인

HOST: localhost:8080                            ----> 요청 헤더
Connection-Length: 60                           ----> 요청 헤더
Content-Type: application/x-www-form-urlencoded ----> 요청 헤더
Accept: */*                                     ----> 요청 헤더

                                                ----> 헤더와 본문 사이의 빈 공백 라인
userId=java&password=password                   ----> 요청 본문
~~~

 - 요청 라인 : (HTTP 메소드 - 메소드 URI - HTTP 버전)으로 구성되어 있다. 
 - 요청 헤더 : <필드 이름> : <필드 값> 쌍으로 이루어져 있다.
 - 헤더와 본문 사이의 빈 공백을 통해 헤더와 본문을 구분짓는다. 

 응답 메세지의 표준 형태는 다음과 같다.

~~~text
HTTP/1.1 200 OK                               ----> 상태 라인 
Content-Type: text/html;charset=utf-8         ----> 요청 헤더
Content-Length: 20                            ----> 요청 헤더
                                              ----> 헤더와 본문 사이의 빈 공백
<h1>Hello World<h1>                           ----> 응답 본문
~~~
 -상태 라인 : (HTTP/버전 - 상태코드 - 응답구문)으로 구성되어 있다.


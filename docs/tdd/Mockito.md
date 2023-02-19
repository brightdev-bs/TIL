## Mockito
### Mockito 사용하기
자바에서 테스트 라이브러리로 많이 사용하고 있는 것이 Mockito이다. JUnit5에서는 @RunWith(MockitoJunitRunner.class)를 클래스 레벨에 선언함으로써 Mockito에서 제공하는 목을 사용할 수 있다.

~~~java
@RunWith(MockitoJunitRunner.class)
public class Test(){
    ...
}
~~~

### Mockito에서 제공하는 어노테이션
1. @Mock : 목 객체를 생성해준다.
2. @InjectMocks : @Mock

@InjectMocks을 사용하면 @Mock이 붙은 목객체를 InjectMocks이 붙은 객체에 주입시킬 수 있다. 예를 들어 WordService.class에서 WordRepository.class를 DI하는 경우 WorldService에 @InjectMocks를 Repository에 @Mock을 선언해주면 worldService에 repository가 주입된다.
~~~java
@RunWith(MockitoJunitRunner.class)
public class Test(){
    @InjectMocks
    private WordService wordService;

    @Mock
    private WordRepository wordRepository;
}
~~~
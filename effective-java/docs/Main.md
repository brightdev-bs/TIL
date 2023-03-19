# 이펙티브 자바 
이펙티브 자바 공부한 내용을 정리합니다.

### Chapter 2. 객체 생성과 파괴
1. [정적 팩터리 메서드](ch2/정적_팩터리_메서드.md)
2. [빌더 패턴](ch2/빌더_패턴.md)
3. [싱글턴을 보장하는 3가지 방법](ch2/싱글턴을_보장하기.md)
4. [인스턴스화를 막기 위해 private 생성자를 이용하자](ch2/인스턴스와_private생성자.md)
5. [의존 객체 주입을 사용하라](ch2/의존_객체_주입을_사용하라.md)
6. [다 쓴 객체 참조를 해제하라](ch2/다_쓴_객체_참조를_해제하라.md)
7. [finalizer와 cleaner의 사용을 자제해라](ch2/finalizer와_cleaner_사용을_피하라.md)
8. [try fianlly보다 try-with-resource를 사용하라](ch2/try_finally보다는_try-with-resource를_사용하라.md)

### Chapter 3. 모든 객체의 공통 메서드
equlas, hashCode, toString, clone, finalize는 모두 재정의(Overriding)를 염두에 둔 메서드로 언제 어떻게 재정의해야 하는지 다룬다.
1. [equals는 일반 규약을 지켜 재정의하라](ch3/equlas는_일반_규약을_지켜_재정의하라.md)
2. [equals는 hashcode도 같이 재정의하라](ch3/equlas를_재정의할때는_hashcode도_재정의하자.md)
3. [toString을 항상 재정의하라](ch3/toString을_항상_재정의하라.md)
4. [clone 재정의](ch3/clone_재정의.md)
5. [Comparable 구현할지 고민하라](ch3/Comparable을_구현할지_고민하라.md)

### Chapter 4. 클래스와 인터페이스
1. [클래스와 멤버의 접근 권한을 최소화하라](ch4/클래스와_멤버의_접근_권한을_최소화하라.md)


### 추가학습
1. [JVM 가비지 컬렉터](./가비지_컬렉터.md)
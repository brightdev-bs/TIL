## 객체지향 프로그래밍II  ## <br>
#### 클래스간의 관계 결정하기 #### <br>
&nbsp;&nbsp; 클래스를 작성하는데 있어서 상속관계를 맺어 줄 것인지 포함관계를 맺어 줄 것인지 결정하는 것이 혼돈스러울 수 있다.<br>
이때는 is-a와 has-a를 이용하여 문장을 만들어 보면 클래스 간의 관계가 보다 명확해 진다.<br>
> 원(Circle)은 점(Point)이다. - Circle is a Point <br>
> 원(Circle)은 점(Point)을 가지고 있다. - Circle has a Point <br>
-> 원은 점을 가지고 있다가 문맥상 더 적합! <br><br>

---
####  오버라이딩과 오버로딩   ####
1 ) 오버로딩 : 기존에 없는 새로운 메서드를 정의하는 것. <br>
2 ) 오버라이딩 : 상속받은 메서드의 내용을 변경하는 것. (overWrite)<br>

    class Parent {
		void parentMethod() {}
	}

	class Child extends Parent {
		void parentMethod() {}        // 오버라이딩
		void parentMethod(int i) {}   // 오버로딩
	}


#### 다형성 ####
다형성이란? <br>
&nbsp;&nbsp; 여러 가지 형태를 가질 수 있는 능력 <br>
&nbsp;&nbsp; 조상클래스 타입의 참조변수로 자손클래스의 인스턴스를 참조하는 것 <br>

#### 참조변수의 형변환  ####
1 ) Up-Casting : 자손 클래스의 객체가 조상 클래스 타입으로 형변환되는 것. (형변환 생략가능) <br>
2 ) Down-Casting : 조상 클래스의 타입이 자손 클래스의 객체 타입으로 형변환 되는 것.  (형변환 생략불가) <br>
![캐스팅.jpg](https://github.com/brightdev-bs/TIL/blob/main/Java/%EC%9D%B4%EB%AF%B8%EC%A7%80/%EC%BA%90%EC%8A%A4%ED%8C%85.PNG)

#### instaceof 연산자  ####
참조변수가 참조하고 있는 인스턴스의 실제 타입을 알아보기 위해 instacneof연산자를 사용한다.<br>
만약 결과가 true라는 것은 검사한 타입으로 형변환이 가능하다는 것을 의미한다.
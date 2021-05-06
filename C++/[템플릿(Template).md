# [템플릿(Template)]

[템플릿(Template)]

 

- 함수나 클래스를 작성할 때, 자료형 별로 작성하지 않도록 도와줌
- 함수 템플릿과 클래스 템플릿이 있음.

```cpp
template <typename T> // 템플릿 선언
T add(T a, T b);

add(1,3) // int add(int, int)의 함수로 구체화 됨
add(1.5, 3.2) // float add(float, float)의 함수로 구체화 됨.
```
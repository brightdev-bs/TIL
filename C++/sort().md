# sort()

알고리즘 테스트, 대회에서는 정렬 알고리즘을 직접 구현하는 것이 아닌 STL을 이용하는 것이 좋다!

<sort() 함수의 기본 사용법>

→ sort(시작 메모리 주소, 마지막 메모리 주소)

```c
#include <iostream>
#include <algorithm> // sort함수가 정의되어 있음

using namespace std;

int main(void) {
	int a[10] = { 9,3,5,4,1,10,8,6,7,2 };
	sort(a, a + 10); // 메모리 주소(a) / 정렬할 마지막 원소의 메모리 주소 (a + 10)
	for (int i = 0l; i < 10; i++) {
		cout << a[i] << ' ';
	}
}
```

<sort함수의 정렬할 기준을 정하기>

sort함수의 기본은 오름차순으로 디폴트가 되어 있다.

만약 내림차순으로 정렬은 원한다면 그 기준을 바꿔주어야 한다.

```c
#include <iostream>
#include <algorithm> // sort함수가 정의되어 있음

using namespace std;

bool compare(int a, int b) {
	return a > b;
}

int main(void) {
	int a[10] = { 9,3,5,4,1,10,8,6,7,2 };
	//sort(a, a + 10);
	sort(a, a + 10, compare);
	for (int i = 0l; i < 10; i++) {
		cout << a[i] << ' ';
	}
}
```

**<데이터 묶어서 정렬하기>**

실제 프로그램에서는 객체로 정리되어 있기 때문에 위와 같은 방법은 잘 사용되지 않는다. 특정 변수를 기준으로 정렬하는 방법이 필요!

```c
#include <iostream>
#include <algorithm> // sort함수가 정의되어 있음

using namespace std;

class Student {
public:
	string name;
	int score;

	Student(string name, int score) {
		this->name = name;
		this->score = score;
	}
	// 정렬 기준은 점수가 낮은 순서
	bool operator < (Student& student) {
		return this->score < student.score;
	}
};

int main(void) {
	Student students[] = {
		Student("아이유", 90),
		Student("원빈", 93),
		Student("BTS", 97),
		Student("미래", 92),
		Student("장첸", 91),
	};
	sort(students, students + 5);
	for (int i = 0; i < 5; i++) {
		cout << students[i].name << ' ';
	}
}
```
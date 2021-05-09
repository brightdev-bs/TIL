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

/*
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
*/




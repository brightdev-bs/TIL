#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

vector<pair<int, int> > v;
int n; // N개의 회의
int c = 1;

// pair vector를 오름차순으로 정렬하기 위한 함수. 
bool compare(pair<int, int>v1, pair<int, int> v2) {
	if(v1.second == v2.second) // 같으면 시작시간 빠른 것 부터 나열 
		return v1.first < v2.first;
	return v1.second < v2.second;
}

int main(void) {
	int start, end; // 시작 시간, 종료 시간 
	int from, to; // 가능한 회의를 찾기 위한 변수들 
	
 	// 회의 수 
	cin >> n;

	// 회의 시간 입력 받기 
	for (int i = 0; i < n; i++) {
		cin >> start >> end;
		v.push_back(pair<int, int>(start, end));
	}

	sort(v.begin(), v.end(), compare); // 시작시간 순으로 나열
	
	from = v[0].second; // 배열 0번재 요소는 무조건 실행! 
	for(int i = 1; i < n; i++) {
		to = v[i].first;
		if(from < to) {
			c++;
			from = v[i].second;
		}
	}
	cout << c;
}



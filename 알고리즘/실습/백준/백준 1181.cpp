// 백준 1181번
// 시간 제한 2초 / 입력 20000 - > 합병 정렬 이용 
#include <iostream>
#include <algorithm>
using namespace std;

string arr[20001];
int n;

bool compare(string a, string b) {
	//길이가 짧은 순서
	if(a.length() < b.length()) {
		return 1;
	}
	else if(a.length() > b.length()) {
		return 0;
	}
	else {
		return a < b; // 사전순 나열 
	}
}

int main(void) {
	cin >> n;
	for(int i = 0; i < n; i++) {
		cin >> arr[i];
	}
	sort(arr, arr + n, compare);
	for(int i = 0; i < n; i++) {
		if(i > 0 && arr[i] == arr[i-1]) {
			continue;
		}else {
			cout << arr[i] << endl;
		}
	}
}

#include <iostream>
using namespace std;


//접근 방법 :  다음 주유비와 비교한다.
// 만약 현재 주유값이 다음 주유값보다 싸다면 다음 주유까지 미리 하기. 
// 다음 주유값이 더 싸다면 다음 주유소까지 가는데 필요한 양 만큼만 주유하기.

long long dist[100001];
long long price[100001];
long long result = 0, tmp = 1000000000;

int main(void) {
	int i, j;
	int cities; // 시티 개수. 
	
	cin >> cities;
	
	// 거리 입력 받기. 
	for(i = 1; i <= cities - 1; i++) {
		cin >> dist[i];
	} 
	
	// 주유값 입력 받기. 
	for(i = 1; i <= cities; i++) {
		cin >> price[i];
	} 
	
	for(i = 1; i <= cities - 1; i++) {
		if(price[i] < tmp) 
			tmp = price[i];
		result += tmp * dist[i];
	} 
	
	cout << result;
}

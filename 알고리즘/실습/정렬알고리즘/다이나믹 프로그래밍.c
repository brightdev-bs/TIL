#include <stdio.h>

int m[100]; // 전역 변수로 선언한 배열은 모두 0으로 자동 초기화됨. 

int d(int x) {
	if(x == 1) return 1;
	if(x == 2) return 1;
	if(m[x] != 0) return m[x];
	return m[x] = d(x-1) + d(x - 2);
}

int main(void) {
	printf("%d", d(30));
}

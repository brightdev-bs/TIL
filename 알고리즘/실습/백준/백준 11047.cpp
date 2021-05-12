#include <stdio.h>

int a[10];
int count[10];

int main(void) {
	int n,k, sum = 0;
	scanf("%d %d", &n, &k);
	
	// 입력받기 
	for(int i = 0; i < n; i++) {
		scanf("%d", &a[i]);
	}
	
	// 동전 갯수 세기 
	for(int i = n -1; i >= 0; i--) {
		count[i] = k / a[i];
		k = k % a[i];
	}
	
	for (int i = 0; i < n ; i++) {
		sum += count[i];
	}
	
	printf("%d", sum);
}

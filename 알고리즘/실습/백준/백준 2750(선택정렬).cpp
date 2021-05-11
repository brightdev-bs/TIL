#include <stdio.h>

/*
1 ) 입력 범위를 제곱해도 1억이 넘지 않음
  --> 버블 정렬, 선택 정렬, 삽입 정렬 사용 가능
2 ) 여기에선 선택 정렬을 이용 
3 ) 선택정렬이란 가장 작은 숫자를 선택해서 앞으로 보내는 알고리즘! 
*/

int arr[1001]; // 알고리즘을 풀 때는 데이터 갯수보다 1 더 크게 하는 것이 정신건강에 좋음 

int main(void) {
	int i, j, tmp, n, index, min;
	scanf("%d ", &n); 

	for(i = 0; i < n; i++) {
		scanf("%d", &arr[i]);	
	}
	
	for(i = 0; i < n; i++) {
		min = 1001;
		for(j = i; j <n; j++) {
			if(min > arr[j]) {
				min = arr[j];
				index = j;
			}
		}
		tmp = arr[i];
		arr[i] = arr[index];
		arr[index] = tmp;
	}
	for(i = 0; i < n; i++) {
		printf("%d ", arr[i]);	
	}
}

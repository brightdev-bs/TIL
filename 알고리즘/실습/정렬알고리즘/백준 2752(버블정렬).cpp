#include <stdio.h>

/*
1 ) 오름차순으로 정렬 한다 -> 정렬 알고리즘을 써야겠다.
2 ) 숫자는 3개만 주어진다. -> 숫자의 범위가 작으므로 어떤 알고리즘을  이용해도 상관 없음 
3 ) 구현하기 쉬운  버블 정렬 이용 
*/

int main(void) {
	int i, j, tmp;
	int arr[3];
	
	// 사용자 입력받기 
	for(i = 0; i < 3; i++) {
		scanf("%d", &arr[i]);
	}
	
	//버블 정렬
	for(i = 0; i < 2; i++) {
		for(j = i+1; j < 3; j++) {
			if(arr[i] > arr[j]) {
				tmp = arr[i];
				arr[i] = arr[j];
				arr[j] = tmp;
			}
		}
	} 
	
	// 작은 수 부터 출력하기 
	for(i = 0; i < 3; i++) {
		printf("%d ", arr[i]); 
	}
}

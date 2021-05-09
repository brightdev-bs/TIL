#include <stdio.h>
//선택 정렬 알고리즘
int main(void) {
	int i, j, k, min, index, tmp;
	int arr[10] = {1,10,5,8,7,6,4,3,2,9};
	for(i = 0; i < 10; i++) {
		min = 999;
		for(j = i; j < 10; j++) {
			if(min > arr[j]) {
				min = arr[j];
				index = j;
			}
		}
		tmp = arr[i];
		arr[i] = min;
		arr[index] = tmp;
		for(k = 0; k < 10; k++) {
			printf("%d ", arr[k]);
		}
		printf("\n");
	}
} 

#include <stdio.h>

int main(void) {
	int i, j, tmp;
	int arr[10] = {1,5,10,8,7,6,4,3,2,9};
	for(i = 0; i < 10; i++) {
		for(j=0; j< 9 - i; j++) {
			if(arr[j] > arr[j+1]) {
				tmp  = arr[j];
				arr[j] = arr[j+1];
				arr[j+1] = tmp;
			}
		}
	}
	for(i = 0; i < 10; i++) {
		printf("%d ", arr[i]);
	}
	return 0;
}

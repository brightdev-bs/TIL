#include <stdio.h>

int number = 10;
int data[10] = {1,10,5,8,7,6,4,3,2,9};

void quickSort(int *data, int start, int end) {
	if(start >= end) { //원소가 1개인 경우 
		return;
	}
	
	int pivot = start; //키는 첫번째 원소
	int i = start + 1;
	int j = end;
	int tmp;
	
	while(i <= j) { //엇갈릴 때가지 반복 
		while(i <= end && data[i] <= data[pivot]) { // 키 값보다 작은 값 만날 때까지 반복 
			i++;
		}
		while(data[j] >= data[pivot] && j > start) { // 키 값보다 작은 값 만날 때까지 반복 
			j--; 
		}
		if(i > j) {
			tmp = data[j];
			data[j] = data[pivot];
			data[pivot] = tmp;
		} else {
			tmp = data[i];
			data[i] = data[j];
			data[j] = tmp;
		}
	} 
	
	quickSort(data, start, j-1);
	quickSort(data, j+1, end);
}


int main(void) {
	int i;
	quickSort(data,0,number-1);
	for(i = 0; i < number; i++) {
		printf("%d ", data[i]);
	}
}

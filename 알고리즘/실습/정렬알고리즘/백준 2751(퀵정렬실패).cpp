/*
1 ) 데이터의 개수가 1억개가 넘음
 --> NlogN 알고리즘 이용 -> 퀵 정렬
*/

#include <stdio.h>

int arr[10000001];

void quick_sort(int *data, int start, int end) {
	if(start >= end) {
		return;
	}
	
	int i, j, pivot,tmp;
	pivot = start;
	i = start+1;
	j = end;
	
	
	while(i <= j) {
		while(arr[i] <= arr[pivot]) {
			i++;
		}
		while(arr[j] >= arr[pivot] && j > start) {
			j--;
		}
		
		if(i > j) {
			tmp = arr[j];
			arr[j] = arr[pivot];
			arr[pivot] = tmp;
		} else {
			tmp = data[i];
			data[i] = data[j];
			data[j] = tmp;
		}
	}
	quick_sort(data, start, j-1);
	quick_sort(data, j+1, end);
}

int main(void) {
	int i, n;
	scanf("%d", &n);
	
	for(i = 0; i < n; i++) {
		scanf("%d", &arr[i]);
	}
	
	quick_sort(arr, 0, n-1);
	
	for(i = 0; i < n; i++) {
		printf("%d\n", arr[i]);
	}
}

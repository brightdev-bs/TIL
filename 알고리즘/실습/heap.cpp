#include <stdio.h>

int number = 10;
int heap[10] = { 1,10,2,8,3,9,4,6,5,7 };

int main(void) {
	// 일단 전체 구조를 힙 구조로 만들기!!
	// 최대 힙 or 최소 힙
	// 여기서는 최대 힙으로 구현 !
	for (int i = 0; i < number; i++) {
		int c = i;
		do {
			int root = (c - 1) / 2;
			if (heap[c] > heap[root]) {
				int temp = heap[root];
				heap[root] = heap[c];
				heap[c] = temp;
			}
			c = root;
		} while (c != 0);
	}
	// 크기를 줄여가며 반복적으로 힙을 구성
	for (int i = number - 1; i >= 0; i--) {
		int temp = heap[0];
		heap[0] = heap[i];
		heap[i] = temp;
		int root = 0;
		int c = 1;
		do {
			c = 2 * root + 1;
			if (c < i - 1 && heap[c] < heap[c + 1]) {
				c++;
			}
			if (c < i && heap[root] < heap[c]) {
				temp = heap[root];
				heap[root] = heap[c];
				heap[c] = temp;
			}
			root = c;
		} while (c < i);
	}
	for (int i = 0; i < number; i++) {
		printf("%d ", heap[i]);
	}
}
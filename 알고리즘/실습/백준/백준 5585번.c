#include <stdio.h>

int main(void) {
	int n, m500, m100, m50, m10, m5, m1, count;
	scanf("%d", &n);
	
	n = 1000 - n;
	
	m500 = n / 500;
	n = n % 500;
	
	m100 = n / 100;
	n = n % 100;
	
	m50 = n / 50;
	n = n % 50;
	
	m10 = n / 10;
	n = n % 10;
	
	m5 = n / 5;
	n = n % 5;
	
	m1 = n / 1;
	
	count = m500 + m100 + m50 + m10 + m5 + m1;
	printf("%d ", count);
}

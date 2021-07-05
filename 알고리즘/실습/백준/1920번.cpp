#include <iostream>
#include <algorithm>

using namespace std;

int arr[100001];
int arr2[100001];

int binary_search(int target, int n) {
	int result = 0;
	int left = 0, right = n-1;
	while(left <= right) {
		int mid = (left + right) / 2;
		if(arr[mid] > target)
			right = mid - 1;
		else if(arr[mid] < target)
			left = mid + 1;
		else {
			result = 1;
			return result;
		}
	}	
	return result;
}

int main(void) {
	int n, n2, i;
	int result = 0;
	cin >> n;
	
	for(i = 0; i < n; i++) {
		scanf("%d", &arr[i]);
	}
	
	cin >> n2;
	for(i = 0; i < n2; i++) {
		scanf("%d", &arr2[i]);
	}
	
	sort(arr, arr+n);
	
	for(i = 0; i < n2; i++) {
		result = binary_search(arr2[i], n);
		printf("%d\n", result);
	}
}

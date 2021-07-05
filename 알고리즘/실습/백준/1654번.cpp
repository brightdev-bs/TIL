#include <iostream>
#include <algorithm>

using namespace std;

long long arr[100001];

int main(void) {
	int k, n;
	long long left, right;
	int result = 0; 
	long long max = 0, mid;
	cin >> k >> n;
	
	for(int i = 0; i < k; i++) {
		cin >> arr[i];
	}
	
	sort(arr, arr+k);
	
	left = 1; right = arr[k-1];
	
	while(left <= right) {
		result = 0;
		mid = (left + right) / 2;
		
		for(int i = 0; i < k; i++) {
			result += arr[i] / mid;
		} 
		
		if(result >= n) {
			left = mid + 1;
			if(mid > max) max = mid;
		} else {
			right = mid - 1;
		}
	}
	cout << max;
}

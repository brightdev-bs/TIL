#include <iostream>
using namespace std;
int arr[11];

int main(void) {
	int n;
	cin >> n;
	
	for(int i = 1; i <= n; i++) {
		int x;
		cin >> x;
		int count = 0;
		for(int j = 1; j <= n; j++) {
			if(count == x && arr[j] == 0) {
				arr[j] = i;
				break;
			}
			if(arr[j] == 0) count++;
		}
	}
	
	for(int i = 1; i <= n; i++) {
		cout << arr[i] << ' ';
	}
	return 0;
}

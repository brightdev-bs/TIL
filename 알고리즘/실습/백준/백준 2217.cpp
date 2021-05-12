#include <iostream>
#include <vector>
#include <algorithm>

using namespace std; 

int main(void) {
	int n, tmp, w, k = 0;
	vector<int> a;
	
	cin >> n;
	for(int i = 0; i < n; i++) {
		cin >> tmp;
		a.push_back(tmp);
	}
	
	sort(a.begin(), a.end());
	
	int max = 0;
	for(int i = 0; i < n; i++) {
		if(max < a[i] * (n-i)) max = a[i] * (n-i);
	}
	cout << max;
	return 0;
}

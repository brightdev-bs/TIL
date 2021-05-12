#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int main(void) {
	int n,tmp,sum = 0;
	vector<int> ta;
	
	scanf("%d", &n);
	
	for(int i = 0; i < n; i++) {
		scanf("%d", &tmp);
		ta.push_back(tmp);
	}
	
	sort(ta, ta+n);
	
	for(int i = 0; i < n; i++) {
		for(int j = 0; j <= i; j++) {
			sum += ta[j];
		}
	}
	cout << sum;
}

#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

bool compare(pair<string, pair<int, int> > a, pair<string, pair<int, int> > b) {
	if (a.second.first == b.second.first) {
		return a.second.second > b.second.second;
	}
	else {
		return a.second.first > b.second.first;
	}
}

int main(void) {
	/* 2개의 변수 pair 응용 */
	/*
	vector<pair<int, string>> v;
	v.push_back(pair<int, string>(90, "아이유"));
	v.push_back(pair<int, string>(85, "원빈"));
	v.push_back(pair<int, string>(88, "수지"));
	v.push_back(pair<int, string>(92, "은혁"));
	v.push_back(pair<int, string>(98, "동수"));
	*/

	/* 3개의 변수 pair -> 이중 pair */
	vector<pair<string, pair<int, int> > > v;
	v.push_back(pair<string, pair<int, int> >("아이유", pair<int, int>(90, 19981111)));
	v.push_back(pair<string, pair<int, int> >("원빈", pair<int, int>(93, 19981112)));
	v.push_back(pair<string, pair<int, int> >("은혁", pair<int, int>(98, 19981113)));
	v.push_back(pair<string, pair<int, int> >("수지", pair<int, int>(93, 19981114)));
	v.push_back(pair<string, pair<int, int> >("동수", pair<int, int>(90, 19981115)));

	sort(v.begin(), v.end(), compare);

	for (int i = 0; i < v.size(); i++) {
		cout << v[i].first << ' ';
	}

	return 0;
}
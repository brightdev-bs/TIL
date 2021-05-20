#include <iostream>
#include <vector>
#include <stack>
#define MAX 10001

using namespace std;

int id, d[MAX];
bool finished[MAX];
vector<int> a[MAX];
vector<vector<int> > SCC;
stack<int> s;

//DFS는 총 정점의 갯수만큼 실행됩니다.
int dfs(int x) {
	d[x] = ++id;
	s.push(x);

	int parent = d[x];
	for (int i = 0; i < a[x].size(); i++) {
		int y = a[x][i]; // 인전합 노드
		// 방문하지 않은 이웃
		if (d[y] == 0) parent = min(parent, dfs(y));
		// 처리 중인 이웃
		else if (!finished[y]) parent = min(parent, d[y]);
	}

	if (parent == d[x]) {
		vector<int> scc;
		while (1) {
			int t = s.top();
			s.pop();
			scc.push_back(t);
			finished[t] = true;
			if (t == x) break;
		}
		SCC.push_back(scc);
	}
	return parent;
}
#include <iostream>
#include <vector>
#include <queue>
#define MAX	10

using namespace std;

int n, inDegree[MAX];
vector<int> a[MAX];

void topologySort() {
	int result[MAX];
	queue<int> q;
	// 진입 차수가 0인 노드를 큐에 삽입
	for(int i = 1; i<=n; i++) {
		if(inDegree[i] == 0) q.push(i);
	} 
	// 위상 정렬이 완전히 수행하려면 정확히 N개의 노드를 방문합니다.
	for(int i = 1; i <= n; i++) {
		if(q.empty()) {
			printf("싸이클 발생");
			return;
		}
		int x = q.front();
		q.pop();
		result[i] = x;
		for(int i = 0; i < a[x].size(); i++) {
			int y = a[x][i];
			if(--inDegree[y] == 0) {
				q.push(y);
			}
		}
	} 
	for(int i = 1; i <=n; i++) {
		printf("%d ", result[i]);
	}
}


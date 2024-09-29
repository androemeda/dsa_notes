#include <iostream>
#include <vector>
#include <algorithm>
#include <set>
#include <map>
#include <queue>
#include <cstring>
using namespace std;

const int N = 2e5 + 10;

const int mx = 0, smx = 1;

int downAns[N][2];

void dfs1(int curr, int parent, vector<vector<int> > &adj) {
    downAns[curr][mx] = 1;
    downAns[curr][smx] = 0;
    for (int nb : adj[curr]) {
        if (nb == parent) continue;
        dfs1(nb, curr, adj);
        int currAns = 1 + downAns[nb][mx];

        if (currAns > downAns[curr][mx]) {
            downAns[curr][smx] = downAns[curr][mx];
            downAns[curr][mx] = currAns;
        } else if (currAns > downAns[curr][smx]) {
            downAns[curr][smx] = currAns;
        }
    }
}

int upAns[N];

void dfs2(int curr, int parent, vector<vector<int> > &adj) {
    if (curr != 1) {
        upAns[curr] = 1 + upAns[parent];
        if (downAns[parent][mx] == 1 + downAns[curr][mx]) {
            upAns[curr] = max(upAns[curr], 1 + downAns[parent][smx]);
        } else {
            upAns[curr] = max(upAns[curr], 1 + downAns[parent][mx]);
        }
    }

    for (int nb : adj[curr]) {
        if (nb == parent) continue;
        dfs2(nb, curr, adj);
    }
}

int main() {
    int n;
    cin >> n;

    vector<vector<int> > adj(n + 1);

    for (int i = 1; i < n; i++) {
        int u, v;
        cin >> u >> v;
        adj[u].push_back(v);
        adj[v].push_back(u);
    }

    dfs1(1, 0, adj);
    dfs2(1, 0, adj);

    for (int i = 1; i <= n; i++) {
        cout << max(downAns[i][mx], upAns[i])-1 << " ";
    }

    return 0;
}

#include <iostream>
#include <vector>
#include <algorithm>
#include <set>
#include <map>
#include <queue>
#include <cstring>
using namespace std;

int n , k;
int downAns[50010][510];
vector<int> adj[50010];

void dfs1(int curr , int parent){
    downAns[curr][0] = 1;
    for(int nb : adj[curr]){
        if(nb == parent) continue;
        dfs1(nb , curr);
        for(int j=1 ; j<=k ; j++){
            downAns[curr][j] += downAns[nb][j-1];
        }
    }
}

int main(){

    cin >> n >> k;
    for(int i=1 ; i<n ; i++){
        int u , v;
        cin >> u >> v;
        adj[u].push_back(v);
        adj[v].push_back(u);
    }

    dfs1(1 , 0);

    for(int i=1 ; i<=n ; i++){
        for(int j=0 ; j<=k ; j++){
            cout << downAns[i][j] << " ";
        }
        cout << endl;
    }

    return 0;
}

/**
 * 
 * downAns[i][j] = count of nodes which are at a distance j from the node i in the subtree of i.
 * 
 */
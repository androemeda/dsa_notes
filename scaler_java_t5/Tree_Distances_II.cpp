#include <iostream>
#include <vector>
#include <algorithm>
#include <set>
#include <map>
#include <queue>
#include <cstring>
using namespace std;

const long long N = 2e5 + 10;
vector<vector<int> > adj(N);
long long downAns[N];
long long upAns[N];
long long Size[N]; //Size of ith subtree
long long n;


//find answer for one root.
void dfs1(int curr , int parent){
    Size[curr]++;

    for(int nb : adj[curr]){
        if(nb == parent) continue;
        dfs1(nb , curr); //we got the ans of nb after this call.
        Size[curr] += Size[nb];
        downAns[curr] += downAns[nb] + Size[nb];
    }
}

//after finding ans for one node , re-root the tree for every node.
void dfs2(int curr , int parent){
    if(parent != -1){
        long long parentAns = downAns[parent] + upAns[parent];
        long long parentAnsWithoutCurr = parentAns - (downAns[curr] + Size[curr]);
        upAns[curr] = parentAnsWithoutCurr + n - Size[curr];
    }

    for(int nb : adj[curr]){
        if(nb == parent) continue;
        dfs2(nb , curr);
    }
}

int main(){

    cin >> n;

    for(int i=1 ; i<n ; i++){
        int u,v;
        cin >> u >> v;
        adj[u].push_back(v);
        adj[v].push_back(u);
    }

    dfs1(1 , -1);
    dfs2(1 , -1);

    for(int i=1 ; i<=n ; i++){
        cout << downAns[i] + upAns[i] << " "; 
    }

    return 0;
}

/**
 * 
 * downAns[i] = summation(downAns[child] + Size[child]);
 * 
 * upAns[i] = (downAns[parent]+upAns[parent]) - (downAns[i] + size[i]) + (n - size[i]) = 
 * 
 */

/**
 * 
 * THIS SOLUTION IS GETTING ACCEPTED , BUT THIS IS NOT THE CODE WHICH DHRUV BHAIYA GAVE , TAKE CLASS CODE FROM SOMEONE. **IMP.
 * 
 */
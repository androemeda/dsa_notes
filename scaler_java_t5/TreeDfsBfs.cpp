#include <iostream>
#include <vector>
#include <algorithm>
#include <set>
#include <map>
#include <queue>
using namespace std;

void dfs(int curr , vector<int> adj[] , int parent){
    cout << curr << " ";
    for(int nb : adj[curr]){
        if(nb != parent){
            dfs(nb , adj , curr); 
        }
    }
}

void bfs(int root , vector<int> adj[]){
    queue<pair<int , int> > q;
    pair<int , int> p;
    p.first = root;
    p.second = 0;
    q.push(p); //curr , parent
    
    while(!q.empty()){
        int curr = q.front().first;
        int parent = q.front().second;
        q.pop();
        cout << curr << " ";
        for(int nb : adj[curr]){
            if(nb != parent){
                pair<int , int> pp ;
                pp.first = nb;
                pp.second = curr;
                q.push(pp);
            }
        }
    }
}

int main(){

    int n;
    cin >> n;

    vector<int> adj[n+1];

    for(int i=1 ; i<n ; i++){
        int u , v;
        cin >> u >> v;
        adj[u].push_back(v);
        adj[v].push_back(u);
    }

    // dfs(1 , adj , 0);
    bfs(1 , adj);
}
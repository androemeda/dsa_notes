#include <iostream>
#include <vector>
#include <algorithm>
#include <set>
#include <map>
#include <queue>
using namespace std;

const int N = 1e5 + 10;
int dp[N][26];

void dfs(int curr , int parent , char ch , vector<vector<int> >& adj , string &s){
    for(int nb : adj[curr]){
        if (nb == parent) continue;
        dfs(nb , curr , ch , adj , s);
        dp[curr][ch - 'a'] += dp[nb][ch-'a'];
    }

    if(s[curr] == ch){
        dp[curr][ch-'a']++;
    }
}

int main(){

    int n , q;
    cin >> n >> q;

    string s;
    cin >> s;

    s = '#' + s; //now everything is one-base indexed.

    vector<vector<int> > adj(n+1);
    for(int i=0 ; i<n-1 ; i++){
        int u , v;
        cin >> u >> v;
        adj[u].push_back(v);
        adj[v].push_back(u);
    }

    for(char ch='a' ; ch<='z' ; ch++){
        dfs(1, 0, ch, adj, s);
    }

    while(q--){
        int node;
        char ch;
        cin >> node >> ch;

        cout << dp[node][ch-'a'] << endl;
    }
}
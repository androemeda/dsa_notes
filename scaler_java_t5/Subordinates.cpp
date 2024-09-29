#include <iostream>
#include <vector>
#include <algorithm>
#include <set>
#include <map>
#include <queue>
using namespace std;

void helper(vector<vector<int> > &adj , int node , vector<int> &ans){
    for(int nb : adj[node]){
        helper(adj , nb , ans);
        ans[node] += ans[nb] + 1;
    }
}

int main(){

    int n;
    cin >> n;

    vector<int> boss(n+1);

    boss[1] = 1;
    for(int i=2 ; i<=n ; i++){
        cin >> boss[i];
    }

    vector<vector<int> > adj(n+1 , vector<int>());

    for(int i=2 ; i<=n ; i++){
        adj[boss[i]].push_back(i);
        // adj[i].push_back(boss[i]);
    }

    // for(int i=1 ; i<=n ; i++){
    //     cout << i << " :";
    //     for(int j=0 ; j<adj[i].size() ; j++){
    //         cout << adj[i][j] << " ";
    //     }
    //     cout << endl;
    // }

    vector<int> ans(n+1);

    helper(adj , 1 , ans);

    for(int i=1 ; i<=n ; i++){
        cout << ans[i] << " ";
    }

    cout << endl;

    return 0;
}
#include <iostream>
#include <vector>
#include <cstring> // for memset
using namespace std;

const int N = 2e5 + 10;
int dp[N][2];

int f(int curr , int parent , bool available , vector<vector<int> >& adj){

    int &ans = dp[curr][available];
    if(ans != -1) return ans;

    //lets not pair with any of its child
    int ans1 = 0;
    for(int nb : adj[curr]){
        if(nb != parent){
            ans1 += f(nb , curr , true , adj);
        }
    }

    //lets pair with any one of its child
    int ans2 = 0;
    if(available){
         for(int nb : adj[curr]){
         if(nb != parent){
             ans2 = max(ans2 , 1+ans1-f(nb , curr , true , adj)+f(nb , curr , false , adj));
         }
        }
    }

    return ans = max(ans1 , ans2);
}

int main(){

    int n;
    cin >> n;

    vector<vector<int> > adj(n+1);

    for(int i=1 ; i<n ; i++){
        int u , v;
        cin >> u >> v;
        adj[u].push_back(v);
        adj[v].push_back(u);
    }

    memset(dp , -1 , sizeof dp);

    cout << f(1 , 0 , true , adj) << endl;
}
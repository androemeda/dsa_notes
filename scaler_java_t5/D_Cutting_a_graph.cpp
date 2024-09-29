#include <iostream>
#include <vector>
#include <algorithm>
#include <set>
#include <map>
using namespace std;

class DSU{
public:

    vector<int> parent;
    vector<int> size;

    DSU(int n){
        parent.assign(n , 0);
        size.assign(n , 1);
        for(int i=0 ; i<n ; i++){
            parent[i] = i;
        }
    }

    int findRoot(int x){
        if(x == parent[x]) return x;
        return parent[x] = findRoot(parent[x]); //path compression
    }   

    void unite(int a , int b){
        a = findRoot(a);
        b = findRoot(b);
        if(a == b) return;

        //ensure size[a] is always greater than size[b]
        if(size[a] < size[b]){
            swap(a, b);
        }

        //merge b to a --> small to large
        parent[b] = a;
        size[a] += size[b];
        
    }
    
};

int main(){

    int v , e , q;
    cin >> v >> e >> q;

    DSU dsu(v+1);

    for(int i=0 ; i<e ; i++){
        int n1 , n2;
        cin >> n1 >> n2;
    }

    vector<vector<int> > queries(q , vector<int>(3));

    for(int i=0 ; i<q ; i++){
        string op;
        cin >> op;
        cin >> queries[i][1] >> queries[i][2];
        
        if(op == "cut") queries[i][0] = 0;
        else queries[i][0] = 1;
    }


    vector<string> ans;

    for(int i=q-1 ; i>=0 ; i--){
        if(queries[i][0] == 0){
            dsu.unite(queries[i][1] , queries[i][2]);
        }
        else{
            if(dsu.findRoot(queries[i][1]) == dsu.findRoot(queries[i][2])) ans.push_back("YES");
            else ans.push_back("NO");
        }
    }

    for(int i=ans.size()-1 ; i>=0 ; i--){
        cout << ans[i] << endl;
    }

    return 0;
}
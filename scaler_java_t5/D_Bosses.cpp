#include <iostream>
#include <vector>
#include <algorithm>
#include <set>
#include <map>
using namespace std;

class DSU{
public:

    vector<int> parent;
    vector<int> wt;

    DSU(int n){
        parent.assign(n , 0);
        wt.assign(n , 0);
        for(int i=0 ; i<n ; i++){
            parent[i] = i;
        }
    }

    pair<int , int> findRoot(int x){
        pair<int , int> ans;
        if(x == parent[x]){
            ans.first = x;
            ans.second = 0;
            return ans;
        }
        pair<int , int> p = findRoot(parent[x]);
        auto root = p.first;
        auto depth = p.second;
        parent[x] = root;
        wt[x] += depth;
        ans.first = parent[x];
        ans.second = wt[x];
        return ans;
    }   

    void unite(int a , int b){
        parent[a] = b;
        wt[a] = 1;
    }
    
};

int main() {
    int n, m;
    cin >> n >> m;

    DSU dsu(n + 1);

    for (int i = 0; i < m; i++) {
        int type;
        cin >> type;
        
        if (type == 1) {
            // Query of type 1: "1 a b" (boss a becomes a subordinate of boss b)
            int a, b;
            cin >> a >> b;
            auto rootA = dsu.findRoot(a).first;
            auto rootB = dsu.findRoot(b).first;
            if (rootA != rootB) {
                dsu.unite(rootA, rootB);
            }
        } else if (type == 2) {
            // Query of type 2: "2 c" (find the number of superiors for employee c)
            int c;
            cin >> c;
            auto res = dsu.findRoot(c);
            cout << res.second << "\n"; // depth is the number of superiors
        }
    }

    return 0;
}

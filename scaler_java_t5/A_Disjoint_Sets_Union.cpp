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

int main() {
    int n, q;
    cin >> n >> q;

    DSU dsu(n + 1);

    for (int i = 0; i < q; ++i) {
        string op;
        int u, v;
        cin >> op >> u >> v;
        if (op == "union") {
            dsu.unite(u, v);
        } else {
            if (dsu.findRoot(u) == dsu.findRoot(v)) {
                cout << "YES" << endl;
            } else {
                cout << "NO" << endl;
            }
        }
    }

    return 0;
}

/**
    either path-compression OR small-to-large both work fine even individually.
 */
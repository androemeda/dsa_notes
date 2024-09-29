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
    vector<int> min;
    vector<int> max;

    DSU(int n){
        parent.assign(n , 0);
        size.assign(n , 1);
        min.assign(n , 0);
        max.assign(n , 0);
        for(int i=0 ; i<n ; i++){
            parent[i] = i;
            min[i] = i;
            max[i] = i;
        }
    }

    int findRoot(int a){
        if(parent[a] == a) return a;
        return parent[a] = findRoot(parent[a]);
    }

    void unite(int a , int b){
        a = findRoot(a);
        b = findRoot(b);

        if(a == b) return;

        if(size[a] < size[b]) swap(a , b); //a is always bigger

        parent[b] = a;
        size[a] += size[b];
        min[a] = std::min(min[a] , min[b]);
        max[a] = std::max(max[a] , max[b]);
    }

    void get(int a){
        a = findRoot(a);
        cout << min[a] << " " << max[a] << " " << size[a] << endl;
    }
};

int main(){

    int n , m;
    cin >> n >> m;

    DSU dsu(n+1);

    for(int i=0 ; i<m ; i++){

        string q;
        cin >> q;

        if(q == "union"){
            int u , v;
            cin >> u >> v;
            dsu.unite(u , v);
        }
        else{
            int u;
            cin >> u;
            dsu.get(u);
        }
    }

    return 0;
}
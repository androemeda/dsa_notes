#include <iostream>
#include <vector>
#include <algorithm>
#include <set>
#include <map>
#include <stack>
#include <initializer_list>
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

    int t;
    cin >> t;

    int caseNo = 0;

    while(t-- > 0){

        caseNo++;

        cout << "Case "<<caseNo<< ":"<<endl;

        int n , q;
        cin >> n >> q;

        vector<int> a(n , 0);

        for(int i=0 ; i<n ; i++){
            cin >> a[i];
        }

        map<int , int> mp;
        for(int i=0 ; i<n ; i++){
            if(mp.count(a[i]) == 0) mp[a[i]] = i;
        }

        DSU dsu(n);

        for(int i=0 ; i<n ; i++){
            dsu.unite(i , mp[a[i]]);
        }

        for(int i=0 ; i<q ; i++){
            int op;
            cin >> op;
            if(op == 1){
                int x , y;
                cin >> x >> y;
                if(mp.count(x) == 0) continue;
                if(mp.count(y) == 0){
                    int root = dsu.findRoot(mp[x]);
                    mp.erase(x);
                    mp[y] = root;
                    a[root] = y;
                    continue;
                }

                int rootX = dsu.findRoot(mp[x]);
                int rootY = dsu.findRoot(mp[y]);

                dsu.unite(rootX , rootY);

                int root = dsu.findRoot(rootX);

                mp.erase(x);

                mp[y] = root;

                a[root] = y;
            }
            else{
                int idx;
                cin >> idx;
                idx = dsu.findRoot(idx - 1);
                cout << a[idx] << endl;
            }
        }
    }
}
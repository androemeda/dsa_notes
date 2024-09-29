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

void solve(){

    int n , q;
    cin >> n >> q;

    vector<vector<int> > queries(q, vector<int>(3 , 0));
    for(int i=0 ; i<q ; i++){
        int l,r,x;
        cin >> l;
        cin >> r;
        cin >> x;
        queries[i][0] = l-1; 
        queries[i][1] = r-1; 
        queries[i][2] = x; 
    }

    set<int> st; //unpainted indices

    for(int i=0 ; i<n ; i++){
        st.insert(i);
    }
    
    vector<int> ans(n);

    for(int i=q-1 ; i>=0 ; i--){
        int l = queries[i][0] , r = queries[i][1] , x = queries[i][2];

        auto it = st.lower_bound(l);

        if(it == st.end() or *it > r){
            break;
        }

        ans[*it] = x;
        st.erase(*it);

    }

    for(int i=0 ; i<n ; i++){
        cout << ans[i] << "\n";
    }
}

int main(){

    solve();

    return 0;
}
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
    int components;
    stack<vector<int> > st;
    
    DSU(int n){
        parent.assign(n , 0);
        size.assign(n , 1);
        for(int i=0 ; i<n ; i++){
            parent[i] = i;
        }
        components = n;
    }

    int findRoot(int x){
        if(x == parent[x]) return x;
        return findRoot(parent[x]); //no path-compression because we dont want to modify our tree
    }

    void unite(int a , int b){
        a = findRoot(a);
        b = findRoot(b);
        if(a == b) return;

        //ensure size[a] is always greater than size[b]
        if(size[a] < size[b]){
            swap(a, b);
        }
        // vector<int> temp = {a , b , size[a] , size[b]};
        vector<int> temp;

        temp.push_back(a);
        temp.push_back(b);
        temp.push_back(size[a]);
        temp.push_back(size[b]);
        
        st.push(temp);

        //merge b to a --> small to large
        parent[b] = a;
        size[a] += size[b];
        
        components--;
    }

    void persist(){
        vector<int> t;
        t.push_back(-1);
        st.push(t);
    }

    void rollback(){
        while(st.size() and st.top()[0] != -1){
            auto diff = st.top();
            st.pop();

            int a = diff[0] , b = diff[1];
            int sz_a = diff[2] , sz_b = diff[3];

            parent[a] = a;
            parent[b] = b;
            size[a] = sz_a;
            size[b] = sz_b;

            components++;
        }
        //removing checkpoint
        st.pop();
    }
    
};

int main(){

    int n , q;
    cin >> n >> q;

    DSU dsu(n+1);

    for(int i=0 ; i<q ; i++){
        string op;
        cin >> op;
        if(op == "union"){
            int u , v;
            cin >> u >> v;
            dsu.unite(u , v);
            cout << dsu.components-1 << endl;
        }
        else if(op == "persist"){
            dsu.persist();
        }
        else{
            dsu.rollback();
            cout << dsu.components-1 << endl; 
        }
    }
}

/**
here we wont do path compression because then it would be very hard for us to undo the operations.
use only small to large.
 */
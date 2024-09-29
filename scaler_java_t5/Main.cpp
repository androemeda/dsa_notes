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
    stack<vector<int> > st;
    int components;

    DSU(int n){
        parent.assign(n , 0);
        size.assign(n , 1);
        components = n;
        for(int i=0 ; i<n ; i++){
            parent[i] = i;
        }
    }

    int findRoot(int x){
        if(x == parent[x]) return x;
        return findRoot(parent[x]);
    }

    void unite(int x , int y){
        x = findRoot(x);
        y = findRoot(y);

        if(x == y) return;

        if(size[x] < size[y]) swap(x , y);

        vector<int> temp;
        temp.push_back(x);
        temp.push_back(y);
        temp.push_back(size[x]);
        temp.push_back(size[y]);

        st.push(temp);

        parent[y] = x;
        size[x] += size[y];

        components--;
    }

    void persisit(){
        vector<int> p;
        p.push_back(-1);
        st.push(p);
    }

    void rollback(){
        while(st.size() and st.top()[0] != -1){
            vector<int> diff = st.top();
            st.pop();

            int a = diff[0];
            int b = diff[1];
            int sz_a = diff[2];
            int sz_b = diff[3];

            parent[a] = a;
            parent[b] = b;
            size[a] = sz_a;
            size[b] = sz_b;

            components++;
        }
        st.pop();
    }
};

int main(){
    
    int n , m;
    cin >> n >> m;

    DSU dsu(n+1);

    for(int i=0 ; i<m ; i++){
        string s;
        cin >> s;

        if(s == "union"){
            int u , v;
            cin >> u >> v;
            dsu.unite(u , v);
            cout << dsu.components-1 << endl;
        }
        else if(s == "persist"){
            dsu.persisit();
        }
        else{
            dsu.rollback();
            cout << dsu.components-1 << endl;
        }
    }
}
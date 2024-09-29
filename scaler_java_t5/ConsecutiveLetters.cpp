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

    int ts;
    cin >> ts;

    for(int t=1 ; t<=ts ; t++){

        cout << "Case " << t <<":\n";

        string s;
        cin >> s;
        int n = s.size();

        string original = s;

        int q;
        cin >> q;

        vector<pair<int,int> > queries(q);
        for(int i=0 ; i<q ; i++){
            int op , idx;
            cin >> op >> idx;

            if(op == 2) s[idx] = '#';
            queries[i].first = op;
            queries[i].second = idx;
        }

        DSU dsu(n);

        for(int i=0 ; i<n ; i++){
            if(s[i] == '#') continue;
            if(i-1 >= 0 and s[i] == s[i-1]) dsu.unite(i , i-1);
            if(i+1 < n and s[i] == s[i+1]) dsu.unite(i , i+1);
        }

        reverse(queries.begin(),  queries.end());

        vector<int> ans;

        for(int i=0 ; i<q ; i++){
            auto op = queries[i].first;
            auto idx = queries[i].second;

            if(op == 1){
                ans.push_back(dsu.size[dsu.findRoot(idx)]);
            }
            else{
                s[idx] = original[idx];
                if(idx-1 >= 0 and s[idx] == s[idx-1]) dsu.unite(idx , idx-1);
                if(idx+1 < n and s[idx] == s[idx+1]) dsu.unite(idx , idx+1);
            }
        }

        reverse(ans.begin(),  ans.end());

        for(int x : ans){
            cout << x << "\n";
        }

    }

    return 0;
}

/**
 * 
 * process in reverse order
 * 
 * ***** 0 ≤ b ≤ i ≤ e < |S|
 */
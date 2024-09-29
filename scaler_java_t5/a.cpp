#include <iostream>
#include <stack>
#include <vector>
using namespace std;
int main(){
    int n;
    cin >> n;
    stack<vector<int> > st; 

    vector<int> A ;
    A.push_back(1);
    st.push(A);
    st.push({4, 5, 6});
}
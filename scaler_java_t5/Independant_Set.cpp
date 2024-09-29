#include <iostream>
#include <vector>
#include <cstring> // for memset
using namespace std;

enum Color { Black = 0, White = 1 };

const int mod = 1e9 + 7;
const int N = 1e5 + 10;

int dp[N][2];

int f(int curr, int parent, int color, vector<vector<int>> &adj) {
    int &ans = dp[curr][color];
    if (ans != -1) return ans;

    // If the current node is painted white
    int ans1 = 1;
    for (int nb : adj[curr]) {
        if (nb != parent) {
            ans1 = (1LL * ans1 * f(nb, curr, White, adj)) % mod;
        }
    }

    // If the current node is painted black
    int ans2 = 0;
    if (color == White) {
        ans2 = 1;
        for (int nb : adj[curr]) {
            if (nb != parent) {
                ans2 = (1LL * ans2 * f(nb, curr, Black, adj)) % mod;
            }
        }
    }

    return ans = (ans1 + ans2) % mod;
}

int main() {
    int n;
    cin >> n;

    vector<vector<int>> adj(n + 1);
    for (int i = 0; i < n - 1; i++) {
        int u, v;
        cin >> u >> v;
        adj[u].push_back(v);
        adj[v].push_back(u);
    }

    memset(dp, -1, sizeof dp);

    cout << f(1, 0, White, adj) << endl;

    return 0;
}

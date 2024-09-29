#include <bits/stdc++.h>
using namespace std;

#define int long long

class NumArray {
    vector<int> tree;
    int identity = numeric_limits<int>::max(); // Use numeric_limits<int>::max() for the min range query identity
    int size;

    void buildTree(vector<int>& nums, int treeIndex, int left, int right) {
        if (left == right) {
            tree[treeIndex] = nums[left];
            return;
        }
        int mid = left + (right - left) / 2;
        buildTree(nums, 2 * treeIndex + 1, left, mid);
        buildTree(nums, 2 * treeIndex + 2, mid + 1, right);
        tree[treeIndex] = minQuery(tree[2 * treeIndex + 1], tree[2 * treeIndex + 2]);
    }

    void updateHelper(int treeIndex, int left, int right, int index, int value) {
        if (left == right) {
            tree[treeIndex] = value;
            return;
        }
        int mid = left + (right - left) / 2;
        if (index <= mid) {
            updateHelper(2 * treeIndex + 1, left, mid, index, value);
        } else {
            updateHelper(2 * treeIndex + 2, mid + 1, right, index, value);
        }
        tree[treeIndex] = minQuery(tree[2 * treeIndex + 1], tree[2 * treeIndex + 2]);
    }

    int minRangeHelper(int treeIndex, int left, int right, int queryLeft, int queryRight) {
        if (queryLeft > right || queryRight < left) return identity;
        if (queryLeft <= left && right <= queryRight) return tree[treeIndex];
        int mid = left + (right - left) / 2;
        return minQuery(minRangeHelper(2 * treeIndex + 1, left, mid, queryLeft, queryRight),
                        minRangeHelper(2 * treeIndex + 2, mid + 1, right, queryLeft, queryRight));
    }

    int minQuery(int a, int b) {
        return min(a, b);
    }

public:
    NumArray(vector<int>& nums) {
        this->size = nums.size();
        tree.resize(4 * size, identity);
        buildTree(nums, 0, 0, size - 1);
    }

    void update(int index, int val) {
        updateHelper(0, 0, size - 1, index, val);
    }

    int minRange(int left, int right) {
        return minRangeHelper(0, 0, size - 1, left, right);
    }
};

signed main() {
    ios::sync_with_stdio(false);
    cin.tie(0);

    int n, q;
    cin >> n >> q;

    vector<int> nums(n + 1);
    for (int i = 1; i <= n; ++i) {
        cin >> nums[i];
    }

    vector<pair<int, int>> queries(q);
    for (int i = 0; i < q; ++i) {
        cin >> queries[i].first >> queries[i].second;
    }

    NumArray obj(nums);

    for (int i = 0; i < q; ++i) {
        cout << obj.minRange(queries[i].first, queries[i].second) << "\n";
    }

    return 0;
}

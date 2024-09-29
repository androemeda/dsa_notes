#include <iostream>
#include <vector>
#include <climits>

#define int long long

using namespace std;

class NumArray {
private:
    vector<int> tree;
    int identity = INT_MAX; // Use INT_MAX for the min range query identity
    int size;

public:
    NumArray(vector<int>& nums) {
        size = nums.size();
        tree.resize(4 * size, identity);
        buildTree(nums, 0, 0, size - 1);
    }

    // Build the segment tree
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

    void update(int index, int val) {
        updateHelper(0, 0, size - 1, index, val);
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

    int minRange(int left, int right) {
        return minRangeHelper(0, 0, size - 1, left, right);
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
};

signed main() {
    int n, q;
    cin >> n >> q;

    vector<int> nums(n + 1);
    for (int i = 1; i <= n; ++i) {
        cin >> nums[i];
    }

    vector<vector<int>> queries(q, vector<int>(3));
    for (int i = 0; i < q; ++i) {
        cin >> queries[i][0] >> queries[i][1] >> queries[i][2];
    }

    NumArray obj(nums);

    for (int i = 0; i < q; ++i) {
        if (queries[i][0] == 2) {
            cout << obj.minRange(queries[i][1], queries[i][2]) << endl;
        }
        if (queries[i][0] == 1) {
            obj.update(queries[i][1], queries[i][2]);
        }
    }

    return 0;
}

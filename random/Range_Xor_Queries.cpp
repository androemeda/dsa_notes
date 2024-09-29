#include <iostream>
#include <vector>
#include <climits>

using namespace std;

class NumArray {
private:
    vector<int> tree;
    int identity = 0; // Use 0 for XOR operation identity
    int size;

public:
    NumArray(vector<int>& nums) {
        size = nums.size();
        tree.resize(4 * size);
        fill(tree.begin(), tree.end(), identity);
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
        return a ^ b; // XOR operation for minimum query
    }
};

int main() {
    int n, q;
    cin >> n >> q;

    vector<int> nums(n + 1);
    for (int i = 1; i <= n; i++) {
        cin >> nums[i];
    }

    vector<vector<int>> queries(q, vector<int>(2));
    for (int i = 0; i < q; i++) {
        cin >> queries[i][0] >> queries[i][1];
    }

    NumArray obj(nums);

    for (int i = 0; i < q; i++) {
        cout << obj.minRange(queries[i][0], queries[i][1]) << endl;
    }

    return 0;
}

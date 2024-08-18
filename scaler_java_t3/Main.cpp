#include <iostream>
#include <vector>

using namespace std;

int main() {
    long long n, q;
    cin >> n >> q;

    vector<long long> arr(n);
    for(long long i = 0; i < n; i++) {
        cin >> arr[i];
    }

    for(long long i = 1; i < n; i++) {
        arr[i] += arr[i - 1];
    }

    for(long long i = 0; i < q; i++) {
        long long left, right;
        cin >> left >> right;

        if(left == 1) {
            cout << arr[right - 1] << endl;
        } else {
            cout << arr[right - 1] - arr[left - 2] << endl;
        }
    }

    return 0;
}

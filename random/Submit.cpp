#include <iostream>
using namespace std;

class Exponentiation {
public:
    static const int mod = 1000000007;

    static long long expo(long long a, long long b) {
        if (b == 0) {
            return 1LL;
        }
        if (b == 1) {
            return (a * 1LL) % mod;
        }
        if (b % 2 == 0) {
            long long ans = expo(a, b / 2);
            return ((ans % mod) * (ans % mod)) % mod;
        } else {
            long long ans = expo(a, b / 2);
            return (((ans % mod) * (ans % mod)) % mod * (a % mod)) % mod;
        }
    }
};

int main() {
    int n;
    cin >> n;

    while (n > 0) {
        long long a, b;
        cin >> a >> b;

        long long ans = Exponentiation::expo(a * 1LL, b * 1LL);
        cout << ans % Exponentiation::mod << endl;

        n--;
    }

    return 0;
}

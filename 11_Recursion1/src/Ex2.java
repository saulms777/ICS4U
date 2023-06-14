class Ex2 {

    // t1 = 10, tn = tn-1 + 3 for n > 1
    static int a(int n) {
        if (n < 1) return -1;
        if (n == 1) return 10;
        return a(n - 1) + 3;
    }

    // t1 = 5, tn = tn-1 * 3 for n > 1
    static int b(int n) {
        if (n < 1) return -1;
        if (n == 1) return 5;
        return b(n - 1) * 3;
    }

    // t1 = 256, tn = tn-1 / 2 for n > 1
    static double c(double n) {
        if (n < 1.0) return -1.0;
        if (n == 1.0) return 256;
        return c(n - 1) / 2.0;
    }

}

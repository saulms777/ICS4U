class Ex1 {

    // 3, 5, 7, 9, 11
    static int a(int n) {
        if (n < 1) return -1;
        if (n == 1) return 3;
        return a(n - 1) + 2;
    }

    // 2, 3, 5, 8, 12
    static int b(int n) {
        if (n < 1) return -1;
        if (n == 1) return 2;
        return b(n - 1) + n - 1;
    }

    // 1, 2, 3, 5, 8
    static int c(int n) {
        if (n < 1) return -1;
        if (n == 1) return 1;
        if (n == 2) return 2;
        return c(n - 2) + c(n - 1);
    }

}

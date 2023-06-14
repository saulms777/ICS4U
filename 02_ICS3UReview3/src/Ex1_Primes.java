class Ex1_Primes {

    private static int[] primes = {
        2, 3, 5, 7, 11,
        13, 17, 19, 23, 29,
        31, 37, 41, 43, 47,
        53, 59, 61, 67, 71
    };

    public static void main(String[] args) {
        for (int num : primes) {
            if (num > 10) System.out.println(num);
        }
        otherPrimes();
        round();
    }

    private static void otherPrimes() {
        for (int i = 0; i < primes.length; i += 2) {
            System.out.println(primes[i]);
        }
    }

    private static void round() {
        for (int num : primes) {
            System.out.println(num + 5 / 10);
        }
    }

}
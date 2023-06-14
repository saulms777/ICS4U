class Main {

    static void rowReduce(double[][] arr) {
        if (arr.length + 1 != arr[0].length) throw new IllegalArgumentException();

        for (int var = 0; var < arr.length - 1; var++) {
            for (int row = var + 1; row < arr.length; row++) {
                double n = -arr[row][var] / arr[var][var];
                for (int i = 0; i < arr[row].length; i++) {
                    arr[row][i] += n * arr[var][i];
                }
            }
        }

        for (int var = arr.length - 1; var >= 0; var--) {
            for (int row = var - 1; row >= 0; row--) {
                double n = -arr[row][var] / arr[var][var];
                for (int i = 0; i < arr[row].length; i++) {
                    arr[row][i] += n * arr[var][i];
                }
            }
            double n = 1 / arr[var][var];
            for (int i = 0; i < arr[var].length; i++) {
                arr[var][i] *= n;
            }
        }
    }

}

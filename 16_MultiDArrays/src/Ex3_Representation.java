/*

[
 [[10, 11],
  [12, 13]],

 [[14, 15],
  [16, 17]],

 [[18, 19],
  [20, 21]]
]

*/


class Ex3_Representation {

    static int[][][] a = {
            {{10, 11}, {12, 13}},
            {{14, 15}, {16, 17}},
            {{18, 19}, {20, 21}}
    };

    static void b() {
        for (int[][] arr : a) {
            for (int[] row : arr) {
                for (int el : row) System.out.print(el + " ");
                System.out.println();
            }
            System.out.println();
        }
    }

    static void c() {
        for (int i = 0; i < a[0][0].length; i++) {
            for (int[][] arr : a) {
                for (int k = 0; k < a[0].length; k++) System.out.print(arr[k][i] + " ");
                System.out.println();
            }
            System.out.println();
        }
    }

}

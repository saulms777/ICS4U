import java.util.Arrays;

class Ex2_Sequence {
    
    public static void main(String[] args) {
        double[] arr = new double[10];

        for (int i = 0; i < 10; i++) arr[i] = i + 1.0;
        System.out.println(Arrays.toString(arr));

        for (int i = 0; i < 10; i++) arr[i] = 1.0 / arr[i];
        System.out.println(Arrays.toString(arr));

        for (int i = 0; i < 10; i++) arr[i] *= arr[i];
        System.out.println(Arrays.toString(arr));
    }

}

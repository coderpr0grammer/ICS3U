public class Arrays {
    public static void main(String[] args) {
        int[] a = {1, 2, 3};

        int[] b = {4, 5};

        a = b;

        a[0] = 10;

        System.out.println(a[0]);
        System.out.println(b[0]);
    }
}

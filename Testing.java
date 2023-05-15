public class Testing {
    public static void main(String[] args) {
        int[] array = { 1, 2, 3 };

        int[] biggerArray = new int[4];

        for (int i = 0; i< array.length; i++) {
            biggerArray[i] = array[i];
        }

        biggerArray[biggerArray.length - 1] = 4;

        System.out.println(biggerArray[3]);

    }
}

public class ArrayAccess {

    static int safeGet(int[] arr, int index) {
        try {
            return arr[index];
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Bad index " + index + ": " + e.getMessage());
            return -1; // sentinel value
        }
    }

    public static void main(String[] args) {
        int[] data = {10, 20, 30, 40, 50};

        System.out.println("data[0] = " + safeGet(data, 0));
        System.out.println("data[4] = " + safeGet(data, 4));
        System.out.println("data[7] = " + safeGet(data, 7));
        System.out.println("data[-1] = " + safeGet(data, -1));

        // Null array also possible
        int[] nullArr = null;
        try {
            System.out.println(nullArr[0]);
        } catch (NullPointerException e) {
            System.out.println("Array is null");
        }
    }
}
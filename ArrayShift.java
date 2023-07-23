import java.util.Arrays;

public class ArrayShift {
    public static void cyclicShift(int[] arr, int n) {
        int length = arr.length;
        n = n % length; // Убедимся, что n находится в пределах длины массива

        if (n < 0) {
            // Для отрицательного значения n выполняем циклический сдвиг влево
            n = length + n;
        }

        int[] shiftedArr = new int[length];

        for (int i = 0; i < length; i++) {
            int newIndex = (i + n) % length;
            shiftedArr[newIndex] = arr[i];
        }

        // Копируем элементы из shiftedArr обратно в исходный массив arr
        System.arraycopy(shiftedArr, 0, arr, 0, length);
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 5, 54, 5, 12, 465, 25};
        int n = -2;

        System.out.println("Исходный массив: " + Arrays.toString(arr));
        cyclicShift(arr, n);
        System.out.println("Массив после циклического сдвига на " + n + " позиций: " + Arrays.toString(arr));
    }
}

import java.util.Arrays;

public class CountingSort {

    public static void countingSort(int[] arr) {
        // Проверяем, что массив не пустой
        if (arr == null || arr.length == 0) {
            return;
        }
        int maxValue = 1000; // Максимальное значение элемента в исходном массиве
        int[] counts = new int[maxValue + 1]; // Шаг 1: Создаем вспомогательный массив для подсчета количества повторений каждого элемента
        for (int num : arr) { // Шаг 2: Подсчитываем количество каждого элемента в исходном массиве
            counts[num]++;
        }
        int index = 0;
        for (int i = 0; i <= maxValue; i++) { // Шаг 3: Заполняем новый отсортированный массив на основе подсчитанных значений
            while (counts[i] > 0) {
                arr[index] = i;
                index++;
                counts[i]--;
            }
        }
    }

    public static void main(String[] args) {
        int[] x = {2, 1, 0, 4, 3, 0, 0, 1, 2};

        System.out.println("Исходный массив: " + Arrays.toString(x));
        countingSort(x);
        System.out.println("Отсортированный массив: " + Arrays.toString(x));
    }
}

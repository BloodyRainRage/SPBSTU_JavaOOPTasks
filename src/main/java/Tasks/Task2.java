package Tasks;

import java.util.*;

public class Task2 implements Task {

//    2.	Дана матрица. В каждой строке найти наибольший элемент.
//          Из этих элементов найти наименьший и удалить ту строку, которой он принадлежит.
//          Вывести исходную и получившуюся матрицы в консоль.

    Random random = new Random();

    @Override
    public void execute() {
        System.out.println("----Task 2----");

        List<List<Integer>> matrix = new ArrayList<>();
        System.out.println("Array after init");
        for (int i = 0; i < 10; i++) {
            matrix.add(new ArrayList<>());
            for (int j = 0; j < 10; j++) {
                matrix.get(i).add(random.nextInt(50));
                System.out.print(matrix.get(i).get(j) + " ");
            }
            System.out.println();

        }

        System.out.println("Array after");
        int line = find(matrix);

        if (line != -1){
            matrix.remove(line);
        }

        System.out.println();
        print(matrix);
        System.out.println("-----END------");
    }

    private int find(List<List<Integer>> input) {
        int max;
        List<Integer> maximums = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            max = input.get(i).get(0);
            for (int j = 0; j < 10; j++) {
                if (input.get(i).get(j) > max)
                    max = input.get(i).get(j);
            }
            maximums.add(max);
        }
        int min = maximums.get(0);
        int line = -1;
        for (int i = 0; i < maximums.size(); i++) {
            if (maximums.get(i) < min) {
                min = maximums.get(i);
                line = i;
            }
        }
        System.out.println("\nLine " + line + " value " + min);
        return line;
    }


    private void print(List<List<Integer>> array) {
        for (int i = 0; i < array.size(); i++) {
            for (int j = 0; j < array.get(i).size(); j++) {
                System.out.print(array.get(i).get(j) + " ");
            }
            System.out.println();
        }
    }

}

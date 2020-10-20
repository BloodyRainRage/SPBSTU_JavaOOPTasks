package Tasks;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Task5 implements Task {

//  5.	Пользователь вводит некоторое число. Записать его цифры в стек.
//      Вывести число, у которого цифры идут в обратном порядке.
//      Предусмотреть возможность введения произвольного количества чисел.

    private Deque<Object> stack = new ArrayDeque<>();

    @Override
    public void execute() {

        try (Scanner scanner = new Scanner(System.in)) {

            System.out.println("Type 'exit' to break the loop");
            while (true) {

                System.out.print("enter value ");
                String input = scanner.nextLine();
                if (input.equals("exit")) break;
                Integer val;
                try {
                    //input = checkForNulls(input);
                    val = Integer.parseInt(input);

                } catch (NumberFormatException e) {
                    e.printStackTrace();
                    continue;
                }

                saveNumberToDeque(val, startsWithAmountNulls(input));
                //stack.push(val);
            }

        } catch (NoSuchElementException e) {
            System.out.println("No input found");
            e.printStackTrace();
        }

        while (!stack.isEmpty()) {
//                Integer val = (Integer) stack.pop();
            Object val = getNextValFromDeq();
            if (val instanceof String) continue;
            System.out.println(new StringBuilder(val.toString()).reverse().toString());
        }

    }

    private int startsWithAmountNulls(String input){
        int count = 0;
        while (input.startsWith("0")){
            count++;
            input = input.substring(1);
        }

        return count;

    }

    private Object getNextValFromDeq() throws ClassCastException{
        int dec = 10;
        Object val = stack.pop();
        if (val instanceof String) return "";
        Integer output = (Integer) val;
        while ((val instanceof Integer) && !stack.isEmpty()){
            val = stack.pop();
            if (val instanceof String) break;
            output = output * dec + (Integer) val;
        }

        return output;
    }

    private void saveNumberToDeque(Integer num, int amountOfNulls) {
        System.out.println("amount " + amountOfNulls);
        while (num > 0) {
            stack.push(num % 10);
            num /= 10;
        }

        for (int i = 0; i <= amountOfNulls; i++) stack.push(0);

        stack.push("");
    }

}

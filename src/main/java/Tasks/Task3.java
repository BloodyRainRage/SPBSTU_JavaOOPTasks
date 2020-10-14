package Tasks;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Task3 implements Task {

    //3.	Дана строка. Разделить строку на фрагменты по три подряд идущих символа.
//      В каждом фрагменте средний символ заменить на случайный символ, не совпадающий ни с
//      одним из символов этого фрагмента. Вывести в консоль фрагменты, упорядоченные по алфавиту.
    Random random = new Random();

    @Override
    public void execute() {
        System.out.println("----Task 3----");
        String str = "qweewqryutqw";
        if (str.length() % 3 == 2) {
            str += " ";
        } else if (str.length() % 3 == 1) str += "  ";

        System.out.println(str.length() % 3);
//        if (str.length() % 3)

        List<String> symbols = new ArrayList<>();

        for (int i = 0; i < str.length(); i += 3) {
            symbols.add(str.substring(i, i + 3));
        }

        System.out.println(symbols);

        for (int i = 0; i < symbols.size(); i++) {
            char[] tmp = symbols.get(i).toCharArray();
            char ch = (char) random.nextInt(random.nextInt(92) + 32);
            while (symbols.get(i).contains(String.valueOf(ch))) {
                tmp[1] = (char) random.nextInt(random.nextInt(92) + 32);
            }
            symbols.set(i, new String(tmp));
        }


        System.out.println(symbols);

        Collections.sort(symbols);
        System.out.println(symbols);

        System.out.println("-----END------");
    }


}

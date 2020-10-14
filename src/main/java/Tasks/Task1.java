package Tasks;

import java.util.*;

public class Task1 implements Task{

//    1.	Дан массив без повторяющихся элементов.
//          Перемешать его элементы случайным образом так, чтобы каждый
//          элемент оказался на новом месте. Вывести исходный и получившийся массивы в консоль.

    Random random = new Random();

    @Override
    public void execute(){
        System.out.println("----Task 1----");
        List<Integer> list = new ArrayList<>(10);
        for (int i = 0; i < 10; i++) {
            list.add(i, i);
        }
        System.out.println("Start array");
        System.out.println(list);
        shuffle(list, random);

        System.out.println("Edited array");
        System.out.println(shuffle(list, random));

        System.out.println("Reshuffled using Collections.shuffle()");
        Collections.shuffle(list, random);
        System.out.println(list);

        System.out.println("-----END------");
    }

    public List<Integer> shuffle(List<Integer> list, Random rnd) {
        List<Integer> tmp = new ArrayList<>(list);
        int size = list.size();

        while (checkIfFullyShuffled(list, tmp)) {
            System.out.println(checkIfFullyShuffled(list, tmp));
            if (size < 5 || list instanceof RandomAccess) {
                for (int i = 0; i < list.size(); i++) {
                    Collections.swap(tmp, i, rnd.nextInt(i + 1));
                }
            }
        }

        return tmp;
    }

    private boolean checkIfFullyShuffled(List<Integer> list, List<Integer> shuffled){
        for (int i = 0; i < list.size(); i++){
            if (!list.get(i).equals(shuffled.get(i))) return false;
        }

        return true;
    }

    //just for sure
    public static void swap(List<Integer> list, int i, int j) {
        Integer tmp = list.get(i);
        list.set(i, list.get(j));
        list.set(j, tmp);
    }

}

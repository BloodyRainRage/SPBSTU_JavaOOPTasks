package Tasks;

import org.w3c.dom.ls.LSOutput;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Task7 implements Task {

//    7.	С использованием streamAPI реализовать следующие методы:
//          a.	метод, возвращающий среднее значение списка целых чисел
//          b.	метод, приводящий все строки в списке в верхний регистр
//          c.	метод возвращающий список квадратов всех уникальных элементов списка

    Random random = new Random();
    @Override
    public void execute() {
        System.out.println("----Task 7----");

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 10; i++){
            list.add(random.nextInt(20));
        }
        System.out.println(list);
        System.out.println("Average value " + avg(list));

        List<String> stringList = new LinkedList<>();
        stringList.add("qweqeEEQweq");
        stringList.add("jsao JIFJDfd 123123");
        stringList.add("64 !!! fdas ///");
        System.out.println(stringList);


        System.out.println(toUpperCase(stringList));

        List<Integer> integerList = Arrays.asList(0, 0, 1, 1, 2, 3, 3, 4, 5);

        System.out.println(integerList);

        System.out.println(sqrUnique(integerList));

        System.out.println("-----END------");
    }

    public List<String> toUpperCase(List<String> list){

        if (list == null) throw  new NullPointerException("list " + list + " is null");

        return list.stream()
                    .map(String::toUpperCase)
                    .collect(Collectors.toList());
    }

    public List<Double> sqrUnique(List<Integer> list){
        if (list == null) throw  new NullPointerException("list " + list + " is null");

        return list.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet()
                .stream()
                .filter(n -> n.getValue() == 1)
                .map(n -> Math.pow(n.getKey(), 2))
                .collect(Collectors.toList());
    }

    public Double avg(List<Integer> integerList){

        if (integerList == null) throw  new NullPointerException("list " + integerList + " is null");

        return integerList.stream()
                            .mapToInt(Integer::intValue)
                            .average().getAsDouble();
    }
}

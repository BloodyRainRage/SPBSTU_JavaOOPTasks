package Tasks;

import Tasks.Task8pack.CustomAnnotation;
import Tasks.Task8pack.TaskClass;

import java.lang.reflect.*;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Task8 implements Task {

//    8.	Написать аннотацию с целочисленным параметром. Создать класс, содержащий только
//          приватные методы (3-4шт), аннотировать любые из них. Вызвать из другого класса все
//          аннотированные методы столько раз, сколько указано в параметре аннотации.


    @Override
    public void execute() {

        try {
            Object reflectedClass = Class.forName("Tasks.Task8pack.TaskClass").getDeclaredConstructor().newInstance();

            Method[] methods = Class.forName("Tasks.Task8pack.TaskClass").getDeclaredMethods();

            for (Method method : methods) {

                if (method.isAnnotationPresent(CustomAnnotation.class) && Modifier.isPrivate(method.getModifiers())) {
                    method.setAccessible(true);
                    int num = method.getAnnotation(CustomAnnotation.class).key();
                    for (int i = 0; i < num; i++)
                        method.invoke(reflectedClass);
                }
            }

        } catch (ClassNotFoundException | IllegalAccessException | InvocationTargetException |
                    InstantiationException | NoSuchMethodException e) {
            e.printStackTrace();
        }

    }
}

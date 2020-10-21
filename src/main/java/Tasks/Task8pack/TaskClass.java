package Tasks.Task8pack;

public class TaskClass {

    @CustomAnnotation(key = 10)
    private int privateAnnotatedIntMethod() {
        System.out.println("privateIntFunction call");
        return 1;
    }

    private void notAnnotatedMethod() {
        System.out.println("Not annotated method call");
    }

    @CustomAnnotation(key = 2)
    private void annotatedMethod() {
        System.out.println("Annotated method call");
    }

    @CustomAnnotation
    private String anotherAnnotatedMethod() {
        System.out.println("Another annotated method call");
        return "qwe";
    }

    public void test(){
        System.out.println("test");
    }


}

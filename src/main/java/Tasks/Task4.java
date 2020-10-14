package Tasks;

public class Task4 implements Task {

//    4.	Описать класс, представляющий треугольник.
//          Предусмотреть методы для создания объектов, вычисления площади,
//          периметра и точки пересечения медиан. Описать свойства для получения состояния объекта.


    @Override
    public void execute() {
        System.out.println("----Task 4----");

        Triangle triangle = new Triangle(new Point(0, 0),
                                            new Point(0, 2),
                                            new Point(2, 0));

        System.out.println("Triangle area " + triangle.getArea());
        System.out.println("Triangle perimeter " + triangle.getPerimeter());
        System.out.println("Triangle meridian cross " + triangle.getMeridianCross().toString());

        System.out.println(triangle.toString());

        System.out.println("-----END------");
    }

    public class Triangle {

        double ab, bc, ac;

        Point a, b, c;

        public Triangle() {

        }

        public Triangle(Point a, Point b, Point c) {
            this.a = a;
            this.b = b;
            this.c = c;

            this.ab = a.getDistance(b);
            this.ac = a.getDistance(c);
            this.bc = b.getDistance(c);
        }

        public Triangle(double ab, double bc, double ac) {
            this.ab = ab;
            this.bc = bc;
            this.ac = ac;
        }

        public Double getPerimeter() {
            return ab + bc + ac;
        }

        public Double getArea() {
            //Heron's formula
            double p = (ab + bc + ac) / 2;
            return Math.sqrt(p * (p - ab) * (p - bc) * (p - ac));
        }

        public Point getMeridianCross(){
            return new Point((a.x + b.x + c.x)/3,
                             (a.y +b.y + c.y)/3);
        }

        public double getAb() {
            return ab;
        }

        public void setAb(double ab) {
            this.ab = ab;
        }

        public double getBc() {
            return bc;
        }

        public void setBc(double bc) {
            this.bc = bc;
        }

        public double getAc() {
            return ac;
        }

        public void setAc(double ac) {
            this.ac = ac;
        }

        @Override
        public String toString(){
            return  "A " + this.a.toString()+ "\n" +
                    "B " + this.b.toString()+ "\n" +
                    "C " +this.c.toString() + "\n" +
                    "AB = " + a.getDistance(b) + "\n" +
                    "BC = " + b.getDistance(c) + "\n" +
                    "AC = " + a.getDistance(c);
        }

    }

    public class Point {

        double x, y;

        public Point(double x, double y) {
            this.x = x;
            this.y = y;
        }

        public Double getDistance(Point point) {
            return Math.sqrt(Math.pow((point.x - this.x), 2)
                    + Math.pow((point.y - this.y), 2));
        }

        @Override
        public String toString(){
            return "(" + this.x + "; " + this.y +")";
        }
    }
}

package eecs1022.lab6;

/**
 * Created by user on 3/28/18.
 */
public class Point
{
    double x;
    double y;
    Point(double x, double y){
        this.x = x;
        this.y = y;
    }



    public static void main(String[] args){
        Point p1 = new Point(3,4);

        Point p2 = new Point(5,6);
        System.out.println("p2.x is" + p2.x);
        System.out.println("p1.x is" + p1.x);

        System.out.println();
        p1 = p2;
        System.out.println("p2.x is" + p2.x);
        System.out.println("p1.x is" + p1.x);
    }
}

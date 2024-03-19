// Q3. Write a Java program that defines a 'Point' class with attributes 'X' and 'Y', and includes a 
// parameterized constructor to initialize these attributes. Implement a copy constructor to 
// create a new point object with the same attribute values. Ensure that modifications made to one 
// object do not affect the other. Utilize getter and setter methods to retrieve and update the 
// attribute values.

public class Point {
    private int x;
    private int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Point(Point point) {
        this.x = point.x;
        this.y = point.y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public static void main(String[] args) {
        Point obj = new Point(2, 3);
        Point copyobj = new Point(obj);

        System.out.println("Original Point: (" + obj.getX() + ", " + obj.getY() + ")");
        System.out.println("Copied Point: (" + copyobj.getX() + ", " + copyobj.getY() + ")");

        obj.setX(5);
        obj.setY(7);

        System.out.println(" Changed Point: (" + obj.getX() + ", " + obj.getY() + ")");
        System.out.println(" Copied Update Point is still unchanged (" + copyobj.getX() + ", " + copyobj.getY() + ")");
    }
}

// Output Original Point: (2, 3)
// Copied Point: (2, 3)
// Changed Point: (5, 7)
// Copied Update Point is still unchanged (2, 3)
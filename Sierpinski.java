/*************************************************************************
 *  Compilation:  javac Sierpinski.java
 *  Execution:    java Sierpinski
 *
 *  @author: Zach Derish, zpd3, zach.derish@rutgers.edu
 *
 *************************************************************************/

public class Sierpinski {

    // Height of an equilateral triangle whose sides are of the specified length. 
    public static double height(double length) {
        double height = ((Math.sqrt(3))*(length))/2;
        return height;
    }

    // Draws a filled equilateral triangle whose bottom vertex is (x, y) 
    // of the specified side length. 
    public static void filledTriangle(double x, double y, double length) {
        double xcoord1 = x - (length/2);
        double xcoord2 = x+(length/2);
        double ycoord1 = y+height(length);
        double[] xs1 = {x , xcoord1, xcoord2};
        double[] ys1 = {y, ycoord1, ycoord1};
        StdDraw.filledPolygon(xs1, ys1);
    }

    // Draws a Sierpinski triangle of order n, such that the largest filled 
    // triangle has bottom vertex (x, y) and sides of the specified length. 
    public static void sierpinski(int n, double x, double y, double length) {
        if(n == 1){
            filledTriangle(x, y, length);
        }
        else{
            filledTriangle(x, y, length);
            filledTriangle(x, y, length);
            filledTriangle(x, y, length); 
            sierpinski(n-1, x - (length/2), y, length/2);
            sierpinski(n-1, x, y+height(length), length/2);
            sierpinski(n-1, x + (length/2), y, length/2);
        }
    }
    // Takes an integer command-line argument n; 
    // draws the outline of an equilateral triangle (pointed upwards) of length 1; 
    // whose bottom-left vertex is (0, 0) and bottom-right vertex is (1, 0); and 
    // draws a Sierpinski triangle of order n that fits snugly inside the outline. 
    public static void main(String[] args) {
        double height1 = height(1.0);
        double[] xs2 = {0.0, 1.0, 0.5};
        double[] ys2 = {0.0, 0.0, height1};
        StdDraw.polygon(xs2, ys2);
        int n = Integer.parseInt(args[0]);
        double x = 0.5;
        double y = 0.0;
        double length = 0.5;
        sierpinski(n, x, y, length);
        height(length);
    }
}

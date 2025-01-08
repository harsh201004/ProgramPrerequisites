import java.util.Scanner;

public class CircleAreaCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the radius of the circle: ");
        double radius = sc.nextDouble();

        double area = Math.PI * Math.pow(radius, 2);

        System.out.printf("The area of the circle is: ", area);

        scanner.close();
    }
}

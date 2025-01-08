import java.util.Scanner;

public class celsiustofahrenheit{
   public static void main(String [] args){
    
   Scanner input = new Scanner(System.in);

      System.out.println("Enter the temperature in celsius: ");

      int Celsius = input.nextInt();
      
      int Fahrenheit = (Celsius * 9/5) + 32;

      System.out.println("Temperature in Fahrenheit is: " + Fahrenheit);
}
}
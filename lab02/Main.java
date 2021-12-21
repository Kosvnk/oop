public class Main{
    public static void main(String args[]) {
      int number = 12345678;
      int sumEven = 0, sumOdd = 0;
      while (number != 0) {
        if (number % 10 % 2 == 0) sumEven += number % 10;
        else sumOdd += number % 10;
        number /= 10;
      }
      System.out.println ("Summ of even numbers: " + sumEven);
      System.out.println ("Summ of odd numbers: " + sumOdd);
    }
}
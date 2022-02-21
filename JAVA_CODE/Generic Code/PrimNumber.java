import java.util.stream.IntStream;
 
public class Main 
{
  public static void main(String[] args) 
  {
    System.out.println("2 is prime number :: " + isPrime(2));
    System.out.println("3 is prime number :: " + isPrime(3));
    System.out.println("4 is prime number :: " + isPrime(4));
    System.out.println("5 is prime number :: " + isPrime(5));
    System.out.println("6 is prime number :: " + isPrime(6));
    System.out.println("7 is prime number :: " + isPrime(7));
    System.out.println("8 is prime number :: " + isPrime(8));
    System.out.println("9 is prime number :: " + isPrime(9));
    System.out.println("10 is prime number :: " + isPrime(10));
    System.out.println("11 is prime number :: " + isPrime(11));
  }
   
  static boolean isPrime(int number) {
    if(number <= 2)
      return number == 2;
    else
      return  (number % 2) != 0
          &&
          IntStream.rangeClosed(3, (int) Math.sqrt(number))
          .filter(n -> n % 2 != 0)
              .noneMatch(n -> (number % n == 0));
  }
}
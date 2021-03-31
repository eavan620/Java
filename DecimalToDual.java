/*
 * Write a Java method public static String transformToDual(int decimal) that transforms a number n > 0 given in base10 to the String representation of that same number in base2. Be aware of the order of bits!
 */

public class DecimalToDual {

  public static String transformToDual(int dec) {
    String str = "";
    int rest = dec;
    while (rest >0){
      dec = rest % 2;
      rest = rest / 2;
      System.out.println(rest);
      str += dec;
    }
    String correctStr = new StringBuilder(str).reverse().toString();
    return correctStr;

  }

  public static void main(String[] args) {
    transformToDual(13);

  }
}
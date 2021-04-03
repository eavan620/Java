/*
* Write a class Clock, that can be used to create, add, and print time objects. The class should at least contain:

* a. the attributes hours and minutes (both int) with appropriate getter and setter methods.

* b. different constructors to create object by either giving the hours and minutes, only the minutes since midnight (here possibly much larger than  60), or a String of the form “hours:minutes” (e.g. “23:18” or “37:128”).

* c. the (overloaded) methods public Clock add(int min) and public Clock add(Clock c) to add to time objects.

* d. a method toString() to transform the object into a proper String representation.

* Test your Clock using the main method. Generate random Clock objects and test your methods’ implementations.

*/


public class Clock {
   private int h;
   private int min;
   private static final int MIN_HOUR = 0;

   private static final int MAX_HOUR = 23;

   private static final int MIN_MINUTE = 0;

   private static final int MAX_MINUTE = 59;

   public int getMin() {
      return min;
   }

   public int getH() {
      return h;
   }



   public Clock(int h, int min) {
      check(h, min);
      this.h = h;
      this.min = min;
   }

   public Clock(int min) {
      check(0, min);
      this.min = min;
      this.h = 0;
   }

   public Clock(String hourmin) {
      String[] time = hourmin.split(":");
      check(Integer.valueOf(time[0]), Integer.valueOf(time[1]));
      this.h = Integer.valueOf(time[0]);
      this.min= Integer.valueOf(time[1]);
   }

   private void check(int h, int min) {
      // check hour
      if (h > MAX_HOUR || h < MIN_HOUR) {
         throw new IllegalArgumentException("hour should be betweent 0 and 23");
      }
      // check minute
      if (min > MAX_MINUTE || min < MIN_MINUTE) {
         throw new IllegalArgumentException("minute should be betweent 0 and 59");
      }
   }

   // TODO: insert all required constructors

   public Clock add(int min) {
      return this.add(0, min);
   }

   public Clock add(Clock c) {
      return this.add(c.getH(), c.getMin());
   }

   private Clock add(int hoursToAdd, int minutesToAdd) {
      int totalMinutes = this.min + minutesToAdd;
      int minutes = totalMinutes % 60;

      int totalHours = this.h + hoursToAdd + totalMinutes / 60;
      int hours = totalHours % 24;
      return new Clock(hours, minutes);
   }

   @Override
   public String toString() {
      return String.format("%02d:%02d", this.h, this.min);
   }


   private static void isTrue(boolean expression, String message) {
      if (!expression) {
         System.out.println(message);
      }
   }

   public static void main(String[] args) {

      // constructor test
      // test 1
      Clock c1 = new Clock(18, 30);
      isTrue(c1.getH() == 18, "test 1: hour is wrong");
      isTrue(c1.getMin() == 30, "test 1: minute is wrong");

      // test 2
      Clock c2 = new Clock(30);
      isTrue(c2.getH() == 0, "test 2: hour is wrong");
      isTrue(c2.getMin() == 30, "test 2: minute is wrong");

      // test 3
      Clock c3 = new Clock("18:30");
      isTrue(c3.getH() == 18, "test 3: hour is wrong");
      isTrue(c3.getMin() == 30, "test 3: minute is wrong");

      // business test
      // test 4
      // 23:59 + 00:01 = 00:00
      Clock c4 = new Clock(23, 59);
      Clock tmp = c4.add(1);
      isTrue(tmp.getH() == 0, "test 4：hour is wrong");
      isTrue(tmp.getH() == 0, "test 4：minute is wrong");

      // test 5
      // 18:40 + 07:30 = 02:10
      Clock c5 = new Clock(18, 40);
      Clock c6 = new Clock(7, 30);
      tmp = c5.add(c6);
      isTrue(tmp.getH() == 2, "test 5：hour is wrong");
      isTrue(tmp.getMin() == 10, "test 5：minute is wrong");

      //test 6
      // toString test
      Clock c7 = new Clock(7, 3);
      isTrue("07:03".equals(c7.toString()), "test 6：time string is wrong");
   }
}

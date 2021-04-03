/*
* Often you can hear someone say: ‘You cannot compare apples and oranges!” But… “Why not?!”, you may ask yourself.

* In this assignment you will make exactly this possible: comparing apples and oranges. For the sake of completeness we will even add cookies and grapes. All these types of Food can be represented by a class Food.

* Each object (e.g. a single cookie) has a set amount of calories.

* Familiarize yourself with the Java interface Comparable. Using this interface, we can store all the Food objects in a fridge (an array of type Food[]…) and use a standard sorting algorithms implemented in java.utils.Arrays.sort() to tidy up the fridge. This sparks joy!

* Implement all required methods (toString(), compareTo(), getCalories(), and createSortedRandomList() from the template file.

* The compareTo method should implement the only reasonable way to compare different types of Food:

* Take the length of the name/type of Food and multiply this by the amount of calories the Food has. Use this score as a feature for comparison.

* The Food with the lower score should also be considered the smaller one (less than).

*/


public class Food implements Comparable<Food> { // Interfaces AND Generics, OMG!

    private String type;
    private int calories;
    private static final String[] TYPES = {"Apple", "Pear", "Cookie", "Grape"};

    public static void main(String[] args) {
        // TODO your test cases
        print(createSortedRandomList(10));
    }

    public Food(String type, int calories) {
        this.type = type;
        this.calories = calories;
    }

    public int compareTo(Food o) {
        if ( (this.type.length() * this.calories) == (o.type.length() * o.calories) ) return 0;
        if ((this.type.length() * this.calories) > (o.type.length() * o.calories) ) return 1;
        else return -1;
    }


    public static Food[] createSortedRandomList(int n) {
        // TODO create a list with n random instances and sort them
        Food[] food = new Food[n];
        for(int i=0; i<food.length; i++){
            food[i] = new Food(TYPES[(int)(2.0*Math.random())], (int)(60 * Math.random()));
        }
        java.util.Arrays.sort(food);
        return food;

    }

    @Override
    public String toString() {
        return "Food [type=" + type + ", calories=" + calories + "]";
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getCalories() {
        return calories;
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }

    public static void print(Food[] a){
        for(int i=0; i<a.length; i++)
        {
            System.out.println(a[i].toString());
        }
        System.out.println();
    }
}

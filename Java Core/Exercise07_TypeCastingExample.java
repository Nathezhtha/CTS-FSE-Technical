public class TypeCastingExample {
    public static void main(String[] args) {
        double myDouble = 9.78;
        int myInt = (int) myDouble;

        int anotherInt = 100;
        double convertedDouble = anotherInt;

        System.out.println("Double to int: " + myInt);
        System.out.println("Int to double: " + convertedDouble);
    }
}
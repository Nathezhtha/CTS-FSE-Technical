public class PatternMatchingSwitch {
    public static void printType(Object obj) {
        switch (obj) {
            case Integer i -> System.out.println("It's an Integer: " + i);
            case String s -> System.out.println("It's a String: " + s);
            case Double d -> System.out.println("It's a Double: " + d);
            default -> System.out.println("Unknown type");
        }
    }

    public static void main(String[] args) {
        printType(10);
        printType("Hello");
        printType(3.14);
        printType(true);
    }
}
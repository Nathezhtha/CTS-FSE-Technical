import java.lang.reflect.Method;

class ReflectTarget {
    public void greet(String name) {
        System.out.println("Hello, " + name);
    }
}

public class ReflectionExample {
    public static void main(String[] args) throws Exception {
        Class<?> clazz = Class.forName("ReflectTarget");
        Object obj = clazz.getDeclaredConstructor().newInstance();
        Method[] methods = clazz.getDeclaredMethods();
        for (Method method : methods) {
            System.out.println("Method: " + method.getName());
        }
        Method greetMethod = clazz.getMethod("greet", String.class);
        greetMethod.invoke(obj, "Java");
    }
}
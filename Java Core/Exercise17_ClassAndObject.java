class Car {
    String make;
    String model;
    int year;

    void displayDetails() {
        System.out.println(year + " " + make + " " + model);
    }
}

public class CarTest {
    public static void main(String[] args) {
        Car car1 = new Car();
        car1.make = "Toyota";
        car1.model = "Camry";
        car1.year = 2022;

        Car car2 = new Car();
        car2.make = "Honda";
        car2.model = "Civic";
        car2.year = 2023;

        car1.displayDetails();
        car2.displayDetails();
    }
}
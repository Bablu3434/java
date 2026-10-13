class Car {
    String color = "Red";

    void start() {
        System.out.println("Car is starting");
    }

    public static void main(String[] args) {
        Car c = new Car();
        System.out.println(c.color);
        c.start();
    }
}

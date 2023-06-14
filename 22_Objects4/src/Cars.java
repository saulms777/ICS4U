public class Cars {

    public static void main(String[] args) {
        Car[] cars = new Car[10];
        for (int i = 0; i < 10; i++) {
            if (utils.inputWord("Default car? (y/n) ").equals("y")) cars[i] = new Car();
            else cars[i] = new Car(
                    utils.inputLine("Model name: "),
                    utils.inputInt("Year bought: "),
                    utils.inputDouble("Initial cost: ")
            );
        }

        boolean loop = true;
        while (loop) {
            int car;
            if ((car = utils.inputInt("Car to update (0 to exit): ")) == 0) loop = false;
            else switch (utils.inputInt("""
                    1) Update car model
                    2) Update car year
                    3) Update car initial cost
                    4) See car info""")) {
                case 1 -> cars[car].setModel(utils.inputLine("New model: "));
                case 2 -> cars[car].setYear(utils.inputInt("New year; "));
                case 3 -> cars[car].setInitCost(utils.inputDouble("New initial cost: "));
                case 4 -> System.out.println(cars[car]);
            }
        }

        double total = 0;
        for (Car c : cars) {
            System.out.println(c);
            total += c.getCost();
        }
        System.out.print("Average cost: " + total / 10);
    }

}

class Car {

    private String model;
    private int year;
    private double initCost;

    public Car() {
        model = "Honda Civic";
        year = 1972;
        initCost = 10000;
    }

    public Car(String model, int year, double initCost) {
        this.model = model;
        this.year = year;
        this.initCost = initCost;
    }

    public double carValue(int year) {
        return initCost * (1.0 - 0.15 * (year - this.year) / 2.0);
    }

    public int mileage(int year) {
        return 40000 * (year - this.year);
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setInitCost(double initCost) {
        this.initCost = initCost;
    }

    public double getCost() {
        return initCost;
    }

    @Override
    public String toString() {
        return "Car: " + model +
                "\nYear acquired: " + year +
                "\nInitial cost: " + initCost +
                "\nCar value in 2021: " + carValue(2021) +
                "\nMileage in 2021: " + mileage(2021);
    }

    public boolean equals(Car car) {
        return car.toString().equals(toString());
    }

}

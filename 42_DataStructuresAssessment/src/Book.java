public class Book {

    private String name;
    private int yearPublished;
    private int cost;

    public Book(String name, int yearPublished, int cost) {
        this.name = name;
        this.yearPublished = yearPublished;
        this.cost = cost;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYearPublished() {
        return yearPublished;
    }

    public void setYearPublished(int yearPublished) {
        this.yearPublished = yearPublished;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    @Override
    public String toString() {
        return "{Name: [" + name +
                "], Year published: [" + yearPublished +
                "], Cost: [" + cost +
                "]}";
    }

    @Override
    public boolean equals(Object o) {
        return (o instanceof Book) &&
                ((Book) o).getName().equals(name) &&
                ((Book) o).getYearPublished() == yearPublished &&
                ((Book) o).getCost() == cost;
    }

}

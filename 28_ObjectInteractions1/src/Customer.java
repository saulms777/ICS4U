public class Customer {

    private final String firstName;
    private final String lastName;
    private String street;
    private String city;
    private String province;

    public Customer(String firstName, String lastName, String street, String city, String province) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.street = street;
        this.city = city;
        this.province = province;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    @Override
    public String toString() {
        return String.format("Name: %s %s\nStreet: %s\nCity: %s\nProvince: %s",
                firstName, lastName, street, city, province);
    }

}

package repro;

class JavaAddress {

    private String street;

    private String city;

    public String getStreet() {
        return street;
    }

    public JavaAddress setStreet(String street) {
        this.street = street;
        return this;
    }

    public String getCity() {
        return city;
    }

    public JavaAddress setCity(String city) {
        this.city = city;
        return this;
    }
}

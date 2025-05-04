import java.util.*;

public class Address {
    protected String city;
    protected String country;

    public Address(String country, String city) {
        this.country = country;
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public String getCity() {
        return city;
    }

    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Address)) return false;
        Address other = (Address) obj;
        return country.equals(other.country) && city.equals(other.city);
    }

    public int hashCode() {
        return Objects.hash(country, city);
    }
}

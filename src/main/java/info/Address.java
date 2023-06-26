package info;

import java.util.HashMap;
import java.util.List;

public class Address extends Object {

    private Integer id;
    private String flatNumber;
    private Integer floor;
    private String house;
    private String street;
    private String city;

    public Address() {

    }

    public Address(HashMap<String, String> map) {
        setMap(map);
    }

    public String getFlatNumber() {
        return flatNumber;
    }

    public void setFlatNumber(String flatNumber) {
        this.flatNumber = flatNumber;
    }

    public Integer getFloor() {
        return floor;
    }

    public void setFloor(Integer floor) {
        this.floor = floor;
    }

    public String getHouse() {
        return house;
    }

    public void setHouse(String house) {
        this.house = house;
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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String toString() {
        return "ID: " + id + " City: " + city + " House: " + house + " Floor: " + floor + " Flat number: " + flatNumber;
    }

    public void setMap(HashMap<String, String> addressMap) {
        if(addressMap != null && !addressMap.isEmpty()) {
            this.id = Integer.parseInt(addressMap.get("id"));
            this.city = addressMap.get("city");
            this.street = addressMap.get("street");
            this.house = addressMap.get("house");
            this.floor = Integer.parseInt(addressMap.get("floor"));
            this.flatNumber = addressMap.get("flatNumber");
        }
    }

    public String getName() {
        return "Address";
    }

    public Boolean hasDuplicate(List<Object> addresses) {
        Integer count = 0;
        for (Object obj: addresses) {
            Address address = (Address) obj;
            if(address.floor.equals(this.floor) &&
            address.flatNumber.equals(this.flatNumber) &&
            address.street.equals(this.street) &&
            address.city.equals(this.city) &&
            address.house.equals(this.house))
                count++;
        }
        return count >= 2;
    }
}

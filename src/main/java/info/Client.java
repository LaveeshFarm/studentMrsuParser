package info;

import java.util.HashMap;

public class Client extends Object {

    private Integer id;
    private String name;
    private String personnelNumber;
    private Integer addressId;

    private Address address;

    public Client() {

    }
    public Client(HashMap<String, String> map) {
        setMap(map);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPersonnelNumber() {
        return personnelNumber;
    }

    public void setPersonnelNumber(String personnelNumber) {
        this.personnelNumber = personnelNumber;
    }

    public Integer getAddressId() {
        return addressId;
    }

    public void setAddressId(Integer addressId) {
        this.addressId = addressId;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String toString() {
        return "ID: " + id + " Name: " + name + " Personnel number: " + personnelNumber + " Address ID: " + addressId;
    }

    public void setMap(HashMap<String, String> addressMap) {
        if(addressMap != null && !addressMap.isEmpty()) {
            this.id = Integer.parseInt(addressMap.get("id"));
            this.name = addressMap.get("name");
            this.personnelNumber = addressMap.get("personnelNumber");
            this.addressId = Integer.parseInt(addressMap.get("addressId"));
        }
    }

}

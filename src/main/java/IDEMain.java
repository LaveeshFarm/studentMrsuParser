import info.Address;
import info.Client;
import parser.XMLParser;

import java.io.File;
import java.util.HashMap;
import java.util.List;

public class IDEMain {
    public static void main(String[] args) {
        XMLParser xmlParser = new XMLParser();

        List<Object> addressList = (List<Object>) xmlParser.parse(new File("address.xml"));
        List<Object> clientList = (List<Object>) xmlParser.parse(new File("client.xml"));

        addressList.forEach(adress -> {
            if(((Address) adress).hasDuplicate(addressList))
                System.out.println(adress + " has duplicate!");
        });

        clientList.forEach(client ->
                addressList.stream()
                        .filter(address -> ((Address) address)
                                .getId().equals(((Client) client)
                                        .getAddressId()))
                        .findFirst()
                        .ifPresent(o -> ((Client) client).setAddress((Address) o)));

        HashMap<String, Integer> countFloorMap = new HashMap<String, Integer>();

        clientList.forEach(client -> {
            Integer floor = ((Client) client).getAddress().getFloor();
            if(!countFloorMap.containsKey("Floor " + floor.toString()))
                countFloorMap.put("Floor " + floor.toString(), 1);
            else countFloorMap.put("Floor " + floor.toString(), countFloorMap.get("Floor " + floor.toString()) + 1);
        });

        System.out.println(countFloorMap);
    }
}

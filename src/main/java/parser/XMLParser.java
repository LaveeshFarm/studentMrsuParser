package parser;

import exceptions.UnexpectedXMLLocalNameException;
import info.*;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.*;

public class XMLParser implements Parser {

    @Override
    public List<? extends Object>  parse(File file) {
        XMLInputFactory factory = XMLInputFactory.newInstance();
        XMLStreamReader parser = null;
        List someList = null;
        HashMap<String, String> map = new HashMap<String, String>();

        try {
            parser = factory.createXMLStreamReader(new FileInputStream(file));
        } catch (FileNotFoundException e) {
            System.out.println("Check file path");
        } catch (XMLStreamException e) {
            System.out.println(e.getMessage());
        }

        try {
            while (true) {
                assert parser != null;
                if (!parser.hasNext()) break;
                int event = parser.next();
                if (event == XMLStreamConstants.START_ELEMENT) {
//                    todo: добавить реализацию
                    map.put("localName", parser.getLocalName());
                    for (int i = 0; i < parser.getAttributeCount(); i++) {
                        map.put(parser.getAttributeLocalName(i), parser.getAttributeValue(i));
                    }

                    String localName = map.get("localName");
                    if (localName.equalsIgnoreCase("ctRoot"))
                        continue;
                    if (localName.equalsIgnoreCase(Address.class.getSimpleName())) {
                        if (someList == null)
                            someList = new ArrayList<Address>();
                        someList.add(new Address(map));
                    } else if (localName.equalsIgnoreCase(Client.class.getSimpleName())) {
                        if (someList == null)
                            someList = new ArrayList<Client>();
                        someList.add(new Client(map));
                    } else throw new UnexpectedXMLLocalNameException();
                }
            }
        } catch (XMLStreamException e) {
            System.out.println(e.getMessage());
        } catch (UnexpectedXMLLocalNameException e) {
            throw new RuntimeException(e);
        }
        return someList;
    }
}
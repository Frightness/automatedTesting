package task5;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import java.io.File;
import java.io.IOException;

class Address {
    private String street;
    private String city;
    private String state;

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

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}

class Person {
    @JsonProperty("isEmployed")
    private boolean isEmployed;
    private String name;
    private Address address;

    @JsonProperty("isEmployed")
    public boolean isEmployed() {
        return isEmployed;
    }

    @JsonProperty("isEmployed")
    public void setEmployed(boolean employed) {
        isEmployed = employed;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}

public class Task5 {
    public static void main(String[] args) {
        try {
            ObjectMapper jsonMapper = new ObjectMapper();
            XmlMapper xmlMapper = new XmlMapper();

            File jsonInput = new File("src/main/resources/input.json");
            Person personFromJson = jsonMapper.readValue(jsonInput, Person.class);

            personFromJson.setEmployed(true);
            personFromJson.getAddress().setCity("New York");

            File jsonOutput = new File("src/main/resources/output.json");
            jsonMapper.writerWithDefaultPrettyPrinter().writeValue(jsonOutput, personFromJson);

            File xmlInput = new File("src/main/resources/input.xml");
            Person personFromXml = xmlMapper.readValue(xmlInput, Person.class);

            personFromXml.setName("John Doe");
            personFromXml.getAddress().setStreet("456 Example Ave");

            File xmlOutput = new File("src/main/resources/output.xml");
            xmlMapper.writerWithDefaultPrettyPrinter().writeValue(xmlOutput, personFromXml);

            System.out.println("Operation finished successfully");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

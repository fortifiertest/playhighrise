package models;

import org.simpleframework.xml.*;
import java.util.List;

@Root
public class People {

    @Attribute(name = "type", required = false)
    private String type;

    @ElementList(name = "people", entry = "person", inline = true)
    private List<Person> persons;


    public List<Person> getPersons() {
        return persons;
    }

    public void setPersons(List<Person> elements) {
        this.persons = elements;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

}

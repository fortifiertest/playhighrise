package models;

import org.simpleframework.xml.*;
import java.util.List;
import java.util.Set;

@Root
public class People {

    @Attribute(name = "type", required = false)
    private String type;

    @ElementList(name = "people", entry = "person", inline = true)
    private Set<Person> persons;

    public Set<Person> getPersons() {
        return persons;
    }

    public void setPersons(Set<Person> persons) {
        this.persons = persons;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

}

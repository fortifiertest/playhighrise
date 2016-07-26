package models;

import org.simpleframework.xml.*;
import play.data.validation.Required;

import java.util.List;

@Root(name = "tag")
public class Tag{

    @Required
    @Element(name="id")
    private Integer id;

    @Element(name="name")
    private String name;

    private List<Person> persons;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Person> getPersons() {
        return persons;
    }

    public void setPersons(List<Person> persons) {
        this.persons = persons;
    }

    @Override
    public String toString() {
        return "Tag{" +
            "id=" + id +
            ", name='" + name + '\'' +
            ", persons=" + persons +
            '}';
    }
}

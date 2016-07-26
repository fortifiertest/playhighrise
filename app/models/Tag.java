package models;

import org.simpleframework.xml.*;
import play.data.validation.Required;
import play.db.jpa.GenericModel;
import play.db.jpa.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;
import java.util.List;

@Entity
@Root(name = "tag")
public class Tag extends GenericModel {

    @Id
    @Required
    @Element(name="id")
    private Integer id;

    @Element(name="name")
    private String name;

    @ManyToMany(mappedBy = "tags")
    private List<Person> persons;

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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public Object _key() {
        return getId();
    }
}

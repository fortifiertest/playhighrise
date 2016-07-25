package services;

import db.HighRiseDAO;
import models.*;
import org.simpleframework.xml.core.Persister;
import play.Logger;
import javax.ws.rs.client.*;
import java.util.*;

import static configurations.HighRiseConfiguration.*;

public class HighRiseService  {

    HighRiseDAO dao = new HighRiseDAO();

    public List<Person> getPerson(Long tagId) {
        People p = readData(tagId);
        dao.insertPeople(p);
        return p.getPersons();
    }

    public Set<Person> getPeopleByTag(String tagName) {
        return dao.findPersons(tagName);
    }

    private People readData(Long tagId) {
        Client client = ClientBuilder.newClient();
        String  response = client.target(HIGH_RISE_URL + "?tag_id=" + tagId).request()
            .header("Authorization", HIGH_RISE_AUTH_CODE).get(String.class);
        People people = null;

        try {
            people = new Persister().read(People.class, response);
        } catch (Exception ex) {
            Logger.error(ex.getMessage());
        }

        return people;
    }
}
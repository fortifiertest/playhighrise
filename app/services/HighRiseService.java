package services;

import models.*;
import org.simpleframework.xml.core.Persister;
import play.Logger;
import javax.ws.rs.client.*;
import java.util.*;

import static configurations.HighRiseConfiguration.*;

public class HighRiseService {

    public Set<Person> findPersonsAPI(Long tagId) {
        Client client = ClientBuilder.newClient();
        String response = client.target(HIGH_RISE_URL + "?tag_id=" + tagId).request()
                .header("Authorization", HIGH_RISE_AUTH_CODE).get(String.class);
        Logger.info("Get response from Highrise API: " + response);
        try {
            return new Persister().read(People.class, response).getPersons();
        } catch (Exception ex) {
            Logger.error(ex.getMessage());
        }
        return Collections.emptySet();
    }
}
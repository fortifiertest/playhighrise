package controllers;

import play.Logger;
import play.mvc.*;
import java.util.*;
import models.*;
import services.HighRiseService;

public class HighRiseController extends Controller {
    private static  HighRiseService service = new HighRiseService();

    public static void index() {
        render();
    }

    public static void findPeopleById(Long tagId){
        Logger.info("Trying to get people from Highrise API by tag:" + tagId);
        Set<Person> persons = service.findPersonsAPI(tagId);
        if(!persons.isEmpty()) Person.saveData(persons);
        Logger.info("Find people:" + persons);
        render(persons);
    }

    public static void findPeopleByTag(String tagName){
        Logger.info("Trying to people by tag:" + tagName);
        List<Person> persons = Person.findData(tagName);
        Logger.info("Find people:" + persons);
        render(persons);
    }
}
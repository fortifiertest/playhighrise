package controllers;

import play.mvc.*;
import java.util.*;
import models.*;
import services.HighRiseService;

public class HighRiseController extends Controller {
    private static  HighRiseService service = new HighRiseService();

    public static void index() {
        render();
    }

    public static void findPeopleById(Long tagId) throws Exception {
        Set<Person> persons = service.findPersonsAPI(tagId);
        if(!persons.isEmpty()) service.addPersons(persons);

        render(persons);
    }

    public static void findPeopleByTag(String tagName) throws Exception {
        Set<Person> persons = service.findPersons(tagName);
        render(persons);
    }
}
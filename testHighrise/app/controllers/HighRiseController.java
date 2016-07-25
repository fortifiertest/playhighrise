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

    public static void getPeople(Long tagId) throws Exception {
        List<Person> persons = service.getPerson(tagId);
        render(persons);
    }

    public static void searchPeopleByTag(String tagName) throws Exception {
        Set<Person> persons = service.getPeopleByTag(tagName);
        render(persons);
    }
}
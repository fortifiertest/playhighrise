package db;

import models.*;
import play.Logger;
import play.db.DB;
import java.sql.*;
import java.util.*;

public class DBProvider {

    public Set<Person> findPersons(String tagName) {
        final String searchRow = "SELECT * FROM person WHERE id IN " +
                "(SELECT personid FROM persontag WHERE tagid IN (SELECT id FROM tag WHERE name IN (?)));";

        try (Connection connection = DB.getDataSource("default").getConnection()) {
            Set<Person> persons = new HashSet<>();

            PreparedStatement statement = connection.prepareStatement(searchRow);
            statement.setString(1, tagName);
            ResultSet resultSet = statement.executeQuery();

            while(resultSet.next()) {
                Person person = new Person();

                person.setId(resultSet.getInt("id"));
                person.setFirstName(resultSet.getString("firstname"));
                person.setLastName(resultSet.getString("lastname"));
                person.setTitle(resultSet.getString("title"));
                person.setBackground(resultSet.getString("background"));
                person.setLinkedinUrl(resultSet.getString("linkedinurl"));
                person.setAvatarUrl(resultSet.getString("avatarurl"));
                person.setCompanyId(resultSet.getInt("companyid"));
                person.setCompanyName(resultSet.getString("companyname"));
                person.setCreatedAt(resultSet.getString("createdat"));
                person.setUpdatedAt(resultSet.getString("updatedat"));
                person.setVisibleTo(resultSet.getString("visibleto"));
                person.setAuthorId(resultSet.getInt("authorid"));
                person.setGroupId(resultSet.getInt("groupid"));
                person.setOwnerId(resultSet.getInt("ownerid"));

                persons.add(person);
            }
            return persons;
        } catch (SQLException ex) {
            Logger.error(ex.getMessage());
        }

        return Collections.emptySet();
    }

    public void addPersons(Set<Person> persons) {
        PreparedStatement statement;

        for (Person person: persons) {
            final String insertPersonRow = "INSERT INTO person VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            final String selectTagRow = "SELECT * FROM tag WHERE id =  (?);";
            final String insertTagRow = "INSERT INTO tag(id, name) VALUES (?,?);";
            final String insertPersonTagRow = "INSERT INTO persontag(personid, tagid) VALUES (?,?);";

            try (Connection connection = DB.getDataSource("default").getConnection()) {
                connection.setAutoCommit(false);
                statement = connection.prepareStatement(insertPersonRow);
                statement.setInt(1, person.getId());
                statement.setString(2, person.getFirstName());
                statement.setString(3, person.getLastName());
                statement.setString(4, person.getTitle());
                statement.setString(5, person.getBackground());
                statement.setString(6, person.getLinkedinUrl());
                statement.setString(7, person.getAvatarUrl());
                if(person.getCompanyId() == null) statement.setNull(8,java.sql.Types.INTEGER);
                else statement.setInt(8, person.getCompanyId());
                statement.setString(9, person.getCompanyName());
                statement.setString(10, person.getCreatedAt());
                statement.setString(11, person.getUpdatedAt());
                statement.setString(12, person.getVisibleTo());
                statement.setInt(13, person.getAuthorId());
                if(person.getGroupId() == null) statement.setNull(14,java.sql.Types.INTEGER);
                else statement.setInt(14, person.getGroupId());
                if(person.getOwnerId() == null) statement.setNull(15,java.sql.Types.INTEGER);
                else statement.setInt(15, person.getOwnerId());
                statement.execute();

                for(Tag tag: person.getTags()) {
                    statement = connection.prepareStatement(selectTagRow);
                    statement.setInt(1, tag.getId());
                    ResultSet set = statement.executeQuery();
                    if(!set.next()){
                        statement = connection.prepareStatement(insertTagRow);
                        statement.setInt(1, tag.getId());
                        statement.setString(2, tag.getName());
                        statement.execute();
                    }
                    statement = connection.prepareStatement(insertPersonTagRow);
                    statement.setInt(1, person.getId());
                    statement.setInt(2, tag.getId());
                    statement.execute();
                }

                connection.commit();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }
}
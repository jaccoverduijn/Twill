package com.twill.test.controller;

import com.twill.test.Model.Repository;
import com.twill.test.Model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.xml.crypto.Data;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by JVERDUIJ on 2-6-2017.
 *
 * Running the program:
 * run the main.java
 * To test the user part you first have to add a user to the DB. Go to postman and post on http://localhost:8080/users/adduser
 * Now you can retrieve the added user using get on http://localhost:8080/users/{LOGIN}
 * You can add a repository by using post on http://localhost:8080/users/{LOGIN}/addrepository
 */
@RestController
public class UserController {
    //Creating an Arraylist of users on which you can add
    ArrayList<User> userDB = new ArrayList<>();
    public void addUserToDB(User addUser) {
        userDB.add(addUser);
    }
    //Creating an Arraylist of repositories on which you can add
    ArrayList<Repository> repositoryDB = new ArrayList<>();
    public void addRepositoryToDB (Repository addedRepository){
        repositoryDB.add(addedRepository);
    }

    @RequestMapping(value = "/users/adduser", method = RequestMethod.POST)
    public User addUser(@RequestBody User addedUser) {
       addUserToDB(addedUser);

        return addedUser;

    }


    @RequestMapping(value = "/users/{login}", method = RequestMethod.GET)
    public User getUser(@PathVariable String login) {

         //Check if the input name exist in the current DB
        for (User user : userDB) {
            if (login.equals(user.getLogin())) {
                return user;
            }

        }

        //If name does not exist return null
        return null;
    }
    @RequestMapping(value = "/users/{name}/addrepository", method = RequestMethod.POST)
    public ArrayList<Repository> addRepos(@PathVariable String name, @RequestBody ArrayList<Repository> addedRepository) {
        // Loop through the arraylist and add items to the DB
        for(Repository repository: addedRepository) {
            addRepositoryToDB(repository);
        }
        return addedRepository;

    }

}






package org.gpiste.myapp;

import java.util.HashMap;

public class User {

    String firstname;
    String lastname;
    String username;
    String password;

    //Static hashmap to access across activities and classes
    static HashMap<String, User> users = new HashMap<>();

    //Constructor
    public User(String f, String l, String u, String p) {
        firstname = f;
        lastname = l;
        username = u;
        password = p;
    }
}

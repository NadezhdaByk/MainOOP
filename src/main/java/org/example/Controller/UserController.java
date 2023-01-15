package org.example.Controller;

import org.example.Model.CheckModul;
import org.example.Model.User;

import java.util.List;

public class UserController {
    private final CheckModul checkModul;

    public UserController(CheckModul checkModul) {
        this.checkModul = checkModul;
    }

    public List<String> GetFullData(String input){
        return checkModul.CheckFullData(input);
    }

    public String GetDateBirth(String input) {
        return checkModul.ChooseDate(checkModul.CheckFullData(input));
    }

    public Integer GetPhone(String input) {
        return checkModul.ChoosePhone(checkModul.CheckFullData(input));
    }

    public String GetGender(String input) {
        return checkModul.ChooseGender(checkModul.CheckFullData(input));
    }

    public List<String> GetFullName(String input){
        return checkModul.ChooseFullName(checkModul.CheckFullData(input));
    }

    public String GetFirstName(List<String> fullname){
        return fullname.get(0);
    }

    public String GetSecondName(List<String> fullname){
        return fullname.get(1);
    }

    public String GetPatronymic(List<String> fullname){
        return fullname.get(2);
    }

    public void SaveUser(String name, User user){

        checkModul.SaveUser(name, user, readUsers(name));
    }
    public List<User> readUsers(String name){
        return checkModul.getAllUsers(name);
    }

}


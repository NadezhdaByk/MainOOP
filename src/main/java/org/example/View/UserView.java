package org.example.View;

import org.example.Controller.UserController;
import org.example.Model.CheckModul;
import org.example.Model.User;

import java.util.List;
import java.util.Scanner;

public class UserView {
    private UserController controller;
    public CheckModul checkModul;

    public UserView(UserController controller) {
        this.controller = controller;
    }

    public void run(){
        String data = prompt("Ведите ФИО, дату рождения, номер телефона, пол: ");
        List<String> team = controller.GetFullData(data);
        String dateBirth = controller.GetDateBirth(data);
        String gender = controller.GetGender(data);
        Integer phone = controller.GetPhone(data);
        List<String> fullName = controller.GetFullName(data);
        String firstName = controller.GetFirstName(fullName);
        String secondName = controller.GetSecondName(fullName);
        String patronymic = controller.GetPatronymic(fullName);
        controller.SaveUser(firstName, new User(firstName,secondName,patronymic,dateBirth,phone,gender));

    }
    private String prompt(String message) {
        Scanner in = new Scanner(System.in);
        System.out.print(message);
        return in.nextLine();
    }
}



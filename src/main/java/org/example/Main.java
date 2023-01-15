package org.example;

import org.example.Controller.UserController;
import org.example.Model.CheckModul;

import org.example.View.UserView;

public class Main {
    public static void main(String[] args) {
        CheckModul checkModul = new CheckModul();
        UserController controller=new UserController(checkModul);
        UserView view = new UserView(controller);
        view.run();
    }
}
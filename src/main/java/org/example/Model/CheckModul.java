package org.example.Model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CheckModul {

    public CheckModul() {

    }
    public List <String> CheckFullData(String input){
        List <String> dataUser = new ArrayList<>(Arrays.asList(input.split(" ")));

        if (dataUser.size()<6){
            throw new RuntimeException("Вы ввели не все данные");
        }
        if (dataUser.size()>6){
            throw new RuntimeException("Вы ввели слишком много данных");
        }
        return dataUser;
    }

    public String ChooseDate (List<String> input){
        String dateBirth = null;
        for (String item: input){
            if (item.contains(".")){
                dateBirth=item;
            }
        }
        if (dateBirth==null){
            throw new IllegalStateException("Ошибка в формате даты рождения");
        }
        return dateBirth;
    }

    public String ChooseGender (List<String> input){
        String gender = null;
        for (String item: input){
            if (item.equals("ж")|| item.equals("м")){
                gender=item;
            }
        }
        if (gender==null){
            throw new IllegalStateException("Пол человека введен не правильно");
        }
        return gender;
    }

    public Integer ChoosePhone (List<String> input){
        Integer phone = 0;
        for (String item:input){
            try {
                phone = Integer.parseInt (item);
            } catch (RuntimeException e){
                continue;
            }
        }
        if (phone==0){
            throw new RuntimeException("Телефонный номер не введен или введен не правильно (не более 7 цифр)");
        }
        return phone;
    }

    public List<String> ChooseFullName(List<String> input){
        input.remove(ChooseDate(input));
        input.remove(ChooseGender(input));
        input.remove(ChoosePhone(input).toString());
        if(input.size()!=3){
            throw new RuntimeException("Полное имя сформировано не правильно");
        }

        return input;
    }

    public void SaveUser(String name, User user, List<User> users){
        users.add(user);
        saveUsers(name, users);
    }

    public String map(User user) {
        return String.format("%s,%s,%s,%s,%d,%s", user.getFirstname(), user.getSecondname(), user.getPatronymic(), user.getDatabirth(), user.getPhone(), user.getGender());
    }

    public User map(String line) {
        String[] lines = line.split(",");
        return new User(lines[0], lines[1], lines[2], lines[3], Integer.parseInt(lines[4]), lines[4]);
    }

    public List<User> getAllUsers(String name) {
        FileOperation fileOperation = new FileOperation(name);
        List<String> lines = fileOperation.readAllLines();
        List<User> users = new ArrayList<>();
        for (String line : lines) {
            users.add(map(line));
        }
        return users;
    }

    private void saveUsers(String name, List<User> users){
        FileOperation fileOperation = new FileOperation(name);
        List<String> lines = new ArrayList<>();
        for (User item: users) {
            lines.add(map(item));
        }
        fileOperation.saveAllLines(lines);
    }

}

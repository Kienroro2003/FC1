/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Dương Tiến
 */
import java.util.ArrayList;
import java.util.List;

public class UserDao {

    List<User> ls = new ArrayList<>();

    public UserDao() {
        ls.add(new User("Duong Van Tien", "07902003", true));
    }

    public boolean checkLogin(String username, String password) {
        for (User us : ls) {
            if (us.getUsername().equals(username) && us.getPassword().equals(password)) {
                return true;
            }
        }
        return false;
    }
}

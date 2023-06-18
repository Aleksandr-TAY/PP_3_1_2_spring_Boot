package web.PP_3_1_2_spring_Boot.dao;

import web.PP_3_1_2_spring_Boot.models.User;

import java.util.List;

public interface UserDao {

    void addUser(User user);

    void removeUserById(int id);

    List<User> getAllUsers();

    User getUser(int id);
    void updateUser(int id, User user);
}

package web.PP_3_1_2_spring_Boot.Service;


import web.PP_3_1_2_spring_Boot.models.User;

import java.util.List;
public interface UserService {
    void addUser(User user);

    void removeUserById(int id);

    List<User> getAllUsers();

    User getUser(int id);

    void updateUser(int id, User user);

}

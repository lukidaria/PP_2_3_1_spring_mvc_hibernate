package web.service;



import web.model.User;

import java.util.List;

public interface UserService {

    User add(User user);

    List<User> getAllUsers();

    void delete(Long userId);

    User getUser(Long id);

    void update(User user);
}

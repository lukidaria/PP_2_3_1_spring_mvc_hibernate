package web.DAO;



import web.model.User;

import java.util.List;

public interface UserDao {

    User add(User user);

    List<User> getAllUsers();

    void delete(Long userId);

    User getUser(Long id);

    void update(User user);
}

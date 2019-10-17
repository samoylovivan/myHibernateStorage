package ivan.samoylov;

import ivan.samoylov.Model.User;
import java.util.List;

public interface Storage {
    int removeAll();
    int removeUser(int id);
    int removeUserByName(String name);
    void addUser(User user);
    void updateUser(User user);
    User getUser(int id);
    List<User> getAllUsers();
}

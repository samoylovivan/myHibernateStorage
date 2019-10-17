package ivan.samoylov;

import ivan.samoylov.Model.User;

import java.util.jar.JarOutputStream;

public class Main {
    public static void main(String[] args) {
        HibernateStorage hs = new HibernateStorage();

        hs.removeAll();

        hs.addUser(new User("Chris", 26));
        hs.addUser(new User("Ben", 31));
        hs.addUser(new User("Lisa", 24));
        hs.addUser(new User("Bill", 28));
        hs.addUser(new User("Alice", 25));
        hs.addUser(new User("Kate", 23));
        hs.addUser(new User("Barbara", 21));

        System.out.println(hs.getAllUsers());

        System.out.println(hs.getUser(4));
        System.out.println(hs.getUser(1));

        User user = hs.getUser(4);
        user.setAge(35);
        hs.updateUser(user);

        System.out.println(hs.getAllUsers());

        user = hs.getUser(2);
        hs.removeUser(user.getId());
        user = hs.getUser(6);
        hs.removeUser(user.getId());

        System.out.println(hs.getAllUsers());

        hs.removeUserByName("Lisa");
        hs.removeUserByName("Bill");

        System.out.println(hs.getAllUsers());

        hs.close();
    }
}

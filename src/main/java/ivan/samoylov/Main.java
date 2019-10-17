package ivan.samoylov;


public class Main {
    public static void main(String[] args) {
        HibernateStorage hibernateStorage = new HibernateStorage();
        hibernateStorage.close();
    }
}

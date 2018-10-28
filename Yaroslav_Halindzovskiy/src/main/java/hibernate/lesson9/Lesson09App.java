package hibernate.lesson9;

import hibernate.lesson9.util.HibernateUtil;

public class Lesson09App {
    public static void main(String[] args) {
        HibernateUtil.getFactory().close();
    }
}

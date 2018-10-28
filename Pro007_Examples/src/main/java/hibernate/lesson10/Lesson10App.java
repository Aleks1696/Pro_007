package hibernate.lesson10;

import hibernate.lesson10.util.HibernateUtil;

public class Lesson10App {

    public static void main(String[] args) {
        HibernateUtil.getFactory().close();
    }
}

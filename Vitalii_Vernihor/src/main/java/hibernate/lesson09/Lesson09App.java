package hibernate.lesson09;

import hibernate.lesson09.utill.HibernateUtil;

public class Lesson09App {
    public static void main(String[] args) {
        HibernateUtil.getFactory().close();
    }
}

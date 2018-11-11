package homework11;

import homework11.util.HibernateUtil;


public class HomeWork11App {
    public static void main(String[] args) {

        HibernateUtil.getFactory().close();
    }
}

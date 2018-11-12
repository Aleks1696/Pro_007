package spring.homework13Part2.entity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class Company {
    @Autowired
    @Qualifier("director")
    private Employee director;
    @Autowired
    @Qualifier("manager")
    private Employee manager;
    @Autowired
    @Qualifier("driver")
    private Employee driver;

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Company{");
        sb.append("director=").append(director);
        sb.append(", manager=").append(manager);
        sb.append(", driver=").append(driver);
        sb.append('}');
        return sb.toString();
    }
}
package spring.homework13Part2.entity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class Director extends BasedEmployee {

    @Autowired
    @Qualifier("driver")
    private Employee driver;

    public Director(String name, String surname, Double salary) {
        super(name, surname, salary);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Director{");
        sb.append("driver=").append(driver);
        sb.append('}');
        return sb.toString();
    }
}

package spring.homework13Part2.entity;

import org.springframework.beans.factory.annotation.Autowired;


public class Driver extends BasedEmployee {

    @Autowired
    private Car car;

    public Driver(String name, String surname, Double salary) {
        super(name, surname, salary);
    }


    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Driver{");
        sb.append("car=").append(car);
        sb.append('}');
        return sb.toString();
    }
}

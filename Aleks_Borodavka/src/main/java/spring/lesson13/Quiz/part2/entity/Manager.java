package spring.lesson13.Quiz.part2.entity;

public class Manager {

    private String name;
    private String Surname;
    private Double salary;

    public Manager(String name, String surname, Double salary) {
        this.name = name;
        Surname = surname;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return Surname;
    }

    public Double getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Manager{");
        sb.append("name='").append(name).append('\'');
        sb.append(", Surname='").append(Surname).append('\'');
        sb.append(", salary=").append(salary);
        sb.append('}');
        return sb.toString();
    }
}

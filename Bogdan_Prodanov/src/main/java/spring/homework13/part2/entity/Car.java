package spring.homework13.part2.entity;

public class Car{
    private String mark;


    public Car(String mark) {
        this.mark = mark;

    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;

    }


    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Car{");
        sb.append("mark='").append(mark).append('\'');
        sb.append('}');
        return sb.toString();
    }
}


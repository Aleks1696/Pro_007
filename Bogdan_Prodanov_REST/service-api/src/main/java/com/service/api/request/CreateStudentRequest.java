package com.service.api.request;

public class CreateStudentRequest {

    private String name;
    private String surname;
    private Integer age;

    public String getName() {
        return name;
    }
    public CreateStudentRequest setName(String name) {
        this.name = name;
        return this;
    }
    public String getSurname() {
        return surname;
    }
    public CreateStudentRequest setSurname(String surname) {
        this.surname = surname;
        return this;
    }
    public Integer getAge() {
        return age;
    }
    public CreateStudentRequest setAge(Integer age) {
        this.age = age;
        return this;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("CreateStudentRequest{");
        sb.append("name='").append(name).append('\'');
        sb.append(", surname='").append(surname).append('\'');
        sb.append(", age=").append(age);
        sb.append('}');
        return sb.toString();
    }
}

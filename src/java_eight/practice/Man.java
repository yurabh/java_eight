package java_eight.practice;

import java.util.Objects;

public class Man {
    private String name;
    private String surname;
    private String firstName;
    private int age;
    private int countChild;
    private Address address;

    public Man() {
    }

    public Man(String name, String surname, String firstName, int age, int countChild, Address address) {
        this.name = name;
        this.surname = surname;
        this.firstName = firstName;
        this.age = age;
        this.countChild = countChild;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getCountChild() {
        return countChild;
    }

    public void setCountChild(int countChild) {
        this.countChild = countChild;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Man man = (Man) o;
        return age == man.age &&
                countChild == man.countChild &&
                Objects.equals(name, man.name) &&
                Objects.equals(surname, man.surname) &&
                Objects.equals(firstName, man.firstName) &&
                Objects.equals(address, man.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname, firstName, age, countChild, address);
    }

    @Override
    public String toString() {
        return "Man{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", firstName='" + firstName + '\'' +
                ", age=" + age +
                ", countChild=" + countChild +
                ", address=" + address +
                '}';
    }
}

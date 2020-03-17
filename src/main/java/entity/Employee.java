package entity;
/*Hibernate позволяет определить обычный Java класс, как часть модели реляционной реляционной базы данных,
точнее соответствие определенного класса к таблице модели базы данных. Что необходимо определить на уровне
Java кода рассмотрим в данном материале.*/
import java.util.Objects;

public class Employee {

    private Long id;
    private String firstName;
    private String lastName;
    private int age;
    private Long addressID;

    public Employee(){

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Long getAddressID() {
        return addressID;
    }

    public void setAddressID(Long addressID) {
        this.addressID = addressID;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return age == employee.age &&
                Objects.equals(id, employee.id) &&
                Objects.equals(firstName, employee.firstName) &&
                Objects.equals(lastName, employee.lastName) &&
                Objects.equals(addressID, employee.addressID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, age, addressID);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lostName='" + lastName + '\'' +
                ", age=" + age +
                ", addressID=" + addressID +
                '}';
    }
}

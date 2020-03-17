package entity;
/*Hibernate позволяет определить обычный Java класс, как часть модели реляционной реляционной базы данных,
точнее соответствие определенного класса к таблице модели базы данных. Что необходимо определить на уровне
Java кода рассмотрим в данном материале.*/
import java.util.Objects;

public class Pets {

    private Long id;
    private String name;
    private int age;
    private Long employeeID;

    public Pets(){

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Long getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(Long employeeID) {
        this.employeeID = employeeID;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pets pets = (Pets) o;
        return age == pets.age &&
                Objects.equals(id, pets.id) &&
                Objects.equals(name, pets.name) &&
                Objects.equals(employeeID, pets.employeeID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, age, employeeID);
    }

    @Override
    public String toString() {
        return "Pets{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", employeeID=" + employeeID +
                '}';
    }
}

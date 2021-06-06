package kg.megacom.jpa;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity
public class Customer {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    private String firstName;
    private String lastName;
    private Integer age;

    private LocalDate startDate;
    private boolean active;

    public Customer() {
    }

    public Customer(String firstName, String lastName, Integer age, LocalDate startDate, boolean active) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.startDate = startDate;
        this.active = active;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                ", startDate='" + startDate + '\'' +
                ", active=" + active +
                '}';
    }

    public Long getId() {
        return id;
    }

    public Integer getAge() {
        return age;
    }

    public boolean isActive() {
        return active;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }
}
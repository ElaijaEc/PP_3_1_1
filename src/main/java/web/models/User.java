package web.models;

import javax.persistence.*;

@Entity
@Table(name="userstable")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name= "firstname")
    private String firstName;
    @Column(name="lastname")
    private String lastName;
    @Column(name = "age")
    private int age;
    //CONSTRUCTORS
    public User() {
    }
    public User(Long id, String firstName, String lastName, int age) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }
    public User(User user) {
        id=user.id;
        firstName= user.firstName;
        lastName=user.lastName;
        age=user.age;
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return new StringBuilder("User with id-").append(getId()).append(" : ").append(getFirstName()).append(" ")
                .append(getLastName()).append(" has age: ").append(getAge()).toString();
    }
}

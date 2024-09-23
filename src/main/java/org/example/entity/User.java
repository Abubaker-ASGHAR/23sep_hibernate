package org.example.entity;
import javax.persistence.*;

@Entity
@Table(name ="users")
public class User {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long id;

    @Column(name = "name",nullable = false)
    private String name;

    @Column(name ="email",nullable=false,unique = true)
    private String email;

    @OneToOne(mappedBy = "user",cascade= CascadeType.ALL)
    @JoinColumn(name = "adress_id")
     private Address address;

    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;

    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public Address getAddress() {
        return address;
    }
    public void setAddress(Address address) {
        this.address = address;
    }


}

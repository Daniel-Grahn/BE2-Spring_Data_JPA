package se.yrgo.domain;

import java.util.*;
import jakarta.persistence.*;

@Entity
@Table(name="CUSTOMER")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String phoneNumber;

    @OneToMany(mappedBy = "customer")
    private List<Vehicle> vehicalList;

    
    public Customer() {
    }

    public Long getId() {
        return id;
    }
    
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getPhoneNumber() {
        return phoneNumber;
    }
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "Customer [id=" + id + ", name=" + name + ", phoneNumber=" + phoneNumber + "]";
    }

    
}

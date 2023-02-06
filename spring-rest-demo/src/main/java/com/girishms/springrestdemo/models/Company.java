package com.girishms.springrestdemo.models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "company")
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToMany
    @JoinTable(
            name="company_employee",
            joinColumns = @JoinColumn(name = "company"),
            inverseJoinColumns = @JoinColumn(name = "employee")
    )
    private List<Employee> employees;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}

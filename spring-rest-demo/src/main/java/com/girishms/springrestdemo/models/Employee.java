package com.girishms.springrestdemo.models;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "employees")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Name should not be blank")
    @NotEmpty(message = "Name should not be empty")
    @NotNull(message = "Name should not be null")
    private String name;

    private Long age = 0L;

    @Column
    private String location;

    @Email
    private String email;

    @NotBlank(message = "department should not be blank")
    @NotEmpty(message = "department should not be empty")
    @NotNull(message = "department should not be null")
    private String department;

    @CreationTimestamp
    @Column(nullable = false, updatable = false)
    private Date createdAt;

    @UpdateTimestamp
    private Date updatedAt;

    @ManyToMany(mappedBy = "employees")
    private List<Company> companies;

	public void setId(Long id) {
		this.id = id;
	}
}

package com.example.springbackend.model;

import com.example.JsfDemo.model.enums.Gender;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Date;

@Data
@Entity
public class Player {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Size(max = 60)
    @NotBlank
    private String firstName;

    @Size(max = 20)
    @NotBlank
    private String lastName;

    @Transient
    private String fullName;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date birthDate;

    private Boolean active;

    @CreationTimestamp
    private Date createdAt;

    @UpdateTimestamp
    private Date updatedAt;

    public Player() {

    }
    public Player(@Size(max = 60) @NotBlank String firstName, @Size(max = 20) @NotBlank String lastName,
                  Gender gender, Date birthDate, Boolean active) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.fullName = fullName;
        this.gender = gender;
        this.birthDate = birthDate;
        this.active = active;
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

    public String getFullName() {
        return this.getFirstName() + " " + this.getLastName();
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

}


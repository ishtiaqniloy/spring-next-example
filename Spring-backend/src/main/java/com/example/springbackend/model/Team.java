package com.example.springbackend.model;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.Set;

@Entity
public class Team {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Size(max = 45)
    @NotBlank
    private String name;

    @Size(max = 200)
    private String description;

    private boolean active;

    @OneToOne(fetch = FetchType.LAZY)
    private Player captain;

    @OneToMany(fetch = FetchType.LAZY)
    private Set<Player> members;

    @CreationTimestamp
    private Date createdAt;

    @UpdateTimestamp
    private Date updatedAt;

    public Team() {
    }

    public Team(@Size(max = 45) @NotBlank String name, @Size(max = 200) String description, boolean active,
                Player captain, Set<Player> members) {
        this.name = name;
        this.description = description;
        this.active = active;
        this.captain = captain;
        this.members = members;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public Player getCaptain() {
        return captain;
    }

    public void setCaptain(Player captain) {
        this.captain = captain;
    }

    public Set<Player> getMembers() {
        return members;
    }

    public void setMembers(Set<Player> members) {
        this.members = members;
    }
}

package com.spe.project.bean;

import lombok.*;

import jakarta.persistence.*;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Project {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Column
    private String projectName;

    @Column
    private String description;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "PROJECT_USER",
            joinColumns = {
                    @JoinColumn(name = "PROJECT_ID")
            },
            inverseJoinColumns = {
                    @JoinColumn(name = "USER_ID") })
    private Set<User> users;

    @OneToMany(mappedBy = "project",cascade = CascadeType.REMOVE)
    private Set<Task> tasks;

    @OneToOne(mappedBy = "project",cascade = CascadeType.REMOVE)
    private EffortTable effortTable;
}


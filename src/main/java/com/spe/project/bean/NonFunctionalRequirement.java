package com.spe.project.bean;


import lombok.*;

import jakarta.persistence.*;
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class NonFunctionalRequirement {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Column
    private String requirement;

    @OneToOne
    @JoinColumn(name = "project_id")
    private Project project;
}


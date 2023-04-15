package com.spe.project.bean;


import lombok.*;

import jakarta.persistence.*;
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Role {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long roleId;

    @Column
    private String name;

    @Column
    private String description;

}


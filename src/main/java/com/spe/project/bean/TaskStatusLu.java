package com.spe.project.bean;


import lombok.*;

import jakarta.persistence.*;
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TaskStatusLu {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;


    @Column
    private String statusName;

    @Column
    private String description;
}

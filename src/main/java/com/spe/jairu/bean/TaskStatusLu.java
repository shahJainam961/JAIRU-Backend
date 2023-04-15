package com.spe.jairu.bean;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TaskStatusLu {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long taskStatusLuId;

    @Column
    private String statusName;

    @Column
    private String description;
}

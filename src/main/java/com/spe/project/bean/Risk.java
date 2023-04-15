package com.spe.project.bean;
import lombok.*;

import jakarta.persistence.*;
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Risk {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Column
    private String description;

    @Column
    private String  status;

    @OneToOne
    @JoinColumn(name = "project_id")
    private Project project;


}

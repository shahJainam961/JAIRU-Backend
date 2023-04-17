package com.spe.jairu.bean;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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
@JsonIgnoreProperties({"project"})
public class EffortTable {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long effortTableId;

    @Column
    private Integer requirementAnalysisHours;

    @Column
    private Integer designingHours;

    @Column
    private Integer codingHours;

    @Column
    private Integer testingHours;

    @Column
    private Integer projectManagementHours;

    @OneToOne
    @JoinColumn(name = "project_id")
    private Project project;
}

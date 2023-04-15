package com.spe.jairu.bean;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","project"})
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Task {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long taskId;

    @Column
    private String taskName;

    @Column
    private String description;

    @ManyToOne
    @JoinColumn(name="status_id")
    private TaskStatusLu statusLu;

    @ManyToOne
    @JoinColumn(name="project_id")
    private Project project;

    @ManyToOne
    @JoinColumn(name="user_id")
    private User user;
}


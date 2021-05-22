package kpi.zabelskyi.csdb.blaze.corp.model;

import lombok.Data;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@Entity
@Table(name= "project" )
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name= "id_project")
    private Long id;

    @NotNull
    //@Size(min = 4, max = 50, message = "{validation.user.login")
    @Column(name= "project_name")
    private String projectName;

    @NotNull
    @Column(name= "project_cost")
    private Integer projectCost;

    //@NotNull
    @Column(name= "description")
    private String description;

}

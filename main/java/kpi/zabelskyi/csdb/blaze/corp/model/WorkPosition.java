package kpi.zabelskyi.csdb.blaze.corp.model;

import lombok.Data;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@Entity
@Table(name= "work_position" )
public class WorkPosition {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    //@Size(min = 4, max = 50, message = "{validation.user.login")
    @Column(name= "work_position_name")
    private String workPositionName;

    @NotNull
    @Column(name= "salary")
    private Integer salary;

    @NotNull
    @Column(name= "premium")
    private Integer premium;

}
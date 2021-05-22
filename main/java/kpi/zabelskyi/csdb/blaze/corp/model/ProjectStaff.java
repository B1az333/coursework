package kpi.zabelskyi.csdb.blaze.corp.model;

import lombok.Data;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@Entity
@Table(name= "project_staff" )
public class ProjectStaff
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name= "id_pr_st")
    private Long id;

    @NotNull
    //@Size(min = 4, max = 50, message = "{validation.user.login")
    @Column(name= "id_contract_project")
    private Integer idContractProject;

    @NotNull
    @Column(name= "id_worker")
    private Integer idWorker;
}

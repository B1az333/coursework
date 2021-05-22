package kpi.zabelskyi.csdb.blaze.corp.model;

import lombok.Data;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@Entity
@Table(name= "contract_project" )
public class ContractProject {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name= "id_contract_project")
    private Long id;

    @NotNull
    //@Size(min = 4, max = 50, message = "{validation.user.login")
    @Column(name= "id_project")
    private Integer idProject;

    @NotNull
    @Column(name= "id_contract")
    private Integer idContract;

    @NotNull
    @Column(name= "id_status_project")
    private Integer idStatusProject;

}

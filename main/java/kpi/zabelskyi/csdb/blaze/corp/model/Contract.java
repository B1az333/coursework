package kpi.zabelskyi.csdb.blaze.corp.model;

import lombok.Data;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@Entity
@Table(name= "contract" )
public class Contract {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name= "id_contract")
    private Long id;

    @NotNull
    //@Size(min = 4, max = 50, message = "{validation.user.login")
    @Column(name= "id_client")
    private Integer idClient;

}

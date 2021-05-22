package kpi.zabelskyi.csdb.blaze.corp.model;

import lombok.Data;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@Entity
@Table(name= "worker" )
public class Worker {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name= "id_worker")
    private Long id;

    @NotNull
    @Column(name= "id_client")
    private Integer idClient;

    //@NotNull
    @Column(name= "id_department")
    private Integer idDepartment;

    //@NotNull
    @Column(name= "start_date")
    private String startDate;

    @NotNull
    @Column(name= "id_work_position")
    private Integer idWorkPosition;

    //@NotNull
    //@Column(name= "engineer_rank")
    //private String engineerRank;

    //@NotNull
    //@Column(name= "constructor_amount_certificates")
    //private String constructorAmountCertificates;

    //@NotNull
    //@Column(name= "specialist_equipment_category")
    //private String specialistEquipmentCategory;


}
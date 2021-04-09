package kpi.zabelskyi.csdb.blaze.corp.model;

import lombok.Data;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@Entity
@Table(name= "status" )
public class Status {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    //@Size(min = 4, max = 50, message = "{validation.user.login")
    @Column(name= "scode")
    private String scode;

    @NotNull
    @Column(name= "sname")
    private String sname;

    @NotNull
    @Column(name= "bclosed")
    private Boolean isClosed;

}

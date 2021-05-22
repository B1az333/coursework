package kpi.zabelskyi.csdb.blaze.corp.model;

import lombok.Data;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@Entity
@Table(name= "clients")
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name= "id_client")
    private Long id;

    @NotNull
    //@Size(min = 4, max = 50, message = "{validation.user.login")
    @Column(name= "full_name")
    private String clientName;

    @NotNull
    @Column(name= "email")
    private String clientEmail;

    @NotNull
    @Column(name= "password")
    private String clientPassword;

    @NotNull
    @Column(name= "id_user_type")
    private Integer idUserType;
}

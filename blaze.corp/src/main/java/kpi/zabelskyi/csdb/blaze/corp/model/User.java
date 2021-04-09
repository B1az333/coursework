package kpi.zabelskyi.csdb.blaze.corp.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Data
@Entity
@Table(name="user_list")

public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    // @Size(min = 4, max=50, message = "{validation.user.login}" )
    @Column(name = "Uname")
    private String name;

    @NotNull
    @Column(name = "Uemail")
    private String email;


    @NotNull
    @Column(name = "Utelephone")
    private String phone;

    @NotNull
    @Column(name = "Ulog")
    private String login;

    @NotNull
    @Column(name = "Upassword")
    private String password;
}
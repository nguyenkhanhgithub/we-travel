package com.example.wetravel.Entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Table(name = "Role")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Role implements Serializable {
    @Id
    @Column(name = "role_id")
    private Integer roleId;

    @Column(name = "role_name" , nullable = false)
    private String roleName;

    @OneToMany(fetch = FetchType.LAZY , mappedBy = "roleId" , cascade = {CascadeType.REFRESH, CascadeType.MERGE, CascadeType.REMOVE})
    private List<Account> accountList;

}

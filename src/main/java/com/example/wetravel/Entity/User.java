package com.example.wetravel.Entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Table(name = "User")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class User implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long userId;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "account_id" ,referencedColumnName = "account_id")
    private Account accountId;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "gender")
    private String gender;

    @Column(name = "address")
    private String address;

    @Column(name = "city")
    private String city;

    @Column(name = "date_of_birth")
    private String birthDate;

    @Column(name = "phone")
    private String phone;

    @Column(name = "is_private")
    private Boolean isPrivate;
}

package com.example.wetravel.Entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Table(name = "Partner")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Partner implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "partner_id")
    private Long partnerId;

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

    @Column(name = "email")
    private String email;

    @ManyToOne
    @JoinColumn(name = "service_category_id" , referencedColumnName = "service_category_id")
    private ServiceCategory serviceCategoryId;

    @Column(name = "position")
    private String position;

    @Column(name = "department")
    private String department;

    @Column(name = "number_id_card")
    private String numberIdCard;

    @Column(name = "place_issue")
    private String placeIssue;

    @Column(name = "date_issue")
    private String dateIssue;

    @OneToOne(mappedBy = "partnerId" , cascade = CascadeType.ALL)
    private CompanyPartner companyPartnerId;

    @OneToMany(mappedBy = "partnerId" , cascade = {CascadeType.REFRESH, CascadeType.MERGE, CascadeType.REMOVE})
    private List<Service> serviceList;
}

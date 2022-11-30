package com.example.wetravel.Entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Table(name = "Company_partner")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CompanyPartner implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "company_partner_id")
    private Long companyPartnerId;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "partner_id" , referencedColumnName = "partner_id")
    private Partner partnerId;

    @Column(name = "company_name")
    private String companyName;

    @Column(name = "short_name")
    private String shortName;

    @Column(name = "address")
    private String address;

    @Column(name = "city")
    private String city;

    @Column(name = "email")
    private String email;

    @Column(name = "fax")
    private String fax;

    @Column(name = "phone")
    private String phone;

    @Column(name = "website")
    private String website;

    @Column(name = "business_license_code")
    private String businessCode;

    @Column(name = "tax_code")
    private String taxCode;

    @Column(name = "registration date")
    private String registrationDate;

    @Column(name = "incorporation_date")
    private String incorporationDate;
}

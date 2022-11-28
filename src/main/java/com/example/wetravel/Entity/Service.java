package com.example.wetravel.Entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

@Table(name = "Service")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Service implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "service_id")
    private Long serviceId;

    @Column(name = "service_name")
    private String serviceName;

    @Column(name = "fax")
    private String fax;

    @Column(name = "phone")
    private String phone;

    @Column(name = "email")
    private String email;

    @Column(name = "address")
    private String address;

    @Column(name = "city")
    private String city;

    @Column(name = "link")
    private String link;

    @Column(name = "status")
    private Integer status;

    @Column(name = "tax_code")
    private String taxCode;

    @Column(name = "date_register")
    private LocalDate dateRegister;

    @Column(name = "is_active")
    private Boolean isActive;

    @Column(name = "isBlock")
    private Boolean isBlock;

    @ManyToOne
    @JoinColumn(name = "service_category_id" , referencedColumnName = "service_category_id")
    private ServiceCategory serviceCategoryId;

    @ManyToOne
    @JoinColumn(name = "partner_id" , referencedColumnName = "partner_id")
    private Partner partnerId;

    @OneToMany(fetch = FetchType.LAZY , mappedBy = "serviceId" , cascade = CascadeType.ALL)
    private List<Post> postList;

    @OneToOne(fetch = FetchType.LAZY , mappedBy = "serviceId" , cascade = CascadeType.ALL)
    private Accommodation accommodation;

    @OneToOne(fetch = FetchType.LAZY , mappedBy = "serviceId" , cascade = CascadeType.ALL)
    private Restaurant restaurant;

    @OneToOne(fetch = FetchType.LAZY , mappedBy = "serviceId" , cascade = CascadeType.ALL)
    private Entertainment entertainment;

    @OneToMany(fetch = FetchType.LAZY , mappedBy = "serviceId" , cascade = {CascadeType.REFRESH, CascadeType.MERGE, CascadeType.REMOVE})
    private List<UtilitiesService> utilitiesServiceList;
}

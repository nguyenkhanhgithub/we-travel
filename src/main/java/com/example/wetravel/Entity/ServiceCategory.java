package com.example.wetravel.Entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Table(name = "service_category")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ServiceCategory implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "service_category_id")
    private Long serviceCategoryId;

    @Column(name = "service_category_name")
    private String serviceCategoryName;

    @OneToMany(fetch = FetchType.EAGER , mappedBy = "serviceCategoryId" , cascade = {CascadeType.REFRESH, CascadeType.MERGE, CascadeType.REMOVE})
    private List<Service> serviceList;

    @OneToMany(fetch = FetchType.LAZY , mappedBy = "serviceCategoryId" , cascade = CascadeType.ALL)
    private List<Partner> partnerList;
}

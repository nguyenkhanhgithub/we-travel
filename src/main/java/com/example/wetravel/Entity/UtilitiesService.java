package com.example.wetravel.Entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Table(name = "utilities_service")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UtilitiesService implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "utilities_service_id")
    private Long utilitiesServiceId;

    @ManyToOne
    @JoinColumn(name = "service_id" , referencedColumnName = "service_id")
    private Service serviceId;

    @ManyToOne
    @JoinColumn(name = "utilities_subcategory_id" , referencedColumnName = "utilities_subcategory_id")
    private UtilitiesSubcategory utilitiesSubcategoryId;
}

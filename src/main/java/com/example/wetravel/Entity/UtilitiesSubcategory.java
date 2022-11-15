package com.example.wetravel.Entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Table(name = "utilities_subcategory")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UtilitiesSubcategory implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "utilities_subcategory_id")
    private Long utilitiesSubcategoryId;

    @Column(name = "utilities_subcategory_name")
    private String utilitiesSubcategoryName;

    @ManyToOne
    @JoinColumn(name = "utilities_category_id" , referencedColumnName = "utilities_category_id")
    private UtilitiesCategory utilitiesCategoryId;

    @OneToMany(cascade = {CascadeType.REFRESH, CascadeType.MERGE, CascadeType.REMOVE} , mappedBy = "utilitiesSubcategoryId" , fetch = FetchType.LAZY)
    private List<UtilitiesService> utilitiesServiceList;
}

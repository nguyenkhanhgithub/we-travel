package com.example.wetravel.Entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Table(name = "utilities_category")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UtilitiesCategory implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "utilities_category_id")
    private Long utilitiesCategoryId;

    @Column(name = "utilities_category_name")
    private String utilitiesCategoryName;

    @OneToMany(fetch = FetchType.LAZY , mappedBy = "utilitiesCategoryId" , cascade = {CascadeType.REFRESH, CascadeType.MERGE, CascadeType.REMOVE})
    private List<UtilitiesSubcategory> utilitiesSubcategoryList;
}

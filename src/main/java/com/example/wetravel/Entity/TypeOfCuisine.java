package com.example.wetravel.Entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Table(name = "type_of_cuisine")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class TypeOfCuisine implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "type_of_cuisine_id")
    private Long typeCuisineId;

    @Column(name = "cuisine_name")
    private String cuisineName;

    @OneToMany(fetch = FetchType.LAZY , mappedBy = "typeCuisineId" , cascade = {CascadeType.REFRESH, CascadeType.MERGE, CascadeType.REMOVE})
    private List<TypeOfCuisineService> typeOfCuisineServiceList;
}

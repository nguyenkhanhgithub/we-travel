package com.example.wetravel.Entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Table(name = "Tour_category")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class TourCategory implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tour_category_id")
    private Long tourCategoryId;

    @Column(name = "tour_category_name")
    private String tourCategoryName;

    @OneToMany(fetch = FetchType.LAZY , mappedBy = "tourCategoryId" , cascade =CascadeType.ALL)
    private List<Tour> tourList;
}

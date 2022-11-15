package com.example.wetravel.Entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Table(name = "tour_detail")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class TourDetail implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tour_detail_id")
    private Long tourDetailId;

    @Column(name = "tour_introduce")
    private String tourIntroduce;

    @Column(name = "tour_include")
    private String tourInclude;

    @Column(name = "tour_non_include")
    private String tourNonInclude;

    @Column(name = "general_terms")
    private String generalTerms;

    @Column(name = "address_start")
    private String addressStart;

    @Column(name = "description")
    private String description;

    @Column(name = "more_description")
    private String moreDescription;

    @Column(name = "longitude")
    private Float longitude;

    @Column(name = "latitude")
    private Float latitude;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "tour_id" , referencedColumnName = "tour_id")
    private Tour tourId;

    @OneToMany(fetch = FetchType.LAZY , mappedBy = "tourDetailId" , cascade = CascadeType.ALL)
    private List<TagOfTour> tagOfTourList;

}

package com.example.wetravel.Entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Table(name = "tag_of_tour")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class TagOfTour implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tag_of_tour_id")
    private Long tagOfTourId;

    @ManyToOne
    @JoinColumn(name = "tag_id" , referencedColumnName = "tag_id")
    private Tag tagId;

    @ManyToOne
    @JoinColumn(name = "tour_detail_id" , referencedColumnName = "tour_detail_id")
    private TourDetail tourDetailId;
}

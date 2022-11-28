package com.example.wetravel.Entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Table(name = "tour_schedule")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class TourSchedule implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tour_schedule_id")
    private Long tourScheduleId;

    @Column(name = "tour_schedule_name")
    private String tourScheduleName;

    @Column(name = "content")
    private String content;

    @Column(name = "to_place")
    private String toPlace;

    @ManyToOne
    @JoinColumn(name = "tour_id" , referencedColumnName = "tour_id")
    private Tour tourId;
}

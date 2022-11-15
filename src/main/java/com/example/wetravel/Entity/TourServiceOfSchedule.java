package com.example.wetravel.Entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Table(name = "tour_service_schedule")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class TourServiceOfSchedule implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tour_service_schedule_id")
    private Long tourServiceScheduleId;

    @ManyToOne
    @JoinColumn(name = "tour_schedule_id" , referencedColumnName = "tour_schedule_id")
    private TourSchedule tourScheduleId;

    @ManyToOne
    @JoinColumn(name = "service_id" , referencedColumnName =  "service_id")
    private Service serviceId;
}

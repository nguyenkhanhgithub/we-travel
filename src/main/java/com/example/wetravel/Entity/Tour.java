package com.example.wetravel.Entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Table(name = "Tour")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Tour implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tour_id")
    private Long tourId;

    @Column(name = "tour_name")
    private String tourName;

    @Column(name = "tour_code")
    private String tourCode;

    @Column(name = "start_place")
    private String startPlace;

    @Column(name = "end_place")
    private String endPlace;

    @Column(name = "status")
    private Integer status;

    @Column(name = "tour_type")
    private Integer tourType;

    @Column(name = "tour_mode")
    private Boolean tourMode;

    @Column(name = "number_of_day")
    private Integer numberOfDay;

    @Column(name = "number_of_night")
    private Integer numberOfNight;

    @Column(name = "min_adult")
    private Integer minAdult;

    @Column(name = "max_adult")
    private Integer maxAdult;

    @Column(name = "min_children")
    private Integer minChildren;

    @Column(name = "max_children")
    private Integer maxChildren;

    @Column(name = "min_to_start")
    private Integer minToStart;

    @Column(name = "adult_price")
    private Float priceAdult;

    @Column(name = "children_price")
    private Float priceChildren;

    @Column(name = "note")
    private String note;

    @Column(name = "start_date")
    private LocalDate startDate;

    @Column(name = "start_time")
    private LocalTime startTime;

    @Column(name = "end_time")
    private LocalTime endTime;

    @Column(name = "total_price")
    private Float totalPrice;

    @Column(name = "deposit")
    private Float deposit;

    @ManyToOne
    @JoinColumn(name = "account_id" , referencedColumnName = "account_id")
    private Account accountId;

    @ManyToOne
    @JoinColumn(name = "tour_category_id" , referencedColumnName = "tour_category_id")
    private TourCategory tourCategoryId;

    @OneToMany(fetch = FetchType.LAZY , mappedBy = "tourId" , cascade = CascadeType.ALL)
    private List<TourSchedule> tourScheduleList;

    @OneToOne(fetch = FetchType.LAZY , mappedBy = "tourId" , cascade = CascadeType.ALL)
    private TourDetail tourDetail;

    @OneToMany(fetch = FetchType.LAZY , mappedBy = "tourId" , cascade = CascadeType.ALL)
    private List<UserBooking> userBookingList;

    @OneToMany(fetch = FetchType.LAZY , mappedBy = "tourId" , cascade = CascadeType.ALL)
    private List<Feedback> feedbackList;
}

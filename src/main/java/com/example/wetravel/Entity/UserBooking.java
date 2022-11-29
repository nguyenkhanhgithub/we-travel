package com.example.wetravel.Entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

@Table(name = "user_booking")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UserBooking implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_booking_id")
    private Long userBookingId;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "account_id" , referencedColumnName = "account_id")
    private Account accountId;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "tour_id" , referencedColumnName = "tour_id")
    private Tour tourId;

    @Column(name = "booking_date")
    private LocalDate bookingDate;

    @Column(name = "start_date")
    private LocalDate startDate;

    @Column(name = "full_name")
    private String fullName;

    @Column(name = "phone")
    private String phone;

    @Column(name = "email")
    private String email;

    @Column(name = "id_card")
    private String idCard;

    @Column(name = "date_of_issue")
    private LocalDate dateOfIssue;

    @Column(name = "place_of_issue")
    private String placeOfIssue;

    @Column(name = "request")
    private String request;

    @Column(name = "adult_price")
    private Float adultPrice;

    @Column(name = "children_price")
    private Float childrenPrice;

    @Column(name = "number_adult")
    private Integer numberOfAdult;

    @Column(name = "number_children")
    private Integer numberOfChildren;

    @Column(name = "total_price")
    private Float totalPrice;

    @Column(name = "order_id")
    private Long orderId;

    @Column(name = "order_title")
    private String orderTitle;

    @Column(name = "pay_type")
    private String payType;

    @Column(name = "status")
    private Integer status;

    @Column(name = "status_deposit")
    private Boolean statusDeposit;

    @Column(name = "is_feedback")
    private Boolean isFeedback;

    @OneToMany(fetch = FetchType.LAZY , mappedBy = "userBookingId" , cascade = CascadeType.ALL)
    private List<RequestCancel> requestCancelList;

    @OneToOne(mappedBy = "userBookingId" , cascade = CascadeType.ALL)
    private Feedback feedbackId;
}

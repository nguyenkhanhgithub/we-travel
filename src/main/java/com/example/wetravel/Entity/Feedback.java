package com.example.wetravel.Entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

@Table(name = "Feedback")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Feedback implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "feedback_id")
    private Long feedbackId;

    @ManyToOne
    @JoinColumn(name = "account_id" , referencedColumnName = "account_id")
    private Account accountId;

    @ManyToOne
    @JoinColumn(name = "tour_id" , referencedColumnName = "tour_id")
    private Tour tourId;

    @Column(name = "create_date")
    private LocalDate createDate;

    @Column(name = "content")
    private String content;

    @Column(name = "is_block")
    private Boolean isBlock;

    @OneToMany(fetch = FetchType.LAZY , mappedBy = "feedbackId" , cascade = CascadeType.ALL)
    private List<ReportFeedback> reportFeedbackList;

    @OneToOne
    @JoinColumn(name = "user_booking_id" , referencedColumnName = "user_booking_id")
    private UserBooking userBookingId;
}

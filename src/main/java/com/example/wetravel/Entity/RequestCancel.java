package com.example.wetravel.Entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Table(name = "Request_Cancel")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class RequestCancel implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "request_cancel_id")
    private Long requestCancelId;

    @ManyToOne
    @JoinColumn(name = "user_booking_id" , referencedColumnName = "user_booking_id")
    private UserBooking userBookingId;

    @ManyToOne
    @JoinColumn(name = "reason_cancel_id" , referencedColumnName = "reason_cancel_id")
    private ReasonCancel reasonCancelId;

    @Column(name = "request_date")
    private LocalDate requestDate;

    @Column(name = "description")
    private String description;

    @Column(name = "status")
    private Integer status;
}

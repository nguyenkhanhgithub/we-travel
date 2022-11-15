package com.example.wetravel.Entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalTime;

@Table(name = "Entertainment")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Entertainment implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "entertainment_id")
    private Long entertainmentId;

    @Column(name = "entertainment_type")
    private String entertainmentType;

    @Column(name = "day_of_week_open")
    private String dowOpen;

    @Column(name = "time_open")
    private LocalTime timeOpen;

    @Column(name = "time_close")
    private LocalTime timeClose;

    @Column(name = "price_ticket_adult")
    private Float priceTicketAdult;

    @Column(name = "price_ticket_children")
    private Float priceTicketChildren;

    @Column(name = "description")
    private String description;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "service_id" , referencedColumnName = "service_id")
    private Service serviceId;
}

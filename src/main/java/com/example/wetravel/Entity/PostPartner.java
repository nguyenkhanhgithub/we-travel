package com.example.wetravel.Entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Table(name = "Post_partner")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PostPartner implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "post_partner_id")
    private Long postPartnerId;

    @Column(name = "date_time")
    private LocalDateTime timePost;

    @Column(name = "description")
    private String description;

    @Column(name = "is_pin")
    private Boolean isPin;

    @Column(name = "is_advertise")
    private Boolean isAdv;

    @ManyToOne
    @JoinColumn(name = "service_id" , referencedColumnName = "service_id")
    private Service serviceId;
}

package com.example.wetravel.Entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Table(name = "Alert")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Alert implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "alert_id")
    private Long alertId;

    @ManyToOne
    @JoinColumn(name = "account_id" , referencedColumnName = "account_id")
    private Account accountId;

    @Column(name = "title")
    private String title;

    @Column(name = "content")
    private String content;

    @Column(name = "status")
    private Boolean status;

    @Column(name = "create_date")
    private LocalDateTime createDate;
}

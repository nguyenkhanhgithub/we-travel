package com.example.wetravel.Entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Table(name = "Reason_Cancel")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ReasonCancel implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "reason_cancel_id")
    private Long reasonCancelId;

    @Column(name = "reason_cancel_name")
    private String reasonCancelName;

    @OneToMany(fetch = FetchType.LAZY , mappedBy = "reasonCancelId" , cascade = CascadeType.ALL)
    private List<RequestCancel> requestCancelList;
}

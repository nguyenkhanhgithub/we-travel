package com.example.wetravel.Entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Table(name = "Account")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Account implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "account_id")
    private Long accountId;

    @Column(name = "email" , nullable = false)
    private String email;

    @Column(name = "password" , nullable = false)
    private String passWord;

    @Column(name = "is_block" , nullable = false)
    private Boolean isBlock = false;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "role_id" , referencedColumnName = "role_id" )
    private Role roleId;

    @OneToOne(mappedBy = "accountId"  , cascade = CascadeType.ALL)
    private User user;

    @OneToOne(mappedBy = "accountId" , cascade = CascadeType.ALL)
    private Partner partner;

    @OneToMany(fetch = FetchType.LAZY , mappedBy = "accountId" , cascade = CascadeType.ALL)
    private List<UserBooking> userBookingList;

    @OneToMany(fetch = FetchType.LAZY , mappedBy = "accountId" , cascade = CascadeType.ALL)
    private List<Tour> tourList;

    @OneToMany(fetch = FetchType.LAZY , mappedBy = "accountId" , cascade = CascadeType.ALL)
    private List<Feedback> feedbackList;

    @OneToMany(fetch = FetchType.LAZY , mappedBy = "accountId" , cascade = CascadeType.ALL)
    private List<Comment> commentList;
}

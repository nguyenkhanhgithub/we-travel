package com.example.wetravel.Entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.parameters.P;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Table(name = "Report_Post")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ReportPost implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "report_post_id")
    private Long reportPostId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "post_id" , referencedColumnName = "post_id")
    private Post postId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "account_id" , referencedColumnName = "account_id")
    private Account accountId;

    @ManyToOne
    @JoinColumn(name = "reason_report_post_id" , referencedColumnName = "reason_report_post_id")
    private ReasonReportPost reasonReportPostId;

    @Column(name = "create_date")
    private LocalDate createDate;
}

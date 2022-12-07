package com.example.wetravel.Entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Table(name = "Report_Feedback")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ReportFeedback implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "report_feedback_id")
    private Long reportFeedbackId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "account_id" , referencedColumnName = "account_id")
    private Account accountId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "feedback_id" , referencedColumnName = "feedback_id")
    private Feedback feedbackId;

    @ManyToOne
    @JoinColumn(name = "reason_report_feedback_id" , referencedColumnName = "reason_report_feedback_id")
    private ReasonReportFeedback reasonReportFeedbackId;

    @Column(name = "create_date")
    private LocalDate createDate;
}

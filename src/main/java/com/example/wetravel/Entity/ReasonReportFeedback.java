package com.example.wetravel.Entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Table(name = "Reason_Report")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ReasonReportFeedback implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "reason_report_feedback_id")
    private Long reasonReportFeedbackId;

    @Column(name = "reason_report_name")
    private String reasonReportName;

    @OneToMany(fetch = FetchType.LAZY , mappedBy = "reasonReportFeedbackId" , cascade = CascadeType.ALL)
    private List<ReportFeedback> reportFeedbackList;
}

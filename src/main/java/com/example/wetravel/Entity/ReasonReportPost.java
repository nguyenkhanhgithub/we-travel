package com.example.wetravel.Entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Table(name = "Reason_Report_Post")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ReasonReportPost implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "reason_report_post_id")
    private Long reasonReportPostId;

    @Column(name = "reason_report_post_name")
    private String reasonReportPostName;

    @OneToMany(fetch = FetchType.LAZY , mappedBy = "reasonReportPostId" , cascade = CascadeType.ALL)
    private List<ReportPost> reportPostList;
}

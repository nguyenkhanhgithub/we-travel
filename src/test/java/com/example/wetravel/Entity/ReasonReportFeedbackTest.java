package com.example.wetravel.Entity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

class ReasonReportFeedbackTest {
    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link ReasonReportFeedback#ReasonReportFeedback()}
     *   <li>{@link ReasonReportFeedback#setReasonReportFeedbackId(Long)}
     *   <li>{@link ReasonReportFeedback#setReasonReportName(String)}
     *   <li>{@link ReasonReportFeedback#setReportFeedbackList(List)}
     *   <li>{@link ReasonReportFeedback#getReasonReportFeedbackId()}
     *   <li>{@link ReasonReportFeedback#getReasonReportName()}
     *   <li>{@link ReasonReportFeedback#getReportFeedbackList()}
     * </ul>
     */
    @Test
    void testConstructor() {
        ReasonReportFeedback actualReasonReportFeedback = new ReasonReportFeedback();
        actualReasonReportFeedback.setReasonReportFeedbackId(123L);
        actualReasonReportFeedback.setReasonReportName("Just cause");
        ArrayList<ReportFeedback> reportFeedbackList = new ArrayList<>();
        actualReasonReportFeedback.setReportFeedbackList(reportFeedbackList);
        assertEquals(123L, actualReasonReportFeedback.getReasonReportFeedbackId().longValue());
        assertEquals("Just cause", actualReasonReportFeedback.getReasonReportName());
        assertSame(reportFeedbackList, actualReasonReportFeedback.getReportFeedbackList());
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link ReasonReportFeedback#ReasonReportFeedback(Long, String, List)}
     *   <li>{@link ReasonReportFeedback#setReasonReportFeedbackId(Long)}
     *   <li>{@link ReasonReportFeedback#setReasonReportName(String)}
     *   <li>{@link ReasonReportFeedback#setReportFeedbackList(List)}
     *   <li>{@link ReasonReportFeedback#getReasonReportFeedbackId()}
     *   <li>{@link ReasonReportFeedback#getReasonReportName()}
     *   <li>{@link ReasonReportFeedback#getReportFeedbackList()}
     * </ul>
     */
    @Test
    void testConstructor2() {
        ArrayList<ReportFeedback> reportFeedbackList = new ArrayList<>();
        ReasonReportFeedback actualReasonReportFeedback = new ReasonReportFeedback(123L, "Just cause",
                reportFeedbackList);
        actualReasonReportFeedback.setReasonReportFeedbackId(123L);
        actualReasonReportFeedback.setReasonReportName("Just cause");
        ArrayList<ReportFeedback> reportFeedbackList1 = new ArrayList<>();
        actualReasonReportFeedback.setReportFeedbackList(reportFeedbackList1);
        assertEquals(123L, actualReasonReportFeedback.getReasonReportFeedbackId().longValue());
        assertEquals("Just cause", actualReasonReportFeedback.getReasonReportName());
        List<ReportFeedback> reportFeedbackList2 = actualReasonReportFeedback.getReportFeedbackList();
        assertSame(reportFeedbackList1, reportFeedbackList2);
        assertEquals(reportFeedbackList, reportFeedbackList2);
    }
}


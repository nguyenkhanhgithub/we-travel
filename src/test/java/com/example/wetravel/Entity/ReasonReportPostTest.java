package com.example.wetravel.Entity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

class ReasonReportPostTest {
    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link ReasonReportPost#ReasonReportPost()}
     *   <li>{@link ReasonReportPost#setReasonReportPostId(Long)}
     *   <li>{@link ReasonReportPost#setReasonReportPostName(String)}
     *   <li>{@link ReasonReportPost#setReportPostList(List)}
     *   <li>{@link ReasonReportPost#getReasonReportPostId()}
     *   <li>{@link ReasonReportPost#getReasonReportPostName()}
     *   <li>{@link ReasonReportPost#getReportPostList()}
     * </ul>
     */
    @Test
    void testConstructor() {
        ReasonReportPost actualReasonReportPost = new ReasonReportPost();
        actualReasonReportPost.setReasonReportPostId(123L);
        actualReasonReportPost.setReasonReportPostName("Just cause");
        ArrayList<ReportPost> reportPostList = new ArrayList<>();
        actualReasonReportPost.setReportPostList(reportPostList);
        assertEquals(123L, actualReasonReportPost.getReasonReportPostId().longValue());
        assertEquals("Just cause", actualReasonReportPost.getReasonReportPostName());
        assertSame(reportPostList, actualReasonReportPost.getReportPostList());
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link ReasonReportPost#ReasonReportPost(Long, String, List)}
     *   <li>{@link ReasonReportPost#setReasonReportPostId(Long)}
     *   <li>{@link ReasonReportPost#setReasonReportPostName(String)}
     *   <li>{@link ReasonReportPost#setReportPostList(List)}
     *   <li>{@link ReasonReportPost#getReasonReportPostId()}
     *   <li>{@link ReasonReportPost#getReasonReportPostName()}
     *   <li>{@link ReasonReportPost#getReportPostList()}
     * </ul>
     */
    @Test
    void testConstructor2() {
        ArrayList<ReportPost> reportPostList = new ArrayList<>();
        ReasonReportPost actualReasonReportPost = new ReasonReportPost(123L, "Just cause", reportPostList);
        actualReasonReportPost.setReasonReportPostId(123L);
        actualReasonReportPost.setReasonReportPostName("Just cause");
        ArrayList<ReportPost> reportPostList1 = new ArrayList<>();
        actualReasonReportPost.setReportPostList(reportPostList1);
        assertEquals(123L, actualReasonReportPost.getReasonReportPostId().longValue());
        assertEquals("Just cause", actualReasonReportPost.getReasonReportPostName());
        List<ReportPost> reportPostList2 = actualReasonReportPost.getReportPostList();
        assertSame(reportPostList1, reportPostList2);
        assertEquals(reportPostList, reportPostList2);
    }
}


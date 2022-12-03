package com.example.wetravel.Entity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

class ReasonCancelTest {
    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link ReasonCancel#ReasonCancel()}
     *   <li>{@link ReasonCancel#setReasonCancelId(Long)}
     *   <li>{@link ReasonCancel#setReasonCancelName(String)}
     *   <li>{@link ReasonCancel#setRequestCancelList(List)}
     *   <li>{@link ReasonCancel#getReasonCancelId()}
     *   <li>{@link ReasonCancel#getReasonCancelName()}
     *   <li>{@link ReasonCancel#getRequestCancelList()}
     * </ul>
     */
    @Test
    void testConstructor() {
        ReasonCancel actualReasonCancel = new ReasonCancel();
        actualReasonCancel.setReasonCancelId(123L);
        actualReasonCancel.setReasonCancelName("Just cause");
        ArrayList<RequestCancel> requestCancelList = new ArrayList<>();
        actualReasonCancel.setRequestCancelList(requestCancelList);
        assertEquals(123L, actualReasonCancel.getReasonCancelId().longValue());
        assertEquals("Just cause", actualReasonCancel.getReasonCancelName());
        assertSame(requestCancelList, actualReasonCancel.getRequestCancelList());
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link ReasonCancel#ReasonCancel(Long, String, List)}
     *   <li>{@link ReasonCancel#setReasonCancelId(Long)}
     *   <li>{@link ReasonCancel#setReasonCancelName(String)}
     *   <li>{@link ReasonCancel#setRequestCancelList(List)}
     *   <li>{@link ReasonCancel#getReasonCancelId()}
     *   <li>{@link ReasonCancel#getReasonCancelName()}
     *   <li>{@link ReasonCancel#getRequestCancelList()}
     * </ul>
     */
    @Test
    void testConstructor2() {
        ArrayList<RequestCancel> requestCancelList = new ArrayList<>();
        ReasonCancel actualReasonCancel = new ReasonCancel(123L, "Just cause", requestCancelList);
        actualReasonCancel.setReasonCancelId(123L);
        actualReasonCancel.setReasonCancelName("Just cause");
        ArrayList<RequestCancel> requestCancelList1 = new ArrayList<>();
        actualReasonCancel.setRequestCancelList(requestCancelList1);
        assertEquals(123L, actualReasonCancel.getReasonCancelId().longValue());
        assertEquals("Just cause", actualReasonCancel.getReasonCancelName());
        List<RequestCancel> requestCancelList2 = actualReasonCancel.getRequestCancelList();
        assertSame(requestCancelList1, requestCancelList2);
        assertEquals(requestCancelList, requestCancelList2);
    }
}


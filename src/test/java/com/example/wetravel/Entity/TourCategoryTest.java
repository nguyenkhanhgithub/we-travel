package com.example.wetravel.Entity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

class TourCategoryTest {
    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link TourCategory#TourCategory()}
     *   <li>{@link TourCategory#setTourCategoryId(Long)}
     *   <li>{@link TourCategory#setTourCategoryName(String)}
     *   <li>{@link TourCategory#setTourList(List)}
     *   <li>{@link TourCategory#getTourCategoryId()}
     *   <li>{@link TourCategory#getTourCategoryName()}
     *   <li>{@link TourCategory#getTourList()}
     * </ul>
     */
    @Test
    void testConstructor() {
        TourCategory actualTourCategory = new TourCategory();
        actualTourCategory.setTourCategoryId(123L);
        actualTourCategory.setTourCategoryName("Tour Category Name");
        ArrayList<Tour> tourList = new ArrayList<>();
        actualTourCategory.setTourList(tourList);
        assertEquals(123L, actualTourCategory.getTourCategoryId().longValue());
        assertEquals("Tour Category Name", actualTourCategory.getTourCategoryName());
        assertSame(tourList, actualTourCategory.getTourList());
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link TourCategory#TourCategory(Long, String, List)}
     *   <li>{@link TourCategory#setTourCategoryId(Long)}
     *   <li>{@link TourCategory#setTourCategoryName(String)}
     *   <li>{@link TourCategory#setTourList(List)}
     *   <li>{@link TourCategory#getTourCategoryId()}
     *   <li>{@link TourCategory#getTourCategoryName()}
     *   <li>{@link TourCategory#getTourList()}
     * </ul>
     */
    @Test
    void testConstructor2() {
        ArrayList<Tour> tourList = new ArrayList<>();
        TourCategory actualTourCategory = new TourCategory(123L, "Tour Category Name", tourList);
        actualTourCategory.setTourCategoryId(123L);
        actualTourCategory.setTourCategoryName("Tour Category Name");
        ArrayList<Tour> tourList1 = new ArrayList<>();
        actualTourCategory.setTourList(tourList1);
        assertEquals(123L, actualTourCategory.getTourCategoryId().longValue());
        assertEquals("Tour Category Name", actualTourCategory.getTourCategoryName());
        List<Tour> tourList2 = actualTourCategory.getTourList();
        assertSame(tourList1, tourList2);
        assertEquals(tourList, tourList2);
    }
}


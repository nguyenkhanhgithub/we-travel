package com.example.wetravel.Entity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

class UtilitiesSubcategoryTest {
    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link UtilitiesSubcategory#UtilitiesSubcategory()}
     *   <li>{@link UtilitiesSubcategory#setUtilitiesCategoryId(UtilitiesCategory)}
     *   <li>{@link UtilitiesSubcategory#setUtilitiesServiceList(List)}
     *   <li>{@link UtilitiesSubcategory#setUtilitiesSubcategoryId(Long)}
     *   <li>{@link UtilitiesSubcategory#setUtilitiesSubcategoryName(String)}
     *   <li>{@link UtilitiesSubcategory#getUtilitiesCategoryId()}
     *   <li>{@link UtilitiesSubcategory#getUtilitiesServiceList()}
     *   <li>{@link UtilitiesSubcategory#getUtilitiesSubcategoryId()}
     *   <li>{@link UtilitiesSubcategory#getUtilitiesSubcategoryName()}
     * </ul>
     */
    @Test
    void testConstructor() {
        UtilitiesSubcategory actualUtilitiesSubcategory = new UtilitiesSubcategory();
        UtilitiesCategory utilitiesCategory = new UtilitiesCategory();
        utilitiesCategory.setUtilitiesCategoryId(123L);
        utilitiesCategory.setUtilitiesCategoryName("Utilities Category Name");
        ArrayList<UtilitiesSubcategory> utilitiesSubcategoryList = new ArrayList<>();
        utilitiesCategory.setUtilitiesSubcategoryList(utilitiesSubcategoryList);
        actualUtilitiesSubcategory.setUtilitiesCategoryId(utilitiesCategory);
        ArrayList<UtilitiesService> utilitiesServiceList = new ArrayList<>();
        actualUtilitiesSubcategory.setUtilitiesServiceList(utilitiesServiceList);
        actualUtilitiesSubcategory.setUtilitiesSubcategoryId(123L);
        actualUtilitiesSubcategory.setUtilitiesSubcategoryName("Utilities Subcategory Name");
        assertSame(utilitiesCategory, actualUtilitiesSubcategory.getUtilitiesCategoryId());
        List<UtilitiesService> utilitiesServiceList1 = actualUtilitiesSubcategory.getUtilitiesServiceList();
        assertSame(utilitiesServiceList, utilitiesServiceList1);
        assertEquals(utilitiesSubcategoryList, utilitiesServiceList1);
        assertEquals(123L, actualUtilitiesSubcategory.getUtilitiesSubcategoryId().longValue());
        assertEquals("Utilities Subcategory Name", actualUtilitiesSubcategory.getUtilitiesSubcategoryName());
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link UtilitiesSubcategory#UtilitiesSubcategory(Long, String, UtilitiesCategory, List)}
     *   <li>{@link UtilitiesSubcategory#setUtilitiesCategoryId(UtilitiesCategory)}
     *   <li>{@link UtilitiesSubcategory#setUtilitiesServiceList(List)}
     *   <li>{@link UtilitiesSubcategory#setUtilitiesSubcategoryId(Long)}
     *   <li>{@link UtilitiesSubcategory#setUtilitiesSubcategoryName(String)}
     *   <li>{@link UtilitiesSubcategory#getUtilitiesCategoryId()}
     *   <li>{@link UtilitiesSubcategory#getUtilitiesServiceList()}
     *   <li>{@link UtilitiesSubcategory#getUtilitiesSubcategoryId()}
     *   <li>{@link UtilitiesSubcategory#getUtilitiesSubcategoryName()}
     * </ul>
     */
    @Test
    void testConstructor2() {
        UtilitiesCategory utilitiesCategory = new UtilitiesCategory();
        utilitiesCategory.setUtilitiesCategoryId(123L);
        utilitiesCategory.setUtilitiesCategoryName("Utilities Category Name");
        ArrayList<UtilitiesSubcategory> utilitiesSubcategoryList = new ArrayList<>();
        utilitiesCategory.setUtilitiesSubcategoryList(utilitiesSubcategoryList);
        ArrayList<UtilitiesService> utilitiesServiceList = new ArrayList<>();
        UtilitiesSubcategory actualUtilitiesSubcategory = new UtilitiesSubcategory(123L, "Utilities Subcategory Name",
                utilitiesCategory, utilitiesServiceList);
        UtilitiesCategory utilitiesCategory1 = new UtilitiesCategory();
        utilitiesCategory1.setUtilitiesCategoryId(123L);
        utilitiesCategory1.setUtilitiesCategoryName("Utilities Category Name");
        ArrayList<UtilitiesSubcategory> utilitiesSubcategoryList1 = new ArrayList<>();
        utilitiesCategory1.setUtilitiesSubcategoryList(utilitiesSubcategoryList1);
        actualUtilitiesSubcategory.setUtilitiesCategoryId(utilitiesCategory1);
        ArrayList<UtilitiesService> utilitiesServiceList1 = new ArrayList<>();
        actualUtilitiesSubcategory.setUtilitiesServiceList(utilitiesServiceList1);
        actualUtilitiesSubcategory.setUtilitiesSubcategoryId(123L);
        actualUtilitiesSubcategory.setUtilitiesSubcategoryName("Utilities Subcategory Name");
        assertSame(utilitiesCategory1, actualUtilitiesSubcategory.getUtilitiesCategoryId());
        List<UtilitiesService> utilitiesServiceList2 = actualUtilitiesSubcategory.getUtilitiesServiceList();
        assertSame(utilitiesServiceList1, utilitiesServiceList2);
        assertEquals(utilitiesSubcategoryList, utilitiesServiceList2);
        assertEquals(utilitiesServiceList, utilitiesServiceList2);
        assertEquals(utilitiesSubcategoryList1, utilitiesServiceList2);
        assertEquals(123L, actualUtilitiesSubcategory.getUtilitiesSubcategoryId().longValue());
        assertEquals("Utilities Subcategory Name", actualUtilitiesSubcategory.getUtilitiesSubcategoryName());
    }
}


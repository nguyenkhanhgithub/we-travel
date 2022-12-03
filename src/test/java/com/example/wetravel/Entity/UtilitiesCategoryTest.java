package com.example.wetravel.Entity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

class UtilitiesCategoryTest {
    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link UtilitiesCategory#UtilitiesCategory()}
     *   <li>{@link UtilitiesCategory#setUtilitiesCategoryId(Long)}
     *   <li>{@link UtilitiesCategory#setUtilitiesCategoryName(String)}
     *   <li>{@link UtilitiesCategory#setUtilitiesSubcategoryList(List)}
     *   <li>{@link UtilitiesCategory#getUtilitiesCategoryId()}
     *   <li>{@link UtilitiesCategory#getUtilitiesCategoryName()}
     *   <li>{@link UtilitiesCategory#getUtilitiesSubcategoryList()}
     * </ul>
     */
    @Test
    void testConstructor() {
        UtilitiesCategory actualUtilitiesCategory = new UtilitiesCategory();
        actualUtilitiesCategory.setUtilitiesCategoryId(123L);
        actualUtilitiesCategory.setUtilitiesCategoryName("Utilities Category Name");
        ArrayList<UtilitiesSubcategory> utilitiesSubcategoryList = new ArrayList<>();
        actualUtilitiesCategory.setUtilitiesSubcategoryList(utilitiesSubcategoryList);
        assertEquals(123L, actualUtilitiesCategory.getUtilitiesCategoryId().longValue());
        assertEquals("Utilities Category Name", actualUtilitiesCategory.getUtilitiesCategoryName());
        assertSame(utilitiesSubcategoryList, actualUtilitiesCategory.getUtilitiesSubcategoryList());
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link UtilitiesCategory#UtilitiesCategory(Long, String, List)}
     *   <li>{@link UtilitiesCategory#setUtilitiesCategoryId(Long)}
     *   <li>{@link UtilitiesCategory#setUtilitiesCategoryName(String)}
     *   <li>{@link UtilitiesCategory#setUtilitiesSubcategoryList(List)}
     *   <li>{@link UtilitiesCategory#getUtilitiesCategoryId()}
     *   <li>{@link UtilitiesCategory#getUtilitiesCategoryName()}
     *   <li>{@link UtilitiesCategory#getUtilitiesSubcategoryList()}
     * </ul>
     */
    @Test
    void testConstructor2() {
        ArrayList<UtilitiesSubcategory> utilitiesSubcategoryList = new ArrayList<>();
        UtilitiesCategory actualUtilitiesCategory = new UtilitiesCategory(123L, "Utilities Category Name",
                utilitiesSubcategoryList);
        actualUtilitiesCategory.setUtilitiesCategoryId(123L);
        actualUtilitiesCategory.setUtilitiesCategoryName("Utilities Category Name");
        ArrayList<UtilitiesSubcategory> utilitiesSubcategoryList1 = new ArrayList<>();
        actualUtilitiesCategory.setUtilitiesSubcategoryList(utilitiesSubcategoryList1);
        assertEquals(123L, actualUtilitiesCategory.getUtilitiesCategoryId().longValue());
        assertEquals("Utilities Category Name", actualUtilitiesCategory.getUtilitiesCategoryName());
        List<UtilitiesSubcategory> utilitiesSubcategoryList2 = actualUtilitiesCategory.getUtilitiesSubcategoryList();
        assertSame(utilitiesSubcategoryList1, utilitiesSubcategoryList2);
        assertEquals(utilitiesSubcategoryList, utilitiesSubcategoryList2);
    }
}


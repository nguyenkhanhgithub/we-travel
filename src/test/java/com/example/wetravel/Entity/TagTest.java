package com.example.wetravel.Entity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

class TagTest {
    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link Tag#Tag()}
     *   <li>{@link Tag#setTagId(Long)}
     *   <li>{@link Tag#setTagName(String)}
     *   <li>{@link Tag#setTagOfTourList(List)}
     *   <li>{@link Tag#getTagId()}
     *   <li>{@link Tag#getTagName()}
     *   <li>{@link Tag#getTagOfTourList()}
     * </ul>
     */
    @Test
    void testConstructor() {
        Tag actualTag = new Tag();
        actualTag.setTagId(123L);
        actualTag.setTagName("Tag Name");
        ArrayList<TagOfTour> tagOfTourList = new ArrayList<>();
        actualTag.setTagOfTourList(tagOfTourList);
        assertEquals(123L, actualTag.getTagId().longValue());
        assertEquals("Tag Name", actualTag.getTagName());
        assertSame(tagOfTourList, actualTag.getTagOfTourList());
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link Tag#Tag(Long, String, List)}
     *   <li>{@link Tag#setTagId(Long)}
     *   <li>{@link Tag#setTagName(String)}
     *   <li>{@link Tag#setTagOfTourList(List)}
     *   <li>{@link Tag#getTagId()}
     *   <li>{@link Tag#getTagName()}
     *   <li>{@link Tag#getTagOfTourList()}
     * </ul>
     */
    @Test
    void testConstructor2() {
        ArrayList<TagOfTour> tagOfTourList = new ArrayList<>();
        Tag actualTag = new Tag(123L, "Tag Name", tagOfTourList);
        actualTag.setTagId(123L);
        actualTag.setTagName("Tag Name");
        ArrayList<TagOfTour> tagOfTourList1 = new ArrayList<>();
        actualTag.setTagOfTourList(tagOfTourList1);
        assertEquals(123L, actualTag.getTagId().longValue());
        assertEquals("Tag Name", actualTag.getTagName());
        List<TagOfTour> tagOfTourList2 = actualTag.getTagOfTourList();
        assertSame(tagOfTourList1, tagOfTourList2);
        assertEquals(tagOfTourList, tagOfTourList2);
    }
}


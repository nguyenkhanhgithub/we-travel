package com.example.wetravel.Entity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

class TopicTest {
    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link Topic#Topic()}
     *   <li>{@link Topic#setPostList(List)}
     *   <li>{@link Topic#setTopicId(Long)}
     *   <li>{@link Topic#setTopicName(String)}
     *   <li>{@link Topic#getPostList()}
     *   <li>{@link Topic#getTopicId()}
     *   <li>{@link Topic#getTopicName()}
     * </ul>
     */
    @Test
    void testConstructor() {
        Topic actualTopic = new Topic();
        ArrayList<Post> postList = new ArrayList<>();
        actualTopic.setPostList(postList);
        actualTopic.setTopicId(123L);
        actualTopic.setTopicName("Topic Name");
        assertSame(postList, actualTopic.getPostList());
        assertEquals(123L, actualTopic.getTopicId().longValue());
        assertEquals("Topic Name", actualTopic.getTopicName());
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link Topic#Topic(Long, String, List)}
     *   <li>{@link Topic#setPostList(List)}
     *   <li>{@link Topic#setTopicId(Long)}
     *   <li>{@link Topic#setTopicName(String)}
     *   <li>{@link Topic#getPostList()}
     *   <li>{@link Topic#getTopicId()}
     *   <li>{@link Topic#getTopicName()}
     * </ul>
     */
    @Test
    void testConstructor2() {
        ArrayList<Post> postList = new ArrayList<>();
        Topic actualTopic = new Topic(123L, "Topic Name", postList);
        ArrayList<Post> postList1 = new ArrayList<>();
        actualTopic.setPostList(postList1);
        actualTopic.setTopicId(123L);
        actualTopic.setTopicName("Topic Name");
        List<Post> postList2 = actualTopic.getPostList();
        assertSame(postList1, postList2);
        assertEquals(postList, postList2);
        assertEquals(123L, actualTopic.getTopicId().longValue());
        assertEquals("Topic Name", actualTopic.getTopicName());
    }
}


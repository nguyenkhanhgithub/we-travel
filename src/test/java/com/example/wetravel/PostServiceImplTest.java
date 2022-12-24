package com.example.wetravel;

import com.example.wetravel.DTO.CommentDTO;
import com.example.wetravel.DTO.PostDTO;
import com.example.wetravel.DTO.ReportPostRequestDTO;
import com.example.wetravel.Entity.*;
import com.example.wetravel.Exception.HandlerException;
import com.example.wetravel.Repository.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;

class PostServiceImplTest {

    private PostServiceImpl postServiceImplUnderTest;

    @BeforeEach
    void setUp() throws Exception {
        postServiceImplUnderTest = new PostServiceImpl();
        postServiceImplUnderTest.postRepository = mock(PostRepository.class);
        postServiceImplUnderTest.topicRepository = mock(TopicRepository.class);
        postServiceImplUnderTest.accountRepository = mock(AccountRepository.class);
        postServiceImplUnderTest.userRepository = mock(UserRepository.class);
        postServiceImplUnderTest.partnerRepository = mock(PartnerRepository.class);
        postServiceImplUnderTest.commentRepository = mock(CommentRepository.class);
        postServiceImplUnderTest.reportPostRepository = mock(ReportPostRepository.class);
        postServiceImplUnderTest.reasonReportPostRepository = mock(ReasonReportPostRepository.class);
    }

    @Test
    void testCreatePost() throws Exception {
        // Setup
        final PostDTO postDTO = new PostDTO(0L, 0L, 0L, "firstName", "lastName", LocalDateTime.of(2020, 1, 1, 0, 0, 0),
                "title", "description", "content", false, false, Arrays.asList(), Arrays.asList(
                new CommentDTO(0L, 0L, "firstName", "lastName", LocalDateTime.of(2020, 1, 1, 0, 0, 0), "content", 0L,
                        0L, Arrays.asList())));

        // Configure TopicRepository.getById(...).
        final Topic topic = new Topic();
        topic.setTopicId(0L);
        topic.setTopicName("topicName");
        final Post post = new Post();
        post.setPostId(0L);
        final Account accountId = new Account();
        accountId.setAccountId(0L);
        accountId.setEmail("email");
        accountId.setPassWord("passWord");
        accountId.setIsBlock(false);
        final Role roleId = new Role();
        roleId.setRoleId(0);
        roleId.setRoleName("roleName");
        roleId.setAccountList(Arrays.asList(new Account()));
        accountId.setRoleId(roleId);
        final User user = new User();
        user.setUserId(0L);
        accountId.setUser(user);
        post.setAccountId(accountId);
        topic.setPostList(Arrays.asList(post));
        when(postServiceImplUnderTest.topicRepository.getById(0L)).thenReturn(topic);

        // Configure AccountRepository.getById(...).
        final Account account = new Account();
        account.setAccountId(0L);
        account.setEmail("email");
        account.setPassWord("passWord");
        account.setIsBlock(false);
        final Role roleId1 = new Role();
        roleId1.setRoleId(0);
        roleId1.setRoleName("roleName");
        roleId1.setAccountList(Arrays.asList(new Account()));
        account.setRoleId(roleId1);
        final User user1 = new User();
        user1.setUserId(0L);
        user1.setFirstName("firstName");
        user1.setLastName("lastName");
        user1.setGender("gender");
        user1.setAddress("address");
        user1.setCity("city");
        account.setUser(user1);
        when(postServiceImplUnderTest.accountRepository.getById(0L)).thenReturn(account);

        // Configure PostRepository.save(...).
        final Post post1 = new Post();
        post1.setPostId(0L);
        final Topic topicId = new Topic();
        topicId.setTopicId(0L);
        topicId.setTopicName("topicName");
        topicId.setPostList(Arrays.asList(new Post()));
        post1.setTopicId(topicId);
        final Account accountId1 = new Account();
        accountId1.setAccountId(0L);
        final Role roleId2 = new Role();
        roleId2.setRoleId(0);
        accountId1.setRoleId(roleId2);
        post1.setAccountId(accountId1);
        post1.setTimePost(LocalDateTime.of(2020, 1, 1, 0, 0, 0));
        post1.setTitle("title");
        post1.setDescription("description");
        post1.setContent("content");
        post1.setIsPublic(false);
        post1.setIsBlock(false);
        when(postServiceImplUnderTest.postRepository.save(any(Post.class))).thenReturn(post1);

        // Run the test
        final PostDTO result = postServiceImplUnderTest.createPost(postDTO);

        // Verify the results
        verify(postServiceImplUnderTest.postRepository).save(any(Post.class));
    }

    @Test
    void testCreatePost_ThrowsHandlerException() {
        // Setup
        final PostDTO postDTO = new PostDTO(0L, 0L, 0L, "firstName", "lastName", LocalDateTime.of(2020, 1, 1, 0, 0, 0),
                "title", "description", "content", false, false, Arrays.asList(), Arrays.asList(
                new CommentDTO(0L, 0L, "firstName", "lastName", LocalDateTime.of(2020, 1, 1, 0, 0, 0), "content", 0L,
                        0L, Arrays.asList())));

        // Configure TopicRepository.getById(...).
        final Topic topic = new Topic();
        topic.setTopicId(0L);
        topic.setTopicName("topicName");
        final Post post = new Post();
        post.setPostId(0L);
        final Account accountId = new Account();
        accountId.setAccountId(0L);
        accountId.setEmail("email");
        accountId.setPassWord("passWord");
        accountId.setIsBlock(false);
        final Role roleId = new Role();
        roleId.setRoleId(0);
        roleId.setRoleName("roleName");
        roleId.setAccountList(Arrays.asList(new Account()));
        accountId.setRoleId(roleId);
        final User user = new User();
        user.setUserId(0L);
        accountId.setUser(user);
        post.setAccountId(accountId);
        topic.setPostList(Arrays.asList(post));
        when(postServiceImplUnderTest.topicRepository.getById(0L)).thenReturn(topic);

        // Configure AccountRepository.getById(...).
        final Account account = new Account();
        account.setAccountId(0L);
        account.setEmail("email");
        account.setPassWord("passWord");
        account.setIsBlock(false);
        final Role roleId1 = new Role();
        roleId1.setRoleId(0);
        roleId1.setRoleName("roleName");
        roleId1.setAccountList(Arrays.asList(new Account()));
        account.setRoleId(roleId1);
        final User user1 = new User();
        user1.setUserId(0L);
        user1.setFirstName("firstName");
        user1.setLastName("lastName");
        user1.setGender("gender");
        user1.setAddress("address");
        user1.setCity("city");
        account.setUser(user1);
        when(postServiceImplUnderTest.accountRepository.getById(0L)).thenReturn(account);

        // Configure PostRepository.save(...).
        final Post post1 = new Post();
        post1.setPostId(0L);
        final Topic topicId = new Topic();
        topicId.setTopicId(0L);
        topicId.setTopicName("topicName");
        topicId.setPostList(Arrays.asList(new Post()));
        post1.setTopicId(topicId);
        final Account accountId1 = new Account();
        accountId1.setAccountId(0L);
        final Role roleId2 = new Role();
        roleId2.setRoleId(0);
        accountId1.setRoleId(roleId2);
        post1.setAccountId(accountId1);
        post1.setTimePost(LocalDateTime.of(2020, 1, 1, 0, 0, 0));
        post1.setTitle("title");
        post1.setDescription("description");
        post1.setContent("content");
        post1.setIsPublic(false);
        post1.setIsBlock(false);
        when(postServiceImplUnderTest.postRepository.save(any(Post.class))).thenReturn(post1);

        // Run the test
        assertThatThrownBy(() -> postServiceImplUnderTest.createPost(postDTO)).isInstanceOf(HandlerException.class);
        verify(postServiceImplUnderTest.postRepository).save(any(Post.class));
    }

    @Test
    void testDeletePost() throws Exception {
        // Setup
        when(postServiceImplUnderTest.postRepository.existsPostByPostId(0L)).thenReturn(false);

        // Configure PostRepository.getById(...).
        final Post post = new Post();
        post.setPostId(0L);
        final Topic topicId = new Topic();
        topicId.setTopicId(0L);
        topicId.setTopicName("topicName");
        topicId.setPostList(Arrays.asList(new Post()));
        post.setTopicId(topicId);
        final Account accountId = new Account();
        accountId.setAccountId(0L);
        final Role roleId = new Role();
        roleId.setRoleId(0);
        accountId.setRoleId(roleId);
        post.setAccountId(accountId);
        post.setTimePost(LocalDateTime.of(2020, 1, 1, 0, 0, 0));
        post.setTitle("title");
        post.setDescription("description");
        post.setContent("content");
        post.setIsPublic(false);
        post.setIsBlock(false);
        when(postServiceImplUnderTest.postRepository.getById(0L)).thenReturn(post);

        // Run the test
        final Boolean result = postServiceImplUnderTest.deletePost(0L);

        // Verify the results
        assertThat(result).isFalse();
        verify(postServiceImplUnderTest.postRepository).delete(any(Post.class));
    }

    @Test
    void testDeletePost_ThrowsHandlerException() {
        // Setup
        when(postServiceImplUnderTest.postRepository.existsPostByPostId(0L)).thenReturn(false);

        // Configure PostRepository.getById(...).
        final Post post = new Post();
        post.setPostId(0L);
        final Topic topicId = new Topic();
        topicId.setTopicId(0L);
        topicId.setTopicName("topicName");
        topicId.setPostList(Arrays.asList(new Post()));
        post.setTopicId(topicId);
        final Account accountId = new Account();
        accountId.setAccountId(0L);
        final Role roleId = new Role();
        roleId.setRoleId(0);
        accountId.setRoleId(roleId);
        post.setAccountId(accountId);
        post.setTimePost(LocalDateTime.of(2020, 1, 1, 0, 0, 0));
        post.setTitle("title");
        post.setDescription("description");
        post.setContent("content");
        post.setIsPublic(false);
        post.setIsBlock(false);
        when(postServiceImplUnderTest.postRepository.getById(0L)).thenReturn(post);

        // Run the test
        assertThatThrownBy(() -> postServiceImplUnderTest.deletePost(0L)).isInstanceOf(HandlerException.class);
        verify(postServiceImplUnderTest.postRepository).delete(any(Post.class));
    }

    @Test
    void testGetListPost() throws Exception {
        // Setup
        // Configure PostRepository.getListPost(...).
        final Post post = new Post();
        post.setPostId(0L);
        final Topic topicId = new Topic();
        topicId.setTopicId(0L);
        topicId.setTopicName("topicName");
        topicId.setPostList(Arrays.asList(new Post()));
        post.setTopicId(topicId);
        final Account accountId = new Account();
        accountId.setAccountId(0L);
        final Role roleId = new Role();
        roleId.setRoleId(0);
        accountId.setRoleId(roleId);
        post.setAccountId(accountId);
        post.setTimePost(LocalDateTime.of(2020, 1, 1, 0, 0, 0));
        post.setTitle("title");
        post.setDescription("description");
        post.setContent("content");
        post.setIsPublic(false);
        post.setIsBlock(false);
        final List<Post> postList = Arrays.asList(post);
        when(postServiceImplUnderTest.postRepository.getListPost(eq("title"), eq(0L), eq(0), eq(0),
                eq(Arrays.asList(0L)), any(Pageable.class))).thenReturn(postList);

        // Configure PostRepository.getListPostReport(...).
        final Post post1 = new Post();
        post1.setPostId(0L);
        final Topic topicId1 = new Topic();
        topicId1.setTopicId(0L);
        topicId1.setTopicName("topicName");
        topicId1.setPostList(Arrays.asList(new Post()));
        post1.setTopicId(topicId1);
        final Account accountId1 = new Account();
        accountId1.setAccountId(0L);
        final Role roleId1 = new Role();
        roleId1.setRoleId(0);
        accountId1.setRoleId(roleId1);
        post1.setAccountId(accountId1);
        post1.setTimePost(LocalDateTime.of(2020, 1, 1, 0, 0, 0));
        post1.setTitle("title");
        post1.setDescription("description");
        post1.setContent("content");
        post1.setIsPublic(false);
        post1.setIsBlock(false);
        final List<Post> postList1 = Arrays.asList(post1);
        when(postServiceImplUnderTest.postRepository.getListPostReport(eq("title"), eq(0L), eq(0), eq(0),
                eq(Arrays.asList(0L)), any(Pageable.class))).thenReturn(postList1);

        // Configure UserRepository.getByAccountId_AccountId(...).
        final User user = new User();
        user.setUserId(0L);
        final Account accountId2 = new Account();
        accountId2.setAccountId(0L);
        accountId2.setEmail("email");
        accountId2.setPassWord("passWord");
        accountId2.setIsBlock(false);
        final Role roleId2 = new Role();
        roleId2.setRoleId(0);
        roleId2.setRoleName("roleName");
        roleId2.setAccountList(Arrays.asList(new Account()));
        accountId2.setRoleId(roleId2);
        final Partner partner = new Partner();
        partner.setPartnerId(0L);
        partner.setFirstName("firstName");
        accountId2.setPartner(partner);
        user.setAccountId(accountId2);
        user.setFirstName("firstName");
        user.setLastName("lastName");
        when(postServiceImplUnderTest.userRepository.getByAccountId_AccountId(0L)).thenReturn(user);

        // Configure PartnerRepository.getPartnerByAccountId_AccountId(...).
        final Partner partner1 = new Partner();
        partner1.setPartnerId(0L);
        final Account accountId3 = new Account();
        accountId3.setAccountId(0L);
        accountId3.setEmail("email");
        accountId3.setPassWord("passWord");
        accountId3.setIsBlock(false);
        final Role roleId3 = new Role();
        roleId3.setRoleId(0);
        roleId3.setRoleName("roleName");
        roleId3.setAccountList(Arrays.asList(new Account()));
        accountId3.setRoleId(roleId3);
        final User user1 = new User();
        user1.setUserId(0L);
        user1.setFirstName("firstName");
        accountId3.setUser(user1);
        partner1.setAccountId(accountId3);
        partner1.setFirstName("firstName");
        partner1.setLastName("lastName");
        when(postServiceImplUnderTest.partnerRepository.getPartnerByAccountId_AccountId(0L)).thenReturn(partner1);

        when(postServiceImplUnderTest.reportPostRepository.getListReportPostByPostId(0L)).thenReturn(Arrays.asList());

        // Run the test
        final Page<PostDTO> result = postServiceImplUnderTest.getListPost(0, "title", 0L, 0, 0, Arrays.asList(0L), 0,
                0);

        // Verify the results
    }

    @Test
    void testGetListPost_PostRepositoryGetListPostReturnsNoItems() throws Exception {
        // Setup
        when(postServiceImplUnderTest.postRepository.getListPost(eq("title"), eq(0L), eq(0), eq(0),
                eq(Arrays.asList(0L)), any(Pageable.class))).thenReturn(Collections.emptyList());

        // Configure PostRepository.getListPostReport(...).
        final Post post = new Post();
        post.setPostId(0L);
        final Topic topicId = new Topic();
        topicId.setTopicId(0L);
        topicId.setTopicName("topicName");
        topicId.setPostList(Arrays.asList(new Post()));
        post.setTopicId(topicId);
        final Account accountId = new Account();
        accountId.setAccountId(0L);
        final Role roleId = new Role();
        roleId.setRoleId(0);
        accountId.setRoleId(roleId);
        post.setAccountId(accountId);
        post.setTimePost(LocalDateTime.of(2020, 1, 1, 0, 0, 0));
        post.setTitle("title");
        post.setDescription("description");
        post.setContent("content");
        post.setIsPublic(false);
        post.setIsBlock(false);
        final List<Post> postList = Arrays.asList(post);
        when(postServiceImplUnderTest.postRepository.getListPostReport(eq("title"), eq(0L), eq(0), eq(0),
                eq(Arrays.asList(0L)), any(Pageable.class))).thenReturn(postList);

        // Configure UserRepository.getByAccountId_AccountId(...).
        final User user = new User();
        user.setUserId(0L);
        final Account accountId1 = new Account();
        accountId1.setAccountId(0L);
        accountId1.setEmail("email");
        accountId1.setPassWord("passWord");
        accountId1.setIsBlock(false);
        final Role roleId1 = new Role();
        roleId1.setRoleId(0);
        roleId1.setRoleName("roleName");
        roleId1.setAccountList(Arrays.asList(new Account()));
        accountId1.setRoleId(roleId1);
        final Partner partner = new Partner();
        partner.setPartnerId(0L);
        partner.setFirstName("firstName");
        accountId1.setPartner(partner);
        user.setAccountId(accountId1);
        user.setFirstName("firstName");
        user.setLastName("lastName");
        when(postServiceImplUnderTest.userRepository.getByAccountId_AccountId(0L)).thenReturn(user);

        // Configure PartnerRepository.getPartnerByAccountId_AccountId(...).
        final Partner partner1 = new Partner();
        partner1.setPartnerId(0L);
        final Account accountId2 = new Account();
        accountId2.setAccountId(0L);
        accountId2.setEmail("email");
        accountId2.setPassWord("passWord");
        accountId2.setIsBlock(false);
        final Role roleId2 = new Role();
        roleId2.setRoleId(0);
        roleId2.setRoleName("roleName");
        roleId2.setAccountList(Arrays.asList(new Account()));
        accountId2.setRoleId(roleId2);
        final User user1 = new User();
        user1.setUserId(0L);
        user1.setFirstName("firstName");
        accountId2.setUser(user1);
        partner1.setAccountId(accountId2);
        partner1.setFirstName("firstName");
        partner1.setLastName("lastName");
        when(postServiceImplUnderTest.partnerRepository.getPartnerByAccountId_AccountId(0L)).thenReturn(partner1);

        when(postServiceImplUnderTest.reportPostRepository.getListReportPostByPostId(0L)).thenReturn(Arrays.asList());

        // Run the test
        final Page<PostDTO> result = postServiceImplUnderTest.getListPost(0, "title", 0L, 0, 0, Arrays.asList(0L), 0,
                0);

        // Verify the results
    }

    @Test
    void testGetListPost_PostRepositoryGetListPostReportReturnsNoItems() throws Exception {
        // Setup
        // Configure PostRepository.getListPost(...).
        final Post post = new Post();
        post.setPostId(0L);
        final Topic topicId = new Topic();
        topicId.setTopicId(0L);
        topicId.setTopicName("topicName");
        topicId.setPostList(Arrays.asList(new Post()));
        post.setTopicId(topicId);
        final Account accountId = new Account();
        accountId.setAccountId(0L);
        final Role roleId = new Role();
        roleId.setRoleId(0);
        accountId.setRoleId(roleId);
        post.setAccountId(accountId);
        post.setTimePost(LocalDateTime.of(2020, 1, 1, 0, 0, 0));
        post.setTitle("title");
        post.setDescription("description");
        post.setContent("content");
        post.setIsPublic(false);
        post.setIsBlock(false);
        final List<Post> postList = Arrays.asList(post);
        when(postServiceImplUnderTest.postRepository.getListPost(eq("title"), eq(0L), eq(0), eq(0),
                eq(Arrays.asList(0L)), any(Pageable.class))).thenReturn(postList);

        when(postServiceImplUnderTest.postRepository.getListPostReport(eq("title"), eq(0L), eq(0), eq(0),
                eq(Arrays.asList(0L)), any(Pageable.class))).thenReturn(Collections.emptyList());

        // Configure UserRepository.getByAccountId_AccountId(...).
        final User user = new User();
        user.setUserId(0L);
        final Account accountId1 = new Account();
        accountId1.setAccountId(0L);
        accountId1.setEmail("email");
        accountId1.setPassWord("passWord");
        accountId1.setIsBlock(false);
        final Role roleId1 = new Role();
        roleId1.setRoleId(0);
        roleId1.setRoleName("roleName");
        roleId1.setAccountList(Arrays.asList(new Account()));
        accountId1.setRoleId(roleId1);
        final Partner partner = new Partner();
        partner.setPartnerId(0L);
        partner.setFirstName("firstName");
        accountId1.setPartner(partner);
        user.setAccountId(accountId1);
        user.setFirstName("firstName");
        user.setLastName("lastName");
        when(postServiceImplUnderTest.userRepository.getByAccountId_AccountId(0L)).thenReturn(user);

        // Configure PartnerRepository.getPartnerByAccountId_AccountId(...).
        final Partner partner1 = new Partner();
        partner1.setPartnerId(0L);
        final Account accountId2 = new Account();
        accountId2.setAccountId(0L);
        accountId2.setEmail("email");
        accountId2.setPassWord("passWord");
        accountId2.setIsBlock(false);
        final Role roleId2 = new Role();
        roleId2.setRoleId(0);
        roleId2.setRoleName("roleName");
        roleId2.setAccountList(Arrays.asList(new Account()));
        accountId2.setRoleId(roleId2);
        final User user1 = new User();
        user1.setUserId(0L);
        user1.setFirstName("firstName");
        accountId2.setUser(user1);
        partner1.setAccountId(accountId2);
        partner1.setFirstName("firstName");
        partner1.setLastName("lastName");
        when(postServiceImplUnderTest.partnerRepository.getPartnerByAccountId_AccountId(0L)).thenReturn(partner1);

        when(postServiceImplUnderTest.reportPostRepository.getListReportPostByPostId(0L)).thenReturn(Arrays.asList());

        // Run the test
        final Page<PostDTO> result = postServiceImplUnderTest.getListPost(0, "title", 0L, 0, 0, Arrays.asList(0L), 0,
                0);

        // Verify the results
    }

    @Test
    void testGetListPost_ReportPostRepositoryReturnsNoItems() throws Exception {
        // Setup
        // Configure PostRepository.getListPost(...).
        final Post post = new Post();
        post.setPostId(0L);
        final Topic topicId = new Topic();
        topicId.setTopicId(0L);
        topicId.setTopicName("topicName");
        topicId.setPostList(Arrays.asList(new Post()));
        post.setTopicId(topicId);
        final Account accountId = new Account();
        accountId.setAccountId(0L);
        final Role roleId = new Role();
        roleId.setRoleId(0);
        accountId.setRoleId(roleId);
        post.setAccountId(accountId);
        post.setTimePost(LocalDateTime.of(2020, 1, 1, 0, 0, 0));
        post.setTitle("title");
        post.setDescription("description");
        post.setContent("content");
        post.setIsPublic(false);
        post.setIsBlock(false);
        final List<Post> postList = Arrays.asList(post);
        when(postServiceImplUnderTest.postRepository.getListPost(eq("title"), eq(0L), eq(0), eq(0),
                eq(Arrays.asList(0L)), any(Pageable.class))).thenReturn(postList);

        // Configure PostRepository.getListPostReport(...).
        final Post post1 = new Post();
        post1.setPostId(0L);
        final Topic topicId1 = new Topic();
        topicId1.setTopicId(0L);
        topicId1.setTopicName("topicName");
        topicId1.setPostList(Arrays.asList(new Post()));
        post1.setTopicId(topicId1);
        final Account accountId1 = new Account();
        accountId1.setAccountId(0L);
        final Role roleId1 = new Role();
        roleId1.setRoleId(0);
        accountId1.setRoleId(roleId1);
        post1.setAccountId(accountId1);
        post1.setTimePost(LocalDateTime.of(2020, 1, 1, 0, 0, 0));
        post1.setTitle("title");
        post1.setDescription("description");
        post1.setContent("content");
        post1.setIsPublic(false);
        post1.setIsBlock(false);
        final List<Post> postList1 = Arrays.asList(post1);
        when(postServiceImplUnderTest.postRepository.getListPostReport(eq("title"), eq(0L), eq(0), eq(0),
                eq(Arrays.asList(0L)), any(Pageable.class))).thenReturn(postList1);

        // Configure UserRepository.getByAccountId_AccountId(...).
        final User user = new User();
        user.setUserId(0L);
        final Account accountId2 = new Account();
        accountId2.setAccountId(0L);
        accountId2.setEmail("email");
        accountId2.setPassWord("passWord");
        accountId2.setIsBlock(false);
        final Role roleId2 = new Role();
        roleId2.setRoleId(0);
        roleId2.setRoleName("roleName");
        roleId2.setAccountList(Arrays.asList(new Account()));
        accountId2.setRoleId(roleId2);
        final Partner partner = new Partner();
        partner.setPartnerId(0L);
        partner.setFirstName("firstName");
        accountId2.setPartner(partner);
        user.setAccountId(accountId2);
        user.setFirstName("firstName");
        user.setLastName("lastName");
        when(postServiceImplUnderTest.userRepository.getByAccountId_AccountId(0L)).thenReturn(user);

        // Configure PartnerRepository.getPartnerByAccountId_AccountId(...).
        final Partner partner1 = new Partner();
        partner1.setPartnerId(0L);
        final Account accountId3 = new Account();
        accountId3.setAccountId(0L);
        accountId3.setEmail("email");
        accountId3.setPassWord("passWord");
        accountId3.setIsBlock(false);
        final Role roleId3 = new Role();
        roleId3.setRoleId(0);
        roleId3.setRoleName("roleName");
        roleId3.setAccountList(Arrays.asList(new Account()));
        accountId3.setRoleId(roleId3);
        final User user1 = new User();
        user1.setUserId(0L);
        user1.setFirstName("firstName");
        accountId3.setUser(user1);
        partner1.setAccountId(accountId3);
        partner1.setFirstName("firstName");
        partner1.setLastName("lastName");
        when(postServiceImplUnderTest.partnerRepository.getPartnerByAccountId_AccountId(0L)).thenReturn(partner1);

        when(postServiceImplUnderTest.reportPostRepository.getListReportPostByPostId(0L))
                .thenReturn(Collections.emptyList());

        // Run the test
        final Page<PostDTO> result = postServiceImplUnderTest.getListPost(0, "title", 0L, 0, 0, Arrays.asList(0L), 0,
                0);

        // Verify the results
    }

    @Test
    void testGetListPost_ThrowsHandlerException() {
        // Setup
        // Configure PostRepository.getListPost(...).
        final Post post = new Post();
        post.setPostId(0L);
        final Topic topicId = new Topic();
        topicId.setTopicId(0L);
        topicId.setTopicName("topicName");
        topicId.setPostList(Arrays.asList(new Post()));
        post.setTopicId(topicId);
        final Account accountId = new Account();
        accountId.setAccountId(0L);
        final Role roleId = new Role();
        roleId.setRoleId(0);
        accountId.setRoleId(roleId);
        post.setAccountId(accountId);
        post.setTimePost(LocalDateTime.of(2020, 1, 1, 0, 0, 0));
        post.setTitle("title");
        post.setDescription("description");
        post.setContent("content");
        post.setIsPublic(false);
        post.setIsBlock(false);
        final List<Post> postList = Arrays.asList(post);
        when(postServiceImplUnderTest.postRepository.getListPost(eq("title"), eq(0L), eq(0), eq(0),
                eq(Arrays.asList(0L)), any(Pageable.class))).thenReturn(postList);

        // Configure PostRepository.getListPostReport(...).
        final Post post1 = new Post();
        post1.setPostId(0L);
        final Topic topicId1 = new Topic();
        topicId1.setTopicId(0L);
        topicId1.setTopicName("topicName");
        topicId1.setPostList(Arrays.asList(new Post()));
        post1.setTopicId(topicId1);
        final Account accountId1 = new Account();
        accountId1.setAccountId(0L);
        final Role roleId1 = new Role();
        roleId1.setRoleId(0);
        accountId1.setRoleId(roleId1);
        post1.setAccountId(accountId1);
        post1.setTimePost(LocalDateTime.of(2020, 1, 1, 0, 0, 0));
        post1.setTitle("title");
        post1.setDescription("description");
        post1.setContent("content");
        post1.setIsPublic(false);
        post1.setIsBlock(false);
        final List<Post> postList1 = Arrays.asList(post1);
        when(postServiceImplUnderTest.postRepository.getListPostReport(eq("title"), eq(0L), eq(0), eq(0),
                eq(Arrays.asList(0L)), any(Pageable.class))).thenReturn(postList1);

        // Configure UserRepository.getByAccountId_AccountId(...).
        final User user = new User();
        user.setUserId(0L);
        final Account accountId2 = new Account();
        accountId2.setAccountId(0L);
        accountId2.setEmail("email");
        accountId2.setPassWord("passWord");
        accountId2.setIsBlock(false);
        final Role roleId2 = new Role();
        roleId2.setRoleId(0);
        roleId2.setRoleName("roleName");
        roleId2.setAccountList(Arrays.asList(new Account()));
        accountId2.setRoleId(roleId2);
        final Partner partner = new Partner();
        partner.setPartnerId(0L);
        partner.setFirstName("firstName");
        accountId2.setPartner(partner);
        user.setAccountId(accountId2);
        user.setFirstName("firstName");
        user.setLastName("lastName");
        when(postServiceImplUnderTest.userRepository.getByAccountId_AccountId(0L)).thenReturn(user);

        // Configure PartnerRepository.getPartnerByAccountId_AccountId(...).
        final Partner partner1 = new Partner();
        partner1.setPartnerId(0L);
        final Account accountId3 = new Account();
        accountId3.setAccountId(0L);
        accountId3.setEmail("email");
        accountId3.setPassWord("passWord");
        accountId3.setIsBlock(false);
        final Role roleId3 = new Role();
        roleId3.setRoleId(0);
        roleId3.setRoleName("roleName");
        roleId3.setAccountList(Arrays.asList(new Account()));
        accountId3.setRoleId(roleId3);
        final User user1 = new User();
        user1.setUserId(0L);
        user1.setFirstName("firstName");
        accountId3.setUser(user1);
        partner1.setAccountId(accountId3);
        partner1.setFirstName("firstName");
        partner1.setLastName("lastName");
        when(postServiceImplUnderTest.partnerRepository.getPartnerByAccountId_AccountId(0L)).thenReturn(partner1);

        when(postServiceImplUnderTest.reportPostRepository.getListReportPostByPostId(0L)).thenReturn(Arrays.asList());

        // Run the test
        assertThatThrownBy(
                () -> postServiceImplUnderTest.getListPost(0, "title", 0L, 0, 0, Arrays.asList(0L), 0, 0))
                .isInstanceOf(HandlerException.class);
    }

    @Test
    void testGetDetailPost() throws Exception {
        // Setup
        // Configure PostRepository.getById(...).
        final Post post = new Post();
        post.setPostId(0L);
        final Topic topicId = new Topic();
        topicId.setTopicId(0L);
        topicId.setTopicName("topicName");
        topicId.setPostList(Arrays.asList(new Post()));
        post.setTopicId(topicId);
        final Account accountId = new Account();
        accountId.setAccountId(0L);
        final Role roleId = new Role();
        roleId.setRoleId(0);
        accountId.setRoleId(roleId);
        post.setAccountId(accountId);
        post.setTimePost(LocalDateTime.of(2020, 1, 1, 0, 0, 0));
        post.setTitle("title");
        post.setDescription("description");
        post.setContent("content");
        post.setIsPublic(false);
        post.setIsBlock(false);
        when(postServiceImplUnderTest.postRepository.getById(0L)).thenReturn(post);

        when(postServiceImplUnderTest.postRepository.existsPostByPostId(0L)).thenReturn(false);

        // Configure UserRepository.getByAccountId_AccountId(...).
        final User user = new User();
        user.setUserId(0L);
        final Account accountId1 = new Account();
        accountId1.setAccountId(0L);
        accountId1.setEmail("email");
        accountId1.setPassWord("passWord");
        accountId1.setIsBlock(false);
        final Role roleId1 = new Role();
        roleId1.setRoleId(0);
        roleId1.setRoleName("roleName");
        roleId1.setAccountList(Arrays.asList(new Account()));
        accountId1.setRoleId(roleId1);
        final Partner partner = new Partner();
        partner.setPartnerId(0L);
        partner.setFirstName("firstName");
        accountId1.setPartner(partner);
        user.setAccountId(accountId1);
        user.setFirstName("firstName");
        user.setLastName("lastName");
        when(postServiceImplUnderTest.userRepository.getByAccountId_AccountId(0L)).thenReturn(user);

        // Configure PartnerRepository.getPartnerByAccountId_AccountId(...).
        final Partner partner1 = new Partner();
        partner1.setPartnerId(0L);
        final Account accountId2 = new Account();
        accountId2.setAccountId(0L);
        accountId2.setEmail("email");
        accountId2.setPassWord("passWord");
        accountId2.setIsBlock(false);
        final Role roleId2 = new Role();
        roleId2.setRoleId(0);
        roleId2.setRoleName("roleName");
        roleId2.setAccountList(Arrays.asList(new Account()));
        accountId2.setRoleId(roleId2);
        final User user1 = new User();
        user1.setUserId(0L);
        user1.setFirstName("firstName");
        accountId2.setUser(user1);
        partner1.setAccountId(accountId2);
        partner1.setFirstName("firstName");
        partner1.setLastName("lastName");
        when(postServiceImplUnderTest.partnerRepository.getPartnerByAccountId_AccountId(0L)).thenReturn(partner1);

        when(postServiceImplUnderTest.reportPostRepository.getListReportPostByPostId(0L)).thenReturn(Arrays.asList());

        // Run the test
        final PostDTO result = postServiceImplUnderTest.getDetailPost(0L);

        // Verify the results
    }

    @Test
    void testGetDetailPost_ReportPostRepositoryReturnsNoItems() throws Exception {
        // Setup
        // Configure PostRepository.getById(...).
        final Post post = new Post();
        post.setPostId(0L);
        final Topic topicId = new Topic();
        topicId.setTopicId(0L);
        topicId.setTopicName("topicName");
        topicId.setPostList(Arrays.asList(new Post()));
        post.setTopicId(topicId);
        final Account accountId = new Account();
        accountId.setAccountId(0L);
        final Role roleId = new Role();
        roleId.setRoleId(0);
        accountId.setRoleId(roleId);
        post.setAccountId(accountId);
        post.setTimePost(LocalDateTime.of(2020, 1, 1, 0, 0, 0));
        post.setTitle("title");
        post.setDescription("description");
        post.setContent("content");
        post.setIsPublic(false);
        post.setIsBlock(false);
        when(postServiceImplUnderTest.postRepository.getById(0L)).thenReturn(post);

        when(postServiceImplUnderTest.postRepository.existsPostByPostId(0L)).thenReturn(false);

        // Configure UserRepository.getByAccountId_AccountId(...).
        final User user = new User();
        user.setUserId(0L);
        final Account accountId1 = new Account();
        accountId1.setAccountId(0L);
        accountId1.setEmail("email");
        accountId1.setPassWord("passWord");
        accountId1.setIsBlock(false);
        final Role roleId1 = new Role();
        roleId1.setRoleId(0);
        roleId1.setRoleName("roleName");
        roleId1.setAccountList(Arrays.asList(new Account()));
        accountId1.setRoleId(roleId1);
        final Partner partner = new Partner();
        partner.setPartnerId(0L);
        partner.setFirstName("firstName");
        accountId1.setPartner(partner);
        user.setAccountId(accountId1);
        user.setFirstName("firstName");
        user.setLastName("lastName");
        when(postServiceImplUnderTest.userRepository.getByAccountId_AccountId(0L)).thenReturn(user);

        // Configure PartnerRepository.getPartnerByAccountId_AccountId(...).
        final Partner partner1 = new Partner();
        partner1.setPartnerId(0L);
        final Account accountId2 = new Account();
        accountId2.setAccountId(0L);
        accountId2.setEmail("email");
        accountId2.setPassWord("passWord");
        accountId2.setIsBlock(false);
        final Role roleId2 = new Role();
        roleId2.setRoleId(0);
        roleId2.setRoleName("roleName");
        roleId2.setAccountList(Arrays.asList(new Account()));
        accountId2.setRoleId(roleId2);
        final User user1 = new User();
        user1.setUserId(0L);
        user1.setFirstName("firstName");
        accountId2.setUser(user1);
        partner1.setAccountId(accountId2);
        partner1.setFirstName("firstName");
        partner1.setLastName("lastName");
        when(postServiceImplUnderTest.partnerRepository.getPartnerByAccountId_AccountId(0L)).thenReturn(partner1);

        when(postServiceImplUnderTest.reportPostRepository.getListReportPostByPostId(0L))
                .thenReturn(Collections.emptyList());

        // Run the test
        final PostDTO result = postServiceImplUnderTest.getDetailPost(0L);

        // Verify the results
    }

    @Test
    void testGetDetailPost_ThrowsHandlerException() {
        // Setup
        // Configure PostRepository.getById(...).
        final Post post = new Post();
        post.setPostId(0L);
        final Topic topicId = new Topic();
        topicId.setTopicId(0L);
        topicId.setTopicName("topicName");
        topicId.setPostList(Arrays.asList(new Post()));
        post.setTopicId(topicId);
        final Account accountId = new Account();
        accountId.setAccountId(0L);
        final Role roleId = new Role();
        roleId.setRoleId(0);
        accountId.setRoleId(roleId);
        post.setAccountId(accountId);
        post.setTimePost(LocalDateTime.of(2020, 1, 1, 0, 0, 0));
        post.setTitle("title");
        post.setDescription("description");
        post.setContent("content");
        post.setIsPublic(false);
        post.setIsBlock(false);
        when(postServiceImplUnderTest.postRepository.getById(0L)).thenReturn(post);

        when(postServiceImplUnderTest.postRepository.existsPostByPostId(0L)).thenReturn(false);

        // Configure UserRepository.getByAccountId_AccountId(...).
        final User user = new User();
        user.setUserId(0L);
        final Account accountId1 = new Account();
        accountId1.setAccountId(0L);
        accountId1.setEmail("email");
        accountId1.setPassWord("passWord");
        accountId1.setIsBlock(false);
        final Role roleId1 = new Role();
        roleId1.setRoleId(0);
        roleId1.setRoleName("roleName");
        roleId1.setAccountList(Arrays.asList(new Account()));
        accountId1.setRoleId(roleId1);
        final Partner partner = new Partner();
        partner.setPartnerId(0L);
        partner.setFirstName("firstName");
        accountId1.setPartner(partner);
        user.setAccountId(accountId1);
        user.setFirstName("firstName");
        user.setLastName("lastName");
        when(postServiceImplUnderTest.userRepository.getByAccountId_AccountId(0L)).thenReturn(user);

        // Configure PartnerRepository.getPartnerByAccountId_AccountId(...).
        final Partner partner1 = new Partner();
        partner1.setPartnerId(0L);
        final Account accountId2 = new Account();
        accountId2.setAccountId(0L);
        accountId2.setEmail("email");
        accountId2.setPassWord("passWord");
        accountId2.setIsBlock(false);
        final Role roleId2 = new Role();
        roleId2.setRoleId(0);
        roleId2.setRoleName("roleName");
        roleId2.setAccountList(Arrays.asList(new Account()));
        accountId2.setRoleId(roleId2);
        final User user1 = new User();
        user1.setUserId(0L);
        user1.setFirstName("firstName");
        accountId2.setUser(user1);
        partner1.setAccountId(accountId2);
        partner1.setFirstName("firstName");
        partner1.setLastName("lastName");
        when(postServiceImplUnderTest.partnerRepository.getPartnerByAccountId_AccountId(0L)).thenReturn(partner1);

        when(postServiceImplUnderTest.reportPostRepository.getListReportPostByPostId(0L)).thenReturn(Arrays.asList());

        // Run the test
        assertThatThrownBy(() -> postServiceImplUnderTest.getDetailPost(0L)).isInstanceOf(HandlerException.class);
    }

    @Test
    void testCreateComment() throws Exception {
        // Setup
        final CommentDTO commentDTO = new CommentDTO(0L, 0L, "firstName", "lastName",
                LocalDateTime.of(2020, 1, 1, 0, 0, 0), "content", 0L, 0L, Arrays.asList());

        // Configure AccountRepository.getById(...).
        final Account account = new Account();
        account.setAccountId(0L);
        account.setEmail("email");
        account.setPassWord("passWord");
        account.setIsBlock(false);
        final Role roleId = new Role();
        roleId.setRoleId(0);
        roleId.setRoleName("roleName");
        roleId.setAccountList(Arrays.asList(new Account()));
        account.setRoleId(roleId);
        final User user = new User();
        user.setUserId(0L);
        user.setFirstName("firstName");
        user.setLastName("lastName");
        user.setGender("gender");
        user.setAddress("address");
        user.setCity("city");
        account.setUser(user);
        when(postServiceImplUnderTest.accountRepository.getById(0L)).thenReturn(account);

        // Configure PostRepository.getById(...).
        final Post post = new Post();
        post.setPostId(0L);
        final Topic topicId = new Topic();
        topicId.setTopicId(0L);
        topicId.setTopicName("topicName");
        topicId.setPostList(Arrays.asList(new Post()));
        post.setTopicId(topicId);
        final Account accountId = new Account();
        accountId.setAccountId(0L);
        final Role roleId1 = new Role();
        roleId1.setRoleId(0);
        accountId.setRoleId(roleId1);
        post.setAccountId(accountId);
        post.setTimePost(LocalDateTime.of(2020, 1, 1, 0, 0, 0));
        post.setTitle("title");
        post.setDescription("description");
        post.setContent("content");
        post.setIsPublic(false);
        post.setIsBlock(false);
        when(postServiceImplUnderTest.postRepository.getById(0L)).thenReturn(post);

        // Configure CommentRepository.save(...).
        final Comment comment = new Comment();
        comment.setCommentId(0L);
        final Account accountId1 = new Account();
        accountId1.setAccountId(0L);
        final Role roleId2 = new Role();
        roleId2.setRoleId(0);
        accountId1.setRoleId(roleId2);
        comment.setAccountId(accountId1);
        comment.setCreateDate(LocalDateTime.of(2020, 1, 1, 0, 0, 0));
        comment.setContent("content");
        comment.setParentCommentId(0L);
        final Post postId = new Post();
        postId.setPostId(0L);
        final Topic topicId1 = new Topic();
        topicId1.setTopicId(0L);
        postId.setTopicId(topicId1);
        final Account accountId2 = new Account();
        accountId2.setAccountId(0L);
        final Role roleId3 = new Role();
        roleId3.setRoleId(0);
        accountId2.setRoleId(roleId3);
        postId.setAccountId(accountId2);
        postId.setTimePost(LocalDateTime.of(2020, 1, 1, 0, 0, 0));
        postId.setTitle("title");
        postId.setDescription("description");
        postId.setContent("content");
        postId.setIsPublic(false);
        postId.setIsBlock(false);
        comment.setPostId(postId);
        when(postServiceImplUnderTest.commentRepository.save(any(Comment.class))).thenReturn(comment);

        // Run the test
        final CommentDTO result = postServiceImplUnderTest.createComment(commentDTO);

        // Verify the results
        verify(postServiceImplUnderTest.commentRepository).save(any(Comment.class));
    }

    @Test
    void testCreateComment_ThrowsHandlerException() {
        // Setup
        final CommentDTO commentDTO = new CommentDTO(0L, 0L, "firstName", "lastName",
                LocalDateTime.of(2020, 1, 1, 0, 0, 0), "content", 0L, 0L, Arrays.asList());

        // Configure AccountRepository.getById(...).
        final Account account = new Account();
        account.setAccountId(0L);
        account.setEmail("email");
        account.setPassWord("passWord");
        account.setIsBlock(false);
        final Role roleId = new Role();
        roleId.setRoleId(0);
        roleId.setRoleName("roleName");
        roleId.setAccountList(Arrays.asList(new Account()));
        account.setRoleId(roleId);
        final User user = new User();
        user.setUserId(0L);
        user.setFirstName("firstName");
        user.setLastName("lastName");
        user.setGender("gender");
        user.setAddress("address");
        user.setCity("city");
        account.setUser(user);
        when(postServiceImplUnderTest.accountRepository.getById(0L)).thenReturn(account);

        // Configure PostRepository.getById(...).
        final Post post = new Post();
        post.setPostId(0L);
        final Topic topicId = new Topic();
        topicId.setTopicId(0L);
        topicId.setTopicName("topicName");
        topicId.setPostList(Arrays.asList(new Post()));
        post.setTopicId(topicId);
        final Account accountId = new Account();
        accountId.setAccountId(0L);
        final Role roleId1 = new Role();
        roleId1.setRoleId(0);
        accountId.setRoleId(roleId1);
        post.setAccountId(accountId);
        post.setTimePost(LocalDateTime.of(2020, 1, 1, 0, 0, 0));
        post.setTitle("title");
        post.setDescription("description");
        post.setContent("content");
        post.setIsPublic(false);
        post.setIsBlock(false);
        when(postServiceImplUnderTest.postRepository.getById(0L)).thenReturn(post);

        // Configure CommentRepository.save(...).
        final Comment comment = new Comment();
        comment.setCommentId(0L);
        final Account accountId1 = new Account();
        accountId1.setAccountId(0L);
        final Role roleId2 = new Role();
        roleId2.setRoleId(0);
        accountId1.setRoleId(roleId2);
        comment.setAccountId(accountId1);
        comment.setCreateDate(LocalDateTime.of(2020, 1, 1, 0, 0, 0));
        comment.setContent("content");
        comment.setParentCommentId(0L);
        final Post postId = new Post();
        postId.setPostId(0L);
        final Topic topicId1 = new Topic();
        topicId1.setTopicId(0L);
        postId.setTopicId(topicId1);
        final Account accountId2 = new Account();
        accountId2.setAccountId(0L);
        final Role roleId3 = new Role();
        roleId3.setRoleId(0);
        accountId2.setRoleId(roleId3);
        postId.setAccountId(accountId2);
        postId.setTimePost(LocalDateTime.of(2020, 1, 1, 0, 0, 0));
        postId.setTitle("title");
        postId.setDescription("description");
        postId.setContent("content");
        postId.setIsPublic(false);
        postId.setIsBlock(false);
        comment.setPostId(postId);
        when(postServiceImplUnderTest.commentRepository.save(any(Comment.class))).thenReturn(comment);

        // Run the test
        assertThatThrownBy(() -> postServiceImplUnderTest.createComment(commentDTO))
                .isInstanceOf(HandlerException.class);
        verify(postServiceImplUnderTest.commentRepository).save(any(Comment.class));
    }

    @Test
    void testGetListCommentByPost() throws Exception {
        // Setup
        // Configure CommentRepository.getAllByPostId_PostIdAndParentCommentIdNullOrderByCreateDateDesc(...).
        final Comment comment = new Comment();
        comment.setCommentId(0L);
        final Account accountId = new Account();
        accountId.setAccountId(0L);
        final Role roleId = new Role();
        roleId.setRoleId(0);
        accountId.setRoleId(roleId);
        comment.setAccountId(accountId);
        comment.setCreateDate(LocalDateTime.of(2020, 1, 1, 0, 0, 0));
        comment.setContent("content");
        comment.setParentCommentId(0L);
        final Post postId = new Post();
        postId.setPostId(0L);
        final Topic topicId = new Topic();
        topicId.setTopicId(0L);
        postId.setTopicId(topicId);
        final Account accountId1 = new Account();
        accountId1.setAccountId(0L);
        final Role roleId1 = new Role();
        roleId1.setRoleId(0);
        accountId1.setRoleId(roleId1);
        postId.setAccountId(accountId1);
        postId.setTimePost(LocalDateTime.of(2020, 1, 1, 0, 0, 0));
        postId.setTitle("title");
        postId.setDescription("description");
        postId.setContent("content");
        postId.setIsPublic(false);
        postId.setIsBlock(false);
        comment.setPostId(postId);
        final List<Comment> commentList = Arrays.asList(comment);
        when(postServiceImplUnderTest.commentRepository.getAllByPostId_PostIdAndParentCommentIdNullOrderByCreateDateDesc(
                0L)).thenReturn(commentList);

        // Configure UserRepository.getByAccountId_AccountId(...).
        final User user = new User();
        user.setUserId(0L);
        final Account accountId2 = new Account();
        accountId2.setAccountId(0L);
        accountId2.setEmail("email");
        accountId2.setPassWord("passWord");
        accountId2.setIsBlock(false);
        final Role roleId2 = new Role();
        roleId2.setRoleId(0);
        roleId2.setRoleName("roleName");
        roleId2.setAccountList(Arrays.asList(new Account()));
        accountId2.setRoleId(roleId2);
        final Partner partner = new Partner();
        partner.setPartnerId(0L);
        partner.setFirstName("firstName");
        accountId2.setPartner(partner);
        user.setAccountId(accountId2);
        user.setFirstName("firstName");
        user.setLastName("lastName");
        when(postServiceImplUnderTest.userRepository.getByAccountId_AccountId(0L)).thenReturn(user);

        // Configure PartnerRepository.getPartnerByAccountId_AccountId(...).
        final Partner partner1 = new Partner();
        partner1.setPartnerId(0L);
        final Account accountId3 = new Account();
        accountId3.setAccountId(0L);
        accountId3.setEmail("email");
        accountId3.setPassWord("passWord");
        accountId3.setIsBlock(false);
        final Role roleId3 = new Role();
        roleId3.setRoleId(0);
        roleId3.setRoleName("roleName");
        roleId3.setAccountList(Arrays.asList(new Account()));
        accountId3.setRoleId(roleId3);
        final User user1 = new User();
        user1.setUserId(0L);
        user1.setFirstName("firstName");
        accountId3.setUser(user1);
        partner1.setAccountId(accountId3);
        partner1.setFirstName("firstName");
        partner1.setLastName("lastName");
        when(postServiceImplUnderTest.partnerRepository.getPartnerByAccountId_AccountId(0L)).thenReturn(partner1);

        when(postServiceImplUnderTest.commentRepository.existsCommentByParentCommentId(0L)).thenReturn(false);

        // Configure CommentRepository.getAllByParentCommentId(...).
        final Comment comment1 = new Comment();
        comment1.setCommentId(0L);
        final Account accountId4 = new Account();
        accountId4.setAccountId(0L);
        final Role roleId4 = new Role();
        roleId4.setRoleId(0);
        accountId4.setRoleId(roleId4);
        comment1.setAccountId(accountId4);
        comment1.setCreateDate(LocalDateTime.of(2020, 1, 1, 0, 0, 0));
        comment1.setContent("content");
        comment1.setParentCommentId(0L);
        final Post postId1 = new Post();
        postId1.setPostId(0L);
        final Topic topicId1 = new Topic();
        topicId1.setTopicId(0L);
        postId1.setTopicId(topicId1);
        final Account accountId5 = new Account();
        accountId5.setAccountId(0L);
        final Role roleId5 = new Role();
        roleId5.setRoleId(0);
        accountId5.setRoleId(roleId5);
        postId1.setAccountId(accountId5);
        postId1.setTimePost(LocalDateTime.of(2020, 1, 1, 0, 0, 0));
        postId1.setTitle("title");
        postId1.setDescription("description");
        postId1.setContent("content");
        postId1.setIsPublic(false);
        postId1.setIsBlock(false);
        comment1.setPostId(postId1);
        final List<Comment> commentList1 = Arrays.asList(comment1);
        when(postServiceImplUnderTest.commentRepository.getAllByParentCommentId(0L)).thenReturn(commentList1);

        // Run the test
        final Page<CommentDTO> result = postServiceImplUnderTest.getListCommentByPost(0L, 0, 0);

        // Verify the results
    }

    @Test
    void testGetListCommentByPost_CommentRepositoryGetAllByPostId_PostIdAndParentCommentIdNullOrderByCreateDateDescReturnsNoItems() throws Exception {
        // Setup
        when(postServiceImplUnderTest.commentRepository.getAllByPostId_PostIdAndParentCommentIdNullOrderByCreateDateDesc(
                0L)).thenReturn(Collections.emptyList());

        // Configure UserRepository.getByAccountId_AccountId(...).
        final User user = new User();
        user.setUserId(0L);
        final Account accountId = new Account();
        accountId.setAccountId(0L);
        accountId.setEmail("email");
        accountId.setPassWord("passWord");
        accountId.setIsBlock(false);
        final Role roleId = new Role();
        roleId.setRoleId(0);
        roleId.setRoleName("roleName");
        roleId.setAccountList(Arrays.asList(new Account()));
        accountId.setRoleId(roleId);
        final Partner partner = new Partner();
        partner.setPartnerId(0L);
        partner.setFirstName("firstName");
        accountId.setPartner(partner);
        user.setAccountId(accountId);
        user.setFirstName("firstName");
        user.setLastName("lastName");
        when(postServiceImplUnderTest.userRepository.getByAccountId_AccountId(0L)).thenReturn(user);

        // Configure PartnerRepository.getPartnerByAccountId_AccountId(...).
        final Partner partner1 = new Partner();
        partner1.setPartnerId(0L);
        final Account accountId1 = new Account();
        accountId1.setAccountId(0L);
        accountId1.setEmail("email");
        accountId1.setPassWord("passWord");
        accountId1.setIsBlock(false);
        final Role roleId1 = new Role();
        roleId1.setRoleId(0);
        roleId1.setRoleName("roleName");
        roleId1.setAccountList(Arrays.asList(new Account()));
        accountId1.setRoleId(roleId1);
        final User user1 = new User();
        user1.setUserId(0L);
        user1.setFirstName("firstName");
        accountId1.setUser(user1);
        partner1.setAccountId(accountId1);
        partner1.setFirstName("firstName");
        partner1.setLastName("lastName");
        when(postServiceImplUnderTest.partnerRepository.getPartnerByAccountId_AccountId(0L)).thenReturn(partner1);

        when(postServiceImplUnderTest.commentRepository.existsCommentByParentCommentId(0L)).thenReturn(false);

        // Configure CommentRepository.getAllByParentCommentId(...).
        final Comment comment = new Comment();
        comment.setCommentId(0L);
        final Account accountId2 = new Account();
        accountId2.setAccountId(0L);
        final Role roleId2 = new Role();
        roleId2.setRoleId(0);
        accountId2.setRoleId(roleId2);
        comment.setAccountId(accountId2);
        comment.setCreateDate(LocalDateTime.of(2020, 1, 1, 0, 0, 0));
        comment.setContent("content");
        comment.setParentCommentId(0L);
        final Post postId = new Post();
        postId.setPostId(0L);
        final Topic topicId = new Topic();
        topicId.setTopicId(0L);
        postId.setTopicId(topicId);
        final Account accountId3 = new Account();
        accountId3.setAccountId(0L);
        final Role roleId3 = new Role();
        roleId3.setRoleId(0);
        accountId3.setRoleId(roleId3);
        postId.setAccountId(accountId3);
        postId.setTimePost(LocalDateTime.of(2020, 1, 1, 0, 0, 0));
        postId.setTitle("title");
        postId.setDescription("description");
        postId.setContent("content");
        postId.setIsPublic(false);
        postId.setIsBlock(false);
        comment.setPostId(postId);
        final List<Comment> commentList = Arrays.asList(comment);
        when(postServiceImplUnderTest.commentRepository.getAllByParentCommentId(0L)).thenReturn(commentList);

        // Run the test
        final Page<CommentDTO> result = postServiceImplUnderTest.getListCommentByPost(0L, 0, 0);

        // Verify the results
    }

    @Test
    void testGetListCommentByPost_CommentRepositoryGetAllByParentCommentIdReturnsNoItems() throws Exception {
        // Setup
        // Configure CommentRepository.getAllByPostId_PostIdAndParentCommentIdNullOrderByCreateDateDesc(...).
        final Comment comment = new Comment();
        comment.setCommentId(0L);
        final Account accountId = new Account();
        accountId.setAccountId(0L);
        final Role roleId = new Role();
        roleId.setRoleId(0);
        accountId.setRoleId(roleId);
        comment.setAccountId(accountId);
        comment.setCreateDate(LocalDateTime.of(2020, 1, 1, 0, 0, 0));
        comment.setContent("content");
        comment.setParentCommentId(0L);
        final Post postId = new Post();
        postId.setPostId(0L);
        final Topic topicId = new Topic();
        topicId.setTopicId(0L);
        postId.setTopicId(topicId);
        final Account accountId1 = new Account();
        accountId1.setAccountId(0L);
        final Role roleId1 = new Role();
        roleId1.setRoleId(0);
        accountId1.setRoleId(roleId1);
        postId.setAccountId(accountId1);
        postId.setTimePost(LocalDateTime.of(2020, 1, 1, 0, 0, 0));
        postId.setTitle("title");
        postId.setDescription("description");
        postId.setContent("content");
        postId.setIsPublic(false);
        postId.setIsBlock(false);
        comment.setPostId(postId);
        final List<Comment> commentList = Arrays.asList(comment);
        when(postServiceImplUnderTest.commentRepository.getAllByPostId_PostIdAndParentCommentIdNullOrderByCreateDateDesc(
                0L)).thenReturn(commentList);

        // Configure UserRepository.getByAccountId_AccountId(...).
        final User user = new User();
        user.setUserId(0L);
        final Account accountId2 = new Account();
        accountId2.setAccountId(0L);
        accountId2.setEmail("email");
        accountId2.setPassWord("passWord");
        accountId2.setIsBlock(false);
        final Role roleId2 = new Role();
        roleId2.setRoleId(0);
        roleId2.setRoleName("roleName");
        roleId2.setAccountList(Arrays.asList(new Account()));
        accountId2.setRoleId(roleId2);
        final Partner partner = new Partner();
        partner.setPartnerId(0L);
        partner.setFirstName("firstName");
        accountId2.setPartner(partner);
        user.setAccountId(accountId2);
        user.setFirstName("firstName");
        user.setLastName("lastName");
        when(postServiceImplUnderTest.userRepository.getByAccountId_AccountId(0L)).thenReturn(user);

        // Configure PartnerRepository.getPartnerByAccountId_AccountId(...).
        final Partner partner1 = new Partner();
        partner1.setPartnerId(0L);
        final Account accountId3 = new Account();
        accountId3.setAccountId(0L);
        accountId3.setEmail("email");
        accountId3.setPassWord("passWord");
        accountId3.setIsBlock(false);
        final Role roleId3 = new Role();
        roleId3.setRoleId(0);
        roleId3.setRoleName("roleName");
        roleId3.setAccountList(Arrays.asList(new Account()));
        accountId3.setRoleId(roleId3);
        final User user1 = new User();
        user1.setUserId(0L);
        user1.setFirstName("firstName");
        accountId3.setUser(user1);
        partner1.setAccountId(accountId3);
        partner1.setFirstName("firstName");
        partner1.setLastName("lastName");
        when(postServiceImplUnderTest.partnerRepository.getPartnerByAccountId_AccountId(0L)).thenReturn(partner1);

        when(postServiceImplUnderTest.commentRepository.existsCommentByParentCommentId(0L)).thenReturn(false);
        when(postServiceImplUnderTest.commentRepository.getAllByParentCommentId(0L))
                .thenReturn(Collections.emptyList());

        // Run the test
        final Page<CommentDTO> result = postServiceImplUnderTest.getListCommentByPost(0L, 0, 0);

        // Verify the results
    }

    @Test
    void testGetListCommentByPost_ThrowsHandlerException() {
        // Setup
        // Configure CommentRepository.getAllByPostId_PostIdAndParentCommentIdNullOrderByCreateDateDesc(...).
        final Comment comment = new Comment();
        comment.setCommentId(0L);
        final Account accountId = new Account();
        accountId.setAccountId(0L);
        final Role roleId = new Role();
        roleId.setRoleId(0);
        accountId.setRoleId(roleId);
        comment.setAccountId(accountId);
        comment.setCreateDate(LocalDateTime.of(2020, 1, 1, 0, 0, 0));
        comment.setContent("content");
        comment.setParentCommentId(0L);
        final Post postId = new Post();
        postId.setPostId(0L);
        final Topic topicId = new Topic();
        topicId.setTopicId(0L);
        postId.setTopicId(topicId);
        final Account accountId1 = new Account();
        accountId1.setAccountId(0L);
        final Role roleId1 = new Role();
        roleId1.setRoleId(0);
        accountId1.setRoleId(roleId1);
        postId.setAccountId(accountId1);
        postId.setTimePost(LocalDateTime.of(2020, 1, 1, 0, 0, 0));
        postId.setTitle("title");
        postId.setDescription("description");
        postId.setContent("content");
        postId.setIsPublic(false);
        postId.setIsBlock(false);
        comment.setPostId(postId);
        final List<Comment> commentList = Arrays.asList(comment);
        when(postServiceImplUnderTest.commentRepository.getAllByPostId_PostIdAndParentCommentIdNullOrderByCreateDateDesc(
                0L)).thenReturn(commentList);

        // Configure UserRepository.getByAccountId_AccountId(...).
        final User user = new User();
        user.setUserId(0L);
        final Account accountId2 = new Account();
        accountId2.setAccountId(0L);
        accountId2.setEmail("email");
        accountId2.setPassWord("passWord");
        accountId2.setIsBlock(false);
        final Role roleId2 = new Role();
        roleId2.setRoleId(0);
        roleId2.setRoleName("roleName");
        roleId2.setAccountList(Arrays.asList(new Account()));
        accountId2.setRoleId(roleId2);
        final Partner partner = new Partner();
        partner.setPartnerId(0L);
        partner.setFirstName("firstName");
        accountId2.setPartner(partner);
        user.setAccountId(accountId2);
        user.setFirstName("firstName");
        user.setLastName("lastName");
        when(postServiceImplUnderTest.userRepository.getByAccountId_AccountId(0L)).thenReturn(user);

        // Configure PartnerRepository.getPartnerByAccountId_AccountId(...).
        final Partner partner1 = new Partner();
        partner1.setPartnerId(0L);
        final Account accountId3 = new Account();
        accountId3.setAccountId(0L);
        accountId3.setEmail("email");
        accountId3.setPassWord("passWord");
        accountId3.setIsBlock(false);
        final Role roleId3 = new Role();
        roleId3.setRoleId(0);
        roleId3.setRoleName("roleName");
        roleId3.setAccountList(Arrays.asList(new Account()));
        accountId3.setRoleId(roleId3);
        final User user1 = new User();
        user1.setUserId(0L);
        user1.setFirstName("firstName");
        accountId3.setUser(user1);
        partner1.setAccountId(accountId3);
        partner1.setFirstName("firstName");
        partner1.setLastName("lastName");
        when(postServiceImplUnderTest.partnerRepository.getPartnerByAccountId_AccountId(0L)).thenReturn(partner1);

        when(postServiceImplUnderTest.commentRepository.existsCommentByParentCommentId(0L)).thenReturn(false);

        // Configure CommentRepository.getAllByParentCommentId(...).
        final Comment comment1 = new Comment();
        comment1.setCommentId(0L);
        final Account accountId4 = new Account();
        accountId4.setAccountId(0L);
        final Role roleId4 = new Role();
        roleId4.setRoleId(0);
        accountId4.setRoleId(roleId4);
        comment1.setAccountId(accountId4);
        comment1.setCreateDate(LocalDateTime.of(2020, 1, 1, 0, 0, 0));
        comment1.setContent("content");
        comment1.setParentCommentId(0L);
        final Post postId1 = new Post();
        postId1.setPostId(0L);
        final Topic topicId1 = new Topic();
        topicId1.setTopicId(0L);
        postId1.setTopicId(topicId1);
        final Account accountId5 = new Account();
        accountId5.setAccountId(0L);
        final Role roleId5 = new Role();
        roleId5.setRoleId(0);
        accountId5.setRoleId(roleId5);
        postId1.setAccountId(accountId5);
        postId1.setTimePost(LocalDateTime.of(2020, 1, 1, 0, 0, 0));
        postId1.setTitle("title");
        postId1.setDescription("description");
        postId1.setContent("content");
        postId1.setIsPublic(false);
        postId1.setIsBlock(false);
        comment1.setPostId(postId1);
        final List<Comment> commentList1 = Arrays.asList(comment1);
        when(postServiceImplUnderTest.commentRepository.getAllByParentCommentId(0L)).thenReturn(commentList1);

        // Run the test
        assertThatThrownBy(() -> postServiceImplUnderTest.getListCommentByPost(0L, 0, 0))
                .isInstanceOf(HandlerException.class);
    }

    @Test
    void testGetListReplyComment() {
        // Setup
        final List<CommentDTO> commentDTOList = Arrays.asList(
                new CommentDTO(0L, 0L, "firstName", "lastName", LocalDateTime.of(2020, 1, 1, 0, 0, 0), "content", 0L,
                        0L, Arrays.asList()));

        // Configure CommentRepository.getAllByParentCommentId(...).
        final Comment comment = new Comment();
        comment.setCommentId(0L);
        final Account accountId = new Account();
        accountId.setAccountId(0L);
        final Role roleId = new Role();
        roleId.setRoleId(0);
        accountId.setRoleId(roleId);
        comment.setAccountId(accountId);
        comment.setCreateDate(LocalDateTime.of(2020, 1, 1, 0, 0, 0));
        comment.setContent("content");
        comment.setParentCommentId(0L);
        final Post postId = new Post();
        postId.setPostId(0L);
        final Topic topicId = new Topic();
        topicId.setTopicId(0L);
        postId.setTopicId(topicId);
        final Account accountId1 = new Account();
        accountId1.setAccountId(0L);
        final Role roleId1 = new Role();
        roleId1.setRoleId(0);
        accountId1.setRoleId(roleId1);
        postId.setAccountId(accountId1);
        postId.setTimePost(LocalDateTime.of(2020, 1, 1, 0, 0, 0));
        postId.setTitle("title");
        postId.setDescription("description");
        postId.setContent("content");
        postId.setIsPublic(false);
        postId.setIsBlock(false);
        comment.setPostId(postId);
        final List<Comment> commentList = Arrays.asList(comment);
        when(postServiceImplUnderTest.commentRepository.getAllByParentCommentId(0L)).thenReturn(commentList);

        // Configure UserRepository.getByAccountId_AccountId(...).
        final User user = new User();
        user.setUserId(0L);
        final Account accountId2 = new Account();
        accountId2.setAccountId(0L);
        accountId2.setEmail("email");
        accountId2.setPassWord("passWord");
        accountId2.setIsBlock(false);
        final Role roleId2 = new Role();
        roleId2.setRoleId(0);
        roleId2.setRoleName("roleName");
        roleId2.setAccountList(Arrays.asList(new Account()));
        accountId2.setRoleId(roleId2);
        final Partner partner = new Partner();
        partner.setPartnerId(0L);
        partner.setFirstName("firstName");
        accountId2.setPartner(partner);
        user.setAccountId(accountId2);
        user.setFirstName("firstName");
        user.setLastName("lastName");
        when(postServiceImplUnderTest.userRepository.getByAccountId_AccountId(0L)).thenReturn(user);

        // Configure PartnerRepository.getPartnerByAccountId_AccountId(...).
        final Partner partner1 = new Partner();
        partner1.setPartnerId(0L);
        final Account accountId3 = new Account();
        accountId3.setAccountId(0L);
        accountId3.setEmail("email");
        accountId3.setPassWord("passWord");
        accountId3.setIsBlock(false);
        final Role roleId3 = new Role();
        roleId3.setRoleId(0);
        roleId3.setRoleName("roleName");
        roleId3.setAccountList(Arrays.asList(new Account()));
        accountId3.setRoleId(roleId3);
        final User user1 = new User();
        user1.setUserId(0L);
        user1.setFirstName("firstName");
        accountId3.setUser(user1);
        partner1.setAccountId(accountId3);
        partner1.setFirstName("firstName");
        partner1.setLastName("lastName");
        when(postServiceImplUnderTest.partnerRepository.getPartnerByAccountId_AccountId(0L)).thenReturn(partner1);

        when(postServiceImplUnderTest.commentRepository.existsCommentByParentCommentId(0L)).thenReturn(false);

        // Run the test
        final List<CommentDTO> result = postServiceImplUnderTest.getListReplyComment(commentDTOList, 0L);

        // Verify the results
    }

    @Test
    void testGetListReplyComment_CommentRepositoryGetAllByParentCommentIdReturnsNoItems() {
        // Setup
        final List<CommentDTO> commentDTOList = Arrays.asList(
                new CommentDTO(0L, 0L, "firstName", "lastName", LocalDateTime.of(2020, 1, 1, 0, 0, 0), "content", 0L,
                        0L, Arrays.asList()));
        when(postServiceImplUnderTest.commentRepository.getAllByParentCommentId(0L))
                .thenReturn(Collections.emptyList());

        // Configure UserRepository.getByAccountId_AccountId(...).
        final User user = new User();
        user.setUserId(0L);
        final Account accountId = new Account();
        accountId.setAccountId(0L);
        accountId.setEmail("email");
        accountId.setPassWord("passWord");
        accountId.setIsBlock(false);
        final Role roleId = new Role();
        roleId.setRoleId(0);
        roleId.setRoleName("roleName");
        roleId.setAccountList(Arrays.asList(new Account()));
        accountId.setRoleId(roleId);
        final Partner partner = new Partner();
        partner.setPartnerId(0L);
        partner.setFirstName("firstName");
        accountId.setPartner(partner);
        user.setAccountId(accountId);
        user.setFirstName("firstName");
        user.setLastName("lastName");
        when(postServiceImplUnderTest.userRepository.getByAccountId_AccountId(0L)).thenReturn(user);

        // Configure PartnerRepository.getPartnerByAccountId_AccountId(...).
        final Partner partner1 = new Partner();
        partner1.setPartnerId(0L);
        final Account accountId1 = new Account();
        accountId1.setAccountId(0L);
        accountId1.setEmail("email");
        accountId1.setPassWord("passWord");
        accountId1.setIsBlock(false);
        final Role roleId1 = new Role();
        roleId1.setRoleId(0);
        roleId1.setRoleName("roleName");
        roleId1.setAccountList(Arrays.asList(new Account()));
        accountId1.setRoleId(roleId1);
        final User user1 = new User();
        user1.setUserId(0L);
        user1.setFirstName("firstName");
        accountId1.setUser(user1);
        partner1.setAccountId(accountId1);
        partner1.setFirstName("firstName");
        partner1.setLastName("lastName");
        when(postServiceImplUnderTest.partnerRepository.getPartnerByAccountId_AccountId(0L)).thenReturn(partner1);

        when(postServiceImplUnderTest.commentRepository.existsCommentByParentCommentId(0L)).thenReturn(false);

        // Run the test
        final List<CommentDTO> result = postServiceImplUnderTest.getListReplyComment(commentDTOList, 0L);

        // Verify the results
        assertThat(result).isEqualTo(Collections.emptyList());
    }

    @Test
    void testCreateReportPost() throws Exception {
        // Setup
        final ReportPostRequestDTO reportPostRequestDTO = new ReportPostRequestDTO(0L, 0L, 0L,
                LocalDate.of(2020, 1, 1));

        // Configure PostRepository.getById(...).
        final Post post = new Post();
        post.setPostId(0L);
        final Topic topicId = new Topic();
        topicId.setTopicId(0L);
        topicId.setTopicName("topicName");
        topicId.setPostList(Arrays.asList(new Post()));
        post.setTopicId(topicId);
        final Account accountId = new Account();
        accountId.setAccountId(0L);
        final Role roleId = new Role();
        roleId.setRoleId(0);
        accountId.setRoleId(roleId);
        post.setAccountId(accountId);
        post.setTimePost(LocalDateTime.of(2020, 1, 1, 0, 0, 0));
        post.setTitle("title");
        post.setDescription("description");
        post.setContent("content");
        post.setIsPublic(false);
        post.setIsBlock(false);
        when(postServiceImplUnderTest.postRepository.getById(0L)).thenReturn(post);

        // Configure AccountRepository.getById(...).
        final Account account = new Account();
        account.setAccountId(0L);
        account.setEmail("email");
        account.setPassWord("passWord");
        account.setIsBlock(false);
        final Role roleId1 = new Role();
        roleId1.setRoleId(0);
        roleId1.setRoleName("roleName");
        roleId1.setAccountList(Arrays.asList(new Account()));
        account.setRoleId(roleId1);
        final User user = new User();
        user.setUserId(0L);
        user.setFirstName("firstName");
        user.setLastName("lastName");
        user.setGender("gender");
        user.setAddress("address");
        user.setCity("city");
        account.setUser(user);
        when(postServiceImplUnderTest.accountRepository.getById(0L)).thenReturn(account);

        // Configure ReasonReportPostRepository.getById(...).
        final ReasonReportPost reasonReportPost = new ReasonReportPost();
        reasonReportPost.setReasonReportPostId(0L);
        reasonReportPost.setReasonReportPostName("reasonReportPostName");
        final ReportPost reportPost = new ReportPost();
        reportPost.setReportPostId(0L);
        final Post postId = new Post();
        postId.setPostId(0L);
        final Topic topicId1 = new Topic();
        topicId1.setTopicId(0L);
        topicId1.setTopicName("topicName");
        topicId1.setPostList(Arrays.asList(new Post()));
        postId.setTopicId(topicId1);
        final Account accountId1 = new Account();
        accountId1.setAccountId(0L);
        accountId1.setEmail("email");
        accountId1.setPassWord("passWord");
        accountId1.setIsBlock(false);
        postId.setAccountId(accountId1);
        reportPost.setPostId(postId);
        reasonReportPost.setReportPostList(Arrays.asList(reportPost));
        when(postServiceImplUnderTest.reasonReportPostRepository.getById(0L)).thenReturn(reasonReportPost);

        // Configure ReportPostRepository.save(...).
        final ReportPost reportPost1 = new ReportPost();
        final Post postId1 = new Post();
        postId1.setPostId(0L);
        final Topic topicId2 = new Topic();
        topicId2.setTopicId(0L);
        postId1.setTopicId(topicId2);
        final Account accountId2 = new Account();
        accountId2.setAccountId(0L);
        final Role roleId2 = new Role();
        roleId2.setRoleId(0);
        accountId2.setRoleId(roleId2);
        postId1.setAccountId(accountId2);
        postId1.setTimePost(LocalDateTime.of(2020, 1, 1, 0, 0, 0));
        postId1.setTitle("title");
        postId1.setDescription("description");
        postId1.setContent("content");
        postId1.setIsPublic(false);
        postId1.setIsBlock(false);
        reportPost1.setPostId(postId1);
        final Account accountId3 = new Account();
        accountId3.setAccountId(0L);
        final Role roleId3 = new Role();
        roleId3.setRoleId(0);
        accountId3.setRoleId(roleId3);
        reportPost1.setAccountId(accountId3);
        final ReasonReportPost reasonReportPostId = new ReasonReportPost();
        reportPost1.setReasonReportPostId(reasonReportPostId);
        reportPost1.setCreateDate(LocalDate.of(2020, 1, 1));
        when(postServiceImplUnderTest.reportPostRepository.save(any(ReportPost.class))).thenReturn(reportPost1);

        // Run the test
        final ReportPostRequestDTO result = postServiceImplUnderTest.createReportPost(reportPostRequestDTO);

        // Verify the results
        verify(postServiceImplUnderTest.reportPostRepository).save(any(ReportPost.class));
    }

    @Test
    void testCreateReportPost_ThrowsHandlerException() {
        // Setup
        final ReportPostRequestDTO reportPostRequestDTO = new ReportPostRequestDTO(0L, 0L, 0L,
                LocalDate.of(2020, 1, 1));

        // Configure PostRepository.getById(...).
        final Post post = new Post();
        post.setPostId(0L);
        final Topic topicId = new Topic();
        topicId.setTopicId(0L);
        topicId.setTopicName("topicName");
        topicId.setPostList(Arrays.asList(new Post()));
        post.setTopicId(topicId);
        final Account accountId = new Account();
        accountId.setAccountId(0L);
        final Role roleId = new Role();
        roleId.setRoleId(0);
        accountId.setRoleId(roleId);
        post.setAccountId(accountId);
        post.setTimePost(LocalDateTime.of(2020, 1, 1, 0, 0, 0));
        post.setTitle("title");
        post.setDescription("description");
        post.setContent("content");
        post.setIsPublic(false);
        post.setIsBlock(false);
        when(postServiceImplUnderTest.postRepository.getById(0L)).thenReturn(post);

        // Configure AccountRepository.getById(...).
        final Account account = new Account();
        account.setAccountId(0L);
        account.setEmail("email");
        account.setPassWord("passWord");
        account.setIsBlock(false);
        final Role roleId1 = new Role();
        roleId1.setRoleId(0);
        roleId1.setRoleName("roleName");
        roleId1.setAccountList(Arrays.asList(new Account()));
        account.setRoleId(roleId1);
        final User user = new User();
        user.setUserId(0L);
        user.setFirstName("firstName");
        user.setLastName("lastName");
        user.setGender("gender");
        user.setAddress("address");
        user.setCity("city");
        account.setUser(user);
        when(postServiceImplUnderTest.accountRepository.getById(0L)).thenReturn(account);

        // Configure ReasonReportPostRepository.getById(...).
        final ReasonReportPost reasonReportPost = new ReasonReportPost();
        reasonReportPost.setReasonReportPostId(0L);
        reasonReportPost.setReasonReportPostName("reasonReportPostName");
        final ReportPost reportPost = new ReportPost();
        reportPost.setReportPostId(0L);
        final Post postId = new Post();
        postId.setPostId(0L);
        final Topic topicId1 = new Topic();
        topicId1.setTopicId(0L);
        topicId1.setTopicName("topicName");
        topicId1.setPostList(Arrays.asList(new Post()));
        postId.setTopicId(topicId1);
        final Account accountId1 = new Account();
        accountId1.setAccountId(0L);
        accountId1.setEmail("email");
        accountId1.setPassWord("passWord");
        accountId1.setIsBlock(false);
        postId.setAccountId(accountId1);
        reportPost.setPostId(postId);
        reasonReportPost.setReportPostList(Arrays.asList(reportPost));
        when(postServiceImplUnderTest.reasonReportPostRepository.getById(0L)).thenReturn(reasonReportPost);

        // Configure ReportPostRepository.save(...).
        final ReportPost reportPost1 = new ReportPost();
        final Post postId1 = new Post();
        postId1.setPostId(0L);
        final Topic topicId2 = new Topic();
        topicId2.setTopicId(0L);
        postId1.setTopicId(topicId2);
        final Account accountId2 = new Account();
        accountId2.setAccountId(0L);
        final Role roleId2 = new Role();
        roleId2.setRoleId(0);
        accountId2.setRoleId(roleId2);
        postId1.setAccountId(accountId2);
        postId1.setTimePost(LocalDateTime.of(2020, 1, 1, 0, 0, 0));
        postId1.setTitle("title");
        postId1.setDescription("description");
        postId1.setContent("content");
        postId1.setIsPublic(false);
        postId1.setIsBlock(false);
        reportPost1.setPostId(postId1);
        final Account accountId3 = new Account();
        accountId3.setAccountId(0L);
        final Role roleId3 = new Role();
        roleId3.setRoleId(0);
        accountId3.setRoleId(roleId3);
        reportPost1.setAccountId(accountId3);
        final ReasonReportPost reasonReportPostId = new ReasonReportPost();
        reportPost1.setReasonReportPostId(reasonReportPostId);
        reportPost1.setCreateDate(LocalDate.of(2020, 1, 1));
        when(postServiceImplUnderTest.reportPostRepository.save(any(ReportPost.class))).thenReturn(reportPost1);

        // Run the test
        assertThatThrownBy(() -> postServiceImplUnderTest.createReportPost(reportPostRequestDTO))
                .isInstanceOf(HandlerException.class);
        verify(postServiceImplUnderTest.reportPostRepository).save(any(ReportPost.class));
    }
}

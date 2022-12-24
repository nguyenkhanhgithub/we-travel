package com.example.wetravel;

import com.example.wetravel.DTO.FeedbackDTO;
import com.example.wetravel.DTO.ReportFeedbackDTO;
import com.example.wetravel.Entity.*;
import com.example.wetravel.Exception.HandlerException;
import com.example.wetravel.Repository.*;
import com.example.wetravel.Service.ServiceImpl.FeedbackServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.data.domain.Page;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class FeedbackServiceImplTest {

    private FeedbackServiceImpl feedbackServiceImplUnderTest;

    @BeforeEach
    void setUp() throws Exception {
        feedbackServiceImplUnderTest = new FeedbackServiceImpl();
        feedbackServiceImplUnderTest.feedbackRepository = mock(FeedbackRepository.class);
        feedbackServiceImplUnderTest.accountRepository = mock(AccountRepository.class);
        feedbackServiceImplUnderTest.tourRepository = mock(TourRepository.class);
        feedbackServiceImplUnderTest.userBookingRepository = mock(UserBookingRepository.class);
        feedbackServiceImplUnderTest.reportFeedbackRepository = mock(ReportFeedbackRepository.class);
        feedbackServiceImplUnderTest.reasonReportFeedbackRepository = mock(ReasonReportFeedbackRepository.class);
        feedbackServiceImplUnderTest.userRepository = mock(UserRepository.class);
        feedbackServiceImplUnderTest.partnerRepository = mock(PartnerRepository.class);
    }

    @Test
    void testCreateFeedback() throws Exception {
        // Setup
        final FeedbackDTO feedbackDTO = new FeedbackDTO(0L, 0L, 0L, "tourName", 0L, LocalDate.of(2020, 1, 1), "content",
                false, "firstName", "lastName",
                Arrays.asList(new ReportFeedbackDTO(0L, "firstName", "lastName", 0L, 0L, LocalDate.of(2020, 1, 1))));

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
        account.setUser(user);
        final Partner partner = new Partner();
        partner.setFirstName("firstName");
        partner.setLastName("lastName");
        account.setPartner(partner);
        when(feedbackServiceImplUnderTest.accountRepository.getById(0L)).thenReturn(account);

        // Configure TourRepository.getById(...).
        final Tour tour = new Tour();
        tour.setTourId(0L);
        tour.setTourName("tourName");
        tour.setTourCode("tourCode");
        tour.setStartPlace("startPlace");
        tour.setEndPlace("endPlace");
        tour.setStatus(0);
        tour.setTourType(0);
        tour.setTourMode(false);
        tour.setNumberOfDay(1);
        tour.setNumberOfNight(0);
        tour.setMinAdult(0);
        tour.setMaxAdult(0);
        tour.setMinChildren(0);
        tour.setMaxChildren(0);
        tour.setMinToStart(0);
        when(feedbackServiceImplUnderTest.tourRepository.getById(0L)).thenReturn(tour);

        // Configure UserBookingRepository.getById(...).
        final UserBooking userBooking = new UserBooking();
        userBooking.setUserBookingId(0L);
        final Account accountId = new Account();
        accountId.setAccountId(0L);
        accountId.setEmail("email");
        accountId.setPassWord("passWord");
        accountId.setIsBlock(false);
        final Role roleId1 = new Role();
        roleId1.setRoleId(0);
        roleId1.setRoleName("roleName");
        roleId1.setAccountList(Arrays.asList(new Account()));
        accountId.setRoleId(roleId1);
        final User user1 = new User();
        user1.setUserId(0L);
        user1.setFirstName("firstName");
        user1.setLastName("lastName");
        accountId.setUser(user1);
        userBooking.setAccountId(accountId);
        userBooking.setIsFeedback(false);
        when(feedbackServiceImplUnderTest.userBookingRepository.getById(0L)).thenReturn(userBooking);

        // Configure UserBookingRepository.save(...).
        final UserBooking userBooking1 = new UserBooking();
        userBooking1.setUserBookingId(0L);
        final Account accountId1 = new Account();
        accountId1.setAccountId(0L);
        accountId1.setEmail("email");
        accountId1.setPassWord("passWord");
        accountId1.setIsBlock(false);
        final Role roleId2 = new Role();
        roleId2.setRoleId(0);
        roleId2.setRoleName("roleName");
        roleId2.setAccountList(Arrays.asList(new Account()));
        accountId1.setRoleId(roleId2);
        final User user2 = new User();
        user2.setUserId(0L);
        user2.setFirstName("firstName");
        user2.setLastName("lastName");
        accountId1.setUser(user2);
        userBooking1.setAccountId(accountId1);
        userBooking1.setIsFeedback(false);
        when(feedbackServiceImplUnderTest.userBookingRepository.save(any(UserBooking.class))).thenReturn(userBooking1);

        // Configure FeedbackRepository.save(...).
        final Feedback feedback = new Feedback();
        feedback.setFeedbackId(0L);
        final Account accountId2 = new Account();
        accountId2.setAccountId(0L);
        final Role roleId3 = new Role();
        roleId3.setRoleId(0);
        accountId2.setRoleId(roleId3);
        final User user3 = new User();
        user3.setFirstName("firstName");
        user3.setLastName("lastName");
        accountId2.setUser(user3);
        final Partner partner1 = new Partner();
        partner1.setFirstName("firstName");
        partner1.setLastName("lastName");
        accountId2.setPartner(partner1);
        feedback.setAccountId(accountId2);
        final Tour tourId = new Tour();
        tourId.setTourId(0L);
        tourId.setTourName("tourName");
        feedback.setTourId(tourId);
        feedback.setCreateDate(LocalDate.of(2020, 1, 1));
        feedback.setContent("content");
        feedback.setIsBlock(false);
        final UserBooking userBookingId = new UserBooking();
        userBookingId.setUserBookingId(0L);
        userBookingId.setIsFeedback(false);
        feedback.setUserBookingId(userBookingId);
        when(feedbackServiceImplUnderTest.feedbackRepository.save(any(Feedback.class))).thenReturn(feedback);

        // Run the test
        final FeedbackDTO result = feedbackServiceImplUnderTest.createFeedback(feedbackDTO);

        // Verify the results
        verify(feedbackServiceImplUnderTest.userBookingRepository).save(any(UserBooking.class));
        verify(feedbackServiceImplUnderTest.feedbackRepository).save(any(Feedback.class));
    }

    @Test
    void testCreateFeedback_ThrowsHandlerException() {
        // Setup
        final FeedbackDTO feedbackDTO = new FeedbackDTO(0L, 0L, 0L, "tourName", 0L, LocalDate.of(2020, 1, 1), "content",
                false, "firstName", "lastName",
                Arrays.asList(new ReportFeedbackDTO(0L, "firstName", "lastName", 0L, 0L, LocalDate.of(2020, 1, 1))));

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
        account.setUser(user);
        final Partner partner = new Partner();
        partner.setFirstName("firstName");
        partner.setLastName("lastName");
        account.setPartner(partner);
        when(feedbackServiceImplUnderTest.accountRepository.getById(0L)).thenReturn(account);

        // Configure TourRepository.getById(...).
        final Tour tour = new Tour();
        tour.setTourId(0L);
        tour.setTourName("tourName");
        tour.setTourCode("tourCode");
        tour.setStartPlace("startPlace");
        tour.setEndPlace("endPlace");
        tour.setStatus(0);
        tour.setTourType(0);
        tour.setTourMode(false);
        tour.setNumberOfDay(1);
        tour.setNumberOfNight(0);
        tour.setMinAdult(0);
        tour.setMaxAdult(0);
        tour.setMinChildren(0);
        tour.setMaxChildren(0);
        tour.setMinToStart(0);
        when(feedbackServiceImplUnderTest.tourRepository.getById(0L)).thenReturn(tour);

        // Configure UserBookingRepository.getById(...).
        final UserBooking userBooking = new UserBooking();
        userBooking.setUserBookingId(0L);
        final Account accountId = new Account();
        accountId.setAccountId(0L);
        accountId.setEmail("email");
        accountId.setPassWord("passWord");
        accountId.setIsBlock(false);
        final Role roleId1 = new Role();
        roleId1.setRoleId(0);
        roleId1.setRoleName("roleName");
        roleId1.setAccountList(Arrays.asList(new Account()));
        accountId.setRoleId(roleId1);
        final User user1 = new User();
        user1.setUserId(0L);
        user1.setFirstName("firstName");
        user1.setLastName("lastName");
        accountId.setUser(user1);
        userBooking.setAccountId(accountId);
        userBooking.setIsFeedback(false);
        when(feedbackServiceImplUnderTest.userBookingRepository.getById(0L)).thenReturn(userBooking);

        // Configure UserBookingRepository.save(...).
        final UserBooking userBooking1 = new UserBooking();
        userBooking1.setUserBookingId(0L);
        final Account accountId1 = new Account();
        accountId1.setAccountId(0L);
        accountId1.setEmail("email");
        accountId1.setPassWord("passWord");
        accountId1.setIsBlock(false);
        final Role roleId2 = new Role();
        roleId2.setRoleId(0);
        roleId2.setRoleName("roleName");
        roleId2.setAccountList(Arrays.asList(new Account()));
        accountId1.setRoleId(roleId2);
        final User user2 = new User();
        user2.setUserId(0L);
        user2.setFirstName("firstName");
        user2.setLastName("lastName");
        accountId1.setUser(user2);
        userBooking1.setAccountId(accountId1);
        userBooking1.setIsFeedback(false);
        when(feedbackServiceImplUnderTest.userBookingRepository.save(any(UserBooking.class))).thenReturn(userBooking1);

        // Configure FeedbackRepository.save(...).
        final Feedback feedback = new Feedback();
        feedback.setFeedbackId(0L);
        final Account accountId2 = new Account();
        accountId2.setAccountId(0L);
        final Role roleId3 = new Role();
        roleId3.setRoleId(0);
        accountId2.setRoleId(roleId3);
        final User user3 = new User();
        user3.setFirstName("firstName");
        user3.setLastName("lastName");
        accountId2.setUser(user3);
        final Partner partner1 = new Partner();
        partner1.setFirstName("firstName");
        partner1.setLastName("lastName");
        accountId2.setPartner(partner1);
        feedback.setAccountId(accountId2);
        final Tour tourId = new Tour();
        tourId.setTourId(0L);
        tourId.setTourName("tourName");
        feedback.setTourId(tourId);
        feedback.setCreateDate(LocalDate.of(2020, 1, 1));
        feedback.setContent("content");
        feedback.setIsBlock(false);
        final UserBooking userBookingId = new UserBooking();
        userBookingId.setUserBookingId(0L);
        userBookingId.setIsFeedback(false);
        feedback.setUserBookingId(userBookingId);
        when(feedbackServiceImplUnderTest.feedbackRepository.save(any(Feedback.class))).thenReturn(feedback);

        // Run the test
        assertThatThrownBy(() -> feedbackServiceImplUnderTest.createFeedback(feedbackDTO))
                .isInstanceOf(HandlerException.class);
        verify(feedbackServiceImplUnderTest.userBookingRepository).save(any(UserBooking.class));
        verify(feedbackServiceImplUnderTest.feedbackRepository).save(any(Feedback.class));
    }

    @Test
    void testCreateReportFeedback() throws Exception {
        // Setup
        final ReportFeedbackDTO reportFeedbackDTO = new ReportFeedbackDTO(0L, "firstName", "lastName", 0L, 0L,
                LocalDate.of(2020, 1, 1));

        // Configure FeedbackRepository.getById(...).
        final Feedback feedback = new Feedback();
        feedback.setFeedbackId(0L);
        final Account accountId = new Account();
        accountId.setAccountId(0L);
        final Role roleId = new Role();
        roleId.setRoleId(0);
        accountId.setRoleId(roleId);
        final User user = new User();
        user.setFirstName("firstName");
        user.setLastName("lastName");
        accountId.setUser(user);
        final Partner partner = new Partner();
        partner.setFirstName("firstName");
        partner.setLastName("lastName");
        accountId.setPartner(partner);
        feedback.setAccountId(accountId);
        final Tour tourId = new Tour();
        tourId.setTourId(0L);
        tourId.setTourName("tourName");
        feedback.setTourId(tourId);
        feedback.setCreateDate(LocalDate.of(2020, 1, 1));
        feedback.setContent("content");
        feedback.setIsBlock(false);
        final UserBooking userBookingId = new UserBooking();
        userBookingId.setUserBookingId(0L);
        userBookingId.setIsFeedback(false);
        feedback.setUserBookingId(userBookingId);
        when(feedbackServiceImplUnderTest.feedbackRepository.getById(0L)).thenReturn(feedback);

        // Configure ReasonReportFeedbackRepository.getById(...).
        final ReasonReportFeedback reasonReportFeedback = new ReasonReportFeedback();
        reasonReportFeedback.setReasonReportFeedbackId(0L);
        reasonReportFeedback.setReasonReportName("reasonReportName");
        final ReportFeedback reportFeedback = new ReportFeedback();
        reportFeedback.setReportFeedbackId(0L);
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
        accountId1.setUser(user1);
        reportFeedback.setAccountId(accountId1);
        reasonReportFeedback.setReportFeedbackList(Arrays.asList(reportFeedback));
        when(feedbackServiceImplUnderTest.reasonReportFeedbackRepository.getById(0L)).thenReturn(reasonReportFeedback);

        // Configure AccountRepository.getById(...).
        final Account account = new Account();
        account.setAccountId(0L);
        account.setEmail("email");
        account.setPassWord("passWord");
        account.setIsBlock(false);
        final Role roleId2 = new Role();
        roleId2.setRoleId(0);
        roleId2.setRoleName("roleName");
        roleId2.setAccountList(Arrays.asList(new Account()));
        account.setRoleId(roleId2);
        final User user2 = new User();
        user2.setUserId(0L);
        user2.setFirstName("firstName");
        user2.setLastName("lastName");
        account.setUser(user2);
        final Partner partner1 = new Partner();
        partner1.setFirstName("firstName");
        partner1.setLastName("lastName");
        account.setPartner(partner1);
        when(feedbackServiceImplUnderTest.accountRepository.getById(0L)).thenReturn(account);

        // Configure ReportFeedbackRepository.save(...).
        final ReportFeedback reportFeedback1 = new ReportFeedback();
        reportFeedback1.setReportFeedbackId(0L);
        final Account accountId2 = new Account();
        accountId2.setAccountId(0L);
        final Role roleId3 = new Role();
        roleId3.setRoleId(0);
        accountId2.setRoleId(roleId3);
        final User user3 = new User();
        user3.setFirstName("firstName");
        user3.setLastName("lastName");
        accountId2.setUser(user3);
        final Partner partner2 = new Partner();
        partner2.setFirstName("firstName");
        partner2.setLastName("lastName");
        accountId2.setPartner(partner2);
        reportFeedback1.setAccountId(accountId2);
        final Feedback feedbackId = new Feedback();
        feedbackId.setFeedbackId(0L);
        final Account accountId3 = new Account();
        accountId3.setAccountId(0L);
        final Role roleId4 = new Role();
        roleId4.setRoleId(0);
        accountId3.setRoleId(roleId4);
        final User user4 = new User();
        user4.setFirstName("firstName");
        user4.setLastName("lastName");
        accountId3.setUser(user4);
        final Partner partner3 = new Partner();
        partner3.setFirstName("firstName");
        partner3.setLastName("lastName");
        accountId3.setPartner(partner3);
        feedbackId.setAccountId(accountId3);
        final Tour tourId1 = new Tour();
        tourId1.setTourId(0L);
        tourId1.setTourName("tourName");
        feedbackId.setTourId(tourId1);
        feedbackId.setCreateDate(LocalDate.of(2020, 1, 1));
        feedbackId.setContent("content");
        feedbackId.setIsBlock(false);
        final UserBooking userBookingId1 = new UserBooking();
        userBookingId1.setUserBookingId(0L);
        userBookingId1.setIsFeedback(false);
        feedbackId.setUserBookingId(userBookingId1);
        reportFeedback1.setFeedbackId(feedbackId);
        final ReasonReportFeedback reasonReportFeedbackId = new ReasonReportFeedback();
        reportFeedback1.setReasonReportFeedbackId(reasonReportFeedbackId);
        reportFeedback1.setCreateDate(LocalDate.of(2020, 1, 1));
        when(feedbackServiceImplUnderTest.reportFeedbackRepository.save(any(ReportFeedback.class)))
                .thenReturn(reportFeedback1);

        // Run the test
        final ReportFeedbackDTO result = feedbackServiceImplUnderTest.createReportFeedback(reportFeedbackDTO);

        // Verify the results
        verify(feedbackServiceImplUnderTest.reportFeedbackRepository).save(any(ReportFeedback.class));
    }

    @Test
    void testCreateReportFeedback_ThrowsHandlerException() {
        // Setup
        final ReportFeedbackDTO reportFeedbackDTO = new ReportFeedbackDTO(0L, "firstName", "lastName", 0L, 0L,
                LocalDate.of(2020, 1, 1));

        // Configure FeedbackRepository.getById(...).
        final Feedback feedback = new Feedback();
        feedback.setFeedbackId(0L);
        final Account accountId = new Account();
        accountId.setAccountId(0L);
        final Role roleId = new Role();
        roleId.setRoleId(0);
        accountId.setRoleId(roleId);
        final User user = new User();
        user.setFirstName("firstName");
        user.setLastName("lastName");
        accountId.setUser(user);
        final Partner partner = new Partner();
        partner.setFirstName("firstName");
        partner.setLastName("lastName");
        accountId.setPartner(partner);
        feedback.setAccountId(accountId);
        final Tour tourId = new Tour();
        tourId.setTourId(0L);
        tourId.setTourName("tourName");
        feedback.setTourId(tourId);
        feedback.setCreateDate(LocalDate.of(2020, 1, 1));
        feedback.setContent("content");
        feedback.setIsBlock(false);
        final UserBooking userBookingId = new UserBooking();
        userBookingId.setUserBookingId(0L);
        userBookingId.setIsFeedback(false);
        feedback.setUserBookingId(userBookingId);
        when(feedbackServiceImplUnderTest.feedbackRepository.getById(0L)).thenReturn(feedback);

        // Configure ReasonReportFeedbackRepository.getById(...).
        final ReasonReportFeedback reasonReportFeedback = new ReasonReportFeedback();
        reasonReportFeedback.setReasonReportFeedbackId(0L);
        reasonReportFeedback.setReasonReportName("reasonReportName");
        final ReportFeedback reportFeedback = new ReportFeedback();
        reportFeedback.setReportFeedbackId(0L);
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
        accountId1.setUser(user1);
        reportFeedback.setAccountId(accountId1);
        reasonReportFeedback.setReportFeedbackList(Arrays.asList(reportFeedback));
        when(feedbackServiceImplUnderTest.reasonReportFeedbackRepository.getById(0L)).thenReturn(reasonReportFeedback);

        // Configure AccountRepository.getById(...).
        final Account account = new Account();
        account.setAccountId(0L);
        account.setEmail("email");
        account.setPassWord("passWord");
        account.setIsBlock(false);
        final Role roleId2 = new Role();
        roleId2.setRoleId(0);
        roleId2.setRoleName("roleName");
        roleId2.setAccountList(Arrays.asList(new Account()));
        account.setRoleId(roleId2);
        final User user2 = new User();
        user2.setUserId(0L);
        user2.setFirstName("firstName");
        user2.setLastName("lastName");
        account.setUser(user2);
        final Partner partner1 = new Partner();
        partner1.setFirstName("firstName");
        partner1.setLastName("lastName");
        account.setPartner(partner1);
        when(feedbackServiceImplUnderTest.accountRepository.getById(0L)).thenReturn(account);

        // Configure ReportFeedbackRepository.save(...).
        final ReportFeedback reportFeedback1 = new ReportFeedback();
        reportFeedback1.setReportFeedbackId(0L);
        final Account accountId2 = new Account();
        accountId2.setAccountId(0L);
        final Role roleId3 = new Role();
        roleId3.setRoleId(0);
        accountId2.setRoleId(roleId3);
        final User user3 = new User();
        user3.setFirstName("firstName");
        user3.setLastName("lastName");
        accountId2.setUser(user3);
        final Partner partner2 = new Partner();
        partner2.setFirstName("firstName");
        partner2.setLastName("lastName");
        accountId2.setPartner(partner2);
        reportFeedback1.setAccountId(accountId2);
        final Feedback feedbackId = new Feedback();
        feedbackId.setFeedbackId(0L);
        final Account accountId3 = new Account();
        accountId3.setAccountId(0L);
        final Role roleId4 = new Role();
        roleId4.setRoleId(0);
        accountId3.setRoleId(roleId4);
        final User user4 = new User();
        user4.setFirstName("firstName");
        user4.setLastName("lastName");
        accountId3.setUser(user4);
        final Partner partner3 = new Partner();
        partner3.setFirstName("firstName");
        partner3.setLastName("lastName");
        accountId3.setPartner(partner3);
        feedbackId.setAccountId(accountId3);
        final Tour tourId1 = new Tour();
        tourId1.setTourId(0L);
        tourId1.setTourName("tourName");
        feedbackId.setTourId(tourId1);
        feedbackId.setCreateDate(LocalDate.of(2020, 1, 1));
        feedbackId.setContent("content");
        feedbackId.setIsBlock(false);
        final UserBooking userBookingId1 = new UserBooking();
        userBookingId1.setUserBookingId(0L);
        userBookingId1.setIsFeedback(false);
        feedbackId.setUserBookingId(userBookingId1);
        reportFeedback1.setFeedbackId(feedbackId);
        final ReasonReportFeedback reasonReportFeedbackId = new ReasonReportFeedback();
        reportFeedback1.setReasonReportFeedbackId(reasonReportFeedbackId);
        reportFeedback1.setCreateDate(LocalDate.of(2020, 1, 1));
        when(feedbackServiceImplUnderTest.reportFeedbackRepository.save(any(ReportFeedback.class)))
                .thenReturn(reportFeedback1);

        // Run the test
        assertThatThrownBy(() -> feedbackServiceImplUnderTest.createReportFeedback(reportFeedbackDTO))
                .isInstanceOf(HandlerException.class);
        verify(feedbackServiceImplUnderTest.reportFeedbackRepository).save(any(ReportFeedback.class));
    }

    @Test
    void testBlockFeedback() throws Exception {
        // Setup
        when(feedbackServiceImplUnderTest.feedbackRepository.existsFeedbackByFeedbackId(0L)).thenReturn(false);

        // Configure FeedbackRepository.getById(...).
        final Feedback feedback = new Feedback();
        feedback.setFeedbackId(0L);
        final Account accountId = new Account();
        accountId.setAccountId(0L);
        final Role roleId = new Role();
        roleId.setRoleId(0);
        accountId.setRoleId(roleId);
        final User user = new User();
        user.setFirstName("firstName");
        user.setLastName("lastName");
        accountId.setUser(user);
        final Partner partner = new Partner();
        partner.setFirstName("firstName");
        partner.setLastName("lastName");
        accountId.setPartner(partner);
        feedback.setAccountId(accountId);
        final Tour tourId = new Tour();
        tourId.setTourId(0L);
        tourId.setTourName("tourName");
        feedback.setTourId(tourId);
        feedback.setCreateDate(LocalDate.of(2020, 1, 1));
        feedback.setContent("content");
        feedback.setIsBlock(false);
        final UserBooking userBookingId = new UserBooking();
        userBookingId.setUserBookingId(0L);
        userBookingId.setIsFeedback(false);
        feedback.setUserBookingId(userBookingId);
        when(feedbackServiceImplUnderTest.feedbackRepository.getById(0L)).thenReturn(feedback);

        // Configure FeedbackRepository.save(...).
        final Feedback feedback1 = new Feedback();
        feedback1.setFeedbackId(0L);
        final Account accountId1 = new Account();
        accountId1.setAccountId(0L);
        final Role roleId1 = new Role();
        roleId1.setRoleId(0);
        accountId1.setRoleId(roleId1);
        final User user1 = new User();
        user1.setFirstName("firstName");
        user1.setLastName("lastName");
        accountId1.setUser(user1);
        final Partner partner1 = new Partner();
        partner1.setFirstName("firstName");
        partner1.setLastName("lastName");
        accountId1.setPartner(partner1);
        feedback1.setAccountId(accountId1);
        final Tour tourId1 = new Tour();
        tourId1.setTourId(0L);
        tourId1.setTourName("tourName");
        feedback1.setTourId(tourId1);
        feedback1.setCreateDate(LocalDate.of(2020, 1, 1));
        feedback1.setContent("content");
        feedback1.setIsBlock(false);
        final UserBooking userBookingId1 = new UserBooking();
        userBookingId1.setUserBookingId(0L);
        userBookingId1.setIsFeedback(false);
        feedback1.setUserBookingId(userBookingId1);
        when(feedbackServiceImplUnderTest.feedbackRepository.save(any(Feedback.class))).thenReturn(feedback1);

        // Run the test
        final Boolean result = feedbackServiceImplUnderTest.blockFeedback(0L);

        // Verify the results
        assertThat(result).isFalse();
        verify(feedbackServiceImplUnderTest.feedbackRepository).save(any(Feedback.class));
    }

    @Test
    void testBlockFeedback_ThrowsHandlerException() {
        // Setup
        when(feedbackServiceImplUnderTest.feedbackRepository.existsFeedbackByFeedbackId(0L)).thenReturn(false);

        // Configure FeedbackRepository.getById(...).
        final Feedback feedback = new Feedback();
        feedback.setFeedbackId(0L);
        final Account accountId = new Account();
        accountId.setAccountId(0L);
        final Role roleId = new Role();
        roleId.setRoleId(0);
        accountId.setRoleId(roleId);
        final User user = new User();
        user.setFirstName("firstName");
        user.setLastName("lastName");
        accountId.setUser(user);
        final Partner partner = new Partner();
        partner.setFirstName("firstName");
        partner.setLastName("lastName");
        accountId.setPartner(partner);
        feedback.setAccountId(accountId);
        final Tour tourId = new Tour();
        tourId.setTourId(0L);
        tourId.setTourName("tourName");
        feedback.setTourId(tourId);
        feedback.setCreateDate(LocalDate.of(2020, 1, 1));
        feedback.setContent("content");
        feedback.setIsBlock(false);
        final UserBooking userBookingId = new UserBooking();
        userBookingId.setUserBookingId(0L);
        userBookingId.setIsFeedback(false);
        feedback.setUserBookingId(userBookingId);
        when(feedbackServiceImplUnderTest.feedbackRepository.getById(0L)).thenReturn(feedback);

        // Configure FeedbackRepository.save(...).
        final Feedback feedback1 = new Feedback();
        feedback1.setFeedbackId(0L);
        final Account accountId1 = new Account();
        accountId1.setAccountId(0L);
        final Role roleId1 = new Role();
        roleId1.setRoleId(0);
        accountId1.setRoleId(roleId1);
        final User user1 = new User();
        user1.setFirstName("firstName");
        user1.setLastName("lastName");
        accountId1.setUser(user1);
        final Partner partner1 = new Partner();
        partner1.setFirstName("firstName");
        partner1.setLastName("lastName");
        accountId1.setPartner(partner1);
        feedback1.setAccountId(accountId1);
        final Tour tourId1 = new Tour();
        tourId1.setTourId(0L);
        tourId1.setTourName("tourName");
        feedback1.setTourId(tourId1);
        feedback1.setCreateDate(LocalDate.of(2020, 1, 1));
        feedback1.setContent("content");
        feedback1.setIsBlock(false);
        final UserBooking userBookingId1 = new UserBooking();
        userBookingId1.setUserBookingId(0L);
        userBookingId1.setIsFeedback(false);
        feedback1.setUserBookingId(userBookingId1);
        when(feedbackServiceImplUnderTest.feedbackRepository.save(any(Feedback.class))).thenReturn(feedback1);

        // Run the test
        assertThatThrownBy(() -> feedbackServiceImplUnderTest.blockFeedback(0L)).isInstanceOf(HandlerException.class);
        verify(feedbackServiceImplUnderTest.feedbackRepository).save(any(Feedback.class));
    }

    @Test
    void testGetListFeedback() throws Exception {
        // Setup
        // Configure FeedbackRepository.getAllByTourId(...).
        final Feedback feedback = new Feedback();
        feedback.setFeedbackId(0L);
        final Account accountId = new Account();
        accountId.setAccountId(0L);
        final Role roleId = new Role();
        roleId.setRoleId(0);
        accountId.setRoleId(roleId);
        final User user = new User();
        user.setFirstName("firstName");
        user.setLastName("lastName");
        accountId.setUser(user);
        final Partner partner = new Partner();
        partner.setFirstName("firstName");
        partner.setLastName("lastName");
        accountId.setPartner(partner);
        feedback.setAccountId(accountId);
        final Tour tourId = new Tour();
        tourId.setTourId(0L);
        tourId.setTourName("tourName");
        feedback.setTourId(tourId);
        feedback.setCreateDate(LocalDate.of(2020, 1, 1));
        feedback.setContent("content");
        feedback.setIsBlock(false);
        final UserBooking userBookingId = new UserBooking();
        userBookingId.setUserBookingId(0L);
        userBookingId.setIsFeedback(false);
        feedback.setUserBookingId(userBookingId);
        final List<Feedback> feedbackList = Arrays.asList(feedback);
        when(feedbackServiceImplUnderTest.feedbackRepository.getAllByTourId(0L, 0L, 0)).thenReturn(feedbackList);

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
        account.setUser(user1);
        final Partner partner1 = new Partner();
        partner1.setFirstName("firstName");
        partner1.setLastName("lastName");
        account.setPartner(partner1);
        when(feedbackServiceImplUnderTest.accountRepository.getById(0L)).thenReturn(account);

        // Configure UserRepository.getByAccountId_AccountId(...).
        final User user2 = new User();
        user2.setUserId(0L);
        final Account accountId1 = new Account();
        accountId1.setAccountId(0L);
        accountId1.setEmail("email");
        accountId1.setPassWord("passWord");
        accountId1.setIsBlock(false);
        final Role roleId2 = new Role();
        roleId2.setRoleId(0);
        roleId2.setRoleName("roleName");
        roleId2.setAccountList(Arrays.asList(new Account()));
        accountId1.setRoleId(roleId2);
        final Partner partner2 = new Partner();
        partner2.setPartnerId(0L);
        partner2.setFirstName("firstName");
        accountId1.setPartner(partner2);
        user2.setAccountId(accountId1);
        user2.setFirstName("firstName");
        user2.setLastName("lastName");
        when(feedbackServiceImplUnderTest.userRepository.getByAccountId_AccountId(0L)).thenReturn(user2);

        // Configure PartnerRepository.getPartnerByAccountId_AccountId(...).
        final Partner partner3 = new Partner();
        partner3.setPartnerId(0L);
        final Account accountId2 = new Account();
        accountId2.setAccountId(0L);
        accountId2.setEmail("email");
        accountId2.setPassWord("passWord");
        accountId2.setIsBlock(false);
        final Role roleId3 = new Role();
        roleId3.setRoleId(0);
        roleId3.setRoleName("roleName");
        roleId3.setAccountList(Arrays.asList(new Account()));
        accountId2.setRoleId(roleId3);
        final User user3 = new User();
        user3.setUserId(0L);
        user3.setFirstName("firstName");
        accountId2.setUser(user3);
        partner3.setAccountId(accountId2);
        partner3.setFirstName("firstName");
        partner3.setLastName("lastName");
        when(feedbackServiceImplUnderTest.partnerRepository.getPartnerByAccountId_AccountId(0L)).thenReturn(partner3);

        // Run the test
        final Page<FeedbackDTO> result = feedbackServiceImplUnderTest.getListFeedback(0L, 0L, 0, 0, 0);

        // Verify the results
    }

    @Test
    void testGetListFeedback_FeedbackRepositoryReturnsNoItems() throws Exception {
        // Setup
        when(feedbackServiceImplUnderTest.feedbackRepository.getAllByTourId(0L, 0L, 0))
                .thenReturn(Collections.emptyList());

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
        account.setUser(user);
        final Partner partner = new Partner();
        partner.setFirstName("firstName");
        partner.setLastName("lastName");
        account.setPartner(partner);
        when(feedbackServiceImplUnderTest.accountRepository.getById(0L)).thenReturn(account);

        // Configure UserRepository.getByAccountId_AccountId(...).
        final User user1 = new User();
        user1.setUserId(0L);
        final Account accountId = new Account();
        accountId.setAccountId(0L);
        accountId.setEmail("email");
        accountId.setPassWord("passWord");
        accountId.setIsBlock(false);
        final Role roleId1 = new Role();
        roleId1.setRoleId(0);
        roleId1.setRoleName("roleName");
        roleId1.setAccountList(Arrays.asList(new Account()));
        accountId.setRoleId(roleId1);
        final Partner partner1 = new Partner();
        partner1.setPartnerId(0L);
        partner1.setFirstName("firstName");
        accountId.setPartner(partner1);
        user1.setAccountId(accountId);
        user1.setFirstName("firstName");
        user1.setLastName("lastName");
        when(feedbackServiceImplUnderTest.userRepository.getByAccountId_AccountId(0L)).thenReturn(user1);

        // Configure PartnerRepository.getPartnerByAccountId_AccountId(...).
        final Partner partner2 = new Partner();
        partner2.setPartnerId(0L);
        final Account accountId1 = new Account();
        accountId1.setAccountId(0L);
        accountId1.setEmail("email");
        accountId1.setPassWord("passWord");
        accountId1.setIsBlock(false);
        final Role roleId2 = new Role();
        roleId2.setRoleId(0);
        roleId2.setRoleName("roleName");
        roleId2.setAccountList(Arrays.asList(new Account()));
        accountId1.setRoleId(roleId2);
        final User user2 = new User();
        user2.setUserId(0L);
        user2.setFirstName("firstName");
        accountId1.setUser(user2);
        partner2.setAccountId(accountId1);
        partner2.setFirstName("firstName");
        partner2.setLastName("lastName");
        when(feedbackServiceImplUnderTest.partnerRepository.getPartnerByAccountId_AccountId(0L)).thenReturn(partner2);

        // Run the test
        final Page<FeedbackDTO> result = feedbackServiceImplUnderTest.getListFeedback(0L, 0L, 0, 0, 0);

        // Verify the results
    }

    @Test
    void testGetListFeedback_ThrowsHandlerException() {
        // Setup
        // Configure FeedbackRepository.getAllByTourId(...).
        final Feedback feedback = new Feedback();
        feedback.setFeedbackId(0L);
        final Account accountId = new Account();
        accountId.setAccountId(0L);
        final Role roleId = new Role();
        roleId.setRoleId(0);
        accountId.setRoleId(roleId);
        final User user = new User();
        user.setFirstName("firstName");
        user.setLastName("lastName");
        accountId.setUser(user);
        final Partner partner = new Partner();
        partner.setFirstName("firstName");
        partner.setLastName("lastName");
        accountId.setPartner(partner);
        feedback.setAccountId(accountId);
        final Tour tourId = new Tour();
        tourId.setTourId(0L);
        tourId.setTourName("tourName");
        feedback.setTourId(tourId);
        feedback.setCreateDate(LocalDate.of(2020, 1, 1));
        feedback.setContent("content");
        feedback.setIsBlock(false);
        final UserBooking userBookingId = new UserBooking();
        userBookingId.setUserBookingId(0L);
        userBookingId.setIsFeedback(false);
        feedback.setUserBookingId(userBookingId);
        final List<Feedback> feedbackList = Arrays.asList(feedback);
        when(feedbackServiceImplUnderTest.feedbackRepository.getAllByTourId(0L, 0L, 0)).thenReturn(feedbackList);

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
        account.setUser(user1);
        final Partner partner1 = new Partner();
        partner1.setFirstName("firstName");
        partner1.setLastName("lastName");
        account.setPartner(partner1);
        when(feedbackServiceImplUnderTest.accountRepository.getById(0L)).thenReturn(account);

        // Configure UserRepository.getByAccountId_AccountId(...).
        final User user2 = new User();
        user2.setUserId(0L);
        final Account accountId1 = new Account();
        accountId1.setAccountId(0L);
        accountId1.setEmail("email");
        accountId1.setPassWord("passWord");
        accountId1.setIsBlock(false);
        final Role roleId2 = new Role();
        roleId2.setRoleId(0);
        roleId2.setRoleName("roleName");
        roleId2.setAccountList(Arrays.asList(new Account()));
        accountId1.setRoleId(roleId2);
        final Partner partner2 = new Partner();
        partner2.setPartnerId(0L);
        partner2.setFirstName("firstName");
        accountId1.setPartner(partner2);
        user2.setAccountId(accountId1);
        user2.setFirstName("firstName");
        user2.setLastName("lastName");
        when(feedbackServiceImplUnderTest.userRepository.getByAccountId_AccountId(0L)).thenReturn(user2);

        // Configure PartnerRepository.getPartnerByAccountId_AccountId(...).
        final Partner partner3 = new Partner();
        partner3.setPartnerId(0L);
        final Account accountId2 = new Account();
        accountId2.setAccountId(0L);
        accountId2.setEmail("email");
        accountId2.setPassWord("passWord");
        accountId2.setIsBlock(false);
        final Role roleId3 = new Role();
        roleId3.setRoleId(0);
        roleId3.setRoleName("roleName");
        roleId3.setAccountList(Arrays.asList(new Account()));
        accountId2.setRoleId(roleId3);
        final User user3 = new User();
        user3.setUserId(0L);
        user3.setFirstName("firstName");
        accountId2.setUser(user3);
        partner3.setAccountId(accountId2);
        partner3.setFirstName("firstName");
        partner3.setLastName("lastName");
        when(feedbackServiceImplUnderTest.partnerRepository.getPartnerByAccountId_AccountId(0L)).thenReturn(partner3);

        // Run the test
        assertThatThrownBy(() -> feedbackServiceImplUnderTest.getListFeedback(0L, 0L, 0, 0, 0))
                .isInstanceOf(HandlerException.class);
    }

    @Test
    void testGetListFeedbackContainReport() throws Exception {
        // Setup
        // Configure FeedbackRepository.getListFeedbackContainReport(...).
        final Feedback feedback = new Feedback();
        feedback.setFeedbackId(0L);
        final Account accountId = new Account();
        accountId.setAccountId(0L);
        final Role roleId = new Role();
        roleId.setRoleId(0);
        accountId.setRoleId(roleId);
        final User user = new User();
        user.setFirstName("firstName");
        user.setLastName("lastName");
        accountId.setUser(user);
        final Partner partner = new Partner();
        partner.setFirstName("firstName");
        partner.setLastName("lastName");
        accountId.setPartner(partner);
        feedback.setAccountId(accountId);
        final Tour tourId = new Tour();
        tourId.setTourId(0L);
        tourId.setTourName("tourName");
        feedback.setTourId(tourId);
        feedback.setCreateDate(LocalDate.of(2020, 1, 1));
        feedback.setContent("content");
        feedback.setIsBlock(false);
        final UserBooking userBookingId = new UserBooking();
        userBookingId.setUserBookingId(0L);
        userBookingId.setIsFeedback(false);
        feedback.setUserBookingId(userBookingId);
        final List<Feedback> feedbackList = Arrays.asList(feedback);
        when(feedbackServiceImplUnderTest.feedbackRepository.getListFeedbackContainReport()).thenReturn(feedbackList);

        // Configure ReportFeedbackRepository.getAllByFeedbackId_FeedbackId(...).
        final ReportFeedback reportFeedback = new ReportFeedback();
        reportFeedback.setReportFeedbackId(0L);
        final Account accountId1 = new Account();
        accountId1.setAccountId(0L);
        final Role roleId1 = new Role();
        roleId1.setRoleId(0);
        accountId1.setRoleId(roleId1);
        final User user1 = new User();
        user1.setFirstName("firstName");
        user1.setLastName("lastName");
        accountId1.setUser(user1);
        final Partner partner1 = new Partner();
        partner1.setFirstName("firstName");
        partner1.setLastName("lastName");
        accountId1.setPartner(partner1);
        reportFeedback.setAccountId(accountId1);
        final Feedback feedbackId = new Feedback();
        feedbackId.setFeedbackId(0L);
        final Account accountId2 = new Account();
        accountId2.setAccountId(0L);
        final Role roleId2 = new Role();
        roleId2.setRoleId(0);
        accountId2.setRoleId(roleId2);
        final User user2 = new User();
        user2.setFirstName("firstName");
        user2.setLastName("lastName");
        accountId2.setUser(user2);
        final Partner partner2 = new Partner();
        partner2.setFirstName("firstName");
        partner2.setLastName("lastName");
        accountId2.setPartner(partner2);
        feedbackId.setAccountId(accountId2);
        final Tour tourId1 = new Tour();
        tourId1.setTourId(0L);
        tourId1.setTourName("tourName");
        feedbackId.setTourId(tourId1);
        feedbackId.setCreateDate(LocalDate.of(2020, 1, 1));
        feedbackId.setContent("content");
        feedbackId.setIsBlock(false);
        final UserBooking userBookingId1 = new UserBooking();
        userBookingId1.setUserBookingId(0L);
        userBookingId1.setIsFeedback(false);
        feedbackId.setUserBookingId(userBookingId1);
        reportFeedback.setFeedbackId(feedbackId);
        final ReasonReportFeedback reasonReportFeedbackId = new ReasonReportFeedback();
        reportFeedback.setReasonReportFeedbackId(reasonReportFeedbackId);
        reportFeedback.setCreateDate(LocalDate.of(2020, 1, 1));
        final List<ReportFeedback> reportFeedbackList = Arrays.asList(reportFeedback);
        when(feedbackServiceImplUnderTest.reportFeedbackRepository.getAllByFeedbackId_FeedbackId(0L))
                .thenReturn(reportFeedbackList);

        // Run the test
        final Page<FeedbackDTO> result = feedbackServiceImplUnderTest.getListFeedbackContainReport(0, 0);

        // Verify the results
    }

    @Test
    void testGetListFeedbackContainReport_FeedbackRepositoryReturnsNoItems() throws Exception {
        // Setup
        when(feedbackServiceImplUnderTest.feedbackRepository.getListFeedbackContainReport())
                .thenReturn(Collections.emptyList());

        // Configure ReportFeedbackRepository.getAllByFeedbackId_FeedbackId(...).
        final ReportFeedback reportFeedback = new ReportFeedback();
        reportFeedback.setReportFeedbackId(0L);
        final Account accountId = new Account();
        accountId.setAccountId(0L);
        final Role roleId = new Role();
        roleId.setRoleId(0);
        accountId.setRoleId(roleId);
        final User user = new User();
        user.setFirstName("firstName");
        user.setLastName("lastName");
        accountId.setUser(user);
        final Partner partner = new Partner();
        partner.setFirstName("firstName");
        partner.setLastName("lastName");
        accountId.setPartner(partner);
        reportFeedback.setAccountId(accountId);
        final Feedback feedbackId = new Feedback();
        feedbackId.setFeedbackId(0L);
        final Account accountId1 = new Account();
        accountId1.setAccountId(0L);
        final Role roleId1 = new Role();
        roleId1.setRoleId(0);
        accountId1.setRoleId(roleId1);
        final User user1 = new User();
        user1.setFirstName("firstName");
        user1.setLastName("lastName");
        accountId1.setUser(user1);
        final Partner partner1 = new Partner();
        partner1.setFirstName("firstName");
        partner1.setLastName("lastName");
        accountId1.setPartner(partner1);
        feedbackId.setAccountId(accountId1);
        final Tour tourId = new Tour();
        tourId.setTourId(0L);
        tourId.setTourName("tourName");
        feedbackId.setTourId(tourId);
        feedbackId.setCreateDate(LocalDate.of(2020, 1, 1));
        feedbackId.setContent("content");
        feedbackId.setIsBlock(false);
        final UserBooking userBookingId = new UserBooking();
        userBookingId.setUserBookingId(0L);
        userBookingId.setIsFeedback(false);
        feedbackId.setUserBookingId(userBookingId);
        reportFeedback.setFeedbackId(feedbackId);
        final ReasonReportFeedback reasonReportFeedbackId = new ReasonReportFeedback();
        reportFeedback.setReasonReportFeedbackId(reasonReportFeedbackId);
        reportFeedback.setCreateDate(LocalDate.of(2020, 1, 1));
        final List<ReportFeedback> reportFeedbackList = Arrays.asList(reportFeedback);
        when(feedbackServiceImplUnderTest.reportFeedbackRepository.getAllByFeedbackId_FeedbackId(0L))
                .thenReturn(reportFeedbackList);

        // Run the test
        final Page<FeedbackDTO> result = feedbackServiceImplUnderTest.getListFeedbackContainReport(0, 0);

        // Verify the results
    }

    @Test
    void testGetListFeedbackContainReport_ReportFeedbackRepositoryReturnsNoItems() throws Exception {
        // Setup
        // Configure FeedbackRepository.getListFeedbackContainReport(...).
        final Feedback feedback = new Feedback();
        feedback.setFeedbackId(0L);
        final Account accountId = new Account();
        accountId.setAccountId(0L);
        final Role roleId = new Role();
        roleId.setRoleId(0);
        accountId.setRoleId(roleId);
        final User user = new User();
        user.setFirstName("firstName");
        user.setLastName("lastName");
        accountId.setUser(user);
        final Partner partner = new Partner();
        partner.setFirstName("firstName");
        partner.setLastName("lastName");
        accountId.setPartner(partner);
        feedback.setAccountId(accountId);
        final Tour tourId = new Tour();
        tourId.setTourId(0L);
        tourId.setTourName("tourName");
        feedback.setTourId(tourId);
        feedback.setCreateDate(LocalDate.of(2020, 1, 1));
        feedback.setContent("content");
        feedback.setIsBlock(false);
        final UserBooking userBookingId = new UserBooking();
        userBookingId.setUserBookingId(0L);
        userBookingId.setIsFeedback(false);
        feedback.setUserBookingId(userBookingId);
        final List<Feedback> feedbackList = Arrays.asList(feedback);
        when(feedbackServiceImplUnderTest.feedbackRepository.getListFeedbackContainReport()).thenReturn(feedbackList);

        when(feedbackServiceImplUnderTest.reportFeedbackRepository.getAllByFeedbackId_FeedbackId(0L))
                .thenReturn(Collections.emptyList());

        // Run the test
        final Page<FeedbackDTO> result = feedbackServiceImplUnderTest.getListFeedbackContainReport(0, 0);

        // Verify the results
    }

    @Test
    void testGetListFeedbackContainReport_ThrowsHandlerException() {
        // Setup
        // Configure FeedbackRepository.getListFeedbackContainReport(...).
        final Feedback feedback = new Feedback();
        feedback.setFeedbackId(0L);
        final Account accountId = new Account();
        accountId.setAccountId(0L);
        final Role roleId = new Role();
        roleId.setRoleId(0);
        accountId.setRoleId(roleId);
        final User user = new User();
        user.setFirstName("firstName");
        user.setLastName("lastName");
        accountId.setUser(user);
        final Partner partner = new Partner();
        partner.setFirstName("firstName");
        partner.setLastName("lastName");
        accountId.setPartner(partner);
        feedback.setAccountId(accountId);
        final Tour tourId = new Tour();
        tourId.setTourId(0L);
        tourId.setTourName("tourName");
        feedback.setTourId(tourId);
        feedback.setCreateDate(LocalDate.of(2020, 1, 1));
        feedback.setContent("content");
        feedback.setIsBlock(false);
        final UserBooking userBookingId = new UserBooking();
        userBookingId.setUserBookingId(0L);
        userBookingId.setIsFeedback(false);
        feedback.setUserBookingId(userBookingId);
        final List<Feedback> feedbackList = Arrays.asList(feedback);
        when(feedbackServiceImplUnderTest.feedbackRepository.getListFeedbackContainReport()).thenReturn(feedbackList);

        // Configure ReportFeedbackRepository.getAllByFeedbackId_FeedbackId(...).
        final ReportFeedback reportFeedback = new ReportFeedback();
        reportFeedback.setReportFeedbackId(0L);
        final Account accountId1 = new Account();
        accountId1.setAccountId(0L);
        final Role roleId1 = new Role();
        roleId1.setRoleId(0);
        accountId1.setRoleId(roleId1);
        final User user1 = new User();
        user1.setFirstName("firstName");
        user1.setLastName("lastName");
        accountId1.setUser(user1);
        final Partner partner1 = new Partner();
        partner1.setFirstName("firstName");
        partner1.setLastName("lastName");
        accountId1.setPartner(partner1);
        reportFeedback.setAccountId(accountId1);
        final Feedback feedbackId = new Feedback();
        feedbackId.setFeedbackId(0L);
        final Account accountId2 = new Account();
        accountId2.setAccountId(0L);
        final Role roleId2 = new Role();
        roleId2.setRoleId(0);
        accountId2.setRoleId(roleId2);
        final User user2 = new User();
        user2.setFirstName("firstName");
        user2.setLastName("lastName");
        accountId2.setUser(user2);
        final Partner partner2 = new Partner();
        partner2.setFirstName("firstName");
        partner2.setLastName("lastName");
        accountId2.setPartner(partner2);
        feedbackId.setAccountId(accountId2);
        final Tour tourId1 = new Tour();
        tourId1.setTourId(0L);
        tourId1.setTourName("tourName");
        feedbackId.setTourId(tourId1);
        feedbackId.setCreateDate(LocalDate.of(2020, 1, 1));
        feedbackId.setContent("content");
        feedbackId.setIsBlock(false);
        final UserBooking userBookingId1 = new UserBooking();
        userBookingId1.setUserBookingId(0L);
        userBookingId1.setIsFeedback(false);
        feedbackId.setUserBookingId(userBookingId1);
        reportFeedback.setFeedbackId(feedbackId);
        final ReasonReportFeedback reasonReportFeedbackId = new ReasonReportFeedback();
        reportFeedback.setReasonReportFeedbackId(reasonReportFeedbackId);
        reportFeedback.setCreateDate(LocalDate.of(2020, 1, 1));
        final List<ReportFeedback> reportFeedbackList = Arrays.asList(reportFeedback);
        when(feedbackServiceImplUnderTest.reportFeedbackRepository.getAllByFeedbackId_FeedbackId(0L))
                .thenReturn(reportFeedbackList);

        // Run the test
        assertThatThrownBy(() -> feedbackServiceImplUnderTest.getListFeedbackContainReport(0, 0))
                .isInstanceOf(HandlerException.class);
    }

    @Test
    void testDeleteReportFeedback() throws Exception {
        // Setup
        when(feedbackServiceImplUnderTest.reportFeedbackRepository.existsReportFeedbackByFeedbackId_FeedbackId(
                0L)).thenReturn(false);

        // Configure ReportFeedbackRepository.getAllByFeedbackId_FeedbackId(...).
        final ReportFeedback reportFeedback = new ReportFeedback();
        reportFeedback.setReportFeedbackId(0L);
        final Account accountId = new Account();
        accountId.setAccountId(0L);
        final Role roleId = new Role();
        roleId.setRoleId(0);
        accountId.setRoleId(roleId);
        final User user = new User();
        user.setFirstName("firstName");
        user.setLastName("lastName");
        accountId.setUser(user);
        final Partner partner = new Partner();
        partner.setFirstName("firstName");
        partner.setLastName("lastName");
        accountId.setPartner(partner);
        reportFeedback.setAccountId(accountId);
        final Feedback feedbackId = new Feedback();
        feedbackId.setFeedbackId(0L);
        final Account accountId1 = new Account();
        accountId1.setAccountId(0L);
        final Role roleId1 = new Role();
        roleId1.setRoleId(0);
        accountId1.setRoleId(roleId1);
        final User user1 = new User();
        user1.setFirstName("firstName");
        user1.setLastName("lastName");
        accountId1.setUser(user1);
        final Partner partner1 = new Partner();
        partner1.setFirstName("firstName");
        partner1.setLastName("lastName");
        accountId1.setPartner(partner1);
        feedbackId.setAccountId(accountId1);
        final Tour tourId = new Tour();
        tourId.setTourId(0L);
        tourId.setTourName("tourName");
        feedbackId.setTourId(tourId);
        feedbackId.setCreateDate(LocalDate.of(2020, 1, 1));
        feedbackId.setContent("content");
        feedbackId.setIsBlock(false);
        final UserBooking userBookingId = new UserBooking();
        userBookingId.setUserBookingId(0L);
        userBookingId.setIsFeedback(false);
        feedbackId.setUserBookingId(userBookingId);
        reportFeedback.setFeedbackId(feedbackId);
        final ReasonReportFeedback reasonReportFeedbackId = new ReasonReportFeedback();
        reportFeedback.setReasonReportFeedbackId(reasonReportFeedbackId);
        reportFeedback.setCreateDate(LocalDate.of(2020, 1, 1));
        final List<ReportFeedback> reportFeedbackList = Arrays.asList(reportFeedback);
        when(feedbackServiceImplUnderTest.reportFeedbackRepository.getAllByFeedbackId_FeedbackId(0L))
                .thenReturn(reportFeedbackList);

        // Run the test
        final Boolean result = feedbackServiceImplUnderTest.deleteReportFeedback(0L);

        // Verify the results
        assertThat(result).isFalse();
        verify(feedbackServiceImplUnderTest.reportFeedbackRepository).deleteAll(Arrays.asList(new ReportFeedback()));
    }

    @Test
    void testDeleteReportFeedback_ReportFeedbackRepositoryGetAllByFeedbackId_FeedbackIdReturnsNoItems() throws Exception {
        // Setup
        when(feedbackServiceImplUnderTest.reportFeedbackRepository.existsReportFeedbackByFeedbackId_FeedbackId(
                0L)).thenReturn(false);
        when(feedbackServiceImplUnderTest.reportFeedbackRepository.getAllByFeedbackId_FeedbackId(0L))
                .thenReturn(Collections.emptyList());

        // Run the test
        final Boolean result = feedbackServiceImplUnderTest.deleteReportFeedback(0L);

        // Verify the results
        assertThat(result).isTrue();
        verify(feedbackServiceImplUnderTest.reportFeedbackRepository).deleteAll(Arrays.asList(new ReportFeedback()));
    }

    @Test
    void testDeleteReportFeedback_ThrowsHandlerException() {
        // Setup
        when(feedbackServiceImplUnderTest.reportFeedbackRepository.existsReportFeedbackByFeedbackId_FeedbackId(
                0L)).thenReturn(false);

        // Configure ReportFeedbackRepository.getAllByFeedbackId_FeedbackId(...).
        final ReportFeedback reportFeedback = new ReportFeedback();
        reportFeedback.setReportFeedbackId(0L);
        final Account accountId = new Account();
        accountId.setAccountId(0L);
        final Role roleId = new Role();
        roleId.setRoleId(0);
        accountId.setRoleId(roleId);
        final User user = new User();
        user.setFirstName("firstName");
        user.setLastName("lastName");
        accountId.setUser(user);
        final Partner partner = new Partner();
        partner.setFirstName("firstName");
        partner.setLastName("lastName");
        accountId.setPartner(partner);
        reportFeedback.setAccountId(accountId);
        final Feedback feedbackId = new Feedback();
        feedbackId.setFeedbackId(0L);
        final Account accountId1 = new Account();
        accountId1.setAccountId(0L);
        final Role roleId1 = new Role();
        roleId1.setRoleId(0);
        accountId1.setRoleId(roleId1);
        final User user1 = new User();
        user1.setFirstName("firstName");
        user1.setLastName("lastName");
        accountId1.setUser(user1);
        final Partner partner1 = new Partner();
        partner1.setFirstName("firstName");
        partner1.setLastName("lastName");
        accountId1.setPartner(partner1);
        feedbackId.setAccountId(accountId1);
        final Tour tourId = new Tour();
        tourId.setTourId(0L);
        tourId.setTourName("tourName");
        feedbackId.setTourId(tourId);
        feedbackId.setCreateDate(LocalDate.of(2020, 1, 1));
        feedbackId.setContent("content");
        feedbackId.setIsBlock(false);
        final UserBooking userBookingId = new UserBooking();
        userBookingId.setUserBookingId(0L);
        userBookingId.setIsFeedback(false);
        feedbackId.setUserBookingId(userBookingId);
        reportFeedback.setFeedbackId(feedbackId);
        final ReasonReportFeedback reasonReportFeedbackId = new ReasonReportFeedback();
        reportFeedback.setReasonReportFeedbackId(reasonReportFeedbackId);
        reportFeedback.setCreateDate(LocalDate.of(2020, 1, 1));
        final List<ReportFeedback> reportFeedbackList = Arrays.asList(reportFeedback);
        when(feedbackServiceImplUnderTest.reportFeedbackRepository.getAllByFeedbackId_FeedbackId(0L))
                .thenReturn(reportFeedbackList);

        // Run the test
        assertThatThrownBy(() -> feedbackServiceImplUnderTest.deleteReportFeedback(0L))
                .isInstanceOf(HandlerException.class);
        verify(feedbackServiceImplUnderTest.reportFeedbackRepository).deleteAll(Arrays.asList(new ReportFeedback()));
    }
}

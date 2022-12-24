package com.example.wetravel;

import com.example.wetravel.DTO.RequestCancelBookingDTO;
import com.example.wetravel.DTO.UserBookingDTO;
import com.example.wetravel.Entity.*;
import com.example.wetravel.Exception.HandlerException;
import com.example.wetravel.Repository.*;
import com.example.wetravel.Service.ServiceImpl.BookingServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;

class BookingServiceImplTest {

    private BookingServiceImpl bookingServiceImplUnderTest;

    @BeforeEach
    void setUp() throws Exception {
        bookingServiceImplUnderTest = new BookingServiceImpl();
        bookingServiceImplUnderTest.userBookingRepository = mock(UserBookingRepository.class);
        bookingServiceImplUnderTest.tourRepository = mock(TourRepository.class);
        bookingServiceImplUnderTest.accountRepository = mock(AccountRepository.class);
        bookingServiceImplUnderTest.reasonCancelRepository = mock(ReasonCancelRepository.class);
        bookingServiceImplUnderTest.requestCancelRepository = mock(RequestCancelRepository.class);
    }

    @Test
    void testGetListBooking() throws Exception {
        // Setup
        when(bookingServiceImplUnderTest.userBookingRepository.existsByAccountId_AccountId(0L)).thenReturn(false);

        // Configure UserBookingRepository.getListBooking(...).
        final UserBooking userBooking = new UserBooking();
        userBooking.setUserBookingId(0L);
        final Account accountId = new Account();
        accountId.setAccountId(0L);
        accountId.setEmail("accountEmail");
        userBooking.setAccountId(accountId);
        final Tour tourId = new Tour();
        tourId.setTourId(0L);
        tourId.setTourName("tourName");
        tourId.setStatus(0);
        tourId.setTourType(0);
        tourId.setDeposit(0.0f);
        userBooking.setTourId(tourId);
        userBooking.setBookingDate(LocalDate.of(2020, 1, 1));
        userBooking.setStartDate(LocalDate.of(2020, 1, 1));
        userBooking.setFullName("fullName");
        userBooking.setPhone("phone");
        userBooking.setEmail("email");
        userBooking.setIdCard("idCard");
        userBooking.setDateOfIssue(LocalDate.of(2020, 1, 1));
        userBooking.setPlaceOfIssue("placeOfIssue");
        userBooking.setRequest("request");
        userBooking.setAdultPrice(0.0f);
        userBooking.setChildrenPrice(0.0f);
        userBooking.setNumberOfAdult(0);
        userBooking.setNumberOfChildren(0);
        userBooking.setTotalPrice(0.0f);
        userBooking.setOrderId(0L);
        userBooking.setOrderTitle("orderTitle");
        userBooking.setPayType("payType");
        userBooking.setStatus(0);
        userBooking.setStatusDeposit(false);
        userBooking.setIsFeedback(false);
        final Page<UserBooking> userBookingPage = new PageImpl<>(Arrays.asList(userBooking));
        when(bookingServiceImplUnderTest.userBookingRepository.getListBooking(eq(0L), eq(0L), eq("startDate"),
                any(Pageable.class))).thenReturn(userBookingPage);

        // Run the test
        final Page<UserBookingDTO> result = bookingServiceImplUnderTest.getListBooking(0L, 0L, "startDate", 0, 0);

        // Verify the results
    }

    @Test
    void testGetListBooking_UserBookingRepositoryGetListBookingReturnsNoItems() throws Exception {
        // Setup
        when(bookingServiceImplUnderTest.userBookingRepository.existsByAccountId_AccountId(0L)).thenReturn(false);
        when(bookingServiceImplUnderTest.userBookingRepository.getListBooking(eq(0L), eq(0L), eq("startDate"),
                any(Pageable.class))).thenReturn(new PageImpl<>(Collections.emptyList()));

        // Run the test
        final Page<UserBookingDTO> result = bookingServiceImplUnderTest.getListBooking(0L, 0L, "startDate", 0, 0);

        // Verify the results
    }

    @Test
    void testGetListBooking_ThrowsHandlerException() {
        // Setup
        when(bookingServiceImplUnderTest.userBookingRepository.existsByAccountId_AccountId(0L)).thenReturn(false);

        // Configure UserBookingRepository.getListBooking(...).
        final UserBooking userBooking = new UserBooking();
        userBooking.setUserBookingId(0L);
        final Account accountId = new Account();
        accountId.setAccountId(0L);
        accountId.setEmail("accountEmail");
        userBooking.setAccountId(accountId);
        final Tour tourId = new Tour();
        tourId.setTourId(0L);
        tourId.setTourName("tourName");
        tourId.setStatus(0);
        tourId.setTourType(0);
        tourId.setDeposit(0.0f);
        userBooking.setTourId(tourId);
        userBooking.setBookingDate(LocalDate.of(2020, 1, 1));
        userBooking.setStartDate(LocalDate.of(2020, 1, 1));
        userBooking.setFullName("fullName");
        userBooking.setPhone("phone");
        userBooking.setEmail("email");
        userBooking.setIdCard("idCard");
        userBooking.setDateOfIssue(LocalDate.of(2020, 1, 1));
        userBooking.setPlaceOfIssue("placeOfIssue");
        userBooking.setRequest("request");
        userBooking.setAdultPrice(0.0f);
        userBooking.setChildrenPrice(0.0f);
        userBooking.setNumberOfAdult(0);
        userBooking.setNumberOfChildren(0);
        userBooking.setTotalPrice(0.0f);
        userBooking.setOrderId(0L);
        userBooking.setOrderTitle("orderTitle");
        userBooking.setPayType("payType");
        userBooking.setStatus(0);
        userBooking.setStatusDeposit(false);
        userBooking.setIsFeedback(false);
        final Page<UserBooking> userBookingPage = new PageImpl<>(Arrays.asList(userBooking));
        when(bookingServiceImplUnderTest.userBookingRepository.getListBooking(eq(0L), eq(0L), eq("startDate"),
                any(Pageable.class))).thenReturn(userBookingPage);

        // Run the test
        assertThatThrownBy(() -> bookingServiceImplUnderTest.getListBooking(0L, 0L, "startDate", 0, 0))
                .isInstanceOf(HandlerException.class);
    }

    @Test
    void testCreateBooking() throws Exception {
        // Setup
        final UserBookingDTO userBookingDTO = new UserBookingDTO(0L, 0L, 0L, "tourName", 0, 0, "fullName", "phone",
                "email", LocalDate.of(2020, 1, 1), LocalDate.of(2020, 1, 1), "idCard", LocalDate.of(2020, 1, 1),
                "placeOfIssue", "request", 0.0f, 0.0f, 0, 0, 0.0f, 0L, "orderTitle", "payType", 0, false, 0.0f, false);

        // Configure AccountRepository.getById(...).
        final Account account = new Account();
        account.setAccountId(0L);
        account.setEmail("accountEmail");
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
        when(bookingServiceImplUnderTest.accountRepository.getById(0L)).thenReturn(account);

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
        tour.setDeposit(0.0f);
        when(bookingServiceImplUnderTest.tourRepository.getById(0L)).thenReturn(tour);

        // Configure UserBookingRepository.save(...).
        final UserBooking userBooking = new UserBooking();
        userBooking.setUserBookingId(0L);
        final Account accountId = new Account();
        accountId.setAccountId(0L);
        accountId.setEmail("accountEmail");
        userBooking.setAccountId(accountId);
        final Tour tourId = new Tour();
        tourId.setTourId(0L);
        tourId.setTourName("tourName");
        tourId.setStatus(0);
        tourId.setTourType(0);
        tourId.setDeposit(0.0f);
        userBooking.setTourId(tourId);
        userBooking.setBookingDate(LocalDate.of(2020, 1, 1));
        userBooking.setStartDate(LocalDate.of(2020, 1, 1));
        userBooking.setFullName("fullName");
        userBooking.setPhone("phone");
        userBooking.setEmail("email");
        userBooking.setIdCard("idCard");
        userBooking.setDateOfIssue(LocalDate.of(2020, 1, 1));
        userBooking.setPlaceOfIssue("placeOfIssue");
        userBooking.setRequest("request");
        userBooking.setAdultPrice(0.0f);
        userBooking.setChildrenPrice(0.0f);
        userBooking.setNumberOfAdult(0);
        userBooking.setNumberOfChildren(0);
        userBooking.setTotalPrice(0.0f);
        userBooking.setOrderId(0L);
        userBooking.setOrderTitle("orderTitle");
        userBooking.setPayType("payType");
        userBooking.setStatus(0);
        userBooking.setStatusDeposit(false);
        userBooking.setIsFeedback(false);
        when(bookingServiceImplUnderTest.userBookingRepository.save(any(UserBooking.class))).thenReturn(userBooking);

        // Run the test
        final UserBookingDTO result = bookingServiceImplUnderTest.createBooking(userBookingDTO);

        // Verify the results
        verify(bookingServiceImplUnderTest.userBookingRepository).save(any(UserBooking.class));
    }

    @Test
    void testCreateBooking_ThrowsHandlerException() {
        // Setup
        final UserBookingDTO userBookingDTO = new UserBookingDTO(0L, 0L, 0L, "tourName", 0, 0, "fullName", "phone",
                "email", LocalDate.of(2020, 1, 1), LocalDate.of(2020, 1, 1), "idCard", LocalDate.of(2020, 1, 1),
                "placeOfIssue", "request", 0.0f, 0.0f, 0, 0, 0.0f, 0L, "orderTitle", "payType", 0, false, 0.0f, false);

        // Configure AccountRepository.getById(...).
        final Account account = new Account();
        account.setAccountId(0L);
        account.setEmail("accountEmail");
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
        when(bookingServiceImplUnderTest.accountRepository.getById(0L)).thenReturn(account);

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
        tour.setDeposit(0.0f);
        when(bookingServiceImplUnderTest.tourRepository.getById(0L)).thenReturn(tour);

        // Configure UserBookingRepository.save(...).
        final UserBooking userBooking = new UserBooking();
        userBooking.setUserBookingId(0L);
        final Account accountId = new Account();
        accountId.setAccountId(0L);
        accountId.setEmail("accountEmail");
        userBooking.setAccountId(accountId);
        final Tour tourId = new Tour();
        tourId.setTourId(0L);
        tourId.setTourName("tourName");
        tourId.setStatus(0);
        tourId.setTourType(0);
        tourId.setDeposit(0.0f);
        userBooking.setTourId(tourId);
        userBooking.setBookingDate(LocalDate.of(2020, 1, 1));
        userBooking.setStartDate(LocalDate.of(2020, 1, 1));
        userBooking.setFullName("fullName");
        userBooking.setPhone("phone");
        userBooking.setEmail("email");
        userBooking.setIdCard("idCard");
        userBooking.setDateOfIssue(LocalDate.of(2020, 1, 1));
        userBooking.setPlaceOfIssue("placeOfIssue");
        userBooking.setRequest("request");
        userBooking.setAdultPrice(0.0f);
        userBooking.setChildrenPrice(0.0f);
        userBooking.setNumberOfAdult(0);
        userBooking.setNumberOfChildren(0);
        userBooking.setTotalPrice(0.0f);
        userBooking.setOrderId(0L);
        userBooking.setOrderTitle("orderTitle");
        userBooking.setPayType("payType");
        userBooking.setStatus(0);
        userBooking.setStatusDeposit(false);
        userBooking.setIsFeedback(false);
        when(bookingServiceImplUnderTest.userBookingRepository.save(any(UserBooking.class))).thenReturn(userBooking);

        // Run the test
        assertThatThrownBy(() -> bookingServiceImplUnderTest.createBooking(userBookingDTO))
                .isInstanceOf(HandlerException.class);
        verify(bookingServiceImplUnderTest.userBookingRepository).save(any(UserBooking.class));
    }

    @Test
    void testUpdateStatus() throws Exception {
        // Setup
        // Configure UserBookingRepository.getById(...).
        final UserBooking userBooking = new UserBooking();
        userBooking.setUserBookingId(0L);
        final Account accountId = new Account();
        accountId.setAccountId(0L);
        accountId.setEmail("accountEmail");
        userBooking.setAccountId(accountId);
        final Tour tourId = new Tour();
        tourId.setTourId(0L);
        tourId.setTourName("tourName");
        tourId.setStatus(0);
        tourId.setTourType(0);
        tourId.setDeposit(0.0f);
        userBooking.setTourId(tourId);
        userBooking.setBookingDate(LocalDate.of(2020, 1, 1));
        userBooking.setStartDate(LocalDate.of(2020, 1, 1));
        userBooking.setFullName("fullName");
        userBooking.setPhone("phone");
        userBooking.setEmail("email");
        userBooking.setIdCard("idCard");
        userBooking.setDateOfIssue(LocalDate.of(2020, 1, 1));
        userBooking.setPlaceOfIssue("placeOfIssue");
        userBooking.setRequest("request");
        userBooking.setAdultPrice(0.0f);
        userBooking.setChildrenPrice(0.0f);
        userBooking.setNumberOfAdult(0);
        userBooking.setNumberOfChildren(0);
        userBooking.setTotalPrice(0.0f);
        userBooking.setOrderId(0L);
        userBooking.setOrderTitle("orderTitle");
        userBooking.setPayType("payType");
        userBooking.setStatus(0);
        userBooking.setStatusDeposit(false);
        userBooking.setIsFeedback(false);
        when(bookingServiceImplUnderTest.userBookingRepository.getById(0L)).thenReturn(userBooking);

        // Configure UserBookingRepository.save(...).
        final UserBooking userBooking1 = new UserBooking();
        userBooking1.setUserBookingId(0L);
        final Account accountId1 = new Account();
        accountId1.setAccountId(0L);
        accountId1.setEmail("accountEmail");
        userBooking1.setAccountId(accountId1);
        final Tour tourId1 = new Tour();
        tourId1.setTourId(0L);
        tourId1.setTourName("tourName");
        tourId1.setStatus(0);
        tourId1.setTourType(0);
        tourId1.setDeposit(0.0f);
        userBooking1.setTourId(tourId1);
        userBooking1.setBookingDate(LocalDate.of(2020, 1, 1));
        userBooking1.setStartDate(LocalDate.of(2020, 1, 1));
        userBooking1.setFullName("fullName");
        userBooking1.setPhone("phone");
        userBooking1.setEmail("email");
        userBooking1.setIdCard("idCard");
        userBooking1.setDateOfIssue(LocalDate.of(2020, 1, 1));
        userBooking1.setPlaceOfIssue("placeOfIssue");
        userBooking1.setRequest("request");
        userBooking1.setAdultPrice(0.0f);
        userBooking1.setChildrenPrice(0.0f);
        userBooking1.setNumberOfAdult(0);
        userBooking1.setNumberOfChildren(0);
        userBooking1.setTotalPrice(0.0f);
        userBooking1.setOrderId(0L);
        userBooking1.setOrderTitle("orderTitle");
        userBooking1.setPayType("payType");
        userBooking1.setStatus(0);
        userBooking1.setStatusDeposit(false);
        userBooking1.setIsFeedback(false);
        when(bookingServiceImplUnderTest.userBookingRepository.save(any(UserBooking.class))).thenReturn(userBooking1);

        // Run the test
        final Boolean result = bookingServiceImplUnderTest.updateStatus(0L, 0);

        // Verify the results
        assertThat(result).isFalse();
        verify(bookingServiceImplUnderTest.userBookingRepository).save(any(UserBooking.class));
    }

    @Test
    void testUpdateStatus_ThrowsHandlerException() {
        // Setup
        // Configure UserBookingRepository.getById(...).
        final UserBooking userBooking = new UserBooking();
        userBooking.setUserBookingId(0L);
        final Account accountId = new Account();
        accountId.setAccountId(0L);
        accountId.setEmail("accountEmail");
        userBooking.setAccountId(accountId);
        final Tour tourId = new Tour();
        tourId.setTourId(0L);
        tourId.setTourName("tourName");
        tourId.setStatus(0);
        tourId.setTourType(0);
        tourId.setDeposit(0.0f);
        userBooking.setTourId(tourId);
        userBooking.setBookingDate(LocalDate.of(2020, 1, 1));
        userBooking.setStartDate(LocalDate.of(2020, 1, 1));
        userBooking.setFullName("fullName");
        userBooking.setPhone("phone");
        userBooking.setEmail("email");
        userBooking.setIdCard("idCard");
        userBooking.setDateOfIssue(LocalDate.of(2020, 1, 1));
        userBooking.setPlaceOfIssue("placeOfIssue");
        userBooking.setRequest("request");
        userBooking.setAdultPrice(0.0f);
        userBooking.setChildrenPrice(0.0f);
        userBooking.setNumberOfAdult(0);
        userBooking.setNumberOfChildren(0);
        userBooking.setTotalPrice(0.0f);
        userBooking.setOrderId(0L);
        userBooking.setOrderTitle("orderTitle");
        userBooking.setPayType("payType");
        userBooking.setStatus(0);
        userBooking.setStatusDeposit(false);
        userBooking.setIsFeedback(false);
        when(bookingServiceImplUnderTest.userBookingRepository.getById(0L)).thenReturn(userBooking);

        // Configure UserBookingRepository.save(...).
        final UserBooking userBooking1 = new UserBooking();
        userBooking1.setUserBookingId(0L);
        final Account accountId1 = new Account();
        accountId1.setAccountId(0L);
        accountId1.setEmail("accountEmail");
        userBooking1.setAccountId(accountId1);
        final Tour tourId1 = new Tour();
        tourId1.setTourId(0L);
        tourId1.setTourName("tourName");
        tourId1.setStatus(0);
        tourId1.setTourType(0);
        tourId1.setDeposit(0.0f);
        userBooking1.setTourId(tourId1);
        userBooking1.setBookingDate(LocalDate.of(2020, 1, 1));
        userBooking1.setStartDate(LocalDate.of(2020, 1, 1));
        userBooking1.setFullName("fullName");
        userBooking1.setPhone("phone");
        userBooking1.setEmail("email");
        userBooking1.setIdCard("idCard");
        userBooking1.setDateOfIssue(LocalDate.of(2020, 1, 1));
        userBooking1.setPlaceOfIssue("placeOfIssue");
        userBooking1.setRequest("request");
        userBooking1.setAdultPrice(0.0f);
        userBooking1.setChildrenPrice(0.0f);
        userBooking1.setNumberOfAdult(0);
        userBooking1.setNumberOfChildren(0);
        userBooking1.setTotalPrice(0.0f);
        userBooking1.setOrderId(0L);
        userBooking1.setOrderTitle("orderTitle");
        userBooking1.setPayType("payType");
        userBooking1.setStatus(0);
        userBooking1.setStatusDeposit(false);
        userBooking1.setIsFeedback(false);
        when(bookingServiceImplUnderTest.userBookingRepository.save(any(UserBooking.class))).thenReturn(userBooking1);

        // Run the test
        assertThatThrownBy(() -> bookingServiceImplUnderTest.updateStatus(0L, 0)).isInstanceOf(HandlerException.class);
        verify(bookingServiceImplUnderTest.userBookingRepository).save(any(UserBooking.class));
    }

    @Test
    void testUpdateStatusDeposit() throws Exception {
        // Setup
        // Configure UserBookingRepository.getById(...).
        final UserBooking userBooking = new UserBooking();
        userBooking.setUserBookingId(0L);
        final Account accountId = new Account();
        accountId.setAccountId(0L);
        accountId.setEmail("accountEmail");
        userBooking.setAccountId(accountId);
        final Tour tourId = new Tour();
        tourId.setTourId(0L);
        tourId.setTourName("tourName");
        tourId.setStatus(0);
        tourId.setTourType(0);
        tourId.setDeposit(0.0f);
        userBooking.setTourId(tourId);
        userBooking.setBookingDate(LocalDate.of(2020, 1, 1));
        userBooking.setStartDate(LocalDate.of(2020, 1, 1));
        userBooking.setFullName("fullName");
        userBooking.setPhone("phone");
        userBooking.setEmail("email");
        userBooking.setIdCard("idCard");
        userBooking.setDateOfIssue(LocalDate.of(2020, 1, 1));
        userBooking.setPlaceOfIssue("placeOfIssue");
        userBooking.setRequest("request");
        userBooking.setAdultPrice(0.0f);
        userBooking.setChildrenPrice(0.0f);
        userBooking.setNumberOfAdult(0);
        userBooking.setNumberOfChildren(0);
        userBooking.setTotalPrice(0.0f);
        userBooking.setOrderId(0L);
        userBooking.setOrderTitle("orderTitle");
        userBooking.setPayType("payType");
        userBooking.setStatus(0);
        userBooking.setStatusDeposit(false);
        userBooking.setIsFeedback(false);
        when(bookingServiceImplUnderTest.userBookingRepository.getById(0L)).thenReturn(userBooking);

        // Configure UserBookingRepository.save(...).
        final UserBooking userBooking1 = new UserBooking();
        userBooking1.setUserBookingId(0L);
        final Account accountId1 = new Account();
        accountId1.setAccountId(0L);
        accountId1.setEmail("accountEmail");
        userBooking1.setAccountId(accountId1);
        final Tour tourId1 = new Tour();
        tourId1.setTourId(0L);
        tourId1.setTourName("tourName");
        tourId1.setStatus(0);
        tourId1.setTourType(0);
        tourId1.setDeposit(0.0f);
        userBooking1.setTourId(tourId1);
        userBooking1.setBookingDate(LocalDate.of(2020, 1, 1));
        userBooking1.setStartDate(LocalDate.of(2020, 1, 1));
        userBooking1.setFullName("fullName");
        userBooking1.setPhone("phone");
        userBooking1.setEmail("email");
        userBooking1.setIdCard("idCard");
        userBooking1.setDateOfIssue(LocalDate.of(2020, 1, 1));
        userBooking1.setPlaceOfIssue("placeOfIssue");
        userBooking1.setRequest("request");
        userBooking1.setAdultPrice(0.0f);
        userBooking1.setChildrenPrice(0.0f);
        userBooking1.setNumberOfAdult(0);
        userBooking1.setNumberOfChildren(0);
        userBooking1.setTotalPrice(0.0f);
        userBooking1.setOrderId(0L);
        userBooking1.setOrderTitle("orderTitle");
        userBooking1.setPayType("payType");
        userBooking1.setStatus(0);
        userBooking1.setStatusDeposit(false);
        userBooking1.setIsFeedback(false);
        when(bookingServiceImplUnderTest.userBookingRepository.save(any(UserBooking.class))).thenReturn(userBooking1);

        // Run the test
        final Boolean result = bookingServiceImplUnderTest.updateStatusDeposit(0L, false);

        // Verify the results
        assertThat(result).isFalse();
        verify(bookingServiceImplUnderTest.userBookingRepository).save(any(UserBooking.class));
    }

    @Test
    void testUpdateStatusDeposit_ThrowsHandlerException() {
        // Setup
        // Configure UserBookingRepository.getById(...).
        final UserBooking userBooking = new UserBooking();
        userBooking.setUserBookingId(0L);
        final Account accountId = new Account();
        accountId.setAccountId(0L);
        accountId.setEmail("accountEmail");
        userBooking.setAccountId(accountId);
        final Tour tourId = new Tour();
        tourId.setTourId(0L);
        tourId.setTourName("tourName");
        tourId.setStatus(0);
        tourId.setTourType(0);
        tourId.setDeposit(0.0f);
        userBooking.setTourId(tourId);
        userBooking.setBookingDate(LocalDate.of(2020, 1, 1));
        userBooking.setStartDate(LocalDate.of(2020, 1, 1));
        userBooking.setFullName("fullName");
        userBooking.setPhone("phone");
        userBooking.setEmail("email");
        userBooking.setIdCard("idCard");
        userBooking.setDateOfIssue(LocalDate.of(2020, 1, 1));
        userBooking.setPlaceOfIssue("placeOfIssue");
        userBooking.setRequest("request");
        userBooking.setAdultPrice(0.0f);
        userBooking.setChildrenPrice(0.0f);
        userBooking.setNumberOfAdult(0);
        userBooking.setNumberOfChildren(0);
        userBooking.setTotalPrice(0.0f);
        userBooking.setOrderId(0L);
        userBooking.setOrderTitle("orderTitle");
        userBooking.setPayType("payType");
        userBooking.setStatus(0);
        userBooking.setStatusDeposit(false);
        userBooking.setIsFeedback(false);
        when(bookingServiceImplUnderTest.userBookingRepository.getById(0L)).thenReturn(userBooking);

        // Configure UserBookingRepository.save(...).
        final UserBooking userBooking1 = new UserBooking();
        userBooking1.setUserBookingId(0L);
        final Account accountId1 = new Account();
        accountId1.setAccountId(0L);
        accountId1.setEmail("accountEmail");
        userBooking1.setAccountId(accountId1);
        final Tour tourId1 = new Tour();
        tourId1.setTourId(0L);
        tourId1.setTourName("tourName");
        tourId1.setStatus(0);
        tourId1.setTourType(0);
        tourId1.setDeposit(0.0f);
        userBooking1.setTourId(tourId1);
        userBooking1.setBookingDate(LocalDate.of(2020, 1, 1));
        userBooking1.setStartDate(LocalDate.of(2020, 1, 1));
        userBooking1.setFullName("fullName");
        userBooking1.setPhone("phone");
        userBooking1.setEmail("email");
        userBooking1.setIdCard("idCard");
        userBooking1.setDateOfIssue(LocalDate.of(2020, 1, 1));
        userBooking1.setPlaceOfIssue("placeOfIssue");
        userBooking1.setRequest("request");
        userBooking1.setAdultPrice(0.0f);
        userBooking1.setChildrenPrice(0.0f);
        userBooking1.setNumberOfAdult(0);
        userBooking1.setNumberOfChildren(0);
        userBooking1.setTotalPrice(0.0f);
        userBooking1.setOrderId(0L);
        userBooking1.setOrderTitle("orderTitle");
        userBooking1.setPayType("payType");
        userBooking1.setStatus(0);
        userBooking1.setStatusDeposit(false);
        userBooking1.setIsFeedback(false);
        when(bookingServiceImplUnderTest.userBookingRepository.save(any(UserBooking.class))).thenReturn(userBooking1);

        // Run the test
        assertThatThrownBy(() -> bookingServiceImplUnderTest.updateStatusDeposit(0L, false))
                .isInstanceOf(HandlerException.class);
        verify(bookingServiceImplUnderTest.userBookingRepository).save(any(UserBooking.class));
    }

    @Test
    void testCreateRequestCancel() throws Exception {
        // Setup
        final RequestCancelBookingDTO requestCancelBookingDTO = new RequestCancelBookingDTO(0L, 0L,
                new UserBookingDTO(0L, 0L, 0L, "tourName", 0, 0, "fullName", "phone", "email", LocalDate.of(2020, 1, 1),
                        LocalDate.of(2020, 1, 1), "idCard", LocalDate.of(2020, 1, 1), "placeOfIssue", "request", 0.0f,
                        0.0f, 0, 0, 0.0f, 0L, "orderTitle", "payType", 0, false, 0.0f, false), 0L,
                LocalDate.of(2020, 1, 1), "description", 0, "accountEmail");

        // Configure UserBookingRepository.getById(...).
        final UserBooking userBooking = new UserBooking();
        userBooking.setUserBookingId(0L);
        final Account accountId = new Account();
        accountId.setAccountId(0L);
        accountId.setEmail("accountEmail");
        userBooking.setAccountId(accountId);
        final Tour tourId = new Tour();
        tourId.setTourId(0L);
        tourId.setTourName("tourName");
        tourId.setStatus(0);
        tourId.setTourType(0);
        tourId.setDeposit(0.0f);
        userBooking.setTourId(tourId);
        userBooking.setBookingDate(LocalDate.of(2020, 1, 1));
        userBooking.setStartDate(LocalDate.of(2020, 1, 1));
        userBooking.setFullName("fullName");
        userBooking.setPhone("phone");
        userBooking.setEmail("email");
        userBooking.setIdCard("idCard");
        userBooking.setDateOfIssue(LocalDate.of(2020, 1, 1));
        userBooking.setPlaceOfIssue("placeOfIssue");
        userBooking.setRequest("request");
        userBooking.setAdultPrice(0.0f);
        userBooking.setChildrenPrice(0.0f);
        userBooking.setNumberOfAdult(0);
        userBooking.setNumberOfChildren(0);
        userBooking.setTotalPrice(0.0f);
        userBooking.setOrderId(0L);
        userBooking.setOrderTitle("orderTitle");
        userBooking.setPayType("payType");
        userBooking.setStatus(0);
        userBooking.setStatusDeposit(false);
        userBooking.setIsFeedback(false);
        when(bookingServiceImplUnderTest.userBookingRepository.getById(0L)).thenReturn(userBooking);

        // Configure ReasonCancelRepository.getById(...).
        final ReasonCancel reasonCancel = new ReasonCancel();
        reasonCancel.setReasonCancelId(0L);
        reasonCancel.setReasonCancelName("reasonCancelName");
        final RequestCancel requestCancel = new RequestCancel();
        requestCancel.setRequestCancelId(0L);
        final UserBooking userBookingId = new UserBooking();
        userBookingId.setUserBookingId(0L);
        final Account accountId1 = new Account();
        accountId1.setAccountId(0L);
        accountId1.setEmail("accountEmail");
        accountId1.setPassWord("passWord");
        accountId1.setIsBlock(false);
        final Role roleId = new Role();
        roleId.setRoleId(0);
        roleId.setRoleName("roleName");
        roleId.setAccountList(Arrays.asList(new Account()));
        accountId1.setRoleId(roleId);
        userBookingId.setAccountId(accountId1);
        requestCancel.setUserBookingId(userBookingId);
        reasonCancel.setRequestCancelList(Arrays.asList(requestCancel));
        when(bookingServiceImplUnderTest.reasonCancelRepository.getById(0L)).thenReturn(reasonCancel);

        // Configure RequestCancelRepository.save(...).
        final RequestCancel requestCancel1 = new RequestCancel();
        requestCancel1.setRequestCancelId(0L);
        final UserBooking userBookingId1 = new UserBooking();
        userBookingId1.setUserBookingId(0L);
        final Account accountId2 = new Account();
        accountId2.setAccountId(0L);
        accountId2.setEmail("accountEmail");
        userBookingId1.setAccountId(accountId2);
        final Tour tourId1 = new Tour();
        tourId1.setTourId(0L);
        tourId1.setTourName("tourName");
        tourId1.setStatus(0);
        tourId1.setTourType(0);
        tourId1.setDeposit(0.0f);
        userBookingId1.setTourId(tourId1);
        userBookingId1.setBookingDate(LocalDate.of(2020, 1, 1));
        userBookingId1.setStartDate(LocalDate.of(2020, 1, 1));
        userBookingId1.setFullName("fullName");
        userBookingId1.setPhone("phone");
        userBookingId1.setEmail("email");
        userBookingId1.setIdCard("idCard");
        userBookingId1.setDateOfIssue(LocalDate.of(2020, 1, 1));
        userBookingId1.setPlaceOfIssue("placeOfIssue");
        userBookingId1.setRequest("request");
        userBookingId1.setAdultPrice(0.0f);
        userBookingId1.setChildrenPrice(0.0f);
        userBookingId1.setNumberOfAdult(0);
        userBookingId1.setNumberOfChildren(0);
        userBookingId1.setTotalPrice(0.0f);
        userBookingId1.setOrderId(0L);
        userBookingId1.setOrderTitle("orderTitle");
        userBookingId1.setPayType("payType");
        userBookingId1.setStatus(0);
        userBookingId1.setStatusDeposit(false);
        userBookingId1.setIsFeedback(false);
        requestCancel1.setUserBookingId(userBookingId1);
        final ReasonCancel reasonCancelId = new ReasonCancel();
        reasonCancelId.setReasonCancelId(0L);
        requestCancel1.setReasonCancelId(reasonCancelId);
        requestCancel1.setRequestDate(LocalDate.of(2020, 1, 1));
        requestCancel1.setDescription("description");
        requestCancel1.setStatus(0);
        when(bookingServiceImplUnderTest.requestCancelRepository.save(any(RequestCancel.class)))
                .thenReturn(requestCancel1);

        // Run the test
        final Boolean result = bookingServiceImplUnderTest.createRequestCancel(requestCancelBookingDTO);

        // Verify the results
        assertThat(result).isFalse();
        verify(bookingServiceImplUnderTest.requestCancelRepository).save(any(RequestCancel.class));
    }

    @Test
    void testCreateRequestCancel_ThrowsHandlerException() {
        // Setup
        final RequestCancelBookingDTO requestCancelBookingDTO = new RequestCancelBookingDTO(0L, 0L,
                new UserBookingDTO(0L, 0L, 0L, "tourName", 0, 0, "fullName", "phone", "email", LocalDate.of(2020, 1, 1),
                        LocalDate.of(2020, 1, 1), "idCard", LocalDate.of(2020, 1, 1), "placeOfIssue", "request", 0.0f,
                        0.0f, 0, 0, 0.0f, 0L, "orderTitle", "payType", 0, false, 0.0f, false), 0L,
                LocalDate.of(2020, 1, 1), "description", 0, "accountEmail");

        // Configure UserBookingRepository.getById(...).
        final UserBooking userBooking = new UserBooking();
        userBooking.setUserBookingId(0L);
        final Account accountId = new Account();
        accountId.setAccountId(0L);
        accountId.setEmail("accountEmail");
        userBooking.setAccountId(accountId);
        final Tour tourId = new Tour();
        tourId.setTourId(0L);
        tourId.setTourName("tourName");
        tourId.setStatus(0);
        tourId.setTourType(0);
        tourId.setDeposit(0.0f);
        userBooking.setTourId(tourId);
        userBooking.setBookingDate(LocalDate.of(2020, 1, 1));
        userBooking.setStartDate(LocalDate.of(2020, 1, 1));
        userBooking.setFullName("fullName");
        userBooking.setPhone("phone");
        userBooking.setEmail("email");
        userBooking.setIdCard("idCard");
        userBooking.setDateOfIssue(LocalDate.of(2020, 1, 1));
        userBooking.setPlaceOfIssue("placeOfIssue");
        userBooking.setRequest("request");
        userBooking.setAdultPrice(0.0f);
        userBooking.setChildrenPrice(0.0f);
        userBooking.setNumberOfAdult(0);
        userBooking.setNumberOfChildren(0);
        userBooking.setTotalPrice(0.0f);
        userBooking.setOrderId(0L);
        userBooking.setOrderTitle("orderTitle");
        userBooking.setPayType("payType");
        userBooking.setStatus(0);
        userBooking.setStatusDeposit(false);
        userBooking.setIsFeedback(false);
        when(bookingServiceImplUnderTest.userBookingRepository.getById(0L)).thenReturn(userBooking);

        // Configure ReasonCancelRepository.getById(...).
        final ReasonCancel reasonCancel = new ReasonCancel();
        reasonCancel.setReasonCancelId(0L);
        reasonCancel.setReasonCancelName("reasonCancelName");
        final RequestCancel requestCancel = new RequestCancel();
        requestCancel.setRequestCancelId(0L);
        final UserBooking userBookingId = new UserBooking();
        userBookingId.setUserBookingId(0L);
        final Account accountId1 = new Account();
        accountId1.setAccountId(0L);
        accountId1.setEmail("accountEmail");
        accountId1.setPassWord("passWord");
        accountId1.setIsBlock(false);
        final Role roleId = new Role();
        roleId.setRoleId(0);
        roleId.setRoleName("roleName");
        roleId.setAccountList(Arrays.asList(new Account()));
        accountId1.setRoleId(roleId);
        userBookingId.setAccountId(accountId1);
        requestCancel.setUserBookingId(userBookingId);
        reasonCancel.setRequestCancelList(Arrays.asList(requestCancel));
        when(bookingServiceImplUnderTest.reasonCancelRepository.getById(0L)).thenReturn(reasonCancel);

        // Configure RequestCancelRepository.save(...).
        final RequestCancel requestCancel1 = new RequestCancel();
        requestCancel1.setRequestCancelId(0L);
        final UserBooking userBookingId1 = new UserBooking();
        userBookingId1.setUserBookingId(0L);
        final Account accountId2 = new Account();
        accountId2.setAccountId(0L);
        accountId2.setEmail("accountEmail");
        userBookingId1.setAccountId(accountId2);
        final Tour tourId1 = new Tour();
        tourId1.setTourId(0L);
        tourId1.setTourName("tourName");
        tourId1.setStatus(0);
        tourId1.setTourType(0);
        tourId1.setDeposit(0.0f);
        userBookingId1.setTourId(tourId1);
        userBookingId1.setBookingDate(LocalDate.of(2020, 1, 1));
        userBookingId1.setStartDate(LocalDate.of(2020, 1, 1));
        userBookingId1.setFullName("fullName");
        userBookingId1.setPhone("phone");
        userBookingId1.setEmail("email");
        userBookingId1.setIdCard("idCard");
        userBookingId1.setDateOfIssue(LocalDate.of(2020, 1, 1));
        userBookingId1.setPlaceOfIssue("placeOfIssue");
        userBookingId1.setRequest("request");
        userBookingId1.setAdultPrice(0.0f);
        userBookingId1.setChildrenPrice(0.0f);
        userBookingId1.setNumberOfAdult(0);
        userBookingId1.setNumberOfChildren(0);
        userBookingId1.setTotalPrice(0.0f);
        userBookingId1.setOrderId(0L);
        userBookingId1.setOrderTitle("orderTitle");
        userBookingId1.setPayType("payType");
        userBookingId1.setStatus(0);
        userBookingId1.setStatusDeposit(false);
        userBookingId1.setIsFeedback(false);
        requestCancel1.setUserBookingId(userBookingId1);
        final ReasonCancel reasonCancelId = new ReasonCancel();
        reasonCancelId.setReasonCancelId(0L);
        requestCancel1.setReasonCancelId(reasonCancelId);
        requestCancel1.setRequestDate(LocalDate.of(2020, 1, 1));
        requestCancel1.setDescription("description");
        requestCancel1.setStatus(0);
        when(bookingServiceImplUnderTest.requestCancelRepository.save(any(RequestCancel.class)))
                .thenReturn(requestCancel1);

        // Run the test
        assertThatThrownBy(() -> bookingServiceImplUnderTest.createRequestCancel(requestCancelBookingDTO))
                .isInstanceOf(HandlerException.class);
        verify(bookingServiceImplUnderTest.requestCancelRepository).save(any(RequestCancel.class));
    }

    @Test
    void testGetListRequestCancelBooking() throws Exception {
        // Setup
        // Configure RequestCancelRepository.getListRequestCancel(...).
        final RequestCancel requestCancel = new RequestCancel();
        requestCancel.setRequestCancelId(0L);
        final UserBooking userBookingId = new UserBooking();
        userBookingId.setUserBookingId(0L);
        final Account accountId = new Account();
        accountId.setAccountId(0L);
        accountId.setEmail("accountEmail");
        userBookingId.setAccountId(accountId);
        final Tour tourId = new Tour();
        tourId.setTourId(0L);
        tourId.setTourName("tourName");
        tourId.setStatus(0);
        tourId.setTourType(0);
        tourId.setDeposit(0.0f);
        userBookingId.setTourId(tourId);
        userBookingId.setBookingDate(LocalDate.of(2020, 1, 1));
        userBookingId.setStartDate(LocalDate.of(2020, 1, 1));
        userBookingId.setFullName("fullName");
        userBookingId.setPhone("phone");
        userBookingId.setEmail("email");
        userBookingId.setIdCard("idCard");
        userBookingId.setDateOfIssue(LocalDate.of(2020, 1, 1));
        userBookingId.setPlaceOfIssue("placeOfIssue");
        userBookingId.setRequest("request");
        userBookingId.setAdultPrice(0.0f);
        userBookingId.setChildrenPrice(0.0f);
        userBookingId.setNumberOfAdult(0);
        userBookingId.setNumberOfChildren(0);
        userBookingId.setTotalPrice(0.0f);
        userBookingId.setOrderId(0L);
        userBookingId.setOrderTitle("orderTitle");
        userBookingId.setPayType("payType");
        userBookingId.setStatus(0);
        userBookingId.setStatusDeposit(false);
        userBookingId.setIsFeedback(false);
        requestCancel.setUserBookingId(userBookingId);
        final ReasonCancel reasonCancelId = new ReasonCancel();
        reasonCancelId.setReasonCancelId(0L);
        requestCancel.setReasonCancelId(reasonCancelId);
        requestCancel.setRequestDate(LocalDate.of(2020, 1, 1));
        requestCancel.setDescription("description");
        requestCancel.setStatus(0);
        final List<RequestCancel> requestCancels = Arrays.asList(requestCancel);
        when(bookingServiceImplUnderTest.requestCancelRepository.getListRequestCancel("email"))
                .thenReturn(requestCancels);

        // Run the test
        final Page<RequestCancelBookingDTO> result = bookingServiceImplUnderTest.getListRequestCancelBooking("email", 0,
                0);

        // Verify the results
    }

    @Test
    void testGetListRequestCancelBooking_RequestCancelRepositoryReturnsNoItems() throws Exception {
        // Setup
        when(bookingServiceImplUnderTest.requestCancelRepository.getListRequestCancel("email"))
                .thenReturn(Collections.emptyList());

        // Run the test
        final Page<RequestCancelBookingDTO> result = bookingServiceImplUnderTest.getListRequestCancelBooking("email", 0,
                0);

        // Verify the results
    }

    @Test
    void testGetListRequestCancelBooking_ThrowsHandlerException() {
        // Setup
        // Configure RequestCancelRepository.getListRequestCancel(...).
        final RequestCancel requestCancel = new RequestCancel();
        requestCancel.setRequestCancelId(0L);
        final UserBooking userBookingId = new UserBooking();
        userBookingId.setUserBookingId(0L);
        final Account accountId = new Account();
        accountId.setAccountId(0L);
        accountId.setEmail("accountEmail");
        userBookingId.setAccountId(accountId);
        final Tour tourId = new Tour();
        tourId.setTourId(0L);
        tourId.setTourName("tourName");
        tourId.setStatus(0);
        tourId.setTourType(0);
        tourId.setDeposit(0.0f);
        userBookingId.setTourId(tourId);
        userBookingId.setBookingDate(LocalDate.of(2020, 1, 1));
        userBookingId.setStartDate(LocalDate.of(2020, 1, 1));
        userBookingId.setFullName("fullName");
        userBookingId.setPhone("phone");
        userBookingId.setEmail("email");
        userBookingId.setIdCard("idCard");
        userBookingId.setDateOfIssue(LocalDate.of(2020, 1, 1));
        userBookingId.setPlaceOfIssue("placeOfIssue");
        userBookingId.setRequest("request");
        userBookingId.setAdultPrice(0.0f);
        userBookingId.setChildrenPrice(0.0f);
        userBookingId.setNumberOfAdult(0);
        userBookingId.setNumberOfChildren(0);
        userBookingId.setTotalPrice(0.0f);
        userBookingId.setOrderId(0L);
        userBookingId.setOrderTitle("orderTitle");
        userBookingId.setPayType("payType");
        userBookingId.setStatus(0);
        userBookingId.setStatusDeposit(false);
        userBookingId.setIsFeedback(false);
        requestCancel.setUserBookingId(userBookingId);
        final ReasonCancel reasonCancelId = new ReasonCancel();
        reasonCancelId.setReasonCancelId(0L);
        requestCancel.setReasonCancelId(reasonCancelId);
        requestCancel.setRequestDate(LocalDate.of(2020, 1, 1));
        requestCancel.setDescription("description");
        requestCancel.setStatus(0);
        final List<RequestCancel> requestCancels = Arrays.asList(requestCancel);
        when(bookingServiceImplUnderTest.requestCancelRepository.getListRequestCancel("email"))
                .thenReturn(requestCancels);

        // Run the test
        assertThatThrownBy(() -> bookingServiceImplUnderTest.getListRequestCancelBooking("email", 0, 0))
                .isInstanceOf(HandlerException.class);
    }

    @Test
    void testDeleteRequestCancelBooking() throws Exception {
        // Setup
        when(bookingServiceImplUnderTest.requestCancelRepository.existsRequestCancelByUserBookingId_UserBookingId(
                0L)).thenReturn(false);

        // Configure RequestCancelRepository.getRequestCancelByUserBookingId_UserBookingId(...).
        final RequestCancel requestCancel = new RequestCancel();
        requestCancel.setRequestCancelId(0L);
        final UserBooking userBookingId = new UserBooking();
        userBookingId.setUserBookingId(0L);
        final Account accountId = new Account();
        accountId.setAccountId(0L);
        accountId.setEmail("accountEmail");
        userBookingId.setAccountId(accountId);
        final Tour tourId = new Tour();
        tourId.setTourId(0L);
        tourId.setTourName("tourName");
        tourId.setStatus(0);
        tourId.setTourType(0);
        tourId.setDeposit(0.0f);
        userBookingId.setTourId(tourId);
        userBookingId.setBookingDate(LocalDate.of(2020, 1, 1));
        userBookingId.setStartDate(LocalDate.of(2020, 1, 1));
        userBookingId.setFullName("fullName");
        userBookingId.setPhone("phone");
        userBookingId.setEmail("email");
        userBookingId.setIdCard("idCard");
        userBookingId.setDateOfIssue(LocalDate.of(2020, 1, 1));
        userBookingId.setPlaceOfIssue("placeOfIssue");
        userBookingId.setRequest("request");
        userBookingId.setAdultPrice(0.0f);
        userBookingId.setChildrenPrice(0.0f);
        userBookingId.setNumberOfAdult(0);
        userBookingId.setNumberOfChildren(0);
        userBookingId.setTotalPrice(0.0f);
        userBookingId.setOrderId(0L);
        userBookingId.setOrderTitle("orderTitle");
        userBookingId.setPayType("payType");
        userBookingId.setStatus(0);
        userBookingId.setStatusDeposit(false);
        userBookingId.setIsFeedback(false);
        requestCancel.setUserBookingId(userBookingId);
        final ReasonCancel reasonCancelId = new ReasonCancel();
        reasonCancelId.setReasonCancelId(0L);
        requestCancel.setReasonCancelId(reasonCancelId);
        requestCancel.setRequestDate(LocalDate.of(2020, 1, 1));
        requestCancel.setDescription("description");
        requestCancel.setStatus(0);
        when(bookingServiceImplUnderTest.requestCancelRepository.getRequestCancelByUserBookingId_UserBookingId(
                0L)).thenReturn(requestCancel);

        // Run the test
        final Boolean result = bookingServiceImplUnderTest.deleteRequestCancelBooking(0L);

        // Verify the results
        assertThat(result).isFalse();
        verify(bookingServiceImplUnderTest.requestCancelRepository).delete(any(RequestCancel.class));
    }

    @Test
    void testDeleteRequestCancelBooking_ThrowsHandlerException() {
        // Setup
        when(bookingServiceImplUnderTest.requestCancelRepository.existsRequestCancelByUserBookingId_UserBookingId(
                0L)).thenReturn(false);

        // Configure RequestCancelRepository.getRequestCancelByUserBookingId_UserBookingId(...).
        final RequestCancel requestCancel = new RequestCancel();
        requestCancel.setRequestCancelId(0L);
        final UserBooking userBookingId = new UserBooking();
        userBookingId.setUserBookingId(0L);
        final Account accountId = new Account();
        accountId.setAccountId(0L);
        accountId.setEmail("accountEmail");
        userBookingId.setAccountId(accountId);
        final Tour tourId = new Tour();
        tourId.setTourId(0L);
        tourId.setTourName("tourName");
        tourId.setStatus(0);
        tourId.setTourType(0);
        tourId.setDeposit(0.0f);
        userBookingId.setTourId(tourId);
        userBookingId.setBookingDate(LocalDate.of(2020, 1, 1));
        userBookingId.setStartDate(LocalDate.of(2020, 1, 1));
        userBookingId.setFullName("fullName");
        userBookingId.setPhone("phone");
        userBookingId.setEmail("email");
        userBookingId.setIdCard("idCard");
        userBookingId.setDateOfIssue(LocalDate.of(2020, 1, 1));
        userBookingId.setPlaceOfIssue("placeOfIssue");
        userBookingId.setRequest("request");
        userBookingId.setAdultPrice(0.0f);
        userBookingId.setChildrenPrice(0.0f);
        userBookingId.setNumberOfAdult(0);
        userBookingId.setNumberOfChildren(0);
        userBookingId.setTotalPrice(0.0f);
        userBookingId.setOrderId(0L);
        userBookingId.setOrderTitle("orderTitle");
        userBookingId.setPayType("payType");
        userBookingId.setStatus(0);
        userBookingId.setStatusDeposit(false);
        userBookingId.setIsFeedback(false);
        requestCancel.setUserBookingId(userBookingId);
        final ReasonCancel reasonCancelId = new ReasonCancel();
        reasonCancelId.setReasonCancelId(0L);
        requestCancel.setReasonCancelId(reasonCancelId);
        requestCancel.setRequestDate(LocalDate.of(2020, 1, 1));
        requestCancel.setDescription("description");
        requestCancel.setStatus(0);
        when(bookingServiceImplUnderTest.requestCancelRepository.getRequestCancelByUserBookingId_UserBookingId(
                0L)).thenReturn(requestCancel);

        // Run the test
        assertThatThrownBy(() -> bookingServiceImplUnderTest.deleteRequestCancelBooking(0L))
                .isInstanceOf(HandlerException.class);
        verify(bookingServiceImplUnderTest.requestCancelRepository).delete(any(RequestCancel.class));
    }
}

package com.example.wetravel;

import com.example.wetravel.DTO.*;
import com.example.wetravel.Entity.*;
import com.example.wetravel.Exception.HandlerException;
import com.example.wetravel.Repository.*;
import com.example.wetravel.Service.ServiceImpl.TourServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;

class TourServiceImplTest {

    private TourServiceImpl tourServiceImplUnderTest;

    @BeforeEach
    void setUp() throws Exception {
        tourServiceImplUnderTest = new TourServiceImpl();
        tourServiceImplUnderTest.tourCategoryRepository = mock(TourCategoryRepository.class);
        tourServiceImplUnderTest.tagRepository = mock(TagRepository.class);
        tourServiceImplUnderTest.tagOfTourRepository = mock(TagOfTourRepository.class);
        tourServiceImplUnderTest.tourDetailRepository = mock(TourDetailRepository.class);
        tourServiceImplUnderTest.tourRepository = mock(TourRepository.class);
        tourServiceImplUnderTest.tourScheduleRepository = mock(TourScheduleRepository.class);
        tourServiceImplUnderTest.serviceRepository = mock(ServiceRepository.class);
        tourServiceImplUnderTest.accountRepository = mock(AccountRepository.class);
        tourServiceImplUnderTest.userBookingRepository = mock(UserBookingRepository.class);
    }

    @Test
    void testGetAllTour() throws Exception {
        // Setup
        // Configure TourRepository.getListTour(...).
        final Tour tour = new Tour();
        tour.setTourId(0L);
        tour.setTourName("tourName");
        tour.setTourCode("tourCode");
        tour.setStartPlace("startPlace");
        tour.setEndPlace("endPlace");
        tour.setStatus(1);
        tour.setTourType(1);
        tour.setTourMode(false);
        tour.setNumberOfDay(1);
        tour.setNumberOfNight(0);
        tour.setMinAdult(0);
        tour.setMaxAdult(0);
        tour.setMinChildren(0);
        tour.setMaxChildren(0);
        tour.setMinToStart(0);
        tour.setPriceAdult(0.0f);
        tour.setPriceChildren(0.0f);
        tour.setNote("note");
        tour.setStartDate(LocalDate.of(2020, 1, 1));
        tour.setStartTime(LocalTime.of(12, 0, 0));
        tour.setEndTime(LocalTime.of(12, 0, 0));
        tour.setTotalPrice(0.0f);
        tour.setDeposit(0.0f);
        final Account accountId = new Account();
        accountId.setAccountId(2L);
        tour.setAccountId(accountId);
        final TourCategory tourCategoryId = new TourCategory();
        tourCategoryId.setTourCategoryId(1L);
        tour.setTourCategoryId(tourCategoryId);
        final Page<Tour> tours = new PageImpl<>(Arrays.asList(tour));
        when(tourServiceImplUnderTest.tourRepository.getListTour(eq("tourName"), eq(Arrays.asList(0)), eq(0), eq(0),
                eq(0), eq(0), any(Pageable.class))).thenReturn(tours);

        when(tourServiceImplUnderTest.tourRepository.countListTour("tourName", Arrays.asList(0), 1, 1, 1000,
                9000000)).thenReturn(0);

        // Run the test
        final TourListDTO result = tourServiceImplUnderTest.getAllTour("tourName", Arrays.asList(0), 1, 1, 1000, 9000000, 1, 1);

        // Verify the results
    }

    @Test
    void testGetAllTour_TourRepositoryGetListTourReturnsNoItems() throws Exception {
        // Setup
        when(tourServiceImplUnderTest.tourRepository.getListTour(eq("tourName"), eq(Arrays.asList(0)), eq(0), eq(0),
                eq(0), eq(0), any(Pageable.class))).thenReturn(new PageImpl<>(Collections.emptyList()));
        when(tourServiceImplUnderTest.tourRepository.countListTour("tourName", Arrays.asList(0), 0, 0, 0,
                0)).thenReturn(0);

        // Run the test
        final TourListDTO result = tourServiceImplUnderTest.getAllTour("tourName", Arrays.asList(0), 0, 0, 0, 0, 0, 0);

        // Verify the results
    }

    @Test
    void testGetAllTour_ThrowsHandlerException() {
        // Setup
        // Configure TourRepository.getListTour(...).
        final Tour tour = new Tour();
        tour.setTourId(1L);
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
        tour.setPriceAdult(0.0f);
        tour.setPriceChildren(0.0f);
        tour.setNote("note");
        tour.setStartDate(LocalDate.of(2020, 1, 1));
        tour.setStartTime(LocalTime.of(12, 0, 0));
        tour.setEndTime(LocalTime.of(12, 0, 0));
        tour.setTotalPrice(0.0f);
        tour.setDeposit(0.0f);
        final Account accountId = new Account();
        accountId.setAccountId(0L);
        tour.setAccountId(accountId);
        final TourCategory tourCategoryId = new TourCategory();
        tourCategoryId.setTourCategoryId(0L);
        tour.setTourCategoryId(tourCategoryId);
        final Page<Tour> tours = new PageImpl<>(Arrays.asList(tour));
        when(tourServiceImplUnderTest.tourRepository.getListTour(eq("tourName"), eq(Arrays.asList(0)), eq(0), eq(0),
                eq(0), eq(0), any(Pageable.class))).thenReturn(tours);

        when(tourServiceImplUnderTest.tourRepository.countListTour("tourName", Arrays.asList(0), 0, 0, 0,
                0)).thenReturn(0);

        // Run the test
        assertThatThrownBy(
                () -> tourServiceImplUnderTest.getAllTour("tourName", Arrays.asList(0), 0, 0, 0, 0, 0, 0))
                .isInstanceOf(HandlerException.class);
    }

    @Test
    void testGetDetailTour() throws Exception {
        // Setup
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
        tour.setPriceAdult(0.0f);
        tour.setPriceChildren(0.0f);
        tour.setNote("note");
        tour.setStartDate(LocalDate.of(2020, 1, 1));
        tour.setStartTime(LocalTime.of(12, 0, 0));
        tour.setEndTime(LocalTime.of(12, 0, 0));
        tour.setTotalPrice(0.0f);
        tour.setDeposit(0.0f);
        final Account accountId = new Account();
        accountId.setAccountId(0L);
        tour.setAccountId(accountId);
        final TourCategory tourCategoryId = new TourCategory();
        tourCategoryId.setTourCategoryId(0L);
        tour.setTourCategoryId(tourCategoryId);
        when(tourServiceImplUnderTest.tourRepository.getById(0L)).thenReturn(tour);

        when(tourServiceImplUnderTest.tourRepository.existsById(0L)).thenReturn(false);

        // Configure UserBookingRepository.getBookingOfTourPrivateByTourId(...).
        final UserBooking userBooking = new UserBooking();
        userBooking.setUserBookingId(0L);
        final Account accountId1 = new Account();
        accountId1.setAccountId(0L);
        userBooking.setAccountId(accountId1);
        final Tour tourId = new Tour();
        tourId.setTourId(0L);
        tourId.setTourName("tourName");
        tourId.setTourCode("tourCode");
        tourId.setStartPlace("startPlace");
        tourId.setEndPlace("endPlace");
        tourId.setStatus(0);
        tourId.setTourType(0);
        tourId.setTourMode(false);
        tourId.setNumberOfDay(1);
        tourId.setNumberOfNight(0);
        tourId.setMinAdult(0);
        tourId.setMaxAdult(0);
        tourId.setMinChildren(0);
        tourId.setMaxChildren(0);
        tourId.setMinToStart(0);
        tourId.setPriceAdult(0.0f);
        tourId.setPriceChildren(0.0f);
        tourId.setNote("note");
        tourId.setStartDate(LocalDate.of(2020, 1, 1));
        tourId.setStartTime(LocalTime.of(12, 0, 0));
        tourId.setEndTime(LocalTime.of(12, 0, 0));
        tourId.setTotalPrice(0.0f);
        tourId.setDeposit(0.0f);
        final Account accountId2 = new Account();
        accountId2.setAccountId(0L);
        tourId.setAccountId(accountId2);
        final TourCategory tourCategoryId1 = new TourCategory();
        tourCategoryId1.setTourCategoryId(0L);
        tourId.setTourCategoryId(tourCategoryId1);
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
        final List<UserBooking> userBookingList = Arrays.asList(userBooking);
        when(tourServiceImplUnderTest.userBookingRepository.getBookingOfTourPrivateByTourId(0L))
                .thenReturn(userBookingList);

        // Configure TourDetailRepository.getByTourId(...).
        final TourDetail tourDetail = new TourDetail();
        tourDetail.setTourDetailId(0L);
        tourDetail.setTourIntroduce("tourIntroduce");
        tourDetail.setTourInclude("tourInclude");
        tourDetail.setTourNonInclude("tourNonInclude");
        tourDetail.setGeneralTerms("generalTerms");
        tourDetail.setAddressStart("addressStart");
        tourDetail.setDescription("description");
        tourDetail.setMoreDescription("moreDescription");
        tourDetail.setLongitude(0.0f);
        tourDetail.setLatitude(0.0f);
        final Tour tourId1 = new Tour();
        tourId1.setTourId(0L);
        tourId1.setTourName("tourName");
        tourId1.setTourCode("tourCode");
        tourId1.setStartPlace("startPlace");
        tourId1.setEndPlace("endPlace");
        tourId1.setStatus(0);
        tourId1.setTourType(0);
        tourId1.setTourMode(false);
        tourId1.setNumberOfDay(1);
        tourId1.setNumberOfNight(0);
        tourId1.setMinAdult(0);
        tourId1.setMaxAdult(0);
        tourId1.setMinChildren(0);
        tourId1.setMaxChildren(0);
        tourId1.setMinToStart(0);
        tourId1.setPriceAdult(0.0f);
        tourId1.setPriceChildren(0.0f);
        tourId1.setNote("note");
        tourId1.setStartDate(LocalDate.of(2020, 1, 1));
        tourId1.setStartTime(LocalTime.of(12, 0, 0));
        tourId1.setEndTime(LocalTime.of(12, 0, 0));
        tourId1.setTotalPrice(0.0f);
        tourId1.setDeposit(0.0f);
        final Account accountId3 = new Account();
        accountId3.setAccountId(0L);
        tourId1.setAccountId(accountId3);
        final TourCategory tourCategoryId2 = new TourCategory();
        tourCategoryId2.setTourCategoryId(0L);
        tourId1.setTourCategoryId(tourCategoryId2);
        tourDetail.setTourId(tourId1);
        when(tourServiceImplUnderTest.tourDetailRepository.getByTourId(0L)).thenReturn(tourDetail);

        // Configure TagOfTourRepository.getByTourDetailId(...).
        final TagOfTour tagOfTour = new TagOfTour();
        final Tag tagId = new Tag();
        tagId.setTagId(0L);
        tagOfTour.setTagId(tagId);
        final TourDetail tourDetailId = new TourDetail();
        tourDetailId.setTourDetailId(0L);
        tourDetailId.setTourIntroduce("tourIntroduce");
        tourDetailId.setTourInclude("tourInclude");
        tourDetailId.setTourNonInclude("tourNonInclude");
        tourDetailId.setGeneralTerms("generalTerms");
        tourDetailId.setAddressStart("addressStart");
        tourDetailId.setDescription("description");
        tourDetailId.setMoreDescription("moreDescription");
        tourDetailId.setLongitude(0.0f);
        tourDetailId.setLatitude(0.0f);
        final Tour tourId2 = new Tour();
        tourId2.setTourId(0L);
        tourId2.setTourName("tourName");
        tourId2.setTourCode("tourCode");
        tourId2.setStartPlace("startPlace");
        tourId2.setEndPlace("endPlace");
        tourId2.setStatus(0);
        tourId2.setTourType(0);
        tourId2.setTourMode(false);
        tourId2.setNumberOfDay(1);
        tourId2.setNumberOfNight(0);
        tourId2.setMinAdult(0);
        tourId2.setMaxAdult(0);
        tourId2.setMinChildren(0);
        tourId2.setMaxChildren(0);
        tourId2.setMinToStart(0);
        tourId2.setPriceAdult(0.0f);
        tourId2.setPriceChildren(0.0f);
        tourId2.setNote("note");
        tourId2.setStartDate(LocalDate.of(2020, 1, 1));
        tourId2.setStartTime(LocalTime.of(12, 0, 0));
        tourId2.setEndTime(LocalTime.of(12, 0, 0));
        tourId2.setTotalPrice(0.0f);
        tourId2.setDeposit(0.0f);
        final Account accountId4 = new Account();
        accountId4.setAccountId(0L);
        tourId2.setAccountId(accountId4);
        final TourCategory tourCategoryId3 = new TourCategory();
        tourCategoryId3.setTourCategoryId(0L);
        tourId2.setTourCategoryId(tourCategoryId3);
        tourDetailId.setTourId(tourId2);
        tagOfTour.setTourDetailId(tourDetailId);
        final List<TagOfTour> tagOfTourList = Arrays.asList(tagOfTour);
        when(tourServiceImplUnderTest.tagOfTourRepository.getByTourDetailId(0L)).thenReturn(tagOfTourList);

        // Configure TourScheduleRepository.getByTourId(...).
        final TourSchedule tourSchedule = new TourSchedule();
        tourSchedule.setTourScheduleName("tourScheduleName");
        tourSchedule.setContent("content");
        tourSchedule.setToPlace("toPlace");
        final Tour tourId3 = new Tour();
        tourId3.setTourId(0L);
        tourId3.setTourName("tourName");
        tourId3.setTourCode("tourCode");
        tourId3.setStartPlace("startPlace");
        tourId3.setEndPlace("endPlace");
        tourId3.setStatus(0);
        tourId3.setTourType(0);
        tourId3.setTourMode(false);
        tourId3.setNumberOfDay(1);
        tourId3.setNumberOfNight(0);
        tourId3.setMinAdult(0);
        tourId3.setMaxAdult(0);
        tourId3.setMinChildren(0);
        tourId3.setMaxChildren(0);
        tourId3.setMinToStart(0);
        tourId3.setPriceAdult(0.0f);
        tourId3.setPriceChildren(0.0f);
        tourId3.setNote("note");
        tourId3.setStartDate(LocalDate.of(2020, 1, 1));
        tourId3.setStartTime(LocalTime.of(12, 0, 0));
        tourId3.setEndTime(LocalTime.of(12, 0, 0));
        tourId3.setTotalPrice(0.0f);
        tourId3.setDeposit(0.0f);
        final Account accountId5 = new Account();
        accountId5.setAccountId(0L);
        tourId3.setAccountId(accountId5);
        final TourCategory tourCategoryId4 = new TourCategory();
        tourCategoryId4.setTourCategoryId(0L);
        tourId3.setTourCategoryId(tourCategoryId4);
        tourSchedule.setTourId(tourId3);
        final List<TourSchedule> tourScheduleList = Arrays.asList(tourSchedule);
        when(tourServiceImplUnderTest.tourScheduleRepository.getByTourId(0L)).thenReturn(tourScheduleList);

        // Run the test
        final TourDTO result = tourServiceImplUnderTest.getDetailTour(0L);

        // Verify the results
    }

    @Test
    void testGetDetailTour_UserBookingRepositoryReturnsNoItems() throws Exception {
        // Setup
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
        tour.setPriceAdult(0.0f);
        tour.setPriceChildren(0.0f);
        tour.setNote("note");
        tour.setStartDate(LocalDate.of(2020, 1, 1));
        tour.setStartTime(LocalTime.of(12, 0, 0));
        tour.setEndTime(LocalTime.of(12, 0, 0));
        tour.setTotalPrice(0.0f);
        tour.setDeposit(0.0f);
        final Account accountId = new Account();
        accountId.setAccountId(0L);
        tour.setAccountId(accountId);
        final TourCategory tourCategoryId = new TourCategory();
        tourCategoryId.setTourCategoryId(0L);
        tour.setTourCategoryId(tourCategoryId);
        when(tourServiceImplUnderTest.tourRepository.getById(0L)).thenReturn(tour);

        when(tourServiceImplUnderTest.tourRepository.existsById(0L)).thenReturn(false);
        when(tourServiceImplUnderTest.userBookingRepository.getBookingOfTourPrivateByTourId(0L))
                .thenReturn(Collections.emptyList());

        // Configure TourDetailRepository.getByTourId(...).
        final TourDetail tourDetail = new TourDetail();
        tourDetail.setTourDetailId(0L);
        tourDetail.setTourIntroduce("tourIntroduce");
        tourDetail.setTourInclude("tourInclude");
        tourDetail.setTourNonInclude("tourNonInclude");
        tourDetail.setGeneralTerms("generalTerms");
        tourDetail.setAddressStart("addressStart");
        tourDetail.setDescription("description");
        tourDetail.setMoreDescription("moreDescription");
        tourDetail.setLongitude(0.0f);
        tourDetail.setLatitude(0.0f);
        final Tour tourId = new Tour();
        tourId.setTourId(0L);
        tourId.setTourName("tourName");
        tourId.setTourCode("tourCode");
        tourId.setStartPlace("startPlace");
        tourId.setEndPlace("endPlace");
        tourId.setStatus(0);
        tourId.setTourType(0);
        tourId.setTourMode(false);
        tourId.setNumberOfDay(1);
        tourId.setNumberOfNight(0);
        tourId.setMinAdult(0);
        tourId.setMaxAdult(0);
        tourId.setMinChildren(0);
        tourId.setMaxChildren(0);
        tourId.setMinToStart(0);
        tourId.setPriceAdult(0.0f);
        tourId.setPriceChildren(0.0f);
        tourId.setNote("note");
        tourId.setStartDate(LocalDate.of(2020, 1, 1));
        tourId.setStartTime(LocalTime.of(12, 0, 0));
        tourId.setEndTime(LocalTime.of(12, 0, 0));
        tourId.setTotalPrice(0.0f);
        tourId.setDeposit(0.0f);
        final Account accountId1 = new Account();
        accountId1.setAccountId(0L);
        tourId.setAccountId(accountId1);
        final TourCategory tourCategoryId1 = new TourCategory();
        tourCategoryId1.setTourCategoryId(0L);
        tourId.setTourCategoryId(tourCategoryId1);
        tourDetail.setTourId(tourId);
        when(tourServiceImplUnderTest.tourDetailRepository.getByTourId(0L)).thenReturn(tourDetail);

        // Configure TagOfTourRepository.getByTourDetailId(...).
        final TagOfTour tagOfTour = new TagOfTour();
        final Tag tagId = new Tag();
        tagId.setTagId(0L);
        tagOfTour.setTagId(tagId);
        final TourDetail tourDetailId = new TourDetail();
        tourDetailId.setTourDetailId(0L);
        tourDetailId.setTourIntroduce("tourIntroduce");
        tourDetailId.setTourInclude("tourInclude");
        tourDetailId.setTourNonInclude("tourNonInclude");
        tourDetailId.setGeneralTerms("generalTerms");
        tourDetailId.setAddressStart("addressStart");
        tourDetailId.setDescription("description");
        tourDetailId.setMoreDescription("moreDescription");
        tourDetailId.setLongitude(0.0f);
        tourDetailId.setLatitude(0.0f);
        final Tour tourId1 = new Tour();
        tourId1.setTourId(0L);
        tourId1.setTourName("tourName");
        tourId1.setTourCode("tourCode");
        tourId1.setStartPlace("startPlace");
        tourId1.setEndPlace("endPlace");
        tourId1.setStatus(0);
        tourId1.setTourType(0);
        tourId1.setTourMode(false);
        tourId1.setNumberOfDay(1);
        tourId1.setNumberOfNight(0);
        tourId1.setMinAdult(0);
        tourId1.setMaxAdult(0);
        tourId1.setMinChildren(0);
        tourId1.setMaxChildren(0);
        tourId1.setMinToStart(0);
        tourId1.setPriceAdult(0.0f);
        tourId1.setPriceChildren(0.0f);
        tourId1.setNote("note");
        tourId1.setStartDate(LocalDate.of(2020, 1, 1));
        tourId1.setStartTime(LocalTime.of(12, 0, 0));
        tourId1.setEndTime(LocalTime.of(12, 0, 0));
        tourId1.setTotalPrice(0.0f);
        tourId1.setDeposit(0.0f);
        final Account accountId2 = new Account();
        accountId2.setAccountId(0L);
        tourId1.setAccountId(accountId2);
        final TourCategory tourCategoryId2 = new TourCategory();
        tourCategoryId2.setTourCategoryId(0L);
        tourId1.setTourCategoryId(tourCategoryId2);
        tourDetailId.setTourId(tourId1);
        tagOfTour.setTourDetailId(tourDetailId);
        final List<TagOfTour> tagOfTourList = Arrays.asList(tagOfTour);
        when(tourServiceImplUnderTest.tagOfTourRepository.getByTourDetailId(0L)).thenReturn(tagOfTourList);

        // Configure TourScheduleRepository.getByTourId(...).
        final TourSchedule tourSchedule = new TourSchedule();
        tourSchedule.setTourScheduleName("tourScheduleName");
        tourSchedule.setContent("content");
        tourSchedule.setToPlace("toPlace");
        final Tour tourId2 = new Tour();
        tourId2.setTourId(0L);
        tourId2.setTourName("tourName");
        tourId2.setTourCode("tourCode");
        tourId2.setStartPlace("startPlace");
        tourId2.setEndPlace("endPlace");
        tourId2.setStatus(0);
        tourId2.setTourType(0);
        tourId2.setTourMode(false);
        tourId2.setNumberOfDay(1);
        tourId2.setNumberOfNight(0);
        tourId2.setMinAdult(0);
        tourId2.setMaxAdult(0);
        tourId2.setMinChildren(0);
        tourId2.setMaxChildren(0);
        tourId2.setMinToStart(0);
        tourId2.setPriceAdult(0.0f);
        tourId2.setPriceChildren(0.0f);
        tourId2.setNote("note");
        tourId2.setStartDate(LocalDate.of(2020, 1, 1));
        tourId2.setStartTime(LocalTime.of(12, 0, 0));
        tourId2.setEndTime(LocalTime.of(12, 0, 0));
        tourId2.setTotalPrice(0.0f);
        tourId2.setDeposit(0.0f);
        final Account accountId3 = new Account();
        accountId3.setAccountId(0L);
        tourId2.setAccountId(accountId3);
        final TourCategory tourCategoryId3 = new TourCategory();
        tourCategoryId3.setTourCategoryId(0L);
        tourId2.setTourCategoryId(tourCategoryId3);
        tourSchedule.setTourId(tourId2);
        final List<TourSchedule> tourScheduleList = Arrays.asList(tourSchedule);
        when(tourServiceImplUnderTest.tourScheduleRepository.getByTourId(0L)).thenReturn(tourScheduleList);

        // Run the test
        final TourDTO result = tourServiceImplUnderTest.getDetailTour(0L);

        // Verify the results
    }

    @Test
    void testGetDetailTour_TagOfTourRepositoryReturnsNoItems() throws Exception {
        // Setup
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
        tour.setPriceAdult(0.0f);
        tour.setPriceChildren(0.0f);
        tour.setNote("note");
        tour.setStartDate(LocalDate.of(2020, 1, 1));
        tour.setStartTime(LocalTime.of(12, 0, 0));
        tour.setEndTime(LocalTime.of(12, 0, 0));
        tour.setTotalPrice(0.0f);
        tour.setDeposit(0.0f);
        final Account accountId = new Account();
        accountId.setAccountId(0L);
        tour.setAccountId(accountId);
        final TourCategory tourCategoryId = new TourCategory();
        tourCategoryId.setTourCategoryId(0L);
        tour.setTourCategoryId(tourCategoryId);
        when(tourServiceImplUnderTest.tourRepository.getById(0L)).thenReturn(tour);

        when(tourServiceImplUnderTest.tourRepository.existsById(0L)).thenReturn(false);

        // Configure UserBookingRepository.getBookingOfTourPrivateByTourId(...).
        final UserBooking userBooking = new UserBooking();
        userBooking.setUserBookingId(0L);
        final Account accountId1 = new Account();
        accountId1.setAccountId(0L);
        userBooking.setAccountId(accountId1);
        final Tour tourId = new Tour();
        tourId.setTourId(0L);
        tourId.setTourName("tourName");
        tourId.setTourCode("tourCode");
        tourId.setStartPlace("startPlace");
        tourId.setEndPlace("endPlace");
        tourId.setStatus(0);
        tourId.setTourType(0);
        tourId.setTourMode(false);
        tourId.setNumberOfDay(1);
        tourId.setNumberOfNight(0);
        tourId.setMinAdult(0);
        tourId.setMaxAdult(0);
        tourId.setMinChildren(0);
        tourId.setMaxChildren(0);
        tourId.setMinToStart(0);
        tourId.setPriceAdult(0.0f);
        tourId.setPriceChildren(0.0f);
        tourId.setNote("note");
        tourId.setStartDate(LocalDate.of(2020, 1, 1));
        tourId.setStartTime(LocalTime.of(12, 0, 0));
        tourId.setEndTime(LocalTime.of(12, 0, 0));
        tourId.setTotalPrice(0.0f);
        tourId.setDeposit(0.0f);
        final Account accountId2 = new Account();
        accountId2.setAccountId(0L);
        tourId.setAccountId(accountId2);
        final TourCategory tourCategoryId1 = new TourCategory();
        tourCategoryId1.setTourCategoryId(0L);
        tourId.setTourCategoryId(tourCategoryId1);
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
        final List<UserBooking> userBookingList = Arrays.asList(userBooking);
        when(tourServiceImplUnderTest.userBookingRepository.getBookingOfTourPrivateByTourId(0L))
                .thenReturn(userBookingList);

        // Configure TourDetailRepository.getByTourId(...).
        final TourDetail tourDetail = new TourDetail();
        tourDetail.setTourDetailId(0L);
        tourDetail.setTourIntroduce("tourIntroduce");
        tourDetail.setTourInclude("tourInclude");
        tourDetail.setTourNonInclude("tourNonInclude");
        tourDetail.setGeneralTerms("generalTerms");
        tourDetail.setAddressStart("addressStart");
        tourDetail.setDescription("description");
        tourDetail.setMoreDescription("moreDescription");
        tourDetail.setLongitude(0.0f);
        tourDetail.setLatitude(0.0f);
        final Tour tourId1 = new Tour();
        tourId1.setTourId(0L);
        tourId1.setTourName("tourName");
        tourId1.setTourCode("tourCode");
        tourId1.setStartPlace("startPlace");
        tourId1.setEndPlace("endPlace");
        tourId1.setStatus(0);
        tourId1.setTourType(0);
        tourId1.setTourMode(false);
        tourId1.setNumberOfDay(1);
        tourId1.setNumberOfNight(0);
        tourId1.setMinAdult(0);
        tourId1.setMaxAdult(0);
        tourId1.setMinChildren(0);
        tourId1.setMaxChildren(0);
        tourId1.setMinToStart(0);
        tourId1.setPriceAdult(0.0f);
        tourId1.setPriceChildren(0.0f);
        tourId1.setNote("note");
        tourId1.setStartDate(LocalDate.of(2020, 1, 1));
        tourId1.setStartTime(LocalTime.of(12, 0, 0));
        tourId1.setEndTime(LocalTime.of(12, 0, 0));
        tourId1.setTotalPrice(0.0f);
        tourId1.setDeposit(0.0f);
        final Account accountId3 = new Account();
        accountId3.setAccountId(0L);
        tourId1.setAccountId(accountId3);
        final TourCategory tourCategoryId2 = new TourCategory();
        tourCategoryId2.setTourCategoryId(0L);
        tourId1.setTourCategoryId(tourCategoryId2);
        tourDetail.setTourId(tourId1);
        when(tourServiceImplUnderTest.tourDetailRepository.getByTourId(0L)).thenReturn(tourDetail);

        when(tourServiceImplUnderTest.tagOfTourRepository.getByTourDetailId(0L)).thenReturn(Collections.emptyList());

        // Configure TourScheduleRepository.getByTourId(...).
        final TourSchedule tourSchedule = new TourSchedule();
        tourSchedule.setTourScheduleName("tourScheduleName");
        tourSchedule.setContent("content");
        tourSchedule.setToPlace("toPlace");
        final Tour tourId2 = new Tour();
        tourId2.setTourId(0L);
        tourId2.setTourName("tourName");
        tourId2.setTourCode("tourCode");
        tourId2.setStartPlace("startPlace");
        tourId2.setEndPlace("endPlace");
        tourId2.setStatus(0);
        tourId2.setTourType(0);
        tourId2.setTourMode(false);
        tourId2.setNumberOfDay(1);
        tourId2.setNumberOfNight(0);
        tourId2.setMinAdult(0);
        tourId2.setMaxAdult(0);
        tourId2.setMinChildren(0);
        tourId2.setMaxChildren(0);
        tourId2.setMinToStart(0);
        tourId2.setPriceAdult(0.0f);
        tourId2.setPriceChildren(0.0f);
        tourId2.setNote("note");
        tourId2.setStartDate(LocalDate.of(2020, 1, 1));
        tourId2.setStartTime(LocalTime.of(12, 0, 0));
        tourId2.setEndTime(LocalTime.of(12, 0, 0));
        tourId2.setTotalPrice(0.0f);
        tourId2.setDeposit(0.0f);
        final Account accountId4 = new Account();
        accountId4.setAccountId(0L);
        tourId2.setAccountId(accountId4);
        final TourCategory tourCategoryId3 = new TourCategory();
        tourCategoryId3.setTourCategoryId(0L);
        tourId2.setTourCategoryId(tourCategoryId3);
        tourSchedule.setTourId(tourId2);
        final List<TourSchedule> tourScheduleList = Arrays.asList(tourSchedule);
        when(tourServiceImplUnderTest.tourScheduleRepository.getByTourId(0L)).thenReturn(tourScheduleList);

        // Run the test
        final TourDTO result = tourServiceImplUnderTest.getDetailTour(0L);

        // Verify the results
    }

    @Test
    void testGetDetailTour_TourScheduleRepositoryReturnsNoItems() throws Exception {
        // Setup
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
        tour.setPriceAdult(0.0f);
        tour.setPriceChildren(0.0f);
        tour.setNote("note");
        tour.setStartDate(LocalDate.of(2020, 1, 1));
        tour.setStartTime(LocalTime.of(12, 0, 0));
        tour.setEndTime(LocalTime.of(12, 0, 0));
        tour.setTotalPrice(0.0f);
        tour.setDeposit(0.0f);
        final Account accountId = new Account();
        accountId.setAccountId(0L);
        tour.setAccountId(accountId);
        final TourCategory tourCategoryId = new TourCategory();
        tourCategoryId.setTourCategoryId(0L);
        tour.setTourCategoryId(tourCategoryId);
        when(tourServiceImplUnderTest.tourRepository.getById(0L)).thenReturn(tour);

        when(tourServiceImplUnderTest.tourRepository.existsById(0L)).thenReturn(false);

        // Configure UserBookingRepository.getBookingOfTourPrivateByTourId(...).
        final UserBooking userBooking = new UserBooking();
        userBooking.setUserBookingId(0L);
        final Account accountId1 = new Account();
        accountId1.setAccountId(0L);
        userBooking.setAccountId(accountId1);
        final Tour tourId = new Tour();
        tourId.setTourId(0L);
        tourId.setTourName("tourName");
        tourId.setTourCode("tourCode");
        tourId.setStartPlace("startPlace");
        tourId.setEndPlace("endPlace");
        tourId.setStatus(0);
        tourId.setTourType(0);
        tourId.setTourMode(false);
        tourId.setNumberOfDay(1);
        tourId.setNumberOfNight(0);
        tourId.setMinAdult(0);
        tourId.setMaxAdult(0);
        tourId.setMinChildren(0);
        tourId.setMaxChildren(0);
        tourId.setMinToStart(0);
        tourId.setPriceAdult(0.0f);
        tourId.setPriceChildren(0.0f);
        tourId.setNote("note");
        tourId.setStartDate(LocalDate.of(2020, 1, 1));
        tourId.setStartTime(LocalTime.of(12, 0, 0));
        tourId.setEndTime(LocalTime.of(12, 0, 0));
        tourId.setTotalPrice(0.0f);
        tourId.setDeposit(0.0f);
        final Account accountId2 = new Account();
        accountId2.setAccountId(0L);
        tourId.setAccountId(accountId2);
        final TourCategory tourCategoryId1 = new TourCategory();
        tourCategoryId1.setTourCategoryId(0L);
        tourId.setTourCategoryId(tourCategoryId1);
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
        final List<UserBooking> userBookingList = Arrays.asList(userBooking);
        when(tourServiceImplUnderTest.userBookingRepository.getBookingOfTourPrivateByTourId(0L))
                .thenReturn(userBookingList);

        // Configure TourDetailRepository.getByTourId(...).
        final TourDetail tourDetail = new TourDetail();
        tourDetail.setTourDetailId(0L);
        tourDetail.setTourIntroduce("tourIntroduce");
        tourDetail.setTourInclude("tourInclude");
        tourDetail.setTourNonInclude("tourNonInclude");
        tourDetail.setGeneralTerms("generalTerms");
        tourDetail.setAddressStart("addressStart");
        tourDetail.setDescription("description");
        tourDetail.setMoreDescription("moreDescription");
        tourDetail.setLongitude(0.0f);
        tourDetail.setLatitude(0.0f);
        final Tour tourId1 = new Tour();
        tourId1.setTourId(0L);
        tourId1.setTourName("tourName");
        tourId1.setTourCode("tourCode");
        tourId1.setStartPlace("startPlace");
        tourId1.setEndPlace("endPlace");
        tourId1.setStatus(0);
        tourId1.setTourType(0);
        tourId1.setTourMode(false);
        tourId1.setNumberOfDay(1);
        tourId1.setNumberOfNight(0);
        tourId1.setMinAdult(0);
        tourId1.setMaxAdult(0);
        tourId1.setMinChildren(0);
        tourId1.setMaxChildren(0);
        tourId1.setMinToStart(0);
        tourId1.setPriceAdult(0.0f);
        tourId1.setPriceChildren(0.0f);
        tourId1.setNote("note");
        tourId1.setStartDate(LocalDate.of(2020, 1, 1));
        tourId1.setStartTime(LocalTime.of(12, 0, 0));
        tourId1.setEndTime(LocalTime.of(12, 0, 0));
        tourId1.setTotalPrice(0.0f);
        tourId1.setDeposit(0.0f);
        final Account accountId3 = new Account();
        accountId3.setAccountId(0L);
        tourId1.setAccountId(accountId3);
        final TourCategory tourCategoryId2 = new TourCategory();
        tourCategoryId2.setTourCategoryId(0L);
        tourId1.setTourCategoryId(tourCategoryId2);
        tourDetail.setTourId(tourId1);
        when(tourServiceImplUnderTest.tourDetailRepository.getByTourId(0L)).thenReturn(tourDetail);

        // Configure TagOfTourRepository.getByTourDetailId(...).
        final TagOfTour tagOfTour = new TagOfTour();
        final Tag tagId = new Tag();
        tagId.setTagId(0L);
        tagOfTour.setTagId(tagId);
        final TourDetail tourDetailId = new TourDetail();
        tourDetailId.setTourDetailId(0L);
        tourDetailId.setTourIntroduce("tourIntroduce");
        tourDetailId.setTourInclude("tourInclude");
        tourDetailId.setTourNonInclude("tourNonInclude");
        tourDetailId.setGeneralTerms("generalTerms");
        tourDetailId.setAddressStart("addressStart");
        tourDetailId.setDescription("description");
        tourDetailId.setMoreDescription("moreDescription");
        tourDetailId.setLongitude(0.0f);
        tourDetailId.setLatitude(0.0f);
        final Tour tourId2 = new Tour();
        tourId2.setTourId(0L);
        tourId2.setTourName("tourName");
        tourId2.setTourCode("tourCode");
        tourId2.setStartPlace("startPlace");
        tourId2.setEndPlace("endPlace");
        tourId2.setStatus(0);
        tourId2.setTourType(0);
        tourId2.setTourMode(false);
        tourId2.setNumberOfDay(1);
        tourId2.setNumberOfNight(0);
        tourId2.setMinAdult(0);
        tourId2.setMaxAdult(0);
        tourId2.setMinChildren(0);
        tourId2.setMaxChildren(0);
        tourId2.setMinToStart(0);
        tourId2.setPriceAdult(0.0f);
        tourId2.setPriceChildren(0.0f);
        tourId2.setNote("note");
        tourId2.setStartDate(LocalDate.of(2020, 1, 1));
        tourId2.setStartTime(LocalTime.of(12, 0, 0));
        tourId2.setEndTime(LocalTime.of(12, 0, 0));
        tourId2.setTotalPrice(0.0f);
        tourId2.setDeposit(0.0f);
        final Account accountId4 = new Account();
        accountId4.setAccountId(0L);
        tourId2.setAccountId(accountId4);
        final TourCategory tourCategoryId3 = new TourCategory();
        tourCategoryId3.setTourCategoryId(0L);
        tourId2.setTourCategoryId(tourCategoryId3);
        tourDetailId.setTourId(tourId2);
        tagOfTour.setTourDetailId(tourDetailId);
        final List<TagOfTour> tagOfTourList = Arrays.asList(tagOfTour);
        when(tourServiceImplUnderTest.tagOfTourRepository.getByTourDetailId(0L)).thenReturn(tagOfTourList);

        when(tourServiceImplUnderTest.tourScheduleRepository.getByTourId(0L)).thenReturn(Collections.emptyList());

        // Run the test
        final TourDTO result = tourServiceImplUnderTest.getDetailTour(0L);

        // Verify the results
    }

    @Test
    void testGetDetailTour_ThrowsHandlerException() {
        // Setup
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
        tour.setPriceAdult(0.0f);
        tour.setPriceChildren(0.0f);
        tour.setNote("note");
        tour.setStartDate(LocalDate.of(2020, 1, 1));
        tour.setStartTime(LocalTime.of(12, 0, 0));
        tour.setEndTime(LocalTime.of(12, 0, 0));
        tour.setTotalPrice(0.0f);
        tour.setDeposit(0.0f);
        final Account accountId = new Account();
        accountId.setAccountId(0L);
        tour.setAccountId(accountId);
        final TourCategory tourCategoryId = new TourCategory();
        tourCategoryId.setTourCategoryId(0L);
        tour.setTourCategoryId(tourCategoryId);
        when(tourServiceImplUnderTest.tourRepository.getById(0L)).thenReturn(tour);

        when(tourServiceImplUnderTest.tourRepository.existsById(0L)).thenReturn(false);

        // Configure UserBookingRepository.getBookingOfTourPrivateByTourId(...).
        final UserBooking userBooking = new UserBooking();
        userBooking.setUserBookingId(0L);
        final Account accountId1 = new Account();
        accountId1.setAccountId(0L);
        userBooking.setAccountId(accountId1);
        final Tour tourId = new Tour();
        tourId.setTourId(0L);
        tourId.setTourName("tourName");
        tourId.setTourCode("tourCode");
        tourId.setStartPlace("startPlace");
        tourId.setEndPlace("endPlace");
        tourId.setStatus(0);
        tourId.setTourType(0);
        tourId.setTourMode(false);
        tourId.setNumberOfDay(1);
        tourId.setNumberOfNight(0);
        tourId.setMinAdult(0);
        tourId.setMaxAdult(0);
        tourId.setMinChildren(0);
        tourId.setMaxChildren(0);
        tourId.setMinToStart(0);
        tourId.setPriceAdult(0.0f);
        tourId.setPriceChildren(0.0f);
        tourId.setNote("note");
        tourId.setStartDate(LocalDate.of(2020, 1, 1));
        tourId.setStartTime(LocalTime.of(12, 0, 0));
        tourId.setEndTime(LocalTime.of(12, 0, 0));
        tourId.setTotalPrice(0.0f);
        tourId.setDeposit(0.0f);
        final Account accountId2 = new Account();
        accountId2.setAccountId(0L);
        tourId.setAccountId(accountId2);
        final TourCategory tourCategoryId1 = new TourCategory();
        tourCategoryId1.setTourCategoryId(0L);
        tourId.setTourCategoryId(tourCategoryId1);
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
        final List<UserBooking> userBookingList = Arrays.asList(userBooking);
        when(tourServiceImplUnderTest.userBookingRepository.getBookingOfTourPrivateByTourId(0L))
                .thenReturn(userBookingList);

        // Configure TourDetailRepository.getByTourId(...).
        final TourDetail tourDetail = new TourDetail();
        tourDetail.setTourDetailId(0L);
        tourDetail.setTourIntroduce("tourIntroduce");
        tourDetail.setTourInclude("tourInclude");
        tourDetail.setTourNonInclude("tourNonInclude");
        tourDetail.setGeneralTerms("generalTerms");
        tourDetail.setAddressStart("addressStart");
        tourDetail.setDescription("description");
        tourDetail.setMoreDescription("moreDescription");
        tourDetail.setLongitude(0.0f);
        tourDetail.setLatitude(0.0f);
        final Tour tourId1 = new Tour();
        tourId1.setTourId(0L);
        tourId1.setTourName("tourName");
        tourId1.setTourCode("tourCode");
        tourId1.setStartPlace("startPlace");
        tourId1.setEndPlace("endPlace");
        tourId1.setStatus(0);
        tourId1.setTourType(0);
        tourId1.setTourMode(false);
        tourId1.setNumberOfDay(1);
        tourId1.setNumberOfNight(0);
        tourId1.setMinAdult(0);
        tourId1.setMaxAdult(0);
        tourId1.setMinChildren(0);
        tourId1.setMaxChildren(0);
        tourId1.setMinToStart(0);
        tourId1.setPriceAdult(0.0f);
        tourId1.setPriceChildren(0.0f);
        tourId1.setNote("note");
        tourId1.setStartDate(LocalDate.of(2020, 1, 1));
        tourId1.setStartTime(LocalTime.of(12, 0, 0));
        tourId1.setEndTime(LocalTime.of(12, 0, 0));
        tourId1.setTotalPrice(0.0f);
        tourId1.setDeposit(0.0f);
        final Account accountId3 = new Account();
        accountId3.setAccountId(0L);
        tourId1.setAccountId(accountId3);
        final TourCategory tourCategoryId2 = new TourCategory();
        tourCategoryId2.setTourCategoryId(0L);
        tourId1.setTourCategoryId(tourCategoryId2);
        tourDetail.setTourId(tourId1);
        when(tourServiceImplUnderTest.tourDetailRepository.getByTourId(0L)).thenReturn(tourDetail);

        // Configure TagOfTourRepository.getByTourDetailId(...).
        final TagOfTour tagOfTour = new TagOfTour();
        final Tag tagId = new Tag();
        tagId.setTagId(0L);
        tagOfTour.setTagId(tagId);
        final TourDetail tourDetailId = new TourDetail();
        tourDetailId.setTourDetailId(0L);
        tourDetailId.setTourIntroduce("tourIntroduce");
        tourDetailId.setTourInclude("tourInclude");
        tourDetailId.setTourNonInclude("tourNonInclude");
        tourDetailId.setGeneralTerms("generalTerms");
        tourDetailId.setAddressStart("addressStart");
        tourDetailId.setDescription("description");
        tourDetailId.setMoreDescription("moreDescription");
        tourDetailId.setLongitude(0.0f);
        tourDetailId.setLatitude(0.0f);
        final Tour tourId2 = new Tour();
        tourId2.setTourId(0L);
        tourId2.setTourName("tourName");
        tourId2.setTourCode("tourCode");
        tourId2.setStartPlace("startPlace");
        tourId2.setEndPlace("endPlace");
        tourId2.setStatus(0);
        tourId2.setTourType(0);
        tourId2.setTourMode(false);
        tourId2.setNumberOfDay(1);
        tourId2.setNumberOfNight(0);
        tourId2.setMinAdult(0);
        tourId2.setMaxAdult(0);
        tourId2.setMinChildren(0);
        tourId2.setMaxChildren(0);
        tourId2.setMinToStart(0);
        tourId2.setPriceAdult(0.0f);
        tourId2.setPriceChildren(0.0f);
        tourId2.setNote("note");
        tourId2.setStartDate(LocalDate.of(2020, 1, 1));
        tourId2.setStartTime(LocalTime.of(12, 0, 0));
        tourId2.setEndTime(LocalTime.of(12, 0, 0));
        tourId2.setTotalPrice(0.0f);
        tourId2.setDeposit(0.0f);
        final Account accountId4 = new Account();
        accountId4.setAccountId(0L);
        tourId2.setAccountId(accountId4);
        final TourCategory tourCategoryId3 = new TourCategory();
        tourCategoryId3.setTourCategoryId(0L);
        tourId2.setTourCategoryId(tourCategoryId3);
        tourDetailId.setTourId(tourId2);
        tagOfTour.setTourDetailId(tourDetailId);
        final List<TagOfTour> tagOfTourList = Arrays.asList(tagOfTour);
        when(tourServiceImplUnderTest.tagOfTourRepository.getByTourDetailId(0L)).thenReturn(tagOfTourList);

        // Configure TourScheduleRepository.getByTourId(...).
        final TourSchedule tourSchedule = new TourSchedule();
        tourSchedule.setTourScheduleName("tourScheduleName");
        tourSchedule.setContent("content");
        tourSchedule.setToPlace("toPlace");
        final Tour tourId3 = new Tour();
        tourId3.setTourId(0L);
        tourId3.setTourName("tourName");
        tourId3.setTourCode("tourCode");
        tourId3.setStartPlace("startPlace");
        tourId3.setEndPlace("endPlace");
        tourId3.setStatus(0);
        tourId3.setTourType(0);
        tourId3.setTourMode(false);
        tourId3.setNumberOfDay(1);
        tourId3.setNumberOfNight(0);
        tourId3.setMinAdult(0);
        tourId3.setMaxAdult(0);
        tourId3.setMinChildren(0);
        tourId3.setMaxChildren(0);
        tourId3.setMinToStart(0);
        tourId3.setPriceAdult(0.0f);
        tourId3.setPriceChildren(0.0f);
        tourId3.setNote("note");
        tourId3.setStartDate(LocalDate.of(2020, 1, 1));
        tourId3.setStartTime(LocalTime.of(12, 0, 0));
        tourId3.setEndTime(LocalTime.of(12, 0, 0));
        tourId3.setTotalPrice(0.0f);
        tourId3.setDeposit(0.0f);
        final Account accountId5 = new Account();
        accountId5.setAccountId(0L);
        tourId3.setAccountId(accountId5);
        final TourCategory tourCategoryId4 = new TourCategory();
        tourCategoryId4.setTourCategoryId(0L);
        tourId3.setTourCategoryId(tourCategoryId4);
        tourSchedule.setTourId(tourId3);
        final List<TourSchedule> tourScheduleList = Arrays.asList(tourSchedule);
        when(tourServiceImplUnderTest.tourScheduleRepository.getByTourId(0L)).thenReturn(tourScheduleList);

        // Run the test
        assertThatThrownBy(() -> tourServiceImplUnderTest.getDetailTour(0L)).isInstanceOf(HandlerException.class);
    }

    @Test
    void testCreateTour() throws Exception {
        // Setup
        final TourDTO tourDTO = new TourDTO(0L, "tourName", "tourCode", "startPlace", "endPlace", 0, 0, false,
                LocalDate.of(2020, 1, 1), LocalTime.of(12, 0, 0), LocalTime.of(12, 0, 0), 1, 0, 0, 0, 0, 0, 0, 0.0f,
                0.0f, 0.0f, 0.0f, "note", 0L,
                new TourDetailDTO("tourIntroduce", "tourInclude", "tourNonInclude", "generalTerms", "addressStart",
                        "description", "moreDescription", 0.0f, 0.0f, Arrays.asList(new TagOfTourDTO(0L))),
                Arrays.asList(new TourScheduleDTO("tourScheduleName", "content", "toPlace")), 0L,
                new UserBookingDTO(0L, 0L, 0L, "tourName", 0, 0, "fullName", "phone", "email", LocalDate.of(2020, 1, 1),
                        LocalDate.of(2020, 1, 1), "idCard", LocalDate.of(2020, 1, 1), "placeOfIssue", "request", 0.0f,
                        0.0f, 0, 0, 0.0f, 0L, "orderTitle", "payType", 0, false, 0.0f, false));

        // Configure TourCategoryRepository.getById(...).
        final TourCategory tourCategory = new TourCategory();
        tourCategory.setTourCategoryId(0L);
        tourCategory.setTourCategoryName("tourCategoryName");
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
        tourCategory.setTourList(Arrays.asList(tour));
        when(tourServiceImplUnderTest.tourCategoryRepository.getById(0L)).thenReturn(tourCategory);

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
        when(tourServiceImplUnderTest.accountRepository.getById(0L)).thenReturn(account);

        // Configure TourDetailRepository.save(...).
        final TourDetail tourDetail = new TourDetail();
        tourDetail.setTourDetailId(0L);
        tourDetail.setTourIntroduce("tourIntroduce");
        tourDetail.setTourInclude("tourInclude");
        tourDetail.setTourNonInclude("tourNonInclude");
        tourDetail.setGeneralTerms("generalTerms");
        tourDetail.setAddressStart("addressStart");
        tourDetail.setDescription("description");
        tourDetail.setMoreDescription("moreDescription");
        tourDetail.setLongitude(0.0f);
        tourDetail.setLatitude(0.0f);
        final Tour tourId = new Tour();
        tourId.setTourId(0L);
        tourId.setTourName("tourName");
        tourId.setTourCode("tourCode");
        tourId.setStartPlace("startPlace");
        tourId.setEndPlace("endPlace");
        tourId.setStatus(0);
        tourId.setTourType(0);
        tourId.setTourMode(false);
        tourId.setNumberOfDay(1);
        tourId.setNumberOfNight(0);
        tourId.setMinAdult(0);
        tourId.setMaxAdult(0);
        tourId.setMinChildren(0);
        tourId.setMaxChildren(0);
        tourId.setMinToStart(0);
        tourId.setPriceAdult(0.0f);
        tourId.setPriceChildren(0.0f);
        tourId.setNote("note");
        tourId.setStartDate(LocalDate.of(2020, 1, 1));
        tourId.setStartTime(LocalTime.of(12, 0, 0));
        tourId.setEndTime(LocalTime.of(12, 0, 0));
        tourId.setTotalPrice(0.0f);
        tourId.setDeposit(0.0f);
        final Account accountId = new Account();
        accountId.setAccountId(0L);
        tourId.setAccountId(accountId);
        final TourCategory tourCategoryId = new TourCategory();
        tourCategoryId.setTourCategoryId(0L);
        tourId.setTourCategoryId(tourCategoryId);
        tourDetail.setTourId(tourId);
        when(tourServiceImplUnderTest.tourDetailRepository.save(any(TourDetail.class))).thenReturn(tourDetail);

        // Configure TagRepository.getById(...).
        final Tag tag = new Tag();
        tag.setTagId(0L);
        tag.setTagName("tagName");
        final TagOfTour tagOfTour = new TagOfTour();
        tagOfTour.setTagOfTourId(0L);
        final TourDetail tourDetailId = new TourDetail();
        tourDetailId.setTourDetailId(0L);
        tourDetailId.setTourIntroduce("tourIntroduce");
        tourDetailId.setTourInclude("tourInclude");
        tourDetailId.setTourNonInclude("tourNonInclude");
        tourDetailId.setGeneralTerms("generalTerms");
        tourDetailId.setAddressStart("addressStart");
        tourDetailId.setDescription("description");
        tourDetailId.setMoreDescription("moreDescription");
        tourDetailId.setLongitude(0.0f);
        tourDetailId.setLatitude(0.0f);
        tagOfTour.setTourDetailId(tourDetailId);
        tag.setTagOfTourList(Arrays.asList(tagOfTour));
        when(tourServiceImplUnderTest.tagRepository.getById(0L)).thenReturn(tag);

        // Configure TagOfTourRepository.save(...).
        final TagOfTour tagOfTour1 = new TagOfTour();
        final Tag tagId = new Tag();
        tagId.setTagId(0L);
        tagOfTour1.setTagId(tagId);
        final TourDetail tourDetailId1 = new TourDetail();
        tourDetailId1.setTourDetailId(0L);
        tourDetailId1.setTourIntroduce("tourIntroduce");
        tourDetailId1.setTourInclude("tourInclude");
        tourDetailId1.setTourNonInclude("tourNonInclude");
        tourDetailId1.setGeneralTerms("generalTerms");
        tourDetailId1.setAddressStart("addressStart");
        tourDetailId1.setDescription("description");
        tourDetailId1.setMoreDescription("moreDescription");
        tourDetailId1.setLongitude(0.0f);
        tourDetailId1.setLatitude(0.0f);
        final Tour tourId1 = new Tour();
        tourId1.setTourId(0L);
        tourId1.setTourName("tourName");
        tourId1.setTourCode("tourCode");
        tourId1.setStartPlace("startPlace");
        tourId1.setEndPlace("endPlace");
        tourId1.setStatus(0);
        tourId1.setTourType(0);
        tourId1.setTourMode(false);
        tourId1.setNumberOfDay(1);
        tourId1.setNumberOfNight(0);
        tourId1.setMinAdult(0);
        tourId1.setMaxAdult(0);
        tourId1.setMinChildren(0);
        tourId1.setMaxChildren(0);
        tourId1.setMinToStart(0);
        tourId1.setPriceAdult(0.0f);
        tourId1.setPriceChildren(0.0f);
        tourId1.setNote("note");
        tourId1.setStartDate(LocalDate.of(2020, 1, 1));
        tourId1.setStartTime(LocalTime.of(12, 0, 0));
        tourId1.setEndTime(LocalTime.of(12, 0, 0));
        tourId1.setTotalPrice(0.0f);
        tourId1.setDeposit(0.0f);
        final Account accountId1 = new Account();
        accountId1.setAccountId(0L);
        tourId1.setAccountId(accountId1);
        final TourCategory tourCategoryId1 = new TourCategory();
        tourCategoryId1.setTourCategoryId(0L);
        tourId1.setTourCategoryId(tourCategoryId1);
        tourDetailId1.setTourId(tourId1);
        tagOfTour1.setTourDetailId(tourDetailId1);
        when(tourServiceImplUnderTest.tagOfTourRepository.save(any(TagOfTour.class))).thenReturn(tagOfTour1);

        // Configure TourScheduleRepository.save(...).
        final TourSchedule tourSchedule = new TourSchedule();
        tourSchedule.setTourScheduleName("tourScheduleName");
        tourSchedule.setContent("content");
        tourSchedule.setToPlace("toPlace");
        final Tour tourId2 = new Tour();
        tourId2.setTourId(0L);
        tourId2.setTourName("tourName");
        tourId2.setTourCode("tourCode");
        tourId2.setStartPlace("startPlace");
        tourId2.setEndPlace("endPlace");
        tourId2.setStatus(0);
        tourId2.setTourType(0);
        tourId2.setTourMode(false);
        tourId2.setNumberOfDay(1);
        tourId2.setNumberOfNight(0);
        tourId2.setMinAdult(0);
        tourId2.setMaxAdult(0);
        tourId2.setMinChildren(0);
        tourId2.setMaxChildren(0);
        tourId2.setMinToStart(0);
        tourId2.setPriceAdult(0.0f);
        tourId2.setPriceChildren(0.0f);
        tourId2.setNote("note");
        tourId2.setStartDate(LocalDate.of(2020, 1, 1));
        tourId2.setStartTime(LocalTime.of(12, 0, 0));
        tourId2.setEndTime(LocalTime.of(12, 0, 0));
        tourId2.setTotalPrice(0.0f);
        tourId2.setDeposit(0.0f);
        final Account accountId2 = new Account();
        accountId2.setAccountId(0L);
        tourId2.setAccountId(accountId2);
        final TourCategory tourCategoryId2 = new TourCategory();
        tourCategoryId2.setTourCategoryId(0L);
        tourId2.setTourCategoryId(tourCategoryId2);
        tourSchedule.setTourId(tourId2);
        when(tourServiceImplUnderTest.tourScheduleRepository.save(any(TourSchedule.class))).thenReturn(tourSchedule);

        // Run the test
        final TourDTO result = tourServiceImplUnderTest.createTour(tourDTO);

        // Verify the results
        verify(tourServiceImplUnderTest.tourDetailRepository).save(any(TourDetail.class));
        verify(tourServiceImplUnderTest.tagOfTourRepository).save(any(TagOfTour.class));
        verify(tourServiceImplUnderTest.tourScheduleRepository).save(any(TourSchedule.class));
    }

    @Test
    void testCreateTour_ThrowsHandlerException() {
        // Setup
        final TourDTO tourDTO = new TourDTO(0L, "tourName", "tourCode", "startPlace", "endPlace", 0, 0, false,
                LocalDate.of(2020, 1, 1), LocalTime.of(12, 0, 0), LocalTime.of(12, 0, 0), 1, 0, 0, 0, 0, 0, 0, 0.0f,
                0.0f, 0.0f, 0.0f, "note", 0L,
                new TourDetailDTO("tourIntroduce", "tourInclude", "tourNonInclude", "generalTerms", "addressStart",
                        "description", "moreDescription", 0.0f, 0.0f, Arrays.asList(new TagOfTourDTO(0L))),
                Arrays.asList(new TourScheduleDTO("tourScheduleName", "content", "toPlace")), 0L,
                new UserBookingDTO(0L, 0L, 0L, "tourName", 0, 0, "fullName", "phone", "email", LocalDate.of(2020, 1, 1),
                        LocalDate.of(2020, 1, 1), "idCard", LocalDate.of(2020, 1, 1), "placeOfIssue", "request", 0.0f,
                        0.0f, 0, 0, 0.0f, 0L, "orderTitle", "payType", 0, false, 0.0f, false));

        // Configure TourCategoryRepository.getById(...).
        final TourCategory tourCategory = new TourCategory();
        tourCategory.setTourCategoryId(0L);
        tourCategory.setTourCategoryName("tourCategoryName");
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
        tourCategory.setTourList(Arrays.asList(tour));
        when(tourServiceImplUnderTest.tourCategoryRepository.getById(0L)).thenReturn(tourCategory);

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
        when(tourServiceImplUnderTest.accountRepository.getById(0L)).thenReturn(account);

        // Configure TourDetailRepository.save(...).
        final TourDetail tourDetail = new TourDetail();
        tourDetail.setTourDetailId(0L);
        tourDetail.setTourIntroduce("tourIntroduce");
        tourDetail.setTourInclude("tourInclude");
        tourDetail.setTourNonInclude("tourNonInclude");
        tourDetail.setGeneralTerms("generalTerms");
        tourDetail.setAddressStart("addressStart");
        tourDetail.setDescription("description");
        tourDetail.setMoreDescription("moreDescription");
        tourDetail.setLongitude(0.0f);
        tourDetail.setLatitude(0.0f);
        final Tour tourId = new Tour();
        tourId.setTourId(0L);
        tourId.setTourName("tourName");
        tourId.setTourCode("tourCode");
        tourId.setStartPlace("startPlace");
        tourId.setEndPlace("endPlace");
        tourId.setStatus(0);
        tourId.setTourType(0);
        tourId.setTourMode(false);
        tourId.setNumberOfDay(1);
        tourId.setNumberOfNight(0);
        tourId.setMinAdult(0);
        tourId.setMaxAdult(0);
        tourId.setMinChildren(0);
        tourId.setMaxChildren(0);
        tourId.setMinToStart(0);
        tourId.setPriceAdult(0.0f);
        tourId.setPriceChildren(0.0f);
        tourId.setNote("note");
        tourId.setStartDate(LocalDate.of(2020, 1, 1));
        tourId.setStartTime(LocalTime.of(12, 0, 0));
        tourId.setEndTime(LocalTime.of(12, 0, 0));
        tourId.setTotalPrice(0.0f);
        tourId.setDeposit(0.0f);
        final Account accountId = new Account();
        accountId.setAccountId(0L);
        tourId.setAccountId(accountId);
        final TourCategory tourCategoryId = new TourCategory();
        tourCategoryId.setTourCategoryId(0L);
        tourId.setTourCategoryId(tourCategoryId);
        tourDetail.setTourId(tourId);
        when(tourServiceImplUnderTest.tourDetailRepository.save(any(TourDetail.class))).thenReturn(tourDetail);

        // Configure TagRepository.getById(...).
        final Tag tag = new Tag();
        tag.setTagId(0L);
        tag.setTagName("tagName");
        final TagOfTour tagOfTour = new TagOfTour();
        tagOfTour.setTagOfTourId(0L);
        final TourDetail tourDetailId = new TourDetail();
        tourDetailId.setTourDetailId(0L);
        tourDetailId.setTourIntroduce("tourIntroduce");
        tourDetailId.setTourInclude("tourInclude");
        tourDetailId.setTourNonInclude("tourNonInclude");
        tourDetailId.setGeneralTerms("generalTerms");
        tourDetailId.setAddressStart("addressStart");
        tourDetailId.setDescription("description");
        tourDetailId.setMoreDescription("moreDescription");
        tourDetailId.setLongitude(0.0f);
        tourDetailId.setLatitude(0.0f);
        tagOfTour.setTourDetailId(tourDetailId);
        tag.setTagOfTourList(Arrays.asList(tagOfTour));
        when(tourServiceImplUnderTest.tagRepository.getById(0L)).thenReturn(tag);

        // Configure TagOfTourRepository.save(...).
        final TagOfTour tagOfTour1 = new TagOfTour();
        final Tag tagId = new Tag();
        tagId.setTagId(0L);
        tagOfTour1.setTagId(tagId);
        final TourDetail tourDetailId1 = new TourDetail();
        tourDetailId1.setTourDetailId(0L);
        tourDetailId1.setTourIntroduce("tourIntroduce");
        tourDetailId1.setTourInclude("tourInclude");
        tourDetailId1.setTourNonInclude("tourNonInclude");
        tourDetailId1.setGeneralTerms("generalTerms");
        tourDetailId1.setAddressStart("addressStart");
        tourDetailId1.setDescription("description");
        tourDetailId1.setMoreDescription("moreDescription");
        tourDetailId1.setLongitude(0.0f);
        tourDetailId1.setLatitude(0.0f);
        final Tour tourId1 = new Tour();
        tourId1.setTourId(0L);
        tourId1.setTourName("tourName");
        tourId1.setTourCode("tourCode");
        tourId1.setStartPlace("startPlace");
        tourId1.setEndPlace("endPlace");
        tourId1.setStatus(0);
        tourId1.setTourType(0);
        tourId1.setTourMode(false);
        tourId1.setNumberOfDay(1);
        tourId1.setNumberOfNight(0);
        tourId1.setMinAdult(0);
        tourId1.setMaxAdult(0);
        tourId1.setMinChildren(0);
        tourId1.setMaxChildren(0);
        tourId1.setMinToStart(0);
        tourId1.setPriceAdult(0.0f);
        tourId1.setPriceChildren(0.0f);
        tourId1.setNote("note");
        tourId1.setStartDate(LocalDate.of(2020, 1, 1));
        tourId1.setStartTime(LocalTime.of(12, 0, 0));
        tourId1.setEndTime(LocalTime.of(12, 0, 0));
        tourId1.setTotalPrice(0.0f);
        tourId1.setDeposit(0.0f);
        final Account accountId1 = new Account();
        accountId1.setAccountId(0L);
        tourId1.setAccountId(accountId1);
        final TourCategory tourCategoryId1 = new TourCategory();
        tourCategoryId1.setTourCategoryId(0L);
        tourId1.setTourCategoryId(tourCategoryId1);
        tourDetailId1.setTourId(tourId1);
        tagOfTour1.setTourDetailId(tourDetailId1);
        when(tourServiceImplUnderTest.tagOfTourRepository.save(any(TagOfTour.class))).thenReturn(tagOfTour1);

        // Configure TourScheduleRepository.save(...).
        final TourSchedule tourSchedule = new TourSchedule();
        tourSchedule.setTourScheduleName("tourScheduleName");
        tourSchedule.setContent("content");
        tourSchedule.setToPlace("toPlace");
        final Tour tourId2 = new Tour();
        tourId2.setTourId(0L);
        tourId2.setTourName("tourName");
        tourId2.setTourCode("tourCode");
        tourId2.setStartPlace("startPlace");
        tourId2.setEndPlace("endPlace");
        tourId2.setStatus(0);
        tourId2.setTourType(0);
        tourId2.setTourMode(false);
        tourId2.setNumberOfDay(1);
        tourId2.setNumberOfNight(0);
        tourId2.setMinAdult(0);
        tourId2.setMaxAdult(0);
        tourId2.setMinChildren(0);
        tourId2.setMaxChildren(0);
        tourId2.setMinToStart(0);
        tourId2.setPriceAdult(0.0f);
        tourId2.setPriceChildren(0.0f);
        tourId2.setNote("note");
        tourId2.setStartDate(LocalDate.of(2020, 1, 1));
        tourId2.setStartTime(LocalTime.of(12, 0, 0));
        tourId2.setEndTime(LocalTime.of(12, 0, 0));
        tourId2.setTotalPrice(0.0f);
        tourId2.setDeposit(0.0f);
        final Account accountId2 = new Account();
        accountId2.setAccountId(0L);
        tourId2.setAccountId(accountId2);
        final TourCategory tourCategoryId2 = new TourCategory();
        tourCategoryId2.setTourCategoryId(0L);
        tourId2.setTourCategoryId(tourCategoryId2);
        tourSchedule.setTourId(tourId2);
        when(tourServiceImplUnderTest.tourScheduleRepository.save(any(TourSchedule.class))).thenReturn(tourSchedule);

        // Run the test
        assertThatThrownBy(() -> tourServiceImplUnderTest.createTour(tourDTO)).isInstanceOf(HandlerException.class);
        verify(tourServiceImplUnderTest.tourDetailRepository).save(any(TourDetail.class));
        verify(tourServiceImplUnderTest.tagOfTourRepository).save(any(TagOfTour.class));
        verify(tourServiceImplUnderTest.tourScheduleRepository).save(any(TourSchedule.class));
    }

    @Test
    void testUpdateTour() throws Exception {
        // Setup
        final TourDTO tourDTO = new TourDTO(0L, "tourName", "tourCode", "startPlace", "endPlace", 0, 0, false,
                LocalDate.of(2020, 1, 1), LocalTime.of(12, 0, 0), LocalTime.of(12, 0, 0), 1, 0, 0, 0, 0, 0, 0, 0.0f,
                0.0f, 0.0f, 0.0f, "note", 0L,
                new TourDetailDTO("tourIntroduce", "tourInclude", "tourNonInclude", "generalTerms", "addressStart",
                        "description", "moreDescription", 0.0f, 0.0f, Arrays.asList(new TagOfTourDTO(0L))),
                Arrays.asList(new TourScheduleDTO("tourScheduleName", "content", "toPlace")), 0L,
                new UserBookingDTO(0L, 0L, 0L, "tourName", 0, 0, "fullName", "phone", "email", LocalDate.of(2020, 1, 1),
                        LocalDate.of(2020, 1, 1), "idCard", LocalDate.of(2020, 1, 1), "placeOfIssue", "request", 0.0f,
                        0.0f, 0, 0, 0.0f, 0L, "orderTitle", "payType", 0, false, 0.0f, false));

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
        tour.setPriceAdult(0.0f);
        tour.setPriceChildren(0.0f);
        tour.setNote("note");
        tour.setStartDate(LocalDate.of(2020, 1, 1));
        tour.setStartTime(LocalTime.of(12, 0, 0));
        tour.setEndTime(LocalTime.of(12, 0, 0));
        tour.setTotalPrice(0.0f);
        tour.setDeposit(0.0f);
        final Account accountId = new Account();
        accountId.setAccountId(0L);
        tour.setAccountId(accountId);
        final TourCategory tourCategoryId = new TourCategory();
        tourCategoryId.setTourCategoryId(0L);
        tour.setTourCategoryId(tourCategoryId);
        when(tourServiceImplUnderTest.tourRepository.getById(0L)).thenReturn(tour);

        when(tourServiceImplUnderTest.tourRepository.existsById(0L)).thenReturn(false);

        // Configure TourCategoryRepository.getById(...).
        final TourCategory tourCategory = new TourCategory();
        tourCategory.setTourCategoryId(0L);
        tourCategory.setTourCategoryName("tourCategoryName");
        final Tour tour1 = new Tour();
        tour1.setTourId(0L);
        tour1.setTourName("tourName");
        tour1.setTourCode("tourCode");
        tour1.setStartPlace("startPlace");
        tour1.setEndPlace("endPlace");
        tour1.setStatus(0);
        tour1.setTourType(0);
        tour1.setTourMode(false);
        tour1.setNumberOfDay(1);
        tour1.setNumberOfNight(0);
        tour1.setMinAdult(0);
        tour1.setMaxAdult(0);
        tourCategory.setTourList(Arrays.asList(tour1));
        when(tourServiceImplUnderTest.tourCategoryRepository.getById(0L)).thenReturn(tourCategory);

        // Configure TourRepository.save(...).
        final Tour tour2 = new Tour();
        tour2.setTourId(0L);
        tour2.setTourName("tourName");
        tour2.setTourCode("tourCode");
        tour2.setStartPlace("startPlace");
        tour2.setEndPlace("endPlace");
        tour2.setStatus(0);
        tour2.setTourType(0);
        tour2.setTourMode(false);
        tour2.setNumberOfDay(1);
        tour2.setNumberOfNight(0);
        tour2.setMinAdult(0);
        tour2.setMaxAdult(0);
        tour2.setMinChildren(0);
        tour2.setMaxChildren(0);
        tour2.setMinToStart(0);
        tour2.setPriceAdult(0.0f);
        tour2.setPriceChildren(0.0f);
        tour2.setNote("note");
        tour2.setStartDate(LocalDate.of(2020, 1, 1));
        tour2.setStartTime(LocalTime.of(12, 0, 0));
        tour2.setEndTime(LocalTime.of(12, 0, 0));
        tour2.setTotalPrice(0.0f);
        tour2.setDeposit(0.0f);
        final Account accountId1 = new Account();
        accountId1.setAccountId(0L);
        tour2.setAccountId(accountId1);
        final TourCategory tourCategoryId1 = new TourCategory();
        tourCategoryId1.setTourCategoryId(0L);
        tour2.setTourCategoryId(tourCategoryId1);
        when(tourServiceImplUnderTest.tourRepository.save(any(Tour.class))).thenReturn(tour2);

        // Configure TourDetailRepository.getByTourId(...).
        final TourDetail tourDetail = new TourDetail();
        tourDetail.setTourDetailId(0L);
        tourDetail.setTourIntroduce("tourIntroduce");
        tourDetail.setTourInclude("tourInclude");
        tourDetail.setTourNonInclude("tourNonInclude");
        tourDetail.setGeneralTerms("generalTerms");
        tourDetail.setAddressStart("addressStart");
        tourDetail.setDescription("description");
        tourDetail.setMoreDescription("moreDescription");
        tourDetail.setLongitude(0.0f);
        tourDetail.setLatitude(0.0f);
        final Tour tourId = new Tour();
        tourId.setTourId(0L);
        tourId.setTourName("tourName");
        tourId.setTourCode("tourCode");
        tourId.setStartPlace("startPlace");
        tourId.setEndPlace("endPlace");
        tourId.setStatus(0);
        tourId.setTourType(0);
        tourId.setTourMode(false);
        tourId.setNumberOfDay(1);
        tourId.setNumberOfNight(0);
        tourId.setMinAdult(0);
        tourId.setMaxAdult(0);
        tourId.setMinChildren(0);
        tourId.setMaxChildren(0);
        tourId.setMinToStart(0);
        tourId.setPriceAdult(0.0f);
        tourId.setPriceChildren(0.0f);
        tourId.setNote("note");
        tourId.setStartDate(LocalDate.of(2020, 1, 1));
        tourId.setStartTime(LocalTime.of(12, 0, 0));
        tourId.setEndTime(LocalTime.of(12, 0, 0));
        tourId.setTotalPrice(0.0f);
        tourId.setDeposit(0.0f);
        final Account accountId2 = new Account();
        accountId2.setAccountId(0L);
        tourId.setAccountId(accountId2);
        final TourCategory tourCategoryId2 = new TourCategory();
        tourCategoryId2.setTourCategoryId(0L);
        tourId.setTourCategoryId(tourCategoryId2);
        tourDetail.setTourId(tourId);
        when(tourServiceImplUnderTest.tourDetailRepository.getByTourId(0L)).thenReturn(tourDetail);

        // Configure TourDetailRepository.save(...).
        final TourDetail tourDetail1 = new TourDetail();
        tourDetail1.setTourDetailId(0L);
        tourDetail1.setTourIntroduce("tourIntroduce");
        tourDetail1.setTourInclude("tourInclude");
        tourDetail1.setTourNonInclude("tourNonInclude");
        tourDetail1.setGeneralTerms("generalTerms");
        tourDetail1.setAddressStart("addressStart");
        tourDetail1.setDescription("description");
        tourDetail1.setMoreDescription("moreDescription");
        tourDetail1.setLongitude(0.0f);
        tourDetail1.setLatitude(0.0f);
        final Tour tourId1 = new Tour();
        tourId1.setTourId(0L);
        tourId1.setTourName("tourName");
        tourId1.setTourCode("tourCode");
        tourId1.setStartPlace("startPlace");
        tourId1.setEndPlace("endPlace");
        tourId1.setStatus(0);
        tourId1.setTourType(0);
        tourId1.setTourMode(false);
        tourId1.setNumberOfDay(1);
        tourId1.setNumberOfNight(0);
        tourId1.setMinAdult(0);
        tourId1.setMaxAdult(0);
        tourId1.setMinChildren(0);
        tourId1.setMaxChildren(0);
        tourId1.setMinToStart(0);
        tourId1.setPriceAdult(0.0f);
        tourId1.setPriceChildren(0.0f);
        tourId1.setNote("note");
        tourId1.setStartDate(LocalDate.of(2020, 1, 1));
        tourId1.setStartTime(LocalTime.of(12, 0, 0));
        tourId1.setEndTime(LocalTime.of(12, 0, 0));
        tourId1.setTotalPrice(0.0f);
        tourId1.setDeposit(0.0f);
        final Account accountId3 = new Account();
        accountId3.setAccountId(0L);
        tourId1.setAccountId(accountId3);
        final TourCategory tourCategoryId3 = new TourCategory();
        tourCategoryId3.setTourCategoryId(0L);
        tourId1.setTourCategoryId(tourCategoryId3);
        tourDetail1.setTourId(tourId1);
        when(tourServiceImplUnderTest.tourDetailRepository.save(any(TourDetail.class))).thenReturn(tourDetail1);

        // Configure TagOfTourRepository.getByTourDetailId(...).
        final TagOfTour tagOfTour = new TagOfTour();
        final Tag tagId = new Tag();
        tagId.setTagId(0L);
        tagOfTour.setTagId(tagId);
        final TourDetail tourDetailId = new TourDetail();
        tourDetailId.setTourDetailId(0L);
        tourDetailId.setTourIntroduce("tourIntroduce");
        tourDetailId.setTourInclude("tourInclude");
        tourDetailId.setTourNonInclude("tourNonInclude");
        tourDetailId.setGeneralTerms("generalTerms");
        tourDetailId.setAddressStart("addressStart");
        tourDetailId.setDescription("description");
        tourDetailId.setMoreDescription("moreDescription");
        tourDetailId.setLongitude(0.0f);
        tourDetailId.setLatitude(0.0f);
        final Tour tourId2 = new Tour();
        tourId2.setTourId(0L);
        tourId2.setTourName("tourName");
        tourId2.setTourCode("tourCode");
        tourId2.setStartPlace("startPlace");
        tourId2.setEndPlace("endPlace");
        tourId2.setStatus(0);
        tourId2.setTourType(0);
        tourId2.setTourMode(false);
        tourId2.setNumberOfDay(1);
        tourId2.setNumberOfNight(0);
        tourId2.setMinAdult(0);
        tourId2.setMaxAdult(0);
        tourId2.setMinChildren(0);
        tourId2.setMaxChildren(0);
        tourId2.setMinToStart(0);
        tourId2.setPriceAdult(0.0f);
        tourId2.setPriceChildren(0.0f);
        tourId2.setNote("note");
        tourId2.setStartDate(LocalDate.of(2020, 1, 1));
        tourId2.setStartTime(LocalTime.of(12, 0, 0));
        tourId2.setEndTime(LocalTime.of(12, 0, 0));
        tourId2.setTotalPrice(0.0f);
        tourId2.setDeposit(0.0f);
        final Account accountId4 = new Account();
        accountId4.setAccountId(0L);
        tourId2.setAccountId(accountId4);
        final TourCategory tourCategoryId4 = new TourCategory();
        tourCategoryId4.setTourCategoryId(0L);
        tourId2.setTourCategoryId(tourCategoryId4);
        tourDetailId.setTourId(tourId2);
        tagOfTour.setTourDetailId(tourDetailId);
        final List<TagOfTour> tagOfTourList = Arrays.asList(tagOfTour);
        when(tourServiceImplUnderTest.tagOfTourRepository.getByTourDetailId(0L)).thenReturn(tagOfTourList);

        // Configure TagRepository.getById(...).
        final Tag tag = new Tag();
        tag.setTagId(0L);
        tag.setTagName("tagName");
        final TagOfTour tagOfTour1 = new TagOfTour();
        tagOfTour1.setTagOfTourId(0L);
        final TourDetail tourDetailId1 = new TourDetail();
        tourDetailId1.setTourDetailId(0L);
        tourDetailId1.setTourIntroduce("tourIntroduce");
        tourDetailId1.setTourInclude("tourInclude");
        tourDetailId1.setTourNonInclude("tourNonInclude");
        tourDetailId1.setGeneralTerms("generalTerms");
        tourDetailId1.setAddressStart("addressStart");
        tourDetailId1.setDescription("description");
        tourDetailId1.setMoreDescription("moreDescription");
        tourDetailId1.setLongitude(0.0f);
        tourDetailId1.setLatitude(0.0f);
        tagOfTour1.setTourDetailId(tourDetailId1);
        tag.setTagOfTourList(Arrays.asList(tagOfTour1));
        when(tourServiceImplUnderTest.tagRepository.getById(0L)).thenReturn(tag);

        // Configure TagOfTourRepository.save(...).
        final TagOfTour tagOfTour2 = new TagOfTour();
        final Tag tagId1 = new Tag();
        tagId1.setTagId(0L);
        tagOfTour2.setTagId(tagId1);
        final TourDetail tourDetailId2 = new TourDetail();
        tourDetailId2.setTourDetailId(0L);
        tourDetailId2.setTourIntroduce("tourIntroduce");
        tourDetailId2.setTourInclude("tourInclude");
        tourDetailId2.setTourNonInclude("tourNonInclude");
        tourDetailId2.setGeneralTerms("generalTerms");
        tourDetailId2.setAddressStart("addressStart");
        tourDetailId2.setDescription("description");
        tourDetailId2.setMoreDescription("moreDescription");
        tourDetailId2.setLongitude(0.0f);
        tourDetailId2.setLatitude(0.0f);
        final Tour tourId3 = new Tour();
        tourId3.setTourId(0L);
        tourId3.setTourName("tourName");
        tourId3.setTourCode("tourCode");
        tourId3.setStartPlace("startPlace");
        tourId3.setEndPlace("endPlace");
        tourId3.setStatus(0);
        tourId3.setTourType(0);
        tourId3.setTourMode(false);
        tourId3.setNumberOfDay(1);
        tourId3.setNumberOfNight(0);
        tourId3.setMinAdult(0);
        tourId3.setMaxAdult(0);
        tourId3.setMinChildren(0);
        tourId3.setMaxChildren(0);
        tourId3.setMinToStart(0);
        tourId3.setPriceAdult(0.0f);
        tourId3.setPriceChildren(0.0f);
        tourId3.setNote("note");
        tourId3.setStartDate(LocalDate.of(2020, 1, 1));
        tourId3.setStartTime(LocalTime.of(12, 0, 0));
        tourId3.setEndTime(LocalTime.of(12, 0, 0));
        tourId3.setTotalPrice(0.0f);
        tourId3.setDeposit(0.0f);
        final Account accountId5 = new Account();
        accountId5.setAccountId(0L);
        tourId3.setAccountId(accountId5);
        final TourCategory tourCategoryId5 = new TourCategory();
        tourCategoryId5.setTourCategoryId(0L);
        tourId3.setTourCategoryId(tourCategoryId5);
        tourDetailId2.setTourId(tourId3);
        tagOfTour2.setTourDetailId(tourDetailId2);
        when(tourServiceImplUnderTest.tagOfTourRepository.save(any(TagOfTour.class))).thenReturn(tagOfTour2);

        // Configure TourScheduleRepository.getByTourId(...).
        final TourSchedule tourSchedule = new TourSchedule();
        tourSchedule.setTourScheduleName("tourScheduleName");
        tourSchedule.setContent("content");
        tourSchedule.setToPlace("toPlace");
        final Tour tourId4 = new Tour();
        tourId4.setTourId(0L);
        tourId4.setTourName("tourName");
        tourId4.setTourCode("tourCode");
        tourId4.setStartPlace("startPlace");
        tourId4.setEndPlace("endPlace");
        tourId4.setStatus(0);
        tourId4.setTourType(0);
        tourId4.setTourMode(false);
        tourId4.setNumberOfDay(1);
        tourId4.setNumberOfNight(0);
        tourId4.setMinAdult(0);
        tourId4.setMaxAdult(0);
        tourId4.setMinChildren(0);
        tourId4.setMaxChildren(0);
        tourId4.setMinToStart(0);
        tourId4.setPriceAdult(0.0f);
        tourId4.setPriceChildren(0.0f);
        tourId4.setNote("note");
        tourId4.setStartDate(LocalDate.of(2020, 1, 1));
        tourId4.setStartTime(LocalTime.of(12, 0, 0));
        tourId4.setEndTime(LocalTime.of(12, 0, 0));
        tourId4.setTotalPrice(0.0f);
        tourId4.setDeposit(0.0f);
        final Account accountId6 = new Account();
        accountId6.setAccountId(0L);
        tourId4.setAccountId(accountId6);
        final TourCategory tourCategoryId6 = new TourCategory();
        tourCategoryId6.setTourCategoryId(0L);
        tourId4.setTourCategoryId(tourCategoryId6);
        tourSchedule.setTourId(tourId4);
        final List<TourSchedule> tourScheduleList = Arrays.asList(tourSchedule);
        when(tourServiceImplUnderTest.tourScheduleRepository.getByTourId(0L)).thenReturn(tourScheduleList);

        // Configure TourScheduleRepository.save(...).
        final TourSchedule tourSchedule1 = new TourSchedule();
        tourSchedule1.setTourScheduleName("tourScheduleName");
        tourSchedule1.setContent("content");
        tourSchedule1.setToPlace("toPlace");
        final Tour tourId5 = new Tour();
        tourId5.setTourId(0L);
        tourId5.setTourName("tourName");
        tourId5.setTourCode("tourCode");
        tourId5.setStartPlace("startPlace");
        tourId5.setEndPlace("endPlace");
        tourId5.setStatus(0);
        tourId5.setTourType(0);
        tourId5.setTourMode(false);
        tourId5.setNumberOfDay(1);
        tourId5.setNumberOfNight(0);
        tourId5.setMinAdult(0);
        tourId5.setMaxAdult(0);
        tourId5.setMinChildren(0);
        tourId5.setMaxChildren(0);
        tourId5.setMinToStart(0);
        tourId5.setPriceAdult(0.0f);
        tourId5.setPriceChildren(0.0f);
        tourId5.setNote("note");
        tourId5.setStartDate(LocalDate.of(2020, 1, 1));
        tourId5.setStartTime(LocalTime.of(12, 0, 0));
        tourId5.setEndTime(LocalTime.of(12, 0, 0));
        tourId5.setTotalPrice(0.0f);
        tourId5.setDeposit(0.0f);
        final Account accountId7 = new Account();
        accountId7.setAccountId(0L);
        tourId5.setAccountId(accountId7);
        final TourCategory tourCategoryId7 = new TourCategory();
        tourCategoryId7.setTourCategoryId(0L);
        tourId5.setTourCategoryId(tourCategoryId7);
        tourSchedule1.setTourId(tourId5);
        when(tourServiceImplUnderTest.tourScheduleRepository.save(any(TourSchedule.class))).thenReturn(tourSchedule1);

        // Run the test
        final TourDTO result = tourServiceImplUnderTest.updateTour(tourDTO, 0L);

        // Verify the results
        verify(tourServiceImplUnderTest.tourRepository).save(any(Tour.class));
        verify(tourServiceImplUnderTest.tourDetailRepository).save(any(TourDetail.class));
        verify(tourServiceImplUnderTest.tagOfTourRepository).deleteAll(Arrays.asList(new TagOfTour()));
        verify(tourServiceImplUnderTest.tagOfTourRepository).save(any(TagOfTour.class));
        verify(tourServiceImplUnderTest.tourScheduleRepository).deleteAll(Arrays.asList(new TourSchedule()));
        verify(tourServiceImplUnderTest.tourScheduleRepository).save(any(TourSchedule.class));
    }

    @Test
    void testUpdateTour_TagOfTourRepositoryGetByTourDetailIdReturnsNoItems() throws Exception {
        // Setup
        final TourDTO tourDTO = new TourDTO(0L, "tourName", "tourCode", "startPlace", "endPlace", 0, 0, false,
                LocalDate.of(2020, 1, 1), LocalTime.of(12, 0, 0), LocalTime.of(12, 0, 0), 1, 0, 0, 0, 0, 0, 0, 0.0f,
                0.0f, 0.0f, 0.0f, "note", 0L,
                new TourDetailDTO("tourIntroduce", "tourInclude", "tourNonInclude", "generalTerms", "addressStart",
                        "description", "moreDescription", 0.0f, 0.0f, Arrays.asList(new TagOfTourDTO(0L))),
                Arrays.asList(new TourScheduleDTO("tourScheduleName", "content", "toPlace")), 0L,
                new UserBookingDTO(0L, 0L, 0L, "tourName", 0, 0, "fullName", "phone", "email", LocalDate.of(2020, 1, 1),
                        LocalDate.of(2020, 1, 1), "idCard", LocalDate.of(2020, 1, 1), "placeOfIssue", "request", 0.0f,
                        0.0f, 0, 0, 0.0f, 0L, "orderTitle", "payType", 0, false, 0.0f, false));

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
        tour.setPriceAdult(0.0f);
        tour.setPriceChildren(0.0f);
        tour.setNote("note");
        tour.setStartDate(LocalDate.of(2020, 1, 1));
        tour.setStartTime(LocalTime.of(12, 0, 0));
        tour.setEndTime(LocalTime.of(12, 0, 0));
        tour.setTotalPrice(0.0f);
        tour.setDeposit(0.0f);
        final Account accountId = new Account();
        accountId.setAccountId(0L);
        tour.setAccountId(accountId);
        final TourCategory tourCategoryId = new TourCategory();
        tourCategoryId.setTourCategoryId(0L);
        tour.setTourCategoryId(tourCategoryId);
        when(tourServiceImplUnderTest.tourRepository.getById(0L)).thenReturn(tour);

        when(tourServiceImplUnderTest.tourRepository.existsById(0L)).thenReturn(false);

        // Configure TourCategoryRepository.getById(...).
        final TourCategory tourCategory = new TourCategory();
        tourCategory.setTourCategoryId(0L);
        tourCategory.setTourCategoryName("tourCategoryName");
        final Tour tour1 = new Tour();
        tour1.setTourId(0L);
        tour1.setTourName("tourName");
        tour1.setTourCode("tourCode");
        tour1.setStartPlace("startPlace");
        tour1.setEndPlace("endPlace");
        tour1.setStatus(0);
        tour1.setTourType(0);
        tour1.setTourMode(false);
        tour1.setNumberOfDay(1);
        tour1.setNumberOfNight(0);
        tour1.setMinAdult(0);
        tour1.setMaxAdult(0);
        tourCategory.setTourList(Arrays.asList(tour1));
        when(tourServiceImplUnderTest.tourCategoryRepository.getById(0L)).thenReturn(tourCategory);

        // Configure TourRepository.save(...).
        final Tour tour2 = new Tour();
        tour2.setTourId(0L);
        tour2.setTourName("tourName");
        tour2.setTourCode("tourCode");
        tour2.setStartPlace("startPlace");
        tour2.setEndPlace("endPlace");
        tour2.setStatus(0);
        tour2.setTourType(0);
        tour2.setTourMode(false);
        tour2.setNumberOfDay(1);
        tour2.setNumberOfNight(0);
        tour2.setMinAdult(0);
        tour2.setMaxAdult(0);
        tour2.setMinChildren(0);
        tour2.setMaxChildren(0);
        tour2.setMinToStart(0);
        tour2.setPriceAdult(0.0f);
        tour2.setPriceChildren(0.0f);
        tour2.setNote("note");
        tour2.setStartDate(LocalDate.of(2020, 1, 1));
        tour2.setStartTime(LocalTime.of(12, 0, 0));
        tour2.setEndTime(LocalTime.of(12, 0, 0));
        tour2.setTotalPrice(0.0f);
        tour2.setDeposit(0.0f);
        final Account accountId1 = new Account();
        accountId1.setAccountId(0L);
        tour2.setAccountId(accountId1);
        final TourCategory tourCategoryId1 = new TourCategory();
        tourCategoryId1.setTourCategoryId(0L);
        tour2.setTourCategoryId(tourCategoryId1);
        when(tourServiceImplUnderTest.tourRepository.save(any(Tour.class))).thenReturn(tour2);

        // Configure TourDetailRepository.getByTourId(...).
        final TourDetail tourDetail = new TourDetail();
        tourDetail.setTourDetailId(0L);
        tourDetail.setTourIntroduce("tourIntroduce");
        tourDetail.setTourInclude("tourInclude");
        tourDetail.setTourNonInclude("tourNonInclude");
        tourDetail.setGeneralTerms("generalTerms");
        tourDetail.setAddressStart("addressStart");
        tourDetail.setDescription("description");
        tourDetail.setMoreDescription("moreDescription");
        tourDetail.setLongitude(0.0f);
        tourDetail.setLatitude(0.0f);
        final Tour tourId = new Tour();
        tourId.setTourId(0L);
        tourId.setTourName("tourName");
        tourId.setTourCode("tourCode");
        tourId.setStartPlace("startPlace");
        tourId.setEndPlace("endPlace");
        tourId.setStatus(0);
        tourId.setTourType(0);
        tourId.setTourMode(false);
        tourId.setNumberOfDay(1);
        tourId.setNumberOfNight(0);
        tourId.setMinAdult(0);
        tourId.setMaxAdult(0);
        tourId.setMinChildren(0);
        tourId.setMaxChildren(0);
        tourId.setMinToStart(0);
        tourId.setPriceAdult(0.0f);
        tourId.setPriceChildren(0.0f);
        tourId.setNote("note");
        tourId.setStartDate(LocalDate.of(2020, 1, 1));
        tourId.setStartTime(LocalTime.of(12, 0, 0));
        tourId.setEndTime(LocalTime.of(12, 0, 0));
        tourId.setTotalPrice(0.0f);
        tourId.setDeposit(0.0f);
        final Account accountId2 = new Account();
        accountId2.setAccountId(0L);
        tourId.setAccountId(accountId2);
        final TourCategory tourCategoryId2 = new TourCategory();
        tourCategoryId2.setTourCategoryId(0L);
        tourId.setTourCategoryId(tourCategoryId2);
        tourDetail.setTourId(tourId);
        when(tourServiceImplUnderTest.tourDetailRepository.getByTourId(0L)).thenReturn(tourDetail);

        // Configure TourDetailRepository.save(...).
        final TourDetail tourDetail1 = new TourDetail();
        tourDetail1.setTourDetailId(0L);
        tourDetail1.setTourIntroduce("tourIntroduce");
        tourDetail1.setTourInclude("tourInclude");
        tourDetail1.setTourNonInclude("tourNonInclude");
        tourDetail1.setGeneralTerms("generalTerms");
        tourDetail1.setAddressStart("addressStart");
        tourDetail1.setDescription("description");
        tourDetail1.setMoreDescription("moreDescription");
        tourDetail1.setLongitude(0.0f);
        tourDetail1.setLatitude(0.0f);
        final Tour tourId1 = new Tour();
        tourId1.setTourId(0L);
        tourId1.setTourName("tourName");
        tourId1.setTourCode("tourCode");
        tourId1.setStartPlace("startPlace");
        tourId1.setEndPlace("endPlace");
        tourId1.setStatus(0);
        tourId1.setTourType(0);
        tourId1.setTourMode(false);
        tourId1.setNumberOfDay(1);
        tourId1.setNumberOfNight(0);
        tourId1.setMinAdult(0);
        tourId1.setMaxAdult(0);
        tourId1.setMinChildren(0);
        tourId1.setMaxChildren(0);
        tourId1.setMinToStart(0);
        tourId1.setPriceAdult(0.0f);
        tourId1.setPriceChildren(0.0f);
        tourId1.setNote("note");
        tourId1.setStartDate(LocalDate.of(2020, 1, 1));
        tourId1.setStartTime(LocalTime.of(12, 0, 0));
        tourId1.setEndTime(LocalTime.of(12, 0, 0));
        tourId1.setTotalPrice(0.0f);
        tourId1.setDeposit(0.0f);
        final Account accountId3 = new Account();
        accountId3.setAccountId(0L);
        tourId1.setAccountId(accountId3);
        final TourCategory tourCategoryId3 = new TourCategory();
        tourCategoryId3.setTourCategoryId(0L);
        tourId1.setTourCategoryId(tourCategoryId3);
        tourDetail1.setTourId(tourId1);
        when(tourServiceImplUnderTest.tourDetailRepository.save(any(TourDetail.class))).thenReturn(tourDetail1);

        when(tourServiceImplUnderTest.tagOfTourRepository.getByTourDetailId(0L)).thenReturn(Collections.emptyList());

        // Configure TagRepository.getById(...).
        final Tag tag = new Tag();
        tag.setTagId(0L);
        tag.setTagName("tagName");
        final TagOfTour tagOfTour = new TagOfTour();
        tagOfTour.setTagOfTourId(0L);
        final TourDetail tourDetailId = new TourDetail();
        tourDetailId.setTourDetailId(0L);
        tourDetailId.setTourIntroduce("tourIntroduce");
        tourDetailId.setTourInclude("tourInclude");
        tourDetailId.setTourNonInclude("tourNonInclude");
        tourDetailId.setGeneralTerms("generalTerms");
        tourDetailId.setAddressStart("addressStart");
        tourDetailId.setDescription("description");
        tourDetailId.setMoreDescription("moreDescription");
        tourDetailId.setLongitude(0.0f);
        tourDetailId.setLatitude(0.0f);
        tagOfTour.setTourDetailId(tourDetailId);
        tag.setTagOfTourList(Arrays.asList(tagOfTour));
        when(tourServiceImplUnderTest.tagRepository.getById(0L)).thenReturn(tag);

        // Configure TagOfTourRepository.save(...).
        final TagOfTour tagOfTour1 = new TagOfTour();
        final Tag tagId = new Tag();
        tagId.setTagId(0L);
        tagOfTour1.setTagId(tagId);
        final TourDetail tourDetailId1 = new TourDetail();
        tourDetailId1.setTourDetailId(0L);
        tourDetailId1.setTourIntroduce("tourIntroduce");
        tourDetailId1.setTourInclude("tourInclude");
        tourDetailId1.setTourNonInclude("tourNonInclude");
        tourDetailId1.setGeneralTerms("generalTerms");
        tourDetailId1.setAddressStart("addressStart");
        tourDetailId1.setDescription("description");
        tourDetailId1.setMoreDescription("moreDescription");
        tourDetailId1.setLongitude(0.0f);
        tourDetailId1.setLatitude(0.0f);
        final Tour tourId2 = new Tour();
        tourId2.setTourId(0L);
        tourId2.setTourName("tourName");
        tourId2.setTourCode("tourCode");
        tourId2.setStartPlace("startPlace");
        tourId2.setEndPlace("endPlace");
        tourId2.setStatus(0);
        tourId2.setTourType(0);
        tourId2.setTourMode(false);
        tourId2.setNumberOfDay(1);
        tourId2.setNumberOfNight(0);
        tourId2.setMinAdult(0);
        tourId2.setMaxAdult(0);
        tourId2.setMinChildren(0);
        tourId2.setMaxChildren(0);
        tourId2.setMinToStart(0);
        tourId2.setPriceAdult(0.0f);
        tourId2.setPriceChildren(0.0f);
        tourId2.setNote("note");
        tourId2.setStartDate(LocalDate.of(2020, 1, 1));
        tourId2.setStartTime(LocalTime.of(12, 0, 0));
        tourId2.setEndTime(LocalTime.of(12, 0, 0));
        tourId2.setTotalPrice(0.0f);
        tourId2.setDeposit(0.0f);
        final Account accountId4 = new Account();
        accountId4.setAccountId(0L);
        tourId2.setAccountId(accountId4);
        final TourCategory tourCategoryId4 = new TourCategory();
        tourCategoryId4.setTourCategoryId(0L);
        tourId2.setTourCategoryId(tourCategoryId4);
        tourDetailId1.setTourId(tourId2);
        tagOfTour1.setTourDetailId(tourDetailId1);
        when(tourServiceImplUnderTest.tagOfTourRepository.save(any(TagOfTour.class))).thenReturn(tagOfTour1);

        // Configure TourScheduleRepository.getByTourId(...).
        final TourSchedule tourSchedule = new TourSchedule();
        tourSchedule.setTourScheduleName("tourScheduleName");
        tourSchedule.setContent("content");
        tourSchedule.setToPlace("toPlace");
        final Tour tourId3 = new Tour();
        tourId3.setTourId(0L);
        tourId3.setTourName("tourName");
        tourId3.setTourCode("tourCode");
        tourId3.setStartPlace("startPlace");
        tourId3.setEndPlace("endPlace");
        tourId3.setStatus(0);
        tourId3.setTourType(0);
        tourId3.setTourMode(false);
        tourId3.setNumberOfDay(1);
        tourId3.setNumberOfNight(0);
        tourId3.setMinAdult(0);
        tourId3.setMaxAdult(0);
        tourId3.setMinChildren(0);
        tourId3.setMaxChildren(0);
        tourId3.setMinToStart(0);
        tourId3.setPriceAdult(0.0f);
        tourId3.setPriceChildren(0.0f);
        tourId3.setNote("note");
        tourId3.setStartDate(LocalDate.of(2020, 1, 1));
        tourId3.setStartTime(LocalTime.of(12, 0, 0));
        tourId3.setEndTime(LocalTime.of(12, 0, 0));
        tourId3.setTotalPrice(0.0f);
        tourId3.setDeposit(0.0f);
        final Account accountId5 = new Account();
        accountId5.setAccountId(0L);
        tourId3.setAccountId(accountId5);
        final TourCategory tourCategoryId5 = new TourCategory();
        tourCategoryId5.setTourCategoryId(0L);
        tourId3.setTourCategoryId(tourCategoryId5);
        tourSchedule.setTourId(tourId3);
        final List<TourSchedule> tourScheduleList = Arrays.asList(tourSchedule);
        when(tourServiceImplUnderTest.tourScheduleRepository.getByTourId(0L)).thenReturn(tourScheduleList);

        // Configure TourScheduleRepository.save(...).
        final TourSchedule tourSchedule1 = new TourSchedule();
        tourSchedule1.setTourScheduleName("tourScheduleName");
        tourSchedule1.setContent("content");
        tourSchedule1.setToPlace("toPlace");
        final Tour tourId4 = new Tour();
        tourId4.setTourId(0L);
        tourId4.setTourName("tourName");
        tourId4.setTourCode("tourCode");
        tourId4.setStartPlace("startPlace");
        tourId4.setEndPlace("endPlace");
        tourId4.setStatus(0);
        tourId4.setTourType(0);
        tourId4.setTourMode(false);
        tourId4.setNumberOfDay(1);
        tourId4.setNumberOfNight(0);
        tourId4.setMinAdult(0);
        tourId4.setMaxAdult(0);
        tourId4.setMinChildren(0);
        tourId4.setMaxChildren(0);
        tourId4.setMinToStart(0);
        tourId4.setPriceAdult(0.0f);
        tourId4.setPriceChildren(0.0f);
        tourId4.setNote("note");
        tourId4.setStartDate(LocalDate.of(2020, 1, 1));
        tourId4.setStartTime(LocalTime.of(12, 0, 0));
        tourId4.setEndTime(LocalTime.of(12, 0, 0));
        tourId4.setTotalPrice(0.0f);
        tourId4.setDeposit(0.0f);
        final Account accountId6 = new Account();
        accountId6.setAccountId(0L);
        tourId4.setAccountId(accountId6);
        final TourCategory tourCategoryId6 = new TourCategory();
        tourCategoryId6.setTourCategoryId(0L);
        tourId4.setTourCategoryId(tourCategoryId6);
        tourSchedule1.setTourId(tourId4);
        when(tourServiceImplUnderTest.tourScheduleRepository.save(any(TourSchedule.class))).thenReturn(tourSchedule1);

        // Run the test
        final TourDTO result = tourServiceImplUnderTest.updateTour(tourDTO, 0L);

        // Verify the results
        verify(tourServiceImplUnderTest.tourRepository).save(any(Tour.class));
        verify(tourServiceImplUnderTest.tourDetailRepository).save(any(TourDetail.class));
        verify(tourServiceImplUnderTest.tagOfTourRepository).deleteAll(Arrays.asList(new TagOfTour()));
        verify(tourServiceImplUnderTest.tagOfTourRepository).save(any(TagOfTour.class));
        verify(tourServiceImplUnderTest.tourScheduleRepository).deleteAll(Arrays.asList(new TourSchedule()));
        verify(tourServiceImplUnderTest.tourScheduleRepository).save(any(TourSchedule.class));
    }

    @Test
    void testUpdateTour_TourScheduleRepositoryGetByTourIdReturnsNoItems() throws Exception {
        // Setup
        final TourDTO tourDTO = new TourDTO(0L, "tourName", "tourCode", "startPlace", "endPlace", 0, 0, false,
                LocalDate.of(2020, 1, 1), LocalTime.of(12, 0, 0), LocalTime.of(12, 0, 0), 1, 0, 0, 0, 0, 0, 0, 0.0f,
                0.0f, 0.0f, 0.0f, "note", 0L,
                new TourDetailDTO("tourIntroduce", "tourInclude", "tourNonInclude", "generalTerms", "addressStart",
                        "description", "moreDescription", 0.0f, 0.0f, Arrays.asList(new TagOfTourDTO(0L))),
                Arrays.asList(new TourScheduleDTO("tourScheduleName", "content", "toPlace")), 0L,
                new UserBookingDTO(0L, 0L, 0L, "tourName", 0, 0, "fullName", "phone", "email", LocalDate.of(2020, 1, 1),
                        LocalDate.of(2020, 1, 1), "idCard", LocalDate.of(2020, 1, 1), "placeOfIssue", "request", 0.0f,
                        0.0f, 0, 0, 0.0f, 0L, "orderTitle", "payType", 0, false, 0.0f, false));

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
        tour.setPriceAdult(0.0f);
        tour.setPriceChildren(0.0f);
        tour.setNote("note");
        tour.setStartDate(LocalDate.of(2020, 1, 1));
        tour.setStartTime(LocalTime.of(12, 0, 0));
        tour.setEndTime(LocalTime.of(12, 0, 0));
        tour.setTotalPrice(0.0f);
        tour.setDeposit(0.0f);
        final Account accountId = new Account();
        accountId.setAccountId(0L);
        tour.setAccountId(accountId);
        final TourCategory tourCategoryId = new TourCategory();
        tourCategoryId.setTourCategoryId(0L);
        tour.setTourCategoryId(tourCategoryId);
        when(tourServiceImplUnderTest.tourRepository.getById(0L)).thenReturn(tour);

        when(tourServiceImplUnderTest.tourRepository.existsById(0L)).thenReturn(false);

        // Configure TourCategoryRepository.getById(...).
        final TourCategory tourCategory = new TourCategory();
        tourCategory.setTourCategoryId(0L);
        tourCategory.setTourCategoryName("tourCategoryName");
        final Tour tour1 = new Tour();
        tour1.setTourId(0L);
        tour1.setTourName("tourName");
        tour1.setTourCode("tourCode");
        tour1.setStartPlace("startPlace");
        tour1.setEndPlace("endPlace");
        tour1.setStatus(0);
        tour1.setTourType(0);
        tour1.setTourMode(false);
        tour1.setNumberOfDay(1);
        tour1.setNumberOfNight(0);
        tour1.setMinAdult(0);
        tour1.setMaxAdult(0);
        tourCategory.setTourList(Arrays.asList(tour1));
        when(tourServiceImplUnderTest.tourCategoryRepository.getById(0L)).thenReturn(tourCategory);

        // Configure TourRepository.save(...).
        final Tour tour2 = new Tour();
        tour2.setTourId(0L);
        tour2.setTourName("tourName");
        tour2.setTourCode("tourCode");
        tour2.setStartPlace("startPlace");
        tour2.setEndPlace("endPlace");
        tour2.setStatus(0);
        tour2.setTourType(0);
        tour2.setTourMode(false);
        tour2.setNumberOfDay(1);
        tour2.setNumberOfNight(0);
        tour2.setMinAdult(0);
        tour2.setMaxAdult(0);
        tour2.setMinChildren(0);
        tour2.setMaxChildren(0);
        tour2.setMinToStart(0);
        tour2.setPriceAdult(0.0f);
        tour2.setPriceChildren(0.0f);
        tour2.setNote("note");
        tour2.setStartDate(LocalDate.of(2020, 1, 1));
        tour2.setStartTime(LocalTime.of(12, 0, 0));
        tour2.setEndTime(LocalTime.of(12, 0, 0));
        tour2.setTotalPrice(0.0f);
        tour2.setDeposit(0.0f);
        final Account accountId1 = new Account();
        accountId1.setAccountId(0L);
        tour2.setAccountId(accountId1);
        final TourCategory tourCategoryId1 = new TourCategory();
        tourCategoryId1.setTourCategoryId(0L);
        tour2.setTourCategoryId(tourCategoryId1);
        when(tourServiceImplUnderTest.tourRepository.save(any(Tour.class))).thenReturn(tour2);

        // Configure TourDetailRepository.getByTourId(...).
        final TourDetail tourDetail = new TourDetail();
        tourDetail.setTourDetailId(0L);
        tourDetail.setTourIntroduce("tourIntroduce");
        tourDetail.setTourInclude("tourInclude");
        tourDetail.setTourNonInclude("tourNonInclude");
        tourDetail.setGeneralTerms("generalTerms");
        tourDetail.setAddressStart("addressStart");
        tourDetail.setDescription("description");
        tourDetail.setMoreDescription("moreDescription");
        tourDetail.setLongitude(0.0f);
        tourDetail.setLatitude(0.0f);
        final Tour tourId = new Tour();
        tourId.setTourId(0L);
        tourId.setTourName("tourName");
        tourId.setTourCode("tourCode");
        tourId.setStartPlace("startPlace");
        tourId.setEndPlace("endPlace");
        tourId.setStatus(0);
        tourId.setTourType(0);
        tourId.setTourMode(false);
        tourId.setNumberOfDay(1);
        tourId.setNumberOfNight(0);
        tourId.setMinAdult(0);
        tourId.setMaxAdult(0);
        tourId.setMinChildren(0);
        tourId.setMaxChildren(0);
        tourId.setMinToStart(0);
        tourId.setPriceAdult(0.0f);
        tourId.setPriceChildren(0.0f);
        tourId.setNote("note");
        tourId.setStartDate(LocalDate.of(2020, 1, 1));
        tourId.setStartTime(LocalTime.of(12, 0, 0));
        tourId.setEndTime(LocalTime.of(12, 0, 0));
        tourId.setTotalPrice(0.0f);
        tourId.setDeposit(0.0f);
        final Account accountId2 = new Account();
        accountId2.setAccountId(0L);
        tourId.setAccountId(accountId2);
        final TourCategory tourCategoryId2 = new TourCategory();
        tourCategoryId2.setTourCategoryId(0L);
        tourId.setTourCategoryId(tourCategoryId2);
        tourDetail.setTourId(tourId);
        when(tourServiceImplUnderTest.tourDetailRepository.getByTourId(0L)).thenReturn(tourDetail);

        // Configure TourDetailRepository.save(...).
        final TourDetail tourDetail1 = new TourDetail();
        tourDetail1.setTourDetailId(0L);
        tourDetail1.setTourIntroduce("tourIntroduce");
        tourDetail1.setTourInclude("tourInclude");
        tourDetail1.setTourNonInclude("tourNonInclude");
        tourDetail1.setGeneralTerms("generalTerms");
        tourDetail1.setAddressStart("addressStart");
        tourDetail1.setDescription("description");
        tourDetail1.setMoreDescription("moreDescription");
        tourDetail1.setLongitude(0.0f);
        tourDetail1.setLatitude(0.0f);
        final Tour tourId1 = new Tour();
        tourId1.setTourId(0L);
        tourId1.setTourName("tourName");
        tourId1.setTourCode("tourCode");
        tourId1.setStartPlace("startPlace");
        tourId1.setEndPlace("endPlace");
        tourId1.setStatus(0);
        tourId1.setTourType(0);
        tourId1.setTourMode(false);
        tourId1.setNumberOfDay(1);
        tourId1.setNumberOfNight(0);
        tourId1.setMinAdult(0);
        tourId1.setMaxAdult(0);
        tourId1.setMinChildren(0);
        tourId1.setMaxChildren(0);
        tourId1.setMinToStart(0);
        tourId1.setPriceAdult(0.0f);
        tourId1.setPriceChildren(0.0f);
        tourId1.setNote("note");
        tourId1.setStartDate(LocalDate.of(2020, 1, 1));
        tourId1.setStartTime(LocalTime.of(12, 0, 0));
        tourId1.setEndTime(LocalTime.of(12, 0, 0));
        tourId1.setTotalPrice(0.0f);
        tourId1.setDeposit(0.0f);
        final Account accountId3 = new Account();
        accountId3.setAccountId(0L);
        tourId1.setAccountId(accountId3);
        final TourCategory tourCategoryId3 = new TourCategory();
        tourCategoryId3.setTourCategoryId(0L);
        tourId1.setTourCategoryId(tourCategoryId3);
        tourDetail1.setTourId(tourId1);
        when(tourServiceImplUnderTest.tourDetailRepository.save(any(TourDetail.class))).thenReturn(tourDetail1);

        // Configure TagOfTourRepository.getByTourDetailId(...).
        final TagOfTour tagOfTour = new TagOfTour();
        final Tag tagId = new Tag();
        tagId.setTagId(0L);
        tagOfTour.setTagId(tagId);
        final TourDetail tourDetailId = new TourDetail();
        tourDetailId.setTourDetailId(0L);
        tourDetailId.setTourIntroduce("tourIntroduce");
        tourDetailId.setTourInclude("tourInclude");
        tourDetailId.setTourNonInclude("tourNonInclude");
        tourDetailId.setGeneralTerms("generalTerms");
        tourDetailId.setAddressStart("addressStart");
        tourDetailId.setDescription("description");
        tourDetailId.setMoreDescription("moreDescription");
        tourDetailId.setLongitude(0.0f);
        tourDetailId.setLatitude(0.0f);
        final Tour tourId2 = new Tour();
        tourId2.setTourId(0L);
        tourId2.setTourName("tourName");
        tourId2.setTourCode("tourCode");
        tourId2.setStartPlace("startPlace");
        tourId2.setEndPlace("endPlace");
        tourId2.setStatus(0);
        tourId2.setTourType(0);
        tourId2.setTourMode(false);
        tourId2.setNumberOfDay(1);
        tourId2.setNumberOfNight(0);
        tourId2.setMinAdult(0);
        tourId2.setMaxAdult(0);
        tourId2.setMinChildren(0);
        tourId2.setMaxChildren(0);
        tourId2.setMinToStart(0);
        tourId2.setPriceAdult(0.0f);
        tourId2.setPriceChildren(0.0f);
        tourId2.setNote("note");
        tourId2.setStartDate(LocalDate.of(2020, 1, 1));
        tourId2.setStartTime(LocalTime.of(12, 0, 0));
        tourId2.setEndTime(LocalTime.of(12, 0, 0));
        tourId2.setTotalPrice(0.0f);
        tourId2.setDeposit(0.0f);
        final Account accountId4 = new Account();
        accountId4.setAccountId(0L);
        tourId2.setAccountId(accountId4);
        final TourCategory tourCategoryId4 = new TourCategory();
        tourCategoryId4.setTourCategoryId(0L);
        tourId2.setTourCategoryId(tourCategoryId4);
        tourDetailId.setTourId(tourId2);
        tagOfTour.setTourDetailId(tourDetailId);
        final List<TagOfTour> tagOfTourList = Arrays.asList(tagOfTour);
        when(tourServiceImplUnderTest.tagOfTourRepository.getByTourDetailId(0L)).thenReturn(tagOfTourList);

        // Configure TagRepository.getById(...).
        final Tag tag = new Tag();
        tag.setTagId(0L);
        tag.setTagName("tagName");
        final TagOfTour tagOfTour1 = new TagOfTour();
        tagOfTour1.setTagOfTourId(0L);
        final TourDetail tourDetailId1 = new TourDetail();
        tourDetailId1.setTourDetailId(0L);
        tourDetailId1.setTourIntroduce("tourIntroduce");
        tourDetailId1.setTourInclude("tourInclude");
        tourDetailId1.setTourNonInclude("tourNonInclude");
        tourDetailId1.setGeneralTerms("generalTerms");
        tourDetailId1.setAddressStart("addressStart");
        tourDetailId1.setDescription("description");
        tourDetailId1.setMoreDescription("moreDescription");
        tourDetailId1.setLongitude(0.0f);
        tourDetailId1.setLatitude(0.0f);
        tagOfTour1.setTourDetailId(tourDetailId1);
        tag.setTagOfTourList(Arrays.asList(tagOfTour1));
        when(tourServiceImplUnderTest.tagRepository.getById(0L)).thenReturn(tag);

        // Configure TagOfTourRepository.save(...).
        final TagOfTour tagOfTour2 = new TagOfTour();
        final Tag tagId1 = new Tag();
        tagId1.setTagId(0L);
        tagOfTour2.setTagId(tagId1);
        final TourDetail tourDetailId2 = new TourDetail();
        tourDetailId2.setTourDetailId(0L);
        tourDetailId2.setTourIntroduce("tourIntroduce");
        tourDetailId2.setTourInclude("tourInclude");
        tourDetailId2.setTourNonInclude("tourNonInclude");
        tourDetailId2.setGeneralTerms("generalTerms");
        tourDetailId2.setAddressStart("addressStart");
        tourDetailId2.setDescription("description");
        tourDetailId2.setMoreDescription("moreDescription");
        tourDetailId2.setLongitude(0.0f);
        tourDetailId2.setLatitude(0.0f);
        final Tour tourId3 = new Tour();
        tourId3.setTourId(0L);
        tourId3.setTourName("tourName");
        tourId3.setTourCode("tourCode");
        tourId3.setStartPlace("startPlace");
        tourId3.setEndPlace("endPlace");
        tourId3.setStatus(0);
        tourId3.setTourType(0);
        tourId3.setTourMode(false);
        tourId3.setNumberOfDay(1);
        tourId3.setNumberOfNight(0);
        tourId3.setMinAdult(0);
        tourId3.setMaxAdult(0);
        tourId3.setMinChildren(0);
        tourId3.setMaxChildren(0);
        tourId3.setMinToStart(0);
        tourId3.setPriceAdult(0.0f);
        tourId3.setPriceChildren(0.0f);
        tourId3.setNote("note");
        tourId3.setStartDate(LocalDate.of(2020, 1, 1));
        tourId3.setStartTime(LocalTime.of(12, 0, 0));
        tourId3.setEndTime(LocalTime.of(12, 0, 0));
        tourId3.setTotalPrice(0.0f);
        tourId3.setDeposit(0.0f);
        final Account accountId5 = new Account();
        accountId5.setAccountId(0L);
        tourId3.setAccountId(accountId5);
        final TourCategory tourCategoryId5 = new TourCategory();
        tourCategoryId5.setTourCategoryId(0L);
        tourId3.setTourCategoryId(tourCategoryId5);
        tourDetailId2.setTourId(tourId3);
        tagOfTour2.setTourDetailId(tourDetailId2);
        when(tourServiceImplUnderTest.tagOfTourRepository.save(any(TagOfTour.class))).thenReturn(tagOfTour2);

        when(tourServiceImplUnderTest.tourScheduleRepository.getByTourId(0L)).thenReturn(Collections.emptyList());

        // Configure TourScheduleRepository.save(...).
        final TourSchedule tourSchedule = new TourSchedule();
        tourSchedule.setTourScheduleName("tourScheduleName");
        tourSchedule.setContent("content");
        tourSchedule.setToPlace("toPlace");
        final Tour tourId4 = new Tour();
        tourId4.setTourId(0L);
        tourId4.setTourName("tourName");
        tourId4.setTourCode("tourCode");
        tourId4.setStartPlace("startPlace");
        tourId4.setEndPlace("endPlace");
        tourId4.setStatus(0);
        tourId4.setTourType(0);
        tourId4.setTourMode(false);
        tourId4.setNumberOfDay(1);
        tourId4.setNumberOfNight(0);
        tourId4.setMinAdult(0);
        tourId4.setMaxAdult(0);
        tourId4.setMinChildren(0);
        tourId4.setMaxChildren(0);
        tourId4.setMinToStart(0);
        tourId4.setPriceAdult(0.0f);
        tourId4.setPriceChildren(0.0f);
        tourId4.setNote("note");
        tourId4.setStartDate(LocalDate.of(2020, 1, 1));
        tourId4.setStartTime(LocalTime.of(12, 0, 0));
        tourId4.setEndTime(LocalTime.of(12, 0, 0));
        tourId4.setTotalPrice(0.0f);
        tourId4.setDeposit(0.0f);
        final Account accountId6 = new Account();
        accountId6.setAccountId(0L);
        tourId4.setAccountId(accountId6);
        final TourCategory tourCategoryId6 = new TourCategory();
        tourCategoryId6.setTourCategoryId(0L);
        tourId4.setTourCategoryId(tourCategoryId6);
        tourSchedule.setTourId(tourId4);
        when(tourServiceImplUnderTest.tourScheduleRepository.save(any(TourSchedule.class))).thenReturn(tourSchedule);

        // Run the test
        final TourDTO result = tourServiceImplUnderTest.updateTour(tourDTO, 0L);

        // Verify the results
        verify(tourServiceImplUnderTest.tourRepository).save(any(Tour.class));
        verify(tourServiceImplUnderTest.tourDetailRepository).save(any(TourDetail.class));
        verify(tourServiceImplUnderTest.tagOfTourRepository).deleteAll(Arrays.asList(new TagOfTour()));
        verify(tourServiceImplUnderTest.tagOfTourRepository).save(any(TagOfTour.class));
        verify(tourServiceImplUnderTest.tourScheduleRepository).deleteAll(Arrays.asList(new TourSchedule()));
        verify(tourServiceImplUnderTest.tourScheduleRepository).save(any(TourSchedule.class));
    }

    @Test
    void testUpdateTour_ThrowsHandlerException() {
        // Setup
        final TourDTO tourDTO = new TourDTO(0L, "tourName", "tourCode", "startPlace", "endPlace", 0, 0, false,
                LocalDate.of(2020, 1, 1), LocalTime.of(12, 0, 0), LocalTime.of(12, 0, 0), 1, 0, 0, 0, 0, 0, 0, 0.0f,
                0.0f, 0.0f, 0.0f, "note", 0L,
                new TourDetailDTO("tourIntroduce", "tourInclude", "tourNonInclude", "generalTerms", "addressStart",
                        "description", "moreDescription", 0.0f, 0.0f, Arrays.asList(new TagOfTourDTO(0L))),
                Arrays.asList(new TourScheduleDTO("tourScheduleName", "content", "toPlace")), 0L,
                new UserBookingDTO(0L, 0L, 0L, "tourName", 0, 0, "fullName", "phone", "email", LocalDate.of(2020, 1, 1),
                        LocalDate.of(2020, 1, 1), "idCard", LocalDate.of(2020, 1, 1), "placeOfIssue", "request", 0.0f,
                        0.0f, 0, 0, 0.0f, 0L, "orderTitle", "payType", 0, false, 0.0f, false));

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
        tour.setPriceAdult(0.0f);
        tour.setPriceChildren(0.0f);
        tour.setNote("note");
        tour.setStartDate(LocalDate.of(2020, 1, 1));
        tour.setStartTime(LocalTime.of(12, 0, 0));
        tour.setEndTime(LocalTime.of(12, 0, 0));
        tour.setTotalPrice(0.0f);
        tour.setDeposit(0.0f);
        final Account accountId = new Account();
        accountId.setAccountId(0L);
        tour.setAccountId(accountId);
        final TourCategory tourCategoryId = new TourCategory();
        tourCategoryId.setTourCategoryId(0L);
        tour.setTourCategoryId(tourCategoryId);
        when(tourServiceImplUnderTest.tourRepository.getById(0L)).thenReturn(tour);

        when(tourServiceImplUnderTest.tourRepository.existsById(0L)).thenReturn(false);

        // Configure TourCategoryRepository.getById(...).
        final TourCategory tourCategory = new TourCategory();
        tourCategory.setTourCategoryId(0L);
        tourCategory.setTourCategoryName("tourCategoryName");
        final Tour tour1 = new Tour();
        tour1.setTourId(0L);
        tour1.setTourName("tourName");
        tour1.setTourCode("tourCode");
        tour1.setStartPlace("startPlace");
        tour1.setEndPlace("endPlace");
        tour1.setStatus(0);
        tour1.setTourType(0);
        tour1.setTourMode(false);
        tour1.setNumberOfDay(1);
        tour1.setNumberOfNight(0);
        tour1.setMinAdult(0);
        tour1.setMaxAdult(0);
        tourCategory.setTourList(Arrays.asList(tour1));
        when(tourServiceImplUnderTest.tourCategoryRepository.getById(0L)).thenReturn(tourCategory);

        // Configure TourRepository.save(...).
        final Tour tour2 = new Tour();
        tour2.setTourId(0L);
        tour2.setTourName("tourName");
        tour2.setTourCode("tourCode");
        tour2.setStartPlace("startPlace");
        tour2.setEndPlace("endPlace");
        tour2.setStatus(0);
        tour2.setTourType(0);
        tour2.setTourMode(false);
        tour2.setNumberOfDay(1);
        tour2.setNumberOfNight(0);
        tour2.setMinAdult(0);
        tour2.setMaxAdult(0);
        tour2.setMinChildren(0);
        tour2.setMaxChildren(0);
        tour2.setMinToStart(0);
        tour2.setPriceAdult(0.0f);
        tour2.setPriceChildren(0.0f);
        tour2.setNote("note");
        tour2.setStartDate(LocalDate.of(2020, 1, 1));
        tour2.setStartTime(LocalTime.of(12, 0, 0));
        tour2.setEndTime(LocalTime.of(12, 0, 0));
        tour2.setTotalPrice(0.0f);
        tour2.setDeposit(0.0f);
        final Account accountId1 = new Account();
        accountId1.setAccountId(0L);
        tour2.setAccountId(accountId1);
        final TourCategory tourCategoryId1 = new TourCategory();
        tourCategoryId1.setTourCategoryId(0L);
        tour2.setTourCategoryId(tourCategoryId1);
        when(tourServiceImplUnderTest.tourRepository.save(any(Tour.class))).thenReturn(tour2);

        // Configure TourDetailRepository.getByTourId(...).
        final TourDetail tourDetail = new TourDetail();
        tourDetail.setTourDetailId(0L);
        tourDetail.setTourIntroduce("tourIntroduce");
        tourDetail.setTourInclude("tourInclude");
        tourDetail.setTourNonInclude("tourNonInclude");
        tourDetail.setGeneralTerms("generalTerms");
        tourDetail.setAddressStart("addressStart");
        tourDetail.setDescription("description");
        tourDetail.setMoreDescription("moreDescription");
        tourDetail.setLongitude(0.0f);
        tourDetail.setLatitude(0.0f);
        final Tour tourId = new Tour();
        tourId.setTourId(0L);
        tourId.setTourName("tourName");
        tourId.setTourCode("tourCode");
        tourId.setStartPlace("startPlace");
        tourId.setEndPlace("endPlace");
        tourId.setStatus(0);
        tourId.setTourType(0);
        tourId.setTourMode(false);
        tourId.setNumberOfDay(1);
        tourId.setNumberOfNight(0);
        tourId.setMinAdult(0);
        tourId.setMaxAdult(0);
        tourId.setMinChildren(0);
        tourId.setMaxChildren(0);
        tourId.setMinToStart(0);
        tourId.setPriceAdult(0.0f);
        tourId.setPriceChildren(0.0f);
        tourId.setNote("note");
        tourId.setStartDate(LocalDate.of(2020, 1, 1));
        tourId.setStartTime(LocalTime.of(12, 0, 0));
        tourId.setEndTime(LocalTime.of(12, 0, 0));
        tourId.setTotalPrice(0.0f);
        tourId.setDeposit(0.0f);
        final Account accountId2 = new Account();
        accountId2.setAccountId(0L);
        tourId.setAccountId(accountId2);
        final TourCategory tourCategoryId2 = new TourCategory();
        tourCategoryId2.setTourCategoryId(0L);
        tourId.setTourCategoryId(tourCategoryId2);
        tourDetail.setTourId(tourId);
        when(tourServiceImplUnderTest.tourDetailRepository.getByTourId(0L)).thenReturn(tourDetail);

        // Configure TourDetailRepository.save(...).
        final TourDetail tourDetail1 = new TourDetail();
        tourDetail1.setTourDetailId(0L);
        tourDetail1.setTourIntroduce("tourIntroduce");
        tourDetail1.setTourInclude("tourInclude");
        tourDetail1.setTourNonInclude("tourNonInclude");
        tourDetail1.setGeneralTerms("generalTerms");
        tourDetail1.setAddressStart("addressStart");
        tourDetail1.setDescription("description");
        tourDetail1.setMoreDescription("moreDescription");
        tourDetail1.setLongitude(0.0f);
        tourDetail1.setLatitude(0.0f);
        final Tour tourId1 = new Tour();
        tourId1.setTourId(0L);
        tourId1.setTourName("tourName");
        tourId1.setTourCode("tourCode");
        tourId1.setStartPlace("startPlace");
        tourId1.setEndPlace("endPlace");
        tourId1.setStatus(0);
        tourId1.setTourType(0);
        tourId1.setTourMode(false);
        tourId1.setNumberOfDay(1);
        tourId1.setNumberOfNight(0);
        tourId1.setMinAdult(0);
        tourId1.setMaxAdult(0);
        tourId1.setMinChildren(0);
        tourId1.setMaxChildren(0);
        tourId1.setMinToStart(0);
        tourId1.setPriceAdult(0.0f);
        tourId1.setPriceChildren(0.0f);
        tourId1.setNote("note");
        tourId1.setStartDate(LocalDate.of(2020, 1, 1));
        tourId1.setStartTime(LocalTime.of(12, 0, 0));
        tourId1.setEndTime(LocalTime.of(12, 0, 0));
        tourId1.setTotalPrice(0.0f);
        tourId1.setDeposit(0.0f);
        final Account accountId3 = new Account();
        accountId3.setAccountId(0L);
        tourId1.setAccountId(accountId3);
        final TourCategory tourCategoryId3 = new TourCategory();
        tourCategoryId3.setTourCategoryId(0L);
        tourId1.setTourCategoryId(tourCategoryId3);
        tourDetail1.setTourId(tourId1);
        when(tourServiceImplUnderTest.tourDetailRepository.save(any(TourDetail.class))).thenReturn(tourDetail1);

        // Configure TagOfTourRepository.getByTourDetailId(...).
        final TagOfTour tagOfTour = new TagOfTour();
        final Tag tagId = new Tag();
        tagId.setTagId(0L);
        tagOfTour.setTagId(tagId);
        final TourDetail tourDetailId = new TourDetail();
        tourDetailId.setTourDetailId(0L);
        tourDetailId.setTourIntroduce("tourIntroduce");
        tourDetailId.setTourInclude("tourInclude");
        tourDetailId.setTourNonInclude("tourNonInclude");
        tourDetailId.setGeneralTerms("generalTerms");
        tourDetailId.setAddressStart("addressStart");
        tourDetailId.setDescription("description");
        tourDetailId.setMoreDescription("moreDescription");
        tourDetailId.setLongitude(0.0f);
        tourDetailId.setLatitude(0.0f);
        final Tour tourId2 = new Tour();
        tourId2.setTourId(0L);
        tourId2.setTourName("tourName");
        tourId2.setTourCode("tourCode");
        tourId2.setStartPlace("startPlace");
        tourId2.setEndPlace("endPlace");
        tourId2.setStatus(0);
        tourId2.setTourType(0);
        tourId2.setTourMode(false);
        tourId2.setNumberOfDay(1);
        tourId2.setNumberOfNight(0);
        tourId2.setMinAdult(0);
        tourId2.setMaxAdult(0);
        tourId2.setMinChildren(0);
        tourId2.setMaxChildren(0);
        tourId2.setMinToStart(0);
        tourId2.setPriceAdult(0.0f);
        tourId2.setPriceChildren(0.0f);
        tourId2.setNote("note");
        tourId2.setStartDate(LocalDate.of(2020, 1, 1));
        tourId2.setStartTime(LocalTime.of(12, 0, 0));
        tourId2.setEndTime(LocalTime.of(12, 0, 0));
        tourId2.setTotalPrice(0.0f);
        tourId2.setDeposit(0.0f);
        final Account accountId4 = new Account();
        accountId4.setAccountId(0L);
        tourId2.setAccountId(accountId4);
        final TourCategory tourCategoryId4 = new TourCategory();
        tourCategoryId4.setTourCategoryId(0L);
        tourId2.setTourCategoryId(tourCategoryId4);
        tourDetailId.setTourId(tourId2);
        tagOfTour.setTourDetailId(tourDetailId);
        final List<TagOfTour> tagOfTourList = Arrays.asList(tagOfTour);
        when(tourServiceImplUnderTest.tagOfTourRepository.getByTourDetailId(0L)).thenReturn(tagOfTourList);

        // Configure TagRepository.getById(...).
        final Tag tag = new Tag();
        tag.setTagId(0L);
        tag.setTagName("tagName");
        final TagOfTour tagOfTour1 = new TagOfTour();
        tagOfTour1.setTagOfTourId(0L);
        final TourDetail tourDetailId1 = new TourDetail();
        tourDetailId1.setTourDetailId(0L);
        tourDetailId1.setTourIntroduce("tourIntroduce");
        tourDetailId1.setTourInclude("tourInclude");
        tourDetailId1.setTourNonInclude("tourNonInclude");
        tourDetailId1.setGeneralTerms("generalTerms");
        tourDetailId1.setAddressStart("addressStart");
        tourDetailId1.setDescription("description");
        tourDetailId1.setMoreDescription("moreDescription");
        tourDetailId1.setLongitude(0.0f);
        tourDetailId1.setLatitude(0.0f);
        tagOfTour1.setTourDetailId(tourDetailId1);
        tag.setTagOfTourList(Arrays.asList(tagOfTour1));
        when(tourServiceImplUnderTest.tagRepository.getById(0L)).thenReturn(tag);

        // Configure TagOfTourRepository.save(...).
        final TagOfTour tagOfTour2 = new TagOfTour();
        final Tag tagId1 = new Tag();
        tagId1.setTagId(0L);
        tagOfTour2.setTagId(tagId1);
        final TourDetail tourDetailId2 = new TourDetail();
        tourDetailId2.setTourDetailId(0L);
        tourDetailId2.setTourIntroduce("tourIntroduce");
        tourDetailId2.setTourInclude("tourInclude");
        tourDetailId2.setTourNonInclude("tourNonInclude");
        tourDetailId2.setGeneralTerms("generalTerms");
        tourDetailId2.setAddressStart("addressStart");
        tourDetailId2.setDescription("description");
        tourDetailId2.setMoreDescription("moreDescription");
        tourDetailId2.setLongitude(0.0f);
        tourDetailId2.setLatitude(0.0f);
        final Tour tourId3 = new Tour();
        tourId3.setTourId(0L);
        tourId3.setTourName("tourName");
        tourId3.setTourCode("tourCode");
        tourId3.setStartPlace("startPlace");
        tourId3.setEndPlace("endPlace");
        tourId3.setStatus(0);
        tourId3.setTourType(0);
        tourId3.setTourMode(false);
        tourId3.setNumberOfDay(1);
        tourId3.setNumberOfNight(0);
        tourId3.setMinAdult(0);
        tourId3.setMaxAdult(0);
        tourId3.setMinChildren(0);
        tourId3.setMaxChildren(0);
        tourId3.setMinToStart(0);
        tourId3.setPriceAdult(0.0f);
        tourId3.setPriceChildren(0.0f);
        tourId3.setNote("note");
        tourId3.setStartDate(LocalDate.of(2020, 1, 1));
        tourId3.setStartTime(LocalTime.of(12, 0, 0));
        tourId3.setEndTime(LocalTime.of(12, 0, 0));
        tourId3.setTotalPrice(0.0f);
        tourId3.setDeposit(0.0f);
        final Account accountId5 = new Account();
        accountId5.setAccountId(0L);
        tourId3.setAccountId(accountId5);
        final TourCategory tourCategoryId5 = new TourCategory();
        tourCategoryId5.setTourCategoryId(0L);
        tourId3.setTourCategoryId(tourCategoryId5);
        tourDetailId2.setTourId(tourId3);
        tagOfTour2.setTourDetailId(tourDetailId2);
        when(tourServiceImplUnderTest.tagOfTourRepository.save(any(TagOfTour.class))).thenReturn(tagOfTour2);

        // Configure TourScheduleRepository.getByTourId(...).
        final TourSchedule tourSchedule = new TourSchedule();
        tourSchedule.setTourScheduleName("tourScheduleName");
        tourSchedule.setContent("content");
        tourSchedule.setToPlace("toPlace");
        final Tour tourId4 = new Tour();
        tourId4.setTourId(0L);
        tourId4.setTourName("tourName");
        tourId4.setTourCode("tourCode");
        tourId4.setStartPlace("startPlace");
        tourId4.setEndPlace("endPlace");
        tourId4.setStatus(0);
        tourId4.setTourType(0);
        tourId4.setTourMode(false);
        tourId4.setNumberOfDay(1);
        tourId4.setNumberOfNight(0);
        tourId4.setMinAdult(0);
        tourId4.setMaxAdult(0);
        tourId4.setMinChildren(0);
        tourId4.setMaxChildren(0);
        tourId4.setMinToStart(0);
        tourId4.setPriceAdult(0.0f);
        tourId4.setPriceChildren(0.0f);
        tourId4.setNote("note");
        tourId4.setStartDate(LocalDate.of(2020, 1, 1));
        tourId4.setStartTime(LocalTime.of(12, 0, 0));
        tourId4.setEndTime(LocalTime.of(12, 0, 0));
        tourId4.setTotalPrice(0.0f);
        tourId4.setDeposit(0.0f);
        final Account accountId6 = new Account();
        accountId6.setAccountId(0L);
        tourId4.setAccountId(accountId6);
        final TourCategory tourCategoryId6 = new TourCategory();
        tourCategoryId6.setTourCategoryId(0L);
        tourId4.setTourCategoryId(tourCategoryId6);
        tourSchedule.setTourId(tourId4);
        final List<TourSchedule> tourScheduleList = Arrays.asList(tourSchedule);
        when(tourServiceImplUnderTest.tourScheduleRepository.getByTourId(0L)).thenReturn(tourScheduleList);

        // Configure TourScheduleRepository.save(...).
        final TourSchedule tourSchedule1 = new TourSchedule();
        tourSchedule1.setTourScheduleName("tourScheduleName");
        tourSchedule1.setContent("content");
        tourSchedule1.setToPlace("toPlace");
        final Tour tourId5 = new Tour();
        tourId5.setTourId(0L);
        tourId5.setTourName("tourName");
        tourId5.setTourCode("tourCode");
        tourId5.setStartPlace("startPlace");
        tourId5.setEndPlace("endPlace");
        tourId5.setStatus(0);
        tourId5.setTourType(0);
        tourId5.setTourMode(false);
        tourId5.setNumberOfDay(1);
        tourId5.setNumberOfNight(0);
        tourId5.setMinAdult(0);
        tourId5.setMaxAdult(0);
        tourId5.setMinChildren(0);
        tourId5.setMaxChildren(0);
        tourId5.setMinToStart(0);
        tourId5.setPriceAdult(0.0f);
        tourId5.setPriceChildren(0.0f);
        tourId5.setNote("note");
        tourId5.setStartDate(LocalDate.of(2020, 1, 1));
        tourId5.setStartTime(LocalTime.of(12, 0, 0));
        tourId5.setEndTime(LocalTime.of(12, 0, 0));
        tourId5.setTotalPrice(0.0f);
        tourId5.setDeposit(0.0f);
        final Account accountId7 = new Account();
        accountId7.setAccountId(0L);
        tourId5.setAccountId(accountId7);
        final TourCategory tourCategoryId7 = new TourCategory();
        tourCategoryId7.setTourCategoryId(0L);
        tourId5.setTourCategoryId(tourCategoryId7);
        tourSchedule1.setTourId(tourId5);
        when(tourServiceImplUnderTest.tourScheduleRepository.save(any(TourSchedule.class))).thenReturn(tourSchedule1);

        // Run the test
        assertThatThrownBy(() -> tourServiceImplUnderTest.updateTour(tourDTO, 0L)).isInstanceOf(HandlerException.class);
        verify(tourServiceImplUnderTest.tourRepository).save(any(Tour.class));
        verify(tourServiceImplUnderTest.tourDetailRepository).save(any(TourDetail.class));
        verify(tourServiceImplUnderTest.tagOfTourRepository).deleteAll(Arrays.asList(new TagOfTour()));
        verify(tourServiceImplUnderTest.tagOfTourRepository).save(any(TagOfTour.class));
        verify(tourServiceImplUnderTest.tourScheduleRepository).deleteAll(Arrays.asList(new TourSchedule()));
        verify(tourServiceImplUnderTest.tourScheduleRepository).save(any(TourSchedule.class));
    }

    @Test
    void testCountTour() throws Exception {
        // Setup
        when(tourServiceImplUnderTest.tourRepository.countListTour("tourName", Arrays.asList(0), 0, 0, 0,
                0)).thenReturn(0);

        // Run the test
        final Integer result = tourServiceImplUnderTest.countTour("tourName", Arrays.asList(0), 0, 0, 0, 0);

        // Verify the results
        assertThat(result).isEqualTo(0);
    }

    @Test
    void testCountTour_ThrowsHandlerException() {
        // Setup
        when(tourServiceImplUnderTest.tourRepository.countListTour("tourName", Arrays.asList(0), 0, 0, 0,
                0)).thenReturn(0);

        // Run the test
        assertThatThrownBy(
                () -> tourServiceImplUnderTest.countTour("tourName", Arrays.asList(0), 0, 0, 0, 0))
                .isInstanceOf(HandlerException.class);
    }

    @Test
    void testDeleteTour() throws Exception {
        // Setup
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
        tour.setPriceAdult(0.0f);
        tour.setPriceChildren(0.0f);
        tour.setNote("note");
        tour.setStartDate(LocalDate.of(2020, 1, 1));
        tour.setStartTime(LocalTime.of(12, 0, 0));
        tour.setEndTime(LocalTime.of(12, 0, 0));
        tour.setTotalPrice(0.0f);
        tour.setDeposit(0.0f);
        final Account accountId = new Account();
        accountId.setAccountId(0L);
        tour.setAccountId(accountId);
        final TourCategory tourCategoryId = new TourCategory();
        tourCategoryId.setTourCategoryId(0L);
        tour.setTourCategoryId(tourCategoryId);
        when(tourServiceImplUnderTest.tourRepository.getById(0L)).thenReturn(tour);

        when(tourServiceImplUnderTest.tourRepository.existsById(0L)).thenReturn(false);

        // Configure TourRepository.save(...).
        final Tour tour1 = new Tour();
        tour1.setTourId(0L);
        tour1.setTourName("tourName");
        tour1.setTourCode("tourCode");
        tour1.setStartPlace("startPlace");
        tour1.setEndPlace("endPlace");
        tour1.setStatus(0);
        tour1.setTourType(0);
        tour1.setTourMode(false);
        tour1.setNumberOfDay(1);
        tour1.setNumberOfNight(0);
        tour1.setMinAdult(0);
        tour1.setMaxAdult(0);
        tour1.setMinChildren(0);
        tour1.setMaxChildren(0);
        tour1.setMinToStart(0);
        tour1.setPriceAdult(0.0f);
        tour1.setPriceChildren(0.0f);
        tour1.setNote("note");
        tour1.setStartDate(LocalDate.of(2020, 1, 1));
        tour1.setStartTime(LocalTime.of(12, 0, 0));
        tour1.setEndTime(LocalTime.of(12, 0, 0));
        tour1.setTotalPrice(0.0f);
        tour1.setDeposit(0.0f);
        final Account accountId1 = new Account();
        accountId1.setAccountId(0L);
        tour1.setAccountId(accountId1);
        final TourCategory tourCategoryId1 = new TourCategory();
        tourCategoryId1.setTourCategoryId(0L);
        tour1.setTourCategoryId(tourCategoryId1);
        when(tourServiceImplUnderTest.tourRepository.save(any(Tour.class))).thenReturn(tour1);

        // Run the test
        final Boolean result = tourServiceImplUnderTest.deleteTour(0L);

        // Verify the results
        assertThat(result).isFalse();
        verify(tourServiceImplUnderTest.tourRepository).save(any(Tour.class));
    }

    @Test
    void testDeleteTour_ThrowsHandlerException() {
        // Setup
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
        tour.setPriceAdult(0.0f);
        tour.setPriceChildren(0.0f);
        tour.setNote("note");
        tour.setStartDate(LocalDate.of(2020, 1, 1));
        tour.setStartTime(LocalTime.of(12, 0, 0));
        tour.setEndTime(LocalTime.of(12, 0, 0));
        tour.setTotalPrice(0.0f);
        tour.setDeposit(0.0f);
        final Account accountId = new Account();
        accountId.setAccountId(0L);
        tour.setAccountId(accountId);
        final TourCategory tourCategoryId = new TourCategory();
        tourCategoryId.setTourCategoryId(0L);
        tour.setTourCategoryId(tourCategoryId);
        when(tourServiceImplUnderTest.tourRepository.getById(0L)).thenReturn(tour);

        when(tourServiceImplUnderTest.tourRepository.existsById(0L)).thenReturn(false);

        // Configure TourRepository.save(...).
        final Tour tour1 = new Tour();
        tour1.setTourId(0L);
        tour1.setTourName("tourName");
        tour1.setTourCode("tourCode");
        tour1.setStartPlace("startPlace");
        tour1.setEndPlace("endPlace");
        tour1.setStatus(0);
        tour1.setTourType(0);
        tour1.setTourMode(false);
        tour1.setNumberOfDay(1);
        tour1.setNumberOfNight(0);
        tour1.setMinAdult(0);
        tour1.setMaxAdult(0);
        tour1.setMinChildren(0);
        tour1.setMaxChildren(0);
        tour1.setMinToStart(0);
        tour1.setPriceAdult(0.0f);
        tour1.setPriceChildren(0.0f);
        tour1.setNote("note");
        tour1.setStartDate(LocalDate.of(2020, 1, 1));
        tour1.setStartTime(LocalTime.of(12, 0, 0));
        tour1.setEndTime(LocalTime.of(12, 0, 0));
        tour1.setTotalPrice(0.0f);
        tour1.setDeposit(0.0f);
        final Account accountId1 = new Account();
        accountId1.setAccountId(0L);
        tour1.setAccountId(accountId1);
        final TourCategory tourCategoryId1 = new TourCategory();
        tourCategoryId1.setTourCategoryId(0L);
        tour1.setTourCategoryId(tourCategoryId1);
        when(tourServiceImplUnderTest.tourRepository.save(any(Tour.class))).thenReturn(tour1);

        // Run the test
        assertThatThrownBy(() -> tourServiceImplUnderTest.deleteTour(0L)).isInstanceOf(HandlerException.class);
        verify(tourServiceImplUnderTest.tourRepository).save(any(Tour.class));
    }

    @Test
    void testActiveTour() throws Exception {
        // Setup
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
        tour.setPriceAdult(0.0f);
        tour.setPriceChildren(0.0f);
        tour.setNote("note");
        tour.setStartDate(LocalDate.of(2020, 1, 1));
        tour.setStartTime(LocalTime.of(12, 0, 0));
        tour.setEndTime(LocalTime.of(12, 0, 0));
        tour.setTotalPrice(0.0f);
        tour.setDeposit(0.0f);
        final Account accountId = new Account();
        accountId.setAccountId(0L);
        tour.setAccountId(accountId);
        final TourCategory tourCategoryId = new TourCategory();
        tourCategoryId.setTourCategoryId(0L);
        tour.setTourCategoryId(tourCategoryId);
        when(tourServiceImplUnderTest.tourRepository.getById(0L)).thenReturn(tour);

        when(tourServiceImplUnderTest.tourRepository.existsById(0L)).thenReturn(false);

        // Configure TourRepository.save(...).
        final Tour tour1 = new Tour();
        tour1.setTourId(0L);
        tour1.setTourName("tourName");
        tour1.setTourCode("tourCode");
        tour1.setStartPlace("startPlace");
        tour1.setEndPlace("endPlace");
        tour1.setStatus(0);
        tour1.setTourType(0);
        tour1.setTourMode(false);
        tour1.setNumberOfDay(1);
        tour1.setNumberOfNight(0);
        tour1.setMinAdult(0);
        tour1.setMaxAdult(0);
        tour1.setMinChildren(0);
        tour1.setMaxChildren(0);
        tour1.setMinToStart(0);
        tour1.setPriceAdult(0.0f);
        tour1.setPriceChildren(0.0f);
        tour1.setNote("note");
        tour1.setStartDate(LocalDate.of(2020, 1, 1));
        tour1.setStartTime(LocalTime.of(12, 0, 0));
        tour1.setEndTime(LocalTime.of(12, 0, 0));
        tour1.setTotalPrice(0.0f);
        tour1.setDeposit(0.0f);
        final Account accountId1 = new Account();
        accountId1.setAccountId(0L);
        tour1.setAccountId(accountId1);
        final TourCategory tourCategoryId1 = new TourCategory();
        tourCategoryId1.setTourCategoryId(0L);
        tour1.setTourCategoryId(tourCategoryId1);
        when(tourServiceImplUnderTest.tourRepository.save(any(Tour.class))).thenReturn(tour1);

        // Run the test
        final Boolean result = tourServiceImplUnderTest.activeTour(0L);

        // Verify the results
        assertThat(result).isFalse();
        verify(tourServiceImplUnderTest.tourRepository).save(any(Tour.class));
    }

    @Test
    void testActiveTour_ThrowsHandlerException() {
        // Setup
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
        tour.setPriceAdult(0.0f);
        tour.setPriceChildren(0.0f);
        tour.setNote("note");
        tour.setStartDate(LocalDate.of(2020, 1, 1));
        tour.setStartTime(LocalTime.of(12, 0, 0));
        tour.setEndTime(LocalTime.of(12, 0, 0));
        tour.setTotalPrice(0.0f);
        tour.setDeposit(0.0f);
        final Account accountId = new Account();
        accountId.setAccountId(0L);
        tour.setAccountId(accountId);
        final TourCategory tourCategoryId = new TourCategory();
        tourCategoryId.setTourCategoryId(0L);
        tour.setTourCategoryId(tourCategoryId);
        when(tourServiceImplUnderTest.tourRepository.getById(0L)).thenReturn(tour);

        when(tourServiceImplUnderTest.tourRepository.existsById(0L)).thenReturn(false);

        // Configure TourRepository.save(...).
        final Tour tour1 = new Tour();
        tour1.setTourId(0L);
        tour1.setTourName("tourName");
        tour1.setTourCode("tourCode");
        tour1.setStartPlace("startPlace");
        tour1.setEndPlace("endPlace");
        tour1.setStatus(0);
        tour1.setTourType(0);
        tour1.setTourMode(false);
        tour1.setNumberOfDay(1);
        tour1.setNumberOfNight(0);
        tour1.setMinAdult(0);
        tour1.setMaxAdult(0);
        tour1.setMinChildren(0);
        tour1.setMaxChildren(0);
        tour1.setMinToStart(0);
        tour1.setPriceAdult(0.0f);
        tour1.setPriceChildren(0.0f);
        tour1.setNote("note");
        tour1.setStartDate(LocalDate.of(2020, 1, 1));
        tour1.setStartTime(LocalTime.of(12, 0, 0));
        tour1.setEndTime(LocalTime.of(12, 0, 0));
        tour1.setTotalPrice(0.0f);
        tour1.setDeposit(0.0f);
        final Account accountId1 = new Account();
        accountId1.setAccountId(0L);
        tour1.setAccountId(accountId1);
        final TourCategory tourCategoryId1 = new TourCategory();
        tourCategoryId1.setTourCategoryId(0L);
        tour1.setTourCategoryId(tourCategoryId1);
        when(tourServiceImplUnderTest.tourRepository.save(any(Tour.class))).thenReturn(tour1);

        // Run the test
        assertThatThrownBy(() -> tourServiceImplUnderTest.activeTour(0L)).isInstanceOf(HandlerException.class);
        verify(tourServiceImplUnderTest.tourRepository).save(any(Tour.class));
    }
}

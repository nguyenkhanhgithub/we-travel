package com.example.wetravel.Service.ServiceImpl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.example.wetravel.DTO.RequestCancelBookingDTO;
import com.example.wetravel.DTO.UserBookingDTO;
import com.example.wetravel.Entity.Account;
import com.example.wetravel.Entity.CompanyPartner;
import com.example.wetravel.Entity.Feedback;
import com.example.wetravel.Entity.Partner;
import com.example.wetravel.Entity.ReasonCancel;
import com.example.wetravel.Entity.RequestCancel;
import com.example.wetravel.Entity.Role;
import com.example.wetravel.Entity.ServiceCategory;
import com.example.wetravel.Entity.Tour;
import com.example.wetravel.Entity.TourCategory;
import com.example.wetravel.Entity.TourDetail;
import com.example.wetravel.Entity.User;
import com.example.wetravel.Entity.UserBooking;
import com.example.wetravel.Exception.HandlerException;
import com.example.wetravel.Repository.AccountRepository;
import com.example.wetravel.Repository.ReasonCancelRepository;
import com.example.wetravel.Repository.RequestCancelRepository;
import com.example.wetravel.Repository.TourRepository;
import com.example.wetravel.Repository.UserBookingRepository;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {BookingServiceImpl.class})
@ExtendWith(SpringExtension.class)
class BookingServiceImplTest {
    @MockBean
    private AccountRepository accountRepository;

    @Autowired
    private BookingServiceImpl bookingServiceImpl;

    @MockBean
    private ReasonCancelRepository reasonCancelRepository;

    @MockBean
    private RequestCancelRepository requestCancelRepository;

    @MockBean
    private TourRepository tourRepository;

    @MockBean
    private UserBookingRepository userBookingRepository;

    /**
     * Method under test: {@link BookingServiceImpl#getListBooking(Long, Long, String, Integer, Integer)}
     */
    @Test
    void testGetListBooking() throws HandlerException {
        when(userBookingRepository.getListBooking((Long) any(), (Long) any(), (String) any(), (Pageable) any()))
                .thenReturn(new PageImpl<>(new ArrayList<>()));
        when(userBookingRepository.existsByAccountId_AccountId((Long) any())).thenReturn(true);
        assertTrue(bookingServiceImpl.getListBooking(1234567890L, 123L, "2020-03-01", 1, 3).toList().isEmpty());
        verify(userBookingRepository).existsByAccountId_AccountId((Long) any());
        verify(userBookingRepository).getListBooking((Long) any(), (Long) any(), (String) any(), (Pageable) any());
    }

    /**
     * Method under test: {@link BookingServiceImpl#getListBooking(Long, Long, String, Integer, Integer)}
     */
    @Test
    void testGetListBooking2() throws HandlerException {
        Account account = new Account();
        account.setAccountId(1234567890L);
        account.setCommentList(new ArrayList<>());
        account.setEmail("jane.doe@example.org");
        account.setFeedbackList(new ArrayList<>());
        account.setIsBlock(true);
        account.setPartner(new Partner());
        account.setPassWord("Pass Word");
        account.setRoleId(new Role());
        account.setTourList(new ArrayList<>());
        account.setUser(new User());
        account.setUserBookingList(new ArrayList<>());

        CompanyPartner companyPartner = new CompanyPartner();
        companyPartner.setAddress("42 Main St");
        companyPartner.setBusinessCode("Business Code");
        companyPartner.setCity("Oxford");
        companyPartner.setCompanyName("Company Name");
        companyPartner.setCompanyPartnerId(123L);
        companyPartner.setEmail("jane.doe@example.org");
        companyPartner.setFax("Fax");
        companyPartner.setIncorporationDate("2020-03-01");
        companyPartner.setPartnerId(new Partner());
        companyPartner.setPhone("4105551212");
        companyPartner.setRegistrationDate("2020-03-01");
        companyPartner.setShortName("Short Name");
        companyPartner.setTaxCode("Tax Code");
        companyPartner.setWebsite("Website");

        ServiceCategory serviceCategory = new ServiceCategory();
        serviceCategory.setPartnerList(new ArrayList<>());
        serviceCategory.setServiceCategoryId(123L);
        serviceCategory.setServiceCategoryName("Service Category Name");
        serviceCategory.setServiceList(new ArrayList<>());

        Partner partner = new Partner();
        partner.setAccountId(account);
        partner.setAddress("42 Main St");
        partner.setBirthDate("2020-03-01");
        partner.setCity("Oxford");
        partner.setCompanyPartnerId(companyPartner);
        partner.setDateIssue("2020-03-01");
        partner.setDepartment("Department");
        partner.setEmail("jane.doe@example.org");
        partner.setFirstName("Jane");
        partner.setGender("Gender");
        partner.setLastName("Doe");
        partner.setNumberIdCard("42");
        partner.setPartnerId(123L);
        partner.setPhone("4105551212");
        partner.setPlaceIssue("Place Issue");
        partner.setPosition("Position");
        partner.setServiceCategoryId(serviceCategory);
        partner.setServiceList(new ArrayList<>());

        Role role = new Role();
        role.setAccountList(new ArrayList<>());
        role.setRoleId(123);
        role.setRoleName("Role Name");

        Account account1 = new Account();
        account1.setAccountId(1234567890L);
        account1.setCommentList(new ArrayList<>());
        account1.setEmail("jane.doe@example.org");
        account1.setFeedbackList(new ArrayList<>());
        account1.setIsBlock(true);
        account1.setPartner(new Partner());
        account1.setPassWord("Pass Word");
        account1.setRoleId(new Role());
        account1.setTourList(new ArrayList<>());
        account1.setUser(new User());
        account1.setUserBookingList(new ArrayList<>());

        User user = new User();
        user.setAccountId(account1);
        user.setAddress("42 Main St");
        user.setBirthDate("2020-03-01");
        user.setCity("Oxford");
        user.setFirstName("Jane");
        user.setGender("Gender");
        user.setIsPrivate(true);
        user.setLastName("Doe");
        user.setPhone("4105551212");
        user.setRankPoint(1);
        user.setUserId(123L);

        Account account2 = new Account();
        account2.setAccountId(1234567890L);
        account2.setCommentList(new ArrayList<>());
        account2.setEmail("jane.doe@example.org");
        account2.setFeedbackList(new ArrayList<>());
        account2.setIsBlock(true);
        account2.setPartner(partner);
        account2.setPassWord("Pass Word");
        account2.setRoleId(role);
        account2.setTourList(new ArrayList<>());
        account2.setUser(user);
        account2.setUserBookingList(new ArrayList<>());

        Partner partner1 = new Partner();
        partner1.setAccountId(new Account());
        partner1.setAddress("42 Main St");
        partner1.setBirthDate("2020-03-01");
        partner1.setCity("Oxford");
        partner1.setCompanyPartnerId(new CompanyPartner());
        partner1.setDateIssue("2020-03-01");
        partner1.setDepartment("Department");
        partner1.setEmail("jane.doe@example.org");
        partner1.setFirstName("Jane");
        partner1.setGender("Gender");
        partner1.setLastName("Doe");
        partner1.setNumberIdCard("42");
        partner1.setPartnerId(123L);
        partner1.setPhone("4105551212");
        partner1.setPlaceIssue("Place Issue");
        partner1.setPosition("Position");
        partner1.setServiceCategoryId(new ServiceCategory());
        partner1.setServiceList(new ArrayList<>());

        Role role1 = new Role();
        role1.setAccountList(new ArrayList<>());
        role1.setRoleId(123);
        role1.setRoleName("Role Name");

        User user1 = new User();
        user1.setAccountId(new Account());
        user1.setAddress("42 Main St");
        user1.setBirthDate("2020-03-01");
        user1.setCity("Oxford");
        user1.setFirstName("Jane");
        user1.setGender("Gender");
        user1.setIsPrivate(true);
        user1.setLastName("Doe");
        user1.setPhone("4105551212");
        user1.setRankPoint(1);
        user1.setUserId(123L);

        Account account3 = new Account();
        account3.setAccountId(1234567890L);
        account3.setCommentList(new ArrayList<>());
        account3.setEmail("jane.doe@example.org");
        account3.setFeedbackList(new ArrayList<>());
        account3.setIsBlock(true);
        account3.setPartner(partner1);
        account3.setPassWord("Pass Word");
        account3.setRoleId(role1);
        account3.setTourList(new ArrayList<>());
        account3.setUser(user1);
        account3.setUserBookingList(new ArrayList<>());

        Account account4 = new Account();
        account4.setAccountId(1234567890L);
        account4.setCommentList(new ArrayList<>());
        account4.setEmail("jane.doe@example.org");
        account4.setFeedbackList(new ArrayList<>());
        account4.setIsBlock(true);
        account4.setPartner(new Partner());
        account4.setPassWord("Pass Word");
        account4.setRoleId(new Role());
        account4.setTourList(new ArrayList<>());
        account4.setUser(new User());
        account4.setUserBookingList(new ArrayList<>());

        TourCategory tourCategory = new TourCategory();
        tourCategory.setTourCategoryId(123L);
        tourCategory.setTourCategoryName("Tour Category Name");
        tourCategory.setTourList(new ArrayList<>());

        TourDetail tourDetail = new TourDetail();
        tourDetail.setAddressStart("42 Main St");
        tourDetail.setDescription("The characteristics of someone or something");
        tourDetail.setGeneralTerms("General Terms");
        tourDetail.setLatitude(10.0f);
        tourDetail.setLongitude(10.0f);
        tourDetail.setMoreDescription("More Description");
        tourDetail.setTagOfTourList(new ArrayList<>());
        tourDetail.setTourDetailId(123L);
        tourDetail.setTourId(new Tour());
        tourDetail.setTourInclude("Tour Include");
        tourDetail.setTourIntroduce("Tour Introduce");
        tourDetail.setTourNonInclude("Tour Non Include");

        Tour tour = new Tour();
        tour.setAccountId(account4);
        tour.setDeposit(10.0f);
        tour.setEndPlace("End Place");
        tour.setEndTime(LocalTime.of(1, 1));
        tour.setFeedbackList(new ArrayList<>());
        tour.setMaxAdult(3);
        tour.setMaxChildren(3);
        tour.setMinAdult(1);
        tour.setMinChildren(1);
        tour.setMinToStart(1);
        tour.setNote("Note");
        tour.setNumberOfDay(10);
        tour.setNumberOfNight(10);
        tour.setPriceAdult(10.0f);
        tour.setPriceChildren(10.0f);
        tour.setStartDate(LocalDate.ofEpochDay(1L));
        tour.setStartPlace("Start Place");
        tour.setStartTime(LocalTime.of(1, 1));
        tour.setStatus(1);
        tour.setTotalPrice(10.0f);
        tour.setTourCategoryId(tourCategory);
        tour.setTourCode("Tour Code");
        tour.setTourDetail(tourDetail);
        tour.setTourId(123L);
        tour.setTourMode(true);
        tour.setTourName("Tour Name");
        tour.setTourScheduleList(new ArrayList<>());
        tour.setTourType(1);
        tour.setUserBookingList(new ArrayList<>());

        Account account5 = new Account();
        account5.setAccountId(1234567890L);
        account5.setCommentList(new ArrayList<>());
        account5.setEmail("jane.doe@example.org");
        account5.setFeedbackList(new ArrayList<>());
        account5.setIsBlock(true);
        account5.setPartner(new Partner());
        account5.setPassWord("Pass Word");
        account5.setRoleId(new Role());
        account5.setTourList(new ArrayList<>());
        account5.setUser(new User());
        account5.setUserBookingList(new ArrayList<>());

        Feedback feedback = new Feedback();
        feedback.setAccountId(new Account());
        feedback.setContent("Not all who wander are lost");
        feedback.setCreateDate(null);
        feedback.setFeedbackId(123L);
        feedback.setIsBlock(true);
        feedback.setReportFeedbackList(new ArrayList<>());
        feedback.setTourId(new Tour());
        feedback.setUserBookingId(new UserBooking());

        Tour tour1 = new Tour();
        tour1.setAccountId(new Account());
        tour1.setDeposit(10.0f);
        tour1.setEndPlace("End Place");
        tour1.setEndTime(null);
        tour1.setFeedbackList(new ArrayList<>());
        tour1.setMaxAdult(3);
        tour1.setMaxChildren(3);
        tour1.setMinAdult(1);
        tour1.setMinChildren(1);
        tour1.setMinToStart(1);
        tour1.setNote("Note");
        tour1.setNumberOfDay(10);
        tour1.setNumberOfNight(10);
        tour1.setPriceAdult(10.0f);
        tour1.setPriceChildren(10.0f);
        tour1.setStartDate(null);
        tour1.setStartPlace("Start Place");
        tour1.setStartTime(null);
        tour1.setStatus(1);
        tour1.setTotalPrice(10.0f);
        tour1.setTourCategoryId(new TourCategory());
        tour1.setTourCode("Tour Code");
        tour1.setTourDetail(new TourDetail());
        tour1.setTourId(123L);
        tour1.setTourMode(true);
        tour1.setTourName("Tour Name");
        tour1.setTourScheduleList(new ArrayList<>());
        tour1.setTourType(1);
        tour1.setUserBookingList(new ArrayList<>());

        UserBooking userBooking = new UserBooking();
        userBooking.setAccountId(account5);
        userBooking.setAdultPrice(10.0f);
        userBooking.setBookingDate(LocalDate.ofEpochDay(1L));
        userBooking.setChildrenPrice(10.0f);
        userBooking.setDateOfIssue(LocalDate.ofEpochDay(1L));
        userBooking.setEmail("jane.doe@example.org");
        userBooking.setFeedbackId(feedback);
        userBooking.setFullName("Dr Jane Doe");
        userBooking.setIdCard("Id Card");
        userBooking.setIsFeedback(true);
        userBooking.setNumberOfAdult(10);
        userBooking.setNumberOfChildren(10);
        userBooking.setOrderId(123L);
        userBooking.setOrderTitle("Dr");
        userBooking.setPayType("Pay Type");
        userBooking.setPhone("4105551212");
        userBooking.setPlaceOfIssue("Place Of Issue");
        userBooking.setRequest("Request");
        userBooking.setRequestCancelList(new ArrayList<>());
        userBooking.setStartDate(LocalDate.ofEpochDay(1L));
        userBooking.setStatus(1);
        userBooking.setStatusDeposit(true);
        userBooking.setTotalPrice(10.0f);
        userBooking.setTourId(tour1);
        userBooking.setUserBookingId(123L);

        Feedback feedback1 = new Feedback();
        feedback1.setAccountId(account3);
        feedback1.setContent("Not all who wander are lost");
        feedback1.setCreateDate(LocalDate.ofEpochDay(1L));
        feedback1.setFeedbackId(123L);
        feedback1.setIsBlock(true);
        feedback1.setReportFeedbackList(new ArrayList<>());
        feedback1.setTourId(tour);
        feedback1.setUserBookingId(userBooking);

        Partner partner2 = new Partner();
        partner2.setAccountId(new Account());
        partner2.setAddress("42 Main St");
        partner2.setBirthDate("2020-03-01");
        partner2.setCity("Oxford");
        partner2.setCompanyPartnerId(new CompanyPartner());
        partner2.setDateIssue("2020-03-01");
        partner2.setDepartment("Department");
        partner2.setEmail("jane.doe@example.org");
        partner2.setFirstName("Jane");
        partner2.setGender("Gender");
        partner2.setLastName("Doe");
        partner2.setNumberIdCard("42");
        partner2.setPartnerId(123L);
        partner2.setPhone("4105551212");
        partner2.setPlaceIssue("Place Issue");
        partner2.setPosition("Position");
        partner2.setServiceCategoryId(new ServiceCategory());
        partner2.setServiceList(new ArrayList<>());

        Role role2 = new Role();
        role2.setAccountList(new ArrayList<>());
        role2.setRoleId(123);
        role2.setRoleName("Role Name");

        User user2 = new User();
        user2.setAccountId(new Account());
        user2.setAddress("42 Main St");
        user2.setBirthDate("2020-03-01");
        user2.setCity("Oxford");
        user2.setFirstName("Jane");
        user2.setGender("Gender");
        user2.setIsPrivate(true);
        user2.setLastName("Doe");
        user2.setPhone("4105551212");
        user2.setRankPoint(1);
        user2.setUserId(123L);

        Account account6 = new Account();
        account6.setAccountId(1234567890L);
        account6.setCommentList(new ArrayList<>());
        account6.setEmail("jane.doe@example.org");
        account6.setFeedbackList(new ArrayList<>());
        account6.setIsBlock(true);
        account6.setPartner(partner2);
        account6.setPassWord("Pass Word");
        account6.setRoleId(role2);
        account6.setTourList(new ArrayList<>());
        account6.setUser(user2);
        account6.setUserBookingList(new ArrayList<>());

        TourCategory tourCategory1 = new TourCategory();
        tourCategory1.setTourCategoryId(123L);
        tourCategory1.setTourCategoryName("Tour Category Name");
        tourCategory1.setTourList(new ArrayList<>());

        Tour tour2 = new Tour();
        tour2.setAccountId(new Account());
        tour2.setDeposit(10.0f);
        tour2.setEndPlace("End Place");
        tour2.setEndTime(null);
        tour2.setFeedbackList(new ArrayList<>());
        tour2.setMaxAdult(3);
        tour2.setMaxChildren(3);
        tour2.setMinAdult(1);
        tour2.setMinChildren(1);
        tour2.setMinToStart(1);
        tour2.setNote("Note");
        tour2.setNumberOfDay(10);
        tour2.setNumberOfNight(10);
        tour2.setPriceAdult(10.0f);
        tour2.setPriceChildren(10.0f);
        tour2.setStartDate(null);
        tour2.setStartPlace("Start Place");
        tour2.setStartTime(null);
        tour2.setStatus(1);
        tour2.setTotalPrice(10.0f);
        tour2.setTourCategoryId(new TourCategory());
        tour2.setTourCode("Tour Code");
        tour2.setTourDetail(new TourDetail());
        tour2.setTourId(123L);
        tour2.setTourMode(true);
        tour2.setTourName("Tour Name");
        tour2.setTourScheduleList(new ArrayList<>());
        tour2.setTourType(1);
        tour2.setUserBookingList(new ArrayList<>());

        TourDetail tourDetail1 = new TourDetail();
        tourDetail1.setAddressStart("42 Main St");
        tourDetail1.setDescription("The characteristics of someone or something");
        tourDetail1.setGeneralTerms("General Terms");
        tourDetail1.setLatitude(10.0f);
        tourDetail1.setLongitude(10.0f);
        tourDetail1.setMoreDescription("More Description");
        tourDetail1.setTagOfTourList(new ArrayList<>());
        tourDetail1.setTourDetailId(123L);
        tourDetail1.setTourId(tour2);
        tourDetail1.setTourInclude("Tour Include");
        tourDetail1.setTourIntroduce("Tour Introduce");
        tourDetail1.setTourNonInclude("Tour Non Include");

        Tour tour3 = new Tour();
        tour3.setAccountId(account6);
        tour3.setDeposit(10.0f);
        tour3.setEndPlace("End Place");
        tour3.setEndTime(LocalTime.of(1, 1));
        tour3.setFeedbackList(new ArrayList<>());
        tour3.setMaxAdult(3);
        tour3.setMaxChildren(3);
        tour3.setMinAdult(1);
        tour3.setMinChildren(1);
        tour3.setMinToStart(1);
        tour3.setNote("Note");
        tour3.setNumberOfDay(10);
        tour3.setNumberOfNight(10);
        tour3.setPriceAdult(10.0f);
        tour3.setPriceChildren(10.0f);
        tour3.setStartDate(LocalDate.ofEpochDay(1L));
        tour3.setStartPlace("Start Place");
        tour3.setStartTime(LocalTime.of(1, 1));
        tour3.setStatus(1);
        tour3.setTotalPrice(10.0f);
        tour3.setTourCategoryId(tourCategory1);
        tour3.setTourCode("Tour Code");
        tour3.setTourDetail(tourDetail1);
        tour3.setTourId(123L);
        tour3.setTourMode(true);
        tour3.setTourName("Tour Name");
        tour3.setTourScheduleList(new ArrayList<>());
        tour3.setTourType(1);
        tour3.setUserBookingList(new ArrayList<>());

        UserBooking userBooking1 = new UserBooking();
        userBooking1.setAccountId(account2);
        userBooking1.setAdultPrice(10.0f);
        userBooking1.setBookingDate(LocalDate.ofEpochDay(1L));
        userBooking1.setChildrenPrice(10.0f);
        userBooking1.setDateOfIssue(LocalDate.ofEpochDay(1L));
        userBooking1.setEmail("jane.doe@example.org");
        userBooking1.setFeedbackId(feedback1);
        userBooking1.setFullName("Dr Jane Doe");
        userBooking1.setIdCard("Id Card");
        userBooking1.setIsFeedback(true);
        userBooking1.setNumberOfAdult(10);
        userBooking1.setNumberOfChildren(10);
        userBooking1.setOrderId(123L);
        userBooking1.setOrderTitle("Dr");
        userBooking1.setPayType("Pay Type");
        userBooking1.setPhone("4105551212");
        userBooking1.setPlaceOfIssue("Place Of Issue");
        userBooking1.setRequest("Request");
        userBooking1.setRequestCancelList(new ArrayList<>());
        userBooking1.setStartDate(LocalDate.ofEpochDay(1L));
        userBooking1.setStatus(1);
        userBooking1.setStatusDeposit(true);
        userBooking1.setTotalPrice(10.0f);
        userBooking1.setTourId(tour3);
        userBooking1.setUserBookingId(123L);

        ArrayList<UserBooking> userBookingList = new ArrayList<>();
        userBookingList.add(userBooking1);
        PageImpl<UserBooking> pageImpl = new PageImpl<>(userBookingList);
        when(userBookingRepository.getListBooking((Long) any(), (Long) any(), (String) any(), (Pageable) any()))
                .thenReturn(pageImpl);
        when(userBookingRepository.existsByAccountId_AccountId((Long) any())).thenReturn(true);
        assertEquals(1, bookingServiceImpl.getListBooking(1234567890L, 123L, "2020-03-01", 1, 3).toList().size());
        verify(userBookingRepository).existsByAccountId_AccountId((Long) any());
        verify(userBookingRepository).getListBooking((Long) any(), (Long) any(), (String) any(), (Pageable) any());
    }

    /**
     * Method under test: {@link BookingServiceImpl#getListBooking(Long, Long, String, Integer, Integer)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testGetListBooking3() throws HandlerException {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at com.example.wetravel.Service.ServiceImpl.BookingServiceImpl.getListBooking(BookingServiceImpl.java:46)
        //   See https://diff.blue/R013 to resolve this issue.

        when(userBookingRepository.getListBooking((Long) any(), (Long) any(), (String) any(), (Pageable) any()))
                .thenReturn(null);
        when(userBookingRepository.existsByAccountId_AccountId((Long) any())).thenReturn(true);
        bookingServiceImpl.getListBooking(1234567890L, 123L, "2020-03-01", 1, 3);
    }

    /**
     * Method under test: {@link BookingServiceImpl#getListBooking(Long, Long, String, Integer, Integer)}
     */
    @Test
    void testGetListBooking4() throws HandlerException {
        when(userBookingRepository.getListBooking((Long) any(), (Long) any(), (String) any(), (Pageable) any()))
                .thenReturn(new PageImpl<>(new ArrayList<>()));
        when(userBookingRepository.existsByAccountId_AccountId((Long) any())).thenReturn(false);
        assertThrows(HandlerException.class,
                () -> bookingServiceImpl.getListBooking(1234567890L, 123L, "2020-03-01", 1, 3));
        verify(userBookingRepository).existsByAccountId_AccountId((Long) any());
    }

    /**
     * Method under test: {@link BookingServiceImpl#getListBooking(Long, Long, String, Integer, Integer)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testGetListBooking5() throws HandlerException {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.IllegalArgumentException: Page index must not be less than zero!
        //       at com.example.wetravel.Service.ServiceImpl.BookingServiceImpl.getListBooking(BookingServiceImpl.java:44)
        //   See https://diff.blue/R013 to resolve this issue.

        when(userBookingRepository.getListBooking((Long) any(), (Long) any(), (String) any(), (Pageable) any()))
                .thenReturn(new PageImpl<>(new ArrayList<>()));
        when(userBookingRepository.existsByAccountId_AccountId((Long) any())).thenReturn(true);
        bookingServiceImpl.getListBooking(1234567890L, 123L, "2020-03-01", 0, 3);
    }

    /**
     * Method under test: {@link BookingServiceImpl#createBooking(UserBookingDTO)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testCreateBooking() throws HandlerException {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at com.example.wetravel.Service.ServiceImpl.BookingServiceImpl.createBooking(BookingServiceImpl.java:86)
        //   See https://diff.blue/R013 to resolve this issue.

        BookingServiceImpl bookingServiceImpl = new BookingServiceImpl();
        bookingServiceImpl.createBooking(new UserBookingDTO());
    }

    /**
     * Method under test: {@link BookingServiceImpl#createBooking(UserBookingDTO)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testCreateBooking2() throws HandlerException {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at com.example.wetravel.Service.ServiceImpl.BookingServiceImpl.createBooking(BookingServiceImpl.java:86)
        //   See https://diff.blue/R013 to resolve this issue.

        (new BookingServiceImpl()).createBooking(null);
    }

    /**
     * Method under test: {@link BookingServiceImpl#createBooking(UserBookingDTO)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testCreateBooking3() throws HandlerException {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at com.example.wetravel.Service.ServiceImpl.BookingServiceImpl.createBooking(BookingServiceImpl.java:86)
        //   See https://diff.blue/R013 to resolve this issue.

        BookingServiceImpl bookingServiceImpl = new BookingServiceImpl();
        UserBookingDTO userBookingDTO = mock(UserBookingDTO.class);
        when(userBookingDTO.getAccountId()).thenReturn(1234567890L);
        bookingServiceImpl.createBooking(userBookingDTO);
    }

    /**
     * Method under test: {@link BookingServiceImpl#updateStatus(Long, Integer)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testUpdateStatus() throws HandlerException {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at com.example.wetravel.Service.ServiceImpl.BookingServiceImpl.updateStatus(BookingServiceImpl.java:119)
        //   See https://diff.blue/R013 to resolve this issue.

        (new BookingServiceImpl()).updateStatus(123L, 1);
    }

    /**
     * Method under test: {@link BookingServiceImpl#updateStatusDeposit(Long, Boolean)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testUpdateStatusDeposit() throws HandlerException {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at com.example.wetravel.Service.ServiceImpl.BookingServiceImpl.updateStatusDeposit(BookingServiceImpl.java:127)
        //   See https://diff.blue/R013 to resolve this issue.

        (new BookingServiceImpl()).updateStatusDeposit(123L, true);
    }

    /**
     * Method under test: {@link BookingServiceImpl#createRequestCancel(RequestCancelBookingDTO)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testCreateRequestCancel() throws HandlerException {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at com.example.wetravel.Service.ServiceImpl.BookingServiceImpl.createRequestCancel(BookingServiceImpl.java:136)
        //   See https://diff.blue/R013 to resolve this issue.

        BookingServiceImpl bookingServiceImpl = new BookingServiceImpl();
        bookingServiceImpl.createRequestCancel(new RequestCancelBookingDTO());
    }

    /**
     * Method under test: {@link BookingServiceImpl#createRequestCancel(RequestCancelBookingDTO)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testCreateRequestCancel2() throws HandlerException {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at com.example.wetravel.Service.ServiceImpl.BookingServiceImpl.createRequestCancel(BookingServiceImpl.java:136)
        //   See https://diff.blue/R013 to resolve this issue.

        (new BookingServiceImpl()).createRequestCancel(null);
    }

    /**
     * Method under test: {@link BookingServiceImpl#createRequestCancel(RequestCancelBookingDTO)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testCreateRequestCancel3() throws HandlerException {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at com.example.wetravel.Service.ServiceImpl.BookingServiceImpl.createRequestCancel(BookingServiceImpl.java:136)
        //   See https://diff.blue/R013 to resolve this issue.

        BookingServiceImpl bookingServiceImpl = new BookingServiceImpl();
        RequestCancelBookingDTO requestCancelBookingDTO = mock(RequestCancelBookingDTO.class);
        when(requestCancelBookingDTO.getUserBookingId()).thenReturn(123L);
        bookingServiceImpl.createRequestCancel(requestCancelBookingDTO);
    }

    /**
     * Method under test: {@link BookingServiceImpl#deleteRequestCancelBooking(Long)}
     */
    @Test
    void testDeleteRequestCancelBooking() throws HandlerException {
        ReasonCancel reasonCancel = new ReasonCancel();
        reasonCancel.setReasonCancelId(123L);
        reasonCancel.setReasonCancelName("Just cause");
        reasonCancel.setRequestCancelList(new ArrayList<>());

        Account account = new Account();
        account.setAccountId(1234567890L);
        account.setCommentList(new ArrayList<>());
        account.setEmail("jane.doe@example.org");
        account.setFeedbackList(new ArrayList<>());
        account.setIsBlock(true);
        account.setPartner(new Partner());
        account.setPassWord("Pass Word");
        account.setRoleId(new Role());
        account.setTourList(new ArrayList<>());
        account.setUser(new User());
        account.setUserBookingList(new ArrayList<>());

        CompanyPartner companyPartner = new CompanyPartner();
        companyPartner.setAddress("42 Main St");
        companyPartner.setBusinessCode("Business Code");
        companyPartner.setCity("Oxford");
        companyPartner.setCompanyName("Company Name");
        companyPartner.setCompanyPartnerId(123L);
        companyPartner.setEmail("jane.doe@example.org");
        companyPartner.setFax("Fax");
        companyPartner.setIncorporationDate("2020-03-01");
        companyPartner.setPartnerId(new Partner());
        companyPartner.setPhone("4105551212");
        companyPartner.setRegistrationDate("2020-03-01");
        companyPartner.setShortName("Short Name");
        companyPartner.setTaxCode("Tax Code");
        companyPartner.setWebsite("Website");

        ServiceCategory serviceCategory = new ServiceCategory();
        serviceCategory.setPartnerList(new ArrayList<>());
        serviceCategory.setServiceCategoryId(123L);
        serviceCategory.setServiceCategoryName("Service Category Name");
        serviceCategory.setServiceList(new ArrayList<>());

        Partner partner = new Partner();
        partner.setAccountId(account);
        partner.setAddress("42 Main St");
        partner.setBirthDate("2020-03-01");
        partner.setCity("Oxford");
        partner.setCompanyPartnerId(companyPartner);
        partner.setDateIssue("2020-03-01");
        partner.setDepartment("Department");
        partner.setEmail("jane.doe@example.org");
        partner.setFirstName("Jane");
        partner.setGender("Gender");
        partner.setLastName("Doe");
        partner.setNumberIdCard("42");
        partner.setPartnerId(123L);
        partner.setPhone("4105551212");
        partner.setPlaceIssue("Place Issue");
        partner.setPosition("Position");
        partner.setServiceCategoryId(serviceCategory);
        partner.setServiceList(new ArrayList<>());

        Role role = new Role();
        role.setAccountList(new ArrayList<>());
        role.setRoleId(123);
        role.setRoleName("Role Name");

        Account account1 = new Account();
        account1.setAccountId(1234567890L);
        account1.setCommentList(new ArrayList<>());
        account1.setEmail("jane.doe@example.org");
        account1.setFeedbackList(new ArrayList<>());
        account1.setIsBlock(true);
        account1.setPartner(new Partner());
        account1.setPassWord("Pass Word");
        account1.setRoleId(new Role());
        account1.setTourList(new ArrayList<>());
        account1.setUser(new User());
        account1.setUserBookingList(new ArrayList<>());

        User user = new User();
        user.setAccountId(account1);
        user.setAddress("42 Main St");
        user.setBirthDate("2020-03-01");
        user.setCity("Oxford");
        user.setFirstName("Jane");
        user.setGender("Gender");
        user.setIsPrivate(true);
        user.setLastName("Doe");
        user.setPhone("4105551212");
        user.setRankPoint(1);
        user.setUserId(123L);

        Account account2 = new Account();
        account2.setAccountId(1234567890L);
        account2.setCommentList(new ArrayList<>());
        account2.setEmail("jane.doe@example.org");
        account2.setFeedbackList(new ArrayList<>());
        account2.setIsBlock(true);
        account2.setPartner(partner);
        account2.setPassWord("Pass Word");
        account2.setRoleId(role);
        account2.setTourList(new ArrayList<>());
        account2.setUser(user);
        account2.setUserBookingList(new ArrayList<>());

        Partner partner1 = new Partner();
        partner1.setAccountId(new Account());
        partner1.setAddress("42 Main St");
        partner1.setBirthDate("2020-03-01");
        partner1.setCity("Oxford");
        partner1.setCompanyPartnerId(new CompanyPartner());
        partner1.setDateIssue("2020-03-01");
        partner1.setDepartment("Department");
        partner1.setEmail("jane.doe@example.org");
        partner1.setFirstName("Jane");
        partner1.setGender("Gender");
        partner1.setLastName("Doe");
        partner1.setNumberIdCard("42");
        partner1.setPartnerId(123L);
        partner1.setPhone("4105551212");
        partner1.setPlaceIssue("Place Issue");
        partner1.setPosition("Position");
        partner1.setServiceCategoryId(new ServiceCategory());
        partner1.setServiceList(new ArrayList<>());

        Role role1 = new Role();
        role1.setAccountList(new ArrayList<>());
        role1.setRoleId(123);
        role1.setRoleName("Role Name");

        User user1 = new User();
        user1.setAccountId(new Account());
        user1.setAddress("42 Main St");
        user1.setBirthDate("2020-03-01");
        user1.setCity("Oxford");
        user1.setFirstName("Jane");
        user1.setGender("Gender");
        user1.setIsPrivate(true);
        user1.setLastName("Doe");
        user1.setPhone("4105551212");
        user1.setRankPoint(1);
        user1.setUserId(123L);

        Account account3 = new Account();
        account3.setAccountId(1234567890L);
        account3.setCommentList(new ArrayList<>());
        account3.setEmail("jane.doe@example.org");
        account3.setFeedbackList(new ArrayList<>());
        account3.setIsBlock(true);
        account3.setPartner(partner1);
        account3.setPassWord("Pass Word");
        account3.setRoleId(role1);
        account3.setTourList(new ArrayList<>());
        account3.setUser(user1);
        account3.setUserBookingList(new ArrayList<>());

        Account account4 = new Account();
        account4.setAccountId(1234567890L);
        account4.setCommentList(new ArrayList<>());
        account4.setEmail("jane.doe@example.org");
        account4.setFeedbackList(new ArrayList<>());
        account4.setIsBlock(true);
        account4.setPartner(new Partner());
        account4.setPassWord("Pass Word");
        account4.setRoleId(new Role());
        account4.setTourList(new ArrayList<>());
        account4.setUser(new User());
        account4.setUserBookingList(new ArrayList<>());

        TourCategory tourCategory = new TourCategory();
        tourCategory.setTourCategoryId(123L);
        tourCategory.setTourCategoryName("Tour Category Name");
        tourCategory.setTourList(new ArrayList<>());

        TourDetail tourDetail = new TourDetail();
        tourDetail.setAddressStart("42 Main St");
        tourDetail.setDescription("The characteristics of someone or something");
        tourDetail.setGeneralTerms("General Terms");
        tourDetail.setLatitude(10.0f);
        tourDetail.setLongitude(10.0f);
        tourDetail.setMoreDescription("More Description");
        tourDetail.setTagOfTourList(new ArrayList<>());
        tourDetail.setTourDetailId(123L);
        tourDetail.setTourId(new Tour());
        tourDetail.setTourInclude("Tour Include");
        tourDetail.setTourIntroduce("Tour Introduce");
        tourDetail.setTourNonInclude("Tour Non Include");

        Tour tour = new Tour();
        tour.setAccountId(account4);
        tour.setDeposit(10.0f);
        tour.setEndPlace("End Place");
        tour.setEndTime(LocalTime.of(1, 1));
        tour.setFeedbackList(new ArrayList<>());
        tour.setMaxAdult(3);
        tour.setMaxChildren(3);
        tour.setMinAdult(1);
        tour.setMinChildren(1);
        tour.setMinToStart(1);
        tour.setNote("Note");
        tour.setNumberOfDay(10);
        tour.setNumberOfNight(10);
        tour.setPriceAdult(10.0f);
        tour.setPriceChildren(10.0f);
        tour.setStartDate(LocalDate.ofEpochDay(1L));
        tour.setStartPlace("Start Place");
        tour.setStartTime(LocalTime.of(1, 1));
        tour.setStatus(1);
        tour.setTotalPrice(10.0f);
        tour.setTourCategoryId(tourCategory);
        tour.setTourCode("Tour Code");
        tour.setTourDetail(tourDetail);
        tour.setTourId(123L);
        tour.setTourMode(true);
        tour.setTourName("Tour Name");
        tour.setTourScheduleList(new ArrayList<>());
        tour.setTourType(1);
        tour.setUserBookingList(new ArrayList<>());

        Account account5 = new Account();
        account5.setAccountId(1234567890L);
        account5.setCommentList(new ArrayList<>());
        account5.setEmail("jane.doe@example.org");
        account5.setFeedbackList(new ArrayList<>());
        account5.setIsBlock(true);
        account5.setPartner(new Partner());
        account5.setPassWord("Pass Word");
        account5.setRoleId(new Role());
        account5.setTourList(new ArrayList<>());
        account5.setUser(new User());
        account5.setUserBookingList(new ArrayList<>());

        Feedback feedback = new Feedback();
        feedback.setAccountId(new Account());
        feedback.setContent("Not all who wander are lost");
        feedback.setCreateDate(null);
        feedback.setFeedbackId(123L);
        feedback.setIsBlock(true);
        feedback.setReportFeedbackList(new ArrayList<>());
        feedback.setTourId(new Tour());
        feedback.setUserBookingId(new UserBooking());

        Tour tour1 = new Tour();
        tour1.setAccountId(new Account());
        tour1.setDeposit(10.0f);
        tour1.setEndPlace("End Place");
        tour1.setEndTime(null);
        tour1.setFeedbackList(new ArrayList<>());
        tour1.setMaxAdult(3);
        tour1.setMaxChildren(3);
        tour1.setMinAdult(1);
        tour1.setMinChildren(1);
        tour1.setMinToStart(1);
        tour1.setNote("Note");
        tour1.setNumberOfDay(10);
        tour1.setNumberOfNight(10);
        tour1.setPriceAdult(10.0f);
        tour1.setPriceChildren(10.0f);
        tour1.setStartDate(null);
        tour1.setStartPlace("Start Place");
        tour1.setStartTime(null);
        tour1.setStatus(1);
        tour1.setTotalPrice(10.0f);
        tour1.setTourCategoryId(new TourCategory());
        tour1.setTourCode("Tour Code");
        tour1.setTourDetail(new TourDetail());
        tour1.setTourId(123L);
        tour1.setTourMode(true);
        tour1.setTourName("Tour Name");
        tour1.setTourScheduleList(new ArrayList<>());
        tour1.setTourType(1);
        tour1.setUserBookingList(new ArrayList<>());

        UserBooking userBooking = new UserBooking();
        userBooking.setAccountId(account5);
        userBooking.setAdultPrice(10.0f);
        userBooking.setBookingDate(LocalDate.ofEpochDay(1L));
        userBooking.setChildrenPrice(10.0f);
        userBooking.setDateOfIssue(LocalDate.ofEpochDay(1L));
        userBooking.setEmail("jane.doe@example.org");
        userBooking.setFeedbackId(feedback);
        userBooking.setFullName("Dr Jane Doe");
        userBooking.setIdCard("Id Card");
        userBooking.setIsFeedback(true);
        userBooking.setNumberOfAdult(10);
        userBooking.setNumberOfChildren(10);
        userBooking.setOrderId(123L);
        userBooking.setOrderTitle("Dr");
        userBooking.setPayType("Pay Type");
        userBooking.setPhone("4105551212");
        userBooking.setPlaceOfIssue("Place Of Issue");
        userBooking.setRequest("Request");
        userBooking.setRequestCancelList(new ArrayList<>());
        userBooking.setStartDate(LocalDate.ofEpochDay(1L));
        userBooking.setStatus(1);
        userBooking.setStatusDeposit(true);
        userBooking.setTotalPrice(10.0f);
        userBooking.setTourId(tour1);
        userBooking.setUserBookingId(123L);

        Feedback feedback1 = new Feedback();
        feedback1.setAccountId(account3);
        feedback1.setContent("Not all who wander are lost");
        feedback1.setCreateDate(LocalDate.ofEpochDay(1L));
        feedback1.setFeedbackId(123L);
        feedback1.setIsBlock(true);
        feedback1.setReportFeedbackList(new ArrayList<>());
        feedback1.setTourId(tour);
        feedback1.setUserBookingId(userBooking);

        Partner partner2 = new Partner();
        partner2.setAccountId(new Account());
        partner2.setAddress("42 Main St");
        partner2.setBirthDate("2020-03-01");
        partner2.setCity("Oxford");
        partner2.setCompanyPartnerId(new CompanyPartner());
        partner2.setDateIssue("2020-03-01");
        partner2.setDepartment("Department");
        partner2.setEmail("jane.doe@example.org");
        partner2.setFirstName("Jane");
        partner2.setGender("Gender");
        partner2.setLastName("Doe");
        partner2.setNumberIdCard("42");
        partner2.setPartnerId(123L);
        partner2.setPhone("4105551212");
        partner2.setPlaceIssue("Place Issue");
        partner2.setPosition("Position");
        partner2.setServiceCategoryId(new ServiceCategory());
        partner2.setServiceList(new ArrayList<>());

        Role role2 = new Role();
        role2.setAccountList(new ArrayList<>());
        role2.setRoleId(123);
        role2.setRoleName("Role Name");

        User user2 = new User();
        user2.setAccountId(new Account());
        user2.setAddress("42 Main St");
        user2.setBirthDate("2020-03-01");
        user2.setCity("Oxford");
        user2.setFirstName("Jane");
        user2.setGender("Gender");
        user2.setIsPrivate(true);
        user2.setLastName("Doe");
        user2.setPhone("4105551212");
        user2.setRankPoint(1);
        user2.setUserId(123L);

        Account account6 = new Account();
        account6.setAccountId(1234567890L);
        account6.setCommentList(new ArrayList<>());
        account6.setEmail("jane.doe@example.org");
        account6.setFeedbackList(new ArrayList<>());
        account6.setIsBlock(true);
        account6.setPartner(partner2);
        account6.setPassWord("Pass Word");
        account6.setRoleId(role2);
        account6.setTourList(new ArrayList<>());
        account6.setUser(user2);
        account6.setUserBookingList(new ArrayList<>());

        TourCategory tourCategory1 = new TourCategory();
        tourCategory1.setTourCategoryId(123L);
        tourCategory1.setTourCategoryName("Tour Category Name");
        tourCategory1.setTourList(new ArrayList<>());

        Tour tour2 = new Tour();
        tour2.setAccountId(new Account());
        tour2.setDeposit(10.0f);
        tour2.setEndPlace("End Place");
        tour2.setEndTime(null);
        tour2.setFeedbackList(new ArrayList<>());
        tour2.setMaxAdult(3);
        tour2.setMaxChildren(3);
        tour2.setMinAdult(1);
        tour2.setMinChildren(1);
        tour2.setMinToStart(1);
        tour2.setNote("Note");
        tour2.setNumberOfDay(10);
        tour2.setNumberOfNight(10);
        tour2.setPriceAdult(10.0f);
        tour2.setPriceChildren(10.0f);
        tour2.setStartDate(null);
        tour2.setStartPlace("Start Place");
        tour2.setStartTime(null);
        tour2.setStatus(1);
        tour2.setTotalPrice(10.0f);
        tour2.setTourCategoryId(new TourCategory());
        tour2.setTourCode("Tour Code");
        tour2.setTourDetail(new TourDetail());
        tour2.setTourId(123L);
        tour2.setTourMode(true);
        tour2.setTourName("Tour Name");
        tour2.setTourScheduleList(new ArrayList<>());
        tour2.setTourType(1);
        tour2.setUserBookingList(new ArrayList<>());

        TourDetail tourDetail1 = new TourDetail();
        tourDetail1.setAddressStart("42 Main St");
        tourDetail1.setDescription("The characteristics of someone or something");
        tourDetail1.setGeneralTerms("General Terms");
        tourDetail1.setLatitude(10.0f);
        tourDetail1.setLongitude(10.0f);
        tourDetail1.setMoreDescription("More Description");
        tourDetail1.setTagOfTourList(new ArrayList<>());
        tourDetail1.setTourDetailId(123L);
        tourDetail1.setTourId(tour2);
        tourDetail1.setTourInclude("Tour Include");
        tourDetail1.setTourIntroduce("Tour Introduce");
        tourDetail1.setTourNonInclude("Tour Non Include");

        Tour tour3 = new Tour();
        tour3.setAccountId(account6);
        tour3.setDeposit(10.0f);
        tour3.setEndPlace("End Place");
        tour3.setEndTime(LocalTime.of(1, 1));
        tour3.setFeedbackList(new ArrayList<>());
        tour3.setMaxAdult(3);
        tour3.setMaxChildren(3);
        tour3.setMinAdult(1);
        tour3.setMinChildren(1);
        tour3.setMinToStart(1);
        tour3.setNote("Note");
        tour3.setNumberOfDay(10);
        tour3.setNumberOfNight(10);
        tour3.setPriceAdult(10.0f);
        tour3.setPriceChildren(10.0f);
        tour3.setStartDate(LocalDate.ofEpochDay(1L));
        tour3.setStartPlace("Start Place");
        tour3.setStartTime(LocalTime.of(1, 1));
        tour3.setStatus(1);
        tour3.setTotalPrice(10.0f);
        tour3.setTourCategoryId(tourCategory1);
        tour3.setTourCode("Tour Code");
        tour3.setTourDetail(tourDetail1);
        tour3.setTourId(123L);
        tour3.setTourMode(true);
        tour3.setTourName("Tour Name");
        tour3.setTourScheduleList(new ArrayList<>());
        tour3.setTourType(1);
        tour3.setUserBookingList(new ArrayList<>());

        UserBooking userBooking1 = new UserBooking();
        userBooking1.setAccountId(account2);
        userBooking1.setAdultPrice(10.0f);
        userBooking1.setBookingDate(LocalDate.ofEpochDay(1L));
        userBooking1.setChildrenPrice(10.0f);
        userBooking1.setDateOfIssue(LocalDate.ofEpochDay(1L));
        userBooking1.setEmail("jane.doe@example.org");
        userBooking1.setFeedbackId(feedback1);
        userBooking1.setFullName("Dr Jane Doe");
        userBooking1.setIdCard("Id Card");
        userBooking1.setIsFeedback(true);
        userBooking1.setNumberOfAdult(10);
        userBooking1.setNumberOfChildren(10);
        userBooking1.setOrderId(123L);
        userBooking1.setOrderTitle("Dr");
        userBooking1.setPayType("Pay Type");
        userBooking1.setPhone("4105551212");
        userBooking1.setPlaceOfIssue("Place Of Issue");
        userBooking1.setRequest("Request");
        userBooking1.setRequestCancelList(new ArrayList<>());
        userBooking1.setStartDate(LocalDate.ofEpochDay(1L));
        userBooking1.setStatus(1);
        userBooking1.setStatusDeposit(true);
        userBooking1.setTotalPrice(10.0f);
        userBooking1.setTourId(tour3);
        userBooking1.setUserBookingId(123L);

        RequestCancel requestCancel = new RequestCancel();
        requestCancel.setDescription("The characteristics of someone or something");
        requestCancel.setReasonCancelId(reasonCancel);
        requestCancel.setRequestCancelId(123L);
        requestCancel.setRequestDate(LocalDate.ofEpochDay(1L));
        requestCancel.setStatus(1);
        requestCancel.setUserBookingId(userBooking1);
        when(requestCancelRepository.getById((Long) any())).thenReturn(requestCancel);
        doNothing().when(requestCancelRepository).delete((RequestCancel) any());
        when(requestCancelRepository.existsRequestCancelByRequestCancelId((Long) any())).thenReturn(true);
        assertTrue(bookingServiceImpl.deleteRequestCancelBooking(123L));
        verify(requestCancelRepository).existsRequestCancelByRequestCancelId((Long) any());
        verify(requestCancelRepository).getById((Long) any());
        verify(requestCancelRepository).delete((RequestCancel) any());
    }
}


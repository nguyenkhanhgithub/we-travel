package com.example.wetravel.Entity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

import org.junit.jupiter.api.Test;

class TagOfTourTest {
    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link TagOfTour#TagOfTour()}
     *   <li>{@link TagOfTour#setTagId(Tag)}
     *   <li>{@link TagOfTour#setTagOfTourId(Long)}
     *   <li>{@link TagOfTour#setTourDetailId(TourDetail)}
     *   <li>{@link TagOfTour#getTagId()}
     *   <li>{@link TagOfTour#getTagOfTourId()}
     *   <li>{@link TagOfTour#getTourDetailId()}
     * </ul>
     */
    @Test
    void testConstructor() {
        TagOfTour actualTagOfTour = new TagOfTour();
        Tag tag = new Tag();
        tag.setTagId(123L);
        tag.setTagName("Tag Name");
        tag.setTagOfTourList(new ArrayList<>());
        actualTagOfTour.setTagId(tag);
        actualTagOfTour.setTagOfTourId(123L);
        Partner partner = new Partner();
        partner.setAccountId(new Account());
        partner.setAddress("42 Main St");
        partner.setBirthDate("2020-03-01");
        partner.setCity("Oxford");
        partner.setCompanyPartnerId(new CompanyPartner());
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
        partner.setServiceCategoryId(new ServiceCategory());
        partner.setServiceList(new ArrayList<>());
        Role role = new Role();
        role.setAccountList(new ArrayList<>());
        role.setRoleId(123);
        role.setRoleName("Role Name");
        User user = new User();
        user.setAccountId(new Account());
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
        Account account = new Account();
        account.setAccountId(1234567890L);
        account.setCommentList(new ArrayList<>());
        account.setEmail("jane.doe@example.org");
        account.setFeedbackList(new ArrayList<>());
        account.setIsBlock(true);
        account.setPartner(partner);
        account.setPassWord("Pass Word");
        account.setRoleId(role);
        account.setTourList(new ArrayList<>());
        account.setUser(user);
        account.setUserBookingList(new ArrayList<>());
        TourCategory tourCategory = new TourCategory();
        tourCategory.setTourCategoryId(123L);
        tourCategory.setTourCategoryName("Tour Category Name");
        tourCategory.setTourList(new ArrayList<>());
        Tour tour = new Tour();
        tour.setAccountId(new Account());
        tour.setDeposit(10.0f);
        tour.setEndPlace("End Place");
        tour.setEndTime(null);
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
        tour.setStartDate(null);
        tour.setStartPlace("Start Place");
        tour.setStartTime(null);
        tour.setStatus(1);
        tour.setTotalPrice(10.0f);
        tour.setTourCategoryId(new TourCategory());
        tour.setTourCode("Tour Code");
        tour.setTourDetail(new TourDetail());
        tour.setTourId(123L);
        tour.setTourMode(true);
        tour.setTourName("Tour Name");
        tour.setTourScheduleList(new ArrayList<>());
        tour.setTourType(1);
        tour.setUserBookingList(new ArrayList<>());
        TourDetail tourDetail = new TourDetail();
        tourDetail.setAddressStart("42 Main St");
        tourDetail.setDescription("The characteristics of someone or something");
        tourDetail.setGeneralTerms("General Terms");
        tourDetail.setLatitude(10.0f);
        tourDetail.setLongitude(10.0f);
        tourDetail.setMoreDescription("More Description");
        tourDetail.setTagOfTourList(new ArrayList<>());
        tourDetail.setTourDetailId(123L);
        tourDetail.setTourId(tour);
        tourDetail.setTourInclude("Tour Include");
        tourDetail.setTourIntroduce("Tour Introduce");
        tourDetail.setTourNonInclude("Tour Non Include");
        Tour tour1 = new Tour();
        tour1.setAccountId(account);
        tour1.setDeposit(10.0f);
        tour1.setEndPlace("End Place");
        tour1.setEndTime(LocalTime.of(1, 1));
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
        tour1.setStartDate(LocalDate.ofEpochDay(1L));
        tour1.setStartPlace("Start Place");
        tour1.setStartTime(LocalTime.of(1, 1));
        tour1.setStatus(1);
        tour1.setTotalPrice(10.0f);
        tour1.setTourCategoryId(tourCategory);
        tour1.setTourCode("Tour Code");
        tour1.setTourDetail(tourDetail);
        tour1.setTourId(123L);
        tour1.setTourMode(true);
        tour1.setTourName("Tour Name");
        tour1.setTourScheduleList(new ArrayList<>());
        tour1.setTourType(1);
        tour1.setUserBookingList(new ArrayList<>());
        TourDetail tourDetail1 = new TourDetail();
        tourDetail1.setAddressStart("42 Main St");
        tourDetail1.setDescription("The characteristics of someone or something");
        tourDetail1.setGeneralTerms("General Terms");
        tourDetail1.setLatitude(10.0f);
        tourDetail1.setLongitude(10.0f);
        tourDetail1.setMoreDescription("More Description");
        tourDetail1.setTagOfTourList(new ArrayList<>());
        tourDetail1.setTourDetailId(123L);
        tourDetail1.setTourId(tour1);
        tourDetail1.setTourInclude("Tour Include");
        tourDetail1.setTourIntroduce("Tour Introduce");
        tourDetail1.setTourNonInclude("Tour Non Include");
        actualTagOfTour.setTourDetailId(tourDetail1);
        assertSame(tag, actualTagOfTour.getTagId());
        assertEquals(123L, actualTagOfTour.getTagOfTourId().longValue());
        assertSame(tourDetail1, actualTagOfTour.getTourDetailId());
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link TagOfTour#TagOfTour(Long, Tag, TourDetail)}
     *   <li>{@link TagOfTour#setTagId(Tag)}
     *   <li>{@link TagOfTour#setTagOfTourId(Long)}
     *   <li>{@link TagOfTour#setTourDetailId(TourDetail)}
     *   <li>{@link TagOfTour#getTagId()}
     *   <li>{@link TagOfTour#getTagOfTourId()}
     *   <li>{@link TagOfTour#getTourDetailId()}
     * </ul>
     */
    @Test
    void testConstructor2() {
        Tag tag = new Tag();
        tag.setTagId(123L);
        tag.setTagName("Tag Name");
        tag.setTagOfTourList(new ArrayList<>());

        Partner partner = new Partner();
        partner.setAccountId(new Account());
        partner.setAddress("42 Main St");
        partner.setBirthDate("2020-03-01");
        partner.setCity("Oxford");
        partner.setCompanyPartnerId(new CompanyPartner());
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
        partner.setServiceCategoryId(new ServiceCategory());
        partner.setServiceList(new ArrayList<>());

        Role role = new Role();
        role.setAccountList(new ArrayList<>());
        role.setRoleId(123);
        role.setRoleName("Role Name");

        User user = new User();
        user.setAccountId(new Account());
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

        Account account = new Account();
        account.setAccountId(1234567890L);
        account.setCommentList(new ArrayList<>());
        account.setEmail("jane.doe@example.org");
        account.setFeedbackList(new ArrayList<>());
        account.setIsBlock(true);
        account.setPartner(partner);
        account.setPassWord("Pass Word");
        account.setRoleId(role);
        account.setTourList(new ArrayList<>());
        account.setUser(user);
        account.setUserBookingList(new ArrayList<>());

        TourCategory tourCategory = new TourCategory();
        tourCategory.setTourCategoryId(123L);
        tourCategory.setTourCategoryName("Tour Category Name");
        tourCategory.setTourList(new ArrayList<>());

        Tour tour = new Tour();
        tour.setAccountId(new Account());
        tour.setDeposit(10.0f);
        tour.setEndPlace("End Place");
        tour.setEndTime(null);
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
        tour.setStartDate(null);
        tour.setStartPlace("Start Place");
        tour.setStartTime(null);
        tour.setStatus(1);
        tour.setTotalPrice(10.0f);
        tour.setTourCategoryId(new TourCategory());
        tour.setTourCode("Tour Code");
        tour.setTourDetail(new TourDetail());
        tour.setTourId(123L);
        tour.setTourMode(true);
        tour.setTourName("Tour Name");
        tour.setTourScheduleList(new ArrayList<>());
        tour.setTourType(1);
        tour.setUserBookingList(new ArrayList<>());

        TourDetail tourDetail = new TourDetail();
        tourDetail.setAddressStart("42 Main St");
        tourDetail.setDescription("The characteristics of someone or something");
        tourDetail.setGeneralTerms("General Terms");
        tourDetail.setLatitude(10.0f);
        tourDetail.setLongitude(10.0f);
        tourDetail.setMoreDescription("More Description");
        tourDetail.setTagOfTourList(new ArrayList<>());
        tourDetail.setTourDetailId(123L);
        tourDetail.setTourId(tour);
        tourDetail.setTourInclude("Tour Include");
        tourDetail.setTourIntroduce("Tour Introduce");
        tourDetail.setTourNonInclude("Tour Non Include");

        Tour tour1 = new Tour();
        tour1.setAccountId(account);
        tour1.setDeposit(10.0f);
        tour1.setEndPlace("End Place");
        tour1.setEndTime(LocalTime.of(1, 1));
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
        tour1.setStartDate(LocalDate.ofEpochDay(1L));
        tour1.setStartPlace("Start Place");
        tour1.setStartTime(LocalTime.of(1, 1));
        tour1.setStatus(1);
        tour1.setTotalPrice(10.0f);
        tour1.setTourCategoryId(tourCategory);
        tour1.setTourCode("Tour Code");
        tour1.setTourDetail(tourDetail);
        tour1.setTourId(123L);
        tour1.setTourMode(true);
        tour1.setTourName("Tour Name");
        tour1.setTourScheduleList(new ArrayList<>());
        tour1.setTourType(1);
        tour1.setUserBookingList(new ArrayList<>());

        TourDetail tourDetail1 = new TourDetail();
        tourDetail1.setAddressStart("42 Main St");
        tourDetail1.setDescription("The characteristics of someone or something");
        tourDetail1.setGeneralTerms("General Terms");
        tourDetail1.setLatitude(10.0f);
        tourDetail1.setLongitude(10.0f);
        tourDetail1.setMoreDescription("More Description");
        tourDetail1.setTagOfTourList(new ArrayList<>());
        tourDetail1.setTourDetailId(123L);
        tourDetail1.setTourId(tour1);
        tourDetail1.setTourInclude("Tour Include");
        tourDetail1.setTourIntroduce("Tour Introduce");
        tourDetail1.setTourNonInclude("Tour Non Include");
        TagOfTour actualTagOfTour = new TagOfTour(123L, tag, tourDetail1);
        Tag tag1 = new Tag();
        tag1.setTagId(123L);
        tag1.setTagName("Tag Name");
        tag1.setTagOfTourList(new ArrayList<>());
        actualTagOfTour.setTagId(tag1);
        actualTagOfTour.setTagOfTourId(123L);
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
        Account account1 = new Account();
        account1.setAccountId(1234567890L);
        account1.setCommentList(new ArrayList<>());
        account1.setEmail("jane.doe@example.org");
        account1.setFeedbackList(new ArrayList<>());
        account1.setIsBlock(true);
        account1.setPartner(partner1);
        account1.setPassWord("Pass Word");
        account1.setRoleId(role1);
        account1.setTourList(new ArrayList<>());
        account1.setUser(user1);
        account1.setUserBookingList(new ArrayList<>());
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
        TourDetail tourDetail2 = new TourDetail();
        tourDetail2.setAddressStart("42 Main St");
        tourDetail2.setDescription("The characteristics of someone or something");
        tourDetail2.setGeneralTerms("General Terms");
        tourDetail2.setLatitude(10.0f);
        tourDetail2.setLongitude(10.0f);
        tourDetail2.setMoreDescription("More Description");
        tourDetail2.setTagOfTourList(new ArrayList<>());
        tourDetail2.setTourDetailId(123L);
        tourDetail2.setTourId(tour2);
        tourDetail2.setTourInclude("Tour Include");
        tourDetail2.setTourIntroduce("Tour Introduce");
        tourDetail2.setTourNonInclude("Tour Non Include");
        Tour tour3 = new Tour();
        tour3.setAccountId(account1);
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
        tour3.setTourDetail(tourDetail2);
        tour3.setTourId(123L);
        tour3.setTourMode(true);
        tour3.setTourName("Tour Name");
        tour3.setTourScheduleList(new ArrayList<>());
        tour3.setTourType(1);
        tour3.setUserBookingList(new ArrayList<>());
        TourDetail tourDetail3 = new TourDetail();
        tourDetail3.setAddressStart("42 Main St");
        tourDetail3.setDescription("The characteristics of someone or something");
        tourDetail3.setGeneralTerms("General Terms");
        tourDetail3.setLatitude(10.0f);
        tourDetail3.setLongitude(10.0f);
        tourDetail3.setMoreDescription("More Description");
        tourDetail3.setTagOfTourList(new ArrayList<>());
        tourDetail3.setTourDetailId(123L);
        tourDetail3.setTourId(tour3);
        tourDetail3.setTourInclude("Tour Include");
        tourDetail3.setTourIntroduce("Tour Introduce");
        tourDetail3.setTourNonInclude("Tour Non Include");
        actualTagOfTour.setTourDetailId(tourDetail3);
        assertSame(tag1, actualTagOfTour.getTagId());
        assertEquals(123L, actualTagOfTour.getTagOfTourId().longValue());
        assertSame(tourDetail3, actualTagOfTour.getTourDetailId());
    }
}


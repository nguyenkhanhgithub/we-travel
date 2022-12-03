package com.example.wetravel.Entity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

import org.junit.jupiter.api.Test;

class RoomTest {
    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link Room#Room()}
     *   <li>{@link Room#setAccommodationId(Accommodation)}
     *   <li>{@link Room#setArea(Float)}
     *   <li>{@link Room#setBedType(String)}
     *   <li>{@link Room#setDailyPrice(Float)}
     *   <li>{@link Room#setDescription(String)}
     *   <li>{@link Room#setHolidayPrice(Float)}
     *   <li>{@link Room#setNumberOfPeople(Integer)}
     *   <li>{@link Room#setNumberRooms(Integer)}
     *   <li>{@link Room#setRoomId(Long)}
     *   <li>{@link Room#setRoomName(String)}
     *   <li>{@link Room#setRoomType(String)}
     *   <li>{@link Room#getAccommodationId()}
     *   <li>{@link Room#getArea()}
     *   <li>{@link Room#getBedType()}
     *   <li>{@link Room#getDailyPrice()}
     *   <li>{@link Room#getDescription()}
     *   <li>{@link Room#getHolidayPrice()}
     *   <li>{@link Room#getNumberOfPeople()}
     *   <li>{@link Room#getNumberRooms()}
     *   <li>{@link Room#getRoomId()}
     *   <li>{@link Room#getRoomName()}
     *   <li>{@link Room#getRoomType()}
     * </ul>
     */
    @Test
    void testConstructor() {
        Room actualRoom = new Room();
        Service service = new Service();
        service.setAccommodation(new Accommodation());
        service.setAddress("42 Main St");
        service.setCity("Oxford");
        service.setDateRegister(null);
        service.setEmail("jane.doe@example.org");
        service.setEntertainment(new Entertainment());
        service.setFax("Fax");
        service.setIsActive(true);
        service.setIsBlock(true);
        service.setLink("Link");
        service.setPartnerId(new Partner());
        service.setPhone("4105551212");
        service.setPostList(new ArrayList<>());
        service.setRestaurant(new Restaurant());
        service.setServiceCategoryId(new ServiceCategory());
        service.setServiceId(123L);
        service.setServiceName("Service Name");
        service.setStatus(1);
        service.setTaxCode("Tax Code");
        service.setUtilitiesServiceList(new ArrayList<>());
        Accommodation accommodation = new Accommodation();
        accommodation.setAccommodationId(123L);
        accommodation.setAccommodationType("Accommodation Type");
        accommodation.setDescription("The characteristics of someone or something");
        accommodation.setNumberFloors(10);
        accommodation.setRate(10.0f);
        accommodation.setRoomList(new ArrayList<>());
        accommodation.setServiceId(service);
        Service service1 = new Service();
        service1.setAccommodation(new Accommodation());
        service1.setAddress("42 Main St");
        service1.setCity("Oxford");
        service1.setDateRegister(null);
        service1.setEmail("jane.doe@example.org");
        service1.setEntertainment(new Entertainment());
        service1.setFax("Fax");
        service1.setIsActive(true);
        service1.setIsBlock(true);
        service1.setLink("Link");
        service1.setPartnerId(new Partner());
        service1.setPhone("4105551212");
        service1.setPostList(new ArrayList<>());
        service1.setRestaurant(new Restaurant());
        service1.setServiceCategoryId(new ServiceCategory());
        service1.setServiceId(123L);
        service1.setServiceName("Service Name");
        service1.setStatus(1);
        service1.setTaxCode("Tax Code");
        service1.setUtilitiesServiceList(new ArrayList<>());
        Entertainment entertainment = new Entertainment();
        entertainment.setDescription("The characteristics of someone or something");
        entertainment.setDowOpen("Dow Open");
        entertainment.setEntertainmentId(123L);
        entertainment.setEntertainmentType("Entertainment Type");
        entertainment.setPriceTicketAdult(10.0f);
        entertainment.setPriceTicketChildren(10.0f);
        entertainment.setServiceId(service1);
        entertainment.setTimeClose(LocalTime.of(1, 1));
        entertainment.setTimeOpen(LocalTime.of(1, 1));
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
        Service service2 = new Service();
        service2.setAccommodation(new Accommodation());
        service2.setAddress("42 Main St");
        service2.setCity("Oxford");
        service2.setDateRegister(null);
        service2.setEmail("jane.doe@example.org");
        service2.setEntertainment(new Entertainment());
        service2.setFax("Fax");
        service2.setIsActive(true);
        service2.setIsBlock(true);
        service2.setLink("Link");
        service2.setPartnerId(new Partner());
        service2.setPhone("4105551212");
        service2.setPostList(new ArrayList<>());
        service2.setRestaurant(new Restaurant());
        service2.setServiceCategoryId(new ServiceCategory());
        service2.setServiceId(123L);
        service2.setServiceName("Service Name");
        service2.setStatus(1);
        service2.setTaxCode("Tax Code");
        service2.setUtilitiesServiceList(new ArrayList<>());
        Restaurant restaurant = new Restaurant();
        restaurant.setDescription("The characteristics of someone or something");
        restaurant.setRate(10.0f);
        restaurant.setRestaurantId(123L);
        restaurant.setRestaurantServiceType("Restaurant Service Type");
        restaurant.setServiceId(service2);
        restaurant.setTimeClose(LocalTime.of(1, 1));
        restaurant.setTimeOpen(LocalTime.of(1, 1));
        restaurant.setTypeOfCuisineServiceList(new ArrayList<>());
        ServiceCategory serviceCategory1 = new ServiceCategory();
        serviceCategory1.setPartnerList(new ArrayList<>());
        serviceCategory1.setServiceCategoryId(123L);
        serviceCategory1.setServiceCategoryName("Service Category Name");
        serviceCategory1.setServiceList(new ArrayList<>());
        Service service3 = new Service();
        service3.setAccommodation(accommodation);
        service3.setAddress("42 Main St");
        service3.setCity("Oxford");
        service3.setDateRegister(LocalDate.ofEpochDay(1L));
        service3.setEmail("jane.doe@example.org");
        service3.setEntertainment(entertainment);
        service3.setFax("Fax");
        service3.setIsActive(true);
        service3.setIsBlock(true);
        service3.setLink("Link");
        service3.setPartnerId(partner);
        service3.setPhone("4105551212");
        service3.setPostList(new ArrayList<>());
        service3.setRestaurant(restaurant);
        service3.setServiceCategoryId(serviceCategory1);
        service3.setServiceId(123L);
        service3.setServiceName("Service Name");
        service3.setStatus(1);
        service3.setTaxCode("Tax Code");
        service3.setUtilitiesServiceList(new ArrayList<>());
        Accommodation accommodation1 = new Accommodation();
        accommodation1.setAccommodationId(123L);
        accommodation1.setAccommodationType("Accommodation Type");
        accommodation1.setDescription("The characteristics of someone or something");
        accommodation1.setNumberFloors(10);
        accommodation1.setRate(10.0f);
        accommodation1.setRoomList(new ArrayList<>());
        accommodation1.setServiceId(service3);
        actualRoom.setAccommodationId(accommodation1);
        actualRoom.setArea(10.0f);
        actualRoom.setBedType("Bed Type");
        actualRoom.setDailyPrice(10.0f);
        actualRoom.setDescription("The characteristics of someone or something");
        actualRoom.setHolidayPrice(10.0f);
        actualRoom.setNumberOfPeople(10);
        actualRoom.setNumberRooms(1000);
        actualRoom.setRoomId(123L);
        actualRoom.setRoomName("Room Name");
        actualRoom.setRoomType("Room Type");
        assertSame(accommodation1, actualRoom.getAccommodationId());
        assertEquals(10.0f, actualRoom.getArea().floatValue());
        assertEquals("Bed Type", actualRoom.getBedType());
        assertEquals(10.0f, actualRoom.getDailyPrice().floatValue());
        assertEquals("The characteristics of someone or something", actualRoom.getDescription());
        assertEquals(10.0f, actualRoom.getHolidayPrice().floatValue());
        assertEquals(10, actualRoom.getNumberOfPeople().intValue());
        assertEquals(1000, actualRoom.getNumberRooms().intValue());
        assertEquals(123L, actualRoom.getRoomId().longValue());
        assertEquals("Room Name", actualRoom.getRoomName());
        assertEquals("Room Type", actualRoom.getRoomType());
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link Room#Room(Long, String, String, Float, Integer, Integer, Float, Float, String, String, Accommodation)}
     *   <li>{@link Room#setAccommodationId(Accommodation)}
     *   <li>{@link Room#setArea(Float)}
     *   <li>{@link Room#setBedType(String)}
     *   <li>{@link Room#setDailyPrice(Float)}
     *   <li>{@link Room#setDescription(String)}
     *   <li>{@link Room#setHolidayPrice(Float)}
     *   <li>{@link Room#setNumberOfPeople(Integer)}
     *   <li>{@link Room#setNumberRooms(Integer)}
     *   <li>{@link Room#setRoomId(Long)}
     *   <li>{@link Room#setRoomName(String)}
     *   <li>{@link Room#setRoomType(String)}
     *   <li>{@link Room#getAccommodationId()}
     *   <li>{@link Room#getArea()}
     *   <li>{@link Room#getBedType()}
     *   <li>{@link Room#getDailyPrice()}
     *   <li>{@link Room#getDescription()}
     *   <li>{@link Room#getHolidayPrice()}
     *   <li>{@link Room#getNumberOfPeople()}
     *   <li>{@link Room#getNumberRooms()}
     *   <li>{@link Room#getRoomId()}
     *   <li>{@link Room#getRoomName()}
     *   <li>{@link Room#getRoomType()}
     * </ul>
     */
    @Test
    void testConstructor2() {
        Service service = new Service();
        service.setAccommodation(new Accommodation());
        service.setAddress("42 Main St");
        service.setCity("Oxford");
        service.setDateRegister(null);
        service.setEmail("jane.doe@example.org");
        service.setEntertainment(new Entertainment());
        service.setFax("Fax");
        service.setIsActive(true);
        service.setIsBlock(true);
        service.setLink("Link");
        service.setPartnerId(new Partner());
        service.setPhone("4105551212");
        service.setPostList(new ArrayList<>());
        service.setRestaurant(new Restaurant());
        service.setServiceCategoryId(new ServiceCategory());
        service.setServiceId(123L);
        service.setServiceName("Service Name");
        service.setStatus(1);
        service.setTaxCode("Tax Code");
        service.setUtilitiesServiceList(new ArrayList<>());

        Accommodation accommodation = new Accommodation();
        accommodation.setAccommodationId(123L);
        accommodation.setAccommodationType("Accommodation Type");
        accommodation.setDescription("The characteristics of someone or something");
        accommodation.setNumberFloors(10);
        accommodation.setRate(10.0f);
        accommodation.setRoomList(new ArrayList<>());
        accommodation.setServiceId(service);

        Service service1 = new Service();
        service1.setAccommodation(new Accommodation());
        service1.setAddress("42 Main St");
        service1.setCity("Oxford");
        service1.setDateRegister(null);
        service1.setEmail("jane.doe@example.org");
        service1.setEntertainment(new Entertainment());
        service1.setFax("Fax");
        service1.setIsActive(true);
        service1.setIsBlock(true);
        service1.setLink("Link");
        service1.setPartnerId(new Partner());
        service1.setPhone("4105551212");
        service1.setPostList(new ArrayList<>());
        service1.setRestaurant(new Restaurant());
        service1.setServiceCategoryId(new ServiceCategory());
        service1.setServiceId(123L);
        service1.setServiceName("Service Name");
        service1.setStatus(1);
        service1.setTaxCode("Tax Code");
        service1.setUtilitiesServiceList(new ArrayList<>());

        Entertainment entertainment = new Entertainment();
        entertainment.setDescription("The characteristics of someone or something");
        entertainment.setDowOpen("Dow Open");
        entertainment.setEntertainmentId(123L);
        entertainment.setEntertainmentType("Entertainment Type");
        entertainment.setPriceTicketAdult(10.0f);
        entertainment.setPriceTicketChildren(10.0f);
        entertainment.setServiceId(service1);
        entertainment.setTimeClose(LocalTime.of(1, 1));
        entertainment.setTimeOpen(LocalTime.of(1, 1));

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

        Service service2 = new Service();
        service2.setAccommodation(new Accommodation());
        service2.setAddress("42 Main St");
        service2.setCity("Oxford");
        service2.setDateRegister(null);
        service2.setEmail("jane.doe@example.org");
        service2.setEntertainment(new Entertainment());
        service2.setFax("Fax");
        service2.setIsActive(true);
        service2.setIsBlock(true);
        service2.setLink("Link");
        service2.setPartnerId(new Partner());
        service2.setPhone("4105551212");
        service2.setPostList(new ArrayList<>());
        service2.setRestaurant(new Restaurant());
        service2.setServiceCategoryId(new ServiceCategory());
        service2.setServiceId(123L);
        service2.setServiceName("Service Name");
        service2.setStatus(1);
        service2.setTaxCode("Tax Code");
        service2.setUtilitiesServiceList(new ArrayList<>());

        Restaurant restaurant = new Restaurant();
        restaurant.setDescription("The characteristics of someone or something");
        restaurant.setRate(10.0f);
        restaurant.setRestaurantId(123L);
        restaurant.setRestaurantServiceType("Restaurant Service Type");
        restaurant.setServiceId(service2);
        restaurant.setTimeClose(LocalTime.of(1, 1));
        restaurant.setTimeOpen(LocalTime.of(1, 1));
        restaurant.setTypeOfCuisineServiceList(new ArrayList<>());

        ServiceCategory serviceCategory1 = new ServiceCategory();
        serviceCategory1.setPartnerList(new ArrayList<>());
        serviceCategory1.setServiceCategoryId(123L);
        serviceCategory1.setServiceCategoryName("Service Category Name");
        serviceCategory1.setServiceList(new ArrayList<>());

        Service service3 = new Service();
        service3.setAccommodation(accommodation);
        service3.setAddress("42 Main St");
        service3.setCity("Oxford");
        service3.setDateRegister(LocalDate.ofEpochDay(1L));
        service3.setEmail("jane.doe@example.org");
        service3.setEntertainment(entertainment);
        service3.setFax("Fax");
        service3.setIsActive(true);
        service3.setIsBlock(true);
        service3.setLink("Link");
        service3.setPartnerId(partner);
        service3.setPhone("4105551212");
        service3.setPostList(new ArrayList<>());
        service3.setRestaurant(restaurant);
        service3.setServiceCategoryId(serviceCategory1);
        service3.setServiceId(123L);
        service3.setServiceName("Service Name");
        service3.setStatus(1);
        service3.setTaxCode("Tax Code");
        service3.setUtilitiesServiceList(new ArrayList<>());

        Accommodation accommodation1 = new Accommodation();
        accommodation1.setAccommodationId(123L);
        accommodation1.setAccommodationType("Accommodation Type");
        accommodation1.setDescription("The characteristics of someone or something");
        accommodation1.setNumberFloors(10);
        accommodation1.setRate(10.0f);
        accommodation1.setRoomList(new ArrayList<>());
        accommodation1.setServiceId(service3);
        Room actualRoom = new Room(123L, "Room Name", "Room Type", 10.0f, 1000, 10, 10.0f, 10.0f,
                "The characteristics of someone or something", "Bed Type", accommodation1);
        Service service4 = new Service();
        service4.setAccommodation(new Accommodation());
        service4.setAddress("42 Main St");
        service4.setCity("Oxford");
        service4.setDateRegister(null);
        service4.setEmail("jane.doe@example.org");
        service4.setEntertainment(new Entertainment());
        service4.setFax("Fax");
        service4.setIsActive(true);
        service4.setIsBlock(true);
        service4.setLink("Link");
        service4.setPartnerId(new Partner());
        service4.setPhone("4105551212");
        service4.setPostList(new ArrayList<>());
        service4.setRestaurant(new Restaurant());
        service4.setServiceCategoryId(new ServiceCategory());
        service4.setServiceId(123L);
        service4.setServiceName("Service Name");
        service4.setStatus(1);
        service4.setTaxCode("Tax Code");
        service4.setUtilitiesServiceList(new ArrayList<>());
        Accommodation accommodation2 = new Accommodation();
        accommodation2.setAccommodationId(123L);
        accommodation2.setAccommodationType("Accommodation Type");
        accommodation2.setDescription("The characteristics of someone or something");
        accommodation2.setNumberFloors(10);
        accommodation2.setRate(10.0f);
        accommodation2.setRoomList(new ArrayList<>());
        accommodation2.setServiceId(service4);
        Service service5 = new Service();
        service5.setAccommodation(new Accommodation());
        service5.setAddress("42 Main St");
        service5.setCity("Oxford");
        service5.setDateRegister(null);
        service5.setEmail("jane.doe@example.org");
        service5.setEntertainment(new Entertainment());
        service5.setFax("Fax");
        service5.setIsActive(true);
        service5.setIsBlock(true);
        service5.setLink("Link");
        service5.setPartnerId(new Partner());
        service5.setPhone("4105551212");
        service5.setPostList(new ArrayList<>());
        service5.setRestaurant(new Restaurant());
        service5.setServiceCategoryId(new ServiceCategory());
        service5.setServiceId(123L);
        service5.setServiceName("Service Name");
        service5.setStatus(1);
        service5.setTaxCode("Tax Code");
        service5.setUtilitiesServiceList(new ArrayList<>());
        Entertainment entertainment1 = new Entertainment();
        entertainment1.setDescription("The characteristics of someone or something");
        entertainment1.setDowOpen("Dow Open");
        entertainment1.setEntertainmentId(123L);
        entertainment1.setEntertainmentType("Entertainment Type");
        entertainment1.setPriceTicketAdult(10.0f);
        entertainment1.setPriceTicketChildren(10.0f);
        entertainment1.setServiceId(service5);
        entertainment1.setTimeClose(LocalTime.of(1, 1));
        entertainment1.setTimeOpen(LocalTime.of(1, 1));
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
        CompanyPartner companyPartner1 = new CompanyPartner();
        companyPartner1.setAddress("42 Main St");
        companyPartner1.setBusinessCode("Business Code");
        companyPartner1.setCity("Oxford");
        companyPartner1.setCompanyName("Company Name");
        companyPartner1.setCompanyPartnerId(123L);
        companyPartner1.setEmail("jane.doe@example.org");
        companyPartner1.setFax("Fax");
        companyPartner1.setIncorporationDate("2020-03-01");
        companyPartner1.setPartnerId(new Partner());
        companyPartner1.setPhone("4105551212");
        companyPartner1.setRegistrationDate("2020-03-01");
        companyPartner1.setShortName("Short Name");
        companyPartner1.setTaxCode("Tax Code");
        companyPartner1.setWebsite("Website");
        ServiceCategory serviceCategory2 = new ServiceCategory();
        serviceCategory2.setPartnerList(new ArrayList<>());
        serviceCategory2.setServiceCategoryId(123L);
        serviceCategory2.setServiceCategoryName("Service Category Name");
        serviceCategory2.setServiceList(new ArrayList<>());
        Partner partner1 = new Partner();
        partner1.setAccountId(account1);
        partner1.setAddress("42 Main St");
        partner1.setBirthDate("2020-03-01");
        partner1.setCity("Oxford");
        partner1.setCompanyPartnerId(companyPartner1);
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
        partner1.setServiceCategoryId(serviceCategory2);
        partner1.setServiceList(new ArrayList<>());
        Service service6 = new Service();
        service6.setAccommodation(new Accommodation());
        service6.setAddress("42 Main St");
        service6.setCity("Oxford");
        service6.setDateRegister(null);
        service6.setEmail("jane.doe@example.org");
        service6.setEntertainment(new Entertainment());
        service6.setFax("Fax");
        service6.setIsActive(true);
        service6.setIsBlock(true);
        service6.setLink("Link");
        service6.setPartnerId(new Partner());
        service6.setPhone("4105551212");
        service6.setPostList(new ArrayList<>());
        service6.setRestaurant(new Restaurant());
        service6.setServiceCategoryId(new ServiceCategory());
        service6.setServiceId(123L);
        service6.setServiceName("Service Name");
        service6.setStatus(1);
        service6.setTaxCode("Tax Code");
        service6.setUtilitiesServiceList(new ArrayList<>());
        Restaurant restaurant1 = new Restaurant();
        restaurant1.setDescription("The characteristics of someone or something");
        restaurant1.setRate(10.0f);
        restaurant1.setRestaurantId(123L);
        restaurant1.setRestaurantServiceType("Restaurant Service Type");
        restaurant1.setServiceId(service6);
        restaurant1.setTimeClose(LocalTime.of(1, 1));
        restaurant1.setTimeOpen(LocalTime.of(1, 1));
        restaurant1.setTypeOfCuisineServiceList(new ArrayList<>());
        ServiceCategory serviceCategory3 = new ServiceCategory();
        serviceCategory3.setPartnerList(new ArrayList<>());
        serviceCategory3.setServiceCategoryId(123L);
        serviceCategory3.setServiceCategoryName("Service Category Name");
        serviceCategory3.setServiceList(new ArrayList<>());
        Service service7 = new Service();
        service7.setAccommodation(accommodation2);
        service7.setAddress("42 Main St");
        service7.setCity("Oxford");
        service7.setDateRegister(LocalDate.ofEpochDay(1L));
        service7.setEmail("jane.doe@example.org");
        service7.setEntertainment(entertainment1);
        service7.setFax("Fax");
        service7.setIsActive(true);
        service7.setIsBlock(true);
        service7.setLink("Link");
        service7.setPartnerId(partner1);
        service7.setPhone("4105551212");
        service7.setPostList(new ArrayList<>());
        service7.setRestaurant(restaurant1);
        service7.setServiceCategoryId(serviceCategory3);
        service7.setServiceId(123L);
        service7.setServiceName("Service Name");
        service7.setStatus(1);
        service7.setTaxCode("Tax Code");
        service7.setUtilitiesServiceList(new ArrayList<>());
        Accommodation accommodation3 = new Accommodation();
        accommodation3.setAccommodationId(123L);
        accommodation3.setAccommodationType("Accommodation Type");
        accommodation3.setDescription("The characteristics of someone or something");
        accommodation3.setNumberFloors(10);
        accommodation3.setRate(10.0f);
        accommodation3.setRoomList(new ArrayList<>());
        accommodation3.setServiceId(service7);
        actualRoom.setAccommodationId(accommodation3);
        actualRoom.setArea(10.0f);
        actualRoom.setBedType("Bed Type");
        actualRoom.setDailyPrice(10.0f);
        actualRoom.setDescription("The characteristics of someone or something");
        actualRoom.setHolidayPrice(10.0f);
        actualRoom.setNumberOfPeople(10);
        actualRoom.setNumberRooms(1000);
        actualRoom.setRoomId(123L);
        actualRoom.setRoomName("Room Name");
        actualRoom.setRoomType("Room Type");
        assertSame(accommodation3, actualRoom.getAccommodationId());
        assertEquals(10.0f, actualRoom.getArea().floatValue());
        assertEquals("Bed Type", actualRoom.getBedType());
        assertEquals(10.0f, actualRoom.getDailyPrice().floatValue());
        assertEquals("The characteristics of someone or something", actualRoom.getDescription());
        assertEquals(10.0f, actualRoom.getHolidayPrice().floatValue());
        assertEquals(10, actualRoom.getNumberOfPeople().intValue());
        assertEquals(1000, actualRoom.getNumberRooms().intValue());
        assertEquals(123L, actualRoom.getRoomId().longValue());
        assertEquals("Room Name", actualRoom.getRoomName());
        assertEquals("Room Type", actualRoom.getRoomType());
    }
}


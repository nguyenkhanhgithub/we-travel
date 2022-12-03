package com.example.wetravel.Service.ServiceImpl;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.example.wetravel.DTO.AccommodationDTO;
import com.example.wetravel.DTO.EntertainmentDTO;
import com.example.wetravel.DTO.RestaurantDTO;
import com.example.wetravel.DTO.ServiceDTO;
import com.example.wetravel.Entity.Accommodation;
import com.example.wetravel.Entity.Account;
import com.example.wetravel.Entity.CompanyPartner;
import com.example.wetravel.Entity.Entertainment;
import com.example.wetravel.Entity.Partner;
import com.example.wetravel.Entity.Restaurant;
import com.example.wetravel.Entity.Role;
import com.example.wetravel.Entity.Service;
import com.example.wetravel.Entity.ServiceCategory;
import com.example.wetravel.Entity.User;
import com.example.wetravel.Exception.HandlerException;
import com.example.wetravel.Repository.AccommodationRepository;
import com.example.wetravel.Repository.EntertainmentRepository;
import com.example.wetravel.Repository.PartnerRepository;
import com.example.wetravel.Repository.RestaurantRepository;
import com.example.wetravel.Repository.RoomRepository;
import com.example.wetravel.Repository.ServiceCategoryRepository;
import com.example.wetravel.Repository.ServiceRepository;
import com.example.wetravel.Repository.TypeOfCuisineRepository;
import com.example.wetravel.Repository.TypeOfCuisineServiceRepository;
import com.example.wetravel.Repository.UtilitiesServiceRepository;
import com.example.wetravel.Repository.UtilitiesSubcategoryRepository;

import java.time.LocalDate;
import java.time.LocalTime;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {ServiceServiceImpl.class})
@ExtendWith(SpringExtension.class)
class ServiceServiceImplTest {
    @MockBean
    private AccommodationRepository accommodationRepository;

    @MockBean
    private EntertainmentRepository entertainmentRepository;

    @MockBean
    private PartnerRepository partnerRepository;

    @MockBean
    private RestaurantRepository restaurantRepository;

    @MockBean
    private RoomRepository roomRepository;

    @MockBean
    private ServiceCategoryRepository serviceCategoryRepository;

    @MockBean
    private ServiceRepository serviceRepository;

    @Autowired
    private ServiceServiceImpl serviceServiceImpl;

    @MockBean
    private TypeOfCuisineRepository typeOfCuisineRepository;

    @MockBean
    private TypeOfCuisineServiceRepository typeOfCuisineServiceRepository;

    @MockBean
    private UtilitiesServiceRepository utilitiesServiceRepository;

    @MockBean
    private UtilitiesSubcategoryRepository utilitiesSubcategoryRepository;

    /**
     * Method under test: {@link ServiceServiceImpl#getAllServiceByCondition(String, Long, Integer, Integer, Integer)}
     */
    @Test
    void testGetAllServiceByCondition() throws HandlerException {
        when(serviceRepository.getListServiceByCondition((String) any(), (Long) any(), (Integer) any(), (Integer) any(),
                (Integer) any())).thenReturn(new ArrayList<>());
        assertThrows(HandlerException.class,
                () -> serviceServiceImpl.getAllServiceByCondition("jane.doe@example.org", 123L, 1, 1, 1));
        verify(serviceRepository).getListServiceByCondition((String) any(), (Long) any(), (Integer) any(),
                (Integer) any(), (Integer) any());
    }

    /**
     * Method under test: {@link ServiceServiceImpl#getListServiceByPartnerId(Long, Integer, Integer)}
     */
    @Test
    void testGetListServiceByPartnerId() throws HandlerException {
        when(serviceRepository.getListServiceByPartnerId((Long) any(), (Pageable) any()))
                .thenReturn(new PageImpl<>(new ArrayList<>()));
        assertThrows(HandlerException.class, () -> serviceServiceImpl.getListServiceByPartnerId(123L, 1, 3));
        verify(serviceRepository).getListServiceByPartnerId((Long) any(), (Pageable) any());
    }

    /**
     * Method under test: {@link ServiceServiceImpl#getDetailAccommodation(Long)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testGetDetailAccommodation() throws HandlerException {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at com.example.wetravel.Service.ServiceImpl.ServiceServiceImpl.getDetailAccommodation(ServiceServiceImpl.java:136)
        //   See https://diff.blue/R013 to resolve this issue.

        (new ServiceServiceImpl()).getDetailAccommodation(123L);
    }

    /**
     * Method under test: {@link ServiceServiceImpl#getDetailRestaurant(Long)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testGetDetailRestaurant() throws HandlerException {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at com.example.wetravel.Service.ServiceImpl.ServiceServiceImpl.getDetailRestaurant(ServiceServiceImpl.java:192)
        //   See https://diff.blue/R013 to resolve this issue.

        (new ServiceServiceImpl()).getDetailRestaurant(123L);
    }

    /**
     * Method under test: {@link ServiceServiceImpl#getDetailEntertainment(Long)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testGetDetailEntertainment() throws HandlerException {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at com.example.wetravel.Service.ServiceImpl.ServiceServiceImpl.getDetailEntertainment(ServiceServiceImpl.java:242)
        //   See https://diff.blue/R013 to resolve this issue.

        (new ServiceServiceImpl()).getDetailEntertainment(123L);
    }

    /**
     * Method under test: {@link ServiceServiceImpl#addService(ServiceDTO)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testAddService() throws HandlerException {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at com.example.wetravel.Service.ServiceImpl.ServiceServiceImpl.addService(ServiceServiceImpl.java:283)
        //   See https://diff.blue/R013 to resolve this issue.

        ServiceServiceImpl serviceServiceImpl = new ServiceServiceImpl();
        serviceServiceImpl.addService(new ServiceDTO());
    }

    /**
     * Method under test: {@link ServiceServiceImpl#addService(ServiceDTO)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testAddService2() throws HandlerException {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at com.example.wetravel.Service.ServiceImpl.ServiceServiceImpl.addService(ServiceServiceImpl.java:283)
        //   See https://diff.blue/R013 to resolve this issue.

        (new ServiceServiceImpl()).addService(null);
    }

    /**
     * Method under test: {@link ServiceServiceImpl#addService(ServiceDTO)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testAddService3() throws HandlerException {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at com.example.wetravel.Service.ServiceImpl.ServiceServiceImpl.addService(ServiceServiceImpl.java:283)
        //   See https://diff.blue/R013 to resolve this issue.

        ServiceServiceImpl serviceServiceImpl = new ServiceServiceImpl();
        ServiceDTO serviceDTO = mock(ServiceDTO.class);
        when(serviceDTO.getPartnerEmail()).thenReturn("jane.doe@example.org");
        serviceServiceImpl.addService(serviceDTO);
    }

    /**
     * Method under test: {@link ServiceServiceImpl#createAccommodation(AccommodationDTO)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testCreateAccommodation() throws HandlerException {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at com.example.wetravel.Service.ServiceImpl.ServiceServiceImpl.addService(ServiceServiceImpl.java:283)
        //       at com.example.wetravel.Service.ServiceImpl.ServiceServiceImpl.createAccommodation(ServiceServiceImpl.java:310)
        //   See https://diff.blue/R013 to resolve this issue.

        serviceServiceImpl.createAccommodation(new AccommodationDTO());
    }

    /**
     * Method under test: {@link ServiceServiceImpl#createRestaurant(RestaurantDTO)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testCreateRestaurant() throws HandlerException {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at com.example.wetravel.Service.ServiceImpl.ServiceServiceImpl.addService(ServiceServiceImpl.java:283)
        //       at com.example.wetravel.Service.ServiceImpl.ServiceServiceImpl.createRestaurant(ServiceServiceImpl.java:355)
        //   See https://diff.blue/R013 to resolve this issue.

        serviceServiceImpl.createRestaurant(new RestaurantDTO());
    }

    /**
     * Method under test: {@link ServiceServiceImpl#createEntertainment(EntertainmentDTO)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testCreateEntertainment() throws HandlerException {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at com.example.wetravel.Service.ServiceImpl.ServiceServiceImpl.addService(ServiceServiceImpl.java:283)
        //       at com.example.wetravel.Service.ServiceImpl.ServiceServiceImpl.createEntertainment(ServiceServiceImpl.java:395)
        //   See https://diff.blue/R013 to resolve this issue.

        serviceServiceImpl.createEntertainment(new EntertainmentDTO());
    }

    /**
     * Method under test: {@link ServiceServiceImpl#updateService(ServiceDTO, List, Long)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testUpdateService() throws HandlerException {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at com.example.wetravel.Service.ServiceImpl.ServiceServiceImpl.updateService(ServiceServiceImpl.java:430)
        //   See https://diff.blue/R013 to resolve this issue.

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

        Entertainment entertainment2 = new Entertainment();
        entertainment2.setDescription("The characteristics of someone or something");
        entertainment2.setDowOpen("Dow Open");
        entertainment2.setEntertainmentId(123L);
        entertainment2.setEntertainmentType("Entertainment Type");
        entertainment2.setPriceTicketAdult(10.0f);
        entertainment2.setPriceTicketChildren(10.0f);
        entertainment2.setServiceId(service7);
        entertainment2.setTimeClose(LocalTime.of(1, 1));
        entertainment2.setTimeOpen(LocalTime.of(1, 1));

        Account account2 = new Account();
        account2.setAccountId(1234567890L);
        account2.setCommentList(new ArrayList<>());
        account2.setEmail("jane.doe@example.org");
        account2.setFeedbackList(new ArrayList<>());
        account2.setIsBlock(true);
        account2.setPartner(new Partner());
        account2.setPassWord("Pass Word");
        account2.setRoleId(new Role());
        account2.setTourList(new ArrayList<>());
        account2.setUser(new User());
        account2.setUserBookingList(new ArrayList<>());

        CompanyPartner companyPartner2 = new CompanyPartner();
        companyPartner2.setAddress("42 Main St");
        companyPartner2.setBusinessCode("Business Code");
        companyPartner2.setCity("Oxford");
        companyPartner2.setCompanyName("Company Name");
        companyPartner2.setCompanyPartnerId(123L);
        companyPartner2.setEmail("jane.doe@example.org");
        companyPartner2.setFax("Fax");
        companyPartner2.setIncorporationDate("2020-03-01");
        companyPartner2.setPartnerId(new Partner());
        companyPartner2.setPhone("4105551212");
        companyPartner2.setRegistrationDate("2020-03-01");
        companyPartner2.setShortName("Short Name");
        companyPartner2.setTaxCode("Tax Code");
        companyPartner2.setWebsite("Website");

        ServiceCategory serviceCategory4 = new ServiceCategory();
        serviceCategory4.setPartnerList(new ArrayList<>());
        serviceCategory4.setServiceCategoryId(123L);
        serviceCategory4.setServiceCategoryName("Service Category Name");
        serviceCategory4.setServiceList(new ArrayList<>());

        Partner partner2 = new Partner();
        partner2.setAccountId(account2);
        partner2.setAddress("42 Main St");
        partner2.setBirthDate("2020-03-01");
        partner2.setCity("Oxford");
        partner2.setCompanyPartnerId(companyPartner2);
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
        partner2.setServiceCategoryId(serviceCategory4);
        partner2.setServiceList(new ArrayList<>());

        Role role = new Role();
        role.setAccountList(new ArrayList<>());
        role.setRoleId(123);
        role.setRoleName("Role Name");

        Account account3 = new Account();
        account3.setAccountId(1234567890L);
        account3.setCommentList(new ArrayList<>());
        account3.setEmail("jane.doe@example.org");
        account3.setFeedbackList(new ArrayList<>());
        account3.setIsBlock(true);
        account3.setPartner(new Partner());
        account3.setPassWord("Pass Word");
        account3.setRoleId(new Role());
        account3.setTourList(new ArrayList<>());
        account3.setUser(new User());
        account3.setUserBookingList(new ArrayList<>());

        User user = new User();
        user.setAccountId(account3);
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

        Account account4 = new Account();
        account4.setAccountId(1234567890L);
        account4.setCommentList(new ArrayList<>());
        account4.setEmail("jane.doe@example.org");
        account4.setFeedbackList(new ArrayList<>());
        account4.setIsBlock(true);
        account4.setPartner(partner2);
        account4.setPassWord("Pass Word");
        account4.setRoleId(role);
        account4.setTourList(new ArrayList<>());
        account4.setUser(user);
        account4.setUserBookingList(new ArrayList<>());

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

        CompanyPartner companyPartner3 = new CompanyPartner();
        companyPartner3.setAddress("42 Main St");
        companyPartner3.setBusinessCode("Business Code");
        companyPartner3.setCity("Oxford");
        companyPartner3.setCompanyName("Company Name");
        companyPartner3.setCompanyPartnerId(123L);
        companyPartner3.setEmail("jane.doe@example.org");
        companyPartner3.setFax("Fax");
        companyPartner3.setIncorporationDate("2020-03-01");
        companyPartner3.setPartnerId(new Partner());
        companyPartner3.setPhone("4105551212");
        companyPartner3.setRegistrationDate("2020-03-01");
        companyPartner3.setShortName("Short Name");
        companyPartner3.setTaxCode("Tax Code");
        companyPartner3.setWebsite("Website");

        ServiceCategory serviceCategory5 = new ServiceCategory();
        serviceCategory5.setPartnerList(new ArrayList<>());
        serviceCategory5.setServiceCategoryId(123L);
        serviceCategory5.setServiceCategoryName("Service Category Name");
        serviceCategory5.setServiceList(new ArrayList<>());

        Partner partner3 = new Partner();
        partner3.setAccountId(account5);
        partner3.setAddress("42 Main St");
        partner3.setBirthDate("2020-03-01");
        partner3.setCity("Oxford");
        partner3.setCompanyPartnerId(companyPartner3);
        partner3.setDateIssue("2020-03-01");
        partner3.setDepartment("Department");
        partner3.setEmail("jane.doe@example.org");
        partner3.setFirstName("Jane");
        partner3.setGender("Gender");
        partner3.setLastName("Doe");
        partner3.setNumberIdCard("42");
        partner3.setPartnerId(123L);
        partner3.setPhone("4105551212");
        partner3.setPlaceIssue("Place Issue");
        partner3.setPosition("Position");
        partner3.setServiceCategoryId(serviceCategory5);
        partner3.setServiceList(new ArrayList<>());

        CompanyPartner companyPartner4 = new CompanyPartner();
        companyPartner4.setAddress("42 Main St");
        companyPartner4.setBusinessCode("Business Code");
        companyPartner4.setCity("Oxford");
        companyPartner4.setCompanyName("Company Name");
        companyPartner4.setCompanyPartnerId(123L);
        companyPartner4.setEmail("jane.doe@example.org");
        companyPartner4.setFax("Fax");
        companyPartner4.setIncorporationDate("2020-03-01");
        companyPartner4.setPartnerId(partner3);
        companyPartner4.setPhone("4105551212");
        companyPartner4.setRegistrationDate("2020-03-01");
        companyPartner4.setShortName("Short Name");
        companyPartner4.setTaxCode("Tax Code");
        companyPartner4.setWebsite("Website");

        ServiceCategory serviceCategory6 = new ServiceCategory();
        serviceCategory6.setPartnerList(new ArrayList<>());
        serviceCategory6.setServiceCategoryId(123L);
        serviceCategory6.setServiceCategoryName("Service Category Name");
        serviceCategory6.setServiceList(new ArrayList<>());

        Partner partner4 = new Partner();
        partner4.setAccountId(account4);
        partner4.setAddress("42 Main St");
        partner4.setBirthDate("2020-03-01");
        partner4.setCity("Oxford");
        partner4.setCompanyPartnerId(companyPartner4);
        partner4.setDateIssue("2020-03-01");
        partner4.setDepartment("Department");
        partner4.setEmail("jane.doe@example.org");
        partner4.setFirstName("Jane");
        partner4.setGender("Gender");
        partner4.setLastName("Doe");
        partner4.setNumberIdCard("42");
        partner4.setPartnerId(123L);
        partner4.setPhone("4105551212");
        partner4.setPlaceIssue("Place Issue");
        partner4.setPosition("Position");
        partner4.setServiceCategoryId(serviceCategory6);
        partner4.setServiceList(new ArrayList<>());

        Service service8 = new Service();
        service8.setAccommodation(new Accommodation());
        service8.setAddress("42 Main St");
        service8.setCity("Oxford");
        service8.setDateRegister(null);
        service8.setEmail("jane.doe@example.org");
        service8.setEntertainment(new Entertainment());
        service8.setFax("Fax");
        service8.setIsActive(true);
        service8.setIsBlock(true);
        service8.setLink("Link");
        service8.setPartnerId(new Partner());
        service8.setPhone("4105551212");
        service8.setPostList(new ArrayList<>());
        service8.setRestaurant(new Restaurant());
        service8.setServiceCategoryId(new ServiceCategory());
        service8.setServiceId(123L);
        service8.setServiceName("Service Name");
        service8.setStatus(1);
        service8.setTaxCode("Tax Code");
        service8.setUtilitiesServiceList(new ArrayList<>());

        Accommodation accommodation3 = new Accommodation();
        accommodation3.setAccommodationId(123L);
        accommodation3.setAccommodationType("Accommodation Type");
        accommodation3.setDescription("The characteristics of someone or something");
        accommodation3.setNumberFloors(10);
        accommodation3.setRate(10.0f);
        accommodation3.setRoomList(new ArrayList<>());
        accommodation3.setServiceId(service8);

        Service service9 = new Service();
        service9.setAccommodation(new Accommodation());
        service9.setAddress("42 Main St");
        service9.setCity("Oxford");
        service9.setDateRegister(null);
        service9.setEmail("jane.doe@example.org");
        service9.setEntertainment(new Entertainment());
        service9.setFax("Fax");
        service9.setIsActive(true);
        service9.setIsBlock(true);
        service9.setLink("Link");
        service9.setPartnerId(new Partner());
        service9.setPhone("4105551212");
        service9.setPostList(new ArrayList<>());
        service9.setRestaurant(new Restaurant());
        service9.setServiceCategoryId(new ServiceCategory());
        service9.setServiceId(123L);
        service9.setServiceName("Service Name");
        service9.setStatus(1);
        service9.setTaxCode("Tax Code");
        service9.setUtilitiesServiceList(new ArrayList<>());

        Entertainment entertainment3 = new Entertainment();
        entertainment3.setDescription("The characteristics of someone or something");
        entertainment3.setDowOpen("Dow Open");
        entertainment3.setEntertainmentId(123L);
        entertainment3.setEntertainmentType("Entertainment Type");
        entertainment3.setPriceTicketAdult(10.0f);
        entertainment3.setPriceTicketChildren(10.0f);
        entertainment3.setServiceId(service9);
        entertainment3.setTimeClose(LocalTime.of(1, 1));
        entertainment3.setTimeOpen(LocalTime.of(1, 1));

        Account account6 = new Account();
        account6.setAccountId(1234567890L);
        account6.setCommentList(new ArrayList<>());
        account6.setEmail("jane.doe@example.org");
        account6.setFeedbackList(new ArrayList<>());
        account6.setIsBlock(true);
        account6.setPartner(new Partner());
        account6.setPassWord("Pass Word");
        account6.setRoleId(new Role());
        account6.setTourList(new ArrayList<>());
        account6.setUser(new User());
        account6.setUserBookingList(new ArrayList<>());

        CompanyPartner companyPartner5 = new CompanyPartner();
        companyPartner5.setAddress("42 Main St");
        companyPartner5.setBusinessCode("Business Code");
        companyPartner5.setCity("Oxford");
        companyPartner5.setCompanyName("Company Name");
        companyPartner5.setCompanyPartnerId(123L);
        companyPartner5.setEmail("jane.doe@example.org");
        companyPartner5.setFax("Fax");
        companyPartner5.setIncorporationDate("2020-03-01");
        companyPartner5.setPartnerId(new Partner());
        companyPartner5.setPhone("4105551212");
        companyPartner5.setRegistrationDate("2020-03-01");
        companyPartner5.setShortName("Short Name");
        companyPartner5.setTaxCode("Tax Code");
        companyPartner5.setWebsite("Website");

        ServiceCategory serviceCategory7 = new ServiceCategory();
        serviceCategory7.setPartnerList(new ArrayList<>());
        serviceCategory7.setServiceCategoryId(123L);
        serviceCategory7.setServiceCategoryName("Service Category Name");
        serviceCategory7.setServiceList(new ArrayList<>());

        Partner partner5 = new Partner();
        partner5.setAccountId(account6);
        partner5.setAddress("42 Main St");
        partner5.setBirthDate("2020-03-01");
        partner5.setCity("Oxford");
        partner5.setCompanyPartnerId(companyPartner5);
        partner5.setDateIssue("2020-03-01");
        partner5.setDepartment("Department");
        partner5.setEmail("jane.doe@example.org");
        partner5.setFirstName("Jane");
        partner5.setGender("Gender");
        partner5.setLastName("Doe");
        partner5.setNumberIdCard("42");
        partner5.setPartnerId(123L);
        partner5.setPhone("4105551212");
        partner5.setPlaceIssue("Place Issue");
        partner5.setPosition("Position");
        partner5.setServiceCategoryId(serviceCategory7);
        partner5.setServiceList(new ArrayList<>());

        Service service10 = new Service();
        service10.setAccommodation(new Accommodation());
        service10.setAddress("42 Main St");
        service10.setCity("Oxford");
        service10.setDateRegister(null);
        service10.setEmail("jane.doe@example.org");
        service10.setEntertainment(new Entertainment());
        service10.setFax("Fax");
        service10.setIsActive(true);
        service10.setIsBlock(true);
        service10.setLink("Link");
        service10.setPartnerId(new Partner());
        service10.setPhone("4105551212");
        service10.setPostList(new ArrayList<>());
        service10.setRestaurant(new Restaurant());
        service10.setServiceCategoryId(new ServiceCategory());
        service10.setServiceId(123L);
        service10.setServiceName("Service Name");
        service10.setStatus(1);
        service10.setTaxCode("Tax Code");
        service10.setUtilitiesServiceList(new ArrayList<>());

        Restaurant restaurant2 = new Restaurant();
        restaurant2.setDescription("The characteristics of someone or something");
        restaurant2.setRate(10.0f);
        restaurant2.setRestaurantId(123L);
        restaurant2.setRestaurantServiceType("Restaurant Service Type");
        restaurant2.setServiceId(service10);
        restaurant2.setTimeClose(LocalTime.of(1, 1));
        restaurant2.setTimeOpen(LocalTime.of(1, 1));
        restaurant2.setTypeOfCuisineServiceList(new ArrayList<>());

        ServiceCategory serviceCategory8 = new ServiceCategory();
        serviceCategory8.setPartnerList(new ArrayList<>());
        serviceCategory8.setServiceCategoryId(123L);
        serviceCategory8.setServiceCategoryName("Service Category Name");
        serviceCategory8.setServiceList(new ArrayList<>());

        Service service11 = new Service();
        service11.setAccommodation(accommodation3);
        service11.setAddress("42 Main St");
        service11.setCity("Oxford");
        service11.setDateRegister(LocalDate.ofEpochDay(1L));
        service11.setEmail("jane.doe@example.org");
        service11.setEntertainment(entertainment3);
        service11.setFax("Fax");
        service11.setIsActive(true);
        service11.setIsBlock(true);
        service11.setLink("Link");
        service11.setPartnerId(partner5);
        service11.setPhone("4105551212");
        service11.setPostList(new ArrayList<>());
        service11.setRestaurant(restaurant2);
        service11.setServiceCategoryId(serviceCategory8);
        service11.setServiceId(123L);
        service11.setServiceName("Service Name");
        service11.setStatus(1);
        service11.setTaxCode("Tax Code");
        service11.setUtilitiesServiceList(new ArrayList<>());

        Restaurant restaurant3 = new Restaurant();
        restaurant3.setDescription("The characteristics of someone or something");
        restaurant3.setRate(10.0f);
        restaurant3.setRestaurantId(123L);
        restaurant3.setRestaurantServiceType("Restaurant Service Type");
        restaurant3.setServiceId(service11);
        restaurant3.setTimeClose(LocalTime.of(1, 1));
        restaurant3.setTimeOpen(LocalTime.of(1, 1));
        restaurant3.setTypeOfCuisineServiceList(new ArrayList<>());

        ServiceCategory serviceCategory9 = new ServiceCategory();
        serviceCategory9.setPartnerList(new ArrayList<>());
        serviceCategory9.setServiceCategoryId(123L);
        serviceCategory9.setServiceCategoryName("Service Category Name");
        serviceCategory9.setServiceList(new ArrayList<>());

        Service service12 = new Service();
        service12.setAccommodation(accommodation1);
        service12.setAddress("42 Main St");
        service12.setCity("Oxford");
        service12.setDateRegister(LocalDate.ofEpochDay(1L));
        service12.setEmail("jane.doe@example.org");
        service12.setEntertainment(entertainment2);
        service12.setFax("Fax");
        service12.setIsActive(true);
        service12.setIsBlock(true);
        service12.setLink("Link");
        service12.setPartnerId(partner4);
        service12.setPhone("4105551212");
        service12.setPostList(new ArrayList<>());
        service12.setRestaurant(restaurant3);
        service12.setServiceCategoryId(serviceCategory9);
        service12.setServiceId(123L);
        service12.setServiceName("Service Name");
        service12.setStatus(1);
        service12.setTaxCode("Tax Code");
        service12.setUtilitiesServiceList(new ArrayList<>());
        when(serviceRepository.existsAllByServiceName((String) any())).thenReturn(true);
        when(serviceRepository.getById((Long) any())).thenReturn(service12);
        ServiceDTO serviceDTO = new ServiceDTO();
        serviceServiceImpl.updateService(serviceDTO, new ArrayList<>(), 123L);
    }

    /**
     * Method under test: {@link ServiceServiceImpl#updateAccommodation(AccommodationDTO, Long)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testUpdateAccommodation() throws HandlerException {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at com.example.wetravel.Service.ServiceImpl.ServiceServiceImpl.updateService(ServiceServiceImpl.java:429)
        //       at com.example.wetravel.Service.ServiceImpl.ServiceServiceImpl.updateAccommodation(ServiceServiceImpl.java:456)
        //   See https://diff.blue/R013 to resolve this issue.

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

        Entertainment entertainment2 = new Entertainment();
        entertainment2.setDescription("The characteristics of someone or something");
        entertainment2.setDowOpen("Dow Open");
        entertainment2.setEntertainmentId(123L);
        entertainment2.setEntertainmentType("Entertainment Type");
        entertainment2.setPriceTicketAdult(10.0f);
        entertainment2.setPriceTicketChildren(10.0f);
        entertainment2.setServiceId(service7);
        entertainment2.setTimeClose(LocalTime.of(1, 1));
        entertainment2.setTimeOpen(LocalTime.of(1, 1));

        Account account2 = new Account();
        account2.setAccountId(1234567890L);
        account2.setCommentList(new ArrayList<>());
        account2.setEmail("jane.doe@example.org");
        account2.setFeedbackList(new ArrayList<>());
        account2.setIsBlock(true);
        account2.setPartner(new Partner());
        account2.setPassWord("Pass Word");
        account2.setRoleId(new Role());
        account2.setTourList(new ArrayList<>());
        account2.setUser(new User());
        account2.setUserBookingList(new ArrayList<>());

        CompanyPartner companyPartner2 = new CompanyPartner();
        companyPartner2.setAddress("42 Main St");
        companyPartner2.setBusinessCode("Business Code");
        companyPartner2.setCity("Oxford");
        companyPartner2.setCompanyName("Company Name");
        companyPartner2.setCompanyPartnerId(123L);
        companyPartner2.setEmail("jane.doe@example.org");
        companyPartner2.setFax("Fax");
        companyPartner2.setIncorporationDate("2020-03-01");
        companyPartner2.setPartnerId(new Partner());
        companyPartner2.setPhone("4105551212");
        companyPartner2.setRegistrationDate("2020-03-01");
        companyPartner2.setShortName("Short Name");
        companyPartner2.setTaxCode("Tax Code");
        companyPartner2.setWebsite("Website");

        ServiceCategory serviceCategory4 = new ServiceCategory();
        serviceCategory4.setPartnerList(new ArrayList<>());
        serviceCategory4.setServiceCategoryId(123L);
        serviceCategory4.setServiceCategoryName("Service Category Name");
        serviceCategory4.setServiceList(new ArrayList<>());

        Partner partner2 = new Partner();
        partner2.setAccountId(account2);
        partner2.setAddress("42 Main St");
        partner2.setBirthDate("2020-03-01");
        partner2.setCity("Oxford");
        partner2.setCompanyPartnerId(companyPartner2);
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
        partner2.setServiceCategoryId(serviceCategory4);
        partner2.setServiceList(new ArrayList<>());

        Role role = new Role();
        role.setAccountList(new ArrayList<>());
        role.setRoleId(123);
        role.setRoleName("Role Name");

        Account account3 = new Account();
        account3.setAccountId(1234567890L);
        account3.setCommentList(new ArrayList<>());
        account3.setEmail("jane.doe@example.org");
        account3.setFeedbackList(new ArrayList<>());
        account3.setIsBlock(true);
        account3.setPartner(new Partner());
        account3.setPassWord("Pass Word");
        account3.setRoleId(new Role());
        account3.setTourList(new ArrayList<>());
        account3.setUser(new User());
        account3.setUserBookingList(new ArrayList<>());

        User user = new User();
        user.setAccountId(account3);
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

        Account account4 = new Account();
        account4.setAccountId(1234567890L);
        account4.setCommentList(new ArrayList<>());
        account4.setEmail("jane.doe@example.org");
        account4.setFeedbackList(new ArrayList<>());
        account4.setIsBlock(true);
        account4.setPartner(partner2);
        account4.setPassWord("Pass Word");
        account4.setRoleId(role);
        account4.setTourList(new ArrayList<>());
        account4.setUser(user);
        account4.setUserBookingList(new ArrayList<>());

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

        CompanyPartner companyPartner3 = new CompanyPartner();
        companyPartner3.setAddress("42 Main St");
        companyPartner3.setBusinessCode("Business Code");
        companyPartner3.setCity("Oxford");
        companyPartner3.setCompanyName("Company Name");
        companyPartner3.setCompanyPartnerId(123L);
        companyPartner3.setEmail("jane.doe@example.org");
        companyPartner3.setFax("Fax");
        companyPartner3.setIncorporationDate("2020-03-01");
        companyPartner3.setPartnerId(new Partner());
        companyPartner3.setPhone("4105551212");
        companyPartner3.setRegistrationDate("2020-03-01");
        companyPartner3.setShortName("Short Name");
        companyPartner3.setTaxCode("Tax Code");
        companyPartner3.setWebsite("Website");

        ServiceCategory serviceCategory5 = new ServiceCategory();
        serviceCategory5.setPartnerList(new ArrayList<>());
        serviceCategory5.setServiceCategoryId(123L);
        serviceCategory5.setServiceCategoryName("Service Category Name");
        serviceCategory5.setServiceList(new ArrayList<>());

        Partner partner3 = new Partner();
        partner3.setAccountId(account5);
        partner3.setAddress("42 Main St");
        partner3.setBirthDate("2020-03-01");
        partner3.setCity("Oxford");
        partner3.setCompanyPartnerId(companyPartner3);
        partner3.setDateIssue("2020-03-01");
        partner3.setDepartment("Department");
        partner3.setEmail("jane.doe@example.org");
        partner3.setFirstName("Jane");
        partner3.setGender("Gender");
        partner3.setLastName("Doe");
        partner3.setNumberIdCard("42");
        partner3.setPartnerId(123L);
        partner3.setPhone("4105551212");
        partner3.setPlaceIssue("Place Issue");
        partner3.setPosition("Position");
        partner3.setServiceCategoryId(serviceCategory5);
        partner3.setServiceList(new ArrayList<>());

        CompanyPartner companyPartner4 = new CompanyPartner();
        companyPartner4.setAddress("42 Main St");
        companyPartner4.setBusinessCode("Business Code");
        companyPartner4.setCity("Oxford");
        companyPartner4.setCompanyName("Company Name");
        companyPartner4.setCompanyPartnerId(123L);
        companyPartner4.setEmail("jane.doe@example.org");
        companyPartner4.setFax("Fax");
        companyPartner4.setIncorporationDate("2020-03-01");
        companyPartner4.setPartnerId(partner3);
        companyPartner4.setPhone("4105551212");
        companyPartner4.setRegistrationDate("2020-03-01");
        companyPartner4.setShortName("Short Name");
        companyPartner4.setTaxCode("Tax Code");
        companyPartner4.setWebsite("Website");

        ServiceCategory serviceCategory6 = new ServiceCategory();
        serviceCategory6.setPartnerList(new ArrayList<>());
        serviceCategory6.setServiceCategoryId(123L);
        serviceCategory6.setServiceCategoryName("Service Category Name");
        serviceCategory6.setServiceList(new ArrayList<>());

        Partner partner4 = new Partner();
        partner4.setAccountId(account4);
        partner4.setAddress("42 Main St");
        partner4.setBirthDate("2020-03-01");
        partner4.setCity("Oxford");
        partner4.setCompanyPartnerId(companyPartner4);
        partner4.setDateIssue("2020-03-01");
        partner4.setDepartment("Department");
        partner4.setEmail("jane.doe@example.org");
        partner4.setFirstName("Jane");
        partner4.setGender("Gender");
        partner4.setLastName("Doe");
        partner4.setNumberIdCard("42");
        partner4.setPartnerId(123L);
        partner4.setPhone("4105551212");
        partner4.setPlaceIssue("Place Issue");
        partner4.setPosition("Position");
        partner4.setServiceCategoryId(serviceCategory6);
        partner4.setServiceList(new ArrayList<>());

        Service service8 = new Service();
        service8.setAccommodation(new Accommodation());
        service8.setAddress("42 Main St");
        service8.setCity("Oxford");
        service8.setDateRegister(null);
        service8.setEmail("jane.doe@example.org");
        service8.setEntertainment(new Entertainment());
        service8.setFax("Fax");
        service8.setIsActive(true);
        service8.setIsBlock(true);
        service8.setLink("Link");
        service8.setPartnerId(new Partner());
        service8.setPhone("4105551212");
        service8.setPostList(new ArrayList<>());
        service8.setRestaurant(new Restaurant());
        service8.setServiceCategoryId(new ServiceCategory());
        service8.setServiceId(123L);
        service8.setServiceName("Service Name");
        service8.setStatus(1);
        service8.setTaxCode("Tax Code");
        service8.setUtilitiesServiceList(new ArrayList<>());

        Accommodation accommodation3 = new Accommodation();
        accommodation3.setAccommodationId(123L);
        accommodation3.setAccommodationType("Accommodation Type");
        accommodation3.setDescription("The characteristics of someone or something");
        accommodation3.setNumberFloors(10);
        accommodation3.setRate(10.0f);
        accommodation3.setRoomList(new ArrayList<>());
        accommodation3.setServiceId(service8);

        Service service9 = new Service();
        service9.setAccommodation(new Accommodation());
        service9.setAddress("42 Main St");
        service9.setCity("Oxford");
        service9.setDateRegister(null);
        service9.setEmail("jane.doe@example.org");
        service9.setEntertainment(new Entertainment());
        service9.setFax("Fax");
        service9.setIsActive(true);
        service9.setIsBlock(true);
        service9.setLink("Link");
        service9.setPartnerId(new Partner());
        service9.setPhone("4105551212");
        service9.setPostList(new ArrayList<>());
        service9.setRestaurant(new Restaurant());
        service9.setServiceCategoryId(new ServiceCategory());
        service9.setServiceId(123L);
        service9.setServiceName("Service Name");
        service9.setStatus(1);
        service9.setTaxCode("Tax Code");
        service9.setUtilitiesServiceList(new ArrayList<>());

        Entertainment entertainment3 = new Entertainment();
        entertainment3.setDescription("The characteristics of someone or something");
        entertainment3.setDowOpen("Dow Open");
        entertainment3.setEntertainmentId(123L);
        entertainment3.setEntertainmentType("Entertainment Type");
        entertainment3.setPriceTicketAdult(10.0f);
        entertainment3.setPriceTicketChildren(10.0f);
        entertainment3.setServiceId(service9);
        entertainment3.setTimeClose(LocalTime.of(1, 1));
        entertainment3.setTimeOpen(LocalTime.of(1, 1));

        Account account6 = new Account();
        account6.setAccountId(1234567890L);
        account6.setCommentList(new ArrayList<>());
        account6.setEmail("jane.doe@example.org");
        account6.setFeedbackList(new ArrayList<>());
        account6.setIsBlock(true);
        account6.setPartner(new Partner());
        account6.setPassWord("Pass Word");
        account6.setRoleId(new Role());
        account6.setTourList(new ArrayList<>());
        account6.setUser(new User());
        account6.setUserBookingList(new ArrayList<>());

        CompanyPartner companyPartner5 = new CompanyPartner();
        companyPartner5.setAddress("42 Main St");
        companyPartner5.setBusinessCode("Business Code");
        companyPartner5.setCity("Oxford");
        companyPartner5.setCompanyName("Company Name");
        companyPartner5.setCompanyPartnerId(123L);
        companyPartner5.setEmail("jane.doe@example.org");
        companyPartner5.setFax("Fax");
        companyPartner5.setIncorporationDate("2020-03-01");
        companyPartner5.setPartnerId(new Partner());
        companyPartner5.setPhone("4105551212");
        companyPartner5.setRegistrationDate("2020-03-01");
        companyPartner5.setShortName("Short Name");
        companyPartner5.setTaxCode("Tax Code");
        companyPartner5.setWebsite("Website");

        ServiceCategory serviceCategory7 = new ServiceCategory();
        serviceCategory7.setPartnerList(new ArrayList<>());
        serviceCategory7.setServiceCategoryId(123L);
        serviceCategory7.setServiceCategoryName("Service Category Name");
        serviceCategory7.setServiceList(new ArrayList<>());

        Partner partner5 = new Partner();
        partner5.setAccountId(account6);
        partner5.setAddress("42 Main St");
        partner5.setBirthDate("2020-03-01");
        partner5.setCity("Oxford");
        partner5.setCompanyPartnerId(companyPartner5);
        partner5.setDateIssue("2020-03-01");
        partner5.setDepartment("Department");
        partner5.setEmail("jane.doe@example.org");
        partner5.setFirstName("Jane");
        partner5.setGender("Gender");
        partner5.setLastName("Doe");
        partner5.setNumberIdCard("42");
        partner5.setPartnerId(123L);
        partner5.setPhone("4105551212");
        partner5.setPlaceIssue("Place Issue");
        partner5.setPosition("Position");
        partner5.setServiceCategoryId(serviceCategory7);
        partner5.setServiceList(new ArrayList<>());

        Service service10 = new Service();
        service10.setAccommodation(new Accommodation());
        service10.setAddress("42 Main St");
        service10.setCity("Oxford");
        service10.setDateRegister(null);
        service10.setEmail("jane.doe@example.org");
        service10.setEntertainment(new Entertainment());
        service10.setFax("Fax");
        service10.setIsActive(true);
        service10.setIsBlock(true);
        service10.setLink("Link");
        service10.setPartnerId(new Partner());
        service10.setPhone("4105551212");
        service10.setPostList(new ArrayList<>());
        service10.setRestaurant(new Restaurant());
        service10.setServiceCategoryId(new ServiceCategory());
        service10.setServiceId(123L);
        service10.setServiceName("Service Name");
        service10.setStatus(1);
        service10.setTaxCode("Tax Code");
        service10.setUtilitiesServiceList(new ArrayList<>());

        Restaurant restaurant2 = new Restaurant();
        restaurant2.setDescription("The characteristics of someone or something");
        restaurant2.setRate(10.0f);
        restaurant2.setRestaurantId(123L);
        restaurant2.setRestaurantServiceType("Restaurant Service Type");
        restaurant2.setServiceId(service10);
        restaurant2.setTimeClose(LocalTime.of(1, 1));
        restaurant2.setTimeOpen(LocalTime.of(1, 1));
        restaurant2.setTypeOfCuisineServiceList(new ArrayList<>());

        ServiceCategory serviceCategory8 = new ServiceCategory();
        serviceCategory8.setPartnerList(new ArrayList<>());
        serviceCategory8.setServiceCategoryId(123L);
        serviceCategory8.setServiceCategoryName("Service Category Name");
        serviceCategory8.setServiceList(new ArrayList<>());

        Service service11 = new Service();
        service11.setAccommodation(accommodation3);
        service11.setAddress("42 Main St");
        service11.setCity("Oxford");
        service11.setDateRegister(LocalDate.ofEpochDay(1L));
        service11.setEmail("jane.doe@example.org");
        service11.setEntertainment(entertainment3);
        service11.setFax("Fax");
        service11.setIsActive(true);
        service11.setIsBlock(true);
        service11.setLink("Link");
        service11.setPartnerId(partner5);
        service11.setPhone("4105551212");
        service11.setPostList(new ArrayList<>());
        service11.setRestaurant(restaurant2);
        service11.setServiceCategoryId(serviceCategory8);
        service11.setServiceId(123L);
        service11.setServiceName("Service Name");
        service11.setStatus(1);
        service11.setTaxCode("Tax Code");
        service11.setUtilitiesServiceList(new ArrayList<>());

        Restaurant restaurant3 = new Restaurant();
        restaurant3.setDescription("The characteristics of someone or something");
        restaurant3.setRate(10.0f);
        restaurant3.setRestaurantId(123L);
        restaurant3.setRestaurantServiceType("Restaurant Service Type");
        restaurant3.setServiceId(service11);
        restaurant3.setTimeClose(LocalTime.of(1, 1));
        restaurant3.setTimeOpen(LocalTime.of(1, 1));
        restaurant3.setTypeOfCuisineServiceList(new ArrayList<>());

        ServiceCategory serviceCategory9 = new ServiceCategory();
        serviceCategory9.setPartnerList(new ArrayList<>());
        serviceCategory9.setServiceCategoryId(123L);
        serviceCategory9.setServiceCategoryName("Service Category Name");
        serviceCategory9.setServiceList(new ArrayList<>());

        Service service12 = new Service();
        service12.setAccommodation(accommodation1);
        service12.setAddress("42 Main St");
        service12.setCity("Oxford");
        service12.setDateRegister(LocalDate.ofEpochDay(1L));
        service12.setEmail("jane.doe@example.org");
        service12.setEntertainment(entertainment2);
        service12.setFax("Fax");
        service12.setIsActive(true);
        service12.setIsBlock(true);
        service12.setLink("Link");
        service12.setPartnerId(partner4);
        service12.setPhone("4105551212");
        service12.setPostList(new ArrayList<>());
        service12.setRestaurant(restaurant3);
        service12.setServiceCategoryId(serviceCategory9);
        service12.setServiceId(123L);
        service12.setServiceName("Service Name");
        service12.setStatus(1);
        service12.setTaxCode("Tax Code");
        service12.setUtilitiesServiceList(new ArrayList<>());
        when(serviceRepository.getById((Long) any())).thenReturn(service12);
        serviceServiceImpl.updateAccommodation(new AccommodationDTO(), 123L);
    }

    /**
     * Method under test: {@link ServiceServiceImpl#updateRestaurant(RestaurantDTO, Long)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testUpdateRestaurant() throws HandlerException {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at com.example.wetravel.Service.ServiceImpl.ServiceServiceImpl.updateService(ServiceServiceImpl.java:429)
        //       at com.example.wetravel.Service.ServiceImpl.ServiceServiceImpl.updateRestaurant(ServiceServiceImpl.java:498)
        //   See https://diff.blue/R013 to resolve this issue.

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

        Entertainment entertainment2 = new Entertainment();
        entertainment2.setDescription("The characteristics of someone or something");
        entertainment2.setDowOpen("Dow Open");
        entertainment2.setEntertainmentId(123L);
        entertainment2.setEntertainmentType("Entertainment Type");
        entertainment2.setPriceTicketAdult(10.0f);
        entertainment2.setPriceTicketChildren(10.0f);
        entertainment2.setServiceId(service7);
        entertainment2.setTimeClose(LocalTime.of(1, 1));
        entertainment2.setTimeOpen(LocalTime.of(1, 1));

        Account account2 = new Account();
        account2.setAccountId(1234567890L);
        account2.setCommentList(new ArrayList<>());
        account2.setEmail("jane.doe@example.org");
        account2.setFeedbackList(new ArrayList<>());
        account2.setIsBlock(true);
        account2.setPartner(new Partner());
        account2.setPassWord("Pass Word");
        account2.setRoleId(new Role());
        account2.setTourList(new ArrayList<>());
        account2.setUser(new User());
        account2.setUserBookingList(new ArrayList<>());

        CompanyPartner companyPartner2 = new CompanyPartner();
        companyPartner2.setAddress("42 Main St");
        companyPartner2.setBusinessCode("Business Code");
        companyPartner2.setCity("Oxford");
        companyPartner2.setCompanyName("Company Name");
        companyPartner2.setCompanyPartnerId(123L);
        companyPartner2.setEmail("jane.doe@example.org");
        companyPartner2.setFax("Fax");
        companyPartner2.setIncorporationDate("2020-03-01");
        companyPartner2.setPartnerId(new Partner());
        companyPartner2.setPhone("4105551212");
        companyPartner2.setRegistrationDate("2020-03-01");
        companyPartner2.setShortName("Short Name");
        companyPartner2.setTaxCode("Tax Code");
        companyPartner2.setWebsite("Website");

        ServiceCategory serviceCategory4 = new ServiceCategory();
        serviceCategory4.setPartnerList(new ArrayList<>());
        serviceCategory4.setServiceCategoryId(123L);
        serviceCategory4.setServiceCategoryName("Service Category Name");
        serviceCategory4.setServiceList(new ArrayList<>());

        Partner partner2 = new Partner();
        partner2.setAccountId(account2);
        partner2.setAddress("42 Main St");
        partner2.setBirthDate("2020-03-01");
        partner2.setCity("Oxford");
        partner2.setCompanyPartnerId(companyPartner2);
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
        partner2.setServiceCategoryId(serviceCategory4);
        partner2.setServiceList(new ArrayList<>());

        Role role = new Role();
        role.setAccountList(new ArrayList<>());
        role.setRoleId(123);
        role.setRoleName("Role Name");

        Account account3 = new Account();
        account3.setAccountId(1234567890L);
        account3.setCommentList(new ArrayList<>());
        account3.setEmail("jane.doe@example.org");
        account3.setFeedbackList(new ArrayList<>());
        account3.setIsBlock(true);
        account3.setPartner(new Partner());
        account3.setPassWord("Pass Word");
        account3.setRoleId(new Role());
        account3.setTourList(new ArrayList<>());
        account3.setUser(new User());
        account3.setUserBookingList(new ArrayList<>());

        User user = new User();
        user.setAccountId(account3);
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

        Account account4 = new Account();
        account4.setAccountId(1234567890L);
        account4.setCommentList(new ArrayList<>());
        account4.setEmail("jane.doe@example.org");
        account4.setFeedbackList(new ArrayList<>());
        account4.setIsBlock(true);
        account4.setPartner(partner2);
        account4.setPassWord("Pass Word");
        account4.setRoleId(role);
        account4.setTourList(new ArrayList<>());
        account4.setUser(user);
        account4.setUserBookingList(new ArrayList<>());

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

        CompanyPartner companyPartner3 = new CompanyPartner();
        companyPartner3.setAddress("42 Main St");
        companyPartner3.setBusinessCode("Business Code");
        companyPartner3.setCity("Oxford");
        companyPartner3.setCompanyName("Company Name");
        companyPartner3.setCompanyPartnerId(123L);
        companyPartner3.setEmail("jane.doe@example.org");
        companyPartner3.setFax("Fax");
        companyPartner3.setIncorporationDate("2020-03-01");
        companyPartner3.setPartnerId(new Partner());
        companyPartner3.setPhone("4105551212");
        companyPartner3.setRegistrationDate("2020-03-01");
        companyPartner3.setShortName("Short Name");
        companyPartner3.setTaxCode("Tax Code");
        companyPartner3.setWebsite("Website");

        ServiceCategory serviceCategory5 = new ServiceCategory();
        serviceCategory5.setPartnerList(new ArrayList<>());
        serviceCategory5.setServiceCategoryId(123L);
        serviceCategory5.setServiceCategoryName("Service Category Name");
        serviceCategory5.setServiceList(new ArrayList<>());

        Partner partner3 = new Partner();
        partner3.setAccountId(account5);
        partner3.setAddress("42 Main St");
        partner3.setBirthDate("2020-03-01");
        partner3.setCity("Oxford");
        partner3.setCompanyPartnerId(companyPartner3);
        partner3.setDateIssue("2020-03-01");
        partner3.setDepartment("Department");
        partner3.setEmail("jane.doe@example.org");
        partner3.setFirstName("Jane");
        partner3.setGender("Gender");
        partner3.setLastName("Doe");
        partner3.setNumberIdCard("42");
        partner3.setPartnerId(123L);
        partner3.setPhone("4105551212");
        partner3.setPlaceIssue("Place Issue");
        partner3.setPosition("Position");
        partner3.setServiceCategoryId(serviceCategory5);
        partner3.setServiceList(new ArrayList<>());

        CompanyPartner companyPartner4 = new CompanyPartner();
        companyPartner4.setAddress("42 Main St");
        companyPartner4.setBusinessCode("Business Code");
        companyPartner4.setCity("Oxford");
        companyPartner4.setCompanyName("Company Name");
        companyPartner4.setCompanyPartnerId(123L);
        companyPartner4.setEmail("jane.doe@example.org");
        companyPartner4.setFax("Fax");
        companyPartner4.setIncorporationDate("2020-03-01");
        companyPartner4.setPartnerId(partner3);
        companyPartner4.setPhone("4105551212");
        companyPartner4.setRegistrationDate("2020-03-01");
        companyPartner4.setShortName("Short Name");
        companyPartner4.setTaxCode("Tax Code");
        companyPartner4.setWebsite("Website");

        ServiceCategory serviceCategory6 = new ServiceCategory();
        serviceCategory6.setPartnerList(new ArrayList<>());
        serviceCategory6.setServiceCategoryId(123L);
        serviceCategory6.setServiceCategoryName("Service Category Name");
        serviceCategory6.setServiceList(new ArrayList<>());

        Partner partner4 = new Partner();
        partner4.setAccountId(account4);
        partner4.setAddress("42 Main St");
        partner4.setBirthDate("2020-03-01");
        partner4.setCity("Oxford");
        partner4.setCompanyPartnerId(companyPartner4);
        partner4.setDateIssue("2020-03-01");
        partner4.setDepartment("Department");
        partner4.setEmail("jane.doe@example.org");
        partner4.setFirstName("Jane");
        partner4.setGender("Gender");
        partner4.setLastName("Doe");
        partner4.setNumberIdCard("42");
        partner4.setPartnerId(123L);
        partner4.setPhone("4105551212");
        partner4.setPlaceIssue("Place Issue");
        partner4.setPosition("Position");
        partner4.setServiceCategoryId(serviceCategory6);
        partner4.setServiceList(new ArrayList<>());

        Service service8 = new Service();
        service8.setAccommodation(new Accommodation());
        service8.setAddress("42 Main St");
        service8.setCity("Oxford");
        service8.setDateRegister(null);
        service8.setEmail("jane.doe@example.org");
        service8.setEntertainment(new Entertainment());
        service8.setFax("Fax");
        service8.setIsActive(true);
        service8.setIsBlock(true);
        service8.setLink("Link");
        service8.setPartnerId(new Partner());
        service8.setPhone("4105551212");
        service8.setPostList(new ArrayList<>());
        service8.setRestaurant(new Restaurant());
        service8.setServiceCategoryId(new ServiceCategory());
        service8.setServiceId(123L);
        service8.setServiceName("Service Name");
        service8.setStatus(1);
        service8.setTaxCode("Tax Code");
        service8.setUtilitiesServiceList(new ArrayList<>());

        Accommodation accommodation3 = new Accommodation();
        accommodation3.setAccommodationId(123L);
        accommodation3.setAccommodationType("Accommodation Type");
        accommodation3.setDescription("The characteristics of someone or something");
        accommodation3.setNumberFloors(10);
        accommodation3.setRate(10.0f);
        accommodation3.setRoomList(new ArrayList<>());
        accommodation3.setServiceId(service8);

        Service service9 = new Service();
        service9.setAccommodation(new Accommodation());
        service9.setAddress("42 Main St");
        service9.setCity("Oxford");
        service9.setDateRegister(null);
        service9.setEmail("jane.doe@example.org");
        service9.setEntertainment(new Entertainment());
        service9.setFax("Fax");
        service9.setIsActive(true);
        service9.setIsBlock(true);
        service9.setLink("Link");
        service9.setPartnerId(new Partner());
        service9.setPhone("4105551212");
        service9.setPostList(new ArrayList<>());
        service9.setRestaurant(new Restaurant());
        service9.setServiceCategoryId(new ServiceCategory());
        service9.setServiceId(123L);
        service9.setServiceName("Service Name");
        service9.setStatus(1);
        service9.setTaxCode("Tax Code");
        service9.setUtilitiesServiceList(new ArrayList<>());

        Entertainment entertainment3 = new Entertainment();
        entertainment3.setDescription("The characteristics of someone or something");
        entertainment3.setDowOpen("Dow Open");
        entertainment3.setEntertainmentId(123L);
        entertainment3.setEntertainmentType("Entertainment Type");
        entertainment3.setPriceTicketAdult(10.0f);
        entertainment3.setPriceTicketChildren(10.0f);
        entertainment3.setServiceId(service9);
        entertainment3.setTimeClose(LocalTime.of(1, 1));
        entertainment3.setTimeOpen(LocalTime.of(1, 1));

        Account account6 = new Account();
        account6.setAccountId(1234567890L);
        account6.setCommentList(new ArrayList<>());
        account6.setEmail("jane.doe@example.org");
        account6.setFeedbackList(new ArrayList<>());
        account6.setIsBlock(true);
        account6.setPartner(new Partner());
        account6.setPassWord("Pass Word");
        account6.setRoleId(new Role());
        account6.setTourList(new ArrayList<>());
        account6.setUser(new User());
        account6.setUserBookingList(new ArrayList<>());

        CompanyPartner companyPartner5 = new CompanyPartner();
        companyPartner5.setAddress("42 Main St");
        companyPartner5.setBusinessCode("Business Code");
        companyPartner5.setCity("Oxford");
        companyPartner5.setCompanyName("Company Name");
        companyPartner5.setCompanyPartnerId(123L);
        companyPartner5.setEmail("jane.doe@example.org");
        companyPartner5.setFax("Fax");
        companyPartner5.setIncorporationDate("2020-03-01");
        companyPartner5.setPartnerId(new Partner());
        companyPartner5.setPhone("4105551212");
        companyPartner5.setRegistrationDate("2020-03-01");
        companyPartner5.setShortName("Short Name");
        companyPartner5.setTaxCode("Tax Code");
        companyPartner5.setWebsite("Website");

        ServiceCategory serviceCategory7 = new ServiceCategory();
        serviceCategory7.setPartnerList(new ArrayList<>());
        serviceCategory7.setServiceCategoryId(123L);
        serviceCategory7.setServiceCategoryName("Service Category Name");
        serviceCategory7.setServiceList(new ArrayList<>());

        Partner partner5 = new Partner();
        partner5.setAccountId(account6);
        partner5.setAddress("42 Main St");
        partner5.setBirthDate("2020-03-01");
        partner5.setCity("Oxford");
        partner5.setCompanyPartnerId(companyPartner5);
        partner5.setDateIssue("2020-03-01");
        partner5.setDepartment("Department");
        partner5.setEmail("jane.doe@example.org");
        partner5.setFirstName("Jane");
        partner5.setGender("Gender");
        partner5.setLastName("Doe");
        partner5.setNumberIdCard("42");
        partner5.setPartnerId(123L);
        partner5.setPhone("4105551212");
        partner5.setPlaceIssue("Place Issue");
        partner5.setPosition("Position");
        partner5.setServiceCategoryId(serviceCategory7);
        partner5.setServiceList(new ArrayList<>());

        Service service10 = new Service();
        service10.setAccommodation(new Accommodation());
        service10.setAddress("42 Main St");
        service10.setCity("Oxford");
        service10.setDateRegister(null);
        service10.setEmail("jane.doe@example.org");
        service10.setEntertainment(new Entertainment());
        service10.setFax("Fax");
        service10.setIsActive(true);
        service10.setIsBlock(true);
        service10.setLink("Link");
        service10.setPartnerId(new Partner());
        service10.setPhone("4105551212");
        service10.setPostList(new ArrayList<>());
        service10.setRestaurant(new Restaurant());
        service10.setServiceCategoryId(new ServiceCategory());
        service10.setServiceId(123L);
        service10.setServiceName("Service Name");
        service10.setStatus(1);
        service10.setTaxCode("Tax Code");
        service10.setUtilitiesServiceList(new ArrayList<>());

        Restaurant restaurant2 = new Restaurant();
        restaurant2.setDescription("The characteristics of someone or something");
        restaurant2.setRate(10.0f);
        restaurant2.setRestaurantId(123L);
        restaurant2.setRestaurantServiceType("Restaurant Service Type");
        restaurant2.setServiceId(service10);
        restaurant2.setTimeClose(LocalTime.of(1, 1));
        restaurant2.setTimeOpen(LocalTime.of(1, 1));
        restaurant2.setTypeOfCuisineServiceList(new ArrayList<>());

        ServiceCategory serviceCategory8 = new ServiceCategory();
        serviceCategory8.setPartnerList(new ArrayList<>());
        serviceCategory8.setServiceCategoryId(123L);
        serviceCategory8.setServiceCategoryName("Service Category Name");
        serviceCategory8.setServiceList(new ArrayList<>());

        Service service11 = new Service();
        service11.setAccommodation(accommodation3);
        service11.setAddress("42 Main St");
        service11.setCity("Oxford");
        service11.setDateRegister(LocalDate.ofEpochDay(1L));
        service11.setEmail("jane.doe@example.org");
        service11.setEntertainment(entertainment3);
        service11.setFax("Fax");
        service11.setIsActive(true);
        service11.setIsBlock(true);
        service11.setLink("Link");
        service11.setPartnerId(partner5);
        service11.setPhone("4105551212");
        service11.setPostList(new ArrayList<>());
        service11.setRestaurant(restaurant2);
        service11.setServiceCategoryId(serviceCategory8);
        service11.setServiceId(123L);
        service11.setServiceName("Service Name");
        service11.setStatus(1);
        service11.setTaxCode("Tax Code");
        service11.setUtilitiesServiceList(new ArrayList<>());

        Restaurant restaurant3 = new Restaurant();
        restaurant3.setDescription("The characteristics of someone or something");
        restaurant3.setRate(10.0f);
        restaurant3.setRestaurantId(123L);
        restaurant3.setRestaurantServiceType("Restaurant Service Type");
        restaurant3.setServiceId(service11);
        restaurant3.setTimeClose(LocalTime.of(1, 1));
        restaurant3.setTimeOpen(LocalTime.of(1, 1));
        restaurant3.setTypeOfCuisineServiceList(new ArrayList<>());

        ServiceCategory serviceCategory9 = new ServiceCategory();
        serviceCategory9.setPartnerList(new ArrayList<>());
        serviceCategory9.setServiceCategoryId(123L);
        serviceCategory9.setServiceCategoryName("Service Category Name");
        serviceCategory9.setServiceList(new ArrayList<>());

        Service service12 = new Service();
        service12.setAccommodation(accommodation1);
        service12.setAddress("42 Main St");
        service12.setCity("Oxford");
        service12.setDateRegister(LocalDate.ofEpochDay(1L));
        service12.setEmail("jane.doe@example.org");
        service12.setEntertainment(entertainment2);
        service12.setFax("Fax");
        service12.setIsActive(true);
        service12.setIsBlock(true);
        service12.setLink("Link");
        service12.setPartnerId(partner4);
        service12.setPhone("4105551212");
        service12.setPostList(new ArrayList<>());
        service12.setRestaurant(restaurant3);
        service12.setServiceCategoryId(serviceCategory9);
        service12.setServiceId(123L);
        service12.setServiceName("Service Name");
        service12.setStatus(1);
        service12.setTaxCode("Tax Code");
        service12.setUtilitiesServiceList(new ArrayList<>());
        when(serviceRepository.getById((Long) any())).thenReturn(service12);
        serviceServiceImpl.updateRestaurant(new RestaurantDTO(), 123L);
    }

    /**
     * Method under test: {@link ServiceServiceImpl#updateEntertainment(EntertainmentDTO, Long)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testUpdateEntertainment() throws HandlerException {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at com.example.wetravel.Service.ServiceImpl.ServiceServiceImpl.updateService(ServiceServiceImpl.java:429)
        //       at com.example.wetravel.Service.ServiceImpl.ServiceServiceImpl.updateEntertainment(ServiceServiceImpl.java:536)
        //   See https://diff.blue/R013 to resolve this issue.

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

        Entertainment entertainment2 = new Entertainment();
        entertainment2.setDescription("The characteristics of someone or something");
        entertainment2.setDowOpen("Dow Open");
        entertainment2.setEntertainmentId(123L);
        entertainment2.setEntertainmentType("Entertainment Type");
        entertainment2.setPriceTicketAdult(10.0f);
        entertainment2.setPriceTicketChildren(10.0f);
        entertainment2.setServiceId(service7);
        entertainment2.setTimeClose(LocalTime.of(1, 1));
        entertainment2.setTimeOpen(LocalTime.of(1, 1));

        Account account2 = new Account();
        account2.setAccountId(1234567890L);
        account2.setCommentList(new ArrayList<>());
        account2.setEmail("jane.doe@example.org");
        account2.setFeedbackList(new ArrayList<>());
        account2.setIsBlock(true);
        account2.setPartner(new Partner());
        account2.setPassWord("Pass Word");
        account2.setRoleId(new Role());
        account2.setTourList(new ArrayList<>());
        account2.setUser(new User());
        account2.setUserBookingList(new ArrayList<>());

        CompanyPartner companyPartner2 = new CompanyPartner();
        companyPartner2.setAddress("42 Main St");
        companyPartner2.setBusinessCode("Business Code");
        companyPartner2.setCity("Oxford");
        companyPartner2.setCompanyName("Company Name");
        companyPartner2.setCompanyPartnerId(123L);
        companyPartner2.setEmail("jane.doe@example.org");
        companyPartner2.setFax("Fax");
        companyPartner2.setIncorporationDate("2020-03-01");
        companyPartner2.setPartnerId(new Partner());
        companyPartner2.setPhone("4105551212");
        companyPartner2.setRegistrationDate("2020-03-01");
        companyPartner2.setShortName("Short Name");
        companyPartner2.setTaxCode("Tax Code");
        companyPartner2.setWebsite("Website");

        ServiceCategory serviceCategory4 = new ServiceCategory();
        serviceCategory4.setPartnerList(new ArrayList<>());
        serviceCategory4.setServiceCategoryId(123L);
        serviceCategory4.setServiceCategoryName("Service Category Name");
        serviceCategory4.setServiceList(new ArrayList<>());

        Partner partner2 = new Partner();
        partner2.setAccountId(account2);
        partner2.setAddress("42 Main St");
        partner2.setBirthDate("2020-03-01");
        partner2.setCity("Oxford");
        partner2.setCompanyPartnerId(companyPartner2);
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
        partner2.setServiceCategoryId(serviceCategory4);
        partner2.setServiceList(new ArrayList<>());

        Role role = new Role();
        role.setAccountList(new ArrayList<>());
        role.setRoleId(123);
        role.setRoleName("Role Name");

        Account account3 = new Account();
        account3.setAccountId(1234567890L);
        account3.setCommentList(new ArrayList<>());
        account3.setEmail("jane.doe@example.org");
        account3.setFeedbackList(new ArrayList<>());
        account3.setIsBlock(true);
        account3.setPartner(new Partner());
        account3.setPassWord("Pass Word");
        account3.setRoleId(new Role());
        account3.setTourList(new ArrayList<>());
        account3.setUser(new User());
        account3.setUserBookingList(new ArrayList<>());

        User user = new User();
        user.setAccountId(account3);
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

        Account account4 = new Account();
        account4.setAccountId(1234567890L);
        account4.setCommentList(new ArrayList<>());
        account4.setEmail("jane.doe@example.org");
        account4.setFeedbackList(new ArrayList<>());
        account4.setIsBlock(true);
        account4.setPartner(partner2);
        account4.setPassWord("Pass Word");
        account4.setRoleId(role);
        account4.setTourList(new ArrayList<>());
        account4.setUser(user);
        account4.setUserBookingList(new ArrayList<>());

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

        CompanyPartner companyPartner3 = new CompanyPartner();
        companyPartner3.setAddress("42 Main St");
        companyPartner3.setBusinessCode("Business Code");
        companyPartner3.setCity("Oxford");
        companyPartner3.setCompanyName("Company Name");
        companyPartner3.setCompanyPartnerId(123L);
        companyPartner3.setEmail("jane.doe@example.org");
        companyPartner3.setFax("Fax");
        companyPartner3.setIncorporationDate("2020-03-01");
        companyPartner3.setPartnerId(new Partner());
        companyPartner3.setPhone("4105551212");
        companyPartner3.setRegistrationDate("2020-03-01");
        companyPartner3.setShortName("Short Name");
        companyPartner3.setTaxCode("Tax Code");
        companyPartner3.setWebsite("Website");

        ServiceCategory serviceCategory5 = new ServiceCategory();
        serviceCategory5.setPartnerList(new ArrayList<>());
        serviceCategory5.setServiceCategoryId(123L);
        serviceCategory5.setServiceCategoryName("Service Category Name");
        serviceCategory5.setServiceList(new ArrayList<>());

        Partner partner3 = new Partner();
        partner3.setAccountId(account5);
        partner3.setAddress("42 Main St");
        partner3.setBirthDate("2020-03-01");
        partner3.setCity("Oxford");
        partner3.setCompanyPartnerId(companyPartner3);
        partner3.setDateIssue("2020-03-01");
        partner3.setDepartment("Department");
        partner3.setEmail("jane.doe@example.org");
        partner3.setFirstName("Jane");
        partner3.setGender("Gender");
        partner3.setLastName("Doe");
        partner3.setNumberIdCard("42");
        partner3.setPartnerId(123L);
        partner3.setPhone("4105551212");
        partner3.setPlaceIssue("Place Issue");
        partner3.setPosition("Position");
        partner3.setServiceCategoryId(serviceCategory5);
        partner3.setServiceList(new ArrayList<>());

        CompanyPartner companyPartner4 = new CompanyPartner();
        companyPartner4.setAddress("42 Main St");
        companyPartner4.setBusinessCode("Business Code");
        companyPartner4.setCity("Oxford");
        companyPartner4.setCompanyName("Company Name");
        companyPartner4.setCompanyPartnerId(123L);
        companyPartner4.setEmail("jane.doe@example.org");
        companyPartner4.setFax("Fax");
        companyPartner4.setIncorporationDate("2020-03-01");
        companyPartner4.setPartnerId(partner3);
        companyPartner4.setPhone("4105551212");
        companyPartner4.setRegistrationDate("2020-03-01");
        companyPartner4.setShortName("Short Name");
        companyPartner4.setTaxCode("Tax Code");
        companyPartner4.setWebsite("Website");

        ServiceCategory serviceCategory6 = new ServiceCategory();
        serviceCategory6.setPartnerList(new ArrayList<>());
        serviceCategory6.setServiceCategoryId(123L);
        serviceCategory6.setServiceCategoryName("Service Category Name");
        serviceCategory6.setServiceList(new ArrayList<>());

        Partner partner4 = new Partner();
        partner4.setAccountId(account4);
        partner4.setAddress("42 Main St");
        partner4.setBirthDate("2020-03-01");
        partner4.setCity("Oxford");
        partner4.setCompanyPartnerId(companyPartner4);
        partner4.setDateIssue("2020-03-01");
        partner4.setDepartment("Department");
        partner4.setEmail("jane.doe@example.org");
        partner4.setFirstName("Jane");
        partner4.setGender("Gender");
        partner4.setLastName("Doe");
        partner4.setNumberIdCard("42");
        partner4.setPartnerId(123L);
        partner4.setPhone("4105551212");
        partner4.setPlaceIssue("Place Issue");
        partner4.setPosition("Position");
        partner4.setServiceCategoryId(serviceCategory6);
        partner4.setServiceList(new ArrayList<>());

        Service service8 = new Service();
        service8.setAccommodation(new Accommodation());
        service8.setAddress("42 Main St");
        service8.setCity("Oxford");
        service8.setDateRegister(null);
        service8.setEmail("jane.doe@example.org");
        service8.setEntertainment(new Entertainment());
        service8.setFax("Fax");
        service8.setIsActive(true);
        service8.setIsBlock(true);
        service8.setLink("Link");
        service8.setPartnerId(new Partner());
        service8.setPhone("4105551212");
        service8.setPostList(new ArrayList<>());
        service8.setRestaurant(new Restaurant());
        service8.setServiceCategoryId(new ServiceCategory());
        service8.setServiceId(123L);
        service8.setServiceName("Service Name");
        service8.setStatus(1);
        service8.setTaxCode("Tax Code");
        service8.setUtilitiesServiceList(new ArrayList<>());

        Accommodation accommodation3 = new Accommodation();
        accommodation3.setAccommodationId(123L);
        accommodation3.setAccommodationType("Accommodation Type");
        accommodation3.setDescription("The characteristics of someone or something");
        accommodation3.setNumberFloors(10);
        accommodation3.setRate(10.0f);
        accommodation3.setRoomList(new ArrayList<>());
        accommodation3.setServiceId(service8);

        Service service9 = new Service();
        service9.setAccommodation(new Accommodation());
        service9.setAddress("42 Main St");
        service9.setCity("Oxford");
        service9.setDateRegister(null);
        service9.setEmail("jane.doe@example.org");
        service9.setEntertainment(new Entertainment());
        service9.setFax("Fax");
        service9.setIsActive(true);
        service9.setIsBlock(true);
        service9.setLink("Link");
        service9.setPartnerId(new Partner());
        service9.setPhone("4105551212");
        service9.setPostList(new ArrayList<>());
        service9.setRestaurant(new Restaurant());
        service9.setServiceCategoryId(new ServiceCategory());
        service9.setServiceId(123L);
        service9.setServiceName("Service Name");
        service9.setStatus(1);
        service9.setTaxCode("Tax Code");
        service9.setUtilitiesServiceList(new ArrayList<>());

        Entertainment entertainment3 = new Entertainment();
        entertainment3.setDescription("The characteristics of someone or something");
        entertainment3.setDowOpen("Dow Open");
        entertainment3.setEntertainmentId(123L);
        entertainment3.setEntertainmentType("Entertainment Type");
        entertainment3.setPriceTicketAdult(10.0f);
        entertainment3.setPriceTicketChildren(10.0f);
        entertainment3.setServiceId(service9);
        entertainment3.setTimeClose(LocalTime.of(1, 1));
        entertainment3.setTimeOpen(LocalTime.of(1, 1));

        Account account6 = new Account();
        account6.setAccountId(1234567890L);
        account6.setCommentList(new ArrayList<>());
        account6.setEmail("jane.doe@example.org");
        account6.setFeedbackList(new ArrayList<>());
        account6.setIsBlock(true);
        account6.setPartner(new Partner());
        account6.setPassWord("Pass Word");
        account6.setRoleId(new Role());
        account6.setTourList(new ArrayList<>());
        account6.setUser(new User());
        account6.setUserBookingList(new ArrayList<>());

        CompanyPartner companyPartner5 = new CompanyPartner();
        companyPartner5.setAddress("42 Main St");
        companyPartner5.setBusinessCode("Business Code");
        companyPartner5.setCity("Oxford");
        companyPartner5.setCompanyName("Company Name");
        companyPartner5.setCompanyPartnerId(123L);
        companyPartner5.setEmail("jane.doe@example.org");
        companyPartner5.setFax("Fax");
        companyPartner5.setIncorporationDate("2020-03-01");
        companyPartner5.setPartnerId(new Partner());
        companyPartner5.setPhone("4105551212");
        companyPartner5.setRegistrationDate("2020-03-01");
        companyPartner5.setShortName("Short Name");
        companyPartner5.setTaxCode("Tax Code");
        companyPartner5.setWebsite("Website");

        ServiceCategory serviceCategory7 = new ServiceCategory();
        serviceCategory7.setPartnerList(new ArrayList<>());
        serviceCategory7.setServiceCategoryId(123L);
        serviceCategory7.setServiceCategoryName("Service Category Name");
        serviceCategory7.setServiceList(new ArrayList<>());

        Partner partner5 = new Partner();
        partner5.setAccountId(account6);
        partner5.setAddress("42 Main St");
        partner5.setBirthDate("2020-03-01");
        partner5.setCity("Oxford");
        partner5.setCompanyPartnerId(companyPartner5);
        partner5.setDateIssue("2020-03-01");
        partner5.setDepartment("Department");
        partner5.setEmail("jane.doe@example.org");
        partner5.setFirstName("Jane");
        partner5.setGender("Gender");
        partner5.setLastName("Doe");
        partner5.setNumberIdCard("42");
        partner5.setPartnerId(123L);
        partner5.setPhone("4105551212");
        partner5.setPlaceIssue("Place Issue");
        partner5.setPosition("Position");
        partner5.setServiceCategoryId(serviceCategory7);
        partner5.setServiceList(new ArrayList<>());

        Service service10 = new Service();
        service10.setAccommodation(new Accommodation());
        service10.setAddress("42 Main St");
        service10.setCity("Oxford");
        service10.setDateRegister(null);
        service10.setEmail("jane.doe@example.org");
        service10.setEntertainment(new Entertainment());
        service10.setFax("Fax");
        service10.setIsActive(true);
        service10.setIsBlock(true);
        service10.setLink("Link");
        service10.setPartnerId(new Partner());
        service10.setPhone("4105551212");
        service10.setPostList(new ArrayList<>());
        service10.setRestaurant(new Restaurant());
        service10.setServiceCategoryId(new ServiceCategory());
        service10.setServiceId(123L);
        service10.setServiceName("Service Name");
        service10.setStatus(1);
        service10.setTaxCode("Tax Code");
        service10.setUtilitiesServiceList(new ArrayList<>());

        Restaurant restaurant2 = new Restaurant();
        restaurant2.setDescription("The characteristics of someone or something");
        restaurant2.setRate(10.0f);
        restaurant2.setRestaurantId(123L);
        restaurant2.setRestaurantServiceType("Restaurant Service Type");
        restaurant2.setServiceId(service10);
        restaurant2.setTimeClose(LocalTime.of(1, 1));
        restaurant2.setTimeOpen(LocalTime.of(1, 1));
        restaurant2.setTypeOfCuisineServiceList(new ArrayList<>());

        ServiceCategory serviceCategory8 = new ServiceCategory();
        serviceCategory8.setPartnerList(new ArrayList<>());
        serviceCategory8.setServiceCategoryId(123L);
        serviceCategory8.setServiceCategoryName("Service Category Name");
        serviceCategory8.setServiceList(new ArrayList<>());

        Service service11 = new Service();
        service11.setAccommodation(accommodation3);
        service11.setAddress("42 Main St");
        service11.setCity("Oxford");
        service11.setDateRegister(LocalDate.ofEpochDay(1L));
        service11.setEmail("jane.doe@example.org");
        service11.setEntertainment(entertainment3);
        service11.setFax("Fax");
        service11.setIsActive(true);
        service11.setIsBlock(true);
        service11.setLink("Link");
        service11.setPartnerId(partner5);
        service11.setPhone("4105551212");
        service11.setPostList(new ArrayList<>());
        service11.setRestaurant(restaurant2);
        service11.setServiceCategoryId(serviceCategory8);
        service11.setServiceId(123L);
        service11.setServiceName("Service Name");
        service11.setStatus(1);
        service11.setTaxCode("Tax Code");
        service11.setUtilitiesServiceList(new ArrayList<>());

        Restaurant restaurant3 = new Restaurant();
        restaurant3.setDescription("The characteristics of someone or something");
        restaurant3.setRate(10.0f);
        restaurant3.setRestaurantId(123L);
        restaurant3.setRestaurantServiceType("Restaurant Service Type");
        restaurant3.setServiceId(service11);
        restaurant3.setTimeClose(LocalTime.of(1, 1));
        restaurant3.setTimeOpen(LocalTime.of(1, 1));
        restaurant3.setTypeOfCuisineServiceList(new ArrayList<>());

        ServiceCategory serviceCategory9 = new ServiceCategory();
        serviceCategory9.setPartnerList(new ArrayList<>());
        serviceCategory9.setServiceCategoryId(123L);
        serviceCategory9.setServiceCategoryName("Service Category Name");
        serviceCategory9.setServiceList(new ArrayList<>());

        Service service12 = new Service();
        service12.setAccommodation(accommodation1);
        service12.setAddress("42 Main St");
        service12.setCity("Oxford");
        service12.setDateRegister(LocalDate.ofEpochDay(1L));
        service12.setEmail("jane.doe@example.org");
        service12.setEntertainment(entertainment2);
        service12.setFax("Fax");
        service12.setIsActive(true);
        service12.setIsBlock(true);
        service12.setLink("Link");
        service12.setPartnerId(partner4);
        service12.setPhone("4105551212");
        service12.setPostList(new ArrayList<>());
        service12.setRestaurant(restaurant3);
        service12.setServiceCategoryId(serviceCategory9);
        service12.setServiceId(123L);
        service12.setServiceName("Service Name");
        service12.setStatus(1);
        service12.setTaxCode("Tax Code");
        service12.setUtilitiesServiceList(new ArrayList<>());
        when(serviceRepository.getById((Long) any())).thenReturn(service12);
        serviceServiceImpl.updateEntertainment(new EntertainmentDTO(), 123L);
    }

    /**
     * Method under test: {@link ServiceServiceImpl#deleteService(Long)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testDeleteService() throws HandlerException {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at com.example.wetravel.Service.ServiceImpl.ServiceServiceImpl.deleteService(ServiceServiceImpl.java:564)
        //   See https://diff.blue/R013 to resolve this issue.

        (new ServiceServiceImpl()).deleteService(123L);
    }

    /**
     * Method under test: {@link ServiceServiceImpl#approveService(Long)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testApproveService() throws HandlerException {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at com.example.wetravel.Service.ServiceImpl.ServiceServiceImpl.approveService(ServiceServiceImpl.java:575)
        //   See https://diff.blue/R013 to resolve this issue.

        (new ServiceServiceImpl()).approveService(123L);
    }

    /**
     * Method under test: {@link ServiceServiceImpl#unblockService(Long)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testUnblockService() throws HandlerException {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at com.example.wetravel.Service.ServiceImpl.ServiceServiceImpl.unblockService(ServiceServiceImpl.java:588)
        //   See https://diff.blue/R013 to resolve this issue.

        (new ServiceServiceImpl()).unblockService(123L);
    }
}


package com.example.wetravel;

import com.example.wetravel.DTO.*;
import com.example.wetravel.Entity.*;
import com.example.wetravel.Exception.HandlerException;
import com.example.wetravel.Repository.*;
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

class ServiceServiceImplTest {

    private ServiceServiceImpl serviceServiceImplUnderTest;

    @BeforeEach
    void setUp() {
        serviceServiceImplUnderTest = new ServiceServiceImpl();
        serviceServiceImplUnderTest.partnerRepository = mock(PartnerRepository.class);
        serviceServiceImplUnderTest.serviceRepository = mock(ServiceRepository.class);
        serviceServiceImplUnderTest.serviceCategoryRepository = mock(ServiceCategoryRepository.class);
        serviceServiceImplUnderTest.accommodationRepository = mock(AccommodationRepository.class);
        serviceServiceImplUnderTest.restaurantRepository = mock(RestaurantRepository.class);
        serviceServiceImplUnderTest.entertainmentRepository = mock(EntertainmentRepository.class);
        serviceServiceImplUnderTest.roomRepository = mock(RoomRepository.class);
        serviceServiceImplUnderTest.utilitiesServiceRepository = mock(UtilitiesServiceRepository.class);
        serviceServiceImplUnderTest.utilitiesSubcategoryRepository = mock(UtilitiesSubcategoryRepository.class);
        serviceServiceImplUnderTest.typeOfCuisineRepository = mock(TypeOfCuisineRepository.class);
        serviceServiceImplUnderTest.typeOfCuisineServiceRepository = mock(TypeOfCuisineServiceRepository.class);
    }

    @Test
    void testGetAllServiceByCondition() throws Exception {
        // Setup
        // Configure ServiceRepository.getListServiceByCondition(...).
        final Service service = new Service();
        service.setServiceId(0L);
        service.setServiceName("serviceName");
        service.setFax("fax");
        service.setPhone("phone");
        service.setEmail("email");
        service.setAddress("address");
        service.setCity("city");
        service.setLink("link");
        service.setStatus(0);
        service.setTaxCode("taxCode");
        service.setDateRegister(LocalDate.of(2020, 1, 1));
        service.setIsActive(false);
        service.setIsBlock(false);
        final ServiceCategory serviceCategoryId = new ServiceCategory();
        serviceCategoryId.setServiceCategoryId(0L);
        service.setServiceCategoryId(serviceCategoryId);
        final Partner partnerId = new Partner();
        partnerId.setEmail("email");
        service.setPartnerId(partnerId);
        final List<Service> serviceList = Arrays.asList(service);
        when(serviceServiceImplUnderTest.serviceRepository.getListServiceByCondition("emailPartner", "serviceName", 0L,
                0, 0, 0)).thenReturn(serviceList);

        when(serviceServiceImplUnderTest.accommodationRepository.getTypeByServiceId(0L))
                .thenReturn("typeOfServiceCategory");
        when(serviceServiceImplUnderTest.entertainmentRepository.getTypeByServiceId(0L))
                .thenReturn("typeOfServiceCategory");
        when(serviceServiceImplUnderTest.restaurantRepository.getTypeByServiceId(0L))
                .thenReturn("typeOfServiceCategory");

        // Run the test
        final Page<ServiceDTO> result = serviceServiceImplUnderTest.getAllServiceByCondition("emailPartner",
                "serviceName", 0L, 0, 0, 0, 0, 0);

        // Verify the results
    }

    @Test
    void testGetAllServiceByCondition_ServiceRepositoryReturnsNoItems() {
        // Setup
        when(serviceServiceImplUnderTest.serviceRepository.getListServiceByCondition("emailPartner", "serviceName", 0L,
                0, 0, 0)).thenReturn(Collections.emptyList());

        // Run the test
        assertThatThrownBy(
                () -> serviceServiceImplUnderTest.getAllServiceByCondition("emailPartner", "serviceName", 0L, 0, 0, 0,
                        0, 0)).isInstanceOf(HandlerException.class);
    }

    @Test
    void testGetAllServiceByCondition_ThrowsHandlerException() {
        // Setup
        // Configure ServiceRepository.getListServiceByCondition(...).
        final Service service = new Service();
        service.setServiceId(0L);
        service.setServiceName("serviceName");
        service.setFax("fax");
        service.setPhone("phone");
        service.setEmail("email");
        service.setAddress("address");
        service.setCity("city");
        service.setLink("link");
        service.setStatus(0);
        service.setTaxCode("taxCode");
        service.setDateRegister(LocalDate.of(2020, 1, 1));
        service.setIsActive(false);
        service.setIsBlock(false);
        final ServiceCategory serviceCategoryId = new ServiceCategory();
        serviceCategoryId.setServiceCategoryId(0L);
        service.setServiceCategoryId(serviceCategoryId);
        final Partner partnerId = new Partner();
        partnerId.setEmail("email");
        service.setPartnerId(partnerId);
        final List<Service> serviceList = Arrays.asList(service);
        when(serviceServiceImplUnderTest.serviceRepository.getListServiceByCondition("emailPartner", "serviceName", 0L,
                0, 0, 0)).thenReturn(serviceList);

        when(serviceServiceImplUnderTest.accommodationRepository.getTypeByServiceId(0L))
                .thenReturn("typeOfServiceCategory");
        when(serviceServiceImplUnderTest.entertainmentRepository.getTypeByServiceId(0L))
                .thenReturn("typeOfServiceCategory");
        when(serviceServiceImplUnderTest.restaurantRepository.getTypeByServiceId(0L))
                .thenReturn("typeOfServiceCategory");

        // Run the test
        assertThatThrownBy(
                () -> serviceServiceImplUnderTest.getAllServiceByCondition("emailPartner", "serviceName", 0L, 0, 0, 0,
                        0, 0)).isInstanceOf(HandlerException.class);
    }

    @Test
    void testGetListServiceByPartnerId() throws Exception {
        // Setup
        // Configure ServiceRepository.getListServiceByPartnerId(...).
        final Service service = new Service();
        service.setServiceId(0L);
        service.setServiceName("serviceName");
        service.setFax("fax");
        service.setPhone("phone");
        service.setEmail("email");
        service.setAddress("address");
        service.setCity("city");
        service.setLink("link");
        service.setStatus(0);
        service.setTaxCode("taxCode");
        service.setDateRegister(LocalDate.of(2020, 1, 1));
        service.setIsActive(false);
        service.setIsBlock(false);
        final ServiceCategory serviceCategoryId = new ServiceCategory();
        serviceCategoryId.setServiceCategoryId(0L);
        service.setServiceCategoryId(serviceCategoryId);
        final Partner partnerId = new Partner();
        partnerId.setEmail("email");
        service.setPartnerId(partnerId);
        final Page<Service> servicePage = new PageImpl<>(Arrays.asList(service));
        when(serviceServiceImplUnderTest.serviceRepository.getListServiceByPartnerId(eq(0L),
                any(Pageable.class))).thenReturn(servicePage);

        when(serviceServiceImplUnderTest.accommodationRepository.getTypeByServiceId(0L))
                .thenReturn("typeOfServiceCategory");
        when(serviceServiceImplUnderTest.entertainmentRepository.getTypeByServiceId(0L))
                .thenReturn("typeOfServiceCategory");
        when(serviceServiceImplUnderTest.restaurantRepository.getTypeByServiceId(0L))
                .thenReturn("typeOfServiceCategory");

        // Run the test
        final Page<ServiceDTO> result = serviceServiceImplUnderTest.getListServiceByPartnerId(0L, 0, 0);

        // Verify the results
    }

    @Test
    void testGetListServiceByPartnerId_ServiceRepositoryReturnsNoItems() throws Exception {
        // Setup
        when(serviceServiceImplUnderTest.serviceRepository.getListServiceByPartnerId(eq(0L),
                any(Pageable.class))).thenReturn(new PageImpl<>(Collections.emptyList()));
        when(serviceServiceImplUnderTest.accommodationRepository.getTypeByServiceId(0L))
                .thenReturn("typeOfServiceCategory");
        when(serviceServiceImplUnderTest.entertainmentRepository.getTypeByServiceId(0L))
                .thenReturn("typeOfServiceCategory");
        when(serviceServiceImplUnderTest.restaurantRepository.getTypeByServiceId(0L))
                .thenReturn("typeOfServiceCategory");

        // Run the test
        final Page<ServiceDTO> result = serviceServiceImplUnderTest.getListServiceByPartnerId(0L, 0, 0);

        // Verify the results
    }

    @Test
    void testGetListServiceByPartnerId_ThrowsHandlerException() {
        // Setup
        // Configure ServiceRepository.getListServiceByPartnerId(...).
        final Service service = new Service();
        service.setServiceId(0L);
        service.setServiceName("serviceName");
        service.setFax("fax");
        service.setPhone("phone");
        service.setEmail("email");
        service.setAddress("address");
        service.setCity("city");
        service.setLink("link");
        service.setStatus(0);
        service.setTaxCode("taxCode");
        service.setDateRegister(LocalDate.of(2020, 1, 1));
        service.setIsActive(false);
        service.setIsBlock(false);
        final ServiceCategory serviceCategoryId = new ServiceCategory();
        serviceCategoryId.setServiceCategoryId(0L);
        service.setServiceCategoryId(serviceCategoryId);
        final Partner partnerId = new Partner();
        partnerId.setEmail("email");
        service.setPartnerId(partnerId);
        final Page<Service> servicePage = new PageImpl<>(Arrays.asList(service));
        when(serviceServiceImplUnderTest.serviceRepository.getListServiceByPartnerId(eq(0L),
                any(Pageable.class))).thenReturn(servicePage);

        when(serviceServiceImplUnderTest.accommodationRepository.getTypeByServiceId(0L))
                .thenReturn("typeOfServiceCategory");
        when(serviceServiceImplUnderTest.entertainmentRepository.getTypeByServiceId(0L))
                .thenReturn("typeOfServiceCategory");
        when(serviceServiceImplUnderTest.restaurantRepository.getTypeByServiceId(0L))
                .thenReturn("typeOfServiceCategory");

        // Run the test
        assertThatThrownBy(() -> serviceServiceImplUnderTest.getListServiceByPartnerId(0L, 0, 0))
                .isInstanceOf(HandlerException.class);
    }

    @Test
    void testGetDetailAccommodation() throws Exception {
        // Setup
        // Configure ServiceRepository.getById(...).
        final Service service = new Service();
        service.setServiceId(0L);
        service.setServiceName("serviceName");
        service.setFax("fax");
        service.setPhone("phone");
        service.setEmail("email");
        service.setAddress("address");
        service.setCity("city");
        service.setLink("link");
        service.setStatus(0);
        service.setTaxCode("taxCode");
        service.setDateRegister(LocalDate.of(2020, 1, 1));
        service.setIsActive(false);
        service.setIsBlock(false);
        final ServiceCategory serviceCategoryId = new ServiceCategory();
        serviceCategoryId.setServiceCategoryId(0L);
        service.setServiceCategoryId(serviceCategoryId);
        final Partner partnerId = new Partner();
        partnerId.setEmail("email");
        service.setPartnerId(partnerId);
        when(serviceServiceImplUnderTest.serviceRepository.getById(0L)).thenReturn(service);

        when(serviceServiceImplUnderTest.serviceRepository.existsById(0L)).thenReturn(false);

        // Configure AccommodationRepository.getByServiceId(...).
        final Accommodation accommodation = new Accommodation();
        accommodation.setAccommodationId(0L);
        accommodation.setAccommodationType("accommodationType");
        accommodation.setRate(0.0f);
        accommodation.setNumberFloors(0);
        accommodation.setDescription("description");
        final Service serviceId = new Service();
        serviceId.setServiceId(0L);
        serviceId.setServiceName("serviceName");
        serviceId.setFax("fax");
        serviceId.setPhone("phone");
        serviceId.setEmail("email");
        serviceId.setAddress("address");
        serviceId.setCity("city");
        serviceId.setLink("link");
        serviceId.setStatus(0);
        serviceId.setTaxCode("taxCode");
        serviceId.setDateRegister(LocalDate.of(2020, 1, 1));
        serviceId.setIsActive(false);
        serviceId.setIsBlock(false);
        final ServiceCategory serviceCategoryId1 = new ServiceCategory();
        serviceCategoryId1.setServiceCategoryId(0L);
        serviceId.setServiceCategoryId(serviceCategoryId1);
        final Partner partnerId1 = new Partner();
        partnerId1.setEmail("email");
        serviceId.setPartnerId(partnerId1);
        accommodation.setServiceId(serviceId);
        when(serviceServiceImplUnderTest.accommodationRepository.getByServiceId(0L)).thenReturn(accommodation);

        // Configure RoomRepository.getListRoomByAccommodationId(...).
        final Room room = new Room();
        room.setRoomName("roomName");
        room.setRoomType("roomType");
        room.setArea(0.0f);
        room.setNumberRooms(0);
        room.setNumberOfPeople(0);
        room.setDailyPrice(0.0f);
        room.setHolidayPrice(0.0f);
        room.setDescription("description");
        room.setBedType("bedType");
        final Accommodation accommodationId = new Accommodation();
        accommodationId.setAccommodationId(0L);
        accommodationId.setAccommodationType("accommodationType");
        accommodationId.setRate(0.0f);
        accommodationId.setNumberFloors(0);
        accommodationId.setDescription("description");
        final Service serviceId1 = new Service();
        serviceId1.setServiceId(0L);
        serviceId1.setServiceName("serviceName");
        serviceId1.setFax("fax");
        serviceId1.setPhone("phone");
        serviceId1.setEmail("email");
        serviceId1.setAddress("address");
        serviceId1.setCity("city");
        serviceId1.setLink("link");
        serviceId1.setStatus(0);
        serviceId1.setTaxCode("taxCode");
        serviceId1.setDateRegister(LocalDate.of(2020, 1, 1));
        serviceId1.setIsActive(false);
        serviceId1.setIsBlock(false);
        final ServiceCategory serviceCategoryId2 = new ServiceCategory();
        serviceCategoryId2.setServiceCategoryId(0L);
        serviceId1.setServiceCategoryId(serviceCategoryId2);
        final Partner partnerId2 = new Partner();
        partnerId2.setEmail("email");
        serviceId1.setPartnerId(partnerId2);
        accommodationId.setServiceId(serviceId1);
        room.setAccommodationId(accommodationId);
        final List<Room> roomList = Arrays.asList(room);
        when(serviceServiceImplUnderTest.roomRepository.getListRoomByAccommodationId(0L)).thenReturn(roomList);

        // Configure UtilitiesServiceRepository.getListUtilitiesServiceByServiceId(...).
        final UtilitiesService utilitiesService = new UtilitiesService();
        final Service serviceId2 = new Service();
        serviceId2.setServiceId(0L);
        serviceId2.setServiceName("serviceName");
        serviceId2.setFax("fax");
        serviceId2.setPhone("phone");
        serviceId2.setEmail("email");
        serviceId2.setAddress("address");
        serviceId2.setCity("city");
        serviceId2.setLink("link");
        serviceId2.setStatus(0);
        serviceId2.setTaxCode("taxCode");
        serviceId2.setDateRegister(LocalDate.of(2020, 1, 1));
        serviceId2.setIsActive(false);
        serviceId2.setIsBlock(false);
        final ServiceCategory serviceCategoryId3 = new ServiceCategory();
        serviceCategoryId3.setServiceCategoryId(0L);
        serviceId2.setServiceCategoryId(serviceCategoryId3);
        final Partner partnerId3 = new Partner();
        partnerId3.setEmail("email");
        serviceId2.setPartnerId(partnerId3);
        utilitiesService.setServiceId(serviceId2);
        final UtilitiesSubcategory utilitiesSubcategoryId = new UtilitiesSubcategory();
        utilitiesSubcategoryId.setUtilitiesSubcategoryId(0L);
        final UtilitiesCategory utilitiesCategoryId = new UtilitiesCategory();
        utilitiesCategoryId.setUtilitiesCategoryId(0L);
        utilitiesSubcategoryId.setUtilitiesCategoryId(utilitiesCategoryId);
        utilitiesService.setUtilitiesSubcategoryId(utilitiesSubcategoryId);
        final List<UtilitiesService> utilitiesServiceList = Arrays.asList(utilitiesService);
        when(serviceServiceImplUnderTest.utilitiesServiceRepository.getListUtilitiesServiceByServiceId(0L))
                .thenReturn(utilitiesServiceList);

        // Run the test
        final AccommodationDTO result = serviceServiceImplUnderTest.getDetailAccommodation(0L);

        // Verify the results
    }

    @Test
    void testGetDetailAccommodation_RoomRepositoryReturnsNoItems() throws Exception {
        // Setup
        // Configure ServiceRepository.getById(...).
        final Service service = new Service();
        service.setServiceId(0L);
        service.setServiceName("serviceName");
        service.setFax("fax");
        service.setPhone("phone");
        service.setEmail("email");
        service.setAddress("address");
        service.setCity("city");
        service.setLink("link");
        service.setStatus(0);
        service.setTaxCode("taxCode");
        service.setDateRegister(LocalDate.of(2020, 1, 1));
        service.setIsActive(false);
        service.setIsBlock(false);
        final ServiceCategory serviceCategoryId = new ServiceCategory();
        serviceCategoryId.setServiceCategoryId(0L);
        service.setServiceCategoryId(serviceCategoryId);
        final Partner partnerId = new Partner();
        partnerId.setEmail("email");
        service.setPartnerId(partnerId);
        when(serviceServiceImplUnderTest.serviceRepository.getById(0L)).thenReturn(service);

        when(serviceServiceImplUnderTest.serviceRepository.existsById(0L)).thenReturn(false);

        // Configure AccommodationRepository.getByServiceId(...).
        final Accommodation accommodation = new Accommodation();
        accommodation.setAccommodationId(0L);
        accommodation.setAccommodationType("accommodationType");
        accommodation.setRate(0.0f);
        accommodation.setNumberFloors(0);
        accommodation.setDescription("description");
        final Service serviceId = new Service();
        serviceId.setServiceId(0L);
        serviceId.setServiceName("serviceName");
        serviceId.setFax("fax");
        serviceId.setPhone("phone");
        serviceId.setEmail("email");
        serviceId.setAddress("address");
        serviceId.setCity("city");
        serviceId.setLink("link");
        serviceId.setStatus(0);
        serviceId.setTaxCode("taxCode");
        serviceId.setDateRegister(LocalDate.of(2020, 1, 1));
        serviceId.setIsActive(false);
        serviceId.setIsBlock(false);
        final ServiceCategory serviceCategoryId1 = new ServiceCategory();
        serviceCategoryId1.setServiceCategoryId(0L);
        serviceId.setServiceCategoryId(serviceCategoryId1);
        final Partner partnerId1 = new Partner();
        partnerId1.setEmail("email");
        serviceId.setPartnerId(partnerId1);
        accommodation.setServiceId(serviceId);
        when(serviceServiceImplUnderTest.accommodationRepository.getByServiceId(0L)).thenReturn(accommodation);

        when(serviceServiceImplUnderTest.roomRepository.getListRoomByAccommodationId(0L))
                .thenReturn(Collections.emptyList());

        // Configure UtilitiesServiceRepository.getListUtilitiesServiceByServiceId(...).
        final UtilitiesService utilitiesService = new UtilitiesService();
        final Service serviceId1 = new Service();
        serviceId1.setServiceId(0L);
        serviceId1.setServiceName("serviceName");
        serviceId1.setFax("fax");
        serviceId1.setPhone("phone");
        serviceId1.setEmail("email");
        serviceId1.setAddress("address");
        serviceId1.setCity("city");
        serviceId1.setLink("link");
        serviceId1.setStatus(0);
        serviceId1.setTaxCode("taxCode");
        serviceId1.setDateRegister(LocalDate.of(2020, 1, 1));
        serviceId1.setIsActive(false);
        serviceId1.setIsBlock(false);
        final ServiceCategory serviceCategoryId2 = new ServiceCategory();
        serviceCategoryId2.setServiceCategoryId(0L);
        serviceId1.setServiceCategoryId(serviceCategoryId2);
        final Partner partnerId2 = new Partner();
        partnerId2.setEmail("email");
        serviceId1.setPartnerId(partnerId2);
        utilitiesService.setServiceId(serviceId1);
        final UtilitiesSubcategory utilitiesSubcategoryId = new UtilitiesSubcategory();
        utilitiesSubcategoryId.setUtilitiesSubcategoryId(0L);
        final UtilitiesCategory utilitiesCategoryId = new UtilitiesCategory();
        utilitiesCategoryId.setUtilitiesCategoryId(0L);
        utilitiesSubcategoryId.setUtilitiesCategoryId(utilitiesCategoryId);
        utilitiesService.setUtilitiesSubcategoryId(utilitiesSubcategoryId);
        final List<UtilitiesService> utilitiesServiceList = Arrays.asList(utilitiesService);
        when(serviceServiceImplUnderTest.utilitiesServiceRepository.getListUtilitiesServiceByServiceId(0L))
                .thenReturn(utilitiesServiceList);

        // Run the test
        final AccommodationDTO result = serviceServiceImplUnderTest.getDetailAccommodation(0L);

        // Verify the results
    }

    @Test
    void testGetDetailAccommodation_UtilitiesServiceRepositoryReturnsNoItems() throws Exception {
        // Setup
        // Configure ServiceRepository.getById(...).
        final Service service = new Service();
        service.setServiceId(0L);
        service.setServiceName("serviceName");
        service.setFax("fax");
        service.setPhone("phone");
        service.setEmail("email");
        service.setAddress("address");
        service.setCity("city");
        service.setLink("link");
        service.setStatus(0);
        service.setTaxCode("taxCode");
        service.setDateRegister(LocalDate.of(2020, 1, 1));
        service.setIsActive(false);
        service.setIsBlock(false);
        final ServiceCategory serviceCategoryId = new ServiceCategory();
        serviceCategoryId.setServiceCategoryId(0L);
        service.setServiceCategoryId(serviceCategoryId);
        final Partner partnerId = new Partner();
        partnerId.setEmail("email");
        service.setPartnerId(partnerId);
        when(serviceServiceImplUnderTest.serviceRepository.getById(0L)).thenReturn(service);

        when(serviceServiceImplUnderTest.serviceRepository.existsById(0L)).thenReturn(false);

        // Configure AccommodationRepository.getByServiceId(...).
        final Accommodation accommodation = new Accommodation();
        accommodation.setAccommodationId(0L);
        accommodation.setAccommodationType("accommodationType");
        accommodation.setRate(0.0f);
        accommodation.setNumberFloors(0);
        accommodation.setDescription("description");
        final Service serviceId = new Service();
        serviceId.setServiceId(0L);
        serviceId.setServiceName("serviceName");
        serviceId.setFax("fax");
        serviceId.setPhone("phone");
        serviceId.setEmail("email");
        serviceId.setAddress("address");
        serviceId.setCity("city");
        serviceId.setLink("link");
        serviceId.setStatus(0);
        serviceId.setTaxCode("taxCode");
        serviceId.setDateRegister(LocalDate.of(2020, 1, 1));
        serviceId.setIsActive(false);
        serviceId.setIsBlock(false);
        final ServiceCategory serviceCategoryId1 = new ServiceCategory();
        serviceCategoryId1.setServiceCategoryId(0L);
        serviceId.setServiceCategoryId(serviceCategoryId1);
        final Partner partnerId1 = new Partner();
        partnerId1.setEmail("email");
        serviceId.setPartnerId(partnerId1);
        accommodation.setServiceId(serviceId);
        when(serviceServiceImplUnderTest.accommodationRepository.getByServiceId(0L)).thenReturn(accommodation);

        // Configure RoomRepository.getListRoomByAccommodationId(...).
        final Room room = new Room();
        room.setRoomName("roomName");
        room.setRoomType("roomType");
        room.setArea(0.0f);
        room.setNumberRooms(0);
        room.setNumberOfPeople(0);
        room.setDailyPrice(0.0f);
        room.setHolidayPrice(0.0f);
        room.setDescription("description");
        room.setBedType("bedType");
        final Accommodation accommodationId = new Accommodation();
        accommodationId.setAccommodationId(0L);
        accommodationId.setAccommodationType("accommodationType");
        accommodationId.setRate(0.0f);
        accommodationId.setNumberFloors(0);
        accommodationId.setDescription("description");
        final Service serviceId1 = new Service();
        serviceId1.setServiceId(0L);
        serviceId1.setServiceName("serviceName");
        serviceId1.setFax("fax");
        serviceId1.setPhone("phone");
        serviceId1.setEmail("email");
        serviceId1.setAddress("address");
        serviceId1.setCity("city");
        serviceId1.setLink("link");
        serviceId1.setStatus(0);
        serviceId1.setTaxCode("taxCode");
        serviceId1.setDateRegister(LocalDate.of(2020, 1, 1));
        serviceId1.setIsActive(false);
        serviceId1.setIsBlock(false);
        final ServiceCategory serviceCategoryId2 = new ServiceCategory();
        serviceCategoryId2.setServiceCategoryId(0L);
        serviceId1.setServiceCategoryId(serviceCategoryId2);
        final Partner partnerId2 = new Partner();
        partnerId2.setEmail("email");
        serviceId1.setPartnerId(partnerId2);
        accommodationId.setServiceId(serviceId1);
        room.setAccommodationId(accommodationId);
        final List<Room> roomList = Arrays.asList(room);
        when(serviceServiceImplUnderTest.roomRepository.getListRoomByAccommodationId(0L)).thenReturn(roomList);

        when(serviceServiceImplUnderTest.utilitiesServiceRepository.getListUtilitiesServiceByServiceId(0L))
                .thenReturn(Collections.emptyList());

        // Run the test
        final AccommodationDTO result = serviceServiceImplUnderTest.getDetailAccommodation(0L);

        // Verify the results
    }

    @Test
    void testGetDetailAccommodation_ThrowsHandlerException() {
        // Setup
        // Configure ServiceRepository.getById(...).
        final Service service = new Service();
        service.setServiceId(0L);
        service.setServiceName("serviceName");
        service.setFax("fax");
        service.setPhone("phone");
        service.setEmail("email");
        service.setAddress("address");
        service.setCity("city");
        service.setLink("link");
        service.setStatus(0);
        service.setTaxCode("taxCode");
        service.setDateRegister(LocalDate.of(2020, 1, 1));
        service.setIsActive(false);
        service.setIsBlock(false);
        final ServiceCategory serviceCategoryId = new ServiceCategory();
        serviceCategoryId.setServiceCategoryId(0L);
        service.setServiceCategoryId(serviceCategoryId);
        final Partner partnerId = new Partner();
        partnerId.setEmail("email");
        service.setPartnerId(partnerId);
        when(serviceServiceImplUnderTest.serviceRepository.getById(0L)).thenReturn(service);

        when(serviceServiceImplUnderTest.serviceRepository.existsById(0L)).thenReturn(false);

        // Configure AccommodationRepository.getByServiceId(...).
        final Accommodation accommodation = new Accommodation();
        accommodation.setAccommodationId(0L);
        accommodation.setAccommodationType("accommodationType");
        accommodation.setRate(0.0f);
        accommodation.setNumberFloors(0);
        accommodation.setDescription("description");
        final Service serviceId = new Service();
        serviceId.setServiceId(0L);
        serviceId.setServiceName("serviceName");
        serviceId.setFax("fax");
        serviceId.setPhone("phone");
        serviceId.setEmail("email");
        serviceId.setAddress("address");
        serviceId.setCity("city");
        serviceId.setLink("link");
        serviceId.setStatus(0);
        serviceId.setTaxCode("taxCode");
        serviceId.setDateRegister(LocalDate.of(2020, 1, 1));
        serviceId.setIsActive(false);
        serviceId.setIsBlock(false);
        final ServiceCategory serviceCategoryId1 = new ServiceCategory();
        serviceCategoryId1.setServiceCategoryId(0L);
        serviceId.setServiceCategoryId(serviceCategoryId1);
        final Partner partnerId1 = new Partner();
        partnerId1.setEmail("email");
        serviceId.setPartnerId(partnerId1);
        accommodation.setServiceId(serviceId);
        when(serviceServiceImplUnderTest.accommodationRepository.getByServiceId(0L)).thenReturn(accommodation);

        // Configure RoomRepository.getListRoomByAccommodationId(...).
        final Room room = new Room();
        room.setRoomName("roomName");
        room.setRoomType("roomType");
        room.setArea(0.0f);
        room.setNumberRooms(0);
        room.setNumberOfPeople(0);
        room.setDailyPrice(0.0f);
        room.setHolidayPrice(0.0f);
        room.setDescription("description");
        room.setBedType("bedType");
        final Accommodation accommodationId = new Accommodation();
        accommodationId.setAccommodationId(0L);
        accommodationId.setAccommodationType("accommodationType");
        accommodationId.setRate(0.0f);
        accommodationId.setNumberFloors(0);
        accommodationId.setDescription("description");
        final Service serviceId1 = new Service();
        serviceId1.setServiceId(0L);
        serviceId1.setServiceName("serviceName");
        serviceId1.setFax("fax");
        serviceId1.setPhone("phone");
        serviceId1.setEmail("email");
        serviceId1.setAddress("address");
        serviceId1.setCity("city");
        serviceId1.setLink("link");
        serviceId1.setStatus(0);
        serviceId1.setTaxCode("taxCode");
        serviceId1.setDateRegister(LocalDate.of(2020, 1, 1));
        serviceId1.setIsActive(false);
        serviceId1.setIsBlock(false);
        final ServiceCategory serviceCategoryId2 = new ServiceCategory();
        serviceCategoryId2.setServiceCategoryId(0L);
        serviceId1.setServiceCategoryId(serviceCategoryId2);
        final Partner partnerId2 = new Partner();
        partnerId2.setEmail("email");
        serviceId1.setPartnerId(partnerId2);
        accommodationId.setServiceId(serviceId1);
        room.setAccommodationId(accommodationId);
        final List<Room> roomList = Arrays.asList(room);
        when(serviceServiceImplUnderTest.roomRepository.getListRoomByAccommodationId(0L)).thenReturn(roomList);

        // Configure UtilitiesServiceRepository.getListUtilitiesServiceByServiceId(...).
        final UtilitiesService utilitiesService = new UtilitiesService();
        final Service serviceId2 = new Service();
        serviceId2.setServiceId(0L);
        serviceId2.setServiceName("serviceName");
        serviceId2.setFax("fax");
        serviceId2.setPhone("phone");
        serviceId2.setEmail("email");
        serviceId2.setAddress("address");
        serviceId2.setCity("city");
        serviceId2.setLink("link");
        serviceId2.setStatus(0);
        serviceId2.setTaxCode("taxCode");
        serviceId2.setDateRegister(LocalDate.of(2020, 1, 1));
        serviceId2.setIsActive(false);
        serviceId2.setIsBlock(false);
        final ServiceCategory serviceCategoryId3 = new ServiceCategory();
        serviceCategoryId3.setServiceCategoryId(0L);
        serviceId2.setServiceCategoryId(serviceCategoryId3);
        final Partner partnerId3 = new Partner();
        partnerId3.setEmail("email");
        serviceId2.setPartnerId(partnerId3);
        utilitiesService.setServiceId(serviceId2);
        final UtilitiesSubcategory utilitiesSubcategoryId = new UtilitiesSubcategory();
        utilitiesSubcategoryId.setUtilitiesSubcategoryId(0L);
        final UtilitiesCategory utilitiesCategoryId = new UtilitiesCategory();
        utilitiesCategoryId.setUtilitiesCategoryId(0L);
        utilitiesSubcategoryId.setUtilitiesCategoryId(utilitiesCategoryId);
        utilitiesService.setUtilitiesSubcategoryId(utilitiesSubcategoryId);
        final List<UtilitiesService> utilitiesServiceList = Arrays.asList(utilitiesService);
        when(serviceServiceImplUnderTest.utilitiesServiceRepository.getListUtilitiesServiceByServiceId(0L))
                .thenReturn(utilitiesServiceList);

        // Run the test
        assertThatThrownBy(() -> serviceServiceImplUnderTest.getDetailAccommodation(0L))
                .isInstanceOf(HandlerException.class);
    }

    @Test
    void testGetDetailRestaurant() throws Exception {
        // Setup
        // Configure ServiceRepository.getById(...).
        final Service service = new Service();
        service.setServiceId(0L);
        service.setServiceName("serviceName");
        service.setFax("fax");
        service.setPhone("phone");
        service.setEmail("email");
        service.setAddress("address");
        service.setCity("city");
        service.setLink("link");
        service.setStatus(0);
        service.setTaxCode("taxCode");
        service.setDateRegister(LocalDate.of(2020, 1, 1));
        service.setIsActive(false);
        service.setIsBlock(false);
        final ServiceCategory serviceCategoryId = new ServiceCategory();
        serviceCategoryId.setServiceCategoryId(0L);
        service.setServiceCategoryId(serviceCategoryId);
        final Partner partnerId = new Partner();
        partnerId.setEmail("email");
        service.setPartnerId(partnerId);
        when(serviceServiceImplUnderTest.serviceRepository.getById(0L)).thenReturn(service);

        when(serviceServiceImplUnderTest.serviceRepository.existsById(0L)).thenReturn(false);

        // Configure RestaurantRepository.getRestaurantByServiceId(...).
        final Restaurant restaurant = new Restaurant();
        restaurant.setRestaurantId(0L);
        restaurant.setRestaurantServiceType("restaurantServiceType");
        restaurant.setTimeOpen(LocalTime.of(12, 0, 0));
        restaurant.setTimeClose(LocalTime.of(12, 0, 0));
        restaurant.setDescription("description");
        restaurant.setRate(0.0f);
        final Service serviceId = new Service();
        serviceId.setServiceId(0L);
        serviceId.setServiceName("serviceName");
        serviceId.setFax("fax");
        serviceId.setPhone("phone");
        serviceId.setEmail("email");
        serviceId.setAddress("address");
        serviceId.setCity("city");
        serviceId.setLink("link");
        serviceId.setStatus(0);
        serviceId.setTaxCode("taxCode");
        serviceId.setDateRegister(LocalDate.of(2020, 1, 1));
        serviceId.setIsActive(false);
        serviceId.setIsBlock(false);
        final ServiceCategory serviceCategoryId1 = new ServiceCategory();
        serviceCategoryId1.setServiceCategoryId(0L);
        serviceId.setServiceCategoryId(serviceCategoryId1);
        final Partner partnerId1 = new Partner();
        partnerId1.setEmail("email");
        serviceId.setPartnerId(partnerId1);
        restaurant.setServiceId(serviceId);
        when(serviceServiceImplUnderTest.restaurantRepository.getRestaurantByServiceId(0L)).thenReturn(restaurant);

        // Configure TypeOfCuisineServiceRepository.getListTypeCuisineServiceByRestaurantId(...).
        final TypeOfCuisineService typeOfCuisineService = new TypeOfCuisineService();
        final Restaurant restaurantId = new Restaurant();
        restaurantId.setRestaurantId(0L);
        restaurantId.setRestaurantServiceType("restaurantServiceType");
        restaurantId.setTimeOpen(LocalTime.of(12, 0, 0));
        restaurantId.setTimeClose(LocalTime.of(12, 0, 0));
        restaurantId.setDescription("description");
        restaurantId.setRate(0.0f);
        final Service serviceId1 = new Service();
        serviceId1.setServiceId(0L);
        serviceId1.setServiceName("serviceName");
        serviceId1.setFax("fax");
        serviceId1.setPhone("phone");
        serviceId1.setEmail("email");
        serviceId1.setAddress("address");
        serviceId1.setCity("city");
        serviceId1.setLink("link");
        serviceId1.setStatus(0);
        serviceId1.setTaxCode("taxCode");
        serviceId1.setDateRegister(LocalDate.of(2020, 1, 1));
        serviceId1.setIsActive(false);
        serviceId1.setIsBlock(false);
        final ServiceCategory serviceCategoryId2 = new ServiceCategory();
        serviceCategoryId2.setServiceCategoryId(0L);
        serviceId1.setServiceCategoryId(serviceCategoryId2);
        final Partner partnerId2 = new Partner();
        partnerId2.setEmail("email");
        serviceId1.setPartnerId(partnerId2);
        restaurantId.setServiceId(serviceId1);
        typeOfCuisineService.setRestaurantId(restaurantId);
        final TypeOfCuisine typeCuisineId = new TypeOfCuisine();
        typeCuisineId.setTypeCuisineId(0L);
        typeOfCuisineService.setTypeCuisineId(typeCuisineId);
        final List<TypeOfCuisineService> typeOfCuisineServiceList = Arrays.asList(typeOfCuisineService);
        when(serviceServiceImplUnderTest.typeOfCuisineServiceRepository.getListTypeCuisineServiceByRestaurantId(
                0L)).thenReturn(typeOfCuisineServiceList);

        // Configure UtilitiesServiceRepository.getListUtilitiesServiceByServiceId(...).
        final UtilitiesService utilitiesService = new UtilitiesService();
        final Service serviceId2 = new Service();
        serviceId2.setServiceId(0L);
        serviceId2.setServiceName("serviceName");
        serviceId2.setFax("fax");
        serviceId2.setPhone("phone");
        serviceId2.setEmail("email");
        serviceId2.setAddress("address");
        serviceId2.setCity("city");
        serviceId2.setLink("link");
        serviceId2.setStatus(0);
        serviceId2.setTaxCode("taxCode");
        serviceId2.setDateRegister(LocalDate.of(2020, 1, 1));
        serviceId2.setIsActive(false);
        serviceId2.setIsBlock(false);
        final ServiceCategory serviceCategoryId3 = new ServiceCategory();
        serviceCategoryId3.setServiceCategoryId(0L);
        serviceId2.setServiceCategoryId(serviceCategoryId3);
        final Partner partnerId3 = new Partner();
        partnerId3.setEmail("email");
        serviceId2.setPartnerId(partnerId3);
        utilitiesService.setServiceId(serviceId2);
        final UtilitiesSubcategory utilitiesSubcategoryId = new UtilitiesSubcategory();
        utilitiesSubcategoryId.setUtilitiesSubcategoryId(0L);
        final UtilitiesCategory utilitiesCategoryId = new UtilitiesCategory();
        utilitiesCategoryId.setUtilitiesCategoryId(0L);
        utilitiesSubcategoryId.setUtilitiesCategoryId(utilitiesCategoryId);
        utilitiesService.setUtilitiesSubcategoryId(utilitiesSubcategoryId);
        final List<UtilitiesService> utilitiesServiceList = Arrays.asList(utilitiesService);
        when(serviceServiceImplUnderTest.utilitiesServiceRepository.getListUtilitiesServiceByServiceId(0L))
                .thenReturn(utilitiesServiceList);

        // Run the test
        final RestaurantDTO result = serviceServiceImplUnderTest.getDetailRestaurant(0L);

        // Verify the results
    }

    @Test
    void testGetDetailRestaurant_TypeOfCuisineServiceRepositoryReturnsNoItems() throws Exception {
        // Setup
        // Configure ServiceRepository.getById(...).
        final Service service = new Service();
        service.setServiceId(0L);
        service.setServiceName("serviceName");
        service.setFax("fax");
        service.setPhone("phone");
        service.setEmail("email");
        service.setAddress("address");
        service.setCity("city");
        service.setLink("link");
        service.setStatus(0);
        service.setTaxCode("taxCode");
        service.setDateRegister(LocalDate.of(2020, 1, 1));
        service.setIsActive(false);
        service.setIsBlock(false);
        final ServiceCategory serviceCategoryId = new ServiceCategory();
        serviceCategoryId.setServiceCategoryId(0L);
        service.setServiceCategoryId(serviceCategoryId);
        final Partner partnerId = new Partner();
        partnerId.setEmail("email");
        service.setPartnerId(partnerId);
        when(serviceServiceImplUnderTest.serviceRepository.getById(0L)).thenReturn(service);

        when(serviceServiceImplUnderTest.serviceRepository.existsById(0L)).thenReturn(false);

        // Configure RestaurantRepository.getRestaurantByServiceId(...).
        final Restaurant restaurant = new Restaurant();
        restaurant.setRestaurantId(0L);
        restaurant.setRestaurantServiceType("restaurantServiceType");
        restaurant.setTimeOpen(LocalTime.of(12, 0, 0));
        restaurant.setTimeClose(LocalTime.of(12, 0, 0));
        restaurant.setDescription("description");
        restaurant.setRate(0.0f);
        final Service serviceId = new Service();
        serviceId.setServiceId(0L);
        serviceId.setServiceName("serviceName");
        serviceId.setFax("fax");
        serviceId.setPhone("phone");
        serviceId.setEmail("email");
        serviceId.setAddress("address");
        serviceId.setCity("city");
        serviceId.setLink("link");
        serviceId.setStatus(0);
        serviceId.setTaxCode("taxCode");
        serviceId.setDateRegister(LocalDate.of(2020, 1, 1));
        serviceId.setIsActive(false);
        serviceId.setIsBlock(false);
        final ServiceCategory serviceCategoryId1 = new ServiceCategory();
        serviceCategoryId1.setServiceCategoryId(0L);
        serviceId.setServiceCategoryId(serviceCategoryId1);
        final Partner partnerId1 = new Partner();
        partnerId1.setEmail("email");
        serviceId.setPartnerId(partnerId1);
        restaurant.setServiceId(serviceId);
        when(serviceServiceImplUnderTest.restaurantRepository.getRestaurantByServiceId(0L)).thenReturn(restaurant);

        when(serviceServiceImplUnderTest.typeOfCuisineServiceRepository.getListTypeCuisineServiceByRestaurantId(
                0L)).thenReturn(Collections.emptyList());

        // Configure UtilitiesServiceRepository.getListUtilitiesServiceByServiceId(...).
        final UtilitiesService utilitiesService = new UtilitiesService();
        final Service serviceId1 = new Service();
        serviceId1.setServiceId(0L);
        serviceId1.setServiceName("serviceName");
        serviceId1.setFax("fax");
        serviceId1.setPhone("phone");
        serviceId1.setEmail("email");
        serviceId1.setAddress("address");
        serviceId1.setCity("city");
        serviceId1.setLink("link");
        serviceId1.setStatus(0);
        serviceId1.setTaxCode("taxCode");
        serviceId1.setDateRegister(LocalDate.of(2020, 1, 1));
        serviceId1.setIsActive(false);
        serviceId1.setIsBlock(false);
        final ServiceCategory serviceCategoryId2 = new ServiceCategory();
        serviceCategoryId2.setServiceCategoryId(0L);
        serviceId1.setServiceCategoryId(serviceCategoryId2);
        final Partner partnerId2 = new Partner();
        partnerId2.setEmail("email");
        serviceId1.setPartnerId(partnerId2);
        utilitiesService.setServiceId(serviceId1);
        final UtilitiesSubcategory utilitiesSubcategoryId = new UtilitiesSubcategory();
        utilitiesSubcategoryId.setUtilitiesSubcategoryId(0L);
        final UtilitiesCategory utilitiesCategoryId = new UtilitiesCategory();
        utilitiesCategoryId.setUtilitiesCategoryId(0L);
        utilitiesSubcategoryId.setUtilitiesCategoryId(utilitiesCategoryId);
        utilitiesService.setUtilitiesSubcategoryId(utilitiesSubcategoryId);
        final List<UtilitiesService> utilitiesServiceList = Arrays.asList(utilitiesService);
        when(serviceServiceImplUnderTest.utilitiesServiceRepository.getListUtilitiesServiceByServiceId(0L))
                .thenReturn(utilitiesServiceList);

        // Run the test
        final RestaurantDTO result = serviceServiceImplUnderTest.getDetailRestaurant(0L);

        // Verify the results
    }

    @Test
    void testGetDetailRestaurant_UtilitiesServiceRepositoryReturnsNoItems() throws Exception {
        // Setup
        // Configure ServiceRepository.getById(...).
        final Service service = new Service();
        service.setServiceId(0L);
        service.setServiceName("serviceName");
        service.setFax("fax");
        service.setPhone("phone");
        service.setEmail("email");
        service.setAddress("address");
        service.setCity("city");
        service.setLink("link");
        service.setStatus(0);
        service.setTaxCode("taxCode");
        service.setDateRegister(LocalDate.of(2020, 1, 1));
        service.setIsActive(false);
        service.setIsBlock(false);
        final ServiceCategory serviceCategoryId = new ServiceCategory();
        serviceCategoryId.setServiceCategoryId(0L);
        service.setServiceCategoryId(serviceCategoryId);
        final Partner partnerId = new Partner();
        partnerId.setEmail("email");
        service.setPartnerId(partnerId);
        when(serviceServiceImplUnderTest.serviceRepository.getById(0L)).thenReturn(service);

        when(serviceServiceImplUnderTest.serviceRepository.existsById(0L)).thenReturn(false);

        // Configure RestaurantRepository.getRestaurantByServiceId(...).
        final Restaurant restaurant = new Restaurant();
        restaurant.setRestaurantId(0L);
        restaurant.setRestaurantServiceType("restaurantServiceType");
        restaurant.setTimeOpen(LocalTime.of(12, 0, 0));
        restaurant.setTimeClose(LocalTime.of(12, 0, 0));
        restaurant.setDescription("description");
        restaurant.setRate(0.0f);
        final Service serviceId = new Service();
        serviceId.setServiceId(0L);
        serviceId.setServiceName("serviceName");
        serviceId.setFax("fax");
        serviceId.setPhone("phone");
        serviceId.setEmail("email");
        serviceId.setAddress("address");
        serviceId.setCity("city");
        serviceId.setLink("link");
        serviceId.setStatus(0);
        serviceId.setTaxCode("taxCode");
        serviceId.setDateRegister(LocalDate.of(2020, 1, 1));
        serviceId.setIsActive(false);
        serviceId.setIsBlock(false);
        final ServiceCategory serviceCategoryId1 = new ServiceCategory();
        serviceCategoryId1.setServiceCategoryId(0L);
        serviceId.setServiceCategoryId(serviceCategoryId1);
        final Partner partnerId1 = new Partner();
        partnerId1.setEmail("email");
        serviceId.setPartnerId(partnerId1);
        restaurant.setServiceId(serviceId);
        when(serviceServiceImplUnderTest.restaurantRepository.getRestaurantByServiceId(0L)).thenReturn(restaurant);

        // Configure TypeOfCuisineServiceRepository.getListTypeCuisineServiceByRestaurantId(...).
        final TypeOfCuisineService typeOfCuisineService = new TypeOfCuisineService();
        final Restaurant restaurantId = new Restaurant();
        restaurantId.setRestaurantId(0L);
        restaurantId.setRestaurantServiceType("restaurantServiceType");
        restaurantId.setTimeOpen(LocalTime.of(12, 0, 0));
        restaurantId.setTimeClose(LocalTime.of(12, 0, 0));
        restaurantId.setDescription("description");
        restaurantId.setRate(0.0f);
        final Service serviceId1 = new Service();
        serviceId1.setServiceId(0L);
        serviceId1.setServiceName("serviceName");
        serviceId1.setFax("fax");
        serviceId1.setPhone("phone");
        serviceId1.setEmail("email");
        serviceId1.setAddress("address");
        serviceId1.setCity("city");
        serviceId1.setLink("link");
        serviceId1.setStatus(0);
        serviceId1.setTaxCode("taxCode");
        serviceId1.setDateRegister(LocalDate.of(2020, 1, 1));
        serviceId1.setIsActive(false);
        serviceId1.setIsBlock(false);
        final ServiceCategory serviceCategoryId2 = new ServiceCategory();
        serviceCategoryId2.setServiceCategoryId(0L);
        serviceId1.setServiceCategoryId(serviceCategoryId2);
        final Partner partnerId2 = new Partner();
        partnerId2.setEmail("email");
        serviceId1.setPartnerId(partnerId2);
        restaurantId.setServiceId(serviceId1);
        typeOfCuisineService.setRestaurantId(restaurantId);
        final TypeOfCuisine typeCuisineId = new TypeOfCuisine();
        typeCuisineId.setTypeCuisineId(0L);
        typeOfCuisineService.setTypeCuisineId(typeCuisineId);
        final List<TypeOfCuisineService> typeOfCuisineServiceList = Arrays.asList(typeOfCuisineService);
        when(serviceServiceImplUnderTest.typeOfCuisineServiceRepository.getListTypeCuisineServiceByRestaurantId(
                0L)).thenReturn(typeOfCuisineServiceList);

        when(serviceServiceImplUnderTest.utilitiesServiceRepository.getListUtilitiesServiceByServiceId(0L))
                .thenReturn(Collections.emptyList());

        // Run the test
        final RestaurantDTO result = serviceServiceImplUnderTest.getDetailRestaurant(0L);

        // Verify the results
    }

    @Test
    void testGetDetailRestaurant_ThrowsHandlerException() {
        // Setup
        // Configure ServiceRepository.getById(...).
        final Service service = new Service();
        service.setServiceId(0L);
        service.setServiceName("serviceName");
        service.setFax("fax");
        service.setPhone("phone");
        service.setEmail("email");
        service.setAddress("address");
        service.setCity("city");
        service.setLink("link");
        service.setStatus(0);
        service.setTaxCode("taxCode");
        service.setDateRegister(LocalDate.of(2020, 1, 1));
        service.setIsActive(false);
        service.setIsBlock(false);
        final ServiceCategory serviceCategoryId = new ServiceCategory();
        serviceCategoryId.setServiceCategoryId(0L);
        service.setServiceCategoryId(serviceCategoryId);
        final Partner partnerId = new Partner();
        partnerId.setEmail("email");
        service.setPartnerId(partnerId);
        when(serviceServiceImplUnderTest.serviceRepository.getById(0L)).thenReturn(service);

        when(serviceServiceImplUnderTest.serviceRepository.existsById(0L)).thenReturn(false);

        // Configure RestaurantRepository.getRestaurantByServiceId(...).
        final Restaurant restaurant = new Restaurant();
        restaurant.setRestaurantId(0L);
        restaurant.setRestaurantServiceType("restaurantServiceType");
        restaurant.setTimeOpen(LocalTime.of(12, 0, 0));
        restaurant.setTimeClose(LocalTime.of(12, 0, 0));
        restaurant.setDescription("description");
        restaurant.setRate(0.0f);
        final Service serviceId = new Service();
        serviceId.setServiceId(0L);
        serviceId.setServiceName("serviceName");
        serviceId.setFax("fax");
        serviceId.setPhone("phone");
        serviceId.setEmail("email");
        serviceId.setAddress("address");
        serviceId.setCity("city");
        serviceId.setLink("link");
        serviceId.setStatus(0);
        serviceId.setTaxCode("taxCode");
        serviceId.setDateRegister(LocalDate.of(2020, 1, 1));
        serviceId.setIsActive(false);
        serviceId.setIsBlock(false);
        final ServiceCategory serviceCategoryId1 = new ServiceCategory();
        serviceCategoryId1.setServiceCategoryId(0L);
        serviceId.setServiceCategoryId(serviceCategoryId1);
        final Partner partnerId1 = new Partner();
        partnerId1.setEmail("email");
        serviceId.setPartnerId(partnerId1);
        restaurant.setServiceId(serviceId);
        when(serviceServiceImplUnderTest.restaurantRepository.getRestaurantByServiceId(0L)).thenReturn(restaurant);

        // Configure TypeOfCuisineServiceRepository.getListTypeCuisineServiceByRestaurantId(...).
        final TypeOfCuisineService typeOfCuisineService = new TypeOfCuisineService();
        final Restaurant restaurantId = new Restaurant();
        restaurantId.setRestaurantId(0L);
        restaurantId.setRestaurantServiceType("restaurantServiceType");
        restaurantId.setTimeOpen(LocalTime.of(12, 0, 0));
        restaurantId.setTimeClose(LocalTime.of(12, 0, 0));
        restaurantId.setDescription("description");
        restaurantId.setRate(0.0f);
        final Service serviceId1 = new Service();
        serviceId1.setServiceId(0L);
        serviceId1.setServiceName("serviceName");
        serviceId1.setFax("fax");
        serviceId1.setPhone("phone");
        serviceId1.setEmail("email");
        serviceId1.setAddress("address");
        serviceId1.setCity("city");
        serviceId1.setLink("link");
        serviceId1.setStatus(0);
        serviceId1.setTaxCode("taxCode");
        serviceId1.setDateRegister(LocalDate.of(2020, 1, 1));
        serviceId1.setIsActive(false);
        serviceId1.setIsBlock(false);
        final ServiceCategory serviceCategoryId2 = new ServiceCategory();
        serviceCategoryId2.setServiceCategoryId(0L);
        serviceId1.setServiceCategoryId(serviceCategoryId2);
        final Partner partnerId2 = new Partner();
        partnerId2.setEmail("email");
        serviceId1.setPartnerId(partnerId2);
        restaurantId.setServiceId(serviceId1);
        typeOfCuisineService.setRestaurantId(restaurantId);
        final TypeOfCuisine typeCuisineId = new TypeOfCuisine();
        typeCuisineId.setTypeCuisineId(0L);
        typeOfCuisineService.setTypeCuisineId(typeCuisineId);
        final List<TypeOfCuisineService> typeOfCuisineServiceList = Arrays.asList(typeOfCuisineService);
        when(serviceServiceImplUnderTest.typeOfCuisineServiceRepository.getListTypeCuisineServiceByRestaurantId(
                0L)).thenReturn(typeOfCuisineServiceList);

        // Configure UtilitiesServiceRepository.getListUtilitiesServiceByServiceId(...).
        final UtilitiesService utilitiesService = new UtilitiesService();
        final Service serviceId2 = new Service();
        serviceId2.setServiceId(0L);
        serviceId2.setServiceName("serviceName");
        serviceId2.setFax("fax");
        serviceId2.setPhone("phone");
        serviceId2.setEmail("email");
        serviceId2.setAddress("address");
        serviceId2.setCity("city");
        serviceId2.setLink("link");
        serviceId2.setStatus(0);
        serviceId2.setTaxCode("taxCode");
        serviceId2.setDateRegister(LocalDate.of(2020, 1, 1));
        serviceId2.setIsActive(false);
        serviceId2.setIsBlock(false);
        final ServiceCategory serviceCategoryId3 = new ServiceCategory();
        serviceCategoryId3.setServiceCategoryId(0L);
        serviceId2.setServiceCategoryId(serviceCategoryId3);
        final Partner partnerId3 = new Partner();
        partnerId3.setEmail("email");
        serviceId2.setPartnerId(partnerId3);
        utilitiesService.setServiceId(serviceId2);
        final UtilitiesSubcategory utilitiesSubcategoryId = new UtilitiesSubcategory();
        utilitiesSubcategoryId.setUtilitiesSubcategoryId(0L);
        final UtilitiesCategory utilitiesCategoryId = new UtilitiesCategory();
        utilitiesCategoryId.setUtilitiesCategoryId(0L);
        utilitiesSubcategoryId.setUtilitiesCategoryId(utilitiesCategoryId);
        utilitiesService.setUtilitiesSubcategoryId(utilitiesSubcategoryId);
        final List<UtilitiesService> utilitiesServiceList = Arrays.asList(utilitiesService);
        when(serviceServiceImplUnderTest.utilitiesServiceRepository.getListUtilitiesServiceByServiceId(0L))
                .thenReturn(utilitiesServiceList);

        // Run the test
        assertThatThrownBy(() -> serviceServiceImplUnderTest.getDetailRestaurant(0L))
                .isInstanceOf(HandlerException.class);
    }

    @Test
    void testGetDetailEntertainment() throws Exception {
        // Setup
        // Configure ServiceRepository.getById(...).
        final Service service = new Service();
        service.setServiceId(0L);
        service.setServiceName("serviceName");
        service.setFax("fax");
        service.setPhone("phone");
        service.setEmail("email");
        service.setAddress("address");
        service.setCity("city");
        service.setLink("link");
        service.setStatus(0);
        service.setTaxCode("taxCode");
        service.setDateRegister(LocalDate.of(2020, 1, 1));
        service.setIsActive(false);
        service.setIsBlock(false);
        final ServiceCategory serviceCategoryId = new ServiceCategory();
        serviceCategoryId.setServiceCategoryId(0L);
        service.setServiceCategoryId(serviceCategoryId);
        final Partner partnerId = new Partner();
        partnerId.setEmail("email");
        service.setPartnerId(partnerId);
        when(serviceServiceImplUnderTest.serviceRepository.getById(0L)).thenReturn(service);

        when(serviceServiceImplUnderTest.serviceRepository.existsById(0L)).thenReturn(false);

        // Configure EntertainmentRepository.getEntertainmentByServiceId(...).
        final Entertainment entertainment = new Entertainment();
        entertainment.setEntertainmentType("entertainmentType");
        entertainment.setDowOpen("dowOpen");
        entertainment.setTimeOpen(LocalTime.of(12, 0, 0));
        entertainment.setTimeClose(LocalTime.of(12, 0, 0));
        entertainment.setPriceTicketAdult(0.0f);
        entertainment.setPriceTicketChildren(0.0f);
        entertainment.setDescription("description");
        final Service serviceId = new Service();
        serviceId.setServiceId(0L);
        serviceId.setServiceName("serviceName");
        serviceId.setFax("fax");
        serviceId.setPhone("phone");
        serviceId.setEmail("email");
        serviceId.setAddress("address");
        serviceId.setCity("city");
        serviceId.setLink("link");
        serviceId.setStatus(0);
        serviceId.setTaxCode("taxCode");
        serviceId.setDateRegister(LocalDate.of(2020, 1, 1));
        serviceId.setIsActive(false);
        serviceId.setIsBlock(false);
        final ServiceCategory serviceCategoryId1 = new ServiceCategory();
        serviceCategoryId1.setServiceCategoryId(0L);
        serviceId.setServiceCategoryId(serviceCategoryId1);
        final Partner partnerId1 = new Partner();
        partnerId1.setEmail("email");
        serviceId.setPartnerId(partnerId1);
        entertainment.setServiceId(serviceId);
        when(serviceServiceImplUnderTest.entertainmentRepository.getEntertainmentByServiceId(0L))
                .thenReturn(entertainment);

        // Configure UtilitiesServiceRepository.getListUtilitiesServiceByServiceId(...).
        final UtilitiesService utilitiesService = new UtilitiesService();
        final Service serviceId1 = new Service();
        serviceId1.setServiceId(0L);
        serviceId1.setServiceName("serviceName");
        serviceId1.setFax("fax");
        serviceId1.setPhone("phone");
        serviceId1.setEmail("email");
        serviceId1.setAddress("address");
        serviceId1.setCity("city");
        serviceId1.setLink("link");
        serviceId1.setStatus(0);
        serviceId1.setTaxCode("taxCode");
        serviceId1.setDateRegister(LocalDate.of(2020, 1, 1));
        serviceId1.setIsActive(false);
        serviceId1.setIsBlock(false);
        final ServiceCategory serviceCategoryId2 = new ServiceCategory();
        serviceCategoryId2.setServiceCategoryId(0L);
        serviceId1.setServiceCategoryId(serviceCategoryId2);
        final Partner partnerId2 = new Partner();
        partnerId2.setEmail("email");
        serviceId1.setPartnerId(partnerId2);
        utilitiesService.setServiceId(serviceId1);
        final UtilitiesSubcategory utilitiesSubcategoryId = new UtilitiesSubcategory();
        utilitiesSubcategoryId.setUtilitiesSubcategoryId(0L);
        final UtilitiesCategory utilitiesCategoryId = new UtilitiesCategory();
        utilitiesCategoryId.setUtilitiesCategoryId(0L);
        utilitiesSubcategoryId.setUtilitiesCategoryId(utilitiesCategoryId);
        utilitiesService.setUtilitiesSubcategoryId(utilitiesSubcategoryId);
        final List<UtilitiesService> utilitiesServiceList = Arrays.asList(utilitiesService);
        when(serviceServiceImplUnderTest.utilitiesServiceRepository.getListUtilitiesServiceByServiceId(0L))
                .thenReturn(utilitiesServiceList);

        // Run the test
        final EntertainmentDTO result = serviceServiceImplUnderTest.getDetailEntertainment(0L);

        // Verify the results
    }

    @Test
    void testGetDetailEntertainment_UtilitiesServiceRepositoryReturnsNoItems() throws Exception {
        // Setup
        // Configure ServiceRepository.getById(...).
        final Service service = new Service();
        service.setServiceId(0L);
        service.setServiceName("serviceName");
        service.setFax("fax");
        service.setPhone("phone");
        service.setEmail("email");
        service.setAddress("address");
        service.setCity("city");
        service.setLink("link");
        service.setStatus(0);
        service.setTaxCode("taxCode");
        service.setDateRegister(LocalDate.of(2020, 1, 1));
        service.setIsActive(false);
        service.setIsBlock(false);
        final ServiceCategory serviceCategoryId = new ServiceCategory();
        serviceCategoryId.setServiceCategoryId(0L);
        service.setServiceCategoryId(serviceCategoryId);
        final Partner partnerId = new Partner();
        partnerId.setEmail("email");
        service.setPartnerId(partnerId);
        when(serviceServiceImplUnderTest.serviceRepository.getById(0L)).thenReturn(service);

        when(serviceServiceImplUnderTest.serviceRepository.existsById(0L)).thenReturn(false);

        // Configure EntertainmentRepository.getEntertainmentByServiceId(...).
        final Entertainment entertainment = new Entertainment();
        entertainment.setEntertainmentType("entertainmentType");
        entertainment.setDowOpen("dowOpen");
        entertainment.setTimeOpen(LocalTime.of(12, 0, 0));
        entertainment.setTimeClose(LocalTime.of(12, 0, 0));
        entertainment.setPriceTicketAdult(0.0f);
        entertainment.setPriceTicketChildren(0.0f);
        entertainment.setDescription("description");
        final Service serviceId = new Service();
        serviceId.setServiceId(0L);
        serviceId.setServiceName("serviceName");
        serviceId.setFax("fax");
        serviceId.setPhone("phone");
        serviceId.setEmail("email");
        serviceId.setAddress("address");
        serviceId.setCity("city");
        serviceId.setLink("link");
        serviceId.setStatus(0);
        serviceId.setTaxCode("taxCode");
        serviceId.setDateRegister(LocalDate.of(2020, 1, 1));
        serviceId.setIsActive(false);
        serviceId.setIsBlock(false);
        final ServiceCategory serviceCategoryId1 = new ServiceCategory();
        serviceCategoryId1.setServiceCategoryId(0L);
        serviceId.setServiceCategoryId(serviceCategoryId1);
        final Partner partnerId1 = new Partner();
        partnerId1.setEmail("email");
        serviceId.setPartnerId(partnerId1);
        entertainment.setServiceId(serviceId);
        when(serviceServiceImplUnderTest.entertainmentRepository.getEntertainmentByServiceId(0L))
                .thenReturn(entertainment);

        when(serviceServiceImplUnderTest.utilitiesServiceRepository.getListUtilitiesServiceByServiceId(0L))
                .thenReturn(Collections.emptyList());

        // Run the test
        final EntertainmentDTO result = serviceServiceImplUnderTest.getDetailEntertainment(0L);

        // Verify the results
    }

    @Test
    void testGetDetailEntertainment_ThrowsHandlerException() {
        // Setup
        // Configure ServiceRepository.getById(...).
        final Service service = new Service();
        service.setServiceId(0L);
        service.setServiceName("serviceName");
        service.setFax("fax");
        service.setPhone("phone");
        service.setEmail("email");
        service.setAddress("address");
        service.setCity("city");
        service.setLink("link");
        service.setStatus(0);
        service.setTaxCode("taxCode");
        service.setDateRegister(LocalDate.of(2020, 1, 1));
        service.setIsActive(false);
        service.setIsBlock(false);
        final ServiceCategory serviceCategoryId = new ServiceCategory();
        serviceCategoryId.setServiceCategoryId(0L);
        service.setServiceCategoryId(serviceCategoryId);
        final Partner partnerId = new Partner();
        partnerId.setEmail("email");
        service.setPartnerId(partnerId);
        when(serviceServiceImplUnderTest.serviceRepository.getById(0L)).thenReturn(service);

        when(serviceServiceImplUnderTest.serviceRepository.existsById(0L)).thenReturn(false);

        // Configure EntertainmentRepository.getEntertainmentByServiceId(...).
        final Entertainment entertainment = new Entertainment();
        entertainment.setEntertainmentType("entertainmentType");
        entertainment.setDowOpen("dowOpen");
        entertainment.setTimeOpen(LocalTime.of(12, 0, 0));
        entertainment.setTimeClose(LocalTime.of(12, 0, 0));
        entertainment.setPriceTicketAdult(0.0f);
        entertainment.setPriceTicketChildren(0.0f);
        entertainment.setDescription("description");
        final Service serviceId = new Service();
        serviceId.setServiceId(0L);
        serviceId.setServiceName("serviceName");
        serviceId.setFax("fax");
        serviceId.setPhone("phone");
        serviceId.setEmail("email");
        serviceId.setAddress("address");
        serviceId.setCity("city");
        serviceId.setLink("link");
        serviceId.setStatus(0);
        serviceId.setTaxCode("taxCode");
        serviceId.setDateRegister(LocalDate.of(2020, 1, 1));
        serviceId.setIsActive(false);
        serviceId.setIsBlock(false);
        final ServiceCategory serviceCategoryId1 = new ServiceCategory();
        serviceCategoryId1.setServiceCategoryId(0L);
        serviceId.setServiceCategoryId(serviceCategoryId1);
        final Partner partnerId1 = new Partner();
        partnerId1.setEmail("email");
        serviceId.setPartnerId(partnerId1);
        entertainment.setServiceId(serviceId);
        when(serviceServiceImplUnderTest.entertainmentRepository.getEntertainmentByServiceId(0L))
                .thenReturn(entertainment);

        // Configure UtilitiesServiceRepository.getListUtilitiesServiceByServiceId(...).
        final UtilitiesService utilitiesService = new UtilitiesService();
        final Service serviceId1 = new Service();
        serviceId1.setServiceId(0L);
        serviceId1.setServiceName("serviceName");
        serviceId1.setFax("fax");
        serviceId1.setPhone("phone");
        serviceId1.setEmail("email");
        serviceId1.setAddress("address");
        serviceId1.setCity("city");
        serviceId1.setLink("link");
        serviceId1.setStatus(0);
        serviceId1.setTaxCode("taxCode");
        serviceId1.setDateRegister(LocalDate.of(2020, 1, 1));
        serviceId1.setIsActive(false);
        serviceId1.setIsBlock(false);
        final ServiceCategory serviceCategoryId2 = new ServiceCategory();
        serviceCategoryId2.setServiceCategoryId(0L);
        serviceId1.setServiceCategoryId(serviceCategoryId2);
        final Partner partnerId2 = new Partner();
        partnerId2.setEmail("email");
        serviceId1.setPartnerId(partnerId2);
        utilitiesService.setServiceId(serviceId1);
        final UtilitiesSubcategory utilitiesSubcategoryId = new UtilitiesSubcategory();
        utilitiesSubcategoryId.setUtilitiesSubcategoryId(0L);
        final UtilitiesCategory utilitiesCategoryId = new UtilitiesCategory();
        utilitiesCategoryId.setUtilitiesCategoryId(0L);
        utilitiesSubcategoryId.setUtilitiesCategoryId(utilitiesCategoryId);
        utilitiesService.setUtilitiesSubcategoryId(utilitiesSubcategoryId);
        final List<UtilitiesService> utilitiesServiceList = Arrays.asList(utilitiesService);
        when(serviceServiceImplUnderTest.utilitiesServiceRepository.getListUtilitiesServiceByServiceId(0L))
                .thenReturn(utilitiesServiceList);

        // Run the test
        assertThatThrownBy(() -> serviceServiceImplUnderTest.getDetailEntertainment(0L))
                .isInstanceOf(HandlerException.class);
    }

    @Test
    void testAddService() throws Exception {
        // Setup
        final ServiceDTO serviceDTO = new ServiceDTO(0L, "serviceName", "fax", "phone", "email", "address", "city",
                "link", 0, "taxCode", false, false, 0L, "typeOfServiceCategory", "email");

        // Configure PartnerRepository.getPartnerByAccountEmail(...).
        final Partner partner = new Partner();
        partner.setPartnerId(0L);
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
        user.setFirstName("firstName");
        user.setLastName("lastName");
        accountId.setUser(user);
        partner.setAccountId(accountId);
        partner.setEmail("email");
        when(serviceServiceImplUnderTest.partnerRepository.getPartnerByAccountEmail("email")).thenReturn(partner);

        // Configure ServiceCategoryRepository.getById(...).
        final ServiceCategory serviceCategory = new ServiceCategory();
        serviceCategory.setServiceCategoryId(0L);
        serviceCategory.setServiceCategoryName("serviceCategoryName");
        final Service service = new Service();
        service.setServiceId(0L);
        service.setServiceName("serviceName");
        service.setFax("fax");
        service.setPhone("phone");
        service.setEmail("email");
        service.setAddress("address");
        service.setCity("city");
        service.setLink("link");
        service.setStatus(0);
        service.setTaxCode("taxCode");
        service.setDateRegister(LocalDate.of(2020, 1, 1));
        service.setIsActive(false);
        serviceCategory.setServiceList(Arrays.asList(service));
        when(serviceServiceImplUnderTest.serviceCategoryRepository.getById(0L)).thenReturn(serviceCategory);

        // Run the test
        final Service result = serviceServiceImplUnderTest.addService(serviceDTO);

        // Verify the results
    }

    @Test
    void testAddService_PartnerRepositoryReturnsNull() {
        // Setup
        final ServiceDTO serviceDTO = new ServiceDTO(0L, "serviceName", "fax", "phone", "email", "address", "city",
                "link", 0, "taxCode", false, false, 0L, "typeOfServiceCategory", "email");
        when(serviceServiceImplUnderTest.partnerRepository.getPartnerByAccountEmail("email")).thenReturn(null);

        // Run the test
        assertThatThrownBy(() -> serviceServiceImplUnderTest.addService(serviceDTO))
                .isInstanceOf(HandlerException.class);
    }

    @Test
    void testAddService_ThrowsHandlerException() {
        // Setup
        final ServiceDTO serviceDTO = new ServiceDTO(0L, "serviceName", "fax", "phone", "email", "address", "city",
                "link", 0, "taxCode", false, false, 0L, "typeOfServiceCategory", "email");

        // Configure PartnerRepository.getPartnerByAccountEmail(...).
        final Partner partner = new Partner();
        partner.setPartnerId(0L);
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
        user.setFirstName("firstName");
        user.setLastName("lastName");
        accountId.setUser(user);
        partner.setAccountId(accountId);
        partner.setEmail("email");
        when(serviceServiceImplUnderTest.partnerRepository.getPartnerByAccountEmail("email")).thenReturn(partner);

        // Configure ServiceCategoryRepository.getById(...).
        final ServiceCategory serviceCategory = new ServiceCategory();
        serviceCategory.setServiceCategoryId(0L);
        serviceCategory.setServiceCategoryName("serviceCategoryName");
        final Service service = new Service();
        service.setServiceId(0L);
        service.setServiceName("serviceName");
        service.setFax("fax");
        service.setPhone("phone");
        service.setEmail("email");
        service.setAddress("address");
        service.setCity("city");
        service.setLink("link");
        service.setStatus(0);
        service.setTaxCode("taxCode");
        service.setDateRegister(LocalDate.of(2020, 1, 1));
        service.setIsActive(false);
        serviceCategory.setServiceList(Arrays.asList(service));
        when(serviceServiceImplUnderTest.serviceCategoryRepository.getById(0L)).thenReturn(serviceCategory);

        // Run the test
        assertThatThrownBy(() -> serviceServiceImplUnderTest.addService(serviceDTO))
                .isInstanceOf(HandlerException.class);
    }

    @Test
    void testCreateAccommodation() throws Exception {
        // Setup
        final AccommodationDTO accommodationDTO = new AccommodationDTO(
                new ServiceDTO(0L, "serviceName", "fax", "phone", "email", "address", "city", "link", 0, "taxCode",
                        false, false, 0L, "typeOfServiceCategory", "email"), "accommodationType", 0.0f, 0,
                "description",
                Arrays.asList(new RoomDTO("roomName", "roomType", 0.0f, 0, 0, 0.0f, 0.0f, "description", "bedType")),
                Arrays.asList(new UtilitiesServiceDTO(0L, 0L)));

        // Configure PartnerRepository.getPartnerByAccountEmail(...).
        final Partner partner = new Partner();
        partner.setPartnerId(0L);
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
        user.setFirstName("firstName");
        user.setLastName("lastName");
        accountId.setUser(user);
        partner.setAccountId(accountId);
        partner.setEmail("email");
        when(serviceServiceImplUnderTest.partnerRepository.getPartnerByAccountEmail("email")).thenReturn(partner);

        // Configure ServiceCategoryRepository.getById(...).
        final ServiceCategory serviceCategory = new ServiceCategory();
        serviceCategory.setServiceCategoryId(0L);
        serviceCategory.setServiceCategoryName("serviceCategoryName");
        final Service service = new Service();
        service.setServiceId(0L);
        service.setServiceName("serviceName");
        service.setFax("fax");
        service.setPhone("phone");
        service.setEmail("email");
        service.setAddress("address");
        service.setCity("city");
        service.setLink("link");
        service.setStatus(0);
        service.setTaxCode("taxCode");
        service.setDateRegister(LocalDate.of(2020, 1, 1));
        service.setIsActive(false);
        serviceCategory.setServiceList(Arrays.asList(service));
        when(serviceServiceImplUnderTest.serviceCategoryRepository.getById(0L)).thenReturn(serviceCategory);

        // Configure RoomRepository.save(...).
        final Room room = new Room();
        room.setRoomName("roomName");
        room.setRoomType("roomType");
        room.setArea(0.0f);
        room.setNumberRooms(0);
        room.setNumberOfPeople(0);
        room.setDailyPrice(0.0f);
        room.setHolidayPrice(0.0f);
        room.setDescription("description");
        room.setBedType("bedType");
        final Accommodation accommodationId = new Accommodation();
        accommodationId.setAccommodationId(0L);
        accommodationId.setAccommodationType("accommodationType");
        accommodationId.setRate(0.0f);
        accommodationId.setNumberFloors(0);
        accommodationId.setDescription("description");
        final Service serviceId = new Service();
        serviceId.setServiceId(0L);
        serviceId.setServiceName("serviceName");
        serviceId.setFax("fax");
        serviceId.setPhone("phone");
        serviceId.setEmail("email");
        serviceId.setAddress("address");
        serviceId.setCity("city");
        serviceId.setLink("link");
        serviceId.setStatus(0);
        serviceId.setTaxCode("taxCode");
        serviceId.setDateRegister(LocalDate.of(2020, 1, 1));
        serviceId.setIsActive(false);
        serviceId.setIsBlock(false);
        final ServiceCategory serviceCategoryId = new ServiceCategory();
        serviceCategoryId.setServiceCategoryId(0L);
        serviceId.setServiceCategoryId(serviceCategoryId);
        final Partner partnerId = new Partner();
        partnerId.setEmail("email");
        serviceId.setPartnerId(partnerId);
        accommodationId.setServiceId(serviceId);
        room.setAccommodationId(accommodationId);
        when(serviceServiceImplUnderTest.roomRepository.save(any(Room.class))).thenReturn(room);

        // Configure UtilitiesSubcategoryRepository.getById(...).
        final UtilitiesSubcategory utilitiesSubcategory = new UtilitiesSubcategory();
        utilitiesSubcategory.setUtilitiesSubcategoryId(0L);
        utilitiesSubcategory.setUtilitiesSubcategoryName("utilitiesSubcategoryName");
        final UtilitiesCategory utilitiesCategoryId = new UtilitiesCategory();
        utilitiesCategoryId.setUtilitiesCategoryId(0L);
        utilitiesCategoryId.setUtilitiesCategoryName("utilitiesCategoryName");
        utilitiesCategoryId.setUtilitiesSubcategoryList(Arrays.asList(new UtilitiesSubcategory()));
        utilitiesSubcategory.setUtilitiesCategoryId(utilitiesCategoryId);
        final UtilitiesService utilitiesService = new UtilitiesService();
        utilitiesService.setUtilitiesServiceId(0L);
        final Service serviceId1 = new Service();
        serviceId1.setServiceId(0L);
        serviceId1.setServiceName("serviceName");
        serviceId1.setFax("fax");
        serviceId1.setPhone("phone");
        serviceId1.setEmail("email");
        serviceId1.setAddress("address");
        utilitiesService.setServiceId(serviceId1);
        utilitiesSubcategory.setUtilitiesServiceList(Arrays.asList(utilitiesService));
        when(serviceServiceImplUnderTest.utilitiesSubcategoryRepository.getById(0L)).thenReturn(utilitiesSubcategory);

        // Configure UtilitiesServiceRepository.save(...).
        final UtilitiesService utilitiesService1 = new UtilitiesService();
        final Service serviceId2 = new Service();
        serviceId2.setServiceId(0L);
        serviceId2.setServiceName("serviceName");
        serviceId2.setFax("fax");
        serviceId2.setPhone("phone");
        serviceId2.setEmail("email");
        serviceId2.setAddress("address");
        serviceId2.setCity("city");
        serviceId2.setLink("link");
        serviceId2.setStatus(0);
        serviceId2.setTaxCode("taxCode");
        serviceId2.setDateRegister(LocalDate.of(2020, 1, 1));
        serviceId2.setIsActive(false);
        serviceId2.setIsBlock(false);
        final ServiceCategory serviceCategoryId1 = new ServiceCategory();
        serviceCategoryId1.setServiceCategoryId(0L);
        serviceId2.setServiceCategoryId(serviceCategoryId1);
        final Partner partnerId1 = new Partner();
        partnerId1.setEmail("email");
        serviceId2.setPartnerId(partnerId1);
        utilitiesService1.setServiceId(serviceId2);
        final UtilitiesSubcategory utilitiesSubcategoryId = new UtilitiesSubcategory();
        utilitiesSubcategoryId.setUtilitiesSubcategoryId(0L);
        final UtilitiesCategory utilitiesCategoryId1 = new UtilitiesCategory();
        utilitiesCategoryId1.setUtilitiesCategoryId(0L);
        utilitiesSubcategoryId.setUtilitiesCategoryId(utilitiesCategoryId1);
        utilitiesService1.setUtilitiesSubcategoryId(utilitiesSubcategoryId);
        when(serviceServiceImplUnderTest.utilitiesServiceRepository.save(any(UtilitiesService.class)))
                .thenReturn(utilitiesService1);

        // Configure UtilitiesSubcategoryRepository.findByUtilitiesSubcategoryId(...).
        final UtilitiesSubcategory utilitiesSubcategory1 = new UtilitiesSubcategory();
        utilitiesSubcategory1.setUtilitiesSubcategoryId(0L);
        utilitiesSubcategory1.setUtilitiesSubcategoryName("utilitiesSubcategoryName");
        final UtilitiesCategory utilitiesCategoryId2 = new UtilitiesCategory();
        utilitiesCategoryId2.setUtilitiesCategoryId(0L);
        utilitiesCategoryId2.setUtilitiesCategoryName("utilitiesCategoryName");
        utilitiesCategoryId2.setUtilitiesSubcategoryList(Arrays.asList(new UtilitiesSubcategory()));
        utilitiesSubcategory1.setUtilitiesCategoryId(utilitiesCategoryId2);
        final UtilitiesService utilitiesService2 = new UtilitiesService();
        utilitiesService2.setUtilitiesServiceId(0L);
        final Service serviceId3 = new Service();
        serviceId3.setServiceId(0L);
        serviceId3.setServiceName("serviceName");
        serviceId3.setFax("fax");
        serviceId3.setPhone("phone");
        serviceId3.setEmail("email");
        serviceId3.setAddress("address");
        utilitiesService2.setServiceId(serviceId3);
        utilitiesSubcategory1.setUtilitiesServiceList(Arrays.asList(utilitiesService2));
        when(serviceServiceImplUnderTest.utilitiesSubcategoryRepository.findByUtilitiesSubcategoryId(0L))
                .thenReturn(utilitiesSubcategory1);

        // Run the test
        final AccommodationDTO result = serviceServiceImplUnderTest.createAccommodation(accommodationDTO);

        // Verify the results
        verify(serviceServiceImplUnderTest.roomRepository).save(any(Room.class));
        verify(serviceServiceImplUnderTest.utilitiesServiceRepository).save(any(UtilitiesService.class));
    }

    @Test
    void testCreateAccommodation_PartnerRepositoryReturnsNull() {
        // Setup
        final AccommodationDTO accommodationDTO = new AccommodationDTO(
                new ServiceDTO(0L, "serviceName", "fax", "phone", "email", "address", "city", "link", 0, "taxCode",
                        false, false, 0L, "typeOfServiceCategory", "email"), "accommodationType", 0.0f, 0,
                "description",
                Arrays.asList(new RoomDTO("roomName", "roomType", 0.0f, 0, 0, 0.0f, 0.0f, "description", "bedType")),
                Arrays.asList(new UtilitiesServiceDTO(0L, 0L)));
        when(serviceServiceImplUnderTest.partnerRepository.getPartnerByAccountEmail("email")).thenReturn(null);

        // Run the test
        assertThatThrownBy(() -> serviceServiceImplUnderTest.createAccommodation(accommodationDTO))
                .isInstanceOf(HandlerException.class);
    }

    @Test
    void testCreateAccommodation_ThrowsHandlerException() {
        // Setup
        final AccommodationDTO accommodationDTO = new AccommodationDTO(
                new ServiceDTO(0L, "serviceName", "fax", "phone", "email", "address", "city", "link", 0, "taxCode",
                        false, false, 0L, "typeOfServiceCategory", "email"), "accommodationType", 0.0f, 0,
                "description",
                Arrays.asList(new RoomDTO("roomName", "roomType", 0.0f, 0, 0, 0.0f, 0.0f, "description", "bedType")),
                Arrays.asList(new UtilitiesServiceDTO(0L, 0L)));

        // Configure PartnerRepository.getPartnerByAccountEmail(...).
        final Partner partner = new Partner();
        partner.setPartnerId(0L);
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
        user.setFirstName("firstName");
        user.setLastName("lastName");
        accountId.setUser(user);
        partner.setAccountId(accountId);
        partner.setEmail("email");
        when(serviceServiceImplUnderTest.partnerRepository.getPartnerByAccountEmail("email")).thenReturn(partner);

        // Configure ServiceCategoryRepository.getById(...).
        final ServiceCategory serviceCategory = new ServiceCategory();
        serviceCategory.setServiceCategoryId(0L);
        serviceCategory.setServiceCategoryName("serviceCategoryName");
        final Service service = new Service();
        service.setServiceId(0L);
        service.setServiceName("serviceName");
        service.setFax("fax");
        service.setPhone("phone");
        service.setEmail("email");
        service.setAddress("address");
        service.setCity("city");
        service.setLink("link");
        service.setStatus(0);
        service.setTaxCode("taxCode");
        service.setDateRegister(LocalDate.of(2020, 1, 1));
        service.setIsActive(false);
        serviceCategory.setServiceList(Arrays.asList(service));
        when(serviceServiceImplUnderTest.serviceCategoryRepository.getById(0L)).thenReturn(serviceCategory);

        // Configure RoomRepository.save(...).
        final Room room = new Room();
        room.setRoomName("roomName");
        room.setRoomType("roomType");
        room.setArea(0.0f);
        room.setNumberRooms(0);
        room.setNumberOfPeople(0);
        room.setDailyPrice(0.0f);
        room.setHolidayPrice(0.0f);
        room.setDescription("description");
        room.setBedType("bedType");
        final Accommodation accommodationId = new Accommodation();
        accommodationId.setAccommodationId(0L);
        accommodationId.setAccommodationType("accommodationType");
        accommodationId.setRate(0.0f);
        accommodationId.setNumberFloors(0);
        accommodationId.setDescription("description");
        final Service serviceId = new Service();
        serviceId.setServiceId(0L);
        serviceId.setServiceName("serviceName");
        serviceId.setFax("fax");
        serviceId.setPhone("phone");
        serviceId.setEmail("email");
        serviceId.setAddress("address");
        serviceId.setCity("city");
        serviceId.setLink("link");
        serviceId.setStatus(0);
        serviceId.setTaxCode("taxCode");
        serviceId.setDateRegister(LocalDate.of(2020, 1, 1));
        serviceId.setIsActive(false);
        serviceId.setIsBlock(false);
        final ServiceCategory serviceCategoryId = new ServiceCategory();
        serviceCategoryId.setServiceCategoryId(0L);
        serviceId.setServiceCategoryId(serviceCategoryId);
        final Partner partnerId = new Partner();
        partnerId.setEmail("email");
        serviceId.setPartnerId(partnerId);
        accommodationId.setServiceId(serviceId);
        room.setAccommodationId(accommodationId);
        when(serviceServiceImplUnderTest.roomRepository.save(any(Room.class))).thenReturn(room);

        // Configure UtilitiesSubcategoryRepository.getById(...).
        final UtilitiesSubcategory utilitiesSubcategory = new UtilitiesSubcategory();
        utilitiesSubcategory.setUtilitiesSubcategoryId(0L);
        utilitiesSubcategory.setUtilitiesSubcategoryName("utilitiesSubcategoryName");
        final UtilitiesCategory utilitiesCategoryId = new UtilitiesCategory();
        utilitiesCategoryId.setUtilitiesCategoryId(0L);
        utilitiesCategoryId.setUtilitiesCategoryName("utilitiesCategoryName");
        utilitiesCategoryId.setUtilitiesSubcategoryList(Arrays.asList(new UtilitiesSubcategory()));
        utilitiesSubcategory.setUtilitiesCategoryId(utilitiesCategoryId);
        final UtilitiesService utilitiesService = new UtilitiesService();
        utilitiesService.setUtilitiesServiceId(0L);
        final Service serviceId1 = new Service();
        serviceId1.setServiceId(0L);
        serviceId1.setServiceName("serviceName");
        serviceId1.setFax("fax");
        serviceId1.setPhone("phone");
        serviceId1.setEmail("email");
        serviceId1.setAddress("address");
        utilitiesService.setServiceId(serviceId1);
        utilitiesSubcategory.setUtilitiesServiceList(Arrays.asList(utilitiesService));
        when(serviceServiceImplUnderTest.utilitiesSubcategoryRepository.getById(0L)).thenReturn(utilitiesSubcategory);

        // Configure UtilitiesServiceRepository.save(...).
        final UtilitiesService utilitiesService1 = new UtilitiesService();
        final Service serviceId2 = new Service();
        serviceId2.setServiceId(0L);
        serviceId2.setServiceName("serviceName");
        serviceId2.setFax("fax");
        serviceId2.setPhone("phone");
        serviceId2.setEmail("email");
        serviceId2.setAddress("address");
        serviceId2.setCity("city");
        serviceId2.setLink("link");
        serviceId2.setStatus(0);
        serviceId2.setTaxCode("taxCode");
        serviceId2.setDateRegister(LocalDate.of(2020, 1, 1));
        serviceId2.setIsActive(false);
        serviceId2.setIsBlock(false);
        final ServiceCategory serviceCategoryId1 = new ServiceCategory();
        serviceCategoryId1.setServiceCategoryId(0L);
        serviceId2.setServiceCategoryId(serviceCategoryId1);
        final Partner partnerId1 = new Partner();
        partnerId1.setEmail("email");
        serviceId2.setPartnerId(partnerId1);
        utilitiesService1.setServiceId(serviceId2);
        final UtilitiesSubcategory utilitiesSubcategoryId = new UtilitiesSubcategory();
        utilitiesSubcategoryId.setUtilitiesSubcategoryId(0L);
        final UtilitiesCategory utilitiesCategoryId1 = new UtilitiesCategory();
        utilitiesCategoryId1.setUtilitiesCategoryId(0L);
        utilitiesSubcategoryId.setUtilitiesCategoryId(utilitiesCategoryId1);
        utilitiesService1.setUtilitiesSubcategoryId(utilitiesSubcategoryId);
        when(serviceServiceImplUnderTest.utilitiesServiceRepository.save(any(UtilitiesService.class)))
                .thenReturn(utilitiesService1);

        // Configure UtilitiesSubcategoryRepository.findByUtilitiesSubcategoryId(...).
        final UtilitiesSubcategory utilitiesSubcategory1 = new UtilitiesSubcategory();
        utilitiesSubcategory1.setUtilitiesSubcategoryId(0L);
        utilitiesSubcategory1.setUtilitiesSubcategoryName("utilitiesSubcategoryName");
        final UtilitiesCategory utilitiesCategoryId2 = new UtilitiesCategory();
        utilitiesCategoryId2.setUtilitiesCategoryId(0L);
        utilitiesCategoryId2.setUtilitiesCategoryName("utilitiesCategoryName");
        utilitiesCategoryId2.setUtilitiesSubcategoryList(Arrays.asList(new UtilitiesSubcategory()));
        utilitiesSubcategory1.setUtilitiesCategoryId(utilitiesCategoryId2);
        final UtilitiesService utilitiesService2 = new UtilitiesService();
        utilitiesService2.setUtilitiesServiceId(0L);
        final Service serviceId3 = new Service();
        serviceId3.setServiceId(0L);
        serviceId3.setServiceName("serviceName");
        serviceId3.setFax("fax");
        serviceId3.setPhone("phone");
        serviceId3.setEmail("email");
        serviceId3.setAddress("address");
        utilitiesService2.setServiceId(serviceId3);
        utilitiesSubcategory1.setUtilitiesServiceList(Arrays.asList(utilitiesService2));
        when(serviceServiceImplUnderTest.utilitiesSubcategoryRepository.findByUtilitiesSubcategoryId(0L))
                .thenReturn(utilitiesSubcategory1);

        // Run the test
        assertThatThrownBy(() -> serviceServiceImplUnderTest.createAccommodation(accommodationDTO))
                .isInstanceOf(HandlerException.class);
        verify(serviceServiceImplUnderTest.roomRepository).save(any(Room.class));
        verify(serviceServiceImplUnderTest.utilitiesServiceRepository).save(any(UtilitiesService.class));
    }

    @Test
    void testCreateRestaurant() throws Exception {
        // Setup
        final RestaurantDTO restaurantDTO = new RestaurantDTO(
                new ServiceDTO(0L, "serviceName", "fax", "phone", "email", "address", "city", "link", 0, "taxCode",
                        false, false, 0L, "typeOfServiceCategory", "email"), "restaurantServiceType",
                LocalTime.of(12, 0, 0), LocalTime.of(12, 0, 0), "description", 0.0f,
                Arrays.asList(new UtilitiesServiceDTO(0L, 0L)), Arrays.asList(new TypeCuisineServiceDTO(0L)));

        // Configure PartnerRepository.getPartnerByAccountEmail(...).
        final Partner partner = new Partner();
        partner.setPartnerId(0L);
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
        user.setFirstName("firstName");
        user.setLastName("lastName");
        accountId.setUser(user);
        partner.setAccountId(accountId);
        partner.setEmail("email");
        when(serviceServiceImplUnderTest.partnerRepository.getPartnerByAccountEmail("email")).thenReturn(partner);

        // Configure ServiceCategoryRepository.getById(...).
        final ServiceCategory serviceCategory = new ServiceCategory();
        serviceCategory.setServiceCategoryId(0L);
        serviceCategory.setServiceCategoryName("serviceCategoryName");
        final Service service = new Service();
        service.setServiceId(0L);
        service.setServiceName("serviceName");
        service.setFax("fax");
        service.setPhone("phone");
        service.setEmail("email");
        service.setAddress("address");
        service.setCity("city");
        service.setLink("link");
        service.setStatus(0);
        service.setTaxCode("taxCode");
        service.setDateRegister(LocalDate.of(2020, 1, 1));
        service.setIsActive(false);
        serviceCategory.setServiceList(Arrays.asList(service));
        when(serviceServiceImplUnderTest.serviceCategoryRepository.getById(0L)).thenReturn(serviceCategory);

        // Configure RestaurantRepository.save(...).
        final Restaurant restaurant = new Restaurant();
        restaurant.setRestaurantId(0L);
        restaurant.setRestaurantServiceType("restaurantServiceType");
        restaurant.setTimeOpen(LocalTime.of(12, 0, 0));
        restaurant.setTimeClose(LocalTime.of(12, 0, 0));
        restaurant.setDescription("description");
        restaurant.setRate(0.0f);
        final Service serviceId = new Service();
        serviceId.setServiceId(0L);
        serviceId.setServiceName("serviceName");
        serviceId.setFax("fax");
        serviceId.setPhone("phone");
        serviceId.setEmail("email");
        serviceId.setAddress("address");
        serviceId.setCity("city");
        serviceId.setLink("link");
        serviceId.setStatus(0);
        serviceId.setTaxCode("taxCode");
        serviceId.setDateRegister(LocalDate.of(2020, 1, 1));
        serviceId.setIsActive(false);
        serviceId.setIsBlock(false);
        final ServiceCategory serviceCategoryId = new ServiceCategory();
        serviceCategoryId.setServiceCategoryId(0L);
        serviceId.setServiceCategoryId(serviceCategoryId);
        final Partner partnerId = new Partner();
        partnerId.setEmail("email");
        serviceId.setPartnerId(partnerId);
        restaurant.setServiceId(serviceId);
        when(serviceServiceImplUnderTest.restaurantRepository.save(any(Restaurant.class))).thenReturn(restaurant);

        // Configure UtilitiesSubcategoryRepository.getById(...).
        final UtilitiesSubcategory utilitiesSubcategory = new UtilitiesSubcategory();
        utilitiesSubcategory.setUtilitiesSubcategoryId(0L);
        utilitiesSubcategory.setUtilitiesSubcategoryName("utilitiesSubcategoryName");
        final UtilitiesCategory utilitiesCategoryId = new UtilitiesCategory();
        utilitiesCategoryId.setUtilitiesCategoryId(0L);
        utilitiesCategoryId.setUtilitiesCategoryName("utilitiesCategoryName");
        utilitiesCategoryId.setUtilitiesSubcategoryList(Arrays.asList(new UtilitiesSubcategory()));
        utilitiesSubcategory.setUtilitiesCategoryId(utilitiesCategoryId);
        final UtilitiesService utilitiesService = new UtilitiesService();
        utilitiesService.setUtilitiesServiceId(0L);
        final Service serviceId1 = new Service();
        serviceId1.setServiceId(0L);
        serviceId1.setServiceName("serviceName");
        serviceId1.setFax("fax");
        serviceId1.setPhone("phone");
        serviceId1.setEmail("email");
        serviceId1.setAddress("address");
        utilitiesService.setServiceId(serviceId1);
        utilitiesSubcategory.setUtilitiesServiceList(Arrays.asList(utilitiesService));
        when(serviceServiceImplUnderTest.utilitiesSubcategoryRepository.getById(0L)).thenReturn(utilitiesSubcategory);

        // Configure UtilitiesServiceRepository.save(...).
        final UtilitiesService utilitiesService1 = new UtilitiesService();
        final Service serviceId2 = new Service();
        serviceId2.setServiceId(0L);
        serviceId2.setServiceName("serviceName");
        serviceId2.setFax("fax");
        serviceId2.setPhone("phone");
        serviceId2.setEmail("email");
        serviceId2.setAddress("address");
        serviceId2.setCity("city");
        serviceId2.setLink("link");
        serviceId2.setStatus(0);
        serviceId2.setTaxCode("taxCode");
        serviceId2.setDateRegister(LocalDate.of(2020, 1, 1));
        serviceId2.setIsActive(false);
        serviceId2.setIsBlock(false);
        final ServiceCategory serviceCategoryId1 = new ServiceCategory();
        serviceCategoryId1.setServiceCategoryId(0L);
        serviceId2.setServiceCategoryId(serviceCategoryId1);
        final Partner partnerId1 = new Partner();
        partnerId1.setEmail("email");
        serviceId2.setPartnerId(partnerId1);
        utilitiesService1.setServiceId(serviceId2);
        final UtilitiesSubcategory utilitiesSubcategoryId = new UtilitiesSubcategory();
        utilitiesSubcategoryId.setUtilitiesSubcategoryId(0L);
        final UtilitiesCategory utilitiesCategoryId1 = new UtilitiesCategory();
        utilitiesCategoryId1.setUtilitiesCategoryId(0L);
        utilitiesSubcategoryId.setUtilitiesCategoryId(utilitiesCategoryId1);
        utilitiesService1.setUtilitiesSubcategoryId(utilitiesSubcategoryId);
        when(serviceServiceImplUnderTest.utilitiesServiceRepository.save(any(UtilitiesService.class)))
                .thenReturn(utilitiesService1);

        // Configure TypeOfCuisineRepository.getById(...).
        final TypeOfCuisine typeOfCuisine = new TypeOfCuisine();
        typeOfCuisine.setTypeCuisineId(0L);
        typeOfCuisine.setCuisineName("cuisineName");
        final TypeOfCuisineService typeOfCuisineService = new TypeOfCuisineService();
        typeOfCuisineService.setTypeCuisineServiceId(0L);
        final Restaurant restaurantId = new Restaurant();
        restaurantId.setRestaurantId(0L);
        restaurantId.setRestaurantServiceType("restaurantServiceType");
        restaurantId.setTimeOpen(LocalTime.of(12, 0, 0));
        restaurantId.setTimeClose(LocalTime.of(12, 0, 0));
        restaurantId.setDescription("description");
        restaurantId.setRate(0.0f);
        final Service serviceId3 = new Service();
        serviceId3.setServiceId(0L);
        serviceId3.setServiceName("serviceName");
        serviceId3.setFax("fax");
        restaurantId.setServiceId(serviceId3);
        typeOfCuisineService.setRestaurantId(restaurantId);
        typeOfCuisine.setTypeOfCuisineServiceList(Arrays.asList(typeOfCuisineService));
        when(serviceServiceImplUnderTest.typeOfCuisineRepository.getById(0L)).thenReturn(typeOfCuisine);

        // Configure TypeOfCuisineServiceRepository.save(...).
        final TypeOfCuisineService typeOfCuisineService1 = new TypeOfCuisineService();
        final Restaurant restaurantId1 = new Restaurant();
        restaurantId1.setRestaurantId(0L);
        restaurantId1.setRestaurantServiceType("restaurantServiceType");
        restaurantId1.setTimeOpen(LocalTime.of(12, 0, 0));
        restaurantId1.setTimeClose(LocalTime.of(12, 0, 0));
        restaurantId1.setDescription("description");
        restaurantId1.setRate(0.0f);
        final Service serviceId4 = new Service();
        serviceId4.setServiceId(0L);
        serviceId4.setServiceName("serviceName");
        serviceId4.setFax("fax");
        serviceId4.setPhone("phone");
        serviceId4.setEmail("email");
        serviceId4.setAddress("address");
        serviceId4.setCity("city");
        serviceId4.setLink("link");
        serviceId4.setStatus(0);
        serviceId4.setTaxCode("taxCode");
        serviceId4.setDateRegister(LocalDate.of(2020, 1, 1));
        serviceId4.setIsActive(false);
        serviceId4.setIsBlock(false);
        final ServiceCategory serviceCategoryId2 = new ServiceCategory();
        serviceCategoryId2.setServiceCategoryId(0L);
        serviceId4.setServiceCategoryId(serviceCategoryId2);
        final Partner partnerId2 = new Partner();
        partnerId2.setEmail("email");
        serviceId4.setPartnerId(partnerId2);
        restaurantId1.setServiceId(serviceId4);
        typeOfCuisineService1.setRestaurantId(restaurantId1);
        final TypeOfCuisine typeCuisineId = new TypeOfCuisine();
        typeCuisineId.setTypeCuisineId(0L);
        typeOfCuisineService1.setTypeCuisineId(typeCuisineId);
        when(serviceServiceImplUnderTest.typeOfCuisineServiceRepository.save(
                any(TypeOfCuisineService.class))).thenReturn(typeOfCuisineService1);

        // Configure UtilitiesSubcategoryRepository.findByUtilitiesSubcategoryId(...).
        final UtilitiesSubcategory utilitiesSubcategory1 = new UtilitiesSubcategory();
        utilitiesSubcategory1.setUtilitiesSubcategoryId(0L);
        utilitiesSubcategory1.setUtilitiesSubcategoryName("utilitiesSubcategoryName");
        final UtilitiesCategory utilitiesCategoryId2 = new UtilitiesCategory();
        utilitiesCategoryId2.setUtilitiesCategoryId(0L);
        utilitiesCategoryId2.setUtilitiesCategoryName("utilitiesCategoryName");
        utilitiesCategoryId2.setUtilitiesSubcategoryList(Arrays.asList(new UtilitiesSubcategory()));
        utilitiesSubcategory1.setUtilitiesCategoryId(utilitiesCategoryId2);
        final UtilitiesService utilitiesService2 = new UtilitiesService();
        utilitiesService2.setUtilitiesServiceId(0L);
        final Service serviceId5 = new Service();
        serviceId5.setServiceId(0L);
        serviceId5.setServiceName("serviceName");
        serviceId5.setFax("fax");
        serviceId5.setPhone("phone");
        serviceId5.setEmail("email");
        serviceId5.setAddress("address");
        utilitiesService2.setServiceId(serviceId5);
        utilitiesSubcategory1.setUtilitiesServiceList(Arrays.asList(utilitiesService2));
        when(serviceServiceImplUnderTest.utilitiesSubcategoryRepository.findByUtilitiesSubcategoryId(0L))
                .thenReturn(utilitiesSubcategory1);

        // Run the test
        final RestaurantDTO result = serviceServiceImplUnderTest.createRestaurant(restaurantDTO);

        // Verify the results
        verify(serviceServiceImplUnderTest.restaurantRepository).save(any(Restaurant.class));
        verify(serviceServiceImplUnderTest.utilitiesServiceRepository).save(any(UtilitiesService.class));
        verify(serviceServiceImplUnderTest.typeOfCuisineServiceRepository).save(any(TypeOfCuisineService.class));
    }

    @Test
    void testCreateRestaurant_PartnerRepositoryReturnsNull() {
        // Setup
        final RestaurantDTO restaurantDTO = new RestaurantDTO(
                new ServiceDTO(0L, "serviceName", "fax", "phone", "email", "address", "city", "link", 0, "taxCode",
                        false, false, 0L, "typeOfServiceCategory", "email"), "restaurantServiceType",
                LocalTime.of(12, 0, 0), LocalTime.of(12, 0, 0), "description", 0.0f,
                Arrays.asList(new UtilitiesServiceDTO(0L, 0L)), Arrays.asList(new TypeCuisineServiceDTO(0L)));
        when(serviceServiceImplUnderTest.partnerRepository.getPartnerByAccountEmail("email")).thenReturn(null);

        // Run the test
        assertThatThrownBy(() -> serviceServiceImplUnderTest.createRestaurant(restaurantDTO))
                .isInstanceOf(HandlerException.class);
    }

    @Test
    void testCreateRestaurant_ThrowsHandlerException() {
        // Setup
        final RestaurantDTO restaurantDTO = new RestaurantDTO(
                new ServiceDTO(0L, "serviceName", "fax", "phone", "email", "address", "city", "link", 0, "taxCode",
                        false, false, 0L, "typeOfServiceCategory", "email"), "restaurantServiceType",
                LocalTime.of(12, 0, 0), LocalTime.of(12, 0, 0), "description", 0.0f,
                Arrays.asList(new UtilitiesServiceDTO(0L, 0L)), Arrays.asList(new TypeCuisineServiceDTO(0L)));

        // Configure PartnerRepository.getPartnerByAccountEmail(...).
        final Partner partner = new Partner();
        partner.setPartnerId(0L);
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
        user.setFirstName("firstName");
        user.setLastName("lastName");
        accountId.setUser(user);
        partner.setAccountId(accountId);
        partner.setEmail("email");
        when(serviceServiceImplUnderTest.partnerRepository.getPartnerByAccountEmail("email")).thenReturn(partner);

        // Configure ServiceCategoryRepository.getById(...).
        final ServiceCategory serviceCategory = new ServiceCategory();
        serviceCategory.setServiceCategoryId(0L);
        serviceCategory.setServiceCategoryName("serviceCategoryName");
        final Service service = new Service();
        service.setServiceId(0L);
        service.setServiceName("serviceName");
        service.setFax("fax");
        service.setPhone("phone");
        service.setEmail("email");
        service.setAddress("address");
        service.setCity("city");
        service.setLink("link");
        service.setStatus(0);
        service.setTaxCode("taxCode");
        service.setDateRegister(LocalDate.of(2020, 1, 1));
        service.setIsActive(false);
        serviceCategory.setServiceList(Arrays.asList(service));
        when(serviceServiceImplUnderTest.serviceCategoryRepository.getById(0L)).thenReturn(serviceCategory);

        // Configure RestaurantRepository.save(...).
        final Restaurant restaurant = new Restaurant();
        restaurant.setRestaurantId(0L);
        restaurant.setRestaurantServiceType("restaurantServiceType");
        restaurant.setTimeOpen(LocalTime.of(12, 0, 0));
        restaurant.setTimeClose(LocalTime.of(12, 0, 0));
        restaurant.setDescription("description");
        restaurant.setRate(0.0f);
        final Service serviceId = new Service();
        serviceId.setServiceId(0L);
        serviceId.setServiceName("serviceName");
        serviceId.setFax("fax");
        serviceId.setPhone("phone");
        serviceId.setEmail("email");
        serviceId.setAddress("address");
        serviceId.setCity("city");
        serviceId.setLink("link");
        serviceId.setStatus(0);
        serviceId.setTaxCode("taxCode");
        serviceId.setDateRegister(LocalDate.of(2020, 1, 1));
        serviceId.setIsActive(false);
        serviceId.setIsBlock(false);
        final ServiceCategory serviceCategoryId = new ServiceCategory();
        serviceCategoryId.setServiceCategoryId(0L);
        serviceId.setServiceCategoryId(serviceCategoryId);
        final Partner partnerId = new Partner();
        partnerId.setEmail("email");
        serviceId.setPartnerId(partnerId);
        restaurant.setServiceId(serviceId);
        when(serviceServiceImplUnderTest.restaurantRepository.save(any(Restaurant.class))).thenReturn(restaurant);

        // Configure UtilitiesSubcategoryRepository.getById(...).
        final UtilitiesSubcategory utilitiesSubcategory = new UtilitiesSubcategory();
        utilitiesSubcategory.setUtilitiesSubcategoryId(0L);
        utilitiesSubcategory.setUtilitiesSubcategoryName("utilitiesSubcategoryName");
        final UtilitiesCategory utilitiesCategoryId = new UtilitiesCategory();
        utilitiesCategoryId.setUtilitiesCategoryId(0L);
        utilitiesCategoryId.setUtilitiesCategoryName("utilitiesCategoryName");
        utilitiesCategoryId.setUtilitiesSubcategoryList(Arrays.asList(new UtilitiesSubcategory()));
        utilitiesSubcategory.setUtilitiesCategoryId(utilitiesCategoryId);
        final UtilitiesService utilitiesService = new UtilitiesService();
        utilitiesService.setUtilitiesServiceId(0L);
        final Service serviceId1 = new Service();
        serviceId1.setServiceId(0L);
        serviceId1.setServiceName("serviceName");
        serviceId1.setFax("fax");
        serviceId1.setPhone("phone");
        serviceId1.setEmail("email");
        serviceId1.setAddress("address");
        utilitiesService.setServiceId(serviceId1);
        utilitiesSubcategory.setUtilitiesServiceList(Arrays.asList(utilitiesService));
        when(serviceServiceImplUnderTest.utilitiesSubcategoryRepository.getById(0L)).thenReturn(utilitiesSubcategory);

        // Configure UtilitiesServiceRepository.save(...).
        final UtilitiesService utilitiesService1 = new UtilitiesService();
        final Service serviceId2 = new Service();
        serviceId2.setServiceId(0L);
        serviceId2.setServiceName("serviceName");
        serviceId2.setFax("fax");
        serviceId2.setPhone("phone");
        serviceId2.setEmail("email");
        serviceId2.setAddress("address");
        serviceId2.setCity("city");
        serviceId2.setLink("link");
        serviceId2.setStatus(0);
        serviceId2.setTaxCode("taxCode");
        serviceId2.setDateRegister(LocalDate.of(2020, 1, 1));
        serviceId2.setIsActive(false);
        serviceId2.setIsBlock(false);
        final ServiceCategory serviceCategoryId1 = new ServiceCategory();
        serviceCategoryId1.setServiceCategoryId(0L);
        serviceId2.setServiceCategoryId(serviceCategoryId1);
        final Partner partnerId1 = new Partner();
        partnerId1.setEmail("email");
        serviceId2.setPartnerId(partnerId1);
        utilitiesService1.setServiceId(serviceId2);
        final UtilitiesSubcategory utilitiesSubcategoryId = new UtilitiesSubcategory();
        utilitiesSubcategoryId.setUtilitiesSubcategoryId(0L);
        final UtilitiesCategory utilitiesCategoryId1 = new UtilitiesCategory();
        utilitiesCategoryId1.setUtilitiesCategoryId(0L);
        utilitiesSubcategoryId.setUtilitiesCategoryId(utilitiesCategoryId1);
        utilitiesService1.setUtilitiesSubcategoryId(utilitiesSubcategoryId);
        when(serviceServiceImplUnderTest.utilitiesServiceRepository.save(any(UtilitiesService.class)))
                .thenReturn(utilitiesService1);

        // Configure TypeOfCuisineRepository.getById(...).
        final TypeOfCuisine typeOfCuisine = new TypeOfCuisine();
        typeOfCuisine.setTypeCuisineId(0L);
        typeOfCuisine.setCuisineName("cuisineName");
        final TypeOfCuisineService typeOfCuisineService = new TypeOfCuisineService();
        typeOfCuisineService.setTypeCuisineServiceId(0L);
        final Restaurant restaurantId = new Restaurant();
        restaurantId.setRestaurantId(0L);
        restaurantId.setRestaurantServiceType("restaurantServiceType");
        restaurantId.setTimeOpen(LocalTime.of(12, 0, 0));
        restaurantId.setTimeClose(LocalTime.of(12, 0, 0));
        restaurantId.setDescription("description");
        restaurantId.setRate(0.0f);
        final Service serviceId3 = new Service();
        serviceId3.setServiceId(0L);
        serviceId3.setServiceName("serviceName");
        serviceId3.setFax("fax");
        restaurantId.setServiceId(serviceId3);
        typeOfCuisineService.setRestaurantId(restaurantId);
        typeOfCuisine.setTypeOfCuisineServiceList(Arrays.asList(typeOfCuisineService));
        when(serviceServiceImplUnderTest.typeOfCuisineRepository.getById(0L)).thenReturn(typeOfCuisine);

        // Configure TypeOfCuisineServiceRepository.save(...).
        final TypeOfCuisineService typeOfCuisineService1 = new TypeOfCuisineService();
        final Restaurant restaurantId1 = new Restaurant();
        restaurantId1.setRestaurantId(0L);
        restaurantId1.setRestaurantServiceType("restaurantServiceType");
        restaurantId1.setTimeOpen(LocalTime.of(12, 0, 0));
        restaurantId1.setTimeClose(LocalTime.of(12, 0, 0));
        restaurantId1.setDescription("description");
        restaurantId1.setRate(0.0f);
        final Service serviceId4 = new Service();
        serviceId4.setServiceId(0L);
        serviceId4.setServiceName("serviceName");
        serviceId4.setFax("fax");
        serviceId4.setPhone("phone");
        serviceId4.setEmail("email");
        serviceId4.setAddress("address");
        serviceId4.setCity("city");
        serviceId4.setLink("link");
        serviceId4.setStatus(0);
        serviceId4.setTaxCode("taxCode");
        serviceId4.setDateRegister(LocalDate.of(2020, 1, 1));
        serviceId4.setIsActive(false);
        serviceId4.setIsBlock(false);
        final ServiceCategory serviceCategoryId2 = new ServiceCategory();
        serviceCategoryId2.setServiceCategoryId(0L);
        serviceId4.setServiceCategoryId(serviceCategoryId2);
        final Partner partnerId2 = new Partner();
        partnerId2.setEmail("email");
        serviceId4.setPartnerId(partnerId2);
        restaurantId1.setServiceId(serviceId4);
        typeOfCuisineService1.setRestaurantId(restaurantId1);
        final TypeOfCuisine typeCuisineId = new TypeOfCuisine();
        typeCuisineId.setTypeCuisineId(0L);
        typeOfCuisineService1.setTypeCuisineId(typeCuisineId);
        when(serviceServiceImplUnderTest.typeOfCuisineServiceRepository.save(
                any(TypeOfCuisineService.class))).thenReturn(typeOfCuisineService1);

        // Configure UtilitiesSubcategoryRepository.findByUtilitiesSubcategoryId(...).
        final UtilitiesSubcategory utilitiesSubcategory1 = new UtilitiesSubcategory();
        utilitiesSubcategory1.setUtilitiesSubcategoryId(0L);
        utilitiesSubcategory1.setUtilitiesSubcategoryName("utilitiesSubcategoryName");
        final UtilitiesCategory utilitiesCategoryId2 = new UtilitiesCategory();
        utilitiesCategoryId2.setUtilitiesCategoryId(0L);
        utilitiesCategoryId2.setUtilitiesCategoryName("utilitiesCategoryName");
        utilitiesCategoryId2.setUtilitiesSubcategoryList(Arrays.asList(new UtilitiesSubcategory()));
        utilitiesSubcategory1.setUtilitiesCategoryId(utilitiesCategoryId2);
        final UtilitiesService utilitiesService2 = new UtilitiesService();
        utilitiesService2.setUtilitiesServiceId(0L);
        final Service serviceId5 = new Service();
        serviceId5.setServiceId(0L);
        serviceId5.setServiceName("serviceName");
        serviceId5.setFax("fax");
        serviceId5.setPhone("phone");
        serviceId5.setEmail("email");
        serviceId5.setAddress("address");
        utilitiesService2.setServiceId(serviceId5);
        utilitiesSubcategory1.setUtilitiesServiceList(Arrays.asList(utilitiesService2));
        when(serviceServiceImplUnderTest.utilitiesSubcategoryRepository.findByUtilitiesSubcategoryId(0L))
                .thenReturn(utilitiesSubcategory1);

        // Run the test
        assertThatThrownBy(() -> serviceServiceImplUnderTest.createRestaurant(restaurantDTO))
                .isInstanceOf(HandlerException.class);
        verify(serviceServiceImplUnderTest.restaurantRepository).save(any(Restaurant.class));
        verify(serviceServiceImplUnderTest.utilitiesServiceRepository).save(any(UtilitiesService.class));
        verify(serviceServiceImplUnderTest.typeOfCuisineServiceRepository).save(any(TypeOfCuisineService.class));
    }

    @Test
    void testCreateEntertainment() throws Exception {
        // Setup
        final EntertainmentDTO entertainmentDTO = new EntertainmentDTO(
                new ServiceDTO(0L, "serviceName", "fax", "phone", "email", "address", "city", "link", 0, "taxCode",
                        false, false, 0L, "typeOfServiceCategory", "email"), "entertainmentType", "dowOpen",
                LocalTime.of(12, 0, 0), LocalTime.of(12, 0, 0), 0.0f, 0.0f, "description",
                Arrays.asList(new UtilitiesServiceDTO(0L, 0L)));

        // Configure PartnerRepository.getPartnerByAccountEmail(...).
        final Partner partner = new Partner();
        partner.setPartnerId(0L);
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
        user.setFirstName("firstName");
        user.setLastName("lastName");
        accountId.setUser(user);
        partner.setAccountId(accountId);
        partner.setEmail("email");
        when(serviceServiceImplUnderTest.partnerRepository.getPartnerByAccountEmail("email")).thenReturn(partner);

        // Configure ServiceCategoryRepository.getById(...).
        final ServiceCategory serviceCategory = new ServiceCategory();
        serviceCategory.setServiceCategoryId(0L);
        serviceCategory.setServiceCategoryName("serviceCategoryName");
        final Service service = new Service();
        service.setServiceId(0L);
        service.setServiceName("serviceName");
        service.setFax("fax");
        service.setPhone("phone");
        service.setEmail("email");
        service.setAddress("address");
        service.setCity("city");
        service.setLink("link");
        service.setStatus(0);
        service.setTaxCode("taxCode");
        service.setDateRegister(LocalDate.of(2020, 1, 1));
        service.setIsActive(false);
        serviceCategory.setServiceList(Arrays.asList(service));
        when(serviceServiceImplUnderTest.serviceCategoryRepository.getById(0L)).thenReturn(serviceCategory);

        // Configure EntertainmentRepository.save(...).
        final Entertainment entertainment = new Entertainment();
        entertainment.setEntertainmentType("entertainmentType");
        entertainment.setDowOpen("dowOpen");
        entertainment.setTimeOpen(LocalTime.of(12, 0, 0));
        entertainment.setTimeClose(LocalTime.of(12, 0, 0));
        entertainment.setPriceTicketAdult(0.0f);
        entertainment.setPriceTicketChildren(0.0f);
        entertainment.setDescription("description");
        final Service serviceId = new Service();
        serviceId.setServiceId(0L);
        serviceId.setServiceName("serviceName");
        serviceId.setFax("fax");
        serviceId.setPhone("phone");
        serviceId.setEmail("email");
        serviceId.setAddress("address");
        serviceId.setCity("city");
        serviceId.setLink("link");
        serviceId.setStatus(0);
        serviceId.setTaxCode("taxCode");
        serviceId.setDateRegister(LocalDate.of(2020, 1, 1));
        serviceId.setIsActive(false);
        serviceId.setIsBlock(false);
        final ServiceCategory serviceCategoryId = new ServiceCategory();
        serviceCategoryId.setServiceCategoryId(0L);
        serviceId.setServiceCategoryId(serviceCategoryId);
        final Partner partnerId = new Partner();
        partnerId.setEmail("email");
        serviceId.setPartnerId(partnerId);
        entertainment.setServiceId(serviceId);
        when(serviceServiceImplUnderTest.entertainmentRepository.save(any(Entertainment.class)))
                .thenReturn(entertainment);

        // Configure UtilitiesSubcategoryRepository.getById(...).
        final UtilitiesSubcategory utilitiesSubcategory = new UtilitiesSubcategory();
        utilitiesSubcategory.setUtilitiesSubcategoryId(0L);
        utilitiesSubcategory.setUtilitiesSubcategoryName("utilitiesSubcategoryName");
        final UtilitiesCategory utilitiesCategoryId = new UtilitiesCategory();
        utilitiesCategoryId.setUtilitiesCategoryId(0L);
        utilitiesCategoryId.setUtilitiesCategoryName("utilitiesCategoryName");
        utilitiesCategoryId.setUtilitiesSubcategoryList(Arrays.asList(new UtilitiesSubcategory()));
        utilitiesSubcategory.setUtilitiesCategoryId(utilitiesCategoryId);
        final UtilitiesService utilitiesService = new UtilitiesService();
        utilitiesService.setUtilitiesServiceId(0L);
        final Service serviceId1 = new Service();
        serviceId1.setServiceId(0L);
        serviceId1.setServiceName("serviceName");
        serviceId1.setFax("fax");
        serviceId1.setPhone("phone");
        serviceId1.setEmail("email");
        serviceId1.setAddress("address");
        utilitiesService.setServiceId(serviceId1);
        utilitiesSubcategory.setUtilitiesServiceList(Arrays.asList(utilitiesService));
        when(serviceServiceImplUnderTest.utilitiesSubcategoryRepository.getById(0L)).thenReturn(utilitiesSubcategory);

        // Configure UtilitiesServiceRepository.save(...).
        final UtilitiesService utilitiesService1 = new UtilitiesService();
        final Service serviceId2 = new Service();
        serviceId2.setServiceId(0L);
        serviceId2.setServiceName("serviceName");
        serviceId2.setFax("fax");
        serviceId2.setPhone("phone");
        serviceId2.setEmail("email");
        serviceId2.setAddress("address");
        serviceId2.setCity("city");
        serviceId2.setLink("link");
        serviceId2.setStatus(0);
        serviceId2.setTaxCode("taxCode");
        serviceId2.setDateRegister(LocalDate.of(2020, 1, 1));
        serviceId2.setIsActive(false);
        serviceId2.setIsBlock(false);
        final ServiceCategory serviceCategoryId1 = new ServiceCategory();
        serviceCategoryId1.setServiceCategoryId(0L);
        serviceId2.setServiceCategoryId(serviceCategoryId1);
        final Partner partnerId1 = new Partner();
        partnerId1.setEmail("email");
        serviceId2.setPartnerId(partnerId1);
        utilitiesService1.setServiceId(serviceId2);
        final UtilitiesSubcategory utilitiesSubcategoryId = new UtilitiesSubcategory();
        utilitiesSubcategoryId.setUtilitiesSubcategoryId(0L);
        final UtilitiesCategory utilitiesCategoryId1 = new UtilitiesCategory();
        utilitiesCategoryId1.setUtilitiesCategoryId(0L);
        utilitiesSubcategoryId.setUtilitiesCategoryId(utilitiesCategoryId1);
        utilitiesService1.setUtilitiesSubcategoryId(utilitiesSubcategoryId);
        when(serviceServiceImplUnderTest.utilitiesServiceRepository.save(any(UtilitiesService.class)))
                .thenReturn(utilitiesService1);

        // Configure UtilitiesSubcategoryRepository.findByUtilitiesSubcategoryId(...).
        final UtilitiesSubcategory utilitiesSubcategory1 = new UtilitiesSubcategory();
        utilitiesSubcategory1.setUtilitiesSubcategoryId(0L);
        utilitiesSubcategory1.setUtilitiesSubcategoryName("utilitiesSubcategoryName");
        final UtilitiesCategory utilitiesCategoryId2 = new UtilitiesCategory();
        utilitiesCategoryId2.setUtilitiesCategoryId(0L);
        utilitiesCategoryId2.setUtilitiesCategoryName("utilitiesCategoryName");
        utilitiesCategoryId2.setUtilitiesSubcategoryList(Arrays.asList(new UtilitiesSubcategory()));
        utilitiesSubcategory1.setUtilitiesCategoryId(utilitiesCategoryId2);
        final UtilitiesService utilitiesService2 = new UtilitiesService();
        utilitiesService2.setUtilitiesServiceId(0L);
        final Service serviceId3 = new Service();
        serviceId3.setServiceId(0L);
        serviceId3.setServiceName("serviceName");
        serviceId3.setFax("fax");
        serviceId3.setPhone("phone");
        serviceId3.setEmail("email");
        serviceId3.setAddress("address");
        utilitiesService2.setServiceId(serviceId3);
        utilitiesSubcategory1.setUtilitiesServiceList(Arrays.asList(utilitiesService2));
        when(serviceServiceImplUnderTest.utilitiesSubcategoryRepository.findByUtilitiesSubcategoryId(0L))
                .thenReturn(utilitiesSubcategory1);

        // Run the test
        final EntertainmentDTO result = serviceServiceImplUnderTest.createEntertainment(entertainmentDTO);

        // Verify the results
        verify(serviceServiceImplUnderTest.entertainmentRepository).save(any(Entertainment.class));
        verify(serviceServiceImplUnderTest.utilitiesServiceRepository).save(any(UtilitiesService.class));
    }

    @Test
    void testCreateEntertainment_PartnerRepositoryReturnsNull() {
        // Setup
        final EntertainmentDTO entertainmentDTO = new EntertainmentDTO(
                new ServiceDTO(0L, "serviceName", "fax", "phone", "email", "address", "city", "link", 0, "taxCode",
                        false, false, 0L, "typeOfServiceCategory", "email"), "entertainmentType", "dowOpen",
                LocalTime.of(12, 0, 0), LocalTime.of(12, 0, 0), 0.0f, 0.0f, "description",
                Arrays.asList(new UtilitiesServiceDTO(0L, 0L)));
        when(serviceServiceImplUnderTest.partnerRepository.getPartnerByAccountEmail("email")).thenReturn(null);

        // Run the test
        assertThatThrownBy(() -> serviceServiceImplUnderTest.createEntertainment(entertainmentDTO))
                .isInstanceOf(HandlerException.class);
    }

    @Test
    void testCreateEntertainment_ThrowsHandlerException() {
        // Setup
        final EntertainmentDTO entertainmentDTO = new EntertainmentDTO(
                new ServiceDTO(0L, "serviceName", "fax", "phone", "email", "address", "city", "link", 0, "taxCode",
                        false, false, 0L, "typeOfServiceCategory", "email"), "entertainmentType", "dowOpen",
                LocalTime.of(12, 0, 0), LocalTime.of(12, 0, 0), 0.0f, 0.0f, "description",
                Arrays.asList(new UtilitiesServiceDTO(0L, 0L)));

        // Configure PartnerRepository.getPartnerByAccountEmail(...).
        final Partner partner = new Partner();
        partner.setPartnerId(0L);
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
        user.setFirstName("firstName");
        user.setLastName("lastName");
        accountId.setUser(user);
        partner.setAccountId(accountId);
        partner.setEmail("email");
        when(serviceServiceImplUnderTest.partnerRepository.getPartnerByAccountEmail("email")).thenReturn(partner);

        // Configure ServiceCategoryRepository.getById(...).
        final ServiceCategory serviceCategory = new ServiceCategory();
        serviceCategory.setServiceCategoryId(0L);
        serviceCategory.setServiceCategoryName("serviceCategoryName");
        final Service service = new Service();
        service.setServiceId(0L);
        service.setServiceName("serviceName");
        service.setFax("fax");
        service.setPhone("phone");
        service.setEmail("email");
        service.setAddress("address");
        service.setCity("city");
        service.setLink("link");
        service.setStatus(0);
        service.setTaxCode("taxCode");
        service.setDateRegister(LocalDate.of(2020, 1, 1));
        service.setIsActive(false);
        serviceCategory.setServiceList(Arrays.asList(service));
        when(serviceServiceImplUnderTest.serviceCategoryRepository.getById(0L)).thenReturn(serviceCategory);

        // Configure EntertainmentRepository.save(...).
        final Entertainment entertainment = new Entertainment();
        entertainment.setEntertainmentType("entertainmentType");
        entertainment.setDowOpen("dowOpen");
        entertainment.setTimeOpen(LocalTime.of(12, 0, 0));
        entertainment.setTimeClose(LocalTime.of(12, 0, 0));
        entertainment.setPriceTicketAdult(0.0f);
        entertainment.setPriceTicketChildren(0.0f);
        entertainment.setDescription("description");
        final Service serviceId = new Service();
        serviceId.setServiceId(0L);
        serviceId.setServiceName("serviceName");
        serviceId.setFax("fax");
        serviceId.setPhone("phone");
        serviceId.setEmail("email");
        serviceId.setAddress("address");
        serviceId.setCity("city");
        serviceId.setLink("link");
        serviceId.setStatus(0);
        serviceId.setTaxCode("taxCode");
        serviceId.setDateRegister(LocalDate.of(2020, 1, 1));
        serviceId.setIsActive(false);
        serviceId.setIsBlock(false);
        final ServiceCategory serviceCategoryId = new ServiceCategory();
        serviceCategoryId.setServiceCategoryId(0L);
        serviceId.setServiceCategoryId(serviceCategoryId);
        final Partner partnerId = new Partner();
        partnerId.setEmail("email");
        serviceId.setPartnerId(partnerId);
        entertainment.setServiceId(serviceId);
        when(serviceServiceImplUnderTest.entertainmentRepository.save(any(Entertainment.class)))
                .thenReturn(entertainment);

        // Configure UtilitiesSubcategoryRepository.getById(...).
        final UtilitiesSubcategory utilitiesSubcategory = new UtilitiesSubcategory();
        utilitiesSubcategory.setUtilitiesSubcategoryId(0L);
        utilitiesSubcategory.setUtilitiesSubcategoryName("utilitiesSubcategoryName");
        final UtilitiesCategory utilitiesCategoryId = new UtilitiesCategory();
        utilitiesCategoryId.setUtilitiesCategoryId(0L);
        utilitiesCategoryId.setUtilitiesCategoryName("utilitiesCategoryName");
        utilitiesCategoryId.setUtilitiesSubcategoryList(Arrays.asList(new UtilitiesSubcategory()));
        utilitiesSubcategory.setUtilitiesCategoryId(utilitiesCategoryId);
        final UtilitiesService utilitiesService = new UtilitiesService();
        utilitiesService.setUtilitiesServiceId(0L);
        final Service serviceId1 = new Service();
        serviceId1.setServiceId(0L);
        serviceId1.setServiceName("serviceName");
        serviceId1.setFax("fax");
        serviceId1.setPhone("phone");
        serviceId1.setEmail("email");
        serviceId1.setAddress("address");
        utilitiesService.setServiceId(serviceId1);
        utilitiesSubcategory.setUtilitiesServiceList(Arrays.asList(utilitiesService));
        when(serviceServiceImplUnderTest.utilitiesSubcategoryRepository.getById(0L)).thenReturn(utilitiesSubcategory);

        // Configure UtilitiesServiceRepository.save(...).
        final UtilitiesService utilitiesService1 = new UtilitiesService();
        final Service serviceId2 = new Service();
        serviceId2.setServiceId(0L);
        serviceId2.setServiceName("serviceName");
        serviceId2.setFax("fax");
        serviceId2.setPhone("phone");
        serviceId2.setEmail("email");
        serviceId2.setAddress("address");
        serviceId2.setCity("city");
        serviceId2.setLink("link");
        serviceId2.setStatus(0);
        serviceId2.setTaxCode("taxCode");
        serviceId2.setDateRegister(LocalDate.of(2020, 1, 1));
        serviceId2.setIsActive(false);
        serviceId2.setIsBlock(false);
        final ServiceCategory serviceCategoryId1 = new ServiceCategory();
        serviceCategoryId1.setServiceCategoryId(0L);
        serviceId2.setServiceCategoryId(serviceCategoryId1);
        final Partner partnerId1 = new Partner();
        partnerId1.setEmail("email");
        serviceId2.setPartnerId(partnerId1);
        utilitiesService1.setServiceId(serviceId2);
        final UtilitiesSubcategory utilitiesSubcategoryId = new UtilitiesSubcategory();
        utilitiesSubcategoryId.setUtilitiesSubcategoryId(0L);
        final UtilitiesCategory utilitiesCategoryId1 = new UtilitiesCategory();
        utilitiesCategoryId1.setUtilitiesCategoryId(0L);
        utilitiesSubcategoryId.setUtilitiesCategoryId(utilitiesCategoryId1);
        utilitiesService1.setUtilitiesSubcategoryId(utilitiesSubcategoryId);
        when(serviceServiceImplUnderTest.utilitiesServiceRepository.save(any(UtilitiesService.class)))
                .thenReturn(utilitiesService1);

        // Configure UtilitiesSubcategoryRepository.findByUtilitiesSubcategoryId(...).
        final UtilitiesSubcategory utilitiesSubcategory1 = new UtilitiesSubcategory();
        utilitiesSubcategory1.setUtilitiesSubcategoryId(0L);
        utilitiesSubcategory1.setUtilitiesSubcategoryName("utilitiesSubcategoryName");
        final UtilitiesCategory utilitiesCategoryId2 = new UtilitiesCategory();
        utilitiesCategoryId2.setUtilitiesCategoryId(0L);
        utilitiesCategoryId2.setUtilitiesCategoryName("utilitiesCategoryName");
        utilitiesCategoryId2.setUtilitiesSubcategoryList(Arrays.asList(new UtilitiesSubcategory()));
        utilitiesSubcategory1.setUtilitiesCategoryId(utilitiesCategoryId2);
        final UtilitiesService utilitiesService2 = new UtilitiesService();
        utilitiesService2.setUtilitiesServiceId(0L);
        final Service serviceId3 = new Service();
        serviceId3.setServiceId(0L);
        serviceId3.setServiceName("serviceName");
        serviceId3.setFax("fax");
        serviceId3.setPhone("phone");
        serviceId3.setEmail("email");
        serviceId3.setAddress("address");
        utilitiesService2.setServiceId(serviceId3);
        utilitiesSubcategory1.setUtilitiesServiceList(Arrays.asList(utilitiesService2));
        when(serviceServiceImplUnderTest.utilitiesSubcategoryRepository.findByUtilitiesSubcategoryId(0L))
                .thenReturn(utilitiesSubcategory1);

        // Run the test
        assertThatThrownBy(() -> serviceServiceImplUnderTest.createEntertainment(entertainmentDTO))
                .isInstanceOf(HandlerException.class);
        verify(serviceServiceImplUnderTest.entertainmentRepository).save(any(Entertainment.class));
        verify(serviceServiceImplUnderTest.utilitiesServiceRepository).save(any(UtilitiesService.class));
    }

    @Test
    void testUpdateService() throws Exception {
        // Setup
        final ServiceDTO serviceDTO = new ServiceDTO(0L, "serviceName", "fax", "phone", "email", "address", "city",
                "link", 0, "taxCode", false, false, 0L, "typeOfServiceCategory", "email");
        final List<UtilitiesServiceDTO> utilitiesServiceDTOList = Arrays.asList(new UtilitiesServiceDTO(0L, 0L));

        // Configure ServiceRepository.getById(...).
        final Service service = new Service();
        service.setServiceId(0L);
        service.setServiceName("serviceName");
        service.setFax("fax");
        service.setPhone("phone");
        service.setEmail("email");
        service.setAddress("address");
        service.setCity("city");
        service.setLink("link");
        service.setStatus(0);
        service.setTaxCode("taxCode");
        service.setDateRegister(LocalDate.of(2020, 1, 1));
        service.setIsActive(false);
        service.setIsBlock(false);
        final ServiceCategory serviceCategoryId = new ServiceCategory();
        serviceCategoryId.setServiceCategoryId(0L);
        service.setServiceCategoryId(serviceCategoryId);
        final Partner partnerId = new Partner();
        partnerId.setEmail("email");
        service.setPartnerId(partnerId);
        when(serviceServiceImplUnderTest.serviceRepository.getById(0L)).thenReturn(service);

        when(serviceServiceImplUnderTest.serviceRepository.existsAllByServiceName("serviceName")).thenReturn(false);

        // Configure UtilitiesServiceRepository.getListUtilitiesServiceByServiceId(...).
        final UtilitiesService utilitiesService = new UtilitiesService();
        final Service serviceId = new Service();
        serviceId.setServiceId(0L);
        serviceId.setServiceName("serviceName");
        serviceId.setFax("fax");
        serviceId.setPhone("phone");
        serviceId.setEmail("email");
        serviceId.setAddress("address");
        serviceId.setCity("city");
        serviceId.setLink("link");
        serviceId.setStatus(0);
        serviceId.setTaxCode("taxCode");
        serviceId.setDateRegister(LocalDate.of(2020, 1, 1));
        serviceId.setIsActive(false);
        serviceId.setIsBlock(false);
        final ServiceCategory serviceCategoryId1 = new ServiceCategory();
        serviceCategoryId1.setServiceCategoryId(0L);
        serviceId.setServiceCategoryId(serviceCategoryId1);
        final Partner partnerId1 = new Partner();
        partnerId1.setEmail("email");
        serviceId.setPartnerId(partnerId1);
        utilitiesService.setServiceId(serviceId);
        final UtilitiesSubcategory utilitiesSubcategoryId = new UtilitiesSubcategory();
        utilitiesSubcategoryId.setUtilitiesSubcategoryId(0L);
        final UtilitiesCategory utilitiesCategoryId = new UtilitiesCategory();
        utilitiesCategoryId.setUtilitiesCategoryId(0L);
        utilitiesSubcategoryId.setUtilitiesCategoryId(utilitiesCategoryId);
        utilitiesService.setUtilitiesSubcategoryId(utilitiesSubcategoryId);
        final List<UtilitiesService> utilitiesServiceList = Arrays.asList(utilitiesService);
        when(serviceServiceImplUnderTest.utilitiesServiceRepository.getListUtilitiesServiceByServiceId(0L))
                .thenReturn(utilitiesServiceList);

        // Configure UtilitiesSubcategoryRepository.getById(...).
        final UtilitiesSubcategory utilitiesSubcategory = new UtilitiesSubcategory();
        utilitiesSubcategory.setUtilitiesSubcategoryId(0L);
        utilitiesSubcategory.setUtilitiesSubcategoryName("utilitiesSubcategoryName");
        final UtilitiesCategory utilitiesCategoryId1 = new UtilitiesCategory();
        utilitiesCategoryId1.setUtilitiesCategoryId(0L);
        utilitiesCategoryId1.setUtilitiesCategoryName("utilitiesCategoryName");
        utilitiesCategoryId1.setUtilitiesSubcategoryList(Arrays.asList(new UtilitiesSubcategory()));
        utilitiesSubcategory.setUtilitiesCategoryId(utilitiesCategoryId1);
        final UtilitiesService utilitiesService1 = new UtilitiesService();
        utilitiesService1.setUtilitiesServiceId(0L);
        final Service serviceId1 = new Service();
        serviceId1.setServiceId(0L);
        serviceId1.setServiceName("serviceName");
        serviceId1.setFax("fax");
        serviceId1.setPhone("phone");
        serviceId1.setEmail("email");
        serviceId1.setAddress("address");
        utilitiesService1.setServiceId(serviceId1);
        utilitiesSubcategory.setUtilitiesServiceList(Arrays.asList(utilitiesService1));
        when(serviceServiceImplUnderTest.utilitiesSubcategoryRepository.getById(0L)).thenReturn(utilitiesSubcategory);

        // Configure UtilitiesServiceRepository.save(...).
        final UtilitiesService utilitiesService2 = new UtilitiesService();
        final Service serviceId2 = new Service();
        serviceId2.setServiceId(0L);
        serviceId2.setServiceName("serviceName");
        serviceId2.setFax("fax");
        serviceId2.setPhone("phone");
        serviceId2.setEmail("email");
        serviceId2.setAddress("address");
        serviceId2.setCity("city");
        serviceId2.setLink("link");
        serviceId2.setStatus(0);
        serviceId2.setTaxCode("taxCode");
        serviceId2.setDateRegister(LocalDate.of(2020, 1, 1));
        serviceId2.setIsActive(false);
        serviceId2.setIsBlock(false);
        final ServiceCategory serviceCategoryId2 = new ServiceCategory();
        serviceCategoryId2.setServiceCategoryId(0L);
        serviceId2.setServiceCategoryId(serviceCategoryId2);
        final Partner partnerId2 = new Partner();
        partnerId2.setEmail("email");
        serviceId2.setPartnerId(partnerId2);
        utilitiesService2.setServiceId(serviceId2);
        final UtilitiesSubcategory utilitiesSubcategoryId1 = new UtilitiesSubcategory();
        utilitiesSubcategoryId1.setUtilitiesSubcategoryId(0L);
        final UtilitiesCategory utilitiesCategoryId2 = new UtilitiesCategory();
        utilitiesCategoryId2.setUtilitiesCategoryId(0L);
        utilitiesSubcategoryId1.setUtilitiesCategoryId(utilitiesCategoryId2);
        utilitiesService2.setUtilitiesSubcategoryId(utilitiesSubcategoryId1);
        when(serviceServiceImplUnderTest.utilitiesServiceRepository.save(any(UtilitiesService.class)))
                .thenReturn(utilitiesService2);

        // Run the test
        final Service result = serviceServiceImplUnderTest.updateService(serviceDTO, utilitiesServiceDTOList, 0L);

        // Verify the results
        verify(serviceServiceImplUnderTest.utilitiesServiceRepository).deleteAll(Arrays.asList(new UtilitiesService()));
        verify(serviceServiceImplUnderTest.utilitiesServiceRepository).save(any(UtilitiesService.class));
    }

    @Test
    void testUpdateService_UtilitiesServiceRepositoryGetListUtilitiesServiceByServiceIdReturnsNoItems() throws Exception {
        // Setup
        final ServiceDTO serviceDTO = new ServiceDTO(0L, "serviceName", "fax", "phone", "email", "address", "city",
                "link", 0, "taxCode", false, false, 0L, "typeOfServiceCategory", "email");
        final List<UtilitiesServiceDTO> utilitiesServiceDTOList = Arrays.asList(new UtilitiesServiceDTO(0L, 0L));

        // Configure ServiceRepository.getById(...).
        final Service service = new Service();
        service.setServiceId(0L);
        service.setServiceName("serviceName");
        service.setFax("fax");
        service.setPhone("phone");
        service.setEmail("email");
        service.setAddress("address");
        service.setCity("city");
        service.setLink("link");
        service.setStatus(0);
        service.setTaxCode("taxCode");
        service.setDateRegister(LocalDate.of(2020, 1, 1));
        service.setIsActive(false);
        service.setIsBlock(false);
        final ServiceCategory serviceCategoryId = new ServiceCategory();
        serviceCategoryId.setServiceCategoryId(0L);
        service.setServiceCategoryId(serviceCategoryId);
        final Partner partnerId = new Partner();
        partnerId.setEmail("email");
        service.setPartnerId(partnerId);
        when(serviceServiceImplUnderTest.serviceRepository.getById(0L)).thenReturn(service);

        when(serviceServiceImplUnderTest.serviceRepository.existsAllByServiceName("serviceName")).thenReturn(false);
        when(serviceServiceImplUnderTest.utilitiesServiceRepository.getListUtilitiesServiceByServiceId(0L))
                .thenReturn(Collections.emptyList());

        // Configure UtilitiesSubcategoryRepository.getById(...).
        final UtilitiesSubcategory utilitiesSubcategory = new UtilitiesSubcategory();
        utilitiesSubcategory.setUtilitiesSubcategoryId(0L);
        utilitiesSubcategory.setUtilitiesSubcategoryName("utilitiesSubcategoryName");
        final UtilitiesCategory utilitiesCategoryId = new UtilitiesCategory();
        utilitiesCategoryId.setUtilitiesCategoryId(0L);
        utilitiesCategoryId.setUtilitiesCategoryName("utilitiesCategoryName");
        utilitiesCategoryId.setUtilitiesSubcategoryList(Arrays.asList(new UtilitiesSubcategory()));
        utilitiesSubcategory.setUtilitiesCategoryId(utilitiesCategoryId);
        final UtilitiesService utilitiesService = new UtilitiesService();
        utilitiesService.setUtilitiesServiceId(0L);
        final Service serviceId = new Service();
        serviceId.setServiceId(0L);
        serviceId.setServiceName("serviceName");
        serviceId.setFax("fax");
        serviceId.setPhone("phone");
        serviceId.setEmail("email");
        serviceId.setAddress("address");
        utilitiesService.setServiceId(serviceId);
        utilitiesSubcategory.setUtilitiesServiceList(Arrays.asList(utilitiesService));
        when(serviceServiceImplUnderTest.utilitiesSubcategoryRepository.getById(0L)).thenReturn(utilitiesSubcategory);

        // Configure UtilitiesServiceRepository.save(...).
        final UtilitiesService utilitiesService1 = new UtilitiesService();
        final Service serviceId1 = new Service();
        serviceId1.setServiceId(0L);
        serviceId1.setServiceName("serviceName");
        serviceId1.setFax("fax");
        serviceId1.setPhone("phone");
        serviceId1.setEmail("email");
        serviceId1.setAddress("address");
        serviceId1.setCity("city");
        serviceId1.setLink("link");
        serviceId1.setStatus(0);
        serviceId1.setTaxCode("taxCode");
        serviceId1.setDateRegister(LocalDate.of(2020, 1, 1));
        serviceId1.setIsActive(false);
        serviceId1.setIsBlock(false);
        final ServiceCategory serviceCategoryId1 = new ServiceCategory();
        serviceCategoryId1.setServiceCategoryId(0L);
        serviceId1.setServiceCategoryId(serviceCategoryId1);
        final Partner partnerId1 = new Partner();
        partnerId1.setEmail("email");
        serviceId1.setPartnerId(partnerId1);
        utilitiesService1.setServiceId(serviceId1);
        final UtilitiesSubcategory utilitiesSubcategoryId = new UtilitiesSubcategory();
        utilitiesSubcategoryId.setUtilitiesSubcategoryId(0L);
        final UtilitiesCategory utilitiesCategoryId1 = new UtilitiesCategory();
        utilitiesCategoryId1.setUtilitiesCategoryId(0L);
        utilitiesSubcategoryId.setUtilitiesCategoryId(utilitiesCategoryId1);
        utilitiesService1.setUtilitiesSubcategoryId(utilitiesSubcategoryId);
        when(serviceServiceImplUnderTest.utilitiesServiceRepository.save(any(UtilitiesService.class)))
                .thenReturn(utilitiesService1);

        // Run the test
        final Service result = serviceServiceImplUnderTest.updateService(serviceDTO, utilitiesServiceDTOList, 0L);

        // Verify the results
        verify(serviceServiceImplUnderTest.utilitiesServiceRepository).deleteAll(Arrays.asList(new UtilitiesService()));
        verify(serviceServiceImplUnderTest.utilitiesServiceRepository).save(any(UtilitiesService.class));
    }

    @Test
    void testUpdateService_ThrowsHandlerException() {
        // Setup
        final ServiceDTO serviceDTO = new ServiceDTO(0L, "serviceName", "fax", "phone", "email", "address", "city",
                "link", 0, "taxCode", false, false, 0L, "typeOfServiceCategory", "email");
        final List<UtilitiesServiceDTO> utilitiesServiceDTOList = Arrays.asList(new UtilitiesServiceDTO(0L, 0L));

        // Configure ServiceRepository.getById(...).
        final Service service = new Service();
        service.setServiceId(0L);
        service.setServiceName("serviceName");
        service.setFax("fax");
        service.setPhone("phone");
        service.setEmail("email");
        service.setAddress("address");
        service.setCity("city");
        service.setLink("link");
        service.setStatus(0);
        service.setTaxCode("taxCode");
        service.setDateRegister(LocalDate.of(2020, 1, 1));
        service.setIsActive(false);
        service.setIsBlock(false);
        final ServiceCategory serviceCategoryId = new ServiceCategory();
        serviceCategoryId.setServiceCategoryId(0L);
        service.setServiceCategoryId(serviceCategoryId);
        final Partner partnerId = new Partner();
        partnerId.setEmail("email");
        service.setPartnerId(partnerId);
        when(serviceServiceImplUnderTest.serviceRepository.getById(0L)).thenReturn(service);

        when(serviceServiceImplUnderTest.serviceRepository.existsAllByServiceName("serviceName")).thenReturn(false);

        // Configure UtilitiesServiceRepository.getListUtilitiesServiceByServiceId(...).
        final UtilitiesService utilitiesService = new UtilitiesService();
        final Service serviceId = new Service();
        serviceId.setServiceId(0L);
        serviceId.setServiceName("serviceName");
        serviceId.setFax("fax");
        serviceId.setPhone("phone");
        serviceId.setEmail("email");
        serviceId.setAddress("address");
        serviceId.setCity("city");
        serviceId.setLink("link");
        serviceId.setStatus(0);
        serviceId.setTaxCode("taxCode");
        serviceId.setDateRegister(LocalDate.of(2020, 1, 1));
        serviceId.setIsActive(false);
        serviceId.setIsBlock(false);
        final ServiceCategory serviceCategoryId1 = new ServiceCategory();
        serviceCategoryId1.setServiceCategoryId(0L);
        serviceId.setServiceCategoryId(serviceCategoryId1);
        final Partner partnerId1 = new Partner();
        partnerId1.setEmail("email");
        serviceId.setPartnerId(partnerId1);
        utilitiesService.setServiceId(serviceId);
        final UtilitiesSubcategory utilitiesSubcategoryId = new UtilitiesSubcategory();
        utilitiesSubcategoryId.setUtilitiesSubcategoryId(0L);
        final UtilitiesCategory utilitiesCategoryId = new UtilitiesCategory();
        utilitiesCategoryId.setUtilitiesCategoryId(0L);
        utilitiesSubcategoryId.setUtilitiesCategoryId(utilitiesCategoryId);
        utilitiesService.setUtilitiesSubcategoryId(utilitiesSubcategoryId);
        final List<UtilitiesService> utilitiesServiceList = Arrays.asList(utilitiesService);
        when(serviceServiceImplUnderTest.utilitiesServiceRepository.getListUtilitiesServiceByServiceId(0L))
                .thenReturn(utilitiesServiceList);

        // Configure UtilitiesSubcategoryRepository.getById(...).
        final UtilitiesSubcategory utilitiesSubcategory = new UtilitiesSubcategory();
        utilitiesSubcategory.setUtilitiesSubcategoryId(0L);
        utilitiesSubcategory.setUtilitiesSubcategoryName("utilitiesSubcategoryName");
        final UtilitiesCategory utilitiesCategoryId1 = new UtilitiesCategory();
        utilitiesCategoryId1.setUtilitiesCategoryId(0L);
        utilitiesCategoryId1.setUtilitiesCategoryName("utilitiesCategoryName");
        utilitiesCategoryId1.setUtilitiesSubcategoryList(Arrays.asList(new UtilitiesSubcategory()));
        utilitiesSubcategory.setUtilitiesCategoryId(utilitiesCategoryId1);
        final UtilitiesService utilitiesService1 = new UtilitiesService();
        utilitiesService1.setUtilitiesServiceId(0L);
        final Service serviceId1 = new Service();
        serviceId1.setServiceId(0L);
        serviceId1.setServiceName("serviceName");
        serviceId1.setFax("fax");
        serviceId1.setPhone("phone");
        serviceId1.setEmail("email");
        serviceId1.setAddress("address");
        utilitiesService1.setServiceId(serviceId1);
        utilitiesSubcategory.setUtilitiesServiceList(Arrays.asList(utilitiesService1));
        when(serviceServiceImplUnderTest.utilitiesSubcategoryRepository.getById(0L)).thenReturn(utilitiesSubcategory);

        // Configure UtilitiesServiceRepository.save(...).
        final UtilitiesService utilitiesService2 = new UtilitiesService();
        final Service serviceId2 = new Service();
        serviceId2.setServiceId(0L);
        serviceId2.setServiceName("serviceName");
        serviceId2.setFax("fax");
        serviceId2.setPhone("phone");
        serviceId2.setEmail("email");
        serviceId2.setAddress("address");
        serviceId2.setCity("city");
        serviceId2.setLink("link");
        serviceId2.setStatus(0);
        serviceId2.setTaxCode("taxCode");
        serviceId2.setDateRegister(LocalDate.of(2020, 1, 1));
        serviceId2.setIsActive(false);
        serviceId2.setIsBlock(false);
        final ServiceCategory serviceCategoryId2 = new ServiceCategory();
        serviceCategoryId2.setServiceCategoryId(0L);
        serviceId2.setServiceCategoryId(serviceCategoryId2);
        final Partner partnerId2 = new Partner();
        partnerId2.setEmail("email");
        serviceId2.setPartnerId(partnerId2);
        utilitiesService2.setServiceId(serviceId2);
        final UtilitiesSubcategory utilitiesSubcategoryId1 = new UtilitiesSubcategory();
        utilitiesSubcategoryId1.setUtilitiesSubcategoryId(0L);
        final UtilitiesCategory utilitiesCategoryId2 = new UtilitiesCategory();
        utilitiesCategoryId2.setUtilitiesCategoryId(0L);
        utilitiesSubcategoryId1.setUtilitiesCategoryId(utilitiesCategoryId2);
        utilitiesService2.setUtilitiesSubcategoryId(utilitiesSubcategoryId1);
        when(serviceServiceImplUnderTest.utilitiesServiceRepository.save(any(UtilitiesService.class)))
                .thenReturn(utilitiesService2);

        // Run the test
        assertThatThrownBy(
                () -> serviceServiceImplUnderTest.updateService(serviceDTO, utilitiesServiceDTOList, 0L))
                .isInstanceOf(HandlerException.class);
        verify(serviceServiceImplUnderTest.utilitiesServiceRepository).deleteAll(Arrays.asList(new UtilitiesService()));
        verify(serviceServiceImplUnderTest.utilitiesServiceRepository).save(any(UtilitiesService.class));
    }

    @Test
    void testUpdateAccommodation() throws Exception {
        // Setup
        final AccommodationDTO accommodationDTO = new AccommodationDTO(
                new ServiceDTO(0L, "serviceName", "fax", "phone", "email", "address", "city", "link", 0, "taxCode",
                        false, false, 0L, "typeOfServiceCategory", "email"), "accommodationType", 0.0f, 0,
                "description",
                Arrays.asList(new RoomDTO("roomName", "roomType", 0.0f, 0, 0, 0.0f, 0.0f, "description", "bedType")),
                Arrays.asList(new UtilitiesServiceDTO(0L, 0L)));

        // Configure ServiceRepository.getById(...).
        final Service service = new Service();
        service.setServiceId(0L);
        service.setServiceName("serviceName");
        service.setFax("fax");
        service.setPhone("phone");
        service.setEmail("email");
        service.setAddress("address");
        service.setCity("city");
        service.setLink("link");
        service.setStatus(0);
        service.setTaxCode("taxCode");
        service.setDateRegister(LocalDate.of(2020, 1, 1));
        service.setIsActive(false);
        service.setIsBlock(false);
        final ServiceCategory serviceCategoryId = new ServiceCategory();
        serviceCategoryId.setServiceCategoryId(0L);
        service.setServiceCategoryId(serviceCategoryId);
        final Partner partnerId = new Partner();
        partnerId.setEmail("email");
        service.setPartnerId(partnerId);
        when(serviceServiceImplUnderTest.serviceRepository.getById(0L)).thenReturn(service);

        when(serviceServiceImplUnderTest.serviceRepository.existsAllByServiceName("serviceName")).thenReturn(false);

        // Configure UtilitiesServiceRepository.getListUtilitiesServiceByServiceId(...).
        final UtilitiesService utilitiesService = new UtilitiesService();
        final Service serviceId = new Service();
        serviceId.setServiceId(0L);
        serviceId.setServiceName("serviceName");
        serviceId.setFax("fax");
        serviceId.setPhone("phone");
        serviceId.setEmail("email");
        serviceId.setAddress("address");
        serviceId.setCity("city");
        serviceId.setLink("link");
        serviceId.setStatus(0);
        serviceId.setTaxCode("taxCode");
        serviceId.setDateRegister(LocalDate.of(2020, 1, 1));
        serviceId.setIsActive(false);
        serviceId.setIsBlock(false);
        final ServiceCategory serviceCategoryId1 = new ServiceCategory();
        serviceCategoryId1.setServiceCategoryId(0L);
        serviceId.setServiceCategoryId(serviceCategoryId1);
        final Partner partnerId1 = new Partner();
        partnerId1.setEmail("email");
        serviceId.setPartnerId(partnerId1);
        utilitiesService.setServiceId(serviceId);
        final UtilitiesSubcategory utilitiesSubcategoryId = new UtilitiesSubcategory();
        utilitiesSubcategoryId.setUtilitiesSubcategoryId(0L);
        final UtilitiesCategory utilitiesCategoryId = new UtilitiesCategory();
        utilitiesCategoryId.setUtilitiesCategoryId(0L);
        utilitiesSubcategoryId.setUtilitiesCategoryId(utilitiesCategoryId);
        utilitiesService.setUtilitiesSubcategoryId(utilitiesSubcategoryId);
        final List<UtilitiesService> utilitiesServiceList = Arrays.asList(utilitiesService);
        when(serviceServiceImplUnderTest.utilitiesServiceRepository.getListUtilitiesServiceByServiceId(0L))
                .thenReturn(utilitiesServiceList);

        // Configure UtilitiesSubcategoryRepository.getById(...).
        final UtilitiesSubcategory utilitiesSubcategory = new UtilitiesSubcategory();
        utilitiesSubcategory.setUtilitiesSubcategoryId(0L);
        utilitiesSubcategory.setUtilitiesSubcategoryName("utilitiesSubcategoryName");
        final UtilitiesCategory utilitiesCategoryId1 = new UtilitiesCategory();
        utilitiesCategoryId1.setUtilitiesCategoryId(0L);
        utilitiesCategoryId1.setUtilitiesCategoryName("utilitiesCategoryName");
        utilitiesCategoryId1.setUtilitiesSubcategoryList(Arrays.asList(new UtilitiesSubcategory()));
        utilitiesSubcategory.setUtilitiesCategoryId(utilitiesCategoryId1);
        final UtilitiesService utilitiesService1 = new UtilitiesService();
        utilitiesService1.setUtilitiesServiceId(0L);
        final Service serviceId1 = new Service();
        serviceId1.setServiceId(0L);
        serviceId1.setServiceName("serviceName");
        serviceId1.setFax("fax");
        serviceId1.setPhone("phone");
        serviceId1.setEmail("email");
        serviceId1.setAddress("address");
        utilitiesService1.setServiceId(serviceId1);
        utilitiesSubcategory.setUtilitiesServiceList(Arrays.asList(utilitiesService1));
        when(serviceServiceImplUnderTest.utilitiesSubcategoryRepository.getById(0L)).thenReturn(utilitiesSubcategory);

        // Configure UtilitiesServiceRepository.save(...).
        final UtilitiesService utilitiesService2 = new UtilitiesService();
        final Service serviceId2 = new Service();
        serviceId2.setServiceId(0L);
        serviceId2.setServiceName("serviceName");
        serviceId2.setFax("fax");
        serviceId2.setPhone("phone");
        serviceId2.setEmail("email");
        serviceId2.setAddress("address");
        serviceId2.setCity("city");
        serviceId2.setLink("link");
        serviceId2.setStatus(0);
        serviceId2.setTaxCode("taxCode");
        serviceId2.setDateRegister(LocalDate.of(2020, 1, 1));
        serviceId2.setIsActive(false);
        serviceId2.setIsBlock(false);
        final ServiceCategory serviceCategoryId2 = new ServiceCategory();
        serviceCategoryId2.setServiceCategoryId(0L);
        serviceId2.setServiceCategoryId(serviceCategoryId2);
        final Partner partnerId2 = new Partner();
        partnerId2.setEmail("email");
        serviceId2.setPartnerId(partnerId2);
        utilitiesService2.setServiceId(serviceId2);
        final UtilitiesSubcategory utilitiesSubcategoryId1 = new UtilitiesSubcategory();
        utilitiesSubcategoryId1.setUtilitiesSubcategoryId(0L);
        final UtilitiesCategory utilitiesCategoryId2 = new UtilitiesCategory();
        utilitiesCategoryId2.setUtilitiesCategoryId(0L);
        utilitiesSubcategoryId1.setUtilitiesCategoryId(utilitiesCategoryId2);
        utilitiesService2.setUtilitiesSubcategoryId(utilitiesSubcategoryId1);
        when(serviceServiceImplUnderTest.utilitiesServiceRepository.save(any(UtilitiesService.class)))
                .thenReturn(utilitiesService2);

        // Configure AccommodationRepository.getByServiceId(...).
        final Accommodation accommodation = new Accommodation();
        accommodation.setAccommodationId(0L);
        accommodation.setAccommodationType("accommodationType");
        accommodation.setRate(0.0f);
        accommodation.setNumberFloors(0);
        accommodation.setDescription("description");
        final Service serviceId3 = new Service();
        serviceId3.setServiceId(0L);
        serviceId3.setServiceName("serviceName");
        serviceId3.setFax("fax");
        serviceId3.setPhone("phone");
        serviceId3.setEmail("email");
        serviceId3.setAddress("address");
        serviceId3.setCity("city");
        serviceId3.setLink("link");
        serviceId3.setStatus(0);
        serviceId3.setTaxCode("taxCode");
        serviceId3.setDateRegister(LocalDate.of(2020, 1, 1));
        serviceId3.setIsActive(false);
        serviceId3.setIsBlock(false);
        final ServiceCategory serviceCategoryId3 = new ServiceCategory();
        serviceCategoryId3.setServiceCategoryId(0L);
        serviceId3.setServiceCategoryId(serviceCategoryId3);
        final Partner partnerId3 = new Partner();
        partnerId3.setEmail("email");
        serviceId3.setPartnerId(partnerId3);
        accommodation.setServiceId(serviceId3);
        when(serviceServiceImplUnderTest.accommodationRepository.getByServiceId(0L)).thenReturn(accommodation);

        // Configure RoomRepository.getListRoomByAccommodationId(...).
        final Room room = new Room();
        room.setRoomName("roomName");
        room.setRoomType("roomType");
        room.setArea(0.0f);
        room.setNumberRooms(0);
        room.setNumberOfPeople(0);
        room.setDailyPrice(0.0f);
        room.setHolidayPrice(0.0f);
        room.setDescription("description");
        room.setBedType("bedType");
        final Accommodation accommodationId = new Accommodation();
        accommodationId.setAccommodationId(0L);
        accommodationId.setAccommodationType("accommodationType");
        accommodationId.setRate(0.0f);
        accommodationId.setNumberFloors(0);
        accommodationId.setDescription("description");
        final Service serviceId4 = new Service();
        serviceId4.setServiceId(0L);
        serviceId4.setServiceName("serviceName");
        serviceId4.setFax("fax");
        serviceId4.setPhone("phone");
        serviceId4.setEmail("email");
        serviceId4.setAddress("address");
        serviceId4.setCity("city");
        serviceId4.setLink("link");
        serviceId4.setStatus(0);
        serviceId4.setTaxCode("taxCode");
        serviceId4.setDateRegister(LocalDate.of(2020, 1, 1));
        serviceId4.setIsActive(false);
        serviceId4.setIsBlock(false);
        final ServiceCategory serviceCategoryId4 = new ServiceCategory();
        serviceCategoryId4.setServiceCategoryId(0L);
        serviceId4.setServiceCategoryId(serviceCategoryId4);
        final Partner partnerId4 = new Partner();
        partnerId4.setEmail("email");
        serviceId4.setPartnerId(partnerId4);
        accommodationId.setServiceId(serviceId4);
        room.setAccommodationId(accommodationId);
        final List<Room> roomList = Arrays.asList(room);
        when(serviceServiceImplUnderTest.roomRepository.getListRoomByAccommodationId(0L)).thenReturn(roomList);

        // Configure RoomRepository.save(...).
        final Room room1 = new Room();
        room1.setRoomName("roomName");
        room1.setRoomType("roomType");
        room1.setArea(0.0f);
        room1.setNumberRooms(0);
        room1.setNumberOfPeople(0);
        room1.setDailyPrice(0.0f);
        room1.setHolidayPrice(0.0f);
        room1.setDescription("description");
        room1.setBedType("bedType");
        final Accommodation accommodationId1 = new Accommodation();
        accommodationId1.setAccommodationId(0L);
        accommodationId1.setAccommodationType("accommodationType");
        accommodationId1.setRate(0.0f);
        accommodationId1.setNumberFloors(0);
        accommodationId1.setDescription("description");
        final Service serviceId5 = new Service();
        serviceId5.setServiceId(0L);
        serviceId5.setServiceName("serviceName");
        serviceId5.setFax("fax");
        serviceId5.setPhone("phone");
        serviceId5.setEmail("email");
        serviceId5.setAddress("address");
        serviceId5.setCity("city");
        serviceId5.setLink("link");
        serviceId5.setStatus(0);
        serviceId5.setTaxCode("taxCode");
        serviceId5.setDateRegister(LocalDate.of(2020, 1, 1));
        serviceId5.setIsActive(false);
        serviceId5.setIsBlock(false);
        final ServiceCategory serviceCategoryId5 = new ServiceCategory();
        serviceCategoryId5.setServiceCategoryId(0L);
        serviceId5.setServiceCategoryId(serviceCategoryId5);
        final Partner partnerId5 = new Partner();
        partnerId5.setEmail("email");
        serviceId5.setPartnerId(partnerId5);
        accommodationId1.setServiceId(serviceId5);
        room1.setAccommodationId(accommodationId1);
        when(serviceServiceImplUnderTest.roomRepository.save(any(Room.class))).thenReturn(room1);

        // Configure UtilitiesSubcategoryRepository.findByUtilitiesSubcategoryId(...).
        final UtilitiesSubcategory utilitiesSubcategory1 = new UtilitiesSubcategory();
        utilitiesSubcategory1.setUtilitiesSubcategoryId(0L);
        utilitiesSubcategory1.setUtilitiesSubcategoryName("utilitiesSubcategoryName");
        final UtilitiesCategory utilitiesCategoryId3 = new UtilitiesCategory();
        utilitiesCategoryId3.setUtilitiesCategoryId(0L);
        utilitiesCategoryId3.setUtilitiesCategoryName("utilitiesCategoryName");
        utilitiesCategoryId3.setUtilitiesSubcategoryList(Arrays.asList(new UtilitiesSubcategory()));
        utilitiesSubcategory1.setUtilitiesCategoryId(utilitiesCategoryId3);
        final UtilitiesService utilitiesService3 = new UtilitiesService();
        utilitiesService3.setUtilitiesServiceId(0L);
        final Service serviceId6 = new Service();
        serviceId6.setServiceId(0L);
        serviceId6.setServiceName("serviceName");
        serviceId6.setFax("fax");
        serviceId6.setPhone("phone");
        serviceId6.setEmail("email");
        serviceId6.setAddress("address");
        utilitiesService3.setServiceId(serviceId6);
        utilitiesSubcategory1.setUtilitiesServiceList(Arrays.asList(utilitiesService3));
        when(serviceServiceImplUnderTest.utilitiesSubcategoryRepository.findByUtilitiesSubcategoryId(0L))
                .thenReturn(utilitiesSubcategory1);

        // Run the test
        final AccommodationDTO result = serviceServiceImplUnderTest.updateAccommodation(accommodationDTO, 0L);

        // Verify the results
        verify(serviceServiceImplUnderTest.utilitiesServiceRepository).deleteAll(Arrays.asList(new UtilitiesService()));
        verify(serviceServiceImplUnderTest.utilitiesServiceRepository).save(any(UtilitiesService.class));
        verify(serviceServiceImplUnderTest.roomRepository).deleteAll(Arrays.asList(new Room()));
        verify(serviceServiceImplUnderTest.roomRepository).save(any(Room.class));
    }

    @Test
    void testUpdateAccommodation_UtilitiesServiceRepositoryGetListUtilitiesServiceByServiceIdReturnsNoItems() throws Exception {
        // Setup
        final AccommodationDTO accommodationDTO = new AccommodationDTO(
                new ServiceDTO(0L, "serviceName", "fax", "phone", "email", "address", "city", "link", 0, "taxCode",
                        false, false, 0L, "typeOfServiceCategory", "email"), "accommodationType", 0.0f, 0,
                "description",
                Arrays.asList(new RoomDTO("roomName", "roomType", 0.0f, 0, 0, 0.0f, 0.0f, "description", "bedType")),
                Arrays.asList(new UtilitiesServiceDTO(0L, 0L)));

        // Configure ServiceRepository.getById(...).
        final Service service = new Service();
        service.setServiceId(0L);
        service.setServiceName("serviceName");
        service.setFax("fax");
        service.setPhone("phone");
        service.setEmail("email");
        service.setAddress("address");
        service.setCity("city");
        service.setLink("link");
        service.setStatus(0);
        service.setTaxCode("taxCode");
        service.setDateRegister(LocalDate.of(2020, 1, 1));
        service.setIsActive(false);
        service.setIsBlock(false);
        final ServiceCategory serviceCategoryId = new ServiceCategory();
        serviceCategoryId.setServiceCategoryId(0L);
        service.setServiceCategoryId(serviceCategoryId);
        final Partner partnerId = new Partner();
        partnerId.setEmail("email");
        service.setPartnerId(partnerId);
        when(serviceServiceImplUnderTest.serviceRepository.getById(0L)).thenReturn(service);

        when(serviceServiceImplUnderTest.serviceRepository.existsAllByServiceName("serviceName")).thenReturn(false);
        when(serviceServiceImplUnderTest.utilitiesServiceRepository.getListUtilitiesServiceByServiceId(0L))
                .thenReturn(Collections.emptyList());

        // Configure UtilitiesSubcategoryRepository.getById(...).
        final UtilitiesSubcategory utilitiesSubcategory = new UtilitiesSubcategory();
        utilitiesSubcategory.setUtilitiesSubcategoryId(0L);
        utilitiesSubcategory.setUtilitiesSubcategoryName("utilitiesSubcategoryName");
        final UtilitiesCategory utilitiesCategoryId = new UtilitiesCategory();
        utilitiesCategoryId.setUtilitiesCategoryId(0L);
        utilitiesCategoryId.setUtilitiesCategoryName("utilitiesCategoryName");
        utilitiesCategoryId.setUtilitiesSubcategoryList(Arrays.asList(new UtilitiesSubcategory()));
        utilitiesSubcategory.setUtilitiesCategoryId(utilitiesCategoryId);
        final UtilitiesService utilitiesService = new UtilitiesService();
        utilitiesService.setUtilitiesServiceId(0L);
        final Service serviceId = new Service();
        serviceId.setServiceId(0L);
        serviceId.setServiceName("serviceName");
        serviceId.setFax("fax");
        serviceId.setPhone("phone");
        serviceId.setEmail("email");
        serviceId.setAddress("address");
        utilitiesService.setServiceId(serviceId);
        utilitiesSubcategory.setUtilitiesServiceList(Arrays.asList(utilitiesService));
        when(serviceServiceImplUnderTest.utilitiesSubcategoryRepository.getById(0L)).thenReturn(utilitiesSubcategory);

        // Configure UtilitiesServiceRepository.save(...).
        final UtilitiesService utilitiesService1 = new UtilitiesService();
        final Service serviceId1 = new Service();
        serviceId1.setServiceId(0L);
        serviceId1.setServiceName("serviceName");
        serviceId1.setFax("fax");
        serviceId1.setPhone("phone");
        serviceId1.setEmail("email");
        serviceId1.setAddress("address");
        serviceId1.setCity("city");
        serviceId1.setLink("link");
        serviceId1.setStatus(0);
        serviceId1.setTaxCode("taxCode");
        serviceId1.setDateRegister(LocalDate.of(2020, 1, 1));
        serviceId1.setIsActive(false);
        serviceId1.setIsBlock(false);
        final ServiceCategory serviceCategoryId1 = new ServiceCategory();
        serviceCategoryId1.setServiceCategoryId(0L);
        serviceId1.setServiceCategoryId(serviceCategoryId1);
        final Partner partnerId1 = new Partner();
        partnerId1.setEmail("email");
        serviceId1.setPartnerId(partnerId1);
        utilitiesService1.setServiceId(serviceId1);
        final UtilitiesSubcategory utilitiesSubcategoryId = new UtilitiesSubcategory();
        utilitiesSubcategoryId.setUtilitiesSubcategoryId(0L);
        final UtilitiesCategory utilitiesCategoryId1 = new UtilitiesCategory();
        utilitiesCategoryId1.setUtilitiesCategoryId(0L);
        utilitiesSubcategoryId.setUtilitiesCategoryId(utilitiesCategoryId1);
        utilitiesService1.setUtilitiesSubcategoryId(utilitiesSubcategoryId);
        when(serviceServiceImplUnderTest.utilitiesServiceRepository.save(any(UtilitiesService.class)))
                .thenReturn(utilitiesService1);

        // Configure AccommodationRepository.getByServiceId(...).
        final Accommodation accommodation = new Accommodation();
        accommodation.setAccommodationId(0L);
        accommodation.setAccommodationType("accommodationType");
        accommodation.setRate(0.0f);
        accommodation.setNumberFloors(0);
        accommodation.setDescription("description");
        final Service serviceId2 = new Service();
        serviceId2.setServiceId(0L);
        serviceId2.setServiceName("serviceName");
        serviceId2.setFax("fax");
        serviceId2.setPhone("phone");
        serviceId2.setEmail("email");
        serviceId2.setAddress("address");
        serviceId2.setCity("city");
        serviceId2.setLink("link");
        serviceId2.setStatus(0);
        serviceId2.setTaxCode("taxCode");
        serviceId2.setDateRegister(LocalDate.of(2020, 1, 1));
        serviceId2.setIsActive(false);
        serviceId2.setIsBlock(false);
        final ServiceCategory serviceCategoryId2 = new ServiceCategory();
        serviceCategoryId2.setServiceCategoryId(0L);
        serviceId2.setServiceCategoryId(serviceCategoryId2);
        final Partner partnerId2 = new Partner();
        partnerId2.setEmail("email");
        serviceId2.setPartnerId(partnerId2);
        accommodation.setServiceId(serviceId2);
        when(serviceServiceImplUnderTest.accommodationRepository.getByServiceId(0L)).thenReturn(accommodation);

        // Configure RoomRepository.getListRoomByAccommodationId(...).
        final Room room = new Room();
        room.setRoomName("roomName");
        room.setRoomType("roomType");
        room.setArea(0.0f);
        room.setNumberRooms(0);
        room.setNumberOfPeople(0);
        room.setDailyPrice(0.0f);
        room.setHolidayPrice(0.0f);
        room.setDescription("description");
        room.setBedType("bedType");
        final Accommodation accommodationId = new Accommodation();
        accommodationId.setAccommodationId(0L);
        accommodationId.setAccommodationType("accommodationType");
        accommodationId.setRate(0.0f);
        accommodationId.setNumberFloors(0);
        accommodationId.setDescription("description");
        final Service serviceId3 = new Service();
        serviceId3.setServiceId(0L);
        serviceId3.setServiceName("serviceName");
        serviceId3.setFax("fax");
        serviceId3.setPhone("phone");
        serviceId3.setEmail("email");
        serviceId3.setAddress("address");
        serviceId3.setCity("city");
        serviceId3.setLink("link");
        serviceId3.setStatus(0);
        serviceId3.setTaxCode("taxCode");
        serviceId3.setDateRegister(LocalDate.of(2020, 1, 1));
        serviceId3.setIsActive(false);
        serviceId3.setIsBlock(false);
        final ServiceCategory serviceCategoryId3 = new ServiceCategory();
        serviceCategoryId3.setServiceCategoryId(0L);
        serviceId3.setServiceCategoryId(serviceCategoryId3);
        final Partner partnerId3 = new Partner();
        partnerId3.setEmail("email");
        serviceId3.setPartnerId(partnerId3);
        accommodationId.setServiceId(serviceId3);
        room.setAccommodationId(accommodationId);
        final List<Room> roomList = Arrays.asList(room);
        when(serviceServiceImplUnderTest.roomRepository.getListRoomByAccommodationId(0L)).thenReturn(roomList);

        // Configure RoomRepository.save(...).
        final Room room1 = new Room();
        room1.setRoomName("roomName");
        room1.setRoomType("roomType");
        room1.setArea(0.0f);
        room1.setNumberRooms(0);
        room1.setNumberOfPeople(0);
        room1.setDailyPrice(0.0f);
        room1.setHolidayPrice(0.0f);
        room1.setDescription("description");
        room1.setBedType("bedType");
        final Accommodation accommodationId1 = new Accommodation();
        accommodationId1.setAccommodationId(0L);
        accommodationId1.setAccommodationType("accommodationType");
        accommodationId1.setRate(0.0f);
        accommodationId1.setNumberFloors(0);
        accommodationId1.setDescription("description");
        final Service serviceId4 = new Service();
        serviceId4.setServiceId(0L);
        serviceId4.setServiceName("serviceName");
        serviceId4.setFax("fax");
        serviceId4.setPhone("phone");
        serviceId4.setEmail("email");
        serviceId4.setAddress("address");
        serviceId4.setCity("city");
        serviceId4.setLink("link");
        serviceId4.setStatus(0);
        serviceId4.setTaxCode("taxCode");
        serviceId4.setDateRegister(LocalDate.of(2020, 1, 1));
        serviceId4.setIsActive(false);
        serviceId4.setIsBlock(false);
        final ServiceCategory serviceCategoryId4 = new ServiceCategory();
        serviceCategoryId4.setServiceCategoryId(0L);
        serviceId4.setServiceCategoryId(serviceCategoryId4);
        final Partner partnerId4 = new Partner();
        partnerId4.setEmail("email");
        serviceId4.setPartnerId(partnerId4);
        accommodationId1.setServiceId(serviceId4);
        room1.setAccommodationId(accommodationId1);
        when(serviceServiceImplUnderTest.roomRepository.save(any(Room.class))).thenReturn(room1);

        // Configure UtilitiesSubcategoryRepository.findByUtilitiesSubcategoryId(...).
        final UtilitiesSubcategory utilitiesSubcategory1 = new UtilitiesSubcategory();
        utilitiesSubcategory1.setUtilitiesSubcategoryId(0L);
        utilitiesSubcategory1.setUtilitiesSubcategoryName("utilitiesSubcategoryName");
        final UtilitiesCategory utilitiesCategoryId2 = new UtilitiesCategory();
        utilitiesCategoryId2.setUtilitiesCategoryId(0L);
        utilitiesCategoryId2.setUtilitiesCategoryName("utilitiesCategoryName");
        utilitiesCategoryId2.setUtilitiesSubcategoryList(Arrays.asList(new UtilitiesSubcategory()));
        utilitiesSubcategory1.setUtilitiesCategoryId(utilitiesCategoryId2);
        final UtilitiesService utilitiesService2 = new UtilitiesService();
        utilitiesService2.setUtilitiesServiceId(0L);
        final Service serviceId5 = new Service();
        serviceId5.setServiceId(0L);
        serviceId5.setServiceName("serviceName");
        serviceId5.setFax("fax");
        serviceId5.setPhone("phone");
        serviceId5.setEmail("email");
        serviceId5.setAddress("address");
        utilitiesService2.setServiceId(serviceId5);
        utilitiesSubcategory1.setUtilitiesServiceList(Arrays.asList(utilitiesService2));
        when(serviceServiceImplUnderTest.utilitiesSubcategoryRepository.findByUtilitiesSubcategoryId(0L))
                .thenReturn(utilitiesSubcategory1);

        // Run the test
        final AccommodationDTO result = serviceServiceImplUnderTest.updateAccommodation(accommodationDTO, 0L);

        // Verify the results
        verify(serviceServiceImplUnderTest.utilitiesServiceRepository).deleteAll(Arrays.asList(new UtilitiesService()));
        verify(serviceServiceImplUnderTest.utilitiesServiceRepository).save(any(UtilitiesService.class));
        verify(serviceServiceImplUnderTest.roomRepository).deleteAll(Arrays.asList(new Room()));
        verify(serviceServiceImplUnderTest.roomRepository).save(any(Room.class));
    }

    @Test
    void testUpdateAccommodation_RoomRepositoryGetListRoomByAccommodationIdReturnsNoItems() throws Exception {
        // Setup
        final AccommodationDTO accommodationDTO = new AccommodationDTO(
                new ServiceDTO(0L, "serviceName", "fax", "phone", "email", "address", "city", "link", 0, "taxCode",
                        false, false, 0L, "typeOfServiceCategory", "email"), "accommodationType", 0.0f, 0,
                "description",
                Arrays.asList(new RoomDTO("roomName", "roomType", 0.0f, 0, 0, 0.0f, 0.0f, "description", "bedType")),
                Arrays.asList(new UtilitiesServiceDTO(0L, 0L)));

        // Configure ServiceRepository.getById(...).
        final Service service = new Service();
        service.setServiceId(0L);
        service.setServiceName("serviceName");
        service.setFax("fax");
        service.setPhone("phone");
        service.setEmail("email");
        service.setAddress("address");
        service.setCity("city");
        service.setLink("link");
        service.setStatus(0);
        service.setTaxCode("taxCode");
        service.setDateRegister(LocalDate.of(2020, 1, 1));
        service.setIsActive(false);
        service.setIsBlock(false);
        final ServiceCategory serviceCategoryId = new ServiceCategory();
        serviceCategoryId.setServiceCategoryId(0L);
        service.setServiceCategoryId(serviceCategoryId);
        final Partner partnerId = new Partner();
        partnerId.setEmail("email");
        service.setPartnerId(partnerId);
        when(serviceServiceImplUnderTest.serviceRepository.getById(0L)).thenReturn(service);

        when(serviceServiceImplUnderTest.serviceRepository.existsAllByServiceName("serviceName")).thenReturn(false);

        // Configure UtilitiesServiceRepository.getListUtilitiesServiceByServiceId(...).
        final UtilitiesService utilitiesService = new UtilitiesService();
        final Service serviceId = new Service();
        serviceId.setServiceId(0L);
        serviceId.setServiceName("serviceName");
        serviceId.setFax("fax");
        serviceId.setPhone("phone");
        serviceId.setEmail("email");
        serviceId.setAddress("address");
        serviceId.setCity("city");
        serviceId.setLink("link");
        serviceId.setStatus(0);
        serviceId.setTaxCode("taxCode");
        serviceId.setDateRegister(LocalDate.of(2020, 1, 1));
        serviceId.setIsActive(false);
        serviceId.setIsBlock(false);
        final ServiceCategory serviceCategoryId1 = new ServiceCategory();
        serviceCategoryId1.setServiceCategoryId(0L);
        serviceId.setServiceCategoryId(serviceCategoryId1);
        final Partner partnerId1 = new Partner();
        partnerId1.setEmail("email");
        serviceId.setPartnerId(partnerId1);
        utilitiesService.setServiceId(serviceId);
        final UtilitiesSubcategory utilitiesSubcategoryId = new UtilitiesSubcategory();
        utilitiesSubcategoryId.setUtilitiesSubcategoryId(0L);
        final UtilitiesCategory utilitiesCategoryId = new UtilitiesCategory();
        utilitiesCategoryId.setUtilitiesCategoryId(0L);
        utilitiesSubcategoryId.setUtilitiesCategoryId(utilitiesCategoryId);
        utilitiesService.setUtilitiesSubcategoryId(utilitiesSubcategoryId);
        final List<UtilitiesService> utilitiesServiceList = Arrays.asList(utilitiesService);
        when(serviceServiceImplUnderTest.utilitiesServiceRepository.getListUtilitiesServiceByServiceId(0L))
                .thenReturn(utilitiesServiceList);

        // Configure UtilitiesSubcategoryRepository.getById(...).
        final UtilitiesSubcategory utilitiesSubcategory = new UtilitiesSubcategory();
        utilitiesSubcategory.setUtilitiesSubcategoryId(0L);
        utilitiesSubcategory.setUtilitiesSubcategoryName("utilitiesSubcategoryName");
        final UtilitiesCategory utilitiesCategoryId1 = new UtilitiesCategory();
        utilitiesCategoryId1.setUtilitiesCategoryId(0L);
        utilitiesCategoryId1.setUtilitiesCategoryName("utilitiesCategoryName");
        utilitiesCategoryId1.setUtilitiesSubcategoryList(Arrays.asList(new UtilitiesSubcategory()));
        utilitiesSubcategory.setUtilitiesCategoryId(utilitiesCategoryId1);
        final UtilitiesService utilitiesService1 = new UtilitiesService();
        utilitiesService1.setUtilitiesServiceId(0L);
        final Service serviceId1 = new Service();
        serviceId1.setServiceId(0L);
        serviceId1.setServiceName("serviceName");
        serviceId1.setFax("fax");
        serviceId1.setPhone("phone");
        serviceId1.setEmail("email");
        serviceId1.setAddress("address");
        utilitiesService1.setServiceId(serviceId1);
        utilitiesSubcategory.setUtilitiesServiceList(Arrays.asList(utilitiesService1));
        when(serviceServiceImplUnderTest.utilitiesSubcategoryRepository.getById(0L)).thenReturn(utilitiesSubcategory);

        // Configure UtilitiesServiceRepository.save(...).
        final UtilitiesService utilitiesService2 = new UtilitiesService();
        final Service serviceId2 = new Service();
        serviceId2.setServiceId(0L);
        serviceId2.setServiceName("serviceName");
        serviceId2.setFax("fax");
        serviceId2.setPhone("phone");
        serviceId2.setEmail("email");
        serviceId2.setAddress("address");
        serviceId2.setCity("city");
        serviceId2.setLink("link");
        serviceId2.setStatus(0);
        serviceId2.setTaxCode("taxCode");
        serviceId2.setDateRegister(LocalDate.of(2020, 1, 1));
        serviceId2.setIsActive(false);
        serviceId2.setIsBlock(false);
        final ServiceCategory serviceCategoryId2 = new ServiceCategory();
        serviceCategoryId2.setServiceCategoryId(0L);
        serviceId2.setServiceCategoryId(serviceCategoryId2);
        final Partner partnerId2 = new Partner();
        partnerId2.setEmail("email");
        serviceId2.setPartnerId(partnerId2);
        utilitiesService2.setServiceId(serviceId2);
        final UtilitiesSubcategory utilitiesSubcategoryId1 = new UtilitiesSubcategory();
        utilitiesSubcategoryId1.setUtilitiesSubcategoryId(0L);
        final UtilitiesCategory utilitiesCategoryId2 = new UtilitiesCategory();
        utilitiesCategoryId2.setUtilitiesCategoryId(0L);
        utilitiesSubcategoryId1.setUtilitiesCategoryId(utilitiesCategoryId2);
        utilitiesService2.setUtilitiesSubcategoryId(utilitiesSubcategoryId1);
        when(serviceServiceImplUnderTest.utilitiesServiceRepository.save(any(UtilitiesService.class)))
                .thenReturn(utilitiesService2);

        // Configure AccommodationRepository.getByServiceId(...).
        final Accommodation accommodation = new Accommodation();
        accommodation.setAccommodationId(0L);
        accommodation.setAccommodationType("accommodationType");
        accommodation.setRate(0.0f);
        accommodation.setNumberFloors(0);
        accommodation.setDescription("description");
        final Service serviceId3 = new Service();
        serviceId3.setServiceId(0L);
        serviceId3.setServiceName("serviceName");
        serviceId3.setFax("fax");
        serviceId3.setPhone("phone");
        serviceId3.setEmail("email");
        serviceId3.setAddress("address");
        serviceId3.setCity("city");
        serviceId3.setLink("link");
        serviceId3.setStatus(0);
        serviceId3.setTaxCode("taxCode");
        serviceId3.setDateRegister(LocalDate.of(2020, 1, 1));
        serviceId3.setIsActive(false);
        serviceId3.setIsBlock(false);
        final ServiceCategory serviceCategoryId3 = new ServiceCategory();
        serviceCategoryId3.setServiceCategoryId(0L);
        serviceId3.setServiceCategoryId(serviceCategoryId3);
        final Partner partnerId3 = new Partner();
        partnerId3.setEmail("email");
        serviceId3.setPartnerId(partnerId3);
        accommodation.setServiceId(serviceId3);
        when(serviceServiceImplUnderTest.accommodationRepository.getByServiceId(0L)).thenReturn(accommodation);

        when(serviceServiceImplUnderTest.roomRepository.getListRoomByAccommodationId(0L))
                .thenReturn(Collections.emptyList());

        // Configure RoomRepository.save(...).
        final Room room = new Room();
        room.setRoomName("roomName");
        room.setRoomType("roomType");
        room.setArea(0.0f);
        room.setNumberRooms(0);
        room.setNumberOfPeople(0);
        room.setDailyPrice(0.0f);
        room.setHolidayPrice(0.0f);
        room.setDescription("description");
        room.setBedType("bedType");
        final Accommodation accommodationId = new Accommodation();
        accommodationId.setAccommodationId(0L);
        accommodationId.setAccommodationType("accommodationType");
        accommodationId.setRate(0.0f);
        accommodationId.setNumberFloors(0);
        accommodationId.setDescription("description");
        final Service serviceId4 = new Service();
        serviceId4.setServiceId(0L);
        serviceId4.setServiceName("serviceName");
        serviceId4.setFax("fax");
        serviceId4.setPhone("phone");
        serviceId4.setEmail("email");
        serviceId4.setAddress("address");
        serviceId4.setCity("city");
        serviceId4.setLink("link");
        serviceId4.setStatus(0);
        serviceId4.setTaxCode("taxCode");
        serviceId4.setDateRegister(LocalDate.of(2020, 1, 1));
        serviceId4.setIsActive(false);
        serviceId4.setIsBlock(false);
        final ServiceCategory serviceCategoryId4 = new ServiceCategory();
        serviceCategoryId4.setServiceCategoryId(0L);
        serviceId4.setServiceCategoryId(serviceCategoryId4);
        final Partner partnerId4 = new Partner();
        partnerId4.setEmail("email");
        serviceId4.setPartnerId(partnerId4);
        accommodationId.setServiceId(serviceId4);
        room.setAccommodationId(accommodationId);
        when(serviceServiceImplUnderTest.roomRepository.save(any(Room.class))).thenReturn(room);

        // Configure UtilitiesSubcategoryRepository.findByUtilitiesSubcategoryId(...).
        final UtilitiesSubcategory utilitiesSubcategory1 = new UtilitiesSubcategory();
        utilitiesSubcategory1.setUtilitiesSubcategoryId(0L);
        utilitiesSubcategory1.setUtilitiesSubcategoryName("utilitiesSubcategoryName");
        final UtilitiesCategory utilitiesCategoryId3 = new UtilitiesCategory();
        utilitiesCategoryId3.setUtilitiesCategoryId(0L);
        utilitiesCategoryId3.setUtilitiesCategoryName("utilitiesCategoryName");
        utilitiesCategoryId3.setUtilitiesSubcategoryList(Arrays.asList(new UtilitiesSubcategory()));
        utilitiesSubcategory1.setUtilitiesCategoryId(utilitiesCategoryId3);
        final UtilitiesService utilitiesService3 = new UtilitiesService();
        utilitiesService3.setUtilitiesServiceId(0L);
        final Service serviceId5 = new Service();
        serviceId5.setServiceId(0L);
        serviceId5.setServiceName("serviceName");
        serviceId5.setFax("fax");
        serviceId5.setPhone("phone");
        serviceId5.setEmail("email");
        serviceId5.setAddress("address");
        utilitiesService3.setServiceId(serviceId5);
        utilitiesSubcategory1.setUtilitiesServiceList(Arrays.asList(utilitiesService3));
        when(serviceServiceImplUnderTest.utilitiesSubcategoryRepository.findByUtilitiesSubcategoryId(0L))
                .thenReturn(utilitiesSubcategory1);

        // Run the test
        final AccommodationDTO result = serviceServiceImplUnderTest.updateAccommodation(accommodationDTO, 0L);

        // Verify the results
        verify(serviceServiceImplUnderTest.utilitiesServiceRepository).deleteAll(Arrays.asList(new UtilitiesService()));
        verify(serviceServiceImplUnderTest.utilitiesServiceRepository).save(any(UtilitiesService.class));
        verify(serviceServiceImplUnderTest.roomRepository).deleteAll(Arrays.asList(new Room()));
        verify(serviceServiceImplUnderTest.roomRepository).save(any(Room.class));
    }

    @Test
    void testUpdateAccommodation_ThrowsHandlerException() {
        // Setup
        final AccommodationDTO accommodationDTO = new AccommodationDTO(
                new ServiceDTO(0L, "serviceName", "fax", "phone", "email", "address", "city", "link", 0, "taxCode",
                        false, false, 0L, "typeOfServiceCategory", "email"), "accommodationType", 0.0f, 0,
                "description",
                Arrays.asList(new RoomDTO("roomName", "roomType", 0.0f, 0, 0, 0.0f, 0.0f, "description", "bedType")),
                Arrays.asList(new UtilitiesServiceDTO(0L, 0L)));

        // Configure ServiceRepository.getById(...).
        final Service service = new Service();
        service.setServiceId(0L);
        service.setServiceName("serviceName");
        service.setFax("fax");
        service.setPhone("phone");
        service.setEmail("email");
        service.setAddress("address");
        service.setCity("city");
        service.setLink("link");
        service.setStatus(0);
        service.setTaxCode("taxCode");
        service.setDateRegister(LocalDate.of(2020, 1, 1));
        service.setIsActive(false);
        service.setIsBlock(false);
        final ServiceCategory serviceCategoryId = new ServiceCategory();
        serviceCategoryId.setServiceCategoryId(0L);
        service.setServiceCategoryId(serviceCategoryId);
        final Partner partnerId = new Partner();
        partnerId.setEmail("email");
        service.setPartnerId(partnerId);
        when(serviceServiceImplUnderTest.serviceRepository.getById(0L)).thenReturn(service);

        when(serviceServiceImplUnderTest.serviceRepository.existsAllByServiceName("serviceName")).thenReturn(false);

        // Configure UtilitiesServiceRepository.getListUtilitiesServiceByServiceId(...).
        final UtilitiesService utilitiesService = new UtilitiesService();
        final Service serviceId = new Service();
        serviceId.setServiceId(0L);
        serviceId.setServiceName("serviceName");
        serviceId.setFax("fax");
        serviceId.setPhone("phone");
        serviceId.setEmail("email");
        serviceId.setAddress("address");
        serviceId.setCity("city");
        serviceId.setLink("link");
        serviceId.setStatus(0);
        serviceId.setTaxCode("taxCode");
        serviceId.setDateRegister(LocalDate.of(2020, 1, 1));
        serviceId.setIsActive(false);
        serviceId.setIsBlock(false);
        final ServiceCategory serviceCategoryId1 = new ServiceCategory();
        serviceCategoryId1.setServiceCategoryId(0L);
        serviceId.setServiceCategoryId(serviceCategoryId1);
        final Partner partnerId1 = new Partner();
        partnerId1.setEmail("email");
        serviceId.setPartnerId(partnerId1);
        utilitiesService.setServiceId(serviceId);
        final UtilitiesSubcategory utilitiesSubcategoryId = new UtilitiesSubcategory();
        utilitiesSubcategoryId.setUtilitiesSubcategoryId(0L);
        final UtilitiesCategory utilitiesCategoryId = new UtilitiesCategory();
        utilitiesCategoryId.setUtilitiesCategoryId(0L);
        utilitiesSubcategoryId.setUtilitiesCategoryId(utilitiesCategoryId);
        utilitiesService.setUtilitiesSubcategoryId(utilitiesSubcategoryId);
        final List<UtilitiesService> utilitiesServiceList = Arrays.asList(utilitiesService);
        when(serviceServiceImplUnderTest.utilitiesServiceRepository.getListUtilitiesServiceByServiceId(0L))
                .thenReturn(utilitiesServiceList);

        // Configure UtilitiesSubcategoryRepository.getById(...).
        final UtilitiesSubcategory utilitiesSubcategory = new UtilitiesSubcategory();
        utilitiesSubcategory.setUtilitiesSubcategoryId(0L);
        utilitiesSubcategory.setUtilitiesSubcategoryName("utilitiesSubcategoryName");
        final UtilitiesCategory utilitiesCategoryId1 = new UtilitiesCategory();
        utilitiesCategoryId1.setUtilitiesCategoryId(0L);
        utilitiesCategoryId1.setUtilitiesCategoryName("utilitiesCategoryName");
        utilitiesCategoryId1.setUtilitiesSubcategoryList(Arrays.asList(new UtilitiesSubcategory()));
        utilitiesSubcategory.setUtilitiesCategoryId(utilitiesCategoryId1);
        final UtilitiesService utilitiesService1 = new UtilitiesService();
        utilitiesService1.setUtilitiesServiceId(0L);
        final Service serviceId1 = new Service();
        serviceId1.setServiceId(0L);
        serviceId1.setServiceName("serviceName");
        serviceId1.setFax("fax");
        serviceId1.setPhone("phone");
        serviceId1.setEmail("email");
        serviceId1.setAddress("address");
        utilitiesService1.setServiceId(serviceId1);
        utilitiesSubcategory.setUtilitiesServiceList(Arrays.asList(utilitiesService1));
        when(serviceServiceImplUnderTest.utilitiesSubcategoryRepository.getById(0L)).thenReturn(utilitiesSubcategory);

        // Configure UtilitiesServiceRepository.save(...).
        final UtilitiesService utilitiesService2 = new UtilitiesService();
        final Service serviceId2 = new Service();
        serviceId2.setServiceId(0L);
        serviceId2.setServiceName("serviceName");
        serviceId2.setFax("fax");
        serviceId2.setPhone("phone");
        serviceId2.setEmail("email");
        serviceId2.setAddress("address");
        serviceId2.setCity("city");
        serviceId2.setLink("link");
        serviceId2.setStatus(0);
        serviceId2.setTaxCode("taxCode");
        serviceId2.setDateRegister(LocalDate.of(2020, 1, 1));
        serviceId2.setIsActive(false);
        serviceId2.setIsBlock(false);
        final ServiceCategory serviceCategoryId2 = new ServiceCategory();
        serviceCategoryId2.setServiceCategoryId(0L);
        serviceId2.setServiceCategoryId(serviceCategoryId2);
        final Partner partnerId2 = new Partner();
        partnerId2.setEmail("email");
        serviceId2.setPartnerId(partnerId2);
        utilitiesService2.setServiceId(serviceId2);
        final UtilitiesSubcategory utilitiesSubcategoryId1 = new UtilitiesSubcategory();
        utilitiesSubcategoryId1.setUtilitiesSubcategoryId(0L);
        final UtilitiesCategory utilitiesCategoryId2 = new UtilitiesCategory();
        utilitiesCategoryId2.setUtilitiesCategoryId(0L);
        utilitiesSubcategoryId1.setUtilitiesCategoryId(utilitiesCategoryId2);
        utilitiesService2.setUtilitiesSubcategoryId(utilitiesSubcategoryId1);
        when(serviceServiceImplUnderTest.utilitiesServiceRepository.save(any(UtilitiesService.class)))
                .thenReturn(utilitiesService2);

        // Configure AccommodationRepository.getByServiceId(...).
        final Accommodation accommodation = new Accommodation();
        accommodation.setAccommodationId(0L);
        accommodation.setAccommodationType("accommodationType");
        accommodation.setRate(0.0f);
        accommodation.setNumberFloors(0);
        accommodation.setDescription("description");
        final Service serviceId3 = new Service();
        serviceId3.setServiceId(0L);
        serviceId3.setServiceName("serviceName");
        serviceId3.setFax("fax");
        serviceId3.setPhone("phone");
        serviceId3.setEmail("email");
        serviceId3.setAddress("address");
        serviceId3.setCity("city");
        serviceId3.setLink("link");
        serviceId3.setStatus(0);
        serviceId3.setTaxCode("taxCode");
        serviceId3.setDateRegister(LocalDate.of(2020, 1, 1));
        serviceId3.setIsActive(false);
        serviceId3.setIsBlock(false);
        final ServiceCategory serviceCategoryId3 = new ServiceCategory();
        serviceCategoryId3.setServiceCategoryId(0L);
        serviceId3.setServiceCategoryId(serviceCategoryId3);
        final Partner partnerId3 = new Partner();
        partnerId3.setEmail("email");
        serviceId3.setPartnerId(partnerId3);
        accommodation.setServiceId(serviceId3);
        when(serviceServiceImplUnderTest.accommodationRepository.getByServiceId(0L)).thenReturn(accommodation);

        // Configure RoomRepository.getListRoomByAccommodationId(...).
        final Room room = new Room();
        room.setRoomName("roomName");
        room.setRoomType("roomType");
        room.setArea(0.0f);
        room.setNumberRooms(0);
        room.setNumberOfPeople(0);
        room.setDailyPrice(0.0f);
        room.setHolidayPrice(0.0f);
        room.setDescription("description");
        room.setBedType("bedType");
        final Accommodation accommodationId = new Accommodation();
        accommodationId.setAccommodationId(0L);
        accommodationId.setAccommodationType("accommodationType");
        accommodationId.setRate(0.0f);
        accommodationId.setNumberFloors(0);
        accommodationId.setDescription("description");
        final Service serviceId4 = new Service();
        serviceId4.setServiceId(0L);
        serviceId4.setServiceName("serviceName");
        serviceId4.setFax("fax");
        serviceId4.setPhone("phone");
        serviceId4.setEmail("email");
        serviceId4.setAddress("address");
        serviceId4.setCity("city");
        serviceId4.setLink("link");
        serviceId4.setStatus(0);
        serviceId4.setTaxCode("taxCode");
        serviceId4.setDateRegister(LocalDate.of(2020, 1, 1));
        serviceId4.setIsActive(false);
        serviceId4.setIsBlock(false);
        final ServiceCategory serviceCategoryId4 = new ServiceCategory();
        serviceCategoryId4.setServiceCategoryId(0L);
        serviceId4.setServiceCategoryId(serviceCategoryId4);
        final Partner partnerId4 = new Partner();
        partnerId4.setEmail("email");
        serviceId4.setPartnerId(partnerId4);
        accommodationId.setServiceId(serviceId4);
        room.setAccommodationId(accommodationId);
        final List<Room> roomList = Arrays.asList(room);
        when(serviceServiceImplUnderTest.roomRepository.getListRoomByAccommodationId(0L)).thenReturn(roomList);

        // Configure RoomRepository.save(...).
        final Room room1 = new Room();
        room1.setRoomName("roomName");
        room1.setRoomType("roomType");
        room1.setArea(0.0f);
        room1.setNumberRooms(0);
        room1.setNumberOfPeople(0);
        room1.setDailyPrice(0.0f);
        room1.setHolidayPrice(0.0f);
        room1.setDescription("description");
        room1.setBedType("bedType");
        final Accommodation accommodationId1 = new Accommodation();
        accommodationId1.setAccommodationId(0L);
        accommodationId1.setAccommodationType("accommodationType");
        accommodationId1.setRate(0.0f);
        accommodationId1.setNumberFloors(0);
        accommodationId1.setDescription("description");
        final Service serviceId5 = new Service();
        serviceId5.setServiceId(0L);
        serviceId5.setServiceName("serviceName");
        serviceId5.setFax("fax");
        serviceId5.setPhone("phone");
        serviceId5.setEmail("email");
        serviceId5.setAddress("address");
        serviceId5.setCity("city");
        serviceId5.setLink("link");
        serviceId5.setStatus(0);
        serviceId5.setTaxCode("taxCode");
        serviceId5.setDateRegister(LocalDate.of(2020, 1, 1));
        serviceId5.setIsActive(false);
        serviceId5.setIsBlock(false);
        final ServiceCategory serviceCategoryId5 = new ServiceCategory();
        serviceCategoryId5.setServiceCategoryId(0L);
        serviceId5.setServiceCategoryId(serviceCategoryId5);
        final Partner partnerId5 = new Partner();
        partnerId5.setEmail("email");
        serviceId5.setPartnerId(partnerId5);
        accommodationId1.setServiceId(serviceId5);
        room1.setAccommodationId(accommodationId1);
        when(serviceServiceImplUnderTest.roomRepository.save(any(Room.class))).thenReturn(room1);

        // Configure UtilitiesSubcategoryRepository.findByUtilitiesSubcategoryId(...).
        final UtilitiesSubcategory utilitiesSubcategory1 = new UtilitiesSubcategory();
        utilitiesSubcategory1.setUtilitiesSubcategoryId(0L);
        utilitiesSubcategory1.setUtilitiesSubcategoryName("utilitiesSubcategoryName");
        final UtilitiesCategory utilitiesCategoryId3 = new UtilitiesCategory();
        utilitiesCategoryId3.setUtilitiesCategoryId(0L);
        utilitiesCategoryId3.setUtilitiesCategoryName("utilitiesCategoryName");
        utilitiesCategoryId3.setUtilitiesSubcategoryList(Arrays.asList(new UtilitiesSubcategory()));
        utilitiesSubcategory1.setUtilitiesCategoryId(utilitiesCategoryId3);
        final UtilitiesService utilitiesService3 = new UtilitiesService();
        utilitiesService3.setUtilitiesServiceId(0L);
        final Service serviceId6 = new Service();
        serviceId6.setServiceId(0L);
        serviceId6.setServiceName("serviceName");
        serviceId6.setFax("fax");
        serviceId6.setPhone("phone");
        serviceId6.setEmail("email");
        serviceId6.setAddress("address");
        utilitiesService3.setServiceId(serviceId6);
        utilitiesSubcategory1.setUtilitiesServiceList(Arrays.asList(utilitiesService3));
        when(serviceServiceImplUnderTest.utilitiesSubcategoryRepository.findByUtilitiesSubcategoryId(0L))
                .thenReturn(utilitiesSubcategory1);

        // Run the test
        assertThatThrownBy(() -> serviceServiceImplUnderTest.updateAccommodation(accommodationDTO, 0L))
                .isInstanceOf(HandlerException.class);
        verify(serviceServiceImplUnderTest.utilitiesServiceRepository).deleteAll(Arrays.asList(new UtilitiesService()));
        verify(serviceServiceImplUnderTest.utilitiesServiceRepository).save(any(UtilitiesService.class));
        verify(serviceServiceImplUnderTest.roomRepository).deleteAll(Arrays.asList(new Room()));
        verify(serviceServiceImplUnderTest.roomRepository).save(any(Room.class));
    }

    @Test
    void testUpdateRestaurant() throws Exception {
        // Setup
        final RestaurantDTO restaurantDTO = new RestaurantDTO(
                new ServiceDTO(0L, "serviceName", "fax", "phone", "email", "address", "city", "link", 0, "taxCode",
                        false, false, 0L, "typeOfServiceCategory", "email"), "restaurantServiceType",
                LocalTime.of(12, 0, 0), LocalTime.of(12, 0, 0), "description", 0.0f,
                Arrays.asList(new UtilitiesServiceDTO(0L, 0L)), Arrays.asList(new TypeCuisineServiceDTO(0L)));

        // Configure ServiceRepository.getById(...).
        final Service service = new Service();
        service.setServiceId(0L);
        service.setServiceName("serviceName");
        service.setFax("fax");
        service.setPhone("phone");
        service.setEmail("email");
        service.setAddress("address");
        service.setCity("city");
        service.setLink("link");
        service.setStatus(0);
        service.setTaxCode("taxCode");
        service.setDateRegister(LocalDate.of(2020, 1, 1));
        service.setIsActive(false);
        service.setIsBlock(false);
        final ServiceCategory serviceCategoryId = new ServiceCategory();
        serviceCategoryId.setServiceCategoryId(0L);
        service.setServiceCategoryId(serviceCategoryId);
        final Partner partnerId = new Partner();
        partnerId.setEmail("email");
        service.setPartnerId(partnerId);
        when(serviceServiceImplUnderTest.serviceRepository.getById(0L)).thenReturn(service);

        when(serviceServiceImplUnderTest.serviceRepository.existsAllByServiceName("serviceName")).thenReturn(false);

        // Configure UtilitiesServiceRepository.getListUtilitiesServiceByServiceId(...).
        final UtilitiesService utilitiesService = new UtilitiesService();
        final Service serviceId = new Service();
        serviceId.setServiceId(0L);
        serviceId.setServiceName("serviceName");
        serviceId.setFax("fax");
        serviceId.setPhone("phone");
        serviceId.setEmail("email");
        serviceId.setAddress("address");
        serviceId.setCity("city");
        serviceId.setLink("link");
        serviceId.setStatus(0);
        serviceId.setTaxCode("taxCode");
        serviceId.setDateRegister(LocalDate.of(2020, 1, 1));
        serviceId.setIsActive(false);
        serviceId.setIsBlock(false);
        final ServiceCategory serviceCategoryId1 = new ServiceCategory();
        serviceCategoryId1.setServiceCategoryId(0L);
        serviceId.setServiceCategoryId(serviceCategoryId1);
        final Partner partnerId1 = new Partner();
        partnerId1.setEmail("email");
        serviceId.setPartnerId(partnerId1);
        utilitiesService.setServiceId(serviceId);
        final UtilitiesSubcategory utilitiesSubcategoryId = new UtilitiesSubcategory();
        utilitiesSubcategoryId.setUtilitiesSubcategoryId(0L);
        final UtilitiesCategory utilitiesCategoryId = new UtilitiesCategory();
        utilitiesCategoryId.setUtilitiesCategoryId(0L);
        utilitiesSubcategoryId.setUtilitiesCategoryId(utilitiesCategoryId);
        utilitiesService.setUtilitiesSubcategoryId(utilitiesSubcategoryId);
        final List<UtilitiesService> utilitiesServiceList = Arrays.asList(utilitiesService);
        when(serviceServiceImplUnderTest.utilitiesServiceRepository.getListUtilitiesServiceByServiceId(0L))
                .thenReturn(utilitiesServiceList);

        // Configure UtilitiesSubcategoryRepository.getById(...).
        final UtilitiesSubcategory utilitiesSubcategory = new UtilitiesSubcategory();
        utilitiesSubcategory.setUtilitiesSubcategoryId(0L);
        utilitiesSubcategory.setUtilitiesSubcategoryName("utilitiesSubcategoryName");
        final UtilitiesCategory utilitiesCategoryId1 = new UtilitiesCategory();
        utilitiesCategoryId1.setUtilitiesCategoryId(0L);
        utilitiesCategoryId1.setUtilitiesCategoryName("utilitiesCategoryName");
        utilitiesCategoryId1.setUtilitiesSubcategoryList(Arrays.asList(new UtilitiesSubcategory()));
        utilitiesSubcategory.setUtilitiesCategoryId(utilitiesCategoryId1);
        final UtilitiesService utilitiesService1 = new UtilitiesService();
        utilitiesService1.setUtilitiesServiceId(0L);
        final Service serviceId1 = new Service();
        serviceId1.setServiceId(0L);
        serviceId1.setServiceName("serviceName");
        serviceId1.setFax("fax");
        serviceId1.setPhone("phone");
        serviceId1.setEmail("email");
        serviceId1.setAddress("address");
        utilitiesService1.setServiceId(serviceId1);
        utilitiesSubcategory.setUtilitiesServiceList(Arrays.asList(utilitiesService1));
        when(serviceServiceImplUnderTest.utilitiesSubcategoryRepository.getById(0L)).thenReturn(utilitiesSubcategory);

        // Configure UtilitiesServiceRepository.save(...).
        final UtilitiesService utilitiesService2 = new UtilitiesService();
        final Service serviceId2 = new Service();
        serviceId2.setServiceId(0L);
        serviceId2.setServiceName("serviceName");
        serviceId2.setFax("fax");
        serviceId2.setPhone("phone");
        serviceId2.setEmail("email");
        serviceId2.setAddress("address");
        serviceId2.setCity("city");
        serviceId2.setLink("link");
        serviceId2.setStatus(0);
        serviceId2.setTaxCode("taxCode");
        serviceId2.setDateRegister(LocalDate.of(2020, 1, 1));
        serviceId2.setIsActive(false);
        serviceId2.setIsBlock(false);
        final ServiceCategory serviceCategoryId2 = new ServiceCategory();
        serviceCategoryId2.setServiceCategoryId(0L);
        serviceId2.setServiceCategoryId(serviceCategoryId2);
        final Partner partnerId2 = new Partner();
        partnerId2.setEmail("email");
        serviceId2.setPartnerId(partnerId2);
        utilitiesService2.setServiceId(serviceId2);
        final UtilitiesSubcategory utilitiesSubcategoryId1 = new UtilitiesSubcategory();
        utilitiesSubcategoryId1.setUtilitiesSubcategoryId(0L);
        final UtilitiesCategory utilitiesCategoryId2 = new UtilitiesCategory();
        utilitiesCategoryId2.setUtilitiesCategoryId(0L);
        utilitiesSubcategoryId1.setUtilitiesCategoryId(utilitiesCategoryId2);
        utilitiesService2.setUtilitiesSubcategoryId(utilitiesSubcategoryId1);
        when(serviceServiceImplUnderTest.utilitiesServiceRepository.save(any(UtilitiesService.class)))
                .thenReturn(utilitiesService2);

        // Configure RestaurantRepository.getRestaurantByServiceId(...).
        final Restaurant restaurant = new Restaurant();
        restaurant.setRestaurantId(0L);
        restaurant.setRestaurantServiceType("restaurantServiceType");
        restaurant.setTimeOpen(LocalTime.of(12, 0, 0));
        restaurant.setTimeClose(LocalTime.of(12, 0, 0));
        restaurant.setDescription("description");
        restaurant.setRate(0.0f);
        final Service serviceId3 = new Service();
        serviceId3.setServiceId(0L);
        serviceId3.setServiceName("serviceName");
        serviceId3.setFax("fax");
        serviceId3.setPhone("phone");
        serviceId3.setEmail("email");
        serviceId3.setAddress("address");
        serviceId3.setCity("city");
        serviceId3.setLink("link");
        serviceId3.setStatus(0);
        serviceId3.setTaxCode("taxCode");
        serviceId3.setDateRegister(LocalDate.of(2020, 1, 1));
        serviceId3.setIsActive(false);
        serviceId3.setIsBlock(false);
        final ServiceCategory serviceCategoryId3 = new ServiceCategory();
        serviceCategoryId3.setServiceCategoryId(0L);
        serviceId3.setServiceCategoryId(serviceCategoryId3);
        final Partner partnerId3 = new Partner();
        partnerId3.setEmail("email");
        serviceId3.setPartnerId(partnerId3);
        restaurant.setServiceId(serviceId3);
        when(serviceServiceImplUnderTest.restaurantRepository.getRestaurantByServiceId(0L)).thenReturn(restaurant);

        // Configure RestaurantRepository.save(...).
        final Restaurant restaurant1 = new Restaurant();
        restaurant1.setRestaurantId(0L);
        restaurant1.setRestaurantServiceType("restaurantServiceType");
        restaurant1.setTimeOpen(LocalTime.of(12, 0, 0));
        restaurant1.setTimeClose(LocalTime.of(12, 0, 0));
        restaurant1.setDescription("description");
        restaurant1.setRate(0.0f);
        final Service serviceId4 = new Service();
        serviceId4.setServiceId(0L);
        serviceId4.setServiceName("serviceName");
        serviceId4.setFax("fax");
        serviceId4.setPhone("phone");
        serviceId4.setEmail("email");
        serviceId4.setAddress("address");
        serviceId4.setCity("city");
        serviceId4.setLink("link");
        serviceId4.setStatus(0);
        serviceId4.setTaxCode("taxCode");
        serviceId4.setDateRegister(LocalDate.of(2020, 1, 1));
        serviceId4.setIsActive(false);
        serviceId4.setIsBlock(false);
        final ServiceCategory serviceCategoryId4 = new ServiceCategory();
        serviceCategoryId4.setServiceCategoryId(0L);
        serviceId4.setServiceCategoryId(serviceCategoryId4);
        final Partner partnerId4 = new Partner();
        partnerId4.setEmail("email");
        serviceId4.setPartnerId(partnerId4);
        restaurant1.setServiceId(serviceId4);
        when(serviceServiceImplUnderTest.restaurantRepository.save(any(Restaurant.class))).thenReturn(restaurant1);

        // Configure TypeOfCuisineServiceRepository.getListTypeCuisineServiceByRestaurantId(...).
        final TypeOfCuisineService typeOfCuisineService = new TypeOfCuisineService();
        final Restaurant restaurantId = new Restaurant();
        restaurantId.setRestaurantId(0L);
        restaurantId.setRestaurantServiceType("restaurantServiceType");
        restaurantId.setTimeOpen(LocalTime.of(12, 0, 0));
        restaurantId.setTimeClose(LocalTime.of(12, 0, 0));
        restaurantId.setDescription("description");
        restaurantId.setRate(0.0f);
        final Service serviceId5 = new Service();
        serviceId5.setServiceId(0L);
        serviceId5.setServiceName("serviceName");
        serviceId5.setFax("fax");
        serviceId5.setPhone("phone");
        serviceId5.setEmail("email");
        serviceId5.setAddress("address");
        serviceId5.setCity("city");
        serviceId5.setLink("link");
        serviceId5.setStatus(0);
        serviceId5.setTaxCode("taxCode");
        serviceId5.setDateRegister(LocalDate.of(2020, 1, 1));
        serviceId5.setIsActive(false);
        serviceId5.setIsBlock(false);
        final ServiceCategory serviceCategoryId5 = new ServiceCategory();
        serviceCategoryId5.setServiceCategoryId(0L);
        serviceId5.setServiceCategoryId(serviceCategoryId5);
        final Partner partnerId5 = new Partner();
        partnerId5.setEmail("email");
        serviceId5.setPartnerId(partnerId5);
        restaurantId.setServiceId(serviceId5);
        typeOfCuisineService.setRestaurantId(restaurantId);
        final TypeOfCuisine typeCuisineId = new TypeOfCuisine();
        typeCuisineId.setTypeCuisineId(0L);
        typeOfCuisineService.setTypeCuisineId(typeCuisineId);
        final List<TypeOfCuisineService> typeOfCuisineServiceList = Arrays.asList(typeOfCuisineService);
        when(serviceServiceImplUnderTest.typeOfCuisineServiceRepository.getListTypeCuisineServiceByRestaurantId(
                0L)).thenReturn(typeOfCuisineServiceList);

        // Configure TypeOfCuisineRepository.getById(...).
        final TypeOfCuisine typeOfCuisine = new TypeOfCuisine();
        typeOfCuisine.setTypeCuisineId(0L);
        typeOfCuisine.setCuisineName("cuisineName");
        final TypeOfCuisineService typeOfCuisineService1 = new TypeOfCuisineService();
        typeOfCuisineService1.setTypeCuisineServiceId(0L);
        final Restaurant restaurantId1 = new Restaurant();
        restaurantId1.setRestaurantId(0L);
        restaurantId1.setRestaurantServiceType("restaurantServiceType");
        restaurantId1.setTimeOpen(LocalTime.of(12, 0, 0));
        restaurantId1.setTimeClose(LocalTime.of(12, 0, 0));
        restaurantId1.setDescription("description");
        restaurantId1.setRate(0.0f);
        final Service serviceId6 = new Service();
        serviceId6.setServiceId(0L);
        serviceId6.setServiceName("serviceName");
        serviceId6.setFax("fax");
        restaurantId1.setServiceId(serviceId6);
        typeOfCuisineService1.setRestaurantId(restaurantId1);
        typeOfCuisine.setTypeOfCuisineServiceList(Arrays.asList(typeOfCuisineService1));
        when(serviceServiceImplUnderTest.typeOfCuisineRepository.getById(0L)).thenReturn(typeOfCuisine);

        // Configure TypeOfCuisineServiceRepository.save(...).
        final TypeOfCuisineService typeOfCuisineService2 = new TypeOfCuisineService();
        final Restaurant restaurantId2 = new Restaurant();
        restaurantId2.setRestaurantId(0L);
        restaurantId2.setRestaurantServiceType("restaurantServiceType");
        restaurantId2.setTimeOpen(LocalTime.of(12, 0, 0));
        restaurantId2.setTimeClose(LocalTime.of(12, 0, 0));
        restaurantId2.setDescription("description");
        restaurantId2.setRate(0.0f);
        final Service serviceId7 = new Service();
        serviceId7.setServiceId(0L);
        serviceId7.setServiceName("serviceName");
        serviceId7.setFax("fax");
        serviceId7.setPhone("phone");
        serviceId7.setEmail("email");
        serviceId7.setAddress("address");
        serviceId7.setCity("city");
        serviceId7.setLink("link");
        serviceId7.setStatus(0);
        serviceId7.setTaxCode("taxCode");
        serviceId7.setDateRegister(LocalDate.of(2020, 1, 1));
        serviceId7.setIsActive(false);
        serviceId7.setIsBlock(false);
        final ServiceCategory serviceCategoryId6 = new ServiceCategory();
        serviceCategoryId6.setServiceCategoryId(0L);
        serviceId7.setServiceCategoryId(serviceCategoryId6);
        final Partner partnerId6 = new Partner();
        partnerId6.setEmail("email");
        serviceId7.setPartnerId(partnerId6);
        restaurantId2.setServiceId(serviceId7);
        typeOfCuisineService2.setRestaurantId(restaurantId2);
        final TypeOfCuisine typeCuisineId1 = new TypeOfCuisine();
        typeCuisineId1.setTypeCuisineId(0L);
        typeOfCuisineService2.setTypeCuisineId(typeCuisineId1);
        when(serviceServiceImplUnderTest.typeOfCuisineServiceRepository.save(
                any(TypeOfCuisineService.class))).thenReturn(typeOfCuisineService2);

        // Configure UtilitiesSubcategoryRepository.findByUtilitiesSubcategoryId(...).
        final UtilitiesSubcategory utilitiesSubcategory1 = new UtilitiesSubcategory();
        utilitiesSubcategory1.setUtilitiesSubcategoryId(0L);
        utilitiesSubcategory1.setUtilitiesSubcategoryName("utilitiesSubcategoryName");
        final UtilitiesCategory utilitiesCategoryId3 = new UtilitiesCategory();
        utilitiesCategoryId3.setUtilitiesCategoryId(0L);
        utilitiesCategoryId3.setUtilitiesCategoryName("utilitiesCategoryName");
        utilitiesCategoryId3.setUtilitiesSubcategoryList(Arrays.asList(new UtilitiesSubcategory()));
        utilitiesSubcategory1.setUtilitiesCategoryId(utilitiesCategoryId3);
        final UtilitiesService utilitiesService3 = new UtilitiesService();
        utilitiesService3.setUtilitiesServiceId(0L);
        final Service serviceId8 = new Service();
        serviceId8.setServiceId(0L);
        serviceId8.setServiceName("serviceName");
        serviceId8.setFax("fax");
        serviceId8.setPhone("phone");
        serviceId8.setEmail("email");
        serviceId8.setAddress("address");
        utilitiesService3.setServiceId(serviceId8);
        utilitiesSubcategory1.setUtilitiesServiceList(Arrays.asList(utilitiesService3));
        when(serviceServiceImplUnderTest.utilitiesSubcategoryRepository.findByUtilitiesSubcategoryId(0L))
                .thenReturn(utilitiesSubcategory1);

        // Run the test
        final RestaurantDTO result = serviceServiceImplUnderTest.updateRestaurant(restaurantDTO, 0L);

        // Verify the results
        verify(serviceServiceImplUnderTest.utilitiesServiceRepository).deleteAll(Arrays.asList(new UtilitiesService()));
        verify(serviceServiceImplUnderTest.utilitiesServiceRepository).save(any(UtilitiesService.class));
        verify(serviceServiceImplUnderTest.restaurantRepository).save(any(Restaurant.class));
        verify(serviceServiceImplUnderTest.typeOfCuisineServiceRepository).deleteAll(
                Arrays.asList(new TypeOfCuisineService()));
        verify(serviceServiceImplUnderTest.typeOfCuisineServiceRepository).save(any(TypeOfCuisineService.class));
    }

    @Test
    void testUpdateRestaurant_UtilitiesServiceRepositoryGetListUtilitiesServiceByServiceIdReturnsNoItems() throws Exception {
        // Setup
        final RestaurantDTO restaurantDTO = new RestaurantDTO(
                new ServiceDTO(0L, "serviceName", "fax", "phone", "email", "address", "city", "link", 0, "taxCode",
                        false, false, 0L, "typeOfServiceCategory", "email"), "restaurantServiceType",
                LocalTime.of(12, 0, 0), LocalTime.of(12, 0, 0), "description", 0.0f,
                Arrays.asList(new UtilitiesServiceDTO(0L, 0L)), Arrays.asList(new TypeCuisineServiceDTO(0L)));

        // Configure ServiceRepository.getById(...).
        final Service service = new Service();
        service.setServiceId(0L);
        service.setServiceName("serviceName");
        service.setFax("fax");
        service.setPhone("phone");
        service.setEmail("email");
        service.setAddress("address");
        service.setCity("city");
        service.setLink("link");
        service.setStatus(0);
        service.setTaxCode("taxCode");
        service.setDateRegister(LocalDate.of(2020, 1, 1));
        service.setIsActive(false);
        service.setIsBlock(false);
        final ServiceCategory serviceCategoryId = new ServiceCategory();
        serviceCategoryId.setServiceCategoryId(0L);
        service.setServiceCategoryId(serviceCategoryId);
        final Partner partnerId = new Partner();
        partnerId.setEmail("email");
        service.setPartnerId(partnerId);
        when(serviceServiceImplUnderTest.serviceRepository.getById(0L)).thenReturn(service);

        when(serviceServiceImplUnderTest.serviceRepository.existsAllByServiceName("serviceName")).thenReturn(false);
        when(serviceServiceImplUnderTest.utilitiesServiceRepository.getListUtilitiesServiceByServiceId(0L))
                .thenReturn(Collections.emptyList());

        // Configure UtilitiesSubcategoryRepository.getById(...).
        final UtilitiesSubcategory utilitiesSubcategory = new UtilitiesSubcategory();
        utilitiesSubcategory.setUtilitiesSubcategoryId(0L);
        utilitiesSubcategory.setUtilitiesSubcategoryName("utilitiesSubcategoryName");
        final UtilitiesCategory utilitiesCategoryId = new UtilitiesCategory();
        utilitiesCategoryId.setUtilitiesCategoryId(0L);
        utilitiesCategoryId.setUtilitiesCategoryName("utilitiesCategoryName");
        utilitiesCategoryId.setUtilitiesSubcategoryList(Arrays.asList(new UtilitiesSubcategory()));
        utilitiesSubcategory.setUtilitiesCategoryId(utilitiesCategoryId);
        final UtilitiesService utilitiesService = new UtilitiesService();
        utilitiesService.setUtilitiesServiceId(0L);
        final Service serviceId = new Service();
        serviceId.setServiceId(0L);
        serviceId.setServiceName("serviceName");
        serviceId.setFax("fax");
        serviceId.setPhone("phone");
        serviceId.setEmail("email");
        serviceId.setAddress("address");
        utilitiesService.setServiceId(serviceId);
        utilitiesSubcategory.setUtilitiesServiceList(Arrays.asList(utilitiesService));
        when(serviceServiceImplUnderTest.utilitiesSubcategoryRepository.getById(0L)).thenReturn(utilitiesSubcategory);

        // Configure UtilitiesServiceRepository.save(...).
        final UtilitiesService utilitiesService1 = new UtilitiesService();
        final Service serviceId1 = new Service();
        serviceId1.setServiceId(0L);
        serviceId1.setServiceName("serviceName");
        serviceId1.setFax("fax");
        serviceId1.setPhone("phone");
        serviceId1.setEmail("email");
        serviceId1.setAddress("address");
        serviceId1.setCity("city");
        serviceId1.setLink("link");
        serviceId1.setStatus(0);
        serviceId1.setTaxCode("taxCode");
        serviceId1.setDateRegister(LocalDate.of(2020, 1, 1));
        serviceId1.setIsActive(false);
        serviceId1.setIsBlock(false);
        final ServiceCategory serviceCategoryId1 = new ServiceCategory();
        serviceCategoryId1.setServiceCategoryId(0L);
        serviceId1.setServiceCategoryId(serviceCategoryId1);
        final Partner partnerId1 = new Partner();
        partnerId1.setEmail("email");
        serviceId1.setPartnerId(partnerId1);
        utilitiesService1.setServiceId(serviceId1);
        final UtilitiesSubcategory utilitiesSubcategoryId = new UtilitiesSubcategory();
        utilitiesSubcategoryId.setUtilitiesSubcategoryId(0L);
        final UtilitiesCategory utilitiesCategoryId1 = new UtilitiesCategory();
        utilitiesCategoryId1.setUtilitiesCategoryId(0L);
        utilitiesSubcategoryId.setUtilitiesCategoryId(utilitiesCategoryId1);
        utilitiesService1.setUtilitiesSubcategoryId(utilitiesSubcategoryId);
        when(serviceServiceImplUnderTest.utilitiesServiceRepository.save(any(UtilitiesService.class)))
                .thenReturn(utilitiesService1);

        // Configure RestaurantRepository.getRestaurantByServiceId(...).
        final Restaurant restaurant = new Restaurant();
        restaurant.setRestaurantId(0L);
        restaurant.setRestaurantServiceType("restaurantServiceType");
        restaurant.setTimeOpen(LocalTime.of(12, 0, 0));
        restaurant.setTimeClose(LocalTime.of(12, 0, 0));
        restaurant.setDescription("description");
        restaurant.setRate(0.0f);
        final Service serviceId2 = new Service();
        serviceId2.setServiceId(0L);
        serviceId2.setServiceName("serviceName");
        serviceId2.setFax("fax");
        serviceId2.setPhone("phone");
        serviceId2.setEmail("email");
        serviceId2.setAddress("address");
        serviceId2.setCity("city");
        serviceId2.setLink("link");
        serviceId2.setStatus(0);
        serviceId2.setTaxCode("taxCode");
        serviceId2.setDateRegister(LocalDate.of(2020, 1, 1));
        serviceId2.setIsActive(false);
        serviceId2.setIsBlock(false);
        final ServiceCategory serviceCategoryId2 = new ServiceCategory();
        serviceCategoryId2.setServiceCategoryId(0L);
        serviceId2.setServiceCategoryId(serviceCategoryId2);
        final Partner partnerId2 = new Partner();
        partnerId2.setEmail("email");
        serviceId2.setPartnerId(partnerId2);
        restaurant.setServiceId(serviceId2);
        when(serviceServiceImplUnderTest.restaurantRepository.getRestaurantByServiceId(0L)).thenReturn(restaurant);

        // Configure RestaurantRepository.save(...).
        final Restaurant restaurant1 = new Restaurant();
        restaurant1.setRestaurantId(0L);
        restaurant1.setRestaurantServiceType("restaurantServiceType");
        restaurant1.setTimeOpen(LocalTime.of(12, 0, 0));
        restaurant1.setTimeClose(LocalTime.of(12, 0, 0));
        restaurant1.setDescription("description");
        restaurant1.setRate(0.0f);
        final Service serviceId3 = new Service();
        serviceId3.setServiceId(0L);
        serviceId3.setServiceName("serviceName");
        serviceId3.setFax("fax");
        serviceId3.setPhone("phone");
        serviceId3.setEmail("email");
        serviceId3.setAddress("address");
        serviceId3.setCity("city");
        serviceId3.setLink("link");
        serviceId3.setStatus(0);
        serviceId3.setTaxCode("taxCode");
        serviceId3.setDateRegister(LocalDate.of(2020, 1, 1));
        serviceId3.setIsActive(false);
        serviceId3.setIsBlock(false);
        final ServiceCategory serviceCategoryId3 = new ServiceCategory();
        serviceCategoryId3.setServiceCategoryId(0L);
        serviceId3.setServiceCategoryId(serviceCategoryId3);
        final Partner partnerId3 = new Partner();
        partnerId3.setEmail("email");
        serviceId3.setPartnerId(partnerId3);
        restaurant1.setServiceId(serviceId3);
        when(serviceServiceImplUnderTest.restaurantRepository.save(any(Restaurant.class))).thenReturn(restaurant1);

        // Configure TypeOfCuisineServiceRepository.getListTypeCuisineServiceByRestaurantId(...).
        final TypeOfCuisineService typeOfCuisineService = new TypeOfCuisineService();
        final Restaurant restaurantId = new Restaurant();
        restaurantId.setRestaurantId(0L);
        restaurantId.setRestaurantServiceType("restaurantServiceType");
        restaurantId.setTimeOpen(LocalTime.of(12, 0, 0));
        restaurantId.setTimeClose(LocalTime.of(12, 0, 0));
        restaurantId.setDescription("description");
        restaurantId.setRate(0.0f);
        final Service serviceId4 = new Service();
        serviceId4.setServiceId(0L);
        serviceId4.setServiceName("serviceName");
        serviceId4.setFax("fax");
        serviceId4.setPhone("phone");
        serviceId4.setEmail("email");
        serviceId4.setAddress("address");
        serviceId4.setCity("city");
        serviceId4.setLink("link");
        serviceId4.setStatus(0);
        serviceId4.setTaxCode("taxCode");
        serviceId4.setDateRegister(LocalDate.of(2020, 1, 1));
        serviceId4.setIsActive(false);
        serviceId4.setIsBlock(false);
        final ServiceCategory serviceCategoryId4 = new ServiceCategory();
        serviceCategoryId4.setServiceCategoryId(0L);
        serviceId4.setServiceCategoryId(serviceCategoryId4);
        final Partner partnerId4 = new Partner();
        partnerId4.setEmail("email");
        serviceId4.setPartnerId(partnerId4);
        restaurantId.setServiceId(serviceId4);
        typeOfCuisineService.setRestaurantId(restaurantId);
        final TypeOfCuisine typeCuisineId = new TypeOfCuisine();
        typeCuisineId.setTypeCuisineId(0L);
        typeOfCuisineService.setTypeCuisineId(typeCuisineId);
        final List<TypeOfCuisineService> typeOfCuisineServiceList = Arrays.asList(typeOfCuisineService);
        when(serviceServiceImplUnderTest.typeOfCuisineServiceRepository.getListTypeCuisineServiceByRestaurantId(
                0L)).thenReturn(typeOfCuisineServiceList);

        // Configure TypeOfCuisineRepository.getById(...).
        final TypeOfCuisine typeOfCuisine = new TypeOfCuisine();
        typeOfCuisine.setTypeCuisineId(0L);
        typeOfCuisine.setCuisineName("cuisineName");
        final TypeOfCuisineService typeOfCuisineService1 = new TypeOfCuisineService();
        typeOfCuisineService1.setTypeCuisineServiceId(0L);
        final Restaurant restaurantId1 = new Restaurant();
        restaurantId1.setRestaurantId(0L);
        restaurantId1.setRestaurantServiceType("restaurantServiceType");
        restaurantId1.setTimeOpen(LocalTime.of(12, 0, 0));
        restaurantId1.setTimeClose(LocalTime.of(12, 0, 0));
        restaurantId1.setDescription("description");
        restaurantId1.setRate(0.0f);
        final Service serviceId5 = new Service();
        serviceId5.setServiceId(0L);
        serviceId5.setServiceName("serviceName");
        serviceId5.setFax("fax");
        restaurantId1.setServiceId(serviceId5);
        typeOfCuisineService1.setRestaurantId(restaurantId1);
        typeOfCuisine.setTypeOfCuisineServiceList(Arrays.asList(typeOfCuisineService1));
        when(serviceServiceImplUnderTest.typeOfCuisineRepository.getById(0L)).thenReturn(typeOfCuisine);

        // Configure TypeOfCuisineServiceRepository.save(...).
        final TypeOfCuisineService typeOfCuisineService2 = new TypeOfCuisineService();
        final Restaurant restaurantId2 = new Restaurant();
        restaurantId2.setRestaurantId(0L);
        restaurantId2.setRestaurantServiceType("restaurantServiceType");
        restaurantId2.setTimeOpen(LocalTime.of(12, 0, 0));
        restaurantId2.setTimeClose(LocalTime.of(12, 0, 0));
        restaurantId2.setDescription("description");
        restaurantId2.setRate(0.0f);
        final Service serviceId6 = new Service();
        serviceId6.setServiceId(0L);
        serviceId6.setServiceName("serviceName");
        serviceId6.setFax("fax");
        serviceId6.setPhone("phone");
        serviceId6.setEmail("email");
        serviceId6.setAddress("address");
        serviceId6.setCity("city");
        serviceId6.setLink("link");
        serviceId6.setStatus(0);
        serviceId6.setTaxCode("taxCode");
        serviceId6.setDateRegister(LocalDate.of(2020, 1, 1));
        serviceId6.setIsActive(false);
        serviceId6.setIsBlock(false);
        final ServiceCategory serviceCategoryId5 = new ServiceCategory();
        serviceCategoryId5.setServiceCategoryId(0L);
        serviceId6.setServiceCategoryId(serviceCategoryId5);
        final Partner partnerId5 = new Partner();
        partnerId5.setEmail("email");
        serviceId6.setPartnerId(partnerId5);
        restaurantId2.setServiceId(serviceId6);
        typeOfCuisineService2.setRestaurantId(restaurantId2);
        final TypeOfCuisine typeCuisineId1 = new TypeOfCuisine();
        typeCuisineId1.setTypeCuisineId(0L);
        typeOfCuisineService2.setTypeCuisineId(typeCuisineId1);
        when(serviceServiceImplUnderTest.typeOfCuisineServiceRepository.save(
                any(TypeOfCuisineService.class))).thenReturn(typeOfCuisineService2);

        // Configure UtilitiesSubcategoryRepository.findByUtilitiesSubcategoryId(...).
        final UtilitiesSubcategory utilitiesSubcategory1 = new UtilitiesSubcategory();
        utilitiesSubcategory1.setUtilitiesSubcategoryId(0L);
        utilitiesSubcategory1.setUtilitiesSubcategoryName("utilitiesSubcategoryName");
        final UtilitiesCategory utilitiesCategoryId2 = new UtilitiesCategory();
        utilitiesCategoryId2.setUtilitiesCategoryId(0L);
        utilitiesCategoryId2.setUtilitiesCategoryName("utilitiesCategoryName");
        utilitiesCategoryId2.setUtilitiesSubcategoryList(Arrays.asList(new UtilitiesSubcategory()));
        utilitiesSubcategory1.setUtilitiesCategoryId(utilitiesCategoryId2);
        final UtilitiesService utilitiesService2 = new UtilitiesService();
        utilitiesService2.setUtilitiesServiceId(0L);
        final Service serviceId7 = new Service();
        serviceId7.setServiceId(0L);
        serviceId7.setServiceName("serviceName");
        serviceId7.setFax("fax");
        serviceId7.setPhone("phone");
        serviceId7.setEmail("email");
        serviceId7.setAddress("address");
        utilitiesService2.setServiceId(serviceId7);
        utilitiesSubcategory1.setUtilitiesServiceList(Arrays.asList(utilitiesService2));
        when(serviceServiceImplUnderTest.utilitiesSubcategoryRepository.findByUtilitiesSubcategoryId(0L))
                .thenReturn(utilitiesSubcategory1);

        // Run the test
        final RestaurantDTO result = serviceServiceImplUnderTest.updateRestaurant(restaurantDTO, 0L);

        // Verify the results
        verify(serviceServiceImplUnderTest.utilitiesServiceRepository).deleteAll(Arrays.asList(new UtilitiesService()));
        verify(serviceServiceImplUnderTest.utilitiesServiceRepository).save(any(UtilitiesService.class));
        verify(serviceServiceImplUnderTest.restaurantRepository).save(any(Restaurant.class));
        verify(serviceServiceImplUnderTest.typeOfCuisineServiceRepository).deleteAll(
                Arrays.asList(new TypeOfCuisineService()));
        verify(serviceServiceImplUnderTest.typeOfCuisineServiceRepository).save(any(TypeOfCuisineService.class));
    }

    @Test
    void testUpdateRestaurant_TypeOfCuisineServiceRepositoryGetListTypeCuisineServiceByRestaurantIdReturnsNoItems() throws Exception {
        // Setup
        final RestaurantDTO restaurantDTO = new RestaurantDTO(
                new ServiceDTO(0L, "serviceName", "fax", "phone", "email", "address", "city", "link", 0, "taxCode",
                        false, false, 0L, "typeOfServiceCategory", "email"), "restaurantServiceType",
                LocalTime.of(12, 0, 0), LocalTime.of(12, 0, 0), "description", 0.0f,
                Arrays.asList(new UtilitiesServiceDTO(0L, 0L)), Arrays.asList(new TypeCuisineServiceDTO(0L)));

        // Configure ServiceRepository.getById(...).
        final Service service = new Service();
        service.setServiceId(0L);
        service.setServiceName("serviceName");
        service.setFax("fax");
        service.setPhone("phone");
        service.setEmail("email");
        service.setAddress("address");
        service.setCity("city");
        service.setLink("link");
        service.setStatus(0);
        service.setTaxCode("taxCode");
        service.setDateRegister(LocalDate.of(2020, 1, 1));
        service.setIsActive(false);
        service.setIsBlock(false);
        final ServiceCategory serviceCategoryId = new ServiceCategory();
        serviceCategoryId.setServiceCategoryId(0L);
        service.setServiceCategoryId(serviceCategoryId);
        final Partner partnerId = new Partner();
        partnerId.setEmail("email");
        service.setPartnerId(partnerId);
        when(serviceServiceImplUnderTest.serviceRepository.getById(0L)).thenReturn(service);

        when(serviceServiceImplUnderTest.serviceRepository.existsAllByServiceName("serviceName")).thenReturn(false);

        // Configure UtilitiesServiceRepository.getListUtilitiesServiceByServiceId(...).
        final UtilitiesService utilitiesService = new UtilitiesService();
        final Service serviceId = new Service();
        serviceId.setServiceId(0L);
        serviceId.setServiceName("serviceName");
        serviceId.setFax("fax");
        serviceId.setPhone("phone");
        serviceId.setEmail("email");
        serviceId.setAddress("address");
        serviceId.setCity("city");
        serviceId.setLink("link");
        serviceId.setStatus(0);
        serviceId.setTaxCode("taxCode");
        serviceId.setDateRegister(LocalDate.of(2020, 1, 1));
        serviceId.setIsActive(false);
        serviceId.setIsBlock(false);
        final ServiceCategory serviceCategoryId1 = new ServiceCategory();
        serviceCategoryId1.setServiceCategoryId(0L);
        serviceId.setServiceCategoryId(serviceCategoryId1);
        final Partner partnerId1 = new Partner();
        partnerId1.setEmail("email");
        serviceId.setPartnerId(partnerId1);
        utilitiesService.setServiceId(serviceId);
        final UtilitiesSubcategory utilitiesSubcategoryId = new UtilitiesSubcategory();
        utilitiesSubcategoryId.setUtilitiesSubcategoryId(0L);
        final UtilitiesCategory utilitiesCategoryId = new UtilitiesCategory();
        utilitiesCategoryId.setUtilitiesCategoryId(0L);
        utilitiesSubcategoryId.setUtilitiesCategoryId(utilitiesCategoryId);
        utilitiesService.setUtilitiesSubcategoryId(utilitiesSubcategoryId);
        final List<UtilitiesService> utilitiesServiceList = Arrays.asList(utilitiesService);
        when(serviceServiceImplUnderTest.utilitiesServiceRepository.getListUtilitiesServiceByServiceId(0L))
                .thenReturn(utilitiesServiceList);

        // Configure UtilitiesSubcategoryRepository.getById(...).
        final UtilitiesSubcategory utilitiesSubcategory = new UtilitiesSubcategory();
        utilitiesSubcategory.setUtilitiesSubcategoryId(0L);
        utilitiesSubcategory.setUtilitiesSubcategoryName("utilitiesSubcategoryName");
        final UtilitiesCategory utilitiesCategoryId1 = new UtilitiesCategory();
        utilitiesCategoryId1.setUtilitiesCategoryId(0L);
        utilitiesCategoryId1.setUtilitiesCategoryName("utilitiesCategoryName");
        utilitiesCategoryId1.setUtilitiesSubcategoryList(Arrays.asList(new UtilitiesSubcategory()));
        utilitiesSubcategory.setUtilitiesCategoryId(utilitiesCategoryId1);
        final UtilitiesService utilitiesService1 = new UtilitiesService();
        utilitiesService1.setUtilitiesServiceId(0L);
        final Service serviceId1 = new Service();
        serviceId1.setServiceId(0L);
        serviceId1.setServiceName("serviceName");
        serviceId1.setFax("fax");
        serviceId1.setPhone("phone");
        serviceId1.setEmail("email");
        serviceId1.setAddress("address");
        utilitiesService1.setServiceId(serviceId1);
        utilitiesSubcategory.setUtilitiesServiceList(Arrays.asList(utilitiesService1));
        when(serviceServiceImplUnderTest.utilitiesSubcategoryRepository.getById(0L)).thenReturn(utilitiesSubcategory);

        // Configure UtilitiesServiceRepository.save(...).
        final UtilitiesService utilitiesService2 = new UtilitiesService();
        final Service serviceId2 = new Service();
        serviceId2.setServiceId(0L);
        serviceId2.setServiceName("serviceName");
        serviceId2.setFax("fax");
        serviceId2.setPhone("phone");
        serviceId2.setEmail("email");
        serviceId2.setAddress("address");
        serviceId2.setCity("city");
        serviceId2.setLink("link");
        serviceId2.setStatus(0);
        serviceId2.setTaxCode("taxCode");
        serviceId2.setDateRegister(LocalDate.of(2020, 1, 1));
        serviceId2.setIsActive(false);
        serviceId2.setIsBlock(false);
        final ServiceCategory serviceCategoryId2 = new ServiceCategory();
        serviceCategoryId2.setServiceCategoryId(0L);
        serviceId2.setServiceCategoryId(serviceCategoryId2);
        final Partner partnerId2 = new Partner();
        partnerId2.setEmail("email");
        serviceId2.setPartnerId(partnerId2);
        utilitiesService2.setServiceId(serviceId2);
        final UtilitiesSubcategory utilitiesSubcategoryId1 = new UtilitiesSubcategory();
        utilitiesSubcategoryId1.setUtilitiesSubcategoryId(0L);
        final UtilitiesCategory utilitiesCategoryId2 = new UtilitiesCategory();
        utilitiesCategoryId2.setUtilitiesCategoryId(0L);
        utilitiesSubcategoryId1.setUtilitiesCategoryId(utilitiesCategoryId2);
        utilitiesService2.setUtilitiesSubcategoryId(utilitiesSubcategoryId1);
        when(serviceServiceImplUnderTest.utilitiesServiceRepository.save(any(UtilitiesService.class)))
                .thenReturn(utilitiesService2);

        // Configure RestaurantRepository.getRestaurantByServiceId(...).
        final Restaurant restaurant = new Restaurant();
        restaurant.setRestaurantId(0L);
        restaurant.setRestaurantServiceType("restaurantServiceType");
        restaurant.setTimeOpen(LocalTime.of(12, 0, 0));
        restaurant.setTimeClose(LocalTime.of(12, 0, 0));
        restaurant.setDescription("description");
        restaurant.setRate(0.0f);
        final Service serviceId3 = new Service();
        serviceId3.setServiceId(0L);
        serviceId3.setServiceName("serviceName");
        serviceId3.setFax("fax");
        serviceId3.setPhone("phone");
        serviceId3.setEmail("email");
        serviceId3.setAddress("address");
        serviceId3.setCity("city");
        serviceId3.setLink("link");
        serviceId3.setStatus(0);
        serviceId3.setTaxCode("taxCode");
        serviceId3.setDateRegister(LocalDate.of(2020, 1, 1));
        serviceId3.setIsActive(false);
        serviceId3.setIsBlock(false);
        final ServiceCategory serviceCategoryId3 = new ServiceCategory();
        serviceCategoryId3.setServiceCategoryId(0L);
        serviceId3.setServiceCategoryId(serviceCategoryId3);
        final Partner partnerId3 = new Partner();
        partnerId3.setEmail("email");
        serviceId3.setPartnerId(partnerId3);
        restaurant.setServiceId(serviceId3);
        when(serviceServiceImplUnderTest.restaurantRepository.getRestaurantByServiceId(0L)).thenReturn(restaurant);

        // Configure RestaurantRepository.save(...).
        final Restaurant restaurant1 = new Restaurant();
        restaurant1.setRestaurantId(0L);
        restaurant1.setRestaurantServiceType("restaurantServiceType");
        restaurant1.setTimeOpen(LocalTime.of(12, 0, 0));
        restaurant1.setTimeClose(LocalTime.of(12, 0, 0));
        restaurant1.setDescription("description");
        restaurant1.setRate(0.0f);
        final Service serviceId4 = new Service();
        serviceId4.setServiceId(0L);
        serviceId4.setServiceName("serviceName");
        serviceId4.setFax("fax");
        serviceId4.setPhone("phone");
        serviceId4.setEmail("email");
        serviceId4.setAddress("address");
        serviceId4.setCity("city");
        serviceId4.setLink("link");
        serviceId4.setStatus(0);
        serviceId4.setTaxCode("taxCode");
        serviceId4.setDateRegister(LocalDate.of(2020, 1, 1));
        serviceId4.setIsActive(false);
        serviceId4.setIsBlock(false);
        final ServiceCategory serviceCategoryId4 = new ServiceCategory();
        serviceCategoryId4.setServiceCategoryId(0L);
        serviceId4.setServiceCategoryId(serviceCategoryId4);
        final Partner partnerId4 = new Partner();
        partnerId4.setEmail("email");
        serviceId4.setPartnerId(partnerId4);
        restaurant1.setServiceId(serviceId4);
        when(serviceServiceImplUnderTest.restaurantRepository.save(any(Restaurant.class))).thenReturn(restaurant1);

        when(serviceServiceImplUnderTest.typeOfCuisineServiceRepository.getListTypeCuisineServiceByRestaurantId(
                0L)).thenReturn(Collections.emptyList());

        // Configure TypeOfCuisineRepository.getById(...).
        final TypeOfCuisine typeOfCuisine = new TypeOfCuisine();
        typeOfCuisine.setTypeCuisineId(0L);
        typeOfCuisine.setCuisineName("cuisineName");
        final TypeOfCuisineService typeOfCuisineService = new TypeOfCuisineService();
        typeOfCuisineService.setTypeCuisineServiceId(0L);
        final Restaurant restaurantId = new Restaurant();
        restaurantId.setRestaurantId(0L);
        restaurantId.setRestaurantServiceType("restaurantServiceType");
        restaurantId.setTimeOpen(LocalTime.of(12, 0, 0));
        restaurantId.setTimeClose(LocalTime.of(12, 0, 0));
        restaurantId.setDescription("description");
        restaurantId.setRate(0.0f);
        final Service serviceId5 = new Service();
        serviceId5.setServiceId(0L);
        serviceId5.setServiceName("serviceName");
        serviceId5.setFax("fax");
        restaurantId.setServiceId(serviceId5);
        typeOfCuisineService.setRestaurantId(restaurantId);
        typeOfCuisine.setTypeOfCuisineServiceList(Arrays.asList(typeOfCuisineService));
        when(serviceServiceImplUnderTest.typeOfCuisineRepository.getById(0L)).thenReturn(typeOfCuisine);

        // Configure TypeOfCuisineServiceRepository.save(...).
        final TypeOfCuisineService typeOfCuisineService1 = new TypeOfCuisineService();
        final Restaurant restaurantId1 = new Restaurant();
        restaurantId1.setRestaurantId(0L);
        restaurantId1.setRestaurantServiceType("restaurantServiceType");
        restaurantId1.setTimeOpen(LocalTime.of(12, 0, 0));
        restaurantId1.setTimeClose(LocalTime.of(12, 0, 0));
        restaurantId1.setDescription("description");
        restaurantId1.setRate(0.0f);
        final Service serviceId6 = new Service();
        serviceId6.setServiceId(0L);
        serviceId6.setServiceName("serviceName");
        serviceId6.setFax("fax");
        serviceId6.setPhone("phone");
        serviceId6.setEmail("email");
        serviceId6.setAddress("address");
        serviceId6.setCity("city");
        serviceId6.setLink("link");
        serviceId6.setStatus(0);
        serviceId6.setTaxCode("taxCode");
        serviceId6.setDateRegister(LocalDate.of(2020, 1, 1));
        serviceId6.setIsActive(false);
        serviceId6.setIsBlock(false);
        final ServiceCategory serviceCategoryId5 = new ServiceCategory();
        serviceCategoryId5.setServiceCategoryId(0L);
        serviceId6.setServiceCategoryId(serviceCategoryId5);
        final Partner partnerId5 = new Partner();
        partnerId5.setEmail("email");
        serviceId6.setPartnerId(partnerId5);
        restaurantId1.setServiceId(serviceId6);
        typeOfCuisineService1.setRestaurantId(restaurantId1);
        final TypeOfCuisine typeCuisineId = new TypeOfCuisine();
        typeCuisineId.setTypeCuisineId(0L);
        typeOfCuisineService1.setTypeCuisineId(typeCuisineId);
        when(serviceServiceImplUnderTest.typeOfCuisineServiceRepository.save(
                any(TypeOfCuisineService.class))).thenReturn(typeOfCuisineService1);

        // Configure UtilitiesSubcategoryRepository.findByUtilitiesSubcategoryId(...).
        final UtilitiesSubcategory utilitiesSubcategory1 = new UtilitiesSubcategory();
        utilitiesSubcategory1.setUtilitiesSubcategoryId(0L);
        utilitiesSubcategory1.setUtilitiesSubcategoryName("utilitiesSubcategoryName");
        final UtilitiesCategory utilitiesCategoryId3 = new UtilitiesCategory();
        utilitiesCategoryId3.setUtilitiesCategoryId(0L);
        utilitiesCategoryId3.setUtilitiesCategoryName("utilitiesCategoryName");
        utilitiesCategoryId3.setUtilitiesSubcategoryList(Arrays.asList(new UtilitiesSubcategory()));
        utilitiesSubcategory1.setUtilitiesCategoryId(utilitiesCategoryId3);
        final UtilitiesService utilitiesService3 = new UtilitiesService();
        utilitiesService3.setUtilitiesServiceId(0L);
        final Service serviceId7 = new Service();
        serviceId7.setServiceId(0L);
        serviceId7.setServiceName("serviceName");
        serviceId7.setFax("fax");
        serviceId7.setPhone("phone");
        serviceId7.setEmail("email");
        serviceId7.setAddress("address");
        utilitiesService3.setServiceId(serviceId7);
        utilitiesSubcategory1.setUtilitiesServiceList(Arrays.asList(utilitiesService3));
        when(serviceServiceImplUnderTest.utilitiesSubcategoryRepository.findByUtilitiesSubcategoryId(0L))
                .thenReturn(utilitiesSubcategory1);

        // Run the test
        final RestaurantDTO result = serviceServiceImplUnderTest.updateRestaurant(restaurantDTO, 0L);

        // Verify the results
        verify(serviceServiceImplUnderTest.utilitiesServiceRepository).deleteAll(Arrays.asList(new UtilitiesService()));
        verify(serviceServiceImplUnderTest.utilitiesServiceRepository).save(any(UtilitiesService.class));
        verify(serviceServiceImplUnderTest.restaurantRepository).save(any(Restaurant.class));
        verify(serviceServiceImplUnderTest.typeOfCuisineServiceRepository).deleteAll(
                Arrays.asList(new TypeOfCuisineService()));
        verify(serviceServiceImplUnderTest.typeOfCuisineServiceRepository).save(any(TypeOfCuisineService.class));
    }

    @Test
    void testUpdateRestaurant_ThrowsHandlerException() {
        // Setup
        final RestaurantDTO restaurantDTO = new RestaurantDTO(
                new ServiceDTO(0L, "serviceName", "fax", "phone", "email", "address", "city", "link", 0, "taxCode",
                        false, false, 0L, "typeOfServiceCategory", "email"), "restaurantServiceType",
                LocalTime.of(12, 0, 0), LocalTime.of(12, 0, 0), "description", 0.0f,
                Arrays.asList(new UtilitiesServiceDTO(0L, 0L)), Arrays.asList(new TypeCuisineServiceDTO(0L)));

        // Configure ServiceRepository.getById(...).
        final Service service = new Service();
        service.setServiceId(0L);
        service.setServiceName("serviceName");
        service.setFax("fax");
        service.setPhone("phone");
        service.setEmail("email");
        service.setAddress("address");
        service.setCity("city");
        service.setLink("link");
        service.setStatus(0);
        service.setTaxCode("taxCode");
        service.setDateRegister(LocalDate.of(2020, 1, 1));
        service.setIsActive(false);
        service.setIsBlock(false);
        final ServiceCategory serviceCategoryId = new ServiceCategory();
        serviceCategoryId.setServiceCategoryId(0L);
        service.setServiceCategoryId(serviceCategoryId);
        final Partner partnerId = new Partner();
        partnerId.setEmail("email");
        service.setPartnerId(partnerId);
        when(serviceServiceImplUnderTest.serviceRepository.getById(0L)).thenReturn(service);

        when(serviceServiceImplUnderTest.serviceRepository.existsAllByServiceName("serviceName")).thenReturn(false);

        // Configure UtilitiesServiceRepository.getListUtilitiesServiceByServiceId(...).
        final UtilitiesService utilitiesService = new UtilitiesService();
        final Service serviceId = new Service();
        serviceId.setServiceId(0L);
        serviceId.setServiceName("serviceName");
        serviceId.setFax("fax");
        serviceId.setPhone("phone");
        serviceId.setEmail("email");
        serviceId.setAddress("address");
        serviceId.setCity("city");
        serviceId.setLink("link");
        serviceId.setStatus(0);
        serviceId.setTaxCode("taxCode");
        serviceId.setDateRegister(LocalDate.of(2020, 1, 1));
        serviceId.setIsActive(false);
        serviceId.setIsBlock(false);
        final ServiceCategory serviceCategoryId1 = new ServiceCategory();
        serviceCategoryId1.setServiceCategoryId(0L);
        serviceId.setServiceCategoryId(serviceCategoryId1);
        final Partner partnerId1 = new Partner();
        partnerId1.setEmail("email");
        serviceId.setPartnerId(partnerId1);
        utilitiesService.setServiceId(serviceId);
        final UtilitiesSubcategory utilitiesSubcategoryId = new UtilitiesSubcategory();
        utilitiesSubcategoryId.setUtilitiesSubcategoryId(0L);
        final UtilitiesCategory utilitiesCategoryId = new UtilitiesCategory();
        utilitiesCategoryId.setUtilitiesCategoryId(0L);
        utilitiesSubcategoryId.setUtilitiesCategoryId(utilitiesCategoryId);
        utilitiesService.setUtilitiesSubcategoryId(utilitiesSubcategoryId);
        final List<UtilitiesService> utilitiesServiceList = Arrays.asList(utilitiesService);
        when(serviceServiceImplUnderTest.utilitiesServiceRepository.getListUtilitiesServiceByServiceId(0L))
                .thenReturn(utilitiesServiceList);

        // Configure UtilitiesSubcategoryRepository.getById(...).
        final UtilitiesSubcategory utilitiesSubcategory = new UtilitiesSubcategory();
        utilitiesSubcategory.setUtilitiesSubcategoryId(0L);
        utilitiesSubcategory.setUtilitiesSubcategoryName("utilitiesSubcategoryName");
        final UtilitiesCategory utilitiesCategoryId1 = new UtilitiesCategory();
        utilitiesCategoryId1.setUtilitiesCategoryId(0L);
        utilitiesCategoryId1.setUtilitiesCategoryName("utilitiesCategoryName");
        utilitiesCategoryId1.setUtilitiesSubcategoryList(Arrays.asList(new UtilitiesSubcategory()));
        utilitiesSubcategory.setUtilitiesCategoryId(utilitiesCategoryId1);
        final UtilitiesService utilitiesService1 = new UtilitiesService();
        utilitiesService1.setUtilitiesServiceId(0L);
        final Service serviceId1 = new Service();
        serviceId1.setServiceId(0L);
        serviceId1.setServiceName("serviceName");
        serviceId1.setFax("fax");
        serviceId1.setPhone("phone");
        serviceId1.setEmail("email");
        serviceId1.setAddress("address");
        utilitiesService1.setServiceId(serviceId1);
        utilitiesSubcategory.setUtilitiesServiceList(Arrays.asList(utilitiesService1));
        when(serviceServiceImplUnderTest.utilitiesSubcategoryRepository.getById(0L)).thenReturn(utilitiesSubcategory);

        // Configure UtilitiesServiceRepository.save(...).
        final UtilitiesService utilitiesService2 = new UtilitiesService();
        final Service serviceId2 = new Service();
        serviceId2.setServiceId(0L);
        serviceId2.setServiceName("serviceName");
        serviceId2.setFax("fax");
        serviceId2.setPhone("phone");
        serviceId2.setEmail("email");
        serviceId2.setAddress("address");
        serviceId2.setCity("city");
        serviceId2.setLink("link");
        serviceId2.setStatus(0);
        serviceId2.setTaxCode("taxCode");
        serviceId2.setDateRegister(LocalDate.of(2020, 1, 1));
        serviceId2.setIsActive(false);
        serviceId2.setIsBlock(false);
        final ServiceCategory serviceCategoryId2 = new ServiceCategory();
        serviceCategoryId2.setServiceCategoryId(0L);
        serviceId2.setServiceCategoryId(serviceCategoryId2);
        final Partner partnerId2 = new Partner();
        partnerId2.setEmail("email");
        serviceId2.setPartnerId(partnerId2);
        utilitiesService2.setServiceId(serviceId2);
        final UtilitiesSubcategory utilitiesSubcategoryId1 = new UtilitiesSubcategory();
        utilitiesSubcategoryId1.setUtilitiesSubcategoryId(0L);
        final UtilitiesCategory utilitiesCategoryId2 = new UtilitiesCategory();
        utilitiesCategoryId2.setUtilitiesCategoryId(0L);
        utilitiesSubcategoryId1.setUtilitiesCategoryId(utilitiesCategoryId2);
        utilitiesService2.setUtilitiesSubcategoryId(utilitiesSubcategoryId1);
        when(serviceServiceImplUnderTest.utilitiesServiceRepository.save(any(UtilitiesService.class)))
                .thenReturn(utilitiesService2);

        // Configure RestaurantRepository.getRestaurantByServiceId(...).
        final Restaurant restaurant = new Restaurant();
        restaurant.setRestaurantId(0L);
        restaurant.setRestaurantServiceType("restaurantServiceType");
        restaurant.setTimeOpen(LocalTime.of(12, 0, 0));
        restaurant.setTimeClose(LocalTime.of(12, 0, 0));
        restaurant.setDescription("description");
        restaurant.setRate(0.0f);
        final Service serviceId3 = new Service();
        serviceId3.setServiceId(0L);
        serviceId3.setServiceName("serviceName");
        serviceId3.setFax("fax");
        serviceId3.setPhone("phone");
        serviceId3.setEmail("email");
        serviceId3.setAddress("address");
        serviceId3.setCity("city");
        serviceId3.setLink("link");
        serviceId3.setStatus(0);
        serviceId3.setTaxCode("taxCode");
        serviceId3.setDateRegister(LocalDate.of(2020, 1, 1));
        serviceId3.setIsActive(false);
        serviceId3.setIsBlock(false);
        final ServiceCategory serviceCategoryId3 = new ServiceCategory();
        serviceCategoryId3.setServiceCategoryId(0L);
        serviceId3.setServiceCategoryId(serviceCategoryId3);
        final Partner partnerId3 = new Partner();
        partnerId3.setEmail("email");
        serviceId3.setPartnerId(partnerId3);
        restaurant.setServiceId(serviceId3);
        when(serviceServiceImplUnderTest.restaurantRepository.getRestaurantByServiceId(0L)).thenReturn(restaurant);

        // Configure RestaurantRepository.save(...).
        final Restaurant restaurant1 = new Restaurant();
        restaurant1.setRestaurantId(0L);
        restaurant1.setRestaurantServiceType("restaurantServiceType");
        restaurant1.setTimeOpen(LocalTime.of(12, 0, 0));
        restaurant1.setTimeClose(LocalTime.of(12, 0, 0));
        restaurant1.setDescription("description");
        restaurant1.setRate(0.0f);
        final Service serviceId4 = new Service();
        serviceId4.setServiceId(0L);
        serviceId4.setServiceName("serviceName");
        serviceId4.setFax("fax");
        serviceId4.setPhone("phone");
        serviceId4.setEmail("email");
        serviceId4.setAddress("address");
        serviceId4.setCity("city");
        serviceId4.setLink("link");
        serviceId4.setStatus(0);
        serviceId4.setTaxCode("taxCode");
        serviceId4.setDateRegister(LocalDate.of(2020, 1, 1));
        serviceId4.setIsActive(false);
        serviceId4.setIsBlock(false);
        final ServiceCategory serviceCategoryId4 = new ServiceCategory();
        serviceCategoryId4.setServiceCategoryId(0L);
        serviceId4.setServiceCategoryId(serviceCategoryId4);
        final Partner partnerId4 = new Partner();
        partnerId4.setEmail("email");
        serviceId4.setPartnerId(partnerId4);
        restaurant1.setServiceId(serviceId4);
        when(serviceServiceImplUnderTest.restaurantRepository.save(any(Restaurant.class))).thenReturn(restaurant1);

        // Configure TypeOfCuisineServiceRepository.getListTypeCuisineServiceByRestaurantId(...).
        final TypeOfCuisineService typeOfCuisineService = new TypeOfCuisineService();
        final Restaurant restaurantId = new Restaurant();
        restaurantId.setRestaurantId(0L);
        restaurantId.setRestaurantServiceType("restaurantServiceType");
        restaurantId.setTimeOpen(LocalTime.of(12, 0, 0));
        restaurantId.setTimeClose(LocalTime.of(12, 0, 0));
        restaurantId.setDescription("description");
        restaurantId.setRate(0.0f);
        final Service serviceId5 = new Service();
        serviceId5.setServiceId(0L);
        serviceId5.setServiceName("serviceName");
        serviceId5.setFax("fax");
        serviceId5.setPhone("phone");
        serviceId5.setEmail("email");
        serviceId5.setAddress("address");
        serviceId5.setCity("city");
        serviceId5.setLink("link");
        serviceId5.setStatus(0);
        serviceId5.setTaxCode("taxCode");
        serviceId5.setDateRegister(LocalDate.of(2020, 1, 1));
        serviceId5.setIsActive(false);
        serviceId5.setIsBlock(false);
        final ServiceCategory serviceCategoryId5 = new ServiceCategory();
        serviceCategoryId5.setServiceCategoryId(0L);
        serviceId5.setServiceCategoryId(serviceCategoryId5);
        final Partner partnerId5 = new Partner();
        partnerId5.setEmail("email");
        serviceId5.setPartnerId(partnerId5);
        restaurantId.setServiceId(serviceId5);
        typeOfCuisineService.setRestaurantId(restaurantId);
        final TypeOfCuisine typeCuisineId = new TypeOfCuisine();
        typeCuisineId.setTypeCuisineId(0L);
        typeOfCuisineService.setTypeCuisineId(typeCuisineId);
        final List<TypeOfCuisineService> typeOfCuisineServiceList = Arrays.asList(typeOfCuisineService);
        when(serviceServiceImplUnderTest.typeOfCuisineServiceRepository.getListTypeCuisineServiceByRestaurantId(
                0L)).thenReturn(typeOfCuisineServiceList);

        // Configure TypeOfCuisineRepository.getById(...).
        final TypeOfCuisine typeOfCuisine = new TypeOfCuisine();
        typeOfCuisine.setTypeCuisineId(0L);
        typeOfCuisine.setCuisineName("cuisineName");
        final TypeOfCuisineService typeOfCuisineService1 = new TypeOfCuisineService();
        typeOfCuisineService1.setTypeCuisineServiceId(0L);
        final Restaurant restaurantId1 = new Restaurant();
        restaurantId1.setRestaurantId(0L);
        restaurantId1.setRestaurantServiceType("restaurantServiceType");
        restaurantId1.setTimeOpen(LocalTime.of(12, 0, 0));
        restaurantId1.setTimeClose(LocalTime.of(12, 0, 0));
        restaurantId1.setDescription("description");
        restaurantId1.setRate(0.0f);
        final Service serviceId6 = new Service();
        serviceId6.setServiceId(0L);
        serviceId6.setServiceName("serviceName");
        serviceId6.setFax("fax");
        restaurantId1.setServiceId(serviceId6);
        typeOfCuisineService1.setRestaurantId(restaurantId1);
        typeOfCuisine.setTypeOfCuisineServiceList(Arrays.asList(typeOfCuisineService1));
        when(serviceServiceImplUnderTest.typeOfCuisineRepository.getById(0L)).thenReturn(typeOfCuisine);

        // Configure TypeOfCuisineServiceRepository.save(...).
        final TypeOfCuisineService typeOfCuisineService2 = new TypeOfCuisineService();
        final Restaurant restaurantId2 = new Restaurant();
        restaurantId2.setRestaurantId(0L);
        restaurantId2.setRestaurantServiceType("restaurantServiceType");
        restaurantId2.setTimeOpen(LocalTime.of(12, 0, 0));
        restaurantId2.setTimeClose(LocalTime.of(12, 0, 0));
        restaurantId2.setDescription("description");
        restaurantId2.setRate(0.0f);
        final Service serviceId7 = new Service();
        serviceId7.setServiceId(0L);
        serviceId7.setServiceName("serviceName");
        serviceId7.setFax("fax");
        serviceId7.setPhone("phone");
        serviceId7.setEmail("email");
        serviceId7.setAddress("address");
        serviceId7.setCity("city");
        serviceId7.setLink("link");
        serviceId7.setStatus(0);
        serviceId7.setTaxCode("taxCode");
        serviceId7.setDateRegister(LocalDate.of(2020, 1, 1));
        serviceId7.setIsActive(false);
        serviceId7.setIsBlock(false);
        final ServiceCategory serviceCategoryId6 = new ServiceCategory();
        serviceCategoryId6.setServiceCategoryId(0L);
        serviceId7.setServiceCategoryId(serviceCategoryId6);
        final Partner partnerId6 = new Partner();
        partnerId6.setEmail("email");
        serviceId7.setPartnerId(partnerId6);
        restaurantId2.setServiceId(serviceId7);
        typeOfCuisineService2.setRestaurantId(restaurantId2);
        final TypeOfCuisine typeCuisineId1 = new TypeOfCuisine();
        typeCuisineId1.setTypeCuisineId(0L);
        typeOfCuisineService2.setTypeCuisineId(typeCuisineId1);
        when(serviceServiceImplUnderTest.typeOfCuisineServiceRepository.save(
                any(TypeOfCuisineService.class))).thenReturn(typeOfCuisineService2);

        // Configure UtilitiesSubcategoryRepository.findByUtilitiesSubcategoryId(...).
        final UtilitiesSubcategory utilitiesSubcategory1 = new UtilitiesSubcategory();
        utilitiesSubcategory1.setUtilitiesSubcategoryId(0L);
        utilitiesSubcategory1.setUtilitiesSubcategoryName("utilitiesSubcategoryName");
        final UtilitiesCategory utilitiesCategoryId3 = new UtilitiesCategory();
        utilitiesCategoryId3.setUtilitiesCategoryId(0L);
        utilitiesCategoryId3.setUtilitiesCategoryName("utilitiesCategoryName");
        utilitiesCategoryId3.setUtilitiesSubcategoryList(Arrays.asList(new UtilitiesSubcategory()));
        utilitiesSubcategory1.setUtilitiesCategoryId(utilitiesCategoryId3);
        final UtilitiesService utilitiesService3 = new UtilitiesService();
        utilitiesService3.setUtilitiesServiceId(0L);
        final Service serviceId8 = new Service();
        serviceId8.setServiceId(0L);
        serviceId8.setServiceName("serviceName");
        serviceId8.setFax("fax");
        serviceId8.setPhone("phone");
        serviceId8.setEmail("email");
        serviceId8.setAddress("address");
        utilitiesService3.setServiceId(serviceId8);
        utilitiesSubcategory1.setUtilitiesServiceList(Arrays.asList(utilitiesService3));
        when(serviceServiceImplUnderTest.utilitiesSubcategoryRepository.findByUtilitiesSubcategoryId(0L))
                .thenReturn(utilitiesSubcategory1);

        // Run the test
        assertThatThrownBy(() -> serviceServiceImplUnderTest.updateRestaurant(restaurantDTO, 0L))
                .isInstanceOf(HandlerException.class);
        verify(serviceServiceImplUnderTest.utilitiesServiceRepository).deleteAll(Arrays.asList(new UtilitiesService()));
        verify(serviceServiceImplUnderTest.utilitiesServiceRepository).save(any(UtilitiesService.class));
        verify(serviceServiceImplUnderTest.restaurantRepository).save(any(Restaurant.class));
        verify(serviceServiceImplUnderTest.typeOfCuisineServiceRepository).deleteAll(
                Arrays.asList(new TypeOfCuisineService()));
        verify(serviceServiceImplUnderTest.typeOfCuisineServiceRepository).save(any(TypeOfCuisineService.class));
    }

    @Test
    void testUpdateEntertainment() throws Exception {
        // Setup
        final EntertainmentDTO entertainmentDTO = new EntertainmentDTO(
                new ServiceDTO(0L, "serviceName", "fax", "phone", "email", "address", "city", "link", 0, "taxCode",
                        false, false, 0L, "typeOfServiceCategory", "email"), "entertainmentType", "dowOpen",
                LocalTime.of(12, 0, 0), LocalTime.of(12, 0, 0), 0.0f, 0.0f, "description",
                Arrays.asList(new UtilitiesServiceDTO(0L, 0L)));

        // Configure ServiceRepository.getById(...).
        final Service service = new Service();
        service.setServiceId(0L);
        service.setServiceName("serviceName");
        service.setFax("fax");
        service.setPhone("phone");
        service.setEmail("email");
        service.setAddress("address");
        service.setCity("city");
        service.setLink("link");
        service.setStatus(0);
        service.setTaxCode("taxCode");
        service.setDateRegister(LocalDate.of(2020, 1, 1));
        service.setIsActive(false);
        service.setIsBlock(false);
        final ServiceCategory serviceCategoryId = new ServiceCategory();
        serviceCategoryId.setServiceCategoryId(0L);
        service.setServiceCategoryId(serviceCategoryId);
        final Partner partnerId = new Partner();
        partnerId.setEmail("email");
        service.setPartnerId(partnerId);
        when(serviceServiceImplUnderTest.serviceRepository.getById(0L)).thenReturn(service);

        when(serviceServiceImplUnderTest.serviceRepository.existsAllByServiceName("serviceName")).thenReturn(false);

        // Configure UtilitiesServiceRepository.getListUtilitiesServiceByServiceId(...).
        final UtilitiesService utilitiesService = new UtilitiesService();
        final Service serviceId = new Service();
        serviceId.setServiceId(0L);
        serviceId.setServiceName("serviceName");
        serviceId.setFax("fax");
        serviceId.setPhone("phone");
        serviceId.setEmail("email");
        serviceId.setAddress("address");
        serviceId.setCity("city");
        serviceId.setLink("link");
        serviceId.setStatus(0);
        serviceId.setTaxCode("taxCode");
        serviceId.setDateRegister(LocalDate.of(2020, 1, 1));
        serviceId.setIsActive(false);
        serviceId.setIsBlock(false);
        final ServiceCategory serviceCategoryId1 = new ServiceCategory();
        serviceCategoryId1.setServiceCategoryId(0L);
        serviceId.setServiceCategoryId(serviceCategoryId1);
        final Partner partnerId1 = new Partner();
        partnerId1.setEmail("email");
        serviceId.setPartnerId(partnerId1);
        utilitiesService.setServiceId(serviceId);
        final UtilitiesSubcategory utilitiesSubcategoryId = new UtilitiesSubcategory();
        utilitiesSubcategoryId.setUtilitiesSubcategoryId(0L);
        final UtilitiesCategory utilitiesCategoryId = new UtilitiesCategory();
        utilitiesCategoryId.setUtilitiesCategoryId(0L);
        utilitiesSubcategoryId.setUtilitiesCategoryId(utilitiesCategoryId);
        utilitiesService.setUtilitiesSubcategoryId(utilitiesSubcategoryId);
        final List<UtilitiesService> utilitiesServiceList = Arrays.asList(utilitiesService);
        when(serviceServiceImplUnderTest.utilitiesServiceRepository.getListUtilitiesServiceByServiceId(0L))
                .thenReturn(utilitiesServiceList);

        // Configure UtilitiesSubcategoryRepository.getById(...).
        final UtilitiesSubcategory utilitiesSubcategory = new UtilitiesSubcategory();
        utilitiesSubcategory.setUtilitiesSubcategoryId(0L);
        utilitiesSubcategory.setUtilitiesSubcategoryName("utilitiesSubcategoryName");
        final UtilitiesCategory utilitiesCategoryId1 = new UtilitiesCategory();
        utilitiesCategoryId1.setUtilitiesCategoryId(0L);
        utilitiesCategoryId1.setUtilitiesCategoryName("utilitiesCategoryName");
        utilitiesCategoryId1.setUtilitiesSubcategoryList(Arrays.asList(new UtilitiesSubcategory()));
        utilitiesSubcategory.setUtilitiesCategoryId(utilitiesCategoryId1);
        final UtilitiesService utilitiesService1 = new UtilitiesService();
        utilitiesService1.setUtilitiesServiceId(0L);
        final Service serviceId1 = new Service();
        serviceId1.setServiceId(0L);
        serviceId1.setServiceName("serviceName");
        serviceId1.setFax("fax");
        serviceId1.setPhone("phone");
        serviceId1.setEmail("email");
        serviceId1.setAddress("address");
        utilitiesService1.setServiceId(serviceId1);
        utilitiesSubcategory.setUtilitiesServiceList(Arrays.asList(utilitiesService1));
        when(serviceServiceImplUnderTest.utilitiesSubcategoryRepository.getById(0L)).thenReturn(utilitiesSubcategory);

        // Configure UtilitiesServiceRepository.save(...).
        final UtilitiesService utilitiesService2 = new UtilitiesService();
        final Service serviceId2 = new Service();
        serviceId2.setServiceId(0L);
        serviceId2.setServiceName("serviceName");
        serviceId2.setFax("fax");
        serviceId2.setPhone("phone");
        serviceId2.setEmail("email");
        serviceId2.setAddress("address");
        serviceId2.setCity("city");
        serviceId2.setLink("link");
        serviceId2.setStatus(0);
        serviceId2.setTaxCode("taxCode");
        serviceId2.setDateRegister(LocalDate.of(2020, 1, 1));
        serviceId2.setIsActive(false);
        serviceId2.setIsBlock(false);
        final ServiceCategory serviceCategoryId2 = new ServiceCategory();
        serviceCategoryId2.setServiceCategoryId(0L);
        serviceId2.setServiceCategoryId(serviceCategoryId2);
        final Partner partnerId2 = new Partner();
        partnerId2.setEmail("email");
        serviceId2.setPartnerId(partnerId2);
        utilitiesService2.setServiceId(serviceId2);
        final UtilitiesSubcategory utilitiesSubcategoryId1 = new UtilitiesSubcategory();
        utilitiesSubcategoryId1.setUtilitiesSubcategoryId(0L);
        final UtilitiesCategory utilitiesCategoryId2 = new UtilitiesCategory();
        utilitiesCategoryId2.setUtilitiesCategoryId(0L);
        utilitiesSubcategoryId1.setUtilitiesCategoryId(utilitiesCategoryId2);
        utilitiesService2.setUtilitiesSubcategoryId(utilitiesSubcategoryId1);
        when(serviceServiceImplUnderTest.utilitiesServiceRepository.save(any(UtilitiesService.class)))
                .thenReturn(utilitiesService2);

        // Configure EntertainmentRepository.getEntertainmentByServiceId(...).
        final Entertainment entertainment = new Entertainment();
        entertainment.setEntertainmentType("entertainmentType");
        entertainment.setDowOpen("dowOpen");
        entertainment.setTimeOpen(LocalTime.of(12, 0, 0));
        entertainment.setTimeClose(LocalTime.of(12, 0, 0));
        entertainment.setPriceTicketAdult(0.0f);
        entertainment.setPriceTicketChildren(0.0f);
        entertainment.setDescription("description");
        final Service serviceId3 = new Service();
        serviceId3.setServiceId(0L);
        serviceId3.setServiceName("serviceName");
        serviceId3.setFax("fax");
        serviceId3.setPhone("phone");
        serviceId3.setEmail("email");
        serviceId3.setAddress("address");
        serviceId3.setCity("city");
        serviceId3.setLink("link");
        serviceId3.setStatus(0);
        serviceId3.setTaxCode("taxCode");
        serviceId3.setDateRegister(LocalDate.of(2020, 1, 1));
        serviceId3.setIsActive(false);
        serviceId3.setIsBlock(false);
        final ServiceCategory serviceCategoryId3 = new ServiceCategory();
        serviceCategoryId3.setServiceCategoryId(0L);
        serviceId3.setServiceCategoryId(serviceCategoryId3);
        final Partner partnerId3 = new Partner();
        partnerId3.setEmail("email");
        serviceId3.setPartnerId(partnerId3);
        entertainment.setServiceId(serviceId3);
        when(serviceServiceImplUnderTest.entertainmentRepository.getEntertainmentByServiceId(0L))
                .thenReturn(entertainment);

        // Configure EntertainmentRepository.save(...).
        final Entertainment entertainment1 = new Entertainment();
        entertainment1.setEntertainmentType("entertainmentType");
        entertainment1.setDowOpen("dowOpen");
        entertainment1.setTimeOpen(LocalTime.of(12, 0, 0));
        entertainment1.setTimeClose(LocalTime.of(12, 0, 0));
        entertainment1.setPriceTicketAdult(0.0f);
        entertainment1.setPriceTicketChildren(0.0f);
        entertainment1.setDescription("description");
        final Service serviceId4 = new Service();
        serviceId4.setServiceId(0L);
        serviceId4.setServiceName("serviceName");
        serviceId4.setFax("fax");
        serviceId4.setPhone("phone");
        serviceId4.setEmail("email");
        serviceId4.setAddress("address");
        serviceId4.setCity("city");
        serviceId4.setLink("link");
        serviceId4.setStatus(0);
        serviceId4.setTaxCode("taxCode");
        serviceId4.setDateRegister(LocalDate.of(2020, 1, 1));
        serviceId4.setIsActive(false);
        serviceId4.setIsBlock(false);
        final ServiceCategory serviceCategoryId4 = new ServiceCategory();
        serviceCategoryId4.setServiceCategoryId(0L);
        serviceId4.setServiceCategoryId(serviceCategoryId4);
        final Partner partnerId4 = new Partner();
        partnerId4.setEmail("email");
        serviceId4.setPartnerId(partnerId4);
        entertainment1.setServiceId(serviceId4);
        when(serviceServiceImplUnderTest.entertainmentRepository.save(any(Entertainment.class)))
                .thenReturn(entertainment1);

        // Configure UtilitiesSubcategoryRepository.findByUtilitiesSubcategoryId(...).
        final UtilitiesSubcategory utilitiesSubcategory1 = new UtilitiesSubcategory();
        utilitiesSubcategory1.setUtilitiesSubcategoryId(0L);
        utilitiesSubcategory1.setUtilitiesSubcategoryName("utilitiesSubcategoryName");
        final UtilitiesCategory utilitiesCategoryId3 = new UtilitiesCategory();
        utilitiesCategoryId3.setUtilitiesCategoryId(0L);
        utilitiesCategoryId3.setUtilitiesCategoryName("utilitiesCategoryName");
        utilitiesCategoryId3.setUtilitiesSubcategoryList(Arrays.asList(new UtilitiesSubcategory()));
        utilitiesSubcategory1.setUtilitiesCategoryId(utilitiesCategoryId3);
        final UtilitiesService utilitiesService3 = new UtilitiesService();
        utilitiesService3.setUtilitiesServiceId(0L);
        final Service serviceId5 = new Service();
        serviceId5.setServiceId(0L);
        serviceId5.setServiceName("serviceName");
        serviceId5.setFax("fax");
        serviceId5.setPhone("phone");
        serviceId5.setEmail("email");
        serviceId5.setAddress("address");
        utilitiesService3.setServiceId(serviceId5);
        utilitiesSubcategory1.setUtilitiesServiceList(Arrays.asList(utilitiesService3));
        when(serviceServiceImplUnderTest.utilitiesSubcategoryRepository.findByUtilitiesSubcategoryId(0L))
                .thenReturn(utilitiesSubcategory1);

        // Run the test
        final EntertainmentDTO result = serviceServiceImplUnderTest.updateEntertainment(entertainmentDTO, 0L);

        // Verify the results
        verify(serviceServiceImplUnderTest.utilitiesServiceRepository).deleteAll(Arrays.asList(new UtilitiesService()));
        verify(serviceServiceImplUnderTest.utilitiesServiceRepository).save(any(UtilitiesService.class));
        verify(serviceServiceImplUnderTest.entertainmentRepository).save(any(Entertainment.class));
    }

    @Test
    void testUpdateEntertainment_UtilitiesServiceRepositoryGetListUtilitiesServiceByServiceIdReturnsNoItems() throws Exception {
        // Setup
        final EntertainmentDTO entertainmentDTO = new EntertainmentDTO(
                new ServiceDTO(0L, "serviceName", "fax", "phone", "email", "address", "city", "link", 0, "taxCode",
                        false, false, 0L, "typeOfServiceCategory", "email"), "entertainmentType", "dowOpen",
                LocalTime.of(12, 0, 0), LocalTime.of(12, 0, 0), 0.0f, 0.0f, "description",
                Arrays.asList(new UtilitiesServiceDTO(0L, 0L)));

        // Configure ServiceRepository.getById(...).
        final Service service = new Service();
        service.setServiceId(0L);
        service.setServiceName("serviceName");
        service.setFax("fax");
        service.setPhone("phone");
        service.setEmail("email");
        service.setAddress("address");
        service.setCity("city");
        service.setLink("link");
        service.setStatus(0);
        service.setTaxCode("taxCode");
        service.setDateRegister(LocalDate.of(2020, 1, 1));
        service.setIsActive(false);
        service.setIsBlock(false);
        final ServiceCategory serviceCategoryId = new ServiceCategory();
        serviceCategoryId.setServiceCategoryId(0L);
        service.setServiceCategoryId(serviceCategoryId);
        final Partner partnerId = new Partner();
        partnerId.setEmail("email");
        service.setPartnerId(partnerId);
        when(serviceServiceImplUnderTest.serviceRepository.getById(0L)).thenReturn(service);

        when(serviceServiceImplUnderTest.serviceRepository.existsAllByServiceName("serviceName")).thenReturn(false);
        when(serviceServiceImplUnderTest.utilitiesServiceRepository.getListUtilitiesServiceByServiceId(0L))
                .thenReturn(Collections.emptyList());

        // Configure UtilitiesSubcategoryRepository.getById(...).
        final UtilitiesSubcategory utilitiesSubcategory = new UtilitiesSubcategory();
        utilitiesSubcategory.setUtilitiesSubcategoryId(0L);
        utilitiesSubcategory.setUtilitiesSubcategoryName("utilitiesSubcategoryName");
        final UtilitiesCategory utilitiesCategoryId = new UtilitiesCategory();
        utilitiesCategoryId.setUtilitiesCategoryId(0L);
        utilitiesCategoryId.setUtilitiesCategoryName("utilitiesCategoryName");
        utilitiesCategoryId.setUtilitiesSubcategoryList(Arrays.asList(new UtilitiesSubcategory()));
        utilitiesSubcategory.setUtilitiesCategoryId(utilitiesCategoryId);
        final UtilitiesService utilitiesService = new UtilitiesService();
        utilitiesService.setUtilitiesServiceId(0L);
        final Service serviceId = new Service();
        serviceId.setServiceId(0L);
        serviceId.setServiceName("serviceName");
        serviceId.setFax("fax");
        serviceId.setPhone("phone");
        serviceId.setEmail("email");
        serviceId.setAddress("address");
        utilitiesService.setServiceId(serviceId);
        utilitiesSubcategory.setUtilitiesServiceList(Arrays.asList(utilitiesService));
        when(serviceServiceImplUnderTest.utilitiesSubcategoryRepository.getById(0L)).thenReturn(utilitiesSubcategory);

        // Configure UtilitiesServiceRepository.save(...).
        final UtilitiesService utilitiesService1 = new UtilitiesService();
        final Service serviceId1 = new Service();
        serviceId1.setServiceId(0L);
        serviceId1.setServiceName("serviceName");
        serviceId1.setFax("fax");
        serviceId1.setPhone("phone");
        serviceId1.setEmail("email");
        serviceId1.setAddress("address");
        serviceId1.setCity("city");
        serviceId1.setLink("link");
        serviceId1.setStatus(0);
        serviceId1.setTaxCode("taxCode");
        serviceId1.setDateRegister(LocalDate.of(2020, 1, 1));
        serviceId1.setIsActive(false);
        serviceId1.setIsBlock(false);
        final ServiceCategory serviceCategoryId1 = new ServiceCategory();
        serviceCategoryId1.setServiceCategoryId(0L);
        serviceId1.setServiceCategoryId(serviceCategoryId1);
        final Partner partnerId1 = new Partner();
        partnerId1.setEmail("email");
        serviceId1.setPartnerId(partnerId1);
        utilitiesService1.setServiceId(serviceId1);
        final UtilitiesSubcategory utilitiesSubcategoryId = new UtilitiesSubcategory();
        utilitiesSubcategoryId.setUtilitiesSubcategoryId(0L);
        final UtilitiesCategory utilitiesCategoryId1 = new UtilitiesCategory();
        utilitiesCategoryId1.setUtilitiesCategoryId(0L);
        utilitiesSubcategoryId.setUtilitiesCategoryId(utilitiesCategoryId1);
        utilitiesService1.setUtilitiesSubcategoryId(utilitiesSubcategoryId);
        when(serviceServiceImplUnderTest.utilitiesServiceRepository.save(any(UtilitiesService.class)))
                .thenReturn(utilitiesService1);

        // Configure EntertainmentRepository.getEntertainmentByServiceId(...).
        final Entertainment entertainment = new Entertainment();
        entertainment.setEntertainmentType("entertainmentType");
        entertainment.setDowOpen("dowOpen");
        entertainment.setTimeOpen(LocalTime.of(12, 0, 0));
        entertainment.setTimeClose(LocalTime.of(12, 0, 0));
        entertainment.setPriceTicketAdult(0.0f);
        entertainment.setPriceTicketChildren(0.0f);
        entertainment.setDescription("description");
        final Service serviceId2 = new Service();
        serviceId2.setServiceId(0L);
        serviceId2.setServiceName("serviceName");
        serviceId2.setFax("fax");
        serviceId2.setPhone("phone");
        serviceId2.setEmail("email");
        serviceId2.setAddress("address");
        serviceId2.setCity("city");
        serviceId2.setLink("link");
        serviceId2.setStatus(0);
        serviceId2.setTaxCode("taxCode");
        serviceId2.setDateRegister(LocalDate.of(2020, 1, 1));
        serviceId2.setIsActive(false);
        serviceId2.setIsBlock(false);
        final ServiceCategory serviceCategoryId2 = new ServiceCategory();
        serviceCategoryId2.setServiceCategoryId(0L);
        serviceId2.setServiceCategoryId(serviceCategoryId2);
        final Partner partnerId2 = new Partner();
        partnerId2.setEmail("email");
        serviceId2.setPartnerId(partnerId2);
        entertainment.setServiceId(serviceId2);
        when(serviceServiceImplUnderTest.entertainmentRepository.getEntertainmentByServiceId(0L))
                .thenReturn(entertainment);

        // Configure EntertainmentRepository.save(...).
        final Entertainment entertainment1 = new Entertainment();
        entertainment1.setEntertainmentType("entertainmentType");
        entertainment1.setDowOpen("dowOpen");
        entertainment1.setTimeOpen(LocalTime.of(12, 0, 0));
        entertainment1.setTimeClose(LocalTime.of(12, 0, 0));
        entertainment1.setPriceTicketAdult(0.0f);
        entertainment1.setPriceTicketChildren(0.0f);
        entertainment1.setDescription("description");
        final Service serviceId3 = new Service();
        serviceId3.setServiceId(0L);
        serviceId3.setServiceName("serviceName");
        serviceId3.setFax("fax");
        serviceId3.setPhone("phone");
        serviceId3.setEmail("email");
        serviceId3.setAddress("address");
        serviceId3.setCity("city");
        serviceId3.setLink("link");
        serviceId3.setStatus(0);
        serviceId3.setTaxCode("taxCode");
        serviceId3.setDateRegister(LocalDate.of(2020, 1, 1));
        serviceId3.setIsActive(false);
        serviceId3.setIsBlock(false);
        final ServiceCategory serviceCategoryId3 = new ServiceCategory();
        serviceCategoryId3.setServiceCategoryId(0L);
        serviceId3.setServiceCategoryId(serviceCategoryId3);
        final Partner partnerId3 = new Partner();
        partnerId3.setEmail("email");
        serviceId3.setPartnerId(partnerId3);
        entertainment1.setServiceId(serviceId3);
        when(serviceServiceImplUnderTest.entertainmentRepository.save(any(Entertainment.class)))
                .thenReturn(entertainment1);

        // Configure UtilitiesSubcategoryRepository.findByUtilitiesSubcategoryId(...).
        final UtilitiesSubcategory utilitiesSubcategory1 = new UtilitiesSubcategory();
        utilitiesSubcategory1.setUtilitiesSubcategoryId(0L);
        utilitiesSubcategory1.setUtilitiesSubcategoryName("utilitiesSubcategoryName");
        final UtilitiesCategory utilitiesCategoryId2 = new UtilitiesCategory();
        utilitiesCategoryId2.setUtilitiesCategoryId(0L);
        utilitiesCategoryId2.setUtilitiesCategoryName("utilitiesCategoryName");
        utilitiesCategoryId2.setUtilitiesSubcategoryList(Arrays.asList(new UtilitiesSubcategory()));
        utilitiesSubcategory1.setUtilitiesCategoryId(utilitiesCategoryId2);
        final UtilitiesService utilitiesService2 = new UtilitiesService();
        utilitiesService2.setUtilitiesServiceId(0L);
        final Service serviceId4 = new Service();
        serviceId4.setServiceId(0L);
        serviceId4.setServiceName("serviceName");
        serviceId4.setFax("fax");
        serviceId4.setPhone("phone");
        serviceId4.setEmail("email");
        serviceId4.setAddress("address");
        utilitiesService2.setServiceId(serviceId4);
        utilitiesSubcategory1.setUtilitiesServiceList(Arrays.asList(utilitiesService2));
        when(serviceServiceImplUnderTest.utilitiesSubcategoryRepository.findByUtilitiesSubcategoryId(0L))
                .thenReturn(utilitiesSubcategory1);

        // Run the test
        final EntertainmentDTO result = serviceServiceImplUnderTest.updateEntertainment(entertainmentDTO, 0L);

        // Verify the results
        verify(serviceServiceImplUnderTest.utilitiesServiceRepository).deleteAll(Arrays.asList(new UtilitiesService()));
        verify(serviceServiceImplUnderTest.utilitiesServiceRepository).save(any(UtilitiesService.class));
        verify(serviceServiceImplUnderTest.entertainmentRepository).save(any(Entertainment.class));
    }

    @Test
    void testUpdateEntertainment_ThrowsHandlerException() {
        // Setup
        final EntertainmentDTO entertainmentDTO = new EntertainmentDTO(
                new ServiceDTO(0L, "serviceName", "fax", "phone", "email", "address", "city", "link", 0, "taxCode",
                        false, false, 0L, "typeOfServiceCategory", "email"), "entertainmentType", "dowOpen",
                LocalTime.of(12, 0, 0), LocalTime.of(12, 0, 0), 0.0f, 0.0f, "description",
                Arrays.asList(new UtilitiesServiceDTO(0L, 0L)));

        // Configure ServiceRepository.getById(...).
        final Service service = new Service();
        service.setServiceId(0L);
        service.setServiceName("serviceName");
        service.setFax("fax");
        service.setPhone("phone");
        service.setEmail("email");
        service.setAddress("address");
        service.setCity("city");
        service.setLink("link");
        service.setStatus(0);
        service.setTaxCode("taxCode");
        service.setDateRegister(LocalDate.of(2020, 1, 1));
        service.setIsActive(false);
        service.setIsBlock(false);
        final ServiceCategory serviceCategoryId = new ServiceCategory();
        serviceCategoryId.setServiceCategoryId(0L);
        service.setServiceCategoryId(serviceCategoryId);
        final Partner partnerId = new Partner();
        partnerId.setEmail("email");
        service.setPartnerId(partnerId);
        when(serviceServiceImplUnderTest.serviceRepository.getById(0L)).thenReturn(service);

        when(serviceServiceImplUnderTest.serviceRepository.existsAllByServiceName("serviceName")).thenReturn(false);

        // Configure UtilitiesServiceRepository.getListUtilitiesServiceByServiceId(...).
        final UtilitiesService utilitiesService = new UtilitiesService();
        final Service serviceId = new Service();
        serviceId.setServiceId(0L);
        serviceId.setServiceName("serviceName");
        serviceId.setFax("fax");
        serviceId.setPhone("phone");
        serviceId.setEmail("email");
        serviceId.setAddress("address");
        serviceId.setCity("city");
        serviceId.setLink("link");
        serviceId.setStatus(0);
        serviceId.setTaxCode("taxCode");
        serviceId.setDateRegister(LocalDate.of(2020, 1, 1));
        serviceId.setIsActive(false);
        serviceId.setIsBlock(false);
        final ServiceCategory serviceCategoryId1 = new ServiceCategory();
        serviceCategoryId1.setServiceCategoryId(0L);
        serviceId.setServiceCategoryId(serviceCategoryId1);
        final Partner partnerId1 = new Partner();
        partnerId1.setEmail("email");
        serviceId.setPartnerId(partnerId1);
        utilitiesService.setServiceId(serviceId);
        final UtilitiesSubcategory utilitiesSubcategoryId = new UtilitiesSubcategory();
        utilitiesSubcategoryId.setUtilitiesSubcategoryId(0L);
        final UtilitiesCategory utilitiesCategoryId = new UtilitiesCategory();
        utilitiesCategoryId.setUtilitiesCategoryId(0L);
        utilitiesSubcategoryId.setUtilitiesCategoryId(utilitiesCategoryId);
        utilitiesService.setUtilitiesSubcategoryId(utilitiesSubcategoryId);
        final List<UtilitiesService> utilitiesServiceList = Arrays.asList(utilitiesService);
        when(serviceServiceImplUnderTest.utilitiesServiceRepository.getListUtilitiesServiceByServiceId(0L))
                .thenReturn(utilitiesServiceList);

        // Configure UtilitiesSubcategoryRepository.getById(...).
        final UtilitiesSubcategory utilitiesSubcategory = new UtilitiesSubcategory();
        utilitiesSubcategory.setUtilitiesSubcategoryId(0L);
        utilitiesSubcategory.setUtilitiesSubcategoryName("utilitiesSubcategoryName");
        final UtilitiesCategory utilitiesCategoryId1 = new UtilitiesCategory();
        utilitiesCategoryId1.setUtilitiesCategoryId(0L);
        utilitiesCategoryId1.setUtilitiesCategoryName("utilitiesCategoryName");
        utilitiesCategoryId1.setUtilitiesSubcategoryList(Arrays.asList(new UtilitiesSubcategory()));
        utilitiesSubcategory.setUtilitiesCategoryId(utilitiesCategoryId1);
        final UtilitiesService utilitiesService1 = new UtilitiesService();
        utilitiesService1.setUtilitiesServiceId(0L);
        final Service serviceId1 = new Service();
        serviceId1.setServiceId(0L);
        serviceId1.setServiceName("serviceName");
        serviceId1.setFax("fax");
        serviceId1.setPhone("phone");
        serviceId1.setEmail("email");
        serviceId1.setAddress("address");
        utilitiesService1.setServiceId(serviceId1);
        utilitiesSubcategory.setUtilitiesServiceList(Arrays.asList(utilitiesService1));
        when(serviceServiceImplUnderTest.utilitiesSubcategoryRepository.getById(0L)).thenReturn(utilitiesSubcategory);

        // Configure UtilitiesServiceRepository.save(...).
        final UtilitiesService utilitiesService2 = new UtilitiesService();
        final Service serviceId2 = new Service();
        serviceId2.setServiceId(0L);
        serviceId2.setServiceName("serviceName");
        serviceId2.setFax("fax");
        serviceId2.setPhone("phone");
        serviceId2.setEmail("email");
        serviceId2.setAddress("address");
        serviceId2.setCity("city");
        serviceId2.setLink("link");
        serviceId2.setStatus(0);
        serviceId2.setTaxCode("taxCode");
        serviceId2.setDateRegister(LocalDate.of(2020, 1, 1));
        serviceId2.setIsActive(false);
        serviceId2.setIsBlock(false);
        final ServiceCategory serviceCategoryId2 = new ServiceCategory();
        serviceCategoryId2.setServiceCategoryId(0L);
        serviceId2.setServiceCategoryId(serviceCategoryId2);
        final Partner partnerId2 = new Partner();
        partnerId2.setEmail("email");
        serviceId2.setPartnerId(partnerId2);
        utilitiesService2.setServiceId(serviceId2);
        final UtilitiesSubcategory utilitiesSubcategoryId1 = new UtilitiesSubcategory();
        utilitiesSubcategoryId1.setUtilitiesSubcategoryId(0L);
        final UtilitiesCategory utilitiesCategoryId2 = new UtilitiesCategory();
        utilitiesCategoryId2.setUtilitiesCategoryId(0L);
        utilitiesSubcategoryId1.setUtilitiesCategoryId(utilitiesCategoryId2);
        utilitiesService2.setUtilitiesSubcategoryId(utilitiesSubcategoryId1);
        when(serviceServiceImplUnderTest.utilitiesServiceRepository.save(any(UtilitiesService.class)))
                .thenReturn(utilitiesService2);

        // Configure EntertainmentRepository.getEntertainmentByServiceId(...).
        final Entertainment entertainment = new Entertainment();
        entertainment.setEntertainmentType("entertainmentType");
        entertainment.setDowOpen("dowOpen");
        entertainment.setTimeOpen(LocalTime.of(12, 0, 0));
        entertainment.setTimeClose(LocalTime.of(12, 0, 0));
        entertainment.setPriceTicketAdult(0.0f);
        entertainment.setPriceTicketChildren(0.0f);
        entertainment.setDescription("description");
        final Service serviceId3 = new Service();
        serviceId3.setServiceId(0L);
        serviceId3.setServiceName("serviceName");
        serviceId3.setFax("fax");
        serviceId3.setPhone("phone");
        serviceId3.setEmail("email");
        serviceId3.setAddress("address");
        serviceId3.setCity("city");
        serviceId3.setLink("link");
        serviceId3.setStatus(0);
        serviceId3.setTaxCode("taxCode");
        serviceId3.setDateRegister(LocalDate.of(2020, 1, 1));
        serviceId3.setIsActive(false);
        serviceId3.setIsBlock(false);
        final ServiceCategory serviceCategoryId3 = new ServiceCategory();
        serviceCategoryId3.setServiceCategoryId(0L);
        serviceId3.setServiceCategoryId(serviceCategoryId3);
        final Partner partnerId3 = new Partner();
        partnerId3.setEmail("email");
        serviceId3.setPartnerId(partnerId3);
        entertainment.setServiceId(serviceId3);
        when(serviceServiceImplUnderTest.entertainmentRepository.getEntertainmentByServiceId(0L))
                .thenReturn(entertainment);

        // Configure EntertainmentRepository.save(...).
        final Entertainment entertainment1 = new Entertainment();
        entertainment1.setEntertainmentType("entertainmentType");
        entertainment1.setDowOpen("dowOpen");
        entertainment1.setTimeOpen(LocalTime.of(12, 0, 0));
        entertainment1.setTimeClose(LocalTime.of(12, 0, 0));
        entertainment1.setPriceTicketAdult(0.0f);
        entertainment1.setPriceTicketChildren(0.0f);
        entertainment1.setDescription("description");
        final Service serviceId4 = new Service();
        serviceId4.setServiceId(0L);
        serviceId4.setServiceName("serviceName");
        serviceId4.setFax("fax");
        serviceId4.setPhone("phone");
        serviceId4.setEmail("email");
        serviceId4.setAddress("address");
        serviceId4.setCity("city");
        serviceId4.setLink("link");
        serviceId4.setStatus(0);
        serviceId4.setTaxCode("taxCode");
        serviceId4.setDateRegister(LocalDate.of(2020, 1, 1));
        serviceId4.setIsActive(false);
        serviceId4.setIsBlock(false);
        final ServiceCategory serviceCategoryId4 = new ServiceCategory();
        serviceCategoryId4.setServiceCategoryId(0L);
        serviceId4.setServiceCategoryId(serviceCategoryId4);
        final Partner partnerId4 = new Partner();
        partnerId4.setEmail("email");
        serviceId4.setPartnerId(partnerId4);
        entertainment1.setServiceId(serviceId4);
        when(serviceServiceImplUnderTest.entertainmentRepository.save(any(Entertainment.class)))
                .thenReturn(entertainment1);

        // Configure UtilitiesSubcategoryRepository.findByUtilitiesSubcategoryId(...).
        final UtilitiesSubcategory utilitiesSubcategory1 = new UtilitiesSubcategory();
        utilitiesSubcategory1.setUtilitiesSubcategoryId(0L);
        utilitiesSubcategory1.setUtilitiesSubcategoryName("utilitiesSubcategoryName");
        final UtilitiesCategory utilitiesCategoryId3 = new UtilitiesCategory();
        utilitiesCategoryId3.setUtilitiesCategoryId(0L);
        utilitiesCategoryId3.setUtilitiesCategoryName("utilitiesCategoryName");
        utilitiesCategoryId3.setUtilitiesSubcategoryList(Arrays.asList(new UtilitiesSubcategory()));
        utilitiesSubcategory1.setUtilitiesCategoryId(utilitiesCategoryId3);
        final UtilitiesService utilitiesService3 = new UtilitiesService();
        utilitiesService3.setUtilitiesServiceId(0L);
        final Service serviceId5 = new Service();
        serviceId5.setServiceId(0L);
        serviceId5.setServiceName("serviceName");
        serviceId5.setFax("fax");
        serviceId5.setPhone("phone");
        serviceId5.setEmail("email");
        serviceId5.setAddress("address");
        utilitiesService3.setServiceId(serviceId5);
        utilitiesSubcategory1.setUtilitiesServiceList(Arrays.asList(utilitiesService3));
        when(serviceServiceImplUnderTest.utilitiesSubcategoryRepository.findByUtilitiesSubcategoryId(0L))
                .thenReturn(utilitiesSubcategory1);

        // Run the test
        assertThatThrownBy(() -> serviceServiceImplUnderTest.updateEntertainment(entertainmentDTO, 0L))
                .isInstanceOf(HandlerException.class);
        verify(serviceServiceImplUnderTest.utilitiesServiceRepository).deleteAll(Arrays.asList(new UtilitiesService()));
        verify(serviceServiceImplUnderTest.utilitiesServiceRepository).save(any(UtilitiesService.class));
        verify(serviceServiceImplUnderTest.entertainmentRepository).save(any(Entertainment.class));
    }

    @Test
    void testDeleteService() throws Exception {
        // Setup
        when(serviceServiceImplUnderTest.serviceRepository.existsById(0L)).thenReturn(false);

        // Configure ServiceRepository.getById(...).
        final Service service = new Service();
        service.setServiceId(0L);
        service.setServiceName("serviceName");
        service.setFax("fax");
        service.setPhone("phone");
        service.setEmail("email");
        service.setAddress("address");
        service.setCity("city");
        service.setLink("link");
        service.setStatus(0);
        service.setTaxCode("taxCode");
        service.setDateRegister(LocalDate.of(2020, 1, 1));
        service.setIsActive(false);
        service.setIsBlock(false);
        final ServiceCategory serviceCategoryId = new ServiceCategory();
        serviceCategoryId.setServiceCategoryId(0L);
        service.setServiceCategoryId(serviceCategoryId);
        final Partner partnerId = new Partner();
        partnerId.setEmail("email");
        service.setPartnerId(partnerId);
        when(serviceServiceImplUnderTest.serviceRepository.getById(0L)).thenReturn(service);

        // Configure ServiceRepository.save(...).
        final Service service1 = new Service();
        service1.setServiceId(0L);
        service1.setServiceName("serviceName");
        service1.setFax("fax");
        service1.setPhone("phone");
        service1.setEmail("email");
        service1.setAddress("address");
        service1.setCity("city");
        service1.setLink("link");
        service1.setStatus(0);
        service1.setTaxCode("taxCode");
        service1.setDateRegister(LocalDate.of(2020, 1, 1));
        service1.setIsActive(false);
        service1.setIsBlock(false);
        final ServiceCategory serviceCategoryId1 = new ServiceCategory();
        serviceCategoryId1.setServiceCategoryId(0L);
        service1.setServiceCategoryId(serviceCategoryId1);
        final Partner partnerId1 = new Partner();
        partnerId1.setEmail("email");
        service1.setPartnerId(partnerId1);
        when(serviceServiceImplUnderTest.serviceRepository.save(any(Service.class))).thenReturn(service1);

        // Run the test
        final Boolean result = serviceServiceImplUnderTest.deleteService(0L);

        // Verify the results
        assertThat(result).isFalse();
        verify(serviceServiceImplUnderTest.serviceRepository).save(any(Service.class));
    }

    @Test
    void testDeleteService_ThrowsHandlerException() {
        // Setup
        when(serviceServiceImplUnderTest.serviceRepository.existsById(0L)).thenReturn(false);

        // Configure ServiceRepository.getById(...).
        final Service service = new Service();
        service.setServiceId(0L);
        service.setServiceName("serviceName");
        service.setFax("fax");
        service.setPhone("phone");
        service.setEmail("email");
        service.setAddress("address");
        service.setCity("city");
        service.setLink("link");
        service.setStatus(0);
        service.setTaxCode("taxCode");
        service.setDateRegister(LocalDate.of(2020, 1, 1));
        service.setIsActive(false);
        service.setIsBlock(false);
        final ServiceCategory serviceCategoryId = new ServiceCategory();
        serviceCategoryId.setServiceCategoryId(0L);
        service.setServiceCategoryId(serviceCategoryId);
        final Partner partnerId = new Partner();
        partnerId.setEmail("email");
        service.setPartnerId(partnerId);
        when(serviceServiceImplUnderTest.serviceRepository.getById(0L)).thenReturn(service);

        // Configure ServiceRepository.save(...).
        final Service service1 = new Service();
        service1.setServiceId(0L);
        service1.setServiceName("serviceName");
        service1.setFax("fax");
        service1.setPhone("phone");
        service1.setEmail("email");
        service1.setAddress("address");
        service1.setCity("city");
        service1.setLink("link");
        service1.setStatus(0);
        service1.setTaxCode("taxCode");
        service1.setDateRegister(LocalDate.of(2020, 1, 1));
        service1.setIsActive(false);
        service1.setIsBlock(false);
        final ServiceCategory serviceCategoryId1 = new ServiceCategory();
        serviceCategoryId1.setServiceCategoryId(0L);
        service1.setServiceCategoryId(serviceCategoryId1);
        final Partner partnerId1 = new Partner();
        partnerId1.setEmail("email");
        service1.setPartnerId(partnerId1);
        when(serviceServiceImplUnderTest.serviceRepository.save(any(Service.class))).thenReturn(service1);

        // Run the test
        assertThatThrownBy(() -> serviceServiceImplUnderTest.deleteService(0L)).isInstanceOf(HandlerException.class);
        verify(serviceServiceImplUnderTest.serviceRepository).save(any(Service.class));
    }

    @Test
    void testApproveService() throws Exception {
        // Setup
        when(serviceServiceImplUnderTest.serviceRepository.existsById(0L)).thenReturn(false);

        // Configure ServiceRepository.getById(...).
        final Service service = new Service();
        service.setServiceId(0L);
        service.setServiceName("serviceName");
        service.setFax("fax");
        service.setPhone("phone");
        service.setEmail("email");
        service.setAddress("address");
        service.setCity("city");
        service.setLink("link");
        service.setStatus(0);
        service.setTaxCode("taxCode");
        service.setDateRegister(LocalDate.of(2020, 1, 1));
        service.setIsActive(false);
        service.setIsBlock(false);
        final ServiceCategory serviceCategoryId = new ServiceCategory();
        serviceCategoryId.setServiceCategoryId(0L);
        service.setServiceCategoryId(serviceCategoryId);
        final Partner partnerId = new Partner();
        partnerId.setEmail("email");
        service.setPartnerId(partnerId);
        when(serviceServiceImplUnderTest.serviceRepository.getById(0L)).thenReturn(service);

        // Configure ServiceRepository.save(...).
        final Service service1 = new Service();
        service1.setServiceId(0L);
        service1.setServiceName("serviceName");
        service1.setFax("fax");
        service1.setPhone("phone");
        service1.setEmail("email");
        service1.setAddress("address");
        service1.setCity("city");
        service1.setLink("link");
        service1.setStatus(0);
        service1.setTaxCode("taxCode");
        service1.setDateRegister(LocalDate.of(2020, 1, 1));
        service1.setIsActive(false);
        service1.setIsBlock(false);
        final ServiceCategory serviceCategoryId1 = new ServiceCategory();
        serviceCategoryId1.setServiceCategoryId(0L);
        service1.setServiceCategoryId(serviceCategoryId1);
        final Partner partnerId1 = new Partner();
        partnerId1.setEmail("email");
        service1.setPartnerId(partnerId1);
        when(serviceServiceImplUnderTest.serviceRepository.save(any(Service.class))).thenReturn(service1);

        // Run the test
        final Boolean result = serviceServiceImplUnderTest.approveService(0L);

        // Verify the results
        assertThat(result).isFalse();
        verify(serviceServiceImplUnderTest.serviceRepository).save(any(Service.class));
    }

    @Test
    void testApproveService_ThrowsHandlerException() {
        // Setup
        when(serviceServiceImplUnderTest.serviceRepository.existsById(0L)).thenReturn(false);

        // Configure ServiceRepository.getById(...).
        final Service service = new Service();
        service.setServiceId(0L);
        service.setServiceName("serviceName");
        service.setFax("fax");
        service.setPhone("phone");
        service.setEmail("email");
        service.setAddress("address");
        service.setCity("city");
        service.setLink("link");
        service.setStatus(0);
        service.setTaxCode("taxCode");
        service.setDateRegister(LocalDate.of(2020, 1, 1));
        service.setIsActive(false);
        service.setIsBlock(false);
        final ServiceCategory serviceCategoryId = new ServiceCategory();
        serviceCategoryId.setServiceCategoryId(0L);
        service.setServiceCategoryId(serviceCategoryId);
        final Partner partnerId = new Partner();
        partnerId.setEmail("email");
        service.setPartnerId(partnerId);
        when(serviceServiceImplUnderTest.serviceRepository.getById(0L)).thenReturn(service);

        // Configure ServiceRepository.save(...).
        final Service service1 = new Service();
        service1.setServiceId(0L);
        service1.setServiceName("serviceName");
        service1.setFax("fax");
        service1.setPhone("phone");
        service1.setEmail("email");
        service1.setAddress("address");
        service1.setCity("city");
        service1.setLink("link");
        service1.setStatus(0);
        service1.setTaxCode("taxCode");
        service1.setDateRegister(LocalDate.of(2020, 1, 1));
        service1.setIsActive(false);
        service1.setIsBlock(false);
        final ServiceCategory serviceCategoryId1 = new ServiceCategory();
        serviceCategoryId1.setServiceCategoryId(0L);
        service1.setServiceCategoryId(serviceCategoryId1);
        final Partner partnerId1 = new Partner();
        partnerId1.setEmail("email");
        service1.setPartnerId(partnerId1);
        when(serviceServiceImplUnderTest.serviceRepository.save(any(Service.class))).thenReturn(service1);

        // Run the test
        assertThatThrownBy(() -> serviceServiceImplUnderTest.approveService(0L)).isInstanceOf(HandlerException.class);
        verify(serviceServiceImplUnderTest.serviceRepository).save(any(Service.class));
    }

    @Test
    void testUnblockService() throws Exception {
        // Setup
        when(serviceServiceImplUnderTest.serviceRepository.existsById(0L)).thenReturn(false);

        // Configure ServiceRepository.getById(...).
        final Service service = new Service();
        service.setServiceId(0L);
        service.setServiceName("serviceName");
        service.setFax("fax");
        service.setPhone("phone");
        service.setEmail("email");
        service.setAddress("address");
        service.setCity("city");
        service.setLink("link");
        service.setStatus(0);
        service.setTaxCode("taxCode");
        service.setDateRegister(LocalDate.of(2020, 1, 1));
        service.setIsActive(false);
        service.setIsBlock(false);
        final ServiceCategory serviceCategoryId = new ServiceCategory();
        serviceCategoryId.setServiceCategoryId(0L);
        service.setServiceCategoryId(serviceCategoryId);
        final Partner partnerId = new Partner();
        partnerId.setEmail("email");
        service.setPartnerId(partnerId);
        when(serviceServiceImplUnderTest.serviceRepository.getById(0L)).thenReturn(service);

        // Configure ServiceRepository.save(...).
        final Service service1 = new Service();
        service1.setServiceId(0L);
        service1.setServiceName("serviceName");
        service1.setFax("fax");
        service1.setPhone("phone");
        service1.setEmail("email");
        service1.setAddress("address");
        service1.setCity("city");
        service1.setLink("link");
        service1.setStatus(0);
        service1.setTaxCode("taxCode");
        service1.setDateRegister(LocalDate.of(2020, 1, 1));
        service1.setIsActive(false);
        service1.setIsBlock(false);
        final ServiceCategory serviceCategoryId1 = new ServiceCategory();
        serviceCategoryId1.setServiceCategoryId(0L);
        service1.setServiceCategoryId(serviceCategoryId1);
        final Partner partnerId1 = new Partner();
        partnerId1.setEmail("email");
        service1.setPartnerId(partnerId1);
        when(serviceServiceImplUnderTest.serviceRepository.save(any(Service.class))).thenReturn(service1);

        // Run the test
        final Boolean result = serviceServiceImplUnderTest.unblockService(0L);

        // Verify the results
        assertThat(result).isFalse();
        verify(serviceServiceImplUnderTest.serviceRepository).save(any(Service.class));
    }

    @Test
    void testUnblockService_ThrowsHandlerException() {
        // Setup
        when(serviceServiceImplUnderTest.serviceRepository.existsById(0L)).thenReturn(false);

        // Configure ServiceRepository.getById(...).
        final Service service = new Service();
        service.setServiceId(0L);
        service.setServiceName("serviceName");
        service.setFax("fax");
        service.setPhone("phone");
        service.setEmail("email");
        service.setAddress("address");
        service.setCity("city");
        service.setLink("link");
        service.setStatus(0);
        service.setTaxCode("taxCode");
        service.setDateRegister(LocalDate.of(2020, 1, 1));
        service.setIsActive(false);
        service.setIsBlock(false);
        final ServiceCategory serviceCategoryId = new ServiceCategory();
        serviceCategoryId.setServiceCategoryId(0L);
        service.setServiceCategoryId(serviceCategoryId);
        final Partner partnerId = new Partner();
        partnerId.setEmail("email");
        service.setPartnerId(partnerId);
        when(serviceServiceImplUnderTest.serviceRepository.getById(0L)).thenReturn(service);

        // Configure ServiceRepository.save(...).
        final Service service1 = new Service();
        service1.setServiceId(0L);
        service1.setServiceName("serviceName");
        service1.setFax("fax");
        service1.setPhone("phone");
        service1.setEmail("email");
        service1.setAddress("address");
        service1.setCity("city");
        service1.setLink("link");
        service1.setStatus(0);
        service1.setTaxCode("taxCode");
        service1.setDateRegister(LocalDate.of(2020, 1, 1));
        service1.setIsActive(false);
        service1.setIsBlock(false);
        final ServiceCategory serviceCategoryId1 = new ServiceCategory();
        serviceCategoryId1.setServiceCategoryId(0L);
        service1.setServiceCategoryId(serviceCategoryId1);
        final Partner partnerId1 = new Partner();
        partnerId1.setEmail("email");
        service1.setPartnerId(partnerId1);
        when(serviceServiceImplUnderTest.serviceRepository.save(any(Service.class))).thenReturn(service1);

        // Run the test
        assertThatThrownBy(() -> serviceServiceImplUnderTest.unblockService(0L)).isInstanceOf(HandlerException.class);
        verify(serviceServiceImplUnderTest.serviceRepository).save(any(Service.class));
    }
}

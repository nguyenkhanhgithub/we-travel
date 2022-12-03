package com.example.wetravel.Entity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

class ServiceCategoryTest {
    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link ServiceCategory#ServiceCategory()}
     *   <li>{@link ServiceCategory#setPartnerList(List)}
     *   <li>{@link ServiceCategory#setServiceCategoryId(Long)}
     *   <li>{@link ServiceCategory#setServiceCategoryName(String)}
     *   <li>{@link ServiceCategory#setServiceList(List)}
     *   <li>{@link ServiceCategory#getPartnerList()}
     *   <li>{@link ServiceCategory#getServiceCategoryId()}
     *   <li>{@link ServiceCategory#getServiceCategoryName()}
     *   <li>{@link ServiceCategory#getServiceList()}
     * </ul>
     */
    @Test
    void testConstructor() {
        ServiceCategory actualServiceCategory = new ServiceCategory();
        ArrayList<Partner> partnerList = new ArrayList<>();
        actualServiceCategory.setPartnerList(partnerList);
        actualServiceCategory.setServiceCategoryId(123L);
        actualServiceCategory.setServiceCategoryName("Service Category Name");
        ArrayList<Service> serviceList = new ArrayList<>();
        actualServiceCategory.setServiceList(serviceList);
        List<Partner> partnerList1 = actualServiceCategory.getPartnerList();
        assertSame(partnerList, partnerList1);
        assertEquals(serviceList, partnerList1);
        assertEquals(123L, actualServiceCategory.getServiceCategoryId().longValue());
        assertEquals("Service Category Name", actualServiceCategory.getServiceCategoryName());
        List<Service> serviceList1 = actualServiceCategory.getServiceList();
        assertSame(serviceList, serviceList1);
        assertEquals(partnerList1, serviceList1);
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link ServiceCategory#ServiceCategory(Long, String, List, List)}
     *   <li>{@link ServiceCategory#setPartnerList(List)}
     *   <li>{@link ServiceCategory#setServiceCategoryId(Long)}
     *   <li>{@link ServiceCategory#setServiceCategoryName(String)}
     *   <li>{@link ServiceCategory#setServiceList(List)}
     *   <li>{@link ServiceCategory#getPartnerList()}
     *   <li>{@link ServiceCategory#getServiceCategoryId()}
     *   <li>{@link ServiceCategory#getServiceCategoryName()}
     *   <li>{@link ServiceCategory#getServiceList()}
     * </ul>
     */
    @Test
    void testConstructor2() {
        ArrayList<Service> serviceList = new ArrayList<>();
        ArrayList<Partner> partnerList = new ArrayList<>();
        ServiceCategory actualServiceCategory = new ServiceCategory(123L, "Service Category Name", serviceList,
                partnerList);
        ArrayList<Partner> partnerList1 = new ArrayList<>();
        actualServiceCategory.setPartnerList(partnerList1);
        actualServiceCategory.setServiceCategoryId(123L);
        actualServiceCategory.setServiceCategoryName("Service Category Name");
        ArrayList<Service> serviceList1 = new ArrayList<>();
        actualServiceCategory.setServiceList(serviceList1);
        List<Partner> partnerList2 = actualServiceCategory.getPartnerList();
        assertSame(partnerList1, partnerList2);
        assertEquals(serviceList, partnerList2);
        assertEquals(partnerList, partnerList2);
        assertEquals(serviceList1, partnerList2);
        assertEquals(123L, actualServiceCategory.getServiceCategoryId().longValue());
        assertEquals("Service Category Name", actualServiceCategory.getServiceCategoryName());
        List<Service> serviceList2 = actualServiceCategory.getServiceList();
        assertSame(serviceList1, serviceList2);
        assertEquals(serviceList, serviceList2);
        assertEquals(partnerList, serviceList2);
        assertEquals(partnerList2, serviceList2);
    }
}


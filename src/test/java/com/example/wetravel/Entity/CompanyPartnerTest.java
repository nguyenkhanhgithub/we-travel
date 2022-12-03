package com.example.wetravel.Entity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

class CompanyPartnerTest {
    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link CompanyPartner#CompanyPartner()}
     *   <li>{@link CompanyPartner#setAddress(String)}
     *   <li>{@link CompanyPartner#setBusinessCode(String)}
     *   <li>{@link CompanyPartner#setCity(String)}
     *   <li>{@link CompanyPartner#setCompanyName(String)}
     *   <li>{@link CompanyPartner#setCompanyPartnerId(Long)}
     *   <li>{@link CompanyPartner#setEmail(String)}
     *   <li>{@link CompanyPartner#setFax(String)}
     *   <li>{@link CompanyPartner#setIncorporationDate(String)}
     *   <li>{@link CompanyPartner#setPartnerId(Partner)}
     *   <li>{@link CompanyPartner#setPhone(String)}
     *   <li>{@link CompanyPartner#setRegistrationDate(String)}
     *   <li>{@link CompanyPartner#setShortName(String)}
     *   <li>{@link CompanyPartner#setTaxCode(String)}
     *   <li>{@link CompanyPartner#setWebsite(String)}
     *   <li>{@link CompanyPartner#getAddress()}
     *   <li>{@link CompanyPartner#getPartnerId()}
     *   <li>{@link CompanyPartner#getBusinessCode()}
     *   <li>{@link CompanyPartner#getCity()}
     *   <li>{@link CompanyPartner#getCompanyName()}
     *   <li>{@link CompanyPartner#getCompanyPartnerId()}
     *   <li>{@link CompanyPartner#getEmail()}
     *   <li>{@link CompanyPartner#getFax()}
     *   <li>{@link CompanyPartner#getIncorporationDate()}
     *   <li>{@link CompanyPartner#getPhone()}
     *   <li>{@link CompanyPartner#getRegistrationDate()}
     *   <li>{@link CompanyPartner#getShortName()}
     *   <li>{@link CompanyPartner#getTaxCode()}
     *   <li>{@link CompanyPartner#getWebsite()}
     * </ul>
     */
    @Test
    void testConstructor() {
        CompanyPartner actualCompanyPartner = new CompanyPartner();
        actualCompanyPartner.setAddress("42 Main St");
        actualCompanyPartner.setBusinessCode("Business Code");
        actualCompanyPartner.setCity("Oxford");
        actualCompanyPartner.setCompanyName("Company Name");
        actualCompanyPartner.setCompanyPartnerId(123L);
        actualCompanyPartner.setEmail("jane.doe@example.org");
        actualCompanyPartner.setFax("Fax");
        actualCompanyPartner.setIncorporationDate("2020-03-01");
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
        ServiceCategory serviceCategory1 = new ServiceCategory();
        serviceCategory1.setPartnerList(new ArrayList<>());
        serviceCategory1.setServiceCategoryId(123L);
        serviceCategory1.setServiceCategoryName("Service Category Name");
        serviceCategory1.setServiceList(new ArrayList<>());
        Partner partner1 = new Partner();
        partner1.setAccountId(account3);
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
        partner1.setServiceCategoryId(serviceCategory1);
        partner1.setServiceList(new ArrayList<>());
        CompanyPartner companyPartner2 = new CompanyPartner();
        companyPartner2.setAddress("42 Main St");
        companyPartner2.setBusinessCode("Business Code");
        companyPartner2.setCity("Oxford");
        companyPartner2.setCompanyName("Company Name");
        companyPartner2.setCompanyPartnerId(123L);
        companyPartner2.setEmail("jane.doe@example.org");
        companyPartner2.setFax("Fax");
        companyPartner2.setIncorporationDate("2020-03-01");
        companyPartner2.setPartnerId(partner1);
        companyPartner2.setPhone("4105551212");
        companyPartner2.setRegistrationDate("2020-03-01");
        companyPartner2.setShortName("Short Name");
        companyPartner2.setTaxCode("Tax Code");
        companyPartner2.setWebsite("Website");
        ServiceCategory serviceCategory2 = new ServiceCategory();
        serviceCategory2.setPartnerList(new ArrayList<>());
        serviceCategory2.setServiceCategoryId(123L);
        serviceCategory2.setServiceCategoryName("Service Category Name");
        serviceCategory2.setServiceList(new ArrayList<>());
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
        partner2.setServiceCategoryId(serviceCategory2);
        partner2.setServiceList(new ArrayList<>());
        actualCompanyPartner.setPartnerId(partner2);
        actualCompanyPartner.setPhone("4105551212");
        actualCompanyPartner.setRegistrationDate("2020-03-01");
        actualCompanyPartner.setShortName("Short Name");
        actualCompanyPartner.setTaxCode("Tax Code");
        actualCompanyPartner.setWebsite("Website");
        assertEquals("42 Main St", actualCompanyPartner.getAddress());
        Partner partnerId = actualCompanyPartner.getPartnerId();
        CompanyPartner companyPartnerId = partnerId.getCompanyPartnerId();
        assertEquals("42 Main St", companyPartnerId.getAddress());
        assertEquals("Business Code", actualCompanyPartner.getBusinessCode());
        assertEquals("Business Code", companyPartnerId.getBusinessCode());
        assertEquals("Oxford", actualCompanyPartner.getCity());
        assertEquals("Oxford", companyPartnerId.getCity());
        assertEquals("Company Name", actualCompanyPartner.getCompanyName());
        assertEquals("Company Name", companyPartnerId.getCompanyName());
        assertEquals(123L, actualCompanyPartner.getCompanyPartnerId().longValue());
        assertEquals(123L, companyPartnerId.getCompanyPartnerId().longValue());
        assertEquals("jane.doe@example.org", actualCompanyPartner.getEmail());
        assertEquals("jane.doe@example.org", companyPartnerId.getEmail());
        assertEquals("Fax", actualCompanyPartner.getFax());
        assertEquals("Fax", companyPartnerId.getFax());
        assertEquals("2020-03-01", actualCompanyPartner.getIncorporationDate());
        assertEquals("2020-03-01", companyPartnerId.getIncorporationDate());
        assertSame(partner2, partnerId);
        assertSame(partner1, companyPartnerId.getPartnerId());
        assertEquals("4105551212", actualCompanyPartner.getPhone());
        assertEquals("4105551212", companyPartnerId.getPhone());
        assertEquals("2020-03-01", actualCompanyPartner.getRegistrationDate());
        assertEquals("2020-03-01", companyPartnerId.getRegistrationDate());
        assertEquals("Short Name", actualCompanyPartner.getShortName());
        assertEquals("Short Name", companyPartnerId.getShortName());
        assertEquals("Tax Code", actualCompanyPartner.getTaxCode());
        assertEquals("Tax Code", companyPartnerId.getTaxCode());
        assertEquals("Website", actualCompanyPartner.getWebsite());
        assertEquals("Website", companyPartnerId.getWebsite());
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link CompanyPartner#CompanyPartner(Long, Partner, String, String, String, String, String, String, String, String, String, String, String, String)}
     *   <li>{@link CompanyPartner#CompanyPartner()}
     *   <li>{@link CompanyPartner#setAddress(String)}
     *   <li>{@link CompanyPartner#setBusinessCode(String)}
     *   <li>{@link CompanyPartner#setCity(String)}
     *   <li>{@link CompanyPartner#setCompanyName(String)}
     *   <li>{@link CompanyPartner#setCompanyPartnerId(Long)}
     *   <li>{@link CompanyPartner#setEmail(String)}
     *   <li>{@link CompanyPartner#setFax(String)}
     *   <li>{@link CompanyPartner#setIncorporationDate(String)}
     *   <li>{@link CompanyPartner#setPartnerId(Partner)}
     *   <li>{@link CompanyPartner#setPhone(String)}
     *   <li>{@link CompanyPartner#setRegistrationDate(String)}
     *   <li>{@link CompanyPartner#setShortName(String)}
     *   <li>{@link CompanyPartner#setTaxCode(String)}
     *   <li>{@link CompanyPartner#setWebsite(String)}
     *   <li>{@link CompanyPartner#getAddress()}
     *   <li>{@link CompanyPartner#getPartnerId()}
     *   <li>{@link CompanyPartner#getBusinessCode()}
     *   <li>{@link CompanyPartner#getCity()}
     *   <li>{@link CompanyPartner#getCompanyName()}
     *   <li>{@link CompanyPartner#getCompanyPartnerId()}
     *   <li>{@link CompanyPartner#getEmail()}
     *   <li>{@link CompanyPartner#getFax()}
     *   <li>{@link CompanyPartner#getIncorporationDate()}
     *   <li>{@link CompanyPartner#getPhone()}
     *   <li>{@link CompanyPartner#getRegistrationDate()}
     *   <li>{@link CompanyPartner#getShortName()}
     *   <li>{@link CompanyPartner#getTaxCode()}
     *   <li>{@link CompanyPartner#getWebsite()}
     * </ul>
     */
    @Test
    void testConstructor2() {
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

        ServiceCategory serviceCategory1 = new ServiceCategory();
        serviceCategory1.setPartnerList(new ArrayList<>());
        serviceCategory1.setServiceCategoryId(123L);
        serviceCategory1.setServiceCategoryName("Service Category Name");
        serviceCategory1.setServiceList(new ArrayList<>());

        Partner partner1 = new Partner();
        partner1.setAccountId(account3);
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
        partner1.setServiceCategoryId(serviceCategory1);
        partner1.setServiceList(new ArrayList<>());

        CompanyPartner companyPartner2 = new CompanyPartner();
        companyPartner2.setAddress("42 Main St");
        companyPartner2.setBusinessCode("Business Code");
        companyPartner2.setCity("Oxford");
        companyPartner2.setCompanyName("Company Name");
        companyPartner2.setCompanyPartnerId(123L);
        companyPartner2.setEmail("jane.doe@example.org");
        companyPartner2.setFax("Fax");
        companyPartner2.setIncorporationDate("2020-03-01");
        companyPartner2.setPartnerId(partner1);
        companyPartner2.setPhone("4105551212");
        companyPartner2.setRegistrationDate("2020-03-01");
        companyPartner2.setShortName("Short Name");
        companyPartner2.setTaxCode("Tax Code");
        companyPartner2.setWebsite("Website");

        ServiceCategory serviceCategory2 = new ServiceCategory();
        serviceCategory2.setPartnerList(new ArrayList<>());
        serviceCategory2.setServiceCategoryId(123L);
        serviceCategory2.setServiceCategoryName("Service Category Name");
        serviceCategory2.setServiceList(new ArrayList<>());

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
        partner2.setServiceCategoryId(serviceCategory2);
        partner2.setServiceList(new ArrayList<>());
        CompanyPartner actualCompanyPartner = new CompanyPartner(123L, partner2, "Company Name", "Short Name",
                "42 Main St", "Oxford", "jane.doe@example.org", "Fax", "4105551212", "Website", "Business Code", "Tax Code",
                "2020-03-01", "2020-03-01");
        actualCompanyPartner.setAddress("42 Main St");
        actualCompanyPartner.setBusinessCode("Business Code");
        actualCompanyPartner.setCity("Oxford");
        actualCompanyPartner.setCompanyName("Company Name");
        actualCompanyPartner.setCompanyPartnerId(123L);
        actualCompanyPartner.setEmail("jane.doe@example.org");
        actualCompanyPartner.setFax("Fax");
        actualCompanyPartner.setIncorporationDate("2020-03-01");
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
        ServiceCategory serviceCategory3 = new ServiceCategory();
        serviceCategory3.setPartnerList(new ArrayList<>());
        serviceCategory3.setServiceCategoryId(123L);
        serviceCategory3.setServiceCategoryName("Service Category Name");
        serviceCategory3.setServiceList(new ArrayList<>());
        Partner partner3 = new Partner();
        partner3.setAccountId(account4);
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
        partner3.setServiceCategoryId(serviceCategory3);
        partner3.setServiceList(new ArrayList<>());
        Role role1 = new Role();
        role1.setAccountList(new ArrayList<>());
        role1.setRoleId(123);
        role1.setRoleName("Role Name");
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
        User user1 = new User();
        user1.setAccountId(account5);
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
        Account account6 = new Account();
        account6.setAccountId(1234567890L);
        account6.setCommentList(new ArrayList<>());
        account6.setEmail("jane.doe@example.org");
        account6.setFeedbackList(new ArrayList<>());
        account6.setIsBlock(true);
        account6.setPartner(partner3);
        account6.setPassWord("Pass Word");
        account6.setRoleId(role1);
        account6.setTourList(new ArrayList<>());
        account6.setUser(user1);
        account6.setUserBookingList(new ArrayList<>());
        Account account7 = new Account();
        account7.setAccountId(1234567890L);
        account7.setCommentList(new ArrayList<>());
        account7.setEmail("jane.doe@example.org");
        account7.setFeedbackList(new ArrayList<>());
        account7.setIsBlock(true);
        account7.setPartner(new Partner());
        account7.setPassWord("Pass Word");
        account7.setRoleId(new Role());
        account7.setTourList(new ArrayList<>());
        account7.setUser(new User());
        account7.setUserBookingList(new ArrayList<>());
        CompanyPartner companyPartner4 = new CompanyPartner();
        companyPartner4.setAddress("42 Main St");
        companyPartner4.setBusinessCode("Business Code");
        companyPartner4.setCity("Oxford");
        companyPartner4.setCompanyName("Company Name");
        companyPartner4.setCompanyPartnerId(123L);
        companyPartner4.setEmail("jane.doe@example.org");
        companyPartner4.setFax("Fax");
        companyPartner4.setIncorporationDate("2020-03-01");
        companyPartner4.setPartnerId(new Partner());
        companyPartner4.setPhone("4105551212");
        companyPartner4.setRegistrationDate("2020-03-01");
        companyPartner4.setShortName("Short Name");
        companyPartner4.setTaxCode("Tax Code");
        companyPartner4.setWebsite("Website");
        ServiceCategory serviceCategory4 = new ServiceCategory();
        serviceCategory4.setPartnerList(new ArrayList<>());
        serviceCategory4.setServiceCategoryId(123L);
        serviceCategory4.setServiceCategoryName("Service Category Name");
        serviceCategory4.setServiceList(new ArrayList<>());
        Partner partner4 = new Partner();
        partner4.setAccountId(account7);
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
        partner4.setServiceCategoryId(serviceCategory4);
        partner4.setServiceList(new ArrayList<>());
        CompanyPartner companyPartner5 = new CompanyPartner();
        companyPartner5.setAddress("42 Main St");
        companyPartner5.setBusinessCode("Business Code");
        companyPartner5.setCity("Oxford");
        companyPartner5.setCompanyName("Company Name");
        companyPartner5.setCompanyPartnerId(123L);
        companyPartner5.setEmail("jane.doe@example.org");
        companyPartner5.setFax("Fax");
        companyPartner5.setIncorporationDate("2020-03-01");
        companyPartner5.setPartnerId(partner4);
        companyPartner5.setPhone("4105551212");
        companyPartner5.setRegistrationDate("2020-03-01");
        companyPartner5.setShortName("Short Name");
        companyPartner5.setTaxCode("Tax Code");
        companyPartner5.setWebsite("Website");
        ServiceCategory serviceCategory5 = new ServiceCategory();
        serviceCategory5.setPartnerList(new ArrayList<>());
        serviceCategory5.setServiceCategoryId(123L);
        serviceCategory5.setServiceCategoryName("Service Category Name");
        serviceCategory5.setServiceList(new ArrayList<>());
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
        partner5.setServiceCategoryId(serviceCategory5);
        partner5.setServiceList(new ArrayList<>());
        actualCompanyPartner.setPartnerId(partner5);
        actualCompanyPartner.setPhone("4105551212");
        actualCompanyPartner.setRegistrationDate("2020-03-01");
        actualCompanyPartner.setShortName("Short Name");
        actualCompanyPartner.setTaxCode("Tax Code");
        actualCompanyPartner.setWebsite("Website");
        assertEquals("42 Main St", actualCompanyPartner.getAddress());
        Partner partnerId = actualCompanyPartner.getPartnerId();
        CompanyPartner companyPartnerId = partnerId.getCompanyPartnerId();
        assertEquals("42 Main St", companyPartnerId.getAddress());
        assertEquals("Business Code", actualCompanyPartner.getBusinessCode());
        assertEquals("Business Code", companyPartnerId.getBusinessCode());
        assertEquals("Oxford", actualCompanyPartner.getCity());
        assertEquals("Oxford", companyPartnerId.getCity());
        assertEquals("Company Name", actualCompanyPartner.getCompanyName());
        assertEquals("Company Name", companyPartnerId.getCompanyName());
        assertEquals(123L, actualCompanyPartner.getCompanyPartnerId().longValue());
        assertEquals(123L, companyPartnerId.getCompanyPartnerId().longValue());
        assertEquals("jane.doe@example.org", actualCompanyPartner.getEmail());
        assertEquals("jane.doe@example.org", companyPartnerId.getEmail());
        assertEquals("Fax", actualCompanyPartner.getFax());
        assertEquals("Fax", companyPartnerId.getFax());
        assertEquals("2020-03-01", actualCompanyPartner.getIncorporationDate());
        assertEquals("2020-03-01", companyPartnerId.getIncorporationDate());
        assertSame(partner5, partnerId);
        assertSame(partner4, companyPartnerId.getPartnerId());
        assertEquals("4105551212", actualCompanyPartner.getPhone());
        assertEquals("4105551212", companyPartnerId.getPhone());
        assertEquals("2020-03-01", actualCompanyPartner.getRegistrationDate());
        assertEquals("2020-03-01", companyPartnerId.getRegistrationDate());
        assertEquals("Short Name", actualCompanyPartner.getShortName());
        assertEquals("Short Name", companyPartnerId.getShortName());
        assertEquals("Tax Code", actualCompanyPartner.getTaxCode());
        assertEquals("Tax Code", companyPartnerId.getTaxCode());
        assertEquals("Website", actualCompanyPartner.getWebsite());
        assertEquals("Website", companyPartnerId.getWebsite());
    }
}


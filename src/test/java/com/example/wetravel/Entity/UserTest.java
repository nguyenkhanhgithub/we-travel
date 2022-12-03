package com.example.wetravel.Entity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

class UserTest {
    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link User#User()}
     *   <li>{@link User#setAccountId(Account)}
     *   <li>{@link User#setAddress(String)}
     *   <li>{@link User#setBirthDate(String)}
     *   <li>{@link User#setCity(String)}
     *   <li>{@link User#setFirstName(String)}
     *   <li>{@link User#setGender(String)}
     *   <li>{@link User#setIsPrivate(Boolean)}
     *   <li>{@link User#setLastName(String)}
     *   <li>{@link User#setPhone(String)}
     *   <li>{@link User#setRankPoint(Integer)}
     *   <li>{@link User#setUserId(Long)}
     *   <li>{@link User#getAccountId()}
     *   <li>{@link User#getAddress()}
     *   <li>{@link User#getBirthDate()}
     *   <li>{@link User#getCity()}
     *   <li>{@link User#getFirstName()}
     *   <li>{@link User#getGender()}
     *   <li>{@link User#getIsPrivate()}
     *   <li>{@link User#getLastName()}
     *   <li>{@link User#getPhone()}
     *   <li>{@link User#getRankPoint()}
     *   <li>{@link User#getUserId()}
     * </ul>
     */
    @Test
    void testConstructor() {
        User actualUser = new User();
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
        CompanyPartner companyPartner = new CompanyPartner();
        companyPartner.setAddress("42 Main St");
        companyPartner.setBusinessCode("Business Code");
        companyPartner.setCity("Oxford");
        companyPartner.setCompanyName("Company Name");
        companyPartner.setCompanyPartnerId(123L);
        companyPartner.setEmail("jane.doe@example.org");
        companyPartner.setFax("Fax");
        companyPartner.setIncorporationDate("2020-03-01");
        companyPartner.setPartnerId(partner1);
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
        Partner partner2 = new Partner();
        partner2.setAccountId(account);
        partner2.setAddress("42 Main St");
        partner2.setBirthDate("2020-03-01");
        partner2.setCity("Oxford");
        partner2.setCompanyPartnerId(companyPartner);
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
        partner2.setServiceCategoryId(serviceCategory);
        partner2.setServiceList(new ArrayList<>());
        Role role1 = new Role();
        role1.setAccountList(new ArrayList<>());
        role1.setRoleId(123);
        role1.setRoleName("Role Name");
        Partner partner3 = new Partner();
        partner3.setAccountId(new Account());
        partner3.setAddress("42 Main St");
        partner3.setBirthDate("2020-03-01");
        partner3.setCity("Oxford");
        partner3.setCompanyPartnerId(new CompanyPartner());
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
        partner3.setServiceCategoryId(new ServiceCategory());
        partner3.setServiceList(new ArrayList<>());
        Role role2 = new Role();
        role2.setAccountList(new ArrayList<>());
        role2.setRoleId(123);
        role2.setRoleName("Role Name");
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
        account1.setPartner(partner3);
        account1.setPassWord("Pass Word");
        account1.setRoleId(role2);
        account1.setTourList(new ArrayList<>());
        account1.setUser(user1);
        account1.setUserBookingList(new ArrayList<>());
        User user2 = new User();
        user2.setAccountId(account1);
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
        Account account2 = new Account();
        account2.setAccountId(1234567890L);
        account2.setCommentList(new ArrayList<>());
        account2.setEmail("jane.doe@example.org");
        account2.setFeedbackList(new ArrayList<>());
        account2.setIsBlock(true);
        account2.setPartner(partner2);
        account2.setPassWord("Pass Word");
        account2.setRoleId(role1);
        account2.setTourList(new ArrayList<>());
        account2.setUser(user2);
        account2.setUserBookingList(new ArrayList<>());
        actualUser.setAccountId(account2);
        actualUser.setAddress("42 Main St");
        actualUser.setBirthDate("2020-03-01");
        actualUser.setCity("Oxford");
        actualUser.setFirstName("Jane");
        actualUser.setGender("Gender");
        actualUser.setIsPrivate(true);
        actualUser.setLastName("Doe");
        actualUser.setPhone("4105551212");
        actualUser.setRankPoint(1);
        actualUser.setUserId(123L);
        Account accountId = actualUser.getAccountId();
        assertSame(account2, accountId);
        User user3 = accountId.getUser();
        assertSame(account1, user3.getAccountId());
        assertEquals("42 Main St", actualUser.getAddress());
        assertEquals("42 Main St", user3.getAddress());
        assertEquals("2020-03-01", actualUser.getBirthDate());
        assertEquals("2020-03-01", user3.getBirthDate());
        assertEquals("Oxford", actualUser.getCity());
        assertEquals("Oxford", user3.getCity());
        assertEquals("Jane", actualUser.getFirstName());
        assertEquals("Jane", user3.getFirstName());
        assertEquals("Gender", actualUser.getGender());
        assertEquals("Gender", user3.getGender());
        assertTrue(actualUser.getIsPrivate());
        assertTrue(user3.getIsPrivate());
        assertEquals("Doe", actualUser.getLastName());
        assertEquals("Doe", user3.getLastName());
        assertEquals("4105551212", actualUser.getPhone());
        assertEquals("4105551212", user3.getPhone());
        assertEquals(1, actualUser.getRankPoint().intValue());
        assertEquals(1, user3.getRankPoint().intValue());
        assertEquals(123L, actualUser.getUserId().longValue());
        assertEquals(123L, user3.getUserId().longValue());
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link User#User(Long, Account, String, String, String, String, String, String, String, Boolean, Integer)}
     *   <li>{@link User#User()}
     *   <li>{@link User#setAccountId(Account)}
     *   <li>{@link User#setAddress(String)}
     *   <li>{@link User#setBirthDate(String)}
     *   <li>{@link User#setCity(String)}
     *   <li>{@link User#setFirstName(String)}
     *   <li>{@link User#setGender(String)}
     *   <li>{@link User#setIsPrivate(Boolean)}
     *   <li>{@link User#setLastName(String)}
     *   <li>{@link User#setPhone(String)}
     *   <li>{@link User#setRankPoint(Integer)}
     *   <li>{@link User#setUserId(Long)}
     *   <li>{@link User#getAccountId()}
     *   <li>{@link User#getAddress()}
     *   <li>{@link User#getBirthDate()}
     *   <li>{@link User#getCity()}
     *   <li>{@link User#getFirstName()}
     *   <li>{@link User#getGender()}
     *   <li>{@link User#getIsPrivate()}
     *   <li>{@link User#getLastName()}
     *   <li>{@link User#getPhone()}
     *   <li>{@link User#getRankPoint()}
     *   <li>{@link User#getUserId()}
     * </ul>
     */
    @Test
    void testConstructor2() {
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

        CompanyPartner companyPartner = new CompanyPartner();
        companyPartner.setAddress("42 Main St");
        companyPartner.setBusinessCode("Business Code");
        companyPartner.setCity("Oxford");
        companyPartner.setCompanyName("Company Name");
        companyPartner.setCompanyPartnerId(123L);
        companyPartner.setEmail("jane.doe@example.org");
        companyPartner.setFax("Fax");
        companyPartner.setIncorporationDate("2020-03-01");
        companyPartner.setPartnerId(partner1);
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

        Partner partner2 = new Partner();
        partner2.setAccountId(account);
        partner2.setAddress("42 Main St");
        partner2.setBirthDate("2020-03-01");
        partner2.setCity("Oxford");
        partner2.setCompanyPartnerId(companyPartner);
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
        partner2.setServiceCategoryId(serviceCategory);
        partner2.setServiceList(new ArrayList<>());

        Role role1 = new Role();
        role1.setAccountList(new ArrayList<>());
        role1.setRoleId(123);
        role1.setRoleName("Role Name");

        Partner partner3 = new Partner();
        partner3.setAccountId(new Account());
        partner3.setAddress("42 Main St");
        partner3.setBirthDate("2020-03-01");
        partner3.setCity("Oxford");
        partner3.setCompanyPartnerId(new CompanyPartner());
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
        partner3.setServiceCategoryId(new ServiceCategory());
        partner3.setServiceList(new ArrayList<>());

        Role role2 = new Role();
        role2.setAccountList(new ArrayList<>());
        role2.setRoleId(123);
        role2.setRoleName("Role Name");

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
        account1.setPartner(partner3);
        account1.setPassWord("Pass Word");
        account1.setRoleId(role2);
        account1.setTourList(new ArrayList<>());
        account1.setUser(user1);
        account1.setUserBookingList(new ArrayList<>());

        User user2 = new User();
        user2.setAccountId(account1);
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

        Account account2 = new Account();
        account2.setAccountId(1234567890L);
        account2.setCommentList(new ArrayList<>());
        account2.setEmail("jane.doe@example.org");
        account2.setFeedbackList(new ArrayList<>());
        account2.setIsBlock(true);
        account2.setPartner(partner2);
        account2.setPassWord("Pass Word");
        account2.setRoleId(role1);
        account2.setTourList(new ArrayList<>());
        account2.setUser(user2);
        account2.setUserBookingList(new ArrayList<>());
        User actualUser = new User(123L, account2, "Jane", "Doe", "Gender", "42 Main St", "Oxford", "2020-03-01",
                "4105551212", true, 1);
        Partner partner4 = new Partner();
        partner4.setAccountId(new Account());
        partner4.setAddress("42 Main St");
        partner4.setBirthDate("2020-03-01");
        partner4.setCity("Oxford");
        partner4.setCompanyPartnerId(new CompanyPartner());
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
        partner4.setServiceCategoryId(new ServiceCategory());
        partner4.setServiceList(new ArrayList<>());
        Role role3 = new Role();
        role3.setAccountList(new ArrayList<>());
        role3.setRoleId(123);
        role3.setRoleName("Role Name");
        User user3 = new User();
        user3.setAccountId(new Account());
        user3.setAddress("42 Main St");
        user3.setBirthDate("2020-03-01");
        user3.setCity("Oxford");
        user3.setFirstName("Jane");
        user3.setGender("Gender");
        user3.setIsPrivate(true);
        user3.setLastName("Doe");
        user3.setPhone("4105551212");
        user3.setRankPoint(1);
        user3.setUserId(123L);
        Account account3 = new Account();
        account3.setAccountId(1234567890L);
        account3.setCommentList(new ArrayList<>());
        account3.setEmail("jane.doe@example.org");
        account3.setFeedbackList(new ArrayList<>());
        account3.setIsBlock(true);
        account3.setPartner(partner4);
        account3.setPassWord("Pass Word");
        account3.setRoleId(role3);
        account3.setTourList(new ArrayList<>());
        account3.setUser(user3);
        account3.setUserBookingList(new ArrayList<>());
        Partner partner5 = new Partner();
        partner5.setAccountId(new Account());
        partner5.setAddress("42 Main St");
        partner5.setBirthDate("2020-03-01");
        partner5.setCity("Oxford");
        partner5.setCompanyPartnerId(new CompanyPartner());
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
        partner5.setServiceCategoryId(new ServiceCategory());
        partner5.setServiceList(new ArrayList<>());
        CompanyPartner companyPartner1 = new CompanyPartner();
        companyPartner1.setAddress("42 Main St");
        companyPartner1.setBusinessCode("Business Code");
        companyPartner1.setCity("Oxford");
        companyPartner1.setCompanyName("Company Name");
        companyPartner1.setCompanyPartnerId(123L);
        companyPartner1.setEmail("jane.doe@example.org");
        companyPartner1.setFax("Fax");
        companyPartner1.setIncorporationDate("2020-03-01");
        companyPartner1.setPartnerId(partner5);
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
        Partner partner6 = new Partner();
        partner6.setAccountId(account3);
        partner6.setAddress("42 Main St");
        partner6.setBirthDate("2020-03-01");
        partner6.setCity("Oxford");
        partner6.setCompanyPartnerId(companyPartner1);
        partner6.setDateIssue("2020-03-01");
        partner6.setDepartment("Department");
        partner6.setEmail("jane.doe@example.org");
        partner6.setFirstName("Jane");
        partner6.setGender("Gender");
        partner6.setLastName("Doe");
        partner6.setNumberIdCard("42");
        partner6.setPartnerId(123L);
        partner6.setPhone("4105551212");
        partner6.setPlaceIssue("Place Issue");
        partner6.setPosition("Position");
        partner6.setServiceCategoryId(serviceCategory1);
        partner6.setServiceList(new ArrayList<>());
        Role role4 = new Role();
        role4.setAccountList(new ArrayList<>());
        role4.setRoleId(123);
        role4.setRoleName("Role Name");
        Partner partner7 = new Partner();
        partner7.setAccountId(new Account());
        partner7.setAddress("42 Main St");
        partner7.setBirthDate("2020-03-01");
        partner7.setCity("Oxford");
        partner7.setCompanyPartnerId(new CompanyPartner());
        partner7.setDateIssue("2020-03-01");
        partner7.setDepartment("Department");
        partner7.setEmail("jane.doe@example.org");
        partner7.setFirstName("Jane");
        partner7.setGender("Gender");
        partner7.setLastName("Doe");
        partner7.setNumberIdCard("42");
        partner7.setPartnerId(123L);
        partner7.setPhone("4105551212");
        partner7.setPlaceIssue("Place Issue");
        partner7.setPosition("Position");
        partner7.setServiceCategoryId(new ServiceCategory());
        partner7.setServiceList(new ArrayList<>());
        Role role5 = new Role();
        role5.setAccountList(new ArrayList<>());
        role5.setRoleId(123);
        role5.setRoleName("Role Name");
        User user4 = new User();
        user4.setAccountId(new Account());
        user4.setAddress("42 Main St");
        user4.setBirthDate("2020-03-01");
        user4.setCity("Oxford");
        user4.setFirstName("Jane");
        user4.setGender("Gender");
        user4.setIsPrivate(true);
        user4.setLastName("Doe");
        user4.setPhone("4105551212");
        user4.setRankPoint(1);
        user4.setUserId(123L);
        Account account4 = new Account();
        account4.setAccountId(1234567890L);
        account4.setCommentList(new ArrayList<>());
        account4.setEmail("jane.doe@example.org");
        account4.setFeedbackList(new ArrayList<>());
        account4.setIsBlock(true);
        account4.setPartner(partner7);
        account4.setPassWord("Pass Word");
        account4.setRoleId(role5);
        account4.setTourList(new ArrayList<>());
        account4.setUser(user4);
        account4.setUserBookingList(new ArrayList<>());
        User user5 = new User();
        user5.setAccountId(account4);
        user5.setAddress("42 Main St");
        user5.setBirthDate("2020-03-01");
        user5.setCity("Oxford");
        user5.setFirstName("Jane");
        user5.setGender("Gender");
        user5.setIsPrivate(true);
        user5.setLastName("Doe");
        user5.setPhone("4105551212");
        user5.setRankPoint(1);
        user5.setUserId(123L);
        Account account5 = new Account();
        account5.setAccountId(1234567890L);
        account5.setCommentList(new ArrayList<>());
        account5.setEmail("jane.doe@example.org");
        account5.setFeedbackList(new ArrayList<>());
        account5.setIsBlock(true);
        account5.setPartner(partner6);
        account5.setPassWord("Pass Word");
        account5.setRoleId(role4);
        account5.setTourList(new ArrayList<>());
        account5.setUser(user5);
        account5.setUserBookingList(new ArrayList<>());
        actualUser.setAccountId(account5);
        actualUser.setAddress("42 Main St");
        actualUser.setBirthDate("2020-03-01");
        actualUser.setCity("Oxford");
        actualUser.setFirstName("Jane");
        actualUser.setGender("Gender");
        actualUser.setIsPrivate(true);
        actualUser.setLastName("Doe");
        actualUser.setPhone("4105551212");
        actualUser.setRankPoint(1);
        actualUser.setUserId(123L);
        Account accountId = actualUser.getAccountId();
        assertSame(account5, accountId);
        User user6 = accountId.getUser();
        assertSame(account4, user6.getAccountId());
        assertEquals("42 Main St", actualUser.getAddress());
        assertEquals("42 Main St", user6.getAddress());
        assertEquals("2020-03-01", actualUser.getBirthDate());
        assertEquals("2020-03-01", user6.getBirthDate());
        assertEquals("Oxford", actualUser.getCity());
        assertEquals("Oxford", user6.getCity());
        assertEquals("Jane", actualUser.getFirstName());
        assertEquals("Jane", user6.getFirstName());
        assertEquals("Gender", actualUser.getGender());
        assertEquals("Gender", user6.getGender());
        assertTrue(actualUser.getIsPrivate());
        assertTrue(user6.getIsPrivate());
        assertEquals("Doe", actualUser.getLastName());
        assertEquals("Doe", user6.getLastName());
        assertEquals("4105551212", actualUser.getPhone());
        assertEquals("4105551212", user6.getPhone());
        assertEquals(1, actualUser.getRankPoint().intValue());
        assertEquals(1, user6.getRankPoint().intValue());
        assertEquals(123L, actualUser.getUserId().longValue());
        assertEquals(123L, user6.getUserId().longValue());
    }
}


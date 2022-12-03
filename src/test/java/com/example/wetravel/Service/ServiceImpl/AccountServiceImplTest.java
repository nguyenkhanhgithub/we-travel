package com.example.wetravel.Service.ServiceImpl;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.example.wetravel.DTO.CustomerRegisterDTO;
import com.example.wetravel.DTO.PartnerRegisterDTO;
import com.example.wetravel.Entity.Account;
import com.example.wetravel.Entity.CompanyPartner;
import com.example.wetravel.Entity.Partner;
import com.example.wetravel.Entity.Role;
import com.example.wetravel.Entity.ServiceCategory;
import com.example.wetravel.Entity.User;
import com.example.wetravel.Exception.HandlerException;
import com.example.wetravel.Repository.AccountRepository;
import com.example.wetravel.Repository.CompanyPartnerRepository;
import com.example.wetravel.Repository.PartnerRepository;
import com.example.wetravel.Repository.RoleRepository;
import com.example.wetravel.Repository.ServiceCategoryRepository;
import com.example.wetravel.Repository.ServiceRepository;
import com.example.wetravel.Repository.UserBookingRepository;
import com.example.wetravel.Repository.UserRepository;
import com.example.wetravel.Security.JwtUtil;
import io.jsonwebtoken.impl.DefaultClaims;

import java.util.ArrayList;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {AccountServiceImpl.class})
@ExtendWith(SpringExtension.class)
class AccountServiceImplTest {
    @MockBean
    private AccountRepository accountRepository;

    @Autowired
    private AccountServiceImpl accountServiceImpl;

    @MockBean
    private CompanyPartnerRepository companyPartnerRepository;

    @MockBean
    private JwtUtil jwtUtil;

    @MockBean
    private PartnerRepository partnerRepository;

    @MockBean
    private PasswordEncoder passwordEncoder;

    @MockBean
    private RoleRepository roleRepository;

    @MockBean
    private ServiceCategoryRepository serviceCategoryRepository;

    @MockBean
    private ServiceRepository serviceRepository;

    @MockBean
    private UserBookingRepository userBookingRepository;

    @MockBean
    private UserRepository userRepository;

    /**
     * Method under test: {@link AccountServiceImpl#registerCustomerAccount(CustomerRegisterDTO)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testRegisterCustomerAccount() throws HandlerException {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at com.example.wetravel.Service.ServiceImpl.AccountServiceImpl.registerCustomerAccount(AccountServiceImpl.java:54)
        //   See https://diff.blue/R013 to resolve this issue.

        when(jwtUtil.extractAllClaims((String) any())).thenReturn(new DefaultClaims());
        accountServiceImpl.registerCustomerAccount(new CustomerRegisterDTO());
    }

    /**
     * Method under test: {@link AccountServiceImpl#registerCustomerAccount(CustomerRegisterDTO)}
     */
    @Test
    void testRegisterCustomerAccount2() throws HandlerException {
        when(accountRepository.existsAccountByEmail((String) any())).thenReturn(true);

        DefaultClaims defaultClaims = new DefaultClaims();
        defaultClaims.put("email", "42");
        when(jwtUtil.extractAllClaims((String) any())).thenReturn(defaultClaims);
        assertThrows(HandlerException.class, () -> accountServiceImpl.registerCustomerAccount(new CustomerRegisterDTO()));
        verify(accountRepository).existsAccountByEmail((String) any());
        verify(jwtUtil).extractAllClaims((String) any());
    }

    /**
     * Method under test: {@link AccountServiceImpl#registerCustomerAccount(CustomerRegisterDTO)}
     */
    @Test
    void testRegisterCustomerAccount3() throws HandlerException {
        when(accountRepository.existsAccountByEmail((String) any())).thenReturn(false);

        DefaultClaims defaultClaims = new DefaultClaims();
        defaultClaims.put("email", "42");
        when(jwtUtil.extractAllClaims((String) any())).thenReturn(defaultClaims);

        Role role = new Role();
        role.setAccountList(new ArrayList<>());
        role.setRoleId(123);
        role.setRoleName("Role Name");
        when(roleRepository.getOne((Integer) any())).thenReturn(role);

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

        Role role1 = new Role();
        role1.setAccountList(new ArrayList<>());
        role1.setRoleId(123);
        role1.setRoleName("Role Name");

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
        account.setRoleId(role1);
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

        Role role2 = new Role();
        role2.setAccountList(new ArrayList<>());
        role2.setRoleId(123);
        role2.setRoleName("Role Name");

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

        Role role3 = new Role();
        role3.setAccountList(new ArrayList<>());
        role3.setRoleId(123);
        role3.setRoleName("Role Name");

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
        account1.setRoleId(role3);
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
        account2.setRoleId(role2);
        account2.setTourList(new ArrayList<>());
        account2.setUser(user2);
        account2.setUserBookingList(new ArrayList<>());

        User user3 = new User();
        user3.setAccountId(account2);
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
        when(userRepository.save((User) any())).thenReturn(user3);
        when(passwordEncoder.encode((CharSequence) any())).thenReturn("secret");
        assertTrue(accountServiceImpl.registerCustomerAccount(new CustomerRegisterDTO()));
        verify(accountRepository).existsAccountByEmail((String) any());
        verify(jwtUtil).extractAllClaims((String) any());
        verify(roleRepository).getOne((Integer) any());
        verify(userRepository).save((User) any());
        verify(passwordEncoder).encode((CharSequence) any());
    }

    /**
     * Method under test: {@link AccountServiceImpl#registerPartnerAccount(PartnerRegisterDTO)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testRegisterPartnerAccount() throws HandlerException {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at com.example.wetravel.Service.ServiceImpl.AccountServiceImpl.registerPartnerAccount(AccountServiceImpl.java:85)
        //   See https://diff.blue/R013 to resolve this issue.

        when(jwtUtil.extractAllClaims((String) any())).thenReturn(new DefaultClaims());
        accountServiceImpl.registerPartnerAccount(new PartnerRegisterDTO());
    }

    /**
     * Method under test: {@link AccountServiceImpl#registerPartnerAccount(PartnerRegisterDTO)}
     */
    @Test
    void testRegisterPartnerAccount2() throws HandlerException {
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

        Role role1 = new Role();
        role1.setAccountList(new ArrayList<>());
        role1.setRoleId(123);
        role1.setRoleName("Role Name");

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

        Role role2 = new Role();
        role2.setAccountList(new ArrayList<>());
        role2.setRoleId(123);
        role2.setRoleName("Role Name");

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
        account6.setRoleId(role2);
        account6.setTourList(new ArrayList<>());
        account6.setUser(user1);
        account6.setUserBookingList(new ArrayList<>());

        User user2 = new User();
        user2.setAccountId(account6);
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

        Account account7 = new Account();
        account7.setAccountId(1234567890L);
        account7.setCommentList(new ArrayList<>());
        account7.setEmail("jane.doe@example.org");
        account7.setFeedbackList(new ArrayList<>());
        account7.setIsBlock(true);
        account7.setPartner(partner2);
        account7.setPassWord("Pass Word");
        account7.setRoleId(role1);
        account7.setTourList(new ArrayList<>());
        account7.setUser(user2);
        account7.setUserBookingList(new ArrayList<>());
        when(accountRepository.findByEmail((String) any())).thenReturn(account7);

        DefaultClaims defaultClaims = new DefaultClaims();
        defaultClaims.put("email", "42");
        when(jwtUtil.extractAllClaims((String) any())).thenReturn(defaultClaims);
        assertThrows(HandlerException.class, () -> accountServiceImpl.registerPartnerAccount(new PartnerRegisterDTO()));
        verify(accountRepository).findByEmail((String) any());
        verify(jwtUtil).extractAllClaims((String) any());
    }

    /**
     * Method under test: {@link AccountServiceImpl#editProfileCustomer(Long, CustomerRegisterDTO)}
     */
    @Test
    void testEditProfileCustomer() throws HandlerException {
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

        User user3 = new User();
        user3.setAccountId(account2);
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
        account3.setUser(user4);
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

        User user5 = new User();
        user5.setAccountId(new Account());
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
        account4.setUser(user5);
        account4.setUserBookingList(new ArrayList<>());

        User user6 = new User();
        user6.setAccountId(account4);
        user6.setAddress("42 Main St");
        user6.setBirthDate("2020-03-01");
        user6.setCity("Oxford");
        user6.setFirstName("Jane");
        user6.setGender("Gender");
        user6.setIsPrivate(true);
        user6.setLastName("Doe");
        user6.setPhone("4105551212");
        user6.setRankPoint(1);
        user6.setUserId(123L);

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
        account5.setUser(user6);
        account5.setUserBookingList(new ArrayList<>());

        User user7 = new User();
        user7.setAccountId(account5);
        user7.setAddress("42 Main St");
        user7.setBirthDate("2020-03-01");
        user7.setCity("Oxford");
        user7.setFirstName("Jane");
        user7.setGender("Gender");
        user7.setIsPrivate(true);
        user7.setLastName("Doe");
        user7.setPhone("4105551212");
        user7.setRankPoint(1);
        user7.setUserId(123L);
        when(userRepository.save((User) any())).thenReturn(user7);
        when(userRepository.getByAccountId_AccountId((Long) any())).thenReturn(user3);
        assertTrue(accountServiceImpl.editProfileCustomer(1234567890L, new CustomerRegisterDTO()));
        verify(userRepository).getByAccountId_AccountId((Long) any());
        verify(userRepository).save((User) any());
    }

    /**
     * Method under test: {@link AccountServiceImpl#editProfilePartner(Long, PartnerRegisterDTO)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testEditProfilePartner() throws HandlerException {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at com.example.wetravel.Service.ServiceImpl.AccountServiceImpl.editProfilePartner(AccountServiceImpl.java:151)
        //   See https://diff.blue/R013 to resolve this issue.

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

        CompanyPartner companyPartner2 = new CompanyPartner();
        companyPartner2.setAddress("42 Main St");
        companyPartner2.setBusinessCode("Business Code");
        companyPartner2.setCity("Oxford");
        companyPartner2.setCompanyName("Company Name");
        companyPartner2.setCompanyPartnerId(123L);
        companyPartner2.setEmail("jane.doe@example.org");
        companyPartner2.setFax("Fax");
        companyPartner2.setIncorporationDate("2020-03-01");
        companyPartner2.setPartnerId(partner6);
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

        Partner partner7 = new Partner();
        partner7.setAccountId(account2);
        partner7.setAddress("42 Main St");
        partner7.setBirthDate("2020-03-01");
        partner7.setCity("Oxford");
        partner7.setCompanyPartnerId(companyPartner2);
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
        partner7.setServiceCategoryId(serviceCategory2);
        partner7.setServiceList(new ArrayList<>());
        when(partnerRepository.getPartnerByAccountId_AccountId((Long) any())).thenReturn(partner7);
        accountServiceImpl.editProfilePartner(1234567890L, new PartnerRegisterDTO());
    }

    /**
     * Method under test: {@link AccountServiceImpl#blockAccount(Long)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testBlockAccount() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at com.example.wetravel.Service.ServiceImpl.AccountServiceImpl.blockAccount(AccountServiceImpl.java:185)
        //   See https://diff.blue/R013 to resolve this issue.

        (new AccountServiceImpl()).blockAccount(1234567890L);
    }

    /**
     * Method under test: {@link AccountServiceImpl#activeAccount(Long)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testActiveAccount() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at com.example.wetravel.Service.ServiceImpl.AccountServiceImpl.activeAccount(AccountServiceImpl.java:207)
        //   See https://diff.blue/R013 to resolve this issue.

        (new AccountServiceImpl()).activeAccount(1234567890L);
    }
}


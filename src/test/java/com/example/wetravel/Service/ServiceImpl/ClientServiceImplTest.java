package com.example.wetravel.Service.ServiceImpl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.example.wetravel.DTO.DataMailDTO;
import com.example.wetravel.DTO.Login;
import com.example.wetravel.Entity.Account;
import com.example.wetravel.Entity.CompanyPartner;
import com.example.wetravel.Entity.Partner;
import com.example.wetravel.Entity.Role;
import com.example.wetravel.Entity.ServiceCategory;
import com.example.wetravel.Entity.User;
import com.example.wetravel.Exception.HandlerException;
import com.example.wetravel.Repository.AccountRepository;
import com.example.wetravel.Repository.PartnerRepository;
import com.example.wetravel.Repository.UserRepository;
import com.example.wetravel.Security.JwtUtil;
import com.example.wetravel.Service.MailService;
import io.jsonwebtoken.impl.DefaultClaims;

import java.util.ArrayList;
import java.util.Map;
import javax.mail.MessagingException;

import org.junit.jupiter.api.Disabled;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {ClientServiceImpl.class})
@ExtendWith(SpringExtension.class)
class ClientServiceImplTest {
    @MockBean
    private AccountRepository accountRepository;

    @Autowired
    private ClientServiceImpl clientServiceImpl;

    @MockBean
    private JwtUtil jwtUtil;

    @MockBean
    private MailService mailService;

    @MockBean
    private PartnerRepository partnerRepository;

    @MockBean
    private PasswordEncoder passwordEncoder;

    @MockBean
    private UserRepository userRepository;

    /**
     * Method under test: {@link ClientServiceImpl#login(Login)}
     */
    @Test
    void testLogin() throws HandlerException {
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
        when(accountRepository.getAccountByEmail((String) any())).thenReturn(account7);
        assertThrows(HandlerException.class,
                () -> clientServiceImpl.login(new Login("jane.doe@example.org", "iloveyou")));
        verify(accountRepository).getAccountByEmail((String) any());
    }

    /**
     * Method under test: {@link ClientServiceImpl#createMailInfor(String, Integer, Integer)}
     */
    @Test
    void testCreateMailInfor() throws HandlerException {
        when(accountRepository.existsAccountByEmail((String) any())).thenReturn(true);
        assertEquals("Email exist!", clientServiceImpl.createMailInfor("jane.doe@example.org", 123, 123));
        verify(accountRepository).existsAccountByEmail((String) any());
    }

    /**
     * Method under test: {@link ClientServiceImpl#createMailInfor(String, Integer, Integer)}
     */
    @Test
    void testCreateMailInfor2() throws HandlerException, MessagingException {
        when(accountRepository.existsAccountByEmail((String) any())).thenReturn(false);
        when(jwtUtil.generateToken((String) any(), (Map<String, Object>) any())).thenReturn("ABC123");
        doNothing().when(mailService).sendMail((DataMailDTO) any(), (String) any());
        assertEquals("ABC123", clientServiceImpl.createMailInfor("jane.doe@example.org", 123, 123));
        verify(accountRepository).existsAccountByEmail((String) any());
        verify(jwtUtil).generateToken((String) any(), (Map<String, Object>) any());
        verify(mailService).sendMail((DataMailDTO) any(), (String) any());
    }

    /**
     * Method under test: {@link ClientServiceImpl#createMailInfor(String, Integer, Integer)}
     */
    @Test
    void testCreateMailInfor3() throws HandlerException, MessagingException {
        when(accountRepository.existsAccountByEmail((String) any())).thenReturn(false);
        when(jwtUtil.generateToken((String) any(), (Map<String, Object>) any())).thenReturn("ABC123");
        doThrow(new MessagingException()).when(mailService).sendMail((DataMailDTO) any(), (String) any());
        assertThrows(HandlerException.class, () -> clientServiceImpl.createMailInfor("jane.doe@example.org", 123, 123));
        verify(accountRepository).existsAccountByEmail((String) any());
        verify(jwtUtil).generateToken((String) any(), (Map<String, Object>) any());
        verify(mailService).sendMail((DataMailDTO) any(), (String) any());
    }

    /**
     * Method under test: {@link ClientServiceImpl#createMailInfor(String, Integer, Integer)}
     */
    @Test
    void testCreateMailInfor4() throws HandlerException, MessagingException {
        when(accountRepository.existsAccountByEmail((String) any())).thenReturn(false);
        when(jwtUtil.generateToken((String) any(), (Map<String, Object>) any())).thenReturn("ABC123");
        doNothing().when(mailService).sendMail((DataMailDTO) any(), (String) any());
        assertEquals("ABC123", clientServiceImpl.createMailInfor("jane.doe@example.org", 2, 123));
        verify(accountRepository).existsAccountByEmail((String) any());
        verify(jwtUtil).generateToken((String) any(), (Map<String, Object>) any());
        verify(mailService).sendMail((DataMailDTO) any(), (String) any());
    }

    /**
     * Method under test: {@link ClientServiceImpl#createMailForgotPassword(String)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testCreateMailForgotPassword() throws HandlerException {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at com.example.wetravel.Service.ServiceImpl.ClientServiceImpl.createMailForgotPassword(ClientServiceImpl.java:104)
        //   See https://diff.blue/R013 to resolve this issue.

        (new ClientServiceImpl()).createMailForgotPassword("jane.doe@example.org");
    }

    /**
     * Method under test: {@link ClientServiceImpl#forgotPassword(String, String)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testForgotPassword() throws HandlerException {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at com.example.wetravel.Service.ServiceImpl.ClientServiceImpl.forgotPassword(ClientServiceImpl.java:131)
        //   See https://diff.blue/R013 to resolve this issue.

        when(jwtUtil.extractAllClaims((String) any())).thenReturn(new DefaultClaims());
        clientServiceImpl.forgotPassword("ABC123", "iloveyou");
    }

    /**
     * Method under test: {@link ClientServiceImpl#changePassword(String, String, String)}
     */
    @Test
    void testChangePassword() throws HandlerException {
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
        when(accountRepository.existsAccountByEmail((String) any())).thenReturn(true);
        assertTrue(clientServiceImpl.changePassword("jane.doe@example.org", "iloveyou", "iloveyou"));
        verify(accountRepository).findByEmail((String) any());
        verify(accountRepository).existsAccountByEmail((String) any());
    }
}


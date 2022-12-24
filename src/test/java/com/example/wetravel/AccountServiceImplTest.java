package com.example.wetravel;

import com.example.wetravel.DTO.CustomerRegisterDTO;
import com.example.wetravel.DTO.PartnerRegisterDTO;
import com.example.wetravel.Entity.*;
import com.example.wetravel.Exception.HandlerException;
import com.example.wetravel.Repository.*;
import com.example.wetravel.Security.JwtUtil;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class AccountServiceImplTest {

    private AccountServiceImpl accountServiceImplUnderTest;

    @BeforeEach
    void setUp() {
        accountServiceImplUnderTest = new AccountServiceImpl();
        accountServiceImplUnderTest.accountRepository = mock(AccountRepository.class);
        accountServiceImplUnderTest.roleRepository = mock(RoleRepository.class);
        accountServiceImplUnderTest.userRepository = mock(UserRepository.class);
        accountServiceImplUnderTest.partnerRepository = mock(PartnerRepository.class);
        accountServiceImplUnderTest.companyPartnerRepository = mock(CompanyPartnerRepository.class);
        accountServiceImplUnderTest.serviceCategoryRepository = mock(ServiceCategoryRepository.class);
        accountServiceImplUnderTest.serviceRepository = mock(ServiceRepository.class);
        accountServiceImplUnderTest.userBookingRepository = mock(UserBookingRepository.class);
        accountServiceImplUnderTest.passwordEncoder = mock(PasswordEncoder.class);
        accountServiceImplUnderTest.jwtUtil = mock(JwtUtil.class);
    }

    @Test
    void testRegisterCustomerAccount() throws Exception {
        // Setup
        final CustomerRegisterDTO customerRegisterDTO = new CustomerRegisterDTO("token", "password", "firstName",
                "lastName", "gender", "birthDate", "address", "city", false, "phone");
        when(accountServiceImplUnderTest.jwtUtil.extractAllClaims("token")).thenReturn(null);
        when(accountServiceImplUnderTest.accountRepository.existsAccountByEmail("email")).thenReturn(false);

        // Configure RoleRepository.getOne(...).
        final Role role = new Role();
        role.setRoleId(0);
        role.setRoleName("roleName");
        final Account account = new Account();
        account.setAccountId(0L);
        account.setEmail("email");
        account.setPassWord("passWord");
        account.setIsBlock(false);
        final User user = new User();
        user.setUserId(0L);
        user.setFirstName("firstName");
        user.setLastName("lastName");
        user.setGender("gender");
        user.setAddress("address");
        user.setCity("city");
        user.setBirthDate("birthDate");
        account.setUser(user);
        role.setAccountList(Arrays.asList(account));
        when(accountServiceImplUnderTest.roleRepository.getOne(0)).thenReturn(role);

        when(accountServiceImplUnderTest.passwordEncoder.encode("password")).thenReturn("passWord");

        // Configure UserRepository.save(...).
        final User user1 = new User();
        user1.setUserId(0L);
        final Account accountId = new Account();
        accountId.setAccountId(0L);
        accountId.setEmail("email");
        accountId.setPassWord("passWord");
        accountId.setIsBlock(false);
        final Role roleId = new Role();
        accountId.setRoleId(roleId);
        user1.setAccountId(accountId);
        user1.setFirstName("firstName");
        user1.setLastName("lastName");
        user1.setGender("gender");
        user1.setAddress("address");
        user1.setCity("city");
        user1.setBirthDate("birthDate");
        user1.setPhone("phone");
        user1.setIsPrivate(false);
        when(accountServiceImplUnderTest.userRepository.save(any(User.class))).thenReturn(user1);

        // Run the test
        final Boolean result = accountServiceImplUnderTest.registerCustomerAccount(customerRegisterDTO);

        // Verify the results
        assertThat(result).isFalse();
        verify(accountServiceImplUnderTest.userRepository).save(any(User.class));
    }

    @Test
    void testRegisterCustomerAccount_ThrowsHandlerException() {
        // Setup
        final CustomerRegisterDTO customerRegisterDTO = new CustomerRegisterDTO("token", "password", "firstName",
                "lastName", "gender", "birthDate", "address", "city", false, "phone");
        when(accountServiceImplUnderTest.jwtUtil.extractAllClaims("token")).thenReturn(null);
        when(accountServiceImplUnderTest.accountRepository.existsAccountByEmail("email")).thenReturn(false);

        // Configure RoleRepository.getOne(...).
        final Role role = new Role();
        role.setRoleId(0);
        role.setRoleName("roleName");
        final Account account = new Account();
        account.setAccountId(0L);
        account.setEmail("email");
        account.setPassWord("passWord");
        account.setIsBlock(false);
        final User user = new User();
        user.setUserId(0L);
        user.setFirstName("firstName");
        user.setLastName("lastName");
        user.setGender("gender");
        user.setAddress("address");
        user.setCity("city");
        user.setBirthDate("birthDate");
        account.setUser(user);
        role.setAccountList(Arrays.asList(account));
        when(accountServiceImplUnderTest.roleRepository.getOne(0)).thenReturn(role);

        when(accountServiceImplUnderTest.passwordEncoder.encode("password")).thenReturn("passWord");

        // Configure UserRepository.save(...).
        final User user1 = new User();
        user1.setUserId(0L);
        final Account accountId = new Account();
        accountId.setAccountId(0L);
        accountId.setEmail("email");
        accountId.setPassWord("passWord");
        accountId.setIsBlock(false);
        final Role roleId = new Role();
        accountId.setRoleId(roleId);
        user1.setAccountId(accountId);
        user1.setFirstName("firstName");
        user1.setLastName("lastName");
        user1.setGender("gender");
        user1.setAddress("address");
        user1.setCity("city");
        user1.setBirthDate("birthDate");
        user1.setPhone("phone");
        user1.setIsPrivate(false);
        when(accountServiceImplUnderTest.userRepository.save(any(User.class))).thenReturn(user1);

        // Run the test
        assertThatThrownBy(() -> accountServiceImplUnderTest.registerCustomerAccount(customerRegisterDTO))
                .isInstanceOf(HandlerException.class);
        verify(accountServiceImplUnderTest.userRepository).save(any(User.class));
    }

    @Test
    void testRegisterPartnerAccount() throws Exception {
        // Setup
        final PartnerRegisterDTO partnerRegisterDTO = new PartnerRegisterDTO();
        partnerRegisterDTO.setToken("token");
        final Account accountInfor = new Account();
        accountInfor.setEmail("email");
        accountInfor.setPassWord("passWord");
        accountInfor.setIsBlock(false);
        final Role roleId = new Role();
        accountInfor.setRoleId(roleId);
        partnerRegisterDTO.setAccountInfor(accountInfor);
        final Partner partnerInfor = new Partner();
        partnerInfor.setPartnerId(0L);
        final Account accountId = new Account();
        accountId.setEmail("email");
        accountId.setPassWord("passWord");
        accountId.setIsBlock(false);
        final Role roleId1 = new Role();
        accountId.setRoleId(roleId1);
        partnerInfor.setAccountId(accountId);
        partnerInfor.setFirstName("firstName");
        partnerInfor.setLastName("lastName");
        partnerInfor.setGender("gender");
        partnerInfor.setAddress("address");
        partnerInfor.setCity("city");
        partnerInfor.setBirthDate("birthDate");
        partnerInfor.setPhone("phone");
        partnerInfor.setEmail("email");
        final ServiceCategory serviceCategoryId = new ServiceCategory();
        partnerInfor.setServiceCategoryId(serviceCategoryId);
        partnerInfor.setPosition("position");
        partnerInfor.setDepartment("department");
        partnerInfor.setNumberIdCard("numberIdCard");
        partnerInfor.setPlaceIssue("placeIssue");
        partnerInfor.setDateIssue("dateIssue");
        partnerRegisterDTO.setPartnerInfor(partnerInfor);
        final CompanyPartner companyPartnerInfor = new CompanyPartner();
        final Partner partnerId = new Partner();
        partnerId.setPartnerId(0L);
        final Account accountId1 = new Account();
        accountId1.setEmail("email");
        accountId1.setPassWord("passWord");
        accountId1.setIsBlock(false);
        final Role roleId2 = new Role();
        accountId1.setRoleId(roleId2);
        partnerId.setAccountId(accountId1);
        partnerId.setFirstName("firstName");
        partnerId.setLastName("lastName");
        partnerId.setGender("gender");
        partnerId.setAddress("address");
        partnerId.setCity("city");
        partnerId.setBirthDate("birthDate");
        partnerId.setPhone("phone");
        partnerId.setEmail("email");
        final ServiceCategory serviceCategoryId1 = new ServiceCategory();
        partnerId.setServiceCategoryId(serviceCategoryId1);
        partnerId.setPosition("position");
        partnerId.setDepartment("department");
        partnerId.setNumberIdCard("numberIdCard");
        partnerId.setPlaceIssue("placeIssue");
        partnerId.setDateIssue("dateIssue");
        companyPartnerInfor.setPartnerId(partnerId);
        companyPartnerInfor.setCompanyName("companyName");
        companyPartnerInfor.setShortName("shortName");
        companyPartnerInfor.setAddress("address");
        companyPartnerInfor.setCity("city");
        companyPartnerInfor.setEmail("email");
        companyPartnerInfor.setFax("fax");
        companyPartnerInfor.setPhone("phone");
        companyPartnerInfor.setWebsite("website");
        companyPartnerInfor.setBusinessCode("businessCode");
        companyPartnerInfor.setTaxCode("taxCode");
        companyPartnerInfor.setRegistrationDate("registrationDate");
        companyPartnerInfor.setIncorporationDate("incorporationDate");
        partnerRegisterDTO.setCompanyPartnerInfor(companyPartnerInfor);

        when(accountServiceImplUnderTest.jwtUtil.extractAllClaims("token")).thenReturn(null);

        // Configure AccountRepository.findByEmail(...).
        final Account account = new Account();
        account.setAccountId(0L);
        account.setEmail("email");
        account.setPassWord("passWord");
        account.setIsBlock(false);
        final Role roleId3 = new Role();
        roleId3.setRoleId(0);
        roleId3.setRoleName("roleName");
        roleId3.setAccountList(Arrays.asList(new Account()));
        account.setRoleId(roleId3);
        final User user = new User();
        user.setUserId(0L);
        user.setFirstName("firstName");
        user.setLastName("lastName");
        user.setGender("gender");
        user.setAddress("address");
        user.setCity("city");
        account.setUser(user);
        when(accountServiceImplUnderTest.accountRepository.findByEmail("mail")).thenReturn(account);

        // Configure RoleRepository.getOne(...).
        final Role role = new Role();
        role.setRoleId(0);
        role.setRoleName("roleName");
        final Account account1 = new Account();
        account1.setAccountId(0L);
        account1.setEmail("email");
        account1.setPassWord("passWord");
        account1.setIsBlock(false);
        final User user1 = new User();
        user1.setUserId(0L);
        user1.setFirstName("firstName");
        user1.setLastName("lastName");
        user1.setGender("gender");
        user1.setAddress("address");
        user1.setCity("city");
        user1.setBirthDate("birthDate");
        account1.setUser(user1);
        role.setAccountList(Arrays.asList(account1));
        when(accountServiceImplUnderTest.roleRepository.getOne(0)).thenReturn(role);

        when(accountServiceImplUnderTest.passwordEncoder.encode("passWord")).thenReturn("passWord");

        // Configure ServiceCategoryRepository.getOne(...).
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
        when(accountServiceImplUnderTest.serviceCategoryRepository.getOne(0L)).thenReturn(serviceCategory);

        // Configure CompanyPartnerRepository.save(...).
        final CompanyPartner companyPartner = new CompanyPartner();
        final Partner partnerId1 = new Partner();
        partnerId1.setPartnerId(0L);
        final Account accountId2 = new Account();
        accountId2.setEmail("email");
        accountId2.setPassWord("passWord");
        accountId2.setIsBlock(false);
        final Role roleId4 = new Role();
        accountId2.setRoleId(roleId4);
        partnerId1.setAccountId(accountId2);
        partnerId1.setFirstName("firstName");
        partnerId1.setLastName("lastName");
        partnerId1.setGender("gender");
        partnerId1.setAddress("address");
        partnerId1.setCity("city");
        partnerId1.setBirthDate("birthDate");
        partnerId1.setPhone("phone");
        partnerId1.setEmail("email");
        final ServiceCategory serviceCategoryId2 = new ServiceCategory();
        partnerId1.setServiceCategoryId(serviceCategoryId2);
        partnerId1.setPosition("position");
        partnerId1.setDepartment("department");
        partnerId1.setNumberIdCard("numberIdCard");
        partnerId1.setPlaceIssue("placeIssue");
        partnerId1.setDateIssue("dateIssue");
        companyPartner.setPartnerId(partnerId1);
        companyPartner.setCompanyName("companyName");
        companyPartner.setShortName("shortName");
        companyPartner.setAddress("address");
        companyPartner.setCity("city");
        companyPartner.setEmail("email");
        companyPartner.setFax("fax");
        companyPartner.setPhone("phone");
        companyPartner.setWebsite("website");
        companyPartner.setBusinessCode("businessCode");
        companyPartner.setTaxCode("taxCode");
        companyPartner.setRegistrationDate("registrationDate");
        companyPartner.setIncorporationDate("incorporationDate");
        when(accountServiceImplUnderTest.companyPartnerRepository.save(any(CompanyPartner.class)))
                .thenReturn(companyPartner);

        // Run the test
        final Boolean result = accountServiceImplUnderTest.registerPartnerAccount(partnerRegisterDTO);

        // Verify the results
        assertThat(result).isFalse();
        verify(accountServiceImplUnderTest.companyPartnerRepository).save(any(CompanyPartner.class));
    }

    @Test
    void testRegisterPartnerAccount_AccountRepositoryReturnsNull() throws Exception {
        // Setup
        final PartnerRegisterDTO partnerRegisterDTO = new PartnerRegisterDTO();
        partnerRegisterDTO.setToken("token");
        final Account accountInfor = new Account();
        accountInfor.setEmail("email");
        accountInfor.setPassWord("passWord");
        accountInfor.setIsBlock(false);
        final Role roleId = new Role();
        accountInfor.setRoleId(roleId);
        partnerRegisterDTO.setAccountInfor(accountInfor);
        final Partner partnerInfor = new Partner();
        partnerInfor.setPartnerId(0L);
        final Account accountId = new Account();
        accountId.setEmail("email");
        accountId.setPassWord("passWord");
        accountId.setIsBlock(false);
        final Role roleId1 = new Role();
        accountId.setRoleId(roleId1);
        partnerInfor.setAccountId(accountId);
        partnerInfor.setFirstName("firstName");
        partnerInfor.setLastName("lastName");
        partnerInfor.setGender("gender");
        partnerInfor.setAddress("address");
        partnerInfor.setCity("city");
        partnerInfor.setBirthDate("birthDate");
        partnerInfor.setPhone("phone");
        partnerInfor.setEmail("email");
        final ServiceCategory serviceCategoryId = new ServiceCategory();
        partnerInfor.setServiceCategoryId(serviceCategoryId);
        partnerInfor.setPosition("position");
        partnerInfor.setDepartment("department");
        partnerInfor.setNumberIdCard("numberIdCard");
        partnerInfor.setPlaceIssue("placeIssue");
        partnerInfor.setDateIssue("dateIssue");
        partnerRegisterDTO.setPartnerInfor(partnerInfor);
        final CompanyPartner companyPartnerInfor = new CompanyPartner();
        final Partner partnerId = new Partner();
        partnerId.setPartnerId(0L);
        final Account accountId1 = new Account();
        accountId1.setEmail("email");
        accountId1.setPassWord("passWord");
        accountId1.setIsBlock(false);
        final Role roleId2 = new Role();
        accountId1.setRoleId(roleId2);
        partnerId.setAccountId(accountId1);
        partnerId.setFirstName("firstName");
        partnerId.setLastName("lastName");
        partnerId.setGender("gender");
        partnerId.setAddress("address");
        partnerId.setCity("city");
        partnerId.setBirthDate("birthDate");
        partnerId.setPhone("phone");
        partnerId.setEmail("email");
        final ServiceCategory serviceCategoryId1 = new ServiceCategory();
        partnerId.setServiceCategoryId(serviceCategoryId1);
        partnerId.setPosition("position");
        partnerId.setDepartment("department");
        partnerId.setNumberIdCard("numberIdCard");
        partnerId.setPlaceIssue("placeIssue");
        partnerId.setDateIssue("dateIssue");
        companyPartnerInfor.setPartnerId(partnerId);
        companyPartnerInfor.setCompanyName("companyName");
        companyPartnerInfor.setShortName("shortName");
        companyPartnerInfor.setAddress("address");
        companyPartnerInfor.setCity("city");
        companyPartnerInfor.setEmail("email");
        companyPartnerInfor.setFax("fax");
        companyPartnerInfor.setPhone("phone");
        companyPartnerInfor.setWebsite("website");
        companyPartnerInfor.setBusinessCode("businessCode");
        companyPartnerInfor.setTaxCode("taxCode");
        companyPartnerInfor.setRegistrationDate("registrationDate");
        companyPartnerInfor.setIncorporationDate("incorporationDate");
        partnerRegisterDTO.setCompanyPartnerInfor(companyPartnerInfor);

        when(accountServiceImplUnderTest.jwtUtil.extractAllClaims("token")).thenReturn(null);
        when(accountServiceImplUnderTest.accountRepository.findByEmail("mail")).thenReturn(null);

        // Configure RoleRepository.getOne(...).
        final Role role = new Role();
        role.setRoleId(0);
        role.setRoleName("roleName");
        final Account account = new Account();
        account.setAccountId(0L);
        account.setEmail("email");
        account.setPassWord("passWord");
        account.setIsBlock(false);
        final User user = new User();
        user.setUserId(0L);
        user.setFirstName("firstName");
        user.setLastName("lastName");
        user.setGender("gender");
        user.setAddress("address");
        user.setCity("city");
        user.setBirthDate("birthDate");
        account.setUser(user);
        role.setAccountList(Arrays.asList(account));
        when(accountServiceImplUnderTest.roleRepository.getOne(0)).thenReturn(role);

        when(accountServiceImplUnderTest.passwordEncoder.encode("passWord")).thenReturn("passWord");

        // Configure ServiceCategoryRepository.getOne(...).
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
        when(accountServiceImplUnderTest.serviceCategoryRepository.getOne(0L)).thenReturn(serviceCategory);

        // Configure CompanyPartnerRepository.save(...).
        final CompanyPartner companyPartner = new CompanyPartner();
        final Partner partnerId1 = new Partner();
        partnerId1.setPartnerId(0L);
        final Account accountId2 = new Account();
        accountId2.setEmail("email");
        accountId2.setPassWord("passWord");
        accountId2.setIsBlock(false);
        final Role roleId3 = new Role();
        accountId2.setRoleId(roleId3);
        partnerId1.setAccountId(accountId2);
        partnerId1.setFirstName("firstName");
        partnerId1.setLastName("lastName");
        partnerId1.setGender("gender");
        partnerId1.setAddress("address");
        partnerId1.setCity("city");
        partnerId1.setBirthDate("birthDate");
        partnerId1.setPhone("phone");
        partnerId1.setEmail("email");
        final ServiceCategory serviceCategoryId2 = new ServiceCategory();
        partnerId1.setServiceCategoryId(serviceCategoryId2);
        partnerId1.setPosition("position");
        partnerId1.setDepartment("department");
        partnerId1.setNumberIdCard("numberIdCard");
        partnerId1.setPlaceIssue("placeIssue");
        partnerId1.setDateIssue("dateIssue");
        companyPartner.setPartnerId(partnerId1);
        companyPartner.setCompanyName("companyName");
        companyPartner.setShortName("shortName");
        companyPartner.setAddress("address");
        companyPartner.setCity("city");
        companyPartner.setEmail("email");
        companyPartner.setFax("fax");
        companyPartner.setPhone("phone");
        companyPartner.setWebsite("website");
        companyPartner.setBusinessCode("businessCode");
        companyPartner.setTaxCode("taxCode");
        companyPartner.setRegistrationDate("registrationDate");
        companyPartner.setIncorporationDate("incorporationDate");
        when(accountServiceImplUnderTest.companyPartnerRepository.save(any(CompanyPartner.class)))
                .thenReturn(companyPartner);

        // Run the test
        final Boolean result = accountServiceImplUnderTest.registerPartnerAccount(partnerRegisterDTO);

        // Verify the results
        assertThat(result).isTrue();
        verify(accountServiceImplUnderTest.companyPartnerRepository).save(any(CompanyPartner.class));
    }

    @Test
    void testRegisterPartnerAccount_ThrowsHandlerException() {
        // Setup
        final PartnerRegisterDTO partnerRegisterDTO = new PartnerRegisterDTO();
        partnerRegisterDTO.setToken("token");
        final Account accountInfor = new Account();
        accountInfor.setEmail("email");
        accountInfor.setPassWord("passWord");
        accountInfor.setIsBlock(false);
        final Role roleId = new Role();
        accountInfor.setRoleId(roleId);
        partnerRegisterDTO.setAccountInfor(accountInfor);
        final Partner partnerInfor = new Partner();
        partnerInfor.setPartnerId(0L);
        final Account accountId = new Account();
        accountId.setEmail("email");
        accountId.setPassWord("passWord");
        accountId.setIsBlock(false);
        final Role roleId1 = new Role();
        accountId.setRoleId(roleId1);
        partnerInfor.setAccountId(accountId);
        partnerInfor.setFirstName("firstName");
        partnerInfor.setLastName("lastName");
        partnerInfor.setGender("gender");
        partnerInfor.setAddress("address");
        partnerInfor.setCity("city");
        partnerInfor.setBirthDate("birthDate");
        partnerInfor.setPhone("phone");
        partnerInfor.setEmail("email");
        final ServiceCategory serviceCategoryId = new ServiceCategory();
        partnerInfor.setServiceCategoryId(serviceCategoryId);
        partnerInfor.setPosition("position");
        partnerInfor.setDepartment("department");
        partnerInfor.setNumberIdCard("numberIdCard");
        partnerInfor.setPlaceIssue("placeIssue");
        partnerInfor.setDateIssue("dateIssue");
        partnerRegisterDTO.setPartnerInfor(partnerInfor);
        final CompanyPartner companyPartnerInfor = new CompanyPartner();
        final Partner partnerId = new Partner();
        partnerId.setPartnerId(0L);
        final Account accountId1 = new Account();
        accountId1.setEmail("email");
        accountId1.setPassWord("passWord");
        accountId1.setIsBlock(false);
        final Role roleId2 = new Role();
        accountId1.setRoleId(roleId2);
        partnerId.setAccountId(accountId1);
        partnerId.setFirstName("firstName");
        partnerId.setLastName("lastName");
        partnerId.setGender("gender");
        partnerId.setAddress("address");
        partnerId.setCity("city");
        partnerId.setBirthDate("birthDate");
        partnerId.setPhone("phone");
        partnerId.setEmail("email");
        final ServiceCategory serviceCategoryId1 = new ServiceCategory();
        partnerId.setServiceCategoryId(serviceCategoryId1);
        partnerId.setPosition("position");
        partnerId.setDepartment("department");
        partnerId.setNumberIdCard("numberIdCard");
        partnerId.setPlaceIssue("placeIssue");
        partnerId.setDateIssue("dateIssue");
        companyPartnerInfor.setPartnerId(partnerId);
        companyPartnerInfor.setCompanyName("companyName");
        companyPartnerInfor.setShortName("shortName");
        companyPartnerInfor.setAddress("address");
        companyPartnerInfor.setCity("city");
        companyPartnerInfor.setEmail("email");
        companyPartnerInfor.setFax("fax");
        companyPartnerInfor.setPhone("phone");
        companyPartnerInfor.setWebsite("website");
        companyPartnerInfor.setBusinessCode("businessCode");
        companyPartnerInfor.setTaxCode("taxCode");
        companyPartnerInfor.setRegistrationDate("registrationDate");
        companyPartnerInfor.setIncorporationDate("incorporationDate");
        partnerRegisterDTO.setCompanyPartnerInfor(companyPartnerInfor);

        when(accountServiceImplUnderTest.jwtUtil.extractAllClaims("token")).thenReturn(null);

        // Configure AccountRepository.findByEmail(...).
        final Account account = new Account();
        account.setAccountId(0L);
        account.setEmail("email");
        account.setPassWord("passWord");
        account.setIsBlock(false);
        final Role roleId3 = new Role();
        roleId3.setRoleId(0);
        roleId3.setRoleName("roleName");
        roleId3.setAccountList(Arrays.asList(new Account()));
        account.setRoleId(roleId3);
        final User user = new User();
        user.setUserId(0L);
        user.setFirstName("firstName");
        user.setLastName("lastName");
        user.setGender("gender");
        user.setAddress("address");
        user.setCity("city");
        account.setUser(user);
        when(accountServiceImplUnderTest.accountRepository.findByEmail("mail")).thenReturn(account);

        // Configure RoleRepository.getOne(...).
        final Role role = new Role();
        role.setRoleId(0);
        role.setRoleName("roleName");
        final Account account1 = new Account();
        account1.setAccountId(0L);
        account1.setEmail("email");
        account1.setPassWord("passWord");
        account1.setIsBlock(false);
        final User user1 = new User();
        user1.setUserId(0L);
        user1.setFirstName("firstName");
        user1.setLastName("lastName");
        user1.setGender("gender");
        user1.setAddress("address");
        user1.setCity("city");
        user1.setBirthDate("birthDate");
        account1.setUser(user1);
        role.setAccountList(Arrays.asList(account1));
        when(accountServiceImplUnderTest.roleRepository.getOne(0)).thenReturn(role);

        when(accountServiceImplUnderTest.passwordEncoder.encode("passWord")).thenReturn("passWord");

        // Configure ServiceCategoryRepository.getOne(...).
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
        when(accountServiceImplUnderTest.serviceCategoryRepository.getOne(0L)).thenReturn(serviceCategory);

        // Configure CompanyPartnerRepository.save(...).
        final CompanyPartner companyPartner = new CompanyPartner();
        final Partner partnerId1 = new Partner();
        partnerId1.setPartnerId(0L);
        final Account accountId2 = new Account();
        accountId2.setEmail("email");
        accountId2.setPassWord("passWord");
        accountId2.setIsBlock(false);
        final Role roleId4 = new Role();
        accountId2.setRoleId(roleId4);
        partnerId1.setAccountId(accountId2);
        partnerId1.setFirstName("firstName");
        partnerId1.setLastName("lastName");
        partnerId1.setGender("gender");
        partnerId1.setAddress("address");
        partnerId1.setCity("city");
        partnerId1.setBirthDate("birthDate");
        partnerId1.setPhone("phone");
        partnerId1.setEmail("email");
        final ServiceCategory serviceCategoryId2 = new ServiceCategory();
        partnerId1.setServiceCategoryId(serviceCategoryId2);
        partnerId1.setPosition("position");
        partnerId1.setDepartment("department");
        partnerId1.setNumberIdCard("numberIdCard");
        partnerId1.setPlaceIssue("placeIssue");
        partnerId1.setDateIssue("dateIssue");
        companyPartner.setPartnerId(partnerId1);
        companyPartner.setCompanyName("companyName");
        companyPartner.setShortName("shortName");
        companyPartner.setAddress("address");
        companyPartner.setCity("city");
        companyPartner.setEmail("email");
        companyPartner.setFax("fax");
        companyPartner.setPhone("phone");
        companyPartner.setWebsite("website");
        companyPartner.setBusinessCode("businessCode");
        companyPartner.setTaxCode("taxCode");
        companyPartner.setRegistrationDate("registrationDate");
        companyPartner.setIncorporationDate("incorporationDate");
        when(accountServiceImplUnderTest.companyPartnerRepository.save(any(CompanyPartner.class)))
                .thenReturn(companyPartner);

        // Run the test
        assertThatThrownBy(() -> accountServiceImplUnderTest.registerPartnerAccount(partnerRegisterDTO))
                .isInstanceOf(HandlerException.class);
        verify(accountServiceImplUnderTest.companyPartnerRepository).save(any(CompanyPartner.class));
    }

    @Test
    void testEditProfileCustomer() throws Exception {
        // Setup
        final CustomerRegisterDTO customerRegisterDTO = new CustomerRegisterDTO("token", "password", "firstName",
                "lastName", "gender", "birthDate", "address", "city", false, "phone");

        // Configure UserRepository.getByAccountId_AccountId(...).
        final User user = new User();
        user.setUserId(0L);
        final Account accountId = new Account();
        accountId.setAccountId(0L);
        accountId.setEmail("email");
        accountId.setPassWord("passWord");
        accountId.setIsBlock(false);
        final Role roleId = new Role();
        accountId.setRoleId(roleId);
        user.setAccountId(accountId);
        user.setFirstName("firstName");
        user.setLastName("lastName");
        user.setGender("gender");
        user.setAddress("address");
        user.setCity("city");
        user.setBirthDate("birthDate");
        user.setPhone("phone");
        user.setIsPrivate(false);
        when(accountServiceImplUnderTest.userRepository.getByAccountId_AccountId(0L)).thenReturn(user);

        // Configure UserRepository.save(...).
        final User user1 = new User();
        user1.setUserId(0L);
        final Account accountId1 = new Account();
        accountId1.setAccountId(0L);
        accountId1.setEmail("email");
        accountId1.setPassWord("passWord");
        accountId1.setIsBlock(false);
        final Role roleId1 = new Role();
        accountId1.setRoleId(roleId1);
        user1.setAccountId(accountId1);
        user1.setFirstName("firstName");
        user1.setLastName("lastName");
        user1.setGender("gender");
        user1.setAddress("address");
        user1.setCity("city");
        user1.setBirthDate("birthDate");
        user1.setPhone("phone");
        user1.setIsPrivate(false);
        when(accountServiceImplUnderTest.userRepository.save(any(User.class))).thenReturn(user1);

        // Run the test
        final Boolean result = accountServiceImplUnderTest.editProfileCustomer(0L, customerRegisterDTO);

        // Verify the results
        assertThat(result).isFalse();
        verify(accountServiceImplUnderTest.userRepository).save(any(User.class));
    }

    @Test
    void testEditProfileCustomer_ThrowsHandlerException() {
        // Setup
        final CustomerRegisterDTO customerRegisterDTO = new CustomerRegisterDTO("token", "password", "firstName",
                "lastName", "gender", "birthDate", "address", "city", false, "phone");

        // Configure UserRepository.getByAccountId_AccountId(...).
        final User user = new User();
        user.setUserId(0L);
        final Account accountId = new Account();
        accountId.setAccountId(0L);
        accountId.setEmail("email");
        accountId.setPassWord("passWord");
        accountId.setIsBlock(false);
        final Role roleId = new Role();
        accountId.setRoleId(roleId);
        user.setAccountId(accountId);
        user.setFirstName("firstName");
        user.setLastName("lastName");
        user.setGender("gender");
        user.setAddress("address");
        user.setCity("city");
        user.setBirthDate("birthDate");
        user.setPhone("phone");
        user.setIsPrivate(false);
        when(accountServiceImplUnderTest.userRepository.getByAccountId_AccountId(0L)).thenReturn(user);

        // Configure UserRepository.save(...).
        final User user1 = new User();
        user1.setUserId(0L);
        final Account accountId1 = new Account();
        accountId1.setAccountId(0L);
        accountId1.setEmail("email");
        accountId1.setPassWord("passWord");
        accountId1.setIsBlock(false);
        final Role roleId1 = new Role();
        accountId1.setRoleId(roleId1);
        user1.setAccountId(accountId1);
        user1.setFirstName("firstName");
        user1.setLastName("lastName");
        user1.setGender("gender");
        user1.setAddress("address");
        user1.setCity("city");
        user1.setBirthDate("birthDate");
        user1.setPhone("phone");
        user1.setIsPrivate(false);
        when(accountServiceImplUnderTest.userRepository.save(any(User.class))).thenReturn(user1);

        // Run the test
        assertThatThrownBy(() -> accountServiceImplUnderTest.editProfileCustomer(0L, customerRegisterDTO))
                .isInstanceOf(HandlerException.class);
        verify(accountServiceImplUnderTest.userRepository).save(any(User.class));
    }

    @Test
    void testEditProfilePartner() throws Exception {
        // Setup
        final PartnerRegisterDTO partnerRegisterDTO = new PartnerRegisterDTO();
        partnerRegisterDTO.setToken("token");
        final Account accountInfor = new Account();
        accountInfor.setEmail("email");
        accountInfor.setPassWord("passWord");
        accountInfor.setIsBlock(false);
        final Role roleId = new Role();
        accountInfor.setRoleId(roleId);
        partnerRegisterDTO.setAccountInfor(accountInfor);
        final Partner partnerInfor = new Partner();
        partnerInfor.setPartnerId(0L);
        final Account accountId = new Account();
        accountId.setEmail("email");
        accountId.setPassWord("passWord");
        accountId.setIsBlock(false);
        final Role roleId1 = new Role();
        accountId.setRoleId(roleId1);
        partnerInfor.setAccountId(accountId);
        partnerInfor.setFirstName("firstName");
        partnerInfor.setLastName("lastName");
        partnerInfor.setGender("gender");
        partnerInfor.setAddress("address");
        partnerInfor.setCity("city");
        partnerInfor.setBirthDate("birthDate");
        partnerInfor.setPhone("phone");
        partnerInfor.setEmail("email");
        final ServiceCategory serviceCategoryId = new ServiceCategory();
        partnerInfor.setServiceCategoryId(serviceCategoryId);
        partnerInfor.setPosition("position");
        partnerInfor.setDepartment("department");
        partnerInfor.setNumberIdCard("numberIdCard");
        partnerInfor.setPlaceIssue("placeIssue");
        partnerInfor.setDateIssue("dateIssue");
        partnerRegisterDTO.setPartnerInfor(partnerInfor);
        final CompanyPartner companyPartnerInfor = new CompanyPartner();
        final Partner partnerId = new Partner();
        partnerId.setPartnerId(0L);
        final Account accountId1 = new Account();
        accountId1.setEmail("email");
        accountId1.setPassWord("passWord");
        accountId1.setIsBlock(false);
        final Role roleId2 = new Role();
        accountId1.setRoleId(roleId2);
        partnerId.setAccountId(accountId1);
        partnerId.setFirstName("firstName");
        partnerId.setLastName("lastName");
        partnerId.setGender("gender");
        partnerId.setAddress("address");
        partnerId.setCity("city");
        partnerId.setBirthDate("birthDate");
        partnerId.setPhone("phone");
        partnerId.setEmail("email");
        final ServiceCategory serviceCategoryId1 = new ServiceCategory();
        partnerId.setServiceCategoryId(serviceCategoryId1);
        partnerId.setPosition("position");
        partnerId.setDepartment("department");
        partnerId.setNumberIdCard("numberIdCard");
        partnerId.setPlaceIssue("placeIssue");
        partnerId.setDateIssue("dateIssue");
        companyPartnerInfor.setPartnerId(partnerId);
        companyPartnerInfor.setCompanyName("companyName");
        companyPartnerInfor.setShortName("shortName");
        companyPartnerInfor.setAddress("address");
        companyPartnerInfor.setCity("city");
        companyPartnerInfor.setEmail("email");
        companyPartnerInfor.setFax("fax");
        companyPartnerInfor.setPhone("phone");
        companyPartnerInfor.setWebsite("website");
        companyPartnerInfor.setBusinessCode("businessCode");
        companyPartnerInfor.setTaxCode("taxCode");
        companyPartnerInfor.setRegistrationDate("registrationDate");
        companyPartnerInfor.setIncorporationDate("incorporationDate");
        partnerRegisterDTO.setCompanyPartnerInfor(companyPartnerInfor);

        // Configure PartnerRepository.getPartnerByAccountId_AccountId(...).
        final Partner partner = new Partner();
        partner.setPartnerId(0L);
        final Account accountId2 = new Account();
        accountId2.setEmail("email");
        accountId2.setPassWord("passWord");
        accountId2.setIsBlock(false);
        final Role roleId3 = new Role();
        accountId2.setRoleId(roleId3);
        partner.setAccountId(accountId2);
        partner.setFirstName("firstName");
        partner.setLastName("lastName");
        partner.setGender("gender");
        partner.setAddress("address");
        partner.setCity("city");
        partner.setBirthDate("birthDate");
        partner.setPhone("phone");
        partner.setEmail("email");
        final ServiceCategory serviceCategoryId2 = new ServiceCategory();
        partner.setServiceCategoryId(serviceCategoryId2);
        partner.setPosition("position");
        partner.setDepartment("department");
        partner.setNumberIdCard("numberIdCard");
        partner.setPlaceIssue("placeIssue");
        partner.setDateIssue("dateIssue");
        when(accountServiceImplUnderTest.partnerRepository.getPartnerByAccountId_AccountId(0L)).thenReturn(partner);

        // Configure PartnerRepository.save(...).
        final Partner partner1 = new Partner();
        partner1.setPartnerId(0L);
        final Account accountId3 = new Account();
        accountId3.setEmail("email");
        accountId3.setPassWord("passWord");
        accountId3.setIsBlock(false);
        final Role roleId4 = new Role();
        accountId3.setRoleId(roleId4);
        partner1.setAccountId(accountId3);
        partner1.setFirstName("firstName");
        partner1.setLastName("lastName");
        partner1.setGender("gender");
        partner1.setAddress("address");
        partner1.setCity("city");
        partner1.setBirthDate("birthDate");
        partner1.setPhone("phone");
        partner1.setEmail("email");
        final ServiceCategory serviceCategoryId3 = new ServiceCategory();
        partner1.setServiceCategoryId(serviceCategoryId3);
        partner1.setPosition("position");
        partner1.setDepartment("department");
        partner1.setNumberIdCard("numberIdCard");
        partner1.setPlaceIssue("placeIssue");
        partner1.setDateIssue("dateIssue");
        when(accountServiceImplUnderTest.partnerRepository.save(any(Partner.class))).thenReturn(partner1);

        // Configure CompanyPartnerRepository.getByPartnerId_PartnerId(...).
        final CompanyPartner companyPartner = new CompanyPartner();
        final Partner partnerId1 = new Partner();
        partnerId1.setPartnerId(0L);
        final Account accountId4 = new Account();
        accountId4.setEmail("email");
        accountId4.setPassWord("passWord");
        accountId4.setIsBlock(false);
        final Role roleId5 = new Role();
        accountId4.setRoleId(roleId5);
        partnerId1.setAccountId(accountId4);
        partnerId1.setFirstName("firstName");
        partnerId1.setLastName("lastName");
        partnerId1.setGender("gender");
        partnerId1.setAddress("address");
        partnerId1.setCity("city");
        partnerId1.setBirthDate("birthDate");
        partnerId1.setPhone("phone");
        partnerId1.setEmail("email");
        final ServiceCategory serviceCategoryId4 = new ServiceCategory();
        partnerId1.setServiceCategoryId(serviceCategoryId4);
        partnerId1.setPosition("position");
        partnerId1.setDepartment("department");
        partnerId1.setNumberIdCard("numberIdCard");
        partnerId1.setPlaceIssue("placeIssue");
        partnerId1.setDateIssue("dateIssue");
        companyPartner.setPartnerId(partnerId1);
        companyPartner.setCompanyName("companyName");
        companyPartner.setShortName("shortName");
        companyPartner.setAddress("address");
        companyPartner.setCity("city");
        companyPartner.setEmail("email");
        companyPartner.setFax("fax");
        companyPartner.setPhone("phone");
        companyPartner.setWebsite("website");
        companyPartner.setBusinessCode("businessCode");
        companyPartner.setTaxCode("taxCode");
        companyPartner.setRegistrationDate("registrationDate");
        companyPartner.setIncorporationDate("incorporationDate");
        when(accountServiceImplUnderTest.companyPartnerRepository.getByPartnerId_PartnerId(0L))
                .thenReturn(companyPartner);

        // Configure CompanyPartnerRepository.save(...).
        final CompanyPartner companyPartner1 = new CompanyPartner();
        final Partner partnerId2 = new Partner();
        partnerId2.setPartnerId(0L);
        final Account accountId5 = new Account();
        accountId5.setEmail("email");
        accountId5.setPassWord("passWord");
        accountId5.setIsBlock(false);
        final Role roleId6 = new Role();
        accountId5.setRoleId(roleId6);
        partnerId2.setAccountId(accountId5);
        partnerId2.setFirstName("firstName");
        partnerId2.setLastName("lastName");
        partnerId2.setGender("gender");
        partnerId2.setAddress("address");
        partnerId2.setCity("city");
        partnerId2.setBirthDate("birthDate");
        partnerId2.setPhone("phone");
        partnerId2.setEmail("email");
        final ServiceCategory serviceCategoryId5 = new ServiceCategory();
        partnerId2.setServiceCategoryId(serviceCategoryId5);
        partnerId2.setPosition("position");
        partnerId2.setDepartment("department");
        partnerId2.setNumberIdCard("numberIdCard");
        partnerId2.setPlaceIssue("placeIssue");
        partnerId2.setDateIssue("dateIssue");
        companyPartner1.setPartnerId(partnerId2);
        companyPartner1.setCompanyName("companyName");
        companyPartner1.setShortName("shortName");
        companyPartner1.setAddress("address");
        companyPartner1.setCity("city");
        companyPartner1.setEmail("email");
        companyPartner1.setFax("fax");
        companyPartner1.setPhone("phone");
        companyPartner1.setWebsite("website");
        companyPartner1.setBusinessCode("businessCode");
        companyPartner1.setTaxCode("taxCode");
        companyPartner1.setRegistrationDate("registrationDate");
        companyPartner1.setIncorporationDate("incorporationDate");
        when(accountServiceImplUnderTest.companyPartnerRepository.save(any(CompanyPartner.class)))
                .thenReturn(companyPartner1);

        // Run the test
        final Boolean result = accountServiceImplUnderTest.editProfilePartner(0L, partnerRegisterDTO);

        // Verify the results
        assertThat(result).isFalse();
        verify(accountServiceImplUnderTest.partnerRepository).save(any(Partner.class));
        verify(accountServiceImplUnderTest.companyPartnerRepository).save(any(CompanyPartner.class));
    }

    @Test
    void testEditProfilePartner_ThrowsHandlerException() {
        // Setup
        final PartnerRegisterDTO partnerRegisterDTO = new PartnerRegisterDTO();
        partnerRegisterDTO.setToken("token");
        final Account accountInfor = new Account();
        accountInfor.setEmail("email");
        accountInfor.setPassWord("passWord");
        accountInfor.setIsBlock(false);
        final Role roleId = new Role();
        accountInfor.setRoleId(roleId);
        partnerRegisterDTO.setAccountInfor(accountInfor);
        final Partner partnerInfor = new Partner();
        partnerInfor.setPartnerId(0L);
        final Account accountId = new Account();
        accountId.setEmail("email");
        accountId.setPassWord("passWord");
        accountId.setIsBlock(false);
        final Role roleId1 = new Role();
        accountId.setRoleId(roleId1);
        partnerInfor.setAccountId(accountId);
        partnerInfor.setFirstName("firstName");
        partnerInfor.setLastName("lastName");
        partnerInfor.setGender("gender");
        partnerInfor.setAddress("address");
        partnerInfor.setCity("city");
        partnerInfor.setBirthDate("birthDate");
        partnerInfor.setPhone("phone");
        partnerInfor.setEmail("email");
        final ServiceCategory serviceCategoryId = new ServiceCategory();
        partnerInfor.setServiceCategoryId(serviceCategoryId);
        partnerInfor.setPosition("position");
        partnerInfor.setDepartment("department");
        partnerInfor.setNumberIdCard("numberIdCard");
        partnerInfor.setPlaceIssue("placeIssue");
        partnerInfor.setDateIssue("dateIssue");
        partnerRegisterDTO.setPartnerInfor(partnerInfor);
        final CompanyPartner companyPartnerInfor = new CompanyPartner();
        final Partner partnerId = new Partner();
        partnerId.setPartnerId(0L);
        final Account accountId1 = new Account();
        accountId1.setEmail("email");
        accountId1.setPassWord("passWord");
        accountId1.setIsBlock(false);
        final Role roleId2 = new Role();
        accountId1.setRoleId(roleId2);
        partnerId.setAccountId(accountId1);
        partnerId.setFirstName("firstName");
        partnerId.setLastName("lastName");
        partnerId.setGender("gender");
        partnerId.setAddress("address");
        partnerId.setCity("city");
        partnerId.setBirthDate("birthDate");
        partnerId.setPhone("phone");
        partnerId.setEmail("email");
        final ServiceCategory serviceCategoryId1 = new ServiceCategory();
        partnerId.setServiceCategoryId(serviceCategoryId1);
        partnerId.setPosition("position");
        partnerId.setDepartment("department");
        partnerId.setNumberIdCard("numberIdCard");
        partnerId.setPlaceIssue("placeIssue");
        partnerId.setDateIssue("dateIssue");
        companyPartnerInfor.setPartnerId(partnerId);
        companyPartnerInfor.setCompanyName("companyName");
        companyPartnerInfor.setShortName("shortName");
        companyPartnerInfor.setAddress("address");
        companyPartnerInfor.setCity("city");
        companyPartnerInfor.setEmail("email");
        companyPartnerInfor.setFax("fax");
        companyPartnerInfor.setPhone("phone");
        companyPartnerInfor.setWebsite("website");
        companyPartnerInfor.setBusinessCode("businessCode");
        companyPartnerInfor.setTaxCode("taxCode");
        companyPartnerInfor.setRegistrationDate("registrationDate");
        companyPartnerInfor.setIncorporationDate("incorporationDate");
        partnerRegisterDTO.setCompanyPartnerInfor(companyPartnerInfor);

        // Configure PartnerRepository.getPartnerByAccountId_AccountId(...).
        final Partner partner = new Partner();
        partner.setPartnerId(0L);
        final Account accountId2 = new Account();
        accountId2.setEmail("email");
        accountId2.setPassWord("passWord");
        accountId2.setIsBlock(false);
        final Role roleId3 = new Role();
        accountId2.setRoleId(roleId3);
        partner.setAccountId(accountId2);
        partner.setFirstName("firstName");
        partner.setLastName("lastName");
        partner.setGender("gender");
        partner.setAddress("address");
        partner.setCity("city");
        partner.setBirthDate("birthDate");
        partner.setPhone("phone");
        partner.setEmail("email");
        final ServiceCategory serviceCategoryId2 = new ServiceCategory();
        partner.setServiceCategoryId(serviceCategoryId2);
        partner.setPosition("position");
        partner.setDepartment("department");
        partner.setNumberIdCard("numberIdCard");
        partner.setPlaceIssue("placeIssue");
        partner.setDateIssue("dateIssue");
        when(accountServiceImplUnderTest.partnerRepository.getPartnerByAccountId_AccountId(0L)).thenReturn(partner);

        // Configure PartnerRepository.save(...).
        final Partner partner1 = new Partner();
        partner1.setPartnerId(0L);
        final Account accountId3 = new Account();
        accountId3.setEmail("email");
        accountId3.setPassWord("passWord");
        accountId3.setIsBlock(false);
        final Role roleId4 = new Role();
        accountId3.setRoleId(roleId4);
        partner1.setAccountId(accountId3);
        partner1.setFirstName("firstName");
        partner1.setLastName("lastName");
        partner1.setGender("gender");
        partner1.setAddress("address");
        partner1.setCity("city");
        partner1.setBirthDate("birthDate");
        partner1.setPhone("phone");
        partner1.setEmail("email");
        final ServiceCategory serviceCategoryId3 = new ServiceCategory();
        partner1.setServiceCategoryId(serviceCategoryId3);
        partner1.setPosition("position");
        partner1.setDepartment("department");
        partner1.setNumberIdCard("numberIdCard");
        partner1.setPlaceIssue("placeIssue");
        partner1.setDateIssue("dateIssue");
        when(accountServiceImplUnderTest.partnerRepository.save(any(Partner.class))).thenReturn(partner1);

        // Configure CompanyPartnerRepository.getByPartnerId_PartnerId(...).
        final CompanyPartner companyPartner = new CompanyPartner();
        final Partner partnerId1 = new Partner();
        partnerId1.setPartnerId(0L);
        final Account accountId4 = new Account();
        accountId4.setEmail("email");
        accountId4.setPassWord("passWord");
        accountId4.setIsBlock(false);
        final Role roleId5 = new Role();
        accountId4.setRoleId(roleId5);
        partnerId1.setAccountId(accountId4);
        partnerId1.setFirstName("firstName");
        partnerId1.setLastName("lastName");
        partnerId1.setGender("gender");
        partnerId1.setAddress("address");
        partnerId1.setCity("city");
        partnerId1.setBirthDate("birthDate");
        partnerId1.setPhone("phone");
        partnerId1.setEmail("email");
        final ServiceCategory serviceCategoryId4 = new ServiceCategory();
        partnerId1.setServiceCategoryId(serviceCategoryId4);
        partnerId1.setPosition("position");
        partnerId1.setDepartment("department");
        partnerId1.setNumberIdCard("numberIdCard");
        partnerId1.setPlaceIssue("placeIssue");
        partnerId1.setDateIssue("dateIssue");
        companyPartner.setPartnerId(partnerId1);
        companyPartner.setCompanyName("companyName");
        companyPartner.setShortName("shortName");
        companyPartner.setAddress("address");
        companyPartner.setCity("city");
        companyPartner.setEmail("email");
        companyPartner.setFax("fax");
        companyPartner.setPhone("phone");
        companyPartner.setWebsite("website");
        companyPartner.setBusinessCode("businessCode");
        companyPartner.setTaxCode("taxCode");
        companyPartner.setRegistrationDate("registrationDate");
        companyPartner.setIncorporationDate("incorporationDate");
        when(accountServiceImplUnderTest.companyPartnerRepository.getByPartnerId_PartnerId(0L))
                .thenReturn(companyPartner);

        // Configure CompanyPartnerRepository.save(...).
        final CompanyPartner companyPartner1 = new CompanyPartner();
        final Partner partnerId2 = new Partner();
        partnerId2.setPartnerId(0L);
        final Account accountId5 = new Account();
        accountId5.setEmail("email");
        accountId5.setPassWord("passWord");
        accountId5.setIsBlock(false);
        final Role roleId6 = new Role();
        accountId5.setRoleId(roleId6);
        partnerId2.setAccountId(accountId5);
        partnerId2.setFirstName("firstName");
        partnerId2.setLastName("lastName");
        partnerId2.setGender("gender");
        partnerId2.setAddress("address");
        partnerId2.setCity("city");
        partnerId2.setBirthDate("birthDate");
        partnerId2.setPhone("phone");
        partnerId2.setEmail("email");
        final ServiceCategory serviceCategoryId5 = new ServiceCategory();
        partnerId2.setServiceCategoryId(serviceCategoryId5);
        partnerId2.setPosition("position");
        partnerId2.setDepartment("department");
        partnerId2.setNumberIdCard("numberIdCard");
        partnerId2.setPlaceIssue("placeIssue");
        partnerId2.setDateIssue("dateIssue");
        companyPartner1.setPartnerId(partnerId2);
        companyPartner1.setCompanyName("companyName");
        companyPartner1.setShortName("shortName");
        companyPartner1.setAddress("address");
        companyPartner1.setCity("city");
        companyPartner1.setEmail("email");
        companyPartner1.setFax("fax");
        companyPartner1.setPhone("phone");
        companyPartner1.setWebsite("website");
        companyPartner1.setBusinessCode("businessCode");
        companyPartner1.setTaxCode("taxCode");
        companyPartner1.setRegistrationDate("registrationDate");
        companyPartner1.setIncorporationDate("incorporationDate");
        when(accountServiceImplUnderTest.companyPartnerRepository.save(any(CompanyPartner.class)))
                .thenReturn(companyPartner1);

        // Run the test
        assertThatThrownBy(() -> accountServiceImplUnderTest.editProfilePartner(0L, partnerRegisterDTO))
                .isInstanceOf(HandlerException.class);
        verify(accountServiceImplUnderTest.partnerRepository).save(any(Partner.class));
        verify(accountServiceImplUnderTest.companyPartnerRepository).save(any(CompanyPartner.class));
    }

    @Test
    void testBlockAccount() {
        // Setup
        // Configure AccountRepository.getById(...).
        final Account account = new Account();
        account.setAccountId(0L);
        account.setEmail("email");
        account.setPassWord("passWord");
        account.setIsBlock(false);
        final Role roleId = new Role();
        roleId.setRoleId(0);
        roleId.setRoleName("roleName");
        roleId.setAccountList(Arrays.asList(new Account()));
        account.setRoleId(roleId);
        final User user = new User();
        user.setUserId(0L);
        user.setFirstName("firstName");
        user.setLastName("lastName");
        user.setGender("gender");
        user.setAddress("address");
        user.setCity("city");
        account.setUser(user);
        when(accountServiceImplUnderTest.accountRepository.getById(0L)).thenReturn(account);

        // Configure AccountRepository.save(...).
        final Account account1 = new Account();
        account1.setAccountId(0L);
        account1.setEmail("email");
        account1.setPassWord("passWord");
        account1.setIsBlock(false);
        final Role roleId1 = new Role();
        roleId1.setRoleId(0);
        roleId1.setRoleName("roleName");
        roleId1.setAccountList(Arrays.asList(new Account()));
        account1.setRoleId(roleId1);
        final User user1 = new User();
        user1.setUserId(0L);
        user1.setFirstName("firstName");
        user1.setLastName("lastName");
        user1.setGender("gender");
        user1.setAddress("address");
        user1.setCity("city");
        account1.setUser(user1);
        when(accountServiceImplUnderTest.accountRepository.save(any(Account.class))).thenReturn(account1);

        // Configure ServiceRepository.getListServiceByAccountPartner(...).
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
        final List<Service> serviceList = Arrays.asList(service);
        when(accountServiceImplUnderTest.serviceRepository.getListServiceByAccountPartner(0L)).thenReturn(serviceList);

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
        when(accountServiceImplUnderTest.serviceRepository.save(any(Service.class))).thenReturn(service1);

        // Configure UserBookingRepository.getAllByAccountId_AccountId(...).
        final UserBooking userBooking = new UserBooking();
        userBooking.setUserBookingId(0L);
        final Account accountId = new Account();
        accountId.setAccountId(0L);
        accountId.setEmail("email");
        accountId.setPassWord("passWord");
        accountId.setIsBlock(false);
        final Role roleId2 = new Role();
        roleId2.setRoleId(0);
        roleId2.setRoleName("roleName");
        roleId2.setAccountList(Arrays.asList(new Account()));
        accountId.setRoleId(roleId2);
        final User user2 = new User();
        user2.setUserId(0L);
        user2.setFirstName("firstName");
        user2.setLastName("lastName");
        accountId.setUser(user2);
        userBooking.setAccountId(accountId);
        userBooking.setStatus(0);
        final List<UserBooking> userBookingList = Arrays.asList(userBooking);
        when(accountServiceImplUnderTest.userBookingRepository.getAllByAccountId_AccountId(0L))
                .thenReturn(userBookingList);

        // Configure UserBookingRepository.save(...).
        final UserBooking userBooking1 = new UserBooking();
        userBooking1.setUserBookingId(0L);
        final Account accountId1 = new Account();
        accountId1.setAccountId(0L);
        accountId1.setEmail("email");
        accountId1.setPassWord("passWord");
        accountId1.setIsBlock(false);
        final Role roleId3 = new Role();
        roleId3.setRoleId(0);
        roleId3.setRoleName("roleName");
        roleId3.setAccountList(Arrays.asList(new Account()));
        accountId1.setRoleId(roleId3);
        final User user3 = new User();
        user3.setUserId(0L);
        user3.setFirstName("firstName");
        user3.setLastName("lastName");
        accountId1.setUser(user3);
        userBooking1.setAccountId(accountId1);
        userBooking1.setStatus(0);
        when(accountServiceImplUnderTest.userBookingRepository.save(any(UserBooking.class))).thenReturn(userBooking1);

        // Run the test
        final Boolean result = accountServiceImplUnderTest.blockAccount(0L);

        // Verify the results
        assertThat(result).isFalse();
        verify(accountServiceImplUnderTest.accountRepository).save(any(Account.class));
        verify(accountServiceImplUnderTest.serviceRepository).save(any(Service.class));
        verify(accountServiceImplUnderTest.userBookingRepository).save(any(UserBooking.class));
    }

    @Test
    void testBlockAccount_ServiceRepositoryGetListServiceByAccountPartnerReturnsNoItems() {
        // Setup
        // Configure AccountRepository.getById(...).
        final Account account = new Account();
        account.setAccountId(0L);
        account.setEmail("email");
        account.setPassWord("passWord");
        account.setIsBlock(false);
        final Role roleId = new Role();
        roleId.setRoleId(0);
        roleId.setRoleName("roleName");
        roleId.setAccountList(Arrays.asList(new Account()));
        account.setRoleId(roleId);
        final User user = new User();
        user.setUserId(0L);
        user.setFirstName("firstName");
        user.setLastName("lastName");
        user.setGender("gender");
        user.setAddress("address");
        user.setCity("city");
        account.setUser(user);
        when(accountServiceImplUnderTest.accountRepository.getById(0L)).thenReturn(account);

        // Configure AccountRepository.save(...).
        final Account account1 = new Account();
        account1.setAccountId(0L);
        account1.setEmail("email");
        account1.setPassWord("passWord");
        account1.setIsBlock(false);
        final Role roleId1 = new Role();
        roleId1.setRoleId(0);
        roleId1.setRoleName("roleName");
        roleId1.setAccountList(Arrays.asList(new Account()));
        account1.setRoleId(roleId1);
        final User user1 = new User();
        user1.setUserId(0L);
        user1.setFirstName("firstName");
        user1.setLastName("lastName");
        user1.setGender("gender");
        user1.setAddress("address");
        user1.setCity("city");
        account1.setUser(user1);
        when(accountServiceImplUnderTest.accountRepository.save(any(Account.class))).thenReturn(account1);

        when(accountServiceImplUnderTest.serviceRepository.getListServiceByAccountPartner(0L))
                .thenReturn(Collections.emptyList());

        // Configure ServiceRepository.save(...).
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
        when(accountServiceImplUnderTest.serviceRepository.save(any(Service.class))).thenReturn(service);

        // Configure UserBookingRepository.getAllByAccountId_AccountId(...).
        final UserBooking userBooking = new UserBooking();
        userBooking.setUserBookingId(0L);
        final Account accountId = new Account();
        accountId.setAccountId(0L);
        accountId.setEmail("email");
        accountId.setPassWord("passWord");
        accountId.setIsBlock(false);
        final Role roleId2 = new Role();
        roleId2.setRoleId(0);
        roleId2.setRoleName("roleName");
        roleId2.setAccountList(Arrays.asList(new Account()));
        accountId.setRoleId(roleId2);
        final User user2 = new User();
        user2.setUserId(0L);
        user2.setFirstName("firstName");
        user2.setLastName("lastName");
        accountId.setUser(user2);
        userBooking.setAccountId(accountId);
        userBooking.setStatus(0);
        final List<UserBooking> userBookingList = Arrays.asList(userBooking);
        when(accountServiceImplUnderTest.userBookingRepository.getAllByAccountId_AccountId(0L))
                .thenReturn(userBookingList);

        // Configure UserBookingRepository.save(...).
        final UserBooking userBooking1 = new UserBooking();
        userBooking1.setUserBookingId(0L);
        final Account accountId1 = new Account();
        accountId1.setAccountId(0L);
        accountId1.setEmail("email");
        accountId1.setPassWord("passWord");
        accountId1.setIsBlock(false);
        final Role roleId3 = new Role();
        roleId3.setRoleId(0);
        roleId3.setRoleName("roleName");
        roleId3.setAccountList(Arrays.asList(new Account()));
        accountId1.setRoleId(roleId3);
        final User user3 = new User();
        user3.setUserId(0L);
        user3.setFirstName("firstName");
        user3.setLastName("lastName");
        accountId1.setUser(user3);
        userBooking1.setAccountId(accountId1);
        userBooking1.setStatus(0);
        when(accountServiceImplUnderTest.userBookingRepository.save(any(UserBooking.class))).thenReturn(userBooking1);

        // Run the test
        final Boolean result = accountServiceImplUnderTest.blockAccount(0L);

        // Verify the results
        assertThat(result).isFalse();
        verify(accountServiceImplUnderTest.accountRepository).save(any(Account.class));
        verify(accountServiceImplUnderTest.serviceRepository).save(any(Service.class));
        verify(accountServiceImplUnderTest.userBookingRepository).save(any(UserBooking.class));
    }

    @Test
    void testBlockAccount_UserBookingRepositoryGetAllByAccountId_AccountIdReturnsNoItems() {
        // Setup
        // Configure AccountRepository.getById(...).
        final Account account = new Account();
        account.setAccountId(0L);
        account.setEmail("email");
        account.setPassWord("passWord");
        account.setIsBlock(false);
        final Role roleId = new Role();
        roleId.setRoleId(0);
        roleId.setRoleName("roleName");
        roleId.setAccountList(Arrays.asList(new Account()));
        account.setRoleId(roleId);
        final User user = new User();
        user.setUserId(0L);
        user.setFirstName("firstName");
        user.setLastName("lastName");
        user.setGender("gender");
        user.setAddress("address");
        user.setCity("city");
        account.setUser(user);
        when(accountServiceImplUnderTest.accountRepository.getById(0L)).thenReturn(account);

        // Configure AccountRepository.save(...).
        final Account account1 = new Account();
        account1.setAccountId(0L);
        account1.setEmail("email");
        account1.setPassWord("passWord");
        account1.setIsBlock(false);
        final Role roleId1 = new Role();
        roleId1.setRoleId(0);
        roleId1.setRoleName("roleName");
        roleId1.setAccountList(Arrays.asList(new Account()));
        account1.setRoleId(roleId1);
        final User user1 = new User();
        user1.setUserId(0L);
        user1.setFirstName("firstName");
        user1.setLastName("lastName");
        user1.setGender("gender");
        user1.setAddress("address");
        user1.setCity("city");
        account1.setUser(user1);
        when(accountServiceImplUnderTest.accountRepository.save(any(Account.class))).thenReturn(account1);

        // Configure ServiceRepository.getListServiceByAccountPartner(...).
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
        final List<Service> serviceList = Arrays.asList(service);
        when(accountServiceImplUnderTest.serviceRepository.getListServiceByAccountPartner(0L)).thenReturn(serviceList);

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
        when(accountServiceImplUnderTest.serviceRepository.save(any(Service.class))).thenReturn(service1);

        when(accountServiceImplUnderTest.userBookingRepository.getAllByAccountId_AccountId(0L))
                .thenReturn(Collections.emptyList());

        // Run the test
        final Boolean result = accountServiceImplUnderTest.blockAccount(0L);

        // Verify the results
        assertThat(result).isTrue();
        verify(accountServiceImplUnderTest.accountRepository).save(any(Account.class));
        verify(accountServiceImplUnderTest.serviceRepository).save(any(Service.class));
    }

    @Test
    void testActiveAccount() {
        // Setup
        // Configure AccountRepository.getById(...).
        final Account account = new Account();
        account.setAccountId(0L);
        account.setEmail("email");
        account.setPassWord("passWord");
        account.setIsBlock(false);
        final Role roleId = new Role();
        roleId.setRoleId(0);
        roleId.setRoleName("roleName");
        roleId.setAccountList(Arrays.asList(new Account()));
        account.setRoleId(roleId);
        final User user = new User();
        user.setUserId(0L);
        user.setFirstName("firstName");
        user.setLastName("lastName");
        user.setGender("gender");
        user.setAddress("address");
        user.setCity("city");
        account.setUser(user);
        when(accountServiceImplUnderTest.accountRepository.getById(0L)).thenReturn(account);

        // Configure AccountRepository.save(...).
        final Account account1 = new Account();
        account1.setAccountId(0L);
        account1.setEmail("email");
        account1.setPassWord("passWord");
        account1.setIsBlock(false);
        final Role roleId1 = new Role();
        roleId1.setRoleId(0);
        roleId1.setRoleName("roleName");
        roleId1.setAccountList(Arrays.asList(new Account()));
        account1.setRoleId(roleId1);
        final User user1 = new User();
        user1.setUserId(0L);
        user1.setFirstName("firstName");
        user1.setLastName("lastName");
        user1.setGender("gender");
        user1.setAddress("address");
        user1.setCity("city");
        account1.setUser(user1);
        when(accountServiceImplUnderTest.accountRepository.save(any(Account.class))).thenReturn(account1);

        // Configure ServiceRepository.getListServiceByAccountPartner(...).
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
        final List<Service> serviceList = Arrays.asList(service);
        when(accountServiceImplUnderTest.serviceRepository.getListServiceByAccountPartner(0L)).thenReturn(serviceList);

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
        when(accountServiceImplUnderTest.serviceRepository.save(any(Service.class))).thenReturn(service1);

        // Run the test
        final Boolean result = accountServiceImplUnderTest.activeAccount(0L);

        // Verify the results
        assertThat(result).isFalse();
        verify(accountServiceImplUnderTest.accountRepository).save(any(Account.class));
        verify(accountServiceImplUnderTest.serviceRepository).save(any(Service.class));
    }

    @Test
    void testActiveAccount_ServiceRepositoryGetListServiceByAccountPartnerReturnsNoItems() {
        // Setup
        // Configure AccountRepository.getById(...).
        final Account account = new Account();
        account.setAccountId(0L);
        account.setEmail("email");
        account.setPassWord("passWord");
        account.setIsBlock(false);
        final Role roleId = new Role();
        roleId.setRoleId(0);
        roleId.setRoleName("roleName");
        roleId.setAccountList(Arrays.asList(new Account()));
        account.setRoleId(roleId);
        final User user = new User();
        user.setUserId(0L);
        user.setFirstName("firstName");
        user.setLastName("lastName");
        user.setGender("gender");
        user.setAddress("address");
        user.setCity("city");
        account.setUser(user);
        when(accountServiceImplUnderTest.accountRepository.getById(0L)).thenReturn(account);

        // Configure AccountRepository.save(...).
        final Account account1 = new Account();
        account1.setAccountId(0L);
        account1.setEmail("email");
        account1.setPassWord("passWord");
        account1.setIsBlock(false);
        final Role roleId1 = new Role();
        roleId1.setRoleId(0);
        roleId1.setRoleName("roleName");
        roleId1.setAccountList(Arrays.asList(new Account()));
        account1.setRoleId(roleId1);
        final User user1 = new User();
        user1.setUserId(0L);
        user1.setFirstName("firstName");
        user1.setLastName("lastName");
        user1.setGender("gender");
        user1.setAddress("address");
        user1.setCity("city");
        account1.setUser(user1);
        when(accountServiceImplUnderTest.accountRepository.save(any(Account.class))).thenReturn(account1);

        when(accountServiceImplUnderTest.serviceRepository.getListServiceByAccountPartner(0L))
                .thenReturn(Collections.emptyList());

        // Run the test
        final Boolean result = accountServiceImplUnderTest.activeAccount(0L);

        // Verify the results
        assertThat(result).isTrue();
        verify(accountServiceImplUnderTest.accountRepository).save(any(Account.class));
    }
}

package com.example.wetravel;

import com.example.wetravel.DTO.AlertDTO;
import com.example.wetravel.Entity.Account;
import com.example.wetravel.Entity.Alert;
import com.example.wetravel.Entity.Role;
import com.example.wetravel.Entity.User;
import com.example.wetravel.Exception.HandlerException;
import com.example.wetravel.Repository.AccountRepository;
import com.example.wetravel.Repository.AlertRepository;
import com.example.wetravel.Service.ServiceImpl.AlertServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class AlertServiceImplTest {

    private AlertServiceImpl alertServiceImplUnderTest;

    @BeforeEach
    void setUp() throws Exception {
        alertServiceImplUnderTest = new AlertServiceImpl();
        alertServiceImplUnderTest.accountRepository = mock(AccountRepository.class);
        alertServiceImplUnderTest.alertRepository = mock(AlertRepository.class);
    }

    @Test
    void testCreateAlert() throws Exception {
        // Setup
        final AlertDTO alertDTO = new AlertDTO(0L, 0L, "title", "content", false,
                LocalDateTime.of(2020, 1, 1, 0, 0, 0));

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
        when(alertServiceImplUnderTest.accountRepository.getById(0L)).thenReturn(account);

        // Configure AlertRepository.save(...).
        final Alert alert = new Alert();
        alert.setAlertId(0L);
        final Account accountId = new Account();
        accountId.setAccountId(0L);
        accountId.setEmail("email");
        accountId.setPassWord("passWord");
        accountId.setIsBlock(false);
        final Role roleId1 = new Role();
        roleId1.setRoleId(0);
        roleId1.setRoleName("roleName");
        roleId1.setAccountList(Arrays.asList(new Account()));
        accountId.setRoleId(roleId1);
        final User user1 = new User();
        accountId.setUser(user1);
        alert.setAccountId(accountId);
        alert.setTitle("title");
        alert.setContent("content");
        alert.setStatus(false);
        alert.setCreateDate(LocalDateTime.of(2020, 1, 1, 0, 0, 0));
        when(alertServiceImplUnderTest.alertRepository.save(any(Alert.class))).thenReturn(alert);

        // Run the test
        final AlertDTO result = alertServiceImplUnderTest.createAlert(alertDTO);

        // Verify the results
        verify(alertServiceImplUnderTest.alertRepository).save(any(Alert.class));
    }

    @Test
    void testCreateAlert_ThrowsHandlerException() {
        // Setup
        final AlertDTO alertDTO = new AlertDTO(0L, 0L, "title", "content", false,
                LocalDateTime.of(2020, 1, 1, 0, 0, 0));

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
        when(alertServiceImplUnderTest.accountRepository.getById(0L)).thenReturn(account);

        // Configure AlertRepository.save(...).
        final Alert alert = new Alert();
        alert.setAlertId(0L);
        final Account accountId = new Account();
        accountId.setAccountId(0L);
        accountId.setEmail("email");
        accountId.setPassWord("passWord");
        accountId.setIsBlock(false);
        final Role roleId1 = new Role();
        roleId1.setRoleId(0);
        roleId1.setRoleName("roleName");
        roleId1.setAccountList(Arrays.asList(new Account()));
        accountId.setRoleId(roleId1);
        final User user1 = new User();
        accountId.setUser(user1);
        alert.setAccountId(accountId);
        alert.setTitle("title");
        alert.setContent("content");
        alert.setStatus(false);
        alert.setCreateDate(LocalDateTime.of(2020, 1, 1, 0, 0, 0));
        when(alertServiceImplUnderTest.alertRepository.save(any(Alert.class))).thenReturn(alert);

        // Run the test
        assertThatThrownBy(() -> alertServiceImplUnderTest.createAlert(alertDTO)).isInstanceOf(HandlerException.class);
        verify(alertServiceImplUnderTest.alertRepository).save(any(Alert.class));
    }

    @Test
    void testGetListAlertByAccountId() throws Exception {
        // Setup
        // Configure AlertRepository.getAllByAccountId_AccountIdOrderByCreateDateDesc(...).
        final Alert alert = new Alert();
        alert.setAlertId(0L);
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
        accountId.setUser(user);
        alert.setAccountId(accountId);
        alert.setTitle("title");
        alert.setContent("content");
        alert.setStatus(false);
        alert.setCreateDate(LocalDateTime.of(2020, 1, 1, 0, 0, 0));
        final List<Alert> alertList = Arrays.asList(alert);
        when(alertServiceImplUnderTest.alertRepository.getAllByAccountId_AccountIdOrderByCreateDateDesc(0L))
                .thenReturn(alertList);

        // Run the test
        final List<AlertDTO> result = alertServiceImplUnderTest.getListAlertByAccountId(0L);

        // Verify the results
    }

    @Test
    void testGetListAlertByAccountId_AlertRepositoryReturnsNoItems() {
        // Setup
        when(alertServiceImplUnderTest.alertRepository.getAllByAccountId_AccountIdOrderByCreateDateDesc(0L))
                .thenReturn(Collections.emptyList());

        // Run the test
        assertThatThrownBy(() -> alertServiceImplUnderTest.getListAlertByAccountId(0L))
                .isInstanceOf(HandlerException.class);
    }

    @Test
    void testGetListAlertByAccountId_ThrowsHandlerException() {
        // Setup
        // Configure AlertRepository.getAllByAccountId_AccountIdOrderByCreateDateDesc(...).
        final Alert alert = new Alert();
        alert.setAlertId(0L);
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
        accountId.setUser(user);
        alert.setAccountId(accountId);
        alert.setTitle("title");
        alert.setContent("content");
        alert.setStatus(false);
        alert.setCreateDate(LocalDateTime.of(2020, 1, 1, 0, 0, 0));
        final List<Alert> alertList = Arrays.asList(alert);
        when(alertServiceImplUnderTest.alertRepository.getAllByAccountId_AccountIdOrderByCreateDateDesc(0L))
                .thenReturn(alertList);

        // Run the test
        assertThatThrownBy(() -> alertServiceImplUnderTest.getListAlertByAccountId(0L))
                .isInstanceOf(HandlerException.class);
    }

    @Test
    void testSeenAlert() throws Exception {
        // Setup
        when(alertServiceImplUnderTest.alertRepository.existsAlertByAlertId(0L)).thenReturn(false);

        // Configure AlertRepository.getById(...).
        final Alert alert = new Alert();
        alert.setAlertId(0L);
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
        accountId.setUser(user);
        alert.setAccountId(accountId);
        alert.setTitle("title");
        alert.setContent("content");
        alert.setStatus(false);
        alert.setCreateDate(LocalDateTime.of(2020, 1, 1, 0, 0, 0));
        when(alertServiceImplUnderTest.alertRepository.getById(0L)).thenReturn(alert);

        // Configure AlertRepository.save(...).
        final Alert alert1 = new Alert();
        alert1.setAlertId(0L);
        final Account accountId1 = new Account();
        accountId1.setAccountId(0L);
        accountId1.setEmail("email");
        accountId1.setPassWord("passWord");
        accountId1.setIsBlock(false);
        final Role roleId1 = new Role();
        roleId1.setRoleId(0);
        roleId1.setRoleName("roleName");
        roleId1.setAccountList(Arrays.asList(new Account()));
        accountId1.setRoleId(roleId1);
        final User user1 = new User();
        accountId1.setUser(user1);
        alert1.setAccountId(accountId1);
        alert1.setTitle("title");
        alert1.setContent("content");
        alert1.setStatus(false);
        alert1.setCreateDate(LocalDateTime.of(2020, 1, 1, 0, 0, 0));
        when(alertServiceImplUnderTest.alertRepository.save(any(Alert.class))).thenReturn(alert1);

        // Run the test
        final Boolean result = alertServiceImplUnderTest.seenAlert(0L);

        // Verify the results
        assertThat(result).isFalse();
        verify(alertServiceImplUnderTest.alertRepository).save(any(Alert.class));
    }

    @Test
    void testSeenAlert_ThrowsHandlerException() {
        // Setup
        when(alertServiceImplUnderTest.alertRepository.existsAlertByAlertId(0L)).thenReturn(false);

        // Configure AlertRepository.getById(...).
        final Alert alert = new Alert();
        alert.setAlertId(0L);
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
        accountId.setUser(user);
        alert.setAccountId(accountId);
        alert.setTitle("title");
        alert.setContent("content");
        alert.setStatus(false);
        alert.setCreateDate(LocalDateTime.of(2020, 1, 1, 0, 0, 0));
        when(alertServiceImplUnderTest.alertRepository.getById(0L)).thenReturn(alert);

        // Configure AlertRepository.save(...).
        final Alert alert1 = new Alert();
        alert1.setAlertId(0L);
        final Account accountId1 = new Account();
        accountId1.setAccountId(0L);
        accountId1.setEmail("email");
        accountId1.setPassWord("passWord");
        accountId1.setIsBlock(false);
        final Role roleId1 = new Role();
        roleId1.setRoleId(0);
        roleId1.setRoleName("roleName");
        roleId1.setAccountList(Arrays.asList(new Account()));
        accountId1.setRoleId(roleId1);
        final User user1 = new User();
        accountId1.setUser(user1);
        alert1.setAccountId(accountId1);
        alert1.setTitle("title");
        alert1.setContent("content");
        alert1.setStatus(false);
        alert1.setCreateDate(LocalDateTime.of(2020, 1, 1, 0, 0, 0));
        when(alertServiceImplUnderTest.alertRepository.save(any(Alert.class))).thenReturn(alert1);

        // Run the test
        assertThatThrownBy(() -> alertServiceImplUnderTest.seenAlert(0L)).isInstanceOf(HandlerException.class);
        verify(alertServiceImplUnderTest.alertRepository).save(any(Alert.class));
    }
}

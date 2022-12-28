package com.example.wetravel;

import com.example.wetravel.DTO.UserDTO;
import com.example.wetravel.Exception.HandlerException;
import com.example.wetravel.Repository.UserRepository;
import com.example.wetravel.Service.ServiceImpl.UserServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.util.Arrays;
import java.util.Collections;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class UserServiceImplTest {

    private UserServiceImpl userServiceImplUnderTest;

    @BeforeEach
    void setUp() throws Exception {
        userServiceImplUnderTest = new UserServiceImpl();
        userServiceImplUnderTest.userRepository = mock(UserRepository.class);
    }

    @Test
    void testGetListUser() throws Exception {
        // Setup
        when(userServiceImplUnderTest.userRepository.getListUser(""  , "",any(Pageable.class)))
                .thenReturn(new PageImpl<>(Arrays.asList()));

        // Run the test
        final Page<UserDTO> result = userServiceImplUnderTest.getListUser("",0, 0);

        // Verify the results
    }

    @Test
    void testGetListUser_UserRepositoryReturnsNoItems() throws Exception {
        // Setup
        when(userServiceImplUnderTest.userRepository.getListUser("", "",any(Pageable.class)))
                .thenReturn(new PageImpl<>(Collections.emptyList()));

        // Run the test
        final Page<UserDTO> result = userServiceImplUnderTest.getListUser("",0, 0);

        // Verify the results
    }

    @Test
    void testGetListUser_ThrowsHandlerException() {
        // Setup
        when(userServiceImplUnderTest.userRepository.getListUser("" , "" , any(Pageable.class)))
                .thenReturn(new PageImpl<>(Arrays.asList()));

        // Run the test
        assertThatThrownBy(() -> userServiceImplUnderTest.getListUser("", 0, 0)).isInstanceOf(HandlerException.class);
    }

    @Test
    void testGetDetailUser() throws Exception {
        // Setup
        when(userServiceImplUnderTest.userRepository.existsByAccountId_AccountId(0L)).thenReturn(false);
        when(userServiceImplUnderTest.userRepository.getDetailUser(0L)).thenReturn(null);

        // Run the test
        final UserDTO result = userServiceImplUnderTest.getDetailUser(0L);

        // Verify the results
    }

    @Test
    void testGetDetailUser_ThrowsHandlerException() {
        // Setup
        when(userServiceImplUnderTest.userRepository.existsByAccountId_AccountId(0L)).thenReturn(false);
        when(userServiceImplUnderTest.userRepository.getDetailUser(0L)).thenReturn(null);

        // Run the test
        assertThatThrownBy(() -> userServiceImplUnderTest.getDetailUser(0L)).isInstanceOf(HandlerException.class);
    }
}

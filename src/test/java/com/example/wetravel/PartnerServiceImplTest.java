package com.example.wetravel;

import com.example.wetravel.DTO.PartnerDTO;
import com.example.wetravel.Exception.HandlerException;
import com.example.wetravel.Repository.PartnerRepository;
import com.example.wetravel.Service.ServiceImpl.PartnerServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.util.Arrays;
import java.util.Collections;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class PartnerServiceImplTest {

    private PartnerServiceImpl partnerServiceImplUnderTest;

    @BeforeEach
    void setUp() throws Exception {
        partnerServiceImplUnderTest = new PartnerServiceImpl();
        partnerServiceImplUnderTest.partnerRepository = mock(PartnerRepository.class);
    }

    @Test
    void testGetListPartner() throws Exception {
        // Setup
        when(partnerServiceImplUnderTest.partnerRepository.getAllPartner(eq("emailPartner"), eq("all"), eq(0), eq(0),
                any(Pageable.class))).thenReturn(new PageImpl<>(Arrays.asList()));

        // Run the test
        final Page<PartnerDTO> result = partnerServiceImplUnderTest.getListPartner("emailPartner", 0, 0, 0, 0);

        // Verify the results
    }

    @Test
    void testGetListPartner_PartnerRepositoryReturnsNoItems() throws Exception {
        // Setup
        when(partnerServiceImplUnderTest.partnerRepository.getAllPartner(eq("emailPartner"), eq("all"), eq(0), eq(0),
                any(Pageable.class))).thenReturn(new PageImpl<>(Collections.emptyList()));

        // Run the test
        final Page<PartnerDTO> result = partnerServiceImplUnderTest.getListPartner("emailPartner", 0, 0, 0, 0);

        // Verify the results
    }

    @Test
    void testGetListPartner_ThrowsHandlerException() {
        // Setup
        when(partnerServiceImplUnderTest.partnerRepository.getAllPartner(eq("emailPartner"), eq("all"), eq(0), eq(0),
                any(Pageable.class))).thenReturn(new PageImpl<>(Arrays.asList()));

        // Run the test
        assertThatThrownBy(() -> partnerServiceImplUnderTest.getListPartner("emailPartner", 0, 0, 0, 0))
                .isInstanceOf(HandlerException.class);
    }

    @Test
    void testGetDetailPartner() throws Exception {
        // Setup
        when(partnerServiceImplUnderTest.partnerRepository.existsByAccountId_AccountId(0L)).thenReturn(false);
        when(partnerServiceImplUnderTest.partnerRepository.getDetailPartner(0L)).thenReturn(null);

        // Run the test
        final PartnerDTO result = partnerServiceImplUnderTest.getDetailPartner(0L);

        // Verify the results
    }

    @Test
    void testGetDetailPartner_ThrowsHandlerException() {
        // Setup
        when(partnerServiceImplUnderTest.partnerRepository.existsByAccountId_AccountId(0L)).thenReturn(false);
        when(partnerServiceImplUnderTest.partnerRepository.getDetailPartner(0L)).thenReturn(null);

        // Run the test
        assertThatThrownBy(() -> partnerServiceImplUnderTest.getDetailPartner(0L)).isInstanceOf(HandlerException.class);
    }
}

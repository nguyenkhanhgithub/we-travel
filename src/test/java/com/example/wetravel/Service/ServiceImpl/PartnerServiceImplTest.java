package com.example.wetravel.Service.ServiceImpl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.example.wetravel.DTO.PartnerDTO;
import com.example.wetravel.Exception.HandlerException;
import com.example.wetravel.Repository.PartnerRepository;

import java.util.ArrayList;

import org.junit.jupiter.api.Disabled;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {PartnerServiceImpl.class})
@ExtendWith(SpringExtension.class)
class PartnerServiceImplTest {
    @MockBean
    private PartnerRepository partnerRepository;

    @Autowired
    private PartnerServiceImpl partnerServiceImpl;

    /**
     * Method under test: {@link PartnerServiceImpl#getListPartner(String, Integer, Integer, Integer, Integer)}
     */
    @Test
    void testGetListPartner() throws HandlerException {
        when(partnerRepository.getAllPartner((String) any(), (String) any(), (Integer) any(), (Integer) any(),
                (Pageable) any())).thenReturn(new PageImpl<>(new ArrayList<>()));
        assertThrows(HandlerException.class,
                () -> partnerServiceImpl.getListPartner("jane.doe@example.org", 123, 1, 1, 3));
        verify(partnerRepository).getAllPartner((String) any(), (String) any(), (Integer) any(), (Integer) any(),
                (Pageable) any());
    }

    /**
     * Method under test: {@link PartnerServiceImpl#getListPartner(String, Integer, Integer, Integer, Integer)}
     */
    @Test
    void testGetListPartner2() throws HandlerException {
        ArrayList<PartnerDTO> partnerDTOList = new ArrayList<>();
        partnerDTOList.add(null);
        PageImpl<PartnerDTO> pageImpl = new PageImpl<>(partnerDTOList);
        when(partnerRepository.getAllPartner((String) any(), (String) any(), (Integer) any(), (Integer) any(),
                (Pageable) any())).thenReturn(pageImpl);
        Page<PartnerDTO> actualListPartner = partnerServiceImpl.getListPartner("jane.doe@example.org", 123, 1, 1, 3);
        assertSame(pageImpl, actualListPartner);
        assertEquals(1, actualListPartner.toList().size());
        verify(partnerRepository).getAllPartner((String) any(), (String) any(), (Integer) any(), (Integer) any(),
                (Pageable) any());
    }

    /**
     * Method under test: {@link PartnerServiceImpl#getListPartner(String, Integer, Integer, Integer, Integer)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testGetListPartner3() throws HandlerException {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at com.example.wetravel.Service.ServiceImpl.PartnerServiceImpl.getListPartner(PartnerServiceImpl.java:23)
        //   See https://diff.blue/R013 to resolve this issue.

        when(partnerRepository.getAllPartner((String) any(), (String) any(), (Integer) any(), (Integer) any(),
                (Pageable) any())).thenReturn(null);
        partnerServiceImpl.getListPartner("jane.doe@example.org", 123, 1, 1, 3);
    }

    /**
     * Method under test: {@link PartnerServiceImpl#getListPartner(String, Integer, Integer, Integer, Integer)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testGetListPartner4() throws HandlerException {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.IllegalArgumentException: Page index must not be less than zero!
        //       at com.example.wetravel.Service.ServiceImpl.PartnerServiceImpl.getListPartner(PartnerServiceImpl.java:21)
        //   See https://diff.blue/R013 to resolve this issue.

        when(partnerRepository.getAllPartner((String) any(), (String) any(), (Integer) any(), (Integer) any(),
                (Pageable) any())).thenReturn(new PageImpl<>(new ArrayList<>()));
        partnerServiceImpl.getListPartner("jane.doe@example.org", 123, 1, 0, 3);
    }

    /**
     * Method under test: {@link PartnerServiceImpl#getDetailPartner(Long)}
     */
    @Test
    void testGetDetailPartner() throws HandlerException {
        when(partnerRepository.getDetailPartner((Long) any())).thenReturn(null);
        when(partnerRepository.existsByAccountId_AccountId((Long) any())).thenReturn(true);
        assertNull(partnerServiceImpl.getDetailPartner(1234567890L));
        verify(partnerRepository).getDetailPartner((Long) any());
        verify(partnerRepository).existsByAccountId_AccountId((Long) any());
    }

    /**
     * Method under test: {@link PartnerServiceImpl#getDetailPartner(Long)}
     */
    @Test
    void testGetDetailPartner2() throws HandlerException {
        when(partnerRepository.getDetailPartner((Long) any())).thenReturn(null);
        when(partnerRepository.existsByAccountId_AccountId((Long) any())).thenReturn(false);
        assertThrows(HandlerException.class, () -> partnerServiceImpl.getDetailPartner(1234567890L));
        verify(partnerRepository).existsByAccountId_AccountId((Long) any());
    }
}


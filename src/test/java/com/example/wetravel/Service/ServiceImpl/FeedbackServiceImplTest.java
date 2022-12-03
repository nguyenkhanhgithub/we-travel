package com.example.wetravel.Service.ServiceImpl;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.example.wetravel.DTO.FeedbackDTO;
import com.example.wetravel.DTO.ReportFeedbackDTO;
import com.example.wetravel.Exception.HandlerException;
import com.example.wetravel.Repository.AccountRepository;
import com.example.wetravel.Repository.FeedbackRepository;
import com.example.wetravel.Repository.PartnerRepository;
import com.example.wetravel.Repository.ReasonReportFeedbackRepository;
import com.example.wetravel.Repository.ReportFeedbackRepository;
import com.example.wetravel.Repository.TourRepository;
import com.example.wetravel.Repository.UserBookingRepository;
import com.example.wetravel.Repository.UserRepository;

import java.util.ArrayList;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {FeedbackServiceImpl.class})
@ExtendWith(SpringExtension.class)
class FeedbackServiceImplTest {
    @MockBean
    private AccountRepository accountRepository;

    @MockBean
    private FeedbackRepository feedbackRepository;

    @Autowired
    private FeedbackServiceImpl feedbackServiceImpl;

    @MockBean
    private PartnerRepository partnerRepository;

    @MockBean
    private ReasonReportFeedbackRepository reasonReportFeedbackRepository;

    @MockBean
    private ReportFeedbackRepository reportFeedbackRepository;

    @MockBean
    private TourRepository tourRepository;

    @MockBean
    private UserBookingRepository userBookingRepository;

    @MockBean
    private UserRepository userRepository;

    /**
     * Method under test: {@link FeedbackServiceImpl#createFeedback(FeedbackDTO)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testCreateFeedback() throws HandlerException {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at com.example.wetravel.Service.ServiceImpl.FeedbackServiceImpl.createFeedback(FeedbackServiceImpl.java:47)
        //   See https://diff.blue/R013 to resolve this issue.

        FeedbackServiceImpl feedbackServiceImpl = new FeedbackServiceImpl();
        feedbackServiceImpl.createFeedback(new FeedbackDTO());
    }

    /**
     * Method under test: {@link FeedbackServiceImpl#createFeedback(FeedbackDTO)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testCreateFeedback2() throws HandlerException {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at com.example.wetravel.Service.ServiceImpl.FeedbackServiceImpl.createFeedback(FeedbackServiceImpl.java:47)
        //   See https://diff.blue/R013 to resolve this issue.

        (new FeedbackServiceImpl()).createFeedback(null);
    }

    /**
     * Method under test: {@link FeedbackServiceImpl#createFeedback(FeedbackDTO)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testCreateFeedback3() throws HandlerException {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at com.example.wetravel.Service.ServiceImpl.FeedbackServiceImpl.createFeedback(FeedbackServiceImpl.java:47)
        //   See https://diff.blue/R013 to resolve this issue.

        FeedbackServiceImpl feedbackServiceImpl = new FeedbackServiceImpl();
        FeedbackDTO feedbackDTO = mock(FeedbackDTO.class);
        when(feedbackDTO.getAccountId()).thenReturn(1234567890L);
        feedbackServiceImpl.createFeedback(feedbackDTO);
    }

    /**
     * Method under test: {@link FeedbackServiceImpl#createReportFeedback(ReportFeedbackDTO)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testCreateReportFeedback() throws HandlerException {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at com.example.wetravel.Service.ServiceImpl.FeedbackServiceImpl.createReportFeedback(FeedbackServiceImpl.java:67)
        //   See https://diff.blue/R013 to resolve this issue.

        FeedbackServiceImpl feedbackServiceImpl = new FeedbackServiceImpl();
        feedbackServiceImpl.createReportFeedback(new ReportFeedbackDTO());
    }

    /**
     * Method under test: {@link FeedbackServiceImpl#createReportFeedback(ReportFeedbackDTO)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testCreateReportFeedback2() throws HandlerException {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at com.example.wetravel.Service.ServiceImpl.FeedbackServiceImpl.createReportFeedback(FeedbackServiceImpl.java:67)
        //   See https://diff.blue/R013 to resolve this issue.

        (new FeedbackServiceImpl()).createReportFeedback(null);
    }

    /**
     * Method under test: {@link FeedbackServiceImpl#createReportFeedback(ReportFeedbackDTO)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testCreateReportFeedback3() throws HandlerException {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at com.example.wetravel.Service.ServiceImpl.FeedbackServiceImpl.createReportFeedback(FeedbackServiceImpl.java:67)
        //   See https://diff.blue/R013 to resolve this issue.

        FeedbackServiceImpl feedbackServiceImpl = new FeedbackServiceImpl();
        ReportFeedbackDTO reportFeedbackDTO = mock(ReportFeedbackDTO.class);
        when(reportFeedbackDTO.getFeedbackId()).thenReturn(123L);
        feedbackServiceImpl.createReportFeedback(reportFeedbackDTO);
    }

    /**
     * Method under test: {@link FeedbackServiceImpl#blockFeedback(Long)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testBlockFeedback() throws HandlerException {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at com.example.wetravel.Service.ServiceImpl.FeedbackServiceImpl.blockFeedback(FeedbackServiceImpl.java:79)
        //   See https://diff.blue/R013 to resolve this issue.

        (new FeedbackServiceImpl()).blockFeedback(123L);
    }

    /**
     * Method under test: {@link FeedbackServiceImpl#getListFeedback(Long, Integer, Integer, Integer)}
     */
    @Test
    void testGetListFeedback() throws HandlerException {
        when(feedbackRepository.getAllByTourId((Long) any(), (Integer) any(), (Pageable) any()))
                .thenReturn(new PageImpl<>(new ArrayList<>()));
        assertTrue(feedbackServiceImpl.getListFeedback(123L, 1, 1, 3).toList().isEmpty());
        verify(feedbackRepository).getAllByTourId((Long) any(), (Integer) any(), (Pageable) any());
    }

    /**
     * Method under test: {@link FeedbackServiceImpl#getListFeedback(Long, Integer, Integer, Integer)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testGetListFeedback2() throws HandlerException {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at com.example.wetravel.Service.ServiceImpl.FeedbackServiceImpl.getListFeedback(FeedbackServiceImpl.java:92)
        //   See https://diff.blue/R013 to resolve this issue.

        when(feedbackRepository.getAllByTourId((Long) any(), (Integer) any(), (Pageable) any())).thenReturn(null);
        feedbackServiceImpl.getListFeedback(123L, 1, 1, 3);
    }

    /**
     * Method under test: {@link FeedbackServiceImpl#getListFeedback(Long, Integer, Integer, Integer)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testGetListFeedback3() throws HandlerException {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.IllegalArgumentException: Page index must not be less than zero!
        //       at com.example.wetravel.Service.ServiceImpl.FeedbackServiceImpl.getListFeedback(FeedbackServiceImpl.java:90)
        //   See https://diff.blue/R013 to resolve this issue.

        when(feedbackRepository.getAllByTourId((Long) any(), (Integer) any(), (Pageable) any()))
                .thenReturn(new PageImpl<>(new ArrayList<>()));
        feedbackServiceImpl.getListFeedback(123L, 1, 0, 3);
    }

    /**
     * Method under test: {@link FeedbackServiceImpl#getListFeedbackContainReport(Integer, Integer)}
     */
    @Test
    void testGetListFeedbackContainReport() throws HandlerException {
        when(feedbackRepository.getListFeedback((Pageable) any())).thenReturn(new PageImpl<>(new ArrayList<>()));
        assertTrue(feedbackServiceImpl.getListFeedbackContainReport(1, 3).toList().isEmpty());
        verify(feedbackRepository).getListFeedback((Pageable) any());
    }

    /**
     * Method under test: {@link FeedbackServiceImpl#getListFeedbackContainReport(Integer, Integer)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testGetListFeedbackContainReport2() throws HandlerException {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at com.example.wetravel.Service.ServiceImpl.FeedbackServiceImpl.getListFeedbackContainReport(FeedbackServiceImpl.java:122)
        //   See https://diff.blue/R013 to resolve this issue.

        when(feedbackRepository.getListFeedback((Pageable) any())).thenReturn(null);
        feedbackServiceImpl.getListFeedbackContainReport(1, 3);
    }

    /**
     * Method under test: {@link FeedbackServiceImpl#getListFeedbackContainReport(Integer, Integer)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testGetListFeedbackContainReport3() throws HandlerException {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.IllegalArgumentException: Page index must not be less than zero!
        //       at com.example.wetravel.Service.ServiceImpl.FeedbackServiceImpl.getListFeedbackContainReport(FeedbackServiceImpl.java:120)
        //   See https://diff.blue/R013 to resolve this issue.

        when(feedbackRepository.getListFeedback((Pageable) any())).thenReturn(new PageImpl<>(new ArrayList<>()));
        feedbackServiceImpl.getListFeedbackContainReport(0, 3);
    }
}


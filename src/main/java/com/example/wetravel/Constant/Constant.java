package com.example.wetravel.Constant;


import javax.persistence.criteria.CriteriaBuilder;
import java.security.PublicKey;

public class Constant {
    public static class Server{
        public static final String LOCALHOST = "http://localhost:3000/";
    }
    public static class Role{
        public static final Integer Admin = 1;
        public static final Integer Partner = 2;
        public static final Integer Customer = 3;
    }

    public static class ServiceCategory{
        public static final Long ACCOMMODATION = 1L;
        public static final Long ENTERTAINMENT = 2L;
        public static final Long RESTAURANT = 3L;

    }

    public static class TourType{
        public static final Long PRIVATE = 1L;
        public static final Long COMPOUND = 2L;
        public static final Long SIC = 3L;

    }

    public static class Mail{
        public static final String SUBJECT_REGISTER  = "Thông tin đăng kí tài khoản WETRAVEL của bạn";
        public static final String CLIENT_REGISTER  = "Client";
        public static final String SUBJECT_FORGOT_PASSWORD  = "Thay đổi mật khẩu tài khoản WETRAVEL của bạn";
    }

    public static class Message{
        public static final String SUCCESS = "Success!";
        public static final String NOT_FOUND = "Not found!";
        public static final String CREATE_SUCCESS = "Create Success!";
        public static final String UPDATE_SUCCESS = "Update Success!";
        public static final String DELETE_SUCCESS = "Delete Success!";

        public static final String CHANGE_PASSWORD = "Change Password Success!";

        public static final String APPROVE_SUCCESS = "Approve Success!";

        public static final String EMAIL_EXIST = "Email exist!";

        public static final String EMAIL_NOT_EXIST = "Email not exist!";

        public static final String SEND_MAIL_ERROR = "SEND MAIL ERROR!";

        public static final String SEND_MAIL_SUCCESS = "SEND MAIL SUCCESS!";

        public static final String FEEDBACK_EXIST = "FEEDBACK EXIST!";


    }

    public static class StatusTour{
        public static final Integer ACTIVE = 1;

        public static final Integer WAITING = 2;

        public static final Integer CLOSE = 3;
    }

    public static class StatusBooking{
        public static final Integer NOT_PAY_YET = 0;

        public static final Integer PAY = 1;

        public static final Integer CANCEL = 2;
    }
}

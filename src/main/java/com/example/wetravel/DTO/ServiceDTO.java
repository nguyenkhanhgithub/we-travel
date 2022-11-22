package com.example.wetravel.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ServiceDTO {
    private Long serviceId;

    private String serviceName;

    private String fax;

    private String phone;

    private String email;

    private String address;

    private String city;

    private String link;

    private Integer status;

    private String taxCode;

    private Boolean isActive;

    private Boolean isBlock;

    private Long serviceCategory;

    private String typeOfServiceCategory;

    private String partnerEmail;
}

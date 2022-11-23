package com.example.wetravel.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CustomerRegisterDTO {
    private String token; //bao gồm email , role

    private String password;

    private String firstName;

    private String lastName;

    private String gender;

    private String birthDate;

    private String address;

    private String city;

    private Boolean isPrivate;

    private String phone;
}

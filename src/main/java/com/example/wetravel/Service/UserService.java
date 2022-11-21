package com.example.wetravel.Service;

import com.example.wetravel.DTO.UserDTO;
import com.example.wetravel.Exception.HandlerException;
import org.springframework.data.domain.Page;

public interface UserService {
    Page<UserDTO> getListUser(Integer page , Integer size) throws HandlerException;

    UserDTO getDetailUser(Long accountId) throws HandlerException;
}

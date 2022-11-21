package com.example.wetravel.Service.ServiceImpl;

import com.example.wetravel.DTO.UserDTO;
import com.example.wetravel.Exception.HandlerException;
import com.example.wetravel.Repository.UserRepository;
import com.example.wetravel.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;

    @Override
    public Page<UserDTO> getListUser(Integer page, Integer size) throws HandlerException{
        Pageable pageable = PageRequest.of(page - 1, size);
        Page<UserDTO> userList = userRepository.getListUser(pageable);
        if(userList.isEmpty()){
            throw new HandlerException("User Empty!");
        }
        return userList;
    }

    @Override
    public UserDTO getDetailUser(Long accountId) throws HandlerException{
        if(!userRepository.existsByAccountId_AccountId(accountId)){
            throw new HandlerException("User not found!");
        }
        UserDTO userDTO = userRepository.getDetailUser(accountId);
        return userDTO;
    }
}

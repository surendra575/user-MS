package com.surendra.UserInformation.service;

import com.surendra.UserInformation.dto.UserDTO;
import com.surendra.UserInformation.entity.UserEntity;
import com.surendra.UserInformation.mapper.UserMapper;
import com.surendra.UserInformation.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    @Autowired
    public UserRepo repo;

    public UserDTO addUser(UserDTO userDTO) {
        UserEntity savedUser = repo.save(UserMapper.INSTANCE.userDTOToUserEntity(userDTO));
        return UserMapper.INSTANCE.userEntityToUserDTO(savedUser);
    }
    public ResponseEntity<UserDTO> fetchUserDetailsById(Integer userId){
        Optional<UserEntity> user = repo.findById(userId);
        if(user.isPresent()){
            return new ResponseEntity<>(UserMapper.INSTANCE.userEntityToUserDTO(user.get()), HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);

    }
}

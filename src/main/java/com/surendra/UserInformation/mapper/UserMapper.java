package com.surendra.UserInformation.mapper;

import com.surendra.UserInformation.dto.UserDTO;
import com.surendra.UserInformation.entity.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMapper {
   UserMapper INSTANCE= Mappers.getMapper(UserMapper.class);

   UserEntity userDTOToUserEntity(UserDTO userDTO);
   UserDTO userEntityToUserDTO (UserEntity userEntity);

}

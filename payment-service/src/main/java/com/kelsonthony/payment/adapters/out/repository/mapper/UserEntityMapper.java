package com.kelsonthony.payment.adapters.out.repository.mapper;

import com.kelsonthony.payment.adapters.out.repository.entity.UserEntity;
import com.kelsonthony.payment.application.core.domain.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserEntityMapper {

    User toUser(UserEntity userEntity);

    UserEntity toUserEntity(User user);
}

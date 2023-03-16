package com.kelsonthony.payment.adapters.out;

import com.kelsonthony.payment.adapters.out.repository.UserRepository;
import com.kelsonthony.payment.adapters.out.repository.mapper.UserEntityMapper;
import com.kelsonthony.payment.application.core.domain.User;
import com.kelsonthony.payment.application.ports.out.FindUserByIdOutputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class FindUserByIdAdapter implements FindUserByIdOutputPort {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserEntityMapper userEntityMapper;

    @Override
    public Optional<User> find(Integer userId) {
        var userEntity = userRepository.findById(userId);
        return userEntity.map(userEntityMapper::toUser);
    }
}

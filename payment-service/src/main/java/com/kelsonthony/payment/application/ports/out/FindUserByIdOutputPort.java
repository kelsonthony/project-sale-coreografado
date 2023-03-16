package com.kelsonthony.payment.application.ports.out;

import com.kelsonthony.payment.application.core.domain.User;

import java.util.Optional;

public interface FindUserByIdOutputPort {

    Optional<User> find(Integer userId);
}

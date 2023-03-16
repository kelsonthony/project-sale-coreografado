package com.kelsonthony.payment.application.ports.in;

import com.kelsonthony.payment.application.core.domain.User;

public interface FindUserByIdInputPort {

    User find(final Integer id);
}

package com.kelsonthony.payment.application.ports.out;

import com.kelsonthony.payment.application.core.domain.User;

public interface UpdateUserOutputPort {

    void update(User user);
}

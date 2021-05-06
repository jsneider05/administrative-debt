package com.administrative.debt.infrastructure.security.auth.repository;

import com.administrative.debt.infrastructure.security.auth.model.ApplicationUser;
import java.util.Optional;

public interface ApplicationUserRepository {

    Optional<ApplicationUser> selectApplicationUserByUsername (String username);

}

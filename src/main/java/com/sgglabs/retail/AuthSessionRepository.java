package com.sgglabs.retail;

import com.sgglabs.retail.model.AuthSession;
import org.springframework.data.repository.CrudRepository;

public interface AuthSessionRepository extends CrudRepository<AuthSession, Long> {
    public AuthSession findByUserName(final String userName);
}
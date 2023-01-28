package com.teckmils.jobportalapi.domain._user.repository;

import com.teckmils.jobportalapi.domain._user.model._User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface _UserRepository extends CrudRepository<_User, Integer> {
    Optional<_User> findByEmail(String email);
}

package org.elbahja.stationery_shop.repository;

import org.elbahja.stationery_shop.model.UserAdapter;
import org.elbahja.stationery_shop.model.UserDAO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserDAO, Long> {
    Optional<UserDAO> findByUsernameIgnoreCase(String username);

    boolean existsByUsernameIgnoreCase(String username);

    Integer deleteByUsernameIgnoreCase(String username);
}

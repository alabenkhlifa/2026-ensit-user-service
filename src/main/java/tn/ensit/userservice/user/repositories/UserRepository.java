package tn.ensit.userservice.user.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.ensit.userservice.user.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> { }

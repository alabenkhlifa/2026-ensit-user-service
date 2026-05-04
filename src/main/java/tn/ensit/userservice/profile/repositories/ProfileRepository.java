package tn.ensit.userservice.profile.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.ensit.userservice.profile.entities.Profile;

@Repository
public interface ProfileRepository extends JpaRepository<Profile, Long> { }

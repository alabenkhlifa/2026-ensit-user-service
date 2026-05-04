package tn.ensit.userservice.user.services;

import org.springframework.stereotype.Service;
import tn.ensit.userservice.profile.entities.Profile;
import tn.ensit.userservice.profile.services.ProfileService;
import tn.ensit.userservice.user.entities.User;
import tn.ensit.userservice.user.repositories.UserRepository;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final ProfileService profileService;

    public UserService(UserRepository repository, ProfileService profileService) {
        this.userRepository = repository;
        this.profileService = profileService;
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public Optional<User> getOneUser(Long id) {
        return userRepository.findById(id);
    }

    public User createUser(User user) {
        var createdUser = userRepository.save(user);
        var bio = "";
        Profile profile = new Profile(createdUser, bio);
        profileService.createProfile(profile);
        return createdUser;
    }

    public User findById(Long id) {
        return userRepository.findById(id).orElseThrow();
    }
}

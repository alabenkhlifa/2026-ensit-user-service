package tn.ensit.userservice;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import tn.ensit.userservice.friendrequest.entities.FriendRequest;
import tn.ensit.userservice.friendrequest.repositories.FriendRequestRepository;
import tn.ensit.userservice.profile.entities.Profile;
import tn.ensit.userservice.user.entities.User;
import tn.ensit.userservice.user.repositories.UserRepository;

import java.util.ArrayList;
import java.util.List;

@Component
public class DataSeeder implements CommandLineRunner {

    private static final String[] USERNAMES = {
            "alice", "bob", "carol", "dave", "eve",
            "frank", "grace", "henry", "iris", "jack"
    };

    private final UserRepository userRepository;
    private final FriendRequestRepository friendRequestRepository;

    public DataSeeder(UserRepository userRepository, FriendRequestRepository friendRequestRepository) {
        this.userRepository = userRepository;
        this.friendRequestRepository = friendRequestRepository;
    }

    @Override
    public void run(String... args) {
        if (userRepository.count() > 0) return;

        List<User> users = new ArrayList<>();
        for (String username : USERNAMES) {
            User user = new User(username);
            Profile profile = new Profile(user, username + "'s bio");
            user.setProfile(profile);
            users.add(userRepository.save(user));
        }

        for (int i = 0; i < USERNAMES.length; i++) {
            User requester = users.get(i);
            User receiver = users.get((i + 1) % USERNAMES.length);
            FriendRequest request = new FriendRequest(requester, receiver);
            if (i % 2 == 0) request.setAccepted(true);
            friendRequestRepository.save(request);
        }
    }
}

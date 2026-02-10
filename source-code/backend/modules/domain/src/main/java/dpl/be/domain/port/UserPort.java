package dpl.be.domain.port;

import dpl.be.domain.model.User;

import java.util.Optional;
import java.util.UUID;

public interface UserPort {
    User save(User user);

    Optional<User> findById(UUID id);
}

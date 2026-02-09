package dpl.be.domain.repository;

import dpl.be.domain.model.User;
import dpl.be.domain.vo.UserId;

import java.util.Optional;

public interface UserRepository {
    User save(User user);

    Optional<User> findById(UserId id);
}

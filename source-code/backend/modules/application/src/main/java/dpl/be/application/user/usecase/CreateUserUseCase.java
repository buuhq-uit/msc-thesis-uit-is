package dpl.be.application.user.usecase;

import dpl.be.domain.model.User;
import dpl.be.domain.port.UserPort;
import dpl.be.domain.vo.AuthType;
import dpl.be.domain.vo.PasswordHash;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CreateUserUseCase {
    private final UserPort userPort;

    public User createLocalUser(UUID id, String rawPassword) {
        User user = new User(UUID.randomUUID(), AuthType.LOCAL);
        user.changePassword(new PasswordHash(hash(rawPassword)));
        return userPort.save(user);
    }

    private String hash(String raw) {
        return "hashed-" + raw; // demo
    }
}

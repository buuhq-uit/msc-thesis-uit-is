package dpl.be.application.user.usecase;

import dpl.be.domain.model.User;
import dpl.be.domain.port.UserPort;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@AllArgsConstructor
public class DisableUserUseCase {
    private final UserPort userPort;

    public void disable(UUID userId) {
        User user = userPort.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("User not found"));

        user.disable();
        userPort.save(user);
    }
}

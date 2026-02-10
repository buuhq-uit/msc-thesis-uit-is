package dpl.be.application.user.usecase;

import dpl.be.domain.model.User;
import dpl.be.domain.port.UserPort;
import dpl.be.domain.vo.RoleName;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AssignRoleToUserUseCase {
    private final UserPort userPort;

    public void assign(UUID userId, RoleName roleName) {
        User user = userPort.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("User not found"));

        user.assignRole(roleName);
        userPort.save(user);
    }
}

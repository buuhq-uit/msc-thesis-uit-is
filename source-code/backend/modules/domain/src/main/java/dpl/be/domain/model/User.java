package dpl.be.domain.model;

import dpl.be.domain.vo.AuthType;
import dpl.be.domain.vo.PasswordHash;
import dpl.be.domain.vo.RoleName;
import lombok.Getter;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Getter
public class User {
    private final UUID id;
    private final Set<Role> roles = new HashSet<>();

    private boolean enabled;
    private final AuthType authType;
    private PasswordHash password;

    public User(UUID id, AuthType authType) {
        this.id = id;
        this.authType = authType;
        this.enabled = true;
    }

    // ===== Business behavior =====

    public void assignRole(RoleName roleName) {
        roles.add(new Role(roleName));
    }

    public void revokeRole(RoleName roleName) {
        roles.removeIf(r -> r.getName() == roleName);
    }

    public boolean hasRole(RoleName roleName) {
        return roles.stream().anyMatch(r -> r.getName() == roleName);
    }

    public void changePassword(PasswordHash passwordHash) {
        if (authType != AuthType.LOCAL) {
            throw new IllegalStateException(
                    "Cannot change password for non-local user"
            );
        }
        this.password = passwordHash;
    }

    public void disable() {
        this.enabled = false;
    }
}

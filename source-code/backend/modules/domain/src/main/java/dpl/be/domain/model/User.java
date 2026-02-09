package dpl.be.domain.model;

import dpl.be.domain.vo.UserId;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.util.HashSet;
import java.util.Set;

@Getter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class User {
    @EqualsAndHashCode.Include
    private final UserId id;

    private final Set<Role> roles = new HashSet<>();

    public User(UserId id) {
        this.id = id;
    }

    // Business behavior
    public void assignRole(Role role) {
        roles.add(role);
    }

    public void revokeRole(Role role) {
        roles.remove(role);
    }
}

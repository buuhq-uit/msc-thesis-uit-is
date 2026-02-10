package dpl.be.domain.port;

import dpl.be.domain.model.Role;
import dpl.be.domain.vo.RoleName;

import java.util.Optional;

public interface RolePort {
    Optional<Role> findByName(RoleName name);

    Role save(Role role);
}

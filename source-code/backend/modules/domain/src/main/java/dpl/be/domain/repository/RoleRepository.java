package dpl.be.domain.repository;

import dpl.be.domain.model.Role;
import dpl.be.domain.vo.RoleName;

import java.util.Optional;

public interface RoleRepository {
    Optional<Role> findByName(RoleName name);

    Role save(Role role);
}

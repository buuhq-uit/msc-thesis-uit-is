package dpl.be.infrastructure.persistence.adapter;

import dpl.be.domain.model.Role;
import dpl.be.domain.port.RolePort;
import dpl.be.domain.vo.RoleName;
import dpl.be.infrastructure.persistence.jpa.RoleJpaRepository;
import dpl.be.infrastructure.persistence.mapper.RoleMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class RoleAdapter implements RolePort {

    private final RoleJpaRepository jpaRepository;
    private final RoleMapper roleMapper;

    @Override
    public Optional<Role> findByName(RoleName name) {
        return jpaRepository.findByName(name)
                .map(roleMapper::toDomain);
    }

    @Override
    public Role save(Role role) {
        return roleMapper.toDomain(
                    jpaRepository.save(roleMapper.toJpa(role)
                )
        );
    }
}

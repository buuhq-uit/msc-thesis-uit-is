package dpl.be.infrastructure.persistence.repository;

import dpl.be.domain.model.Role;
import dpl.be.domain.repository.RoleRepository;
import dpl.be.domain.vo.RoleName;
import dpl.be.infrastructure.persistence.jpa.RoleJpaRepository;
import dpl.be.infrastructure.persistence.mapper.RoleMapper;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class RoleRepositoryAdapter implements RoleRepository {

    private final RoleJpaRepository jpaRepository;

    public RoleRepositoryAdapter(RoleJpaRepository jpaRepository) {
        this.jpaRepository = jpaRepository;
    }

    @Override
    public Optional<Role> findByName(RoleName name) {
        return jpaRepository.findByName(name.value())
                .map(RoleMapper::toDomain);
    }

    @Override
    public Role save(Role role) {
        return RoleMapper.toDomain(
                jpaRepository.save(RoleMapper.toJpa(role))
        );
    }
}

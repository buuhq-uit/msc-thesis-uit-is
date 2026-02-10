package dpl.be.infrastructure.persistence.jpa;

import dpl.be.domain.vo.RoleName;
import dpl.be.infrastructure.persistence.entity.RoleJpaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleJpaRepository extends JpaRepository<RoleJpaEntity, Long> {
    Optional<RoleJpaEntity> findByName(RoleName name);
}

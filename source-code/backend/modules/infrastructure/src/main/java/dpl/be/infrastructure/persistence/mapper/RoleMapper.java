package dpl.be.infrastructure.persistence.mapper;

import dpl.be.domain.model.Role;
import dpl.be.domain.vo.RoleName;
import dpl.be.infrastructure.persistence.entity.RoleJpaEntity;

public class RoleMapper {
    public static RoleJpaEntity toJpa(Role role) {
        RoleJpaEntity entity = new RoleJpaEntity();
        entity.setName(role.getName().value());
        return entity;
    }

    public static Role toDomain(RoleJpaEntity entity) {
        return new Role(new RoleName(entity.getName()));
    }
}

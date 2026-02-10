package dpl.be.infrastructure.persistence.mapper;

import dpl.be.domain.model.Role;
import dpl.be.infrastructure.persistence.entity.RoleJpaEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface RoleMapper {
    @Mapping(target = "id", ignore = true)
    RoleJpaEntity toJpa(Role domain);

    Role toDomain(RoleJpaEntity entity);
}

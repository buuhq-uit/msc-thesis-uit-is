package dpl.be.infrastructure.persistence.mapper;

import dpl.be.domain.model.User;
import dpl.be.domain.vo.PasswordHash;
import dpl.be.infrastructure.persistence.entity.UserJpaEntity;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;


@Mapper(
        componentModel = "spring",
        uses = RoleMapper.class
)
public interface UserMapper {
    @Mapping(target = "authType", expression = "java(AuthType.valueOf(entity.getAuthType()))")
    @Mapping(target = "password", ignore = true)
    User toDomain(UserJpaEntity entity);

    @Mapping(target = "authType", source = "authType")
    @Mapping(target = "password", ignore = true)
    UserJpaEntity toJpa(User domain);

    @AfterMapping
    default void mapPassword(UserJpaEntity entity, @MappingTarget User user) {
        if (entity.getPassword() != null) {
            user.changePassword(new PasswordHash(entity.getPassword()));
        }
    }

    @AfterMapping
    default void mapPassword(User domain, @MappingTarget UserJpaEntity entity) {
        if (domain.getPassword() != null) {
            entity.setPassword(domain.getPassword().getValue());
        }
    }
}

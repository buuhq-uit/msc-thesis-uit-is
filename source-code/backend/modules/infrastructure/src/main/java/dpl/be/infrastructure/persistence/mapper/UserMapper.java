package dpl.be.infrastructure.persistence.mapper;

import dpl.be.domain.model.Role;
import dpl.be.domain.model.User;
import dpl.be.domain.vo.RoleName;
import dpl.be.domain.vo.UserId;
import dpl.be.infrastructure.persistence.entity.RoleJpaEntity;
import dpl.be.infrastructure.persistence.entity.UserJpaEntity;

import java.util.stream.Collectors;

public class UserMapper {
    public static UserJpaEntity toJpa(User user) {
        UserJpaEntity entity = new UserJpaEntity();
        entity.setId(user.getId().value());

        entity.setRoles(
                user.getRoles().stream()
                        .map(role -> {
                            RoleJpaEntity r = new RoleJpaEntity();
                            r.setName(role.getName().value());
                            return r;
                        })
                        .collect(Collectors.toSet())
        );

        return entity;
    }

    public static User toDomain(UserJpaEntity entity) {
        User user = new User(new UserId(entity.getId()));

        entity.getRoles().forEach(
                r -> user.assignRole(new Role(new RoleName(r.getName())))
        );

        return user;
    }
}

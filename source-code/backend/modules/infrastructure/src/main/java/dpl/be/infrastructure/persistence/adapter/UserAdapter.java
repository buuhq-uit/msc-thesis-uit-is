package dpl.be.infrastructure.persistence.adapter;

import dpl.be.domain.model.User;
import dpl.be.domain.port.UserPort;
import dpl.be.infrastructure.persistence.jpa.UserJpaRepository;
import dpl.be.infrastructure.persistence.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
@RequiredArgsConstructor
public class UserAdapter implements UserPort {
    private final UserJpaRepository jpaRepository;
    private final UserMapper userMapper;

    @Override
    public User save(User user) {
        return userMapper.toDomain(
                jpaRepository.save(userMapper.toJpa(user))
        );
    }

    @Override
    public Optional<User> findById(UUID id) {
        return jpaRepository.findById(id)
                .map(userMapper::toDomain);
    }
}

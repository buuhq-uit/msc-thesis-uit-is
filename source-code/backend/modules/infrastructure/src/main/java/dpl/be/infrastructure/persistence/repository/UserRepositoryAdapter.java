package dpl.be.infrastructure.persistence.repository;

import dpl.be.domain.model.User;
import dpl.be.domain.repository.UserRepository;
import dpl.be.domain.vo.UserId;
import dpl.be.infrastructure.persistence.jpa.UserJpaRepository;
import dpl.be.infrastructure.persistence.mapper.UserMapper;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class UserRepositoryAdapter implements UserRepository {
    private final UserJpaRepository jpaRepository;

    public UserRepositoryAdapter (UserJpaRepository jpaRepository) {
        this.jpaRepository = jpaRepository;
    }
    @Override
    public User save(User user) {
        return UserMapper.toDomain(
                jpaRepository.save(UserMapper.toJpa(user))
        );
    }

    @Override
    public Optional<User> findById(UserId id) {
        return jpaRepository.findById(id.value())
                .map(UserMapper::toDomain);
    }
}

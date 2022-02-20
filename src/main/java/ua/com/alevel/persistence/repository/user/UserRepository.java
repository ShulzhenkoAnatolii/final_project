package ua.com.alevel.persistence.repository.user;

import org.springframework.stereotype.Repository;
import ua.com.alevel.persistence.entity.user.User;
import ua.com.alevel.persistence.repository.BaseRepository;

@Repository
public interface UserRepository<USER extends User> extends BaseRepository<USER> {

    USER findByEmail(String email);

    boolean existsByEmail(String email);
}

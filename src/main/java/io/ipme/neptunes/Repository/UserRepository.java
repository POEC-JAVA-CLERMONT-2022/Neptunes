package io.ipme.neptunes.Repository;

import io.ipme.neptunes.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}

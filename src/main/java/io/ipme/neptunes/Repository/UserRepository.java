package io.ipme.neptunes.Repository;

import io.ipme.neptunes.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface UserRepository extends JpaRepository<User, Integer> {

    @Modifying
    @Transactional
    @Query("UPDATE User SET userName = :userName, avatar = :avatar WHERE id = :id")
    void updateUserInfos(@Param("userName") String userName, @Param("avatar") String avatar, @Param("id") Integer id);

}

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
    @Query("UPDATE User set user_name = :username where id = :id")
    void updateUserName(@Param("username") String userName, @Param("id") Integer id);

    @Modifying
    @Transactional
    @Query("UPDATE User set email = :email where id = :id")
    void updateEmail(@Param("email") String email, @Param("id") Integer id);

    @Modifying
    @Transactional
    @Query("UPDATE User set password = :password where id = :id")
    void updatePassword(@Param("password") String password, @Param("id") Integer id);

    @Modifying
    @Transactional
    @Query("UPDATE User set avatar = :avatar where id = :id")
    void updateAvatar(@Param("avatar") String avatar, @Param("id") Integer id);

    @Modifying
    @Transactional
    @Query("UPDATE User set is_Premium = :isPremium where id = :id")
    void updateIsPremium(@Param("isPremium") Boolean isPremium, @Param("id") Integer id);

}

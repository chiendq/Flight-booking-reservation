package vn.hanu.fit.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import vn.hanu.fit.entity.Role;
import vn.hanu.fit.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    boolean existsByUsername(String username);

    boolean existsByUsernameAndPassword(String username, String password);

    User findByUsername(String username);

    User findUserByUsername(String username);

    @Modifying
    @Query("UPDATE User u SET u.role =?1 where u.username=?2")
    int setAdmin( Role role, String username);
}

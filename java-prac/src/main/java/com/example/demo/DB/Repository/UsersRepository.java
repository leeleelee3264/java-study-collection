package com.example.demo.DB.Repository;

import com.example.demo.DB.DAO.UsersVO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author SeungminLee
 * project java_toy_project
 * date 2021-01-24
 * description
 */
@Repository
public interface UsersRepository extends JpaRepository<UsersVO, Long> {

    List<UsersVO> findByName(String name);

    List<UsersVO> findByNameLike(String name);
}

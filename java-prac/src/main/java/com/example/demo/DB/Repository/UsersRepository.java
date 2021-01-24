package com.example.demo.DB.Repository;

import com.example.demo.DB.DAO.UsersVO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
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

    /**
     * jpa update 는 분명 모든 것을 한 큐에 업데이트 하는 그런.. 성격인가봄 
     * @param id
     * @param name
     */
    @Modifying
    @Query("update users u " +
            "set u.name = :name " +
            "where u.id = :id")
    void updateName(@Param(value = "id") long id, @Param(value = "name") String name);
}

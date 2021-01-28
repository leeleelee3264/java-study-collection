package com.example.demo.Units;

import com.example.demo.DB.DAO.UsersVO;
import com.example.demo.DB.Repository.UsersRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author SeungminLee
 * project java_toy_project
 * date 2021-01-24
 * description: Repository unit test
 */
@ExtendWith(SpringExtension.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class UsersRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private UsersRepository usersRepository;

//    @BeforeEach
//    void setUp() {
//    }

    /**
     * 대박 이렇게 하면 db 에 변경 반영이 안됨
     */
    @Test
    public void whenSave_thenReturnUsers() {
        UsersVO jpaEntity = UsersVO.builder()
                .name("tryNoDB")
                .salary(20000)
                .build();

        entityManager.persist(jpaEntity);
        entityManager.flush();

        UsersVO saved = usersRepository.save(jpaEntity);
        assertThat(saved.getName()).isEqualTo(jpaEntity.getName());
    }

    @Test
    public void should_update_name_by_id() {
        long id = 2;
        String name = "Jamie";
        String notName = "rer";

        // entityManager 은 진짜 jpa 에 있는 entity 를 위한거다.
        // jpa entity 가 아니면 못 쓴다는 소리임임
//       entityManager.persist(id);
//        entityManager.flush();;

        usersRepository.updateName(id, name);
        List<UsersVO> updated = usersRepository.findByName(name);

        assertThat(updated.get(0).getName()).isEqualTo(notName);
    }
}
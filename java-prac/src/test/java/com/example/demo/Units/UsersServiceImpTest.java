package com.example.demo.Units;

import com.example.demo.DB.DAO.UsersVO;
import com.example.demo.DB.Repository.UsersRepository;
import com.example.demo.Service.UsersServiceImp;
import com.example.demo.Service.frame.UsersService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.AdditionalAnswers;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;

/**
 * @author SeungminLee
 * project java_toy_project
 * date 2021-01-24
 * description: service unit test
 */
@ExtendWith(SpringExtension.class)
class UsersServiceImpTest {

    // 일단 test code 에서 autowired 하는데 필요한 형식이다
    @TestConfiguration
    static class UsersServiceTestConfiguration {

        @Bean
        public UsersService usersService() {
            return new UsersServiceImp();
        }
    }

    @Autowired
    UsersService UsersService;

    // 이렇게 mock 으로 해두면 진짜 리포지토리 부르는 걸 우회한다.
    @MockBean
    private UsersRepository usersRepository;

    @BeforeEach
    public void setUp() {
        UsersVO test = UsersVO.builder()
                .name("test_account")
                .salary(1000)
                .build();

        Mockito.when(usersRepository.findByName(test.getName()))
                .thenReturn(Collections.singletonList(test));

    }

    @Test
    public void whenValidName_thenUsersShouldBeFound() {
        String name = "Sam";
        List<UsersVO> found = UsersService.findByName(name);

        assertThat(found.get(0).getName()).isEqualTo(name);
    }

    @Test
    void whenSaved_thenUsersShouldBeReturned() {
        UsersVO test = UsersVO.builder()
                .name("dummy_account")
                .salary(1000)
                .build();

        UsersVO saved = UsersService.save(test);

        UsersVO found = UsersService.findByName(test.getName()).get(0);
        assertThat(test.getName()).isEqualTo(found.getName());

        assertThat(saved.getName()).isEqualTo(test.getName());
    }
}
package com.example.demo.Service;

import com.example.demo.DB.DAO.UsersVO;
import com.example.demo.DB.Repository.UsersRepository;
import com.example.demo.Service.frame.UsersService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

/**
 * @author SeungminLee
 * project java_toy_project
 * date 2021-01-24
 * description: service 는 db별로 작성을 해야 하나 기능별로 작성을 해야 하나?
 */
@Slf4j
@Service
public class UsersServiceImp implements UsersService {

    @Autowired
    private UsersRepository usersRepository;

    @Override
    public List<UsersVO> findByName(String name) {
        try {
            return usersRepository.findByName(name);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return Collections.emptyList();
        }
    }

    @Override
    public List<UsersVO> findByNameLike(String name) {
        try {
            return usersRepository.findByNameLike(name);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return Collections.emptyList();
        }
    }

    @Override
    public UsersVO save(UsersVO vo) {
        usersRepository.save(vo);
        return vo;
    }
}

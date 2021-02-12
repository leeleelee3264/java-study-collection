package com.example.demo.Service.frame;

import com.example.demo.DB.DAO.UsersVO;

import java.util.List;

/**
 * @author SeungminLee
 * project java_toy_project
 * date 2021-01-28
 * description
 */
public interface UsersService {

    List<UsersVO> findByName(String name);
    List<UsersVO> findByNameLike(String name);
    UsersVO save(UsersVO vo);
}

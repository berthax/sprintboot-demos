package com.xgj.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xgj.dao.UserMapper;
import com.xgj.entity.User;

@Service
public class UserService {
    @Autowired
    UserMapper userMapper;

//    public User Sel(int id){
//        return userMapper.Sel(id);
//    }
    
    public PageInfo<User> findAllByPage(Integer pageNum, Integer pageSize){
    	pageNum = pageNum == null ? 1 : pageNum;
        pageSize = pageSize == null ? 10 : pageSize;
        PageHelper.startPage(pageNum, pageSize);
        List<User> list = userMapper.selectAll();
        PageInfo<User> pageInfo = new PageInfo(list);
//        Page page = (Page) list;
//        return "PageInfo: " + JSON.toJSONString(pageInfo) + ", Page: " + JSON.toJSONString(page);
    	return pageInfo;
    }
}

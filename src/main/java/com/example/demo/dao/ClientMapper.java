package com.example.demo.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.demo.bo.Client;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface ClientMapper extends BaseMapper<Client> {
//    @Select("select * from client where cid = #{cid}")
    Client getClient(int cid);

    void insertClient(Client c);

    @Update("update client set email=#{email} where cid=#{cid}")
    void updateEmail(int cid, String email);
}

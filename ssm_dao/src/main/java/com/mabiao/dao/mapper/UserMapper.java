package com.mabiao.dao.mapper;

import com.mabiao.domain.User;
import org.apache.ibatis.annotations.Param;

/**
 * @author created by mabiao on 2018/8/3
 */
public interface UserMapper {

	User findById(@Param("id")int id);
}

package com.kwin.db.test.user.mapper;

import com.kwin.db.test.user.entity.Admin;
import com.kwin.db.test.user.entity.SystemManager;
import com.kwin.db.test.user.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

@Component
@Mapper
public interface UserMapper {

    User getUser(String userName,String password);

    Admin getAdmin(String userName,String password);

    SystemManager getSystemManager(String userName,String password);

}

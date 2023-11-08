package azone.service;

import azone.dao.UserBasicDAO;
import azone.pojo.UserBasic;

import java.util.List;

public interface UserBasicService {
    UserBasic login(String loginId , String pwd );
    List<UserBasic> getFriendList(UserBasic userBasic);

    UserBasic getUserBasicById(Integer id);
}

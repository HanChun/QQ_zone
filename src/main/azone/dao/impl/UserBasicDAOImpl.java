package azone.dao.impl;

import myssm.basedao.BaseDAO;
import azone.dao.UserBasicDAO;
import azone.pojo.UserBasic;

import java.util.List;

public class UserBasicDAOImpl extends BaseDAO<UserBasic> implements UserBasicDAO {
    @Override
    public UserBasic getUserBasic(String loginId, String pwd) {
        return super.load("select * from t_user_basic where \"loginId\" = ? and \"pwd\" = ? " , loginId , pwd);
    }

    @Override
    public List<UserBasic> getUserBasicList(UserBasic userBasic) {
        String sql = "SELECT fid as \"id\" FROM t_friend WHERE uid = ?";
        System.out.println("uid : " + userBasic.getId());
        return super.executeQuery(sql,userBasic.getId());
    }

    @Override
    public UserBasic getUserBasicById(Integer id) {
        return load("select * from t_user_basic where id = ? " , id);
    }
}















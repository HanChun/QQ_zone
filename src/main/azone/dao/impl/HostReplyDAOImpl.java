package azone.dao.impl;

import azone.dao.HostReplyDAO;
import azone.pojo.HostReply;
import myssm.basedao.BaseDAO;

public class HostReplyDAOImpl extends BaseDAO<HostReply> implements HostReplyDAO {
    @Override
    public HostReply getHostReplyByReplyId(Integer reply) {
        return load("select * from t_host_reply where reply=?",reply);
    }

    @Override
    public void delHostReply(Integer id) {
        super.executeUpdate("delete from t_host_reply where id = ?",id);
    }
}



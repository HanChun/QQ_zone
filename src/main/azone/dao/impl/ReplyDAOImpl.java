package azone.dao.impl;

import azone.dao.ReplyDAO;
import azone.pojo.Reply;
import azone.pojo.Topic;
import myssm.basedao.BaseDAO;
import java.util.List;
public class ReplyDAOImpl extends BaseDAO<Reply> implements ReplyDAO {
    @Override
    public List<Reply> getReplyList( Topic topic ) {
        System.out.println(String.format("Flag_3: ReplyDAOImpl ： select * from t_reply where topic =%s",topic.getId()));
        return executeQuery("select * from t_reply where topic =?",topic.getId())   ;
    }

     public void addReply( Reply reply ) {
         String sql = "insert into t_reply values((SELECT max(id)+1 FROM t_reply),?,?,?,?)";
         executeUpdate( sql, reply.getContent(), reply.getReplyDate(), reply.getAuthor().getId(), reply.getTopic().getId());
    }

    @Override
    public void delReply( Integer id ) {
        executeUpdate( "delete from t_reply where id = ?", id);
    }

    @Override
    public Reply getReply(Integer id) {
        return load("select * from t_reply where id =?", id);
    }
}

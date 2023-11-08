package azone.dao;

import azone.pojo.HostReply;

public interface HostReplyDAO {
    HostReply getHostReplyByReplyId(Integer replyId);
    void delHostReply(Integer id);
}

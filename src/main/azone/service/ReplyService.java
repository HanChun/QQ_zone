package azone.service;

import azone.pojo.Reply;
import azone.pojo.Topic;

import java.util.List;

public interface ReplyService {
    List<Reply> getReplyListByTopicId(Integer topicId);

    void addReply(Reply reply);

    void delReply(Integer id);//delete certain reply
    //删除 指定的日志 关联的 所有 回复
    void delReplyList(Topic topic);
}

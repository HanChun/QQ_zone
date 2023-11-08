package azone.service.impl;

import azone.dao.TopicDAO;
import azone.pojo.Reply;
import azone.pojo.Topic;
import azone.pojo.UserBasic;
import azone.service.ReplyService;
import azone.service.TopicService;
import azone.service.UserBasicService;

import java.util.List;

public class TopicServiceImpl implements TopicService {
    private TopicDAO topicDAO = null ;
    private ReplyService replyService;
    private UserBasicService userBasicService;

    @Override
    public List<Topic> getTopicList(UserBasic userBasic) {
        return topicDAO.getTopicList(userBasic);
    }
    @Override//根据 id 获取 指定的topic 信息，包含这个topic 关联 的 作者信息
    public Topic getTopic(Integer id) {
        Topic topic= topicDAO.getTopic(id);// 具体这个 topic 里面

        UserBasic author = topic.getAuthor();
        author = userBasicService.getUserBasicById(author.getId());
        topic.setAuthor(author);
        return topic;
    }

    @Override
    public void delTopic(Integer id) {
        Topic topic = topicDAO.getTopic(id);
        if( topic!=null ){
            // 获取到 当前 topic 的 所有的 reply List，并删除
            replyService.delReplyList(topic);

            topicDAO.delTopic(topic);
        }
    }

    //根据id获取指定的topic信息，包含这个topic关联的作者信息
    @Override
    public Topic getTopicById(Integer id) {//
        Topic topic = getTopic(id);
        // 在 topic service 里面 把 对应的 reply list 查出来；
        List<Reply> replyList = replyService.getReplyListByTopicId(topic.getId());
        topic.setReplyList(replyList );
        return topic;
    }
}









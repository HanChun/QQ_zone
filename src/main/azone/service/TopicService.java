package azone.service;

import azone.dao.TopicDAO;
import azone.pojo.Topic;
import azone.pojo.UserBasic;

import java.util.List;

public interface TopicService {
    //查询特定用户的日志列表
    List<Topic> getTopicList(UserBasic userBasic) ;

    Topic getTopicById(Integer id);
    //根据id获取指定的topic信息，包含这个topic关联的作者信息
    public Topic getTopic(Integer id);
    //
    void delTopic(Integer id);

}

package azone.controller;

import azone.pojo.Reply;
import azone.pojo.Topic;
import azone.pojo.UserBasic;
import azone.service.ReplyService;
import azone.service.TopicService;

import javax.servlet.http.HttpSession;
import java.util.List;

public class TopicController {
    private TopicService topicService;
    public String topicDetail( Integer id, HttpSession session ){
        Topic topic = topicService.getTopicById(id) ;
        session.setAttribute("topic",topic);
        return "frames/detail";// 这个是 返回的html的根目录的路径
    }

    public String delTopic(Integer topicId){
        topicService.delTopic(topicId);
        return "redirect:topic.do?operate=getTopicList";
    }

    public String getTopicList(HttpSession session){
        // 主要 目的是 删除 完 topic 了，要 把 session 里面 原来的 topicList 更新；
        UserBasic userBasic = (UserBasic)session.getAttribute("userBasic");
        List<Topic> topicList = topicService.getTopicList(userBasic);
        userBasic.setTopicList(topicList);// 重新更新 一下 当前 session 中 userBasic 中 TopicList中的 信息

        session.setAttribute("friend",userBasic);//另外 一定要注意 这里 更新覆盖的 的 "friend"
        return "frames/main";
    }

}












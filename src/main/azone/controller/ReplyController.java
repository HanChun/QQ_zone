package azone.controller;

import azone.pojo.Reply;
import azone.pojo.Topic;
import azone.pojo.UserBasic;
import azone.service.ReplyService;

import javax.servlet.http.HttpSession;
import java.util.Date;
//http://localhost:8080/pro19/page.do?operate=page&page=login.html
public class ReplyController {
    private ReplyService replyService ;
    public String addReply( String content, Integer topicId, HttpSession session  ) {
        UserBasic author = (UserBasic) session.getAttribute("userBasic");
        Reply reply = new Reply( content, new Date(), author, new Topic(topicId));
        replyService.addReply(reply);//当前 页面 是 detail；所以 不能直接跳回去， 应该让它重新 查一下 所有的 Topic
        return "redirect:topic.do?operate=topicDetail&id="+topicId;
        //return "redirect:topic.do?operate=topicDetail&id="+topicId;
        // 这里面的这个 topicId 指的是 给哪个帖子的回复是；是
    }

    public String delReply(Integer replyId, Integer topicId){
        replyService.delReply(replyId);
        return "redirect:topic.do?operate=topicDetail&id="+topicId;//删除完 重定向回 文章内容+回复的  页面
    }
}

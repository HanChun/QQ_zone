package azone.controller;

import azone.pojo.Topic;
import azone.pojo.UserBasic;
import azone.service.TopicService;
import azone.service.UserBasicService;

import javax.servlet.http.HttpSession;
import java.util.List;

/** 项目 一开始 的初始化
 * http://localhost:8080/pro19/page.do?operate=page&page=login.html
 */
public class UserController {
    private UserBasicService userBasicService ;
    private TopicService topicService ;

    public String login(String loginId , String pwd , HttpSession session){
        //1.登录验证
        UserBasic userBasic = userBasicService.login(loginId, pwd);
        if( userBasic!= null ){
            //1-1 获取相关的好友信息
            List<UserBasic> friendList = userBasicService.getFriendList(userBasic);
            //1-2 获取相关的日志列表信息(但是，日志只有id，没有其他信息）
            List<Topic> topicList = topicService.getTopicList(userBasic);

            userBasic.setFriendList(friendList);
            userBasic.setTopicList(topicList);

            session.setAttribute("userBasic",userBasic);//登录者的信息===>从一开始登录的 时候，这个 session的值就不变了
            session.setAttribute("friend",userBasic);//记录当前进入的是谁的空间
            // 一个对象，以不同的名称 存储了两份；如果 这两个userBasic对象的 id不一致 ===》辅助判断 当前user不在自己的空间
            return "index";
        }else{
            return "login";
        }
    }

    public String friend( Integer id, HttpSession session ){
        UserBasic currFriend = userBasicService.getUserBasicById(id);
        List<Topic> topicList = topicService.getTopicList(currFriend);

        currFriend.setTopicList(topicList);
        session.setAttribute("friend",currFriend);
        return "index";
    }
}

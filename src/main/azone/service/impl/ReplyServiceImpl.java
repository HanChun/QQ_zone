package azone.service.impl;

import azone.dao.ReplyDAO;
import azone.pojo.HostReply;
import azone.pojo.Reply;
import azone.pojo.Topic;
import azone.pojo.UserBasic;
import azone.service.HostReplyService;
import azone.service.ReplyService;
import azone.service.UserBasicService;

import java.util.List;

public class ReplyServiceImpl implements ReplyService {
    private ReplyDAO replyDAO;
    private HostReplyService hostReplyService;  //这块是service
    private UserBasicService userBasicService;
    @Override
    public List<Reply> getReplyListByTopicId(Integer topicId) {
        //System.out.println("Flag_1 getReplyListByTopicId(Integer topicId) : " + topicId);
        Topic topic = new Topic(topicId);
        //System.out.println("Flag_2 topicId" + topic.getId());
        List<Reply> replyList =  replyDAO.getReplyList(topic);// 传入 topic id,获取当前topic id 对应的 回复列表
        for( int i = 0 ; i < replyList.size() ; i++ ){
            Reply reply = replyList.get(i);
            System.out.println("reply.getContent() : "+ reply.getContent());

            UserBasic author = userBasicService.getUserBasicById(reply.getAuthor().getId()) ;
            reply.setAuthor(author);

            //2.将关联的hostREPLY 设置进去
            HostReply hostReply = hostReplyService.getHostReplyByReplyId(reply.getId());
            reply.setHostReply(hostReply);
        }
        return replyList;
    }
    @Override
    public void addReply(Reply reply) {
        replyDAO.addReply(reply);
    }
    @Override
    public void delReply(Integer id) {
        //问题：直接 删除 一条评论，会有 主键依赖问题； 就是 主人回复的 reply，依赖于 评论表的 id
        /**
         * 1_根据Id 获取 到 reply;
         * 2_如果 reply 有 关联的 hostReply, 则先删除 hostReply;
         * 3_删除reply;
         */
        Reply reply = replyDAO.getReply(id);
        if( reply != null ){
            HostReply hostReply = hostReplyService.getHostReplyByReplyId(reply.getId());
            if(hostReply!=null){
                hostReplyService.delHostReply(hostReply.getId());
            }
        }
        replyDAO.delReply(id);
    }

    @Override
    public void delReplyList(Topic topic) {
        List<Reply> replyList = replyDAO.getReplyList(topic);

        if(replyList!=null){
            for(Reply reply: replyList){
                delReply(reply.getId());
            }
        }
    }
}









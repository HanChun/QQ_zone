package azone.pojo;

import java.util.Date;

public class Reply {
    private Integer id ;
    private String content ;// 回复 的内容
    private Date replyDate ;// 回复的 时间
    private UserBasic author ;  //回复的作者 【 这个是 对于当前登录的用户，他有m个回复 】 M:1
    private Topic topic ;       // 回复的主题 M:1
    private HostReply hostReply ;   //1:1 当前 这个reply 只可能 有一个 hostReply

    public Reply(){}

    public Reply(Integer id){this.id=id;}

    public Reply( String content, Date replyDate, UserBasic author, Topic topic ) {
        this.content = content;
        this.replyDate = replyDate;
        this.author = author;
        this.topic = topic;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    public String getContent() {
        return content;
    }
    public void setContent(String content) {
        this.content = content;
    }
    public Date getReplyDate() {
        return replyDate;
    }
    public void setReplyDate(Date replyDate) {
        this.replyDate = replyDate;
    }
    public UserBasic getAuthor() {
        return author;
    }
    public void setAuthor(UserBasic author) {
        this.author = author;
    }

    public Topic getTopic() {
        return topic;
    }

    public void setTopic(Topic topic) {
        this.topic = topic;
    }
    public HostReply getHostReply() {
        return hostReply;
    }
    public void setHostReply(HostReply hostReply) {
        this.hostReply = hostReply;
    }
}

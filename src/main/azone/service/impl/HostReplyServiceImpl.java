package azone.service.impl;

import azone.dao.HostReplyDAO;
import azone.pojo.HostReply;
import azone.service.HostReplyService;

public class HostReplyServiceImpl implements HostReplyService {// idea overwrite 快捷键： ctrl + o
    private HostReplyDAO hostReplyDAO;
    @Override
    public HostReply getHostReplyByReplyId(Integer replyId) {
        return hostReplyDAO.getHostReplyByReplyId(replyId);
    }
    @Override
    public void delHostReply(Integer id) {
        hostReplyDAO.delHostReply(id);
    }
}

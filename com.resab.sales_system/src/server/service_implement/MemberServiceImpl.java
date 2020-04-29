package server.service_implement;

import bean.Member;
import dao.dao_Impl.MemberDaoImpl;
import dao.dao_interface.MemberDao;
import server.service_interface.MemberService;

import java.util.List;

public class MemberServiceImpl implements MemberService {
    MemberDao memberDao = new MemberDaoImpl();

    public Integer insert(Member bean) {
        return memberDao.insert(bean);
    }

    public Integer update(Member bean) {
        return memberDao.update(bean);
    }

    public Integer delete(Integer id) {
        return memberDao.delete(id);
    }

    public List<Member> list() {
        return memberDao.list();
    }

}

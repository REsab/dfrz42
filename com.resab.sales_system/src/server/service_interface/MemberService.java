package server.service_interface;

import bean.Member;

import java.util.List;

public interface MemberService {


    public Integer insert(Member bean);

    public Integer update(Member bean);

    public Integer delete(Integer id);

    public List<Member> list();

}

package dao.dao_interface;

import bean.Member;

import java.util.List;

public interface MemberDao {



    Integer insert(Member bean);

    Integer update(Member bean);

    Integer delete(Integer id);

    List<Member> list();
}

package dao.dao_interface;

import bean.StoreHouse;

import java.util.List;

public interface StoreHouseDao {



    Integer insert(StoreHouse bean);

    Integer update(StoreHouse bean);

    Integer delete(Integer id);

    List<StoreHouse> list();


}

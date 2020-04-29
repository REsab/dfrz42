package server.service_interface;

import bean.StoreHouse;

import java.util.List;

public interface StoreHouseService {
    public Integer insert(StoreHouse bean);

    public Integer update(StoreHouse bean);

    public Integer delete(Integer id);

    public List<StoreHouse> list();

}

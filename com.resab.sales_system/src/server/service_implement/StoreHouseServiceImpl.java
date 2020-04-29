package server.service_implement;

import bean.StoreHouse;
import dao.dao_Impl.StoreHouseDaoImpl;
import server.service_interface.StoreHouseService;

import java.util.List;

public class StoreHouseServiceImpl implements StoreHouseService {
    StoreHouseDaoImpl storeHouseDao = new StoreHouseDaoImpl();

    @Override
    public Integer insert(StoreHouse bean) {
        return storeHouseDao.insert(bean);
    }


    @Override
    public Integer update(StoreHouse bean) {
        return storeHouseDao.update(bean);
    }

    @Override
    public Integer delete(Integer id) {
        return storeHouseDao.delete(id);
    }

    @Override
    public List<StoreHouse> list() {
        return storeHouseDao.list();
    }
}

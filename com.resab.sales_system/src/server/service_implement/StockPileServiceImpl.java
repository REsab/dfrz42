package server.service_implement;

import bean.StockPile;
import dao.dao_Impl.StockPileDaoImpl;
import dao.dao_interface.StockPileDao;

import java.util.List;

public class StockPileServiceImpl implements StockPileDao {
    StockPileDaoImpl stockPileDao = new StockPileDaoImpl();

    @Override
    public Integer insert(StockPile bean) {
        return stockPileDao.insert(bean);
    }

    @Override
    public Integer update(StockPile bean) {
        return stockPileDao.update(bean);
    }

    @Override
    public Integer delete(Integer id) {
        return stockPileDao.delete(id);
    }

    @Override
    public List<StockPile> list() {
        return stockPileDao.list();
    }
}

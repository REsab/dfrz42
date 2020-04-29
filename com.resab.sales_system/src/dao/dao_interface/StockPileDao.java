package dao.dao_interface;

import bean.StockPile;

import java.util.List;

public interface StockPileDao {



    Integer insert(StockPile bean);

    Integer update(StockPile bean);

    Integer delete(Integer id);

    List<StockPile> list();



}

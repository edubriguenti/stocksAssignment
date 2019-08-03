package com.payconiq.stock.service;

import com.payconiq.stock.exception.StockNotFoundException;
import com.payconiq.stock.model.Stock;
import com.payconiq.stock.util.Util;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class StockService {

    private Map<Integer, Stock> stocks;

    @PostConstruct
    private void init(){
        stocks = Util.getStockDatabase();
    }

    public List<Stock> getStocks() {
        return new ArrayList<>(stocks.values());
    }

    public Stock createStock(Stock stock) {
        if (stock.getCurrentPrice() == null || stock.getName() == null)
            throw new IllegalArgumentException("Stock requires price and name");

        Stock newlyCreatedStock = stocks.put(Util.getNextId(), stock);
        return newlyCreatedStock;
    }

    public Stock getStockById(Integer id) {
        return stocks.get(id);
    }

    public Stock updateStock(Integer id, Stock stock) {
        Stock stockDatabase = stocks.get(id);
        if (stockDatabase == null)
            throw new StockNotFoundException("Stock not found");
        stockDatabase.setCurrentPrice(stock.getCurrentPrice());
        return stockDatabase;
    }
}

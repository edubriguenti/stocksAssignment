package com.payconiq.stock.util;

import com.payconiq.stock.model.Stock;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

public final class Util {

    private static final Map<Integer, Stock> stockDatabase = new HashMap<>();
    private static int currentId = 1;

    public static void createStockDatabase() {
        for (; currentId <= 20; currentId++) {
            createStock(currentId, "NFLX" + currentId, Math.random() * 100, LocalDateTime.now());
        }
    }

    public static void createStock(int id, String name, double currentPrice, LocalDateTime lastUpdate) {
        Stock stock = new Stock();
        stock.setId(id);
        stock.setCurrentPrice(BigDecimal.valueOf(currentPrice));
        stock.setLastUpdate(lastUpdate.toString());
        stock.setName(name);
        stockDatabase.put(id, stock);
    }

    public static Map<Integer, Stock> getStockDatabase() {
        if (stockDatabase.isEmpty())
            createStockDatabase();

        return stockDatabase;
    }

    public static int getNextId(){
        return ++currentId;
    }
}

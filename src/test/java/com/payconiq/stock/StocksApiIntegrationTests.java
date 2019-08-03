package com.payconiq.stock;

import com.payconiq.stock.api.StocksApi;
import com.payconiq.stock.model.Stock;
import com.payconiq.stock.util.Util;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@TestPropertySource(locations = "classpath:application.properties")
public class StocksApiIntegrationTests {

    @Autowired
    private StocksApi api;

    @Test
    public void shouldReturnAllStocks() throws Exception {
        Map<Integer, Stock> stockDatabase = Util.getStockDatabase();
        ResponseEntity<List<Stock>> allStocks = api.getAllStocks();
        assertEquals(HttpStatus.OK, allStocks.getStatusCode());
        assertEquals(stockDatabase.size(), allStocks.getBody().size());
    }

    @Test
    public void shouldCreateNewStockItem() throws Exception {
        Stock stock = new Stock();
        stock.setName("AMZO34");
        stock.setCurrentPrice(BigDecimal.TEN);
        ResponseEntity<Void> response = api.createStock(stock);
        assertEquals(HttpStatus.CREATED, response.getStatusCode());
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldReturnExceptionIFNoPriceIsSent() throws Exception {
        Stock stock = new Stock();
        stock.setName("GOGL34");
        ResponseEntity<Void> response = api.createStock(stock);
    }

    @Test
    public void shouldReturnAStock() throws Exception {
        ResponseEntity<Stock> response = api.getStockById(1);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        Stock stock = response.getBody();
        assertEquals("NFLX1", stock.getName());
    }

    @Test
    public void shouldUpdateAStockPrice() throws Exception {
        ResponseEntity<Stock> response = api.getStockById(1);
        Stock stock = response.getBody();
        BigDecimal currentPrice = stock.getCurrentPrice();
        Stock newStockPrice = new Stock();
        newStockPrice.setCurrentPrice(BigDecimal.valueOf(500.0));
        api.updateStockPrice(newStockPrice, 1);
        stock = api.getStockById(1).getBody();
        assertEquals(BigDecimal.valueOf(500.0), stock.getCurrentPrice());
    }


}

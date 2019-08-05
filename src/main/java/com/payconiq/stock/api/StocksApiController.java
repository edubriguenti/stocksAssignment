package com.payconiq.stock.api;

import com.payconiq.stock.model.Stock;
import com.payconiq.stock.service.StockService;
import io.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;
import java.util.List;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2019-08-03T17:00:34.400Z[GMT]")
@Controller
public class StocksApiController implements StocksApi {

    private static final Logger log = LoggerFactory.getLogger(StocksApiController.class);

    @Autowired
    StockService stockService;

    public ResponseEntity<Stock> createStock(@ApiParam(value = "") @Valid @RequestBody Stock body) {
        return new ResponseEntity<Stock>(stockService.createStock(body), HttpStatus.CREATED);
    }

    public ResponseEntity<List<Stock>> getAllStocks() {
        return new ResponseEntity<List<Stock>>(stockService.getStocks(), HttpStatus.OK);
    }

    public ResponseEntity<Stock> getStockById(@ApiParam(value = "ID of stock to return", required = true) @PathVariable("id") Integer id) {
        return new ResponseEntity<Stock>(stockService.getStockById(id), HttpStatus.OK);
    }

    public ResponseEntity<Stock> updateStockPrice(@ApiParam(value = "Stock with new price", required = true) @Valid @RequestBody Stock body, @ApiParam(value = "ID of stock to update", required = true) @PathVariable("id") Integer id) {
        return new ResponseEntity<Stock>(stockService.updateStock(id, body), HttpStatus.OK);
    }

}

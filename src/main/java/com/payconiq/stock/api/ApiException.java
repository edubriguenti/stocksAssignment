package com.payconiq.stock.api;

@javax.annotation.Generated(value = "com.payconiq.stock.codegen.v3.generators.java.SpringCodegen", date = "2019-08-03T16:32:05.573Z[GMT]")
public class ApiException extends Exception{
    private int code;
    public ApiException (int code, String msg) {
        super(msg);
        this.code = code;
    }
}

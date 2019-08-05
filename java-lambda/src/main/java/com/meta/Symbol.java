package com.meta;

/**
 * @author: whp
 * @description:
 * @date: 2019-8-5
 */
public class Symbol {
    private String symbol;
    private Type type;

    public Symbol(String symbol, Type type) {
        this.symbol = symbol;
        this.type = type;
    }
    public  void setType(Type type){
        this.type = type;
    }




    public enum Type{
        INT;
    }
}

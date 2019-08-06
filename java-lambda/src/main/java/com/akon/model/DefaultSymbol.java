package com.akon.model;

import com.akon.imodel.Symbol;

/**
 * @author: whp
 * @description:
 * @date: 2019-8-6
 */
public class DefaultSymbol implements Symbol {
    private String symbolString;

    public DefaultSymbol(String symbolString) {
        this.symbolString = symbolString;
    }
    @Override
    public String getSymbol() {
        return symbolString;
    }
}

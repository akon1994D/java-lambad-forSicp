package com.akon.model;

import com.akon.imodel.Env;
import com.akon.imodel.Symbol;
import com.akon.imodel.Value;
import com.akon.type.JavaType;

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

    @Override
    public Value eval(Env env) {
        return new DefaultValue(JavaType.SYMBOL, symbolString);
    }
}

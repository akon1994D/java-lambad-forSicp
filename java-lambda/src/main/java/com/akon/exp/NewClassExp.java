package com.akon.exp;

import com.akon.imodel.Env;
import com.akon.imodel.Expression;
import com.akon.imodel.Symbol;
import com.akon.imodel.Value;
import com.akon.model.DefaultValue;
import com.akon.type.JavaType;

/**
 * @author: whp
 * @description:
 * @date: 2019-8-7
 */
public class NewClassExp implements Expression {

    private Symbol symbol;

    @Override
    public Value eval(Env env) throws Exception{
        String symbol = this.symbol.getSymbol();
        Class<?> aClass = Class.forName(symbol);
        Object o = aClass.newInstance();
        Value value = new DefaultValue(JavaType.REFERENCE, o);
        return value;
    }
}

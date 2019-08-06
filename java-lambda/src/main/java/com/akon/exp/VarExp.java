package com.akon.exp;

import com.akon.imodel.Env;
import com.akon.imodel.Expression;
import com.akon.imodel.Symbol;
import com.akon.imodel.Value;

/**
 * @author: whp
 * @description:
 * @date: 2019-8-6
 */
public class VarExp implements Expression {

    private Symbol symbol;

    private Expression init;

    public VarExp(Symbol symbol, Expression init) {
        this.symbol = symbol;
        this.init = init;
    }

    @Override
    public Value eval(Env env) {
        Value value = init.eval(env);
        // 求得结果放入到env中
        env.define(symbol, value);
        return value;
    }
}

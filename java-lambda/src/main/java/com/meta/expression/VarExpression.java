package com.meta.expression;

import com.meta.Env;
import com.meta.Expression;
import com.meta.Symbol;
import com.meta.Value;

/**
 * @author: whp
 * @description:
 * @date: 2019-8-5
 */
public class VarExpression extends Expression {

    private Symbol symbol;
    private Symbol varType;

    private Expression init;

    public VarExpression(Symbol symbol, Symbol varType, Expression init) {
        this.symbol = symbol;
        this.varType = varType;
        this.init = init;
    }

    @Override
    public Value eval(Env env) {
        Value value = init.eval(env);
        // 求得结果放入到env中
        symbol.setType(varType);
        env.put(symbol, value);
        return value;
    }
}

package com.meta.expression;

import com.meta.Env;
import com.meta.Expression;
import com.meta.Symbol;
import com.meta.Value;
import com.meta.procedure.Procedure;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: whp
 * @description:  二元运算
 * @date: 2019-8-5
 */
public class BinaryExpression extends Expression {

    public Expression lhs;
    public Expression rhs;
    public Symbol operator;

    @Override
    public Value eval(Env env) {
        Procedure procedure = env.get(operator, Procedure.class);
        Value lhsValue = lhs.eval(env);
        Value rhsValue = rhs.eval(env);
        List<Value> args = new ArrayList<>();
        args.add(lhsValue);
        args.add(rhsValue);
        return procedure.apply(args);
    }
}

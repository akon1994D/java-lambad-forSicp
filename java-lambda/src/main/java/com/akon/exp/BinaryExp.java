package com.akon.exp;

import com.akon.imodel.*;
import com.akon.type.JavaType;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: whp
 * @description:
 * @date: 2019-8-6
 */
public class BinaryExp implements Expression {

    public Expression lhs;
    public Expression rhs;
    public Procedure operator;

    public BinaryExp(Expression lhs, Expression rhs, Symbol symbol) {
        this.lhs = lhs;
        this.rhs = rhs;
        this.operator = getOperator(symbol);
    }

    @Override
    public Value eval(Env env) {
        Value lvalue = lhs.eval(env);
        Value rvalue = rhs.eval(env);
        List<Value> list = new ArrayList<>();
        list.add(lvalue);
        list.add(rvalue);
        Value value = operator.apply(list, env);
        return value;
    }

    private static Procedure getOperator(Symbol symbol){




        Procedure procedure = new Procedure() {
            @Override
            public Value apply(List<Value> args, Env env) {
                return null;
            }

            @Override
            public JavaType getType() {
                return JavaType.PROCEDURE;
            }

            @Override
            public Object getValue() {
                return null;
            }
        };
        return procedure;
    }




}

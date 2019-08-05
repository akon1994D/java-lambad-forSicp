package com.meta.util;

import com.meta.Expression;
import com.meta.Symbol;
import com.meta.expression.BinaryExpression;
import com.meta.expression.VarExpression;

/**
 * @author: whp
 * @description:
 * @date: 2019-8-5
 */
public class Parser {

    public static Expression parse(String str){
        VarExpression varExpression = new VarExpression(
                new Symbol("i", Symbol.Type.INT),
                new BinaryExpression());

        return  null;
    }
}

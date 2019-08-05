package com.meta;

import com.meta.util.Parser;

/**
 * @author: whp
 * @description:
 * @date: 2019-8-5
 */
public class Eval {


    public static void main(String[] args) {
        Expression expression = Parser.parse("");
        Env env = Env.instance();
        expression.eval(env);
    }

}

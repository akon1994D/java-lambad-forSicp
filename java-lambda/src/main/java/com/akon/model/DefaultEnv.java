package com.akon.model;

import com.akon.imodel.Env;
import com.akon.imodel.Symbol;
import com.akon.imodel.Value;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: whp
 * @description:
 * @date: 2019-8-6
 */
public class DefaultEnv implements Env {

    private Map<Symbol,Value> env;

    @Override
    public Value getValue(Symbol symbol) {
        return  env.get(symbol);
    }

    @Override
    public Value define(Symbol symbol,Value value) {
        Value v = env.put(symbol, value);
        return v;
    }

    private DefaultEnv(Map<Symbol, Value> env) {
        this.env = env;
    }

    public static Env newInstance() {
        return new DefaultEnv(new HashMap<>());
    }
    public static Env newInstance(Map<Symbol, Value> env) {
        return new DefaultEnv(env);
    }
}

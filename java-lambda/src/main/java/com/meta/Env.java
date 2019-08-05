package com.meta;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: whp
 * @description:
 * @date: 2019-8-5
 */
public class Env {

    private Map<Symbol,Value> map = new HashMap<>();

    public Value put(Symbol symbol,Value value){
        return map.put(symbol, value);
    }

    public <T> T get(Symbol symbol,Class<T> clazz){
        Value value = map.get(symbol);
        return (T) value;
    }

    public static Env instance(){
        return  new Env();
    }
}

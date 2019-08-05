package com.meta.procedure;

import com.meta.Symbol;
import com.meta.Value;

import java.util.List;

/**
 * @author: whp
 * @description:
 * @date: 2019-8-5
 */
public class PrimaryProcedure extends Procedure{
    private Symbol type;

    @Override
    public void setType(Symbol type) {
        this.type = type;
    }

    @Override
    public Value apply(List<Value> args) {
        return null;
    }
}

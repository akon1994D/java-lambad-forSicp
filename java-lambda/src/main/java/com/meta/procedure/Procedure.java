package com.meta.procedure;

import com.meta.Value;

import java.util.List;

/**
 * @author: whp
 * @description:
 * @date: 2019-8-5
 */
public abstract class Procedure extends Value{

    public abstract Value apply(List<Value> args);
}

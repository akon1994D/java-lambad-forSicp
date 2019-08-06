package com.akon.imodel;

/**
 * @author: whp
 * @description:
 * @date: 2019-8-6
 */
public interface Env {

    Value getValue(Symbol symbol);

    Value define(Symbol symbol,Value value);
}

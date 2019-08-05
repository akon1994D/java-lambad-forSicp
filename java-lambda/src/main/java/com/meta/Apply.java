package com.meta;

import com.meta.procedure.Procedure;

import java.util.List;

/**
 * @author: whp
 * @description:
 * @date: 2019-8-5
 */
public class Apply {

    public static Object apply(Procedure procedure, List<Value> args){
        return  procedure.apply(args);
    }

}

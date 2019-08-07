package com.akon.exp;

import com.akon.imodel.Env;
import com.akon.imodel.Expression;
import com.akon.imodel.Symbol;
import com.akon.imodel.Value;
import com.akon.model.DefaultValue;
import com.akon.type.JavaType;

/**
 * @author: whp
 * @description:
 * @date: 2019-8-6
 */
public class LiteralExp implements Expression {
    private Value value;

    public LiteralExp(Object object) {
        JavaType type = JavaType.getType(object);
        this.value = new DefaultValue(type, object);
    }

    @Override
    public Value eval(Env env) throws Exception{
        if(value.getType().equals(JavaType.REFERENCE)){
            return env.getValue((Symbol)value.getValue());
        }else{
            return value;
        }
    }
}

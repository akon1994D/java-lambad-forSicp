package com.akon.model;

import com.akon.imodel.Value;
import com.akon.type.JavaType;

/**
 * @author: whp
 * @description:
 * @date: 2019-8-6
 */
public class DefaultValue implements Value {
    private JavaType javaType;
    private Object value;

    public DefaultValue(JavaType javaType, Object value) {
        this.javaType = javaType;
        this.value = value;
    }

    @Override
    public JavaType getType() {
        return javaType;
    }

    @Override
    public Object getValue() {
        return value;
    }


    @Override
    public String toString() {
        return value.toString();
    }
}

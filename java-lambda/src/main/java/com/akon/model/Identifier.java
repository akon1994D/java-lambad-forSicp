package com.akon.model;

import com.akon.type.JavaType;

/**
 * @author: whp
 * @description:
 * @date: 2019-8-6
 */
public class Identifier extends DefaultSymbol {
    private JavaType type;

    public Identifier(String symbolString, JavaType type) {
        super(symbolString);
        this.type = type;
    }
    public JavaType getType() {
        return type;
    }

    public void setType(JavaType type) {
        this.type = type;
    }
}

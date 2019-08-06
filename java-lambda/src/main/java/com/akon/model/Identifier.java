package com.akon.model;

/**
 * @author: whp
 * @description:
 * @date: 2019-8-6
 */
public class Identifier extends DefaultSymbol {
    private String type;

    public Identifier(String symbolString, String type) {
        super(symbolString);
        this.type = type;
    }
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}

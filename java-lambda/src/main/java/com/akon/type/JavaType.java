package com.akon.type;

public enum JavaType {

    BYTE,
    SHORT,
    INT,
    LONG,
    CHAR,
    FLOAT,
    DOUBLE,
    REFERENCE,
    PROCEDURE;

    public static JavaType getType(Object o){
        if(o instanceof Byte){
            return JavaType.BYTE;
        }else if (o instanceof  Short){
            return JavaType.SHORT;
        }else if (o instanceof  Integer){
            return JavaType.INT;
        }else if (o instanceof  Long){
            return JavaType.LONG;
        }else if (o instanceof  Character){
            return JavaType.CHAR;
        }else if (o instanceof  Float){
            return JavaType.FLOAT;
        }else if (o instanceof  Double){
            return JavaType.DOUBLE;
        }else{
            return JavaType.REFERENCE;
        }
    }



}

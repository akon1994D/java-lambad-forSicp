package com.akon.type;

import com.akon.imodel.Value;

import java.util.List;
import java.util.Optional;

public enum JavaType {
    //（byte、short、char）---> int ---> long ---> folat ---> double
    BYTE(0x01),
    SHORT(0x01),
    CHAR(0x01),
    INT(0x02),
    LONG(0x03),
    FLOAT(0x04),
    DOUBLE(0x05),
    REFERENCE(0x06),
    PROCEDURE(0x07);

    int value;

    JavaType(int value) {
        this.value = value;
    }

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
    public static JavaType change(List<Value> values){
        Optional<Value> reduce = values.stream().reduce((x, y) -> x.getType().value > y.getType().value ? x : y);
        return reduce.get().getType();
    }

}

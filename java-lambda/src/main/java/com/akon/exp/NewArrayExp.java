package com.akon.exp;

import com.akon.imodel.Env;
import com.akon.imodel.Expression;
import com.akon.imodel.Value;
import com.akon.type.JavaType;

import java.util.List;

/**
 * @author: whp
 * @description:
 * @date: 2019-8-7
 */
public class NewArrayExp implements Expression {

    private List<Expression> elems;
    private Expression dims; // 只考虑一维数据先
    private JavaType elemtype;

    private NewArrayExp() { }

    public static NewArrayExp newInstanceByDims(Expression dims,JavaType elemtype){
        NewArrayExp exp = new NewArrayExp();
        exp.dims = dims;
        exp.elemtype = elemtype;
        return exp;
    }
    public static NewArrayExp newInstanceByElems(List<Expression> elems){
        NewArrayExp exp = new NewArrayExp();
        exp.elems = elems;
        return exp;
    }

    @Override
    public Value eval(Env env) throws Exception{
        if(dims!=null){
            Value dim = dims.eval(env);
            assert dim.getType().equals(JavaType.INT);
            int value = (int) dim.getValue();


        }else {

        }
        return null;
    }
}

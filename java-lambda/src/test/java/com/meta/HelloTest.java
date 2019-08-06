package com.meta;

import com.akon.exp.BinaryExp;
import com.akon.exp.LiteralExp;
import com.akon.exp.VarExp;
import com.akon.imodel.Env;
import com.akon.imodel.Expression;
import com.akon.imodel.Symbol;
import com.akon.imodel.Value;
import com.akon.model.DefaultEnv;
import com.akon.model.DefaultSymbol;
import com.akon.model.Identifier;
import com.akon.type.JavaType;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 * @author: whp
 * @description:
 * @date: 2019-8-6
 */
public class HelloTest {
    @Test
    public void testLiteralExp(){
        LiteralExp exp = new LiteralExp('a');
        Env env = DefaultEnv.newInstance();
        Value value = exp.eval(env);
        assertTrue(value.toString().equals("a"));
    }

    @Test
    public void testVarExp(){
        // int i = 1;
        LiteralExp exp = new LiteralExp(1);
        Identifier identifier = new Identifier("j", "int");
        VarExp varExp = new VarExp( identifier, exp);

        Env env = DefaultEnv.newInstance();
        Value value = varExp.eval(env);
        assertTrue(value.equals(env.getValue(identifier)));
    }

    @Test
    public void testBinaryExp(){
        // int i = 1 + 2;
        Expression l = new LiteralExp(1);
        Expression r = new LiteralExp(2);
        Symbol identifier = new Identifier("j", "int");
        Expression binaryExp = new BinaryExp(l, r, new DefaultSymbol("+"));
        VarExp varExp = new VarExp( identifier, binaryExp);
        Env env = DefaultEnv.newInstance();
        Value value = varExp.eval(env);

        assertTrue(value.equals(env.getValue(identifier)));
        assertTrue(value.getValue().equals(3));
        assertTrue(value.getType().equals(JavaType.INT));
    }


}

package com.akon.exp;

import com.akon.imodel.*;
import com.akon.model.DefaultValue;
import com.akon.type.JavaType;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;

/**
 * @author: whp
 * @description:
 * @date: 2019-8-6
 */

/***
 *             case POS:     return "+";
 *             case NEG:     return "-";
 *             case NOT:     return "!";
 *             case COMPL:   return "~";
 *             case PREINC:  return "++";
 *             case PREDEC:  return "--";
 *             case POSTINC: return "++";
 *             case POSTDEC: return "--";
 *             case NULLCHK: return "<*nullchk*>";
 *             case OR:      return "||";
 *             case AND:     return "&&";
 *             case EQ:      return "==";
 *             case NE:      return "!=";
 *             case LT:      return "<";
 *             case GT:      return ">";
 *             case LE:      return "<=";
 *             case GE:      return ">=";
 *             case BITOR:   return "|";
 *             case BITXOR:  return "^";
 *             case BITAND:  return "&";
 *             case SL:      return "<<";
 *             case SR:      return ">>";
 *             case USR:     return ">>>";
 *             case PLUS:    return "+";
 *             case MINUS:   return "-";
 *             case MUL:     return "*";
 *             case DIV:     return "/";
 *             case MOD:     return "%";
 */
public class BinaryExp implements Expression {

    public Expression lhs;
    public Expression rhs;
    public Procedure operator;

    public BinaryExp(Expression lhs, Expression rhs, Symbol symbol) {
        this.lhs = lhs;
        this.rhs = rhs;
        this.operator = getOperator(symbol);
    }

    @Override
    public Value eval(Env env) throws Exception{
        Value lvalue = lhs.eval(env);
        Value rvalue = rhs.eval(env);
        List<Value> list = new ArrayList<>();
        list.add(lvalue);
        list.add(rvalue);
        Value value = operator.apply(list, env);
        return value;
    }

    private static Procedure getOperator(Symbol symbol){
        Procedure procedure = new Procedure() {
            @Override
            public Value apply(List<Value> args, Env env) {
                Operator operator = Operator.getOperator(symbol.getSymbol());
                Value value = operator.invoke(args);
                return value;
            }

            @Override
            public JavaType getType() {
                return JavaType.PROCEDURE;
            }

            @Override
            public Object getValue() {
                return this;
            }
        };
        return procedure;
    }

    /**
     * TODO 基本运算
     */
    private enum Operator{
        PLUS("+"),MINUS("-"),MUL("*"),DIV("/"),MOD("%");

        Operator(String symbol) {
            this.symbol = symbol;
        }

        private String symbol;


        public static Operator getOperator(String str){
            Operator[] values = values();
            for (Operator value : values) {
                if(value.symbol.equals(str)){
                    return value;
                }
            }
            throw new IllegalArgumentException();
        }
        public Value invoke(List<Value> args){
            Value value;
            switch (this){
                case PLUS: value = plus(args);break;
                case MINUS: value = minus(args);break;
                case MUL: value = mul(args);break;
                case DIV: value = div(args);break;
                case MOD: value = mod(args);break;
                default:throw  new IllegalArgumentException();
            }
            return value;
        }

        //（byte、short、char）---> int ---> long ---> folat ---> double
        public static Value plus(List<Value> args){
            JavaType type = JavaType.change(args);
            Object rvalue = args.get(0).getValue();
            Object lvalue = args.get(1).getValue();
            Value value;
            switch (type){
                case BYTE:  value = new DefaultValue(JavaType.INT,(byte) rvalue + (byte) lvalue);break;
                case CHAR:  value = new DefaultValue(JavaType.INT,(char) rvalue + (char) lvalue);break;
                case SHORT: value = new DefaultValue(JavaType.INT,(short) rvalue + (short) lvalue);break;
                case INT:   value = new DefaultValue(JavaType.INT,(int) rvalue + (int) lvalue);break;
                case FLOAT: value = new DefaultValue(JavaType.FLOAT,(float) rvalue + (float) lvalue);break;
                case LONG:  value = new DefaultValue(JavaType.LONG,(long) rvalue + (long) lvalue);break;
                default: throw new IllegalArgumentException();
            }
            return value;
        }
        public static Value minus(List<Value> args){
            JavaType type = JavaType.change(args);
            Object rvalue = args.get(0).getValue();
            Object lvalue = args.get(1).getValue();
            Value value;
            switch (type){
                case BYTE:  value = new DefaultValue(JavaType.INT,(byte) rvalue - (byte) lvalue);break;
                case CHAR:  value = new DefaultValue(JavaType.INT,(char) rvalue - (char) lvalue);break;
                case SHORT: value = new DefaultValue(JavaType.INT,(short) rvalue - (short) lvalue);break;
                case INT:   value = new DefaultValue(JavaType.INT,(int) rvalue - (int) lvalue);break;
                case FLOAT: value = new DefaultValue(JavaType.FLOAT,(float) rvalue - (float) lvalue);break;
                case LONG:  value = new DefaultValue(JavaType.LONG,(long) rvalue - (long) lvalue);break;
                case DOUBLE: value = new DefaultValue(JavaType.DOUBLE,(double) rvalue - (double) lvalue);break;
                default: throw new IllegalArgumentException();
            }

            return value;
        }
        public static Value mul(List<Value> args){
            JavaType type = JavaType.change(args);
            Object rvalue = args.get(0).getValue();
            Object lvalue = args.get(1).getValue();
            Value value;
            switch (type){
                case BYTE:  value = new DefaultValue(JavaType.INT,(byte) rvalue * (byte) lvalue);break;
                case CHAR:  value = new DefaultValue(JavaType.INT,(char) rvalue * (char) lvalue);break;
                case SHORT: value = new DefaultValue(JavaType.INT,(short) rvalue * (short) lvalue);break;
                case INT:   value = new DefaultValue(JavaType.INT,(int) rvalue * (int) lvalue);break;
                case FLOAT: value = new DefaultValue(JavaType.FLOAT,(float) rvalue * (float) lvalue);break;
                case LONG:  value = new DefaultValue(JavaType.LONG,(long) rvalue * (long) lvalue);break;
                case DOUBLE: value = new DefaultValue(JavaType.DOUBLE,(double) rvalue * (double) lvalue);break;
                default: throw new IllegalArgumentException();
            }

            return value;
        }
        public static Value div(List<Value> args){
            JavaType type = JavaType.change(args);
            Object rvalue = args.get(0).getValue();
            Object lvalue = args.get(1).getValue();
            Value value;
            switch (type){
                case BYTE:  value = new DefaultValue(JavaType.INT,(byte) rvalue / (byte) lvalue);break;
                case CHAR:  value = new DefaultValue(JavaType.INT,(char) rvalue / (char) lvalue);break;
                case SHORT: value = new DefaultValue(JavaType.INT,(short) rvalue / (short) lvalue);break;
                case INT:   value = new DefaultValue(JavaType.INT,(int) rvalue / (int) lvalue);break;
                case FLOAT: value = new DefaultValue(JavaType.FLOAT,(float) rvalue / (float) lvalue);break;
                case LONG:  value = new DefaultValue(JavaType.LONG,(long) rvalue / (long) lvalue);break;
                case DOUBLE: value = new DefaultValue(JavaType.DOUBLE,(double) rvalue / (double) lvalue);break;
                default: throw new IllegalArgumentException();
            }

            return value;
        }
        public static Value mod(List<Value> args){
            JavaType type = JavaType.change(args);
            Object rvalue = args.get(0).getValue();
            Object lvalue = args.get(1).getValue();
            Value value;
            switch (type){
                case BYTE:  value = new DefaultValue(JavaType.INT,(byte) rvalue % (byte) lvalue);break;
                case CHAR:  value = new DefaultValue(JavaType.INT,(char) rvalue % (char) lvalue);break;
                case SHORT: value = new DefaultValue(JavaType.INT,(short) rvalue % (short) lvalue);break;
                case INT:   value = new DefaultValue(JavaType.INT,(int) rvalue % (int) lvalue);break;
                case FLOAT: value = new DefaultValue(JavaType.FLOAT,(float) rvalue % (float) lvalue);break;
                case LONG:  value = new DefaultValue(JavaType.LONG,(long) rvalue % (long) lvalue);break;
                case DOUBLE: value = new DefaultValue(JavaType.DOUBLE,(double) rvalue % (double) lvalue);break;
                default: throw new IllegalArgumentException();
            }
            return value;
        }
    }
}

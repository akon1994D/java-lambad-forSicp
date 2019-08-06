package com.akon.imodel;

import java.util.List;

public interface Procedure extends Value{

    Value apply(List<Value> args,Env env);

}

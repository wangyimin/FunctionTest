package com.wang;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class Functions implements Ifunction{
    @SuppressWarnings("unchecked")
    public <T> T convert(String s, Class<T> type) {
        try{
            Constructor<T> c  = type.getConstructor(String.class);
            if (c != null) return (T)c.newInstance(s);

            Method m = type.getMethod("valueOf", String.class);
            if (m != null) return (T)m.invoke(null, new Object[]{s});
        }catch(Exception e){}
        
        return null;
    }

    public boolean filter(String s){
        if (convert(s, Integer.class) % 2 == 0){
            return true;
        }

        return false;
    }
}

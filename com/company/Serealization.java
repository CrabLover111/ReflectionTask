package com.company;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;

public class Serealization {

    public Object serialize(Object obj) throws IllegalAccessException {
        ArrayList<Object> strg = new ArrayList<>();
        Class cls = obj.getClass();

        Field[] fld = cls.getDeclaredFields();

        for (Field f : fld) {
            if(f.isAnnotationPresent(Save.class))
                {
                    if (String.class.equals(f.getType())) {
                        strg.add(f.get(obj));
                    }
                    else if(f.getType().equals(int.class)) {
                        strg.add(f.getInt(obj));
                    }
                    else if(f.getType().equals(float.class)) {
                        strg.add(f.getFloat(obj));
                    }
                    //and so on


                }
            if(Modifier.isPrivate(f.getModifiers())){
                f.setAccessible(true);
            }

        }
        return strg;
    }
    public Object deser(ArrayList<Object> ARO, Object obj) {

        for(Object o : ARO) {

        }
    }
}

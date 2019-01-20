package com.zipcodewilmington.generic;

/**
 * @author leon on 06/12/2018.
 */

import com.github.git_leon.collectionutils.maps.IntrospectiveMap;
import sun.reflect.generics.reflectiveObjects.TypeVariableImpl;
import sun.reflect.generics.tree.FieldTypeSignature;
import sun.reflect.generics.tree.SimpleClassTypeSignature;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;

/**
 * @author leon on 05/12/2018.
 * This class exists for testing purposes
 */
public class ClassWrapper {
    private final TypeVariableImpl type;
    private final Object object;

    public ClassWrapper(Object o, int parameterizedIndex) {
        Class<?>  cls = o.getClass();
        Type superType = cls.getGenericSuperclass();
        ParameterizedType parameterizedClassType = (ParameterizedType)superType;
        Type[] parameterizedTypes = parameterizedClassType.getActualTypeArguments();
        Type typeOfClassParameterization = parameterizedTypes[parameterizedIndex];
        this.object = o;
        this.type = (TypeVariableImpl) typeOfClassParameterization;
    }

    private Field getBoundASTsAsField() {
        Field f = null;
        try {
            f = type.getClass().getDeclaredField("boundASTs");
            f.setAccessible(true);
        } catch (Throwable e) {
            throw new Error(e);
        }
        return f;
    }

    public String getParameterizedType(){
        Field boundASTs = getBoundASTsAsField();
        FieldTypeSignature[] f;
        try {
            f = (FieldTypeSignature[]) boundASTs.get(type);
            return getUpperBoundOfType(f);
        } catch (IllegalAccessException e) {
            throw new Error(e);
        }
    }


    private String getUpperBoundOfType(FieldTypeSignature[] fieldTypeSignatures) {
        try {
            FieldTypeSignature fieldTypeSignature = fieldTypeSignatures[0];
            Class<? extends FieldTypeSignature> clss = fieldTypeSignature.getClass();
            Field field = clss.getDeclaredField("path");
            field.setAccessible(true);
            List<? extends SimpleClassTypeSignature> list = (List<? extends SimpleClassTypeSignature>) field.get(fieldTypeSignature);
            Map m = new IntrospectiveMap(list.get(0));
            return m.get("name").toString();
        } catch (Throwable e) {
            throw new Error(e);
        }
    }
}


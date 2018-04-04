package com.pmcb.sbexp;

import java.lang.reflect.Method;

public class TestUtils {

    public static Object genericInvokMethod(Object obj, String methodName,
                                            Object... params) throws Exception {
        Method method;
        Object requiredObj = null;
        int paramCount = params.length;
        Class<?>[] classArray = new Class<?>[paramCount];
        for (int i = 0; i < paramCount; i++) {
            classArray[i] = params[i].getClass();
        }
        method = obj.getClass().getDeclaredMethod(methodName, classArray);
        method.setAccessible(true);
        requiredObj = method.invoke(obj, params);

        return requiredObj;
    }
}

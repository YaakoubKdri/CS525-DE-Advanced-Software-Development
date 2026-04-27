package framework;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.reflections.Reflections;

public class FWContext {

	private static List<Object> objectMap = new ArrayList<>();

	public FWContext() {
		try {
            Reflections reflections = new Reflections("");

            Set<Class<?>> serviceTypes = reflections.getTypesAnnotatedWith(Service.class);
            for(Class<?> implementationClass : serviceTypes){
                objectMap.add(implementationClass.newInstance());
            }
			// find and instantiate all classes annotated with the @TestClass annotation
			Set<Class<?>> types = reflections.getTypesAnnotatedWith(TestClass.class);
			for (Class<?> implementationClass : types) {
				objectMap.add((Object) implementationClass.newInstance());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
        performDI();
	}

    private void performDI() {
        try{
            for (Object obj : objectMap){
                for(Field field : obj.getClass().getDeclaredFields()){
                    if(field.isAnnotationPresent(Inject.class)){
                        Class<?> fieldType = field.getType();
                        Object dependency = getBeanOfType(fieldType);
                        field.setAccessible(true);
                        field.set(obj, dependency);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private Object getBeanOfType(Class<?> interfaceType) {
        for(Object obj : objectMap){
            Class<?>[] interfaces = obj.getClass().getInterfaces();
            for(Class<?> i : interfaces){
                if(i.equals(interfaceType)){
                    return obj;
                }
            }
        }
        return null;
    }

    public void start() {
		try {
			for (Object theTestClass : objectMap) {
                Method beforeMethod = null;

                for(Method method : theTestClass.getClass().getDeclaredMethods()){
                    if(method.isAnnotationPresent(Before.class)){
                        beforeMethod = method;
                    }
                }
				// find all methods annotated with the @Test annotation
				for (Method method : theTestClass.getClass().getDeclaredMethods()) {
					if (method.isAnnotationPresent(Test.class)) {

                        if(beforeMethod != null){
                            beforeMethod.invoke(theTestClass);
                        }
						method.invoke(theTestClass);
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

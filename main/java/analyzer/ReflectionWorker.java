package analyzer;

import fillers.Filler;
import fillers.Fillers;
import org.reflections.Reflections;
import org.reflections.scanners.SubTypesScanner;
import sorters.Sort;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Iterator;
import java.util.LinkedList;

/**
 * Created by User on 01.11.2017.
 * @author shvets
 * @version 1.0
 */
public class ReflectionWorker {

    private LinkedList<Sort> sorts;
    private LinkedList<Method> fillers;

    public ReflectionWorker() {
        sorts = new LinkedList<Sort>();

        LinkedList<Class<?>> buf = findSorts();
        for (Iterator iterator = buf.iterator(); iterator.hasNext(); ) {
            try {
                Class bufClass = Class.forName(iterator.next().toString().split(" ")[1]);
                //System.out.println(bufClass.getName());
                Object obj = bufClass.newInstance();
                Sort sort = (Sort) obj;
                sorts.add(sort);
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }

        fillers = findFillers();
    }

    private LinkedList<Method> findFillers() {
        Fillers fillers = new Fillers();
        Class<?> c = fillers.getClass();
        Method[] allMethods = c.getMethods();
        LinkedList<Method> fillersList = new LinkedList<Method>();
        for (Method method : allMethods) {
            if (method.getAnnotation(Filler.class) != null) {
                fillersList.add(method);
            }
        }
        return fillersList;
    }

    private LinkedList<Class<?>> findSorts() {
        Reflections reflections = new Reflections(Sort.class.getPackage().getName(), new SubTypesScanner());
        LinkedList<Class<?>> subTypes = new LinkedList<Class<?>>();
        for (String className : reflections.getStore().get(SubTypesScanner.class.getSimpleName()).values()) {
            try {
                Class subType = Class.forName(className);
                if (Sort.class.isAssignableFrom(subType) && !Modifier.isAbstract(subType.getModifiers())) {
                    subTypes.add(subType);
                }
            } catch (ClassNotFoundException e) {
                throw new RuntimeException("no such class", e);
            }
        }
        return subTypes;
    }

    public LinkedList<Sort> getSorts() {
        return sorts;
    }

    public LinkedList<Method> getFillers() {
        return fillers;
    }

    public LinkedList<String> getSortsNames() {
        LinkedList<String> names = new LinkedList<>();
        for(Sort sort: sorts) {
            names.add(sort.getClass().getSimpleName());
        }
        return names;
    }
}

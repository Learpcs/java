import java.awt.*;
import java.lang.reflect.*;
import java.util.*;

class Randomizer {
    private static Random rnd = new Random();

    public static <T> T getRandomObject(Class<T> cls) throws Exception {
        System.out.printf("Start: %s %s %s\n", cls.getName(), cls.isPrimitive(), cls.isArray());
        if (cls.isPrimitive()) {
            if (cls == int.class) {
                return (T) (Object) (int) rnd.nextInt();
            }
            if (cls == byte.class) {
                return (T) (Object) (byte) rnd.nextInt(256);
            }
            if (cls == char.class) {
                return (T) (Object) (char) ('a' + rnd.nextInt(26));
            }
            if (cls == float.class) {
                return (T) (Object) (float) rnd.nextFloat();
            }
            if (cls == double.class) {
                return (T) (Object) (double) rnd.nextDouble();
            }
        }

        if (cls.isArray()) {
            Object[] arr = new Object[rnd.nextInt(10) + 1];
            for (int i = 0; i < arr.length; ++i) {
                System.out.println(cls.getComponentType());
                arr[i] = getRandomObject(cls.getComponentType());
            }
            return Arrays.copyOf(arr, arr.length, T.class);
        }

        Constructor[] ctrList = cls.getDeclaredConstructors();
        Collections.shuffle(Arrays.asList(ctrList));
        System.out.println(ctrList.length);
        for (Constructor ctr : ctrList) {
            System.out.
        }

        Constructor ctr = null;

        for (Constructor c : ctrList) {
            System.out.println(c.getModifiers());
            if (Modifier.isPublic(c.getModifiers())) {
                ctr = c;
                break;
            }
        }

        if (ctr == null) {
            throw new Exception("All constructors are private");
        }

        Object[] invokeParms = new Object[ctr.getParameterCount()];
        Class[] ctrParams = ctr.getParameterTypes();
        for (int i = 0; i < invokeParms.length; i++) {
            invokeParms[i] = getRandomObject(ctrParams[i]);
        }
        T obj = (T)ctr.newInstance(invokeParms);
        //System.out.println(obj.toString());
        return obj;
    }
}

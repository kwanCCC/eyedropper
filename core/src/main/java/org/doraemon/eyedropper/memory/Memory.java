package org.doraemon.eyedropper.memory;

import java.lang.reflect.Field;
import java.util.StringTokenizer;

import com.typesafe.config.Config;
import com.typesafe.config.ConfigException;
import com.typesafe.config.ConfigFactory;
import org.doraemon.eyedropper.allocate.JNAMemoryAllocater;
import org.doraemon.eyedropper.allocate.MemoryAllocater;
import org.doraemon.eyedropper.allocate.UnsafeMemoryAllocater;
import sun.misc.Unsafe;

/**
 * Created by SDE on 2018/1/23.
 */
public final class Memory {

    private static final Unsafe unsafe;
    private static final MemoryAllocater allocater;

    static {
        try {
            Field field = sun.misc.Unsafe.class.getDeclaredField("theUnsafe");
            field.setAccessible(true);
            unsafe = (sun.misc.Unsafe)field.get(null);
        } catch (Exception e) {
            throw new AssertionError(e);
        }
        Config config = ConfigFactory.load();
        String allocate;
        try {
            allocate = config.getString("allocate");
        } catch (ConfigException.Missing missing) {
            allocate = "jna";
        }
        if (allocate.equals("jna")) {
            allocater = new JNAMemoryAllocater();
        } else if (allocate.equals("unsafe")) {
            allocater = new UnsafeMemoryAllocater();
        } else {
            allocater = new JNAMemoryAllocater();
        }
        String javaVersion = System.getProperty("java.version");
        if (javaVersion.indexOf('-') != -1) { javaVersion = javaVersion.substring(0, javaVersion.indexOf('-')); }
        StringTokenizer st = new StringTokenizer(javaVersion, ".");
        int major = Integer.parseInt(st.nextToken());
        int minor = st.hasMoreTokens() ? Integer.parseInt(st.nextToken()) : 0;

    }

}

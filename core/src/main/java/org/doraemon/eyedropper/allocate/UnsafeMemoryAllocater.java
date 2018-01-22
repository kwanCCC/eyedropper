package org.doraemon.eyedropper.allocate;

import java.lang.reflect.Field;

import sun.misc.Unsafe;

/**
 * Created by SDE on 2018/1/22.
 */
public class UnsafeMemoryAllocater implements MemoryAllocater {
    static final Unsafe unsafe;

    static {
        try {
            Field field = sun.misc.Unsafe.class.getDeclaredField("theUnsafe");
            field.setAccessible(true);
            unsafe = (sun.misc.Unsafe)field.get(null);
        } catch (Exception e) {
            throw new AssertionError(e);
        }
    }

    public long allocate(long size) {
        try {
            return unsafe.allocateMemory(size);
        } catch (OutOfMemoryError oom) {
            return 0L;
        }
    }

    public void free(long peer) {
        unsafe.freeMemory(peer);
    }
}

package org.doraemon.eyedropper.allocate;

import com.sun.jna.Native;

/**
 * Created by peanut on 2018/1/22.
 */
public class JNAMemoryAllocater implements MemoryAllocater {

    public long allocate(long length) {
        return Native.malloc(length);
    }

    public void free(long address) {
        Native.free(address);
    }
}

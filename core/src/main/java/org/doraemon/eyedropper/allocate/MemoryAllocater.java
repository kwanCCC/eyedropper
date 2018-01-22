package org.doraemon.eyedropper.allocate;

/**
 * Created by peanut on 2018/1/22.
 */
public interface MemoryAllocater {

    /**
     * allocate memory of length
     *
     * @param length
     * @return the memory's address
     */
    long allocate(long length);

    /**
     * free the memory Occupied
     * @param address
     */
    void free(long address);
}

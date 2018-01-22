package org.doraemon.eyedropper.queue;

/**
 * Created by SDE on 2018/1/22.
 */
public interface Queue {

    void offer(byte[] content);

    byte[] poll();

}

package org.doraemon.eyedropper.block;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.WritableByteChannel;

import org.doraemon.eyedropper.allocate.JNAMemoryAllocater;
import org.junit.Test;

/**
 * Created by SDE on 2018/1/23.
 */
public class BlockTest {

    @Test
    public void test() {
        byte[] a = new byte[10];
        ByteBuffer buffer = ByteBuffer.wrap(a);
        //after serilizer

        JNAMemoryAllocater allocater = new JNAMemoryAllocater();
        long address = allocater.allocate(1024 * 1024);




        BlockWriteableChannel channel = new BlockWriteableChannel();

    //    WTF place FUCK FUCK

    }

    class BlockWriteableChannel implements WritableByteChannel {



        public int write(ByteBuffer src) throws IOException {

            return 0;
        }

        public boolean isOpen() {
            return false;
        }

        public void close() throws IOException {

        }
    }

}
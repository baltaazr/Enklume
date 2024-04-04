package io.xol.enklume.nbt;

import java.io.IOException;
import java.io.DataInputStream;

public class NBTLongArray extends NBTNamed {

    int size;
    public long[] data;

    @Override
    void feed(DataInputStream is) throws IOException {
        super.feed(is);
        size = is.read() << 24;
        size += is.read() << 16;
        size += is.read() << 8;
        size += is.read();

        data = new long[size];
        for (int i = 0; i < size; i++) {
            long y = is.read() << 56;
            y += is.read() << 48;
            y += is.read() << 40;
            y += is.read() << 32;
            y += is.read() << 24;
            y += is.read() << 16;
            y += is.read() << 8;
            y += is.read();
            data[i] = y;
        }
    }
}


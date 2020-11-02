package mayton.tinyasm.asm;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class X86Builder {

    ByteArrayOutputStream out = new ByteArrayOutputStream();
    DataOutputStream dos = new DataOutputStream(out);

    public X86Builder() {

    }

    public X86Builder mov(Registers32bit r32_1, Registers32bit r32_2) throws IOException {
        dos.writeByte(0x01);
        return this;
    }

    public X86Builder interrupt(int code) {

        return this;
    }

    public X86Builder mov(Registers32bit r32_1, int value) {

        return this;
    }

    public X86Builder addps(RegistersXMM r0, RegistersXMM r1) {

        return this;
    }



    public ByteArrayOutputStream dump() {
        return out;
    }
}

package mayton.tinyasm;

import mayton.tinyasm.asm.X86Builder;

import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import static mayton.tinyasm.asm.Registers32bit.ebx;
import static mayton.tinyasm.asm.Registers32bit.ecx;
import static mayton.tinyasm.asm.Registers32bit.edx;

public class Main {

    public static void main(String[] args) throws IOException {

        X86Builder x86Builder = new X86Builder();

        ByteArrayOutputStream blob = x86Builder
                .interrupt(1)
                .mov(edx, 0)
                .mov(ecx, ebx)
                .dump();

        OutputStream os = new FileOutputStream("out/blob.bin");
        os.write(blob.toByteArray());
        os.close();

    }
}

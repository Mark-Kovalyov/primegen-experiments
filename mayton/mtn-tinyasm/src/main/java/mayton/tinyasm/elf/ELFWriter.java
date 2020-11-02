package mayton.tinyasm.elf;

import java.io.OutputStream;

public class ELFWriter implements AutoCloseable {

    private OutputStream outputStream;

    public ELFWriter(OutputStream outputStream) {
        this.outputStream = outputStream;
    }

    public void writeProgramHeaderTable(Object object) {

    }

    public void writeSectonHeaderTable(Object object) {

    }

    @Override
    public void close() throws Exception {
        outputStream.close();
    }
}

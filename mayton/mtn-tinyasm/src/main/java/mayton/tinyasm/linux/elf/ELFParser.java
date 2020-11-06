package mayton.tinyasm.linux.elf;

import mayton.tinyasm.linux.elf.document.ELFDocument;
import mayton.tinyasm.linux.elf.document.ELFHeader;
import org.apache.commons.io.input.SwappedDataInputStream;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;

public class ELFParser {

    private InputStream inputStream;

    public ELFParser(InputStream inputStream) {
        this.inputStream = inputStream;
    }

    public ELFDocument parse() throws IOException {
        ELFDocument elfDocument = new ELFDocument();
        ELFHeader elfHeader = new ELFHeader();
        //DataInputStream dataInputStream = new DataInputStream(inputStream);
        SwappedDataInputStream swappedDataInputStream = new SwappedDataInputStream(inputStream);
        elfHeader.magic = swappedDataInputStream.readInt();

        return elfDocument;
    }

}

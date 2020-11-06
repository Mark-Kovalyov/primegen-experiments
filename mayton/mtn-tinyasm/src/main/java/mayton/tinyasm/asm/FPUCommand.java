package mayton.tinyasm.asm;

import javax.annotation.concurrent.Immutable;
import java.util.Arrays;

@Immutable
public class FPUCommand {

    public final String mnemonic;
    public final String[] operands;

    public FPUCommand(String mnemonic, String... operands) {
        this.mnemonic = mnemonic;
        this.operands = operands;
    }

    @Override
    public String toString() {
        return String.format("%s %s", mnemonic, operands);
    }
}

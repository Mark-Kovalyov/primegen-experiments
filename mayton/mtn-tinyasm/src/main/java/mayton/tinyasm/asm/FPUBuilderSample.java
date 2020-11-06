package mayton.tinyasm.asm;

import java.util.ArrayList;
import java.util.List;

public class FPUBuilderSample {

    List<FPUCommand> fpuCommands;

    public class FPUBuilderSampleBuilder {

        public FPUBuilderSampleBuilder() {
            fpuCommands = new ArrayList<>();
        }

        public FPUBuilderSampleBuilder addGenericFpuCommand(FPUCommand fpuCommand) {
            fpuCommands.add(fpuCommand);
            return this;
        }

        public FPUBuilderSampleBuilder fld() {
            fpuCommands.add(new FPUCommand("fld", ""));
            return this;
        }

        FPUBuilderSample build() {
            return new FPUBuilderSample();
        }

    }


}

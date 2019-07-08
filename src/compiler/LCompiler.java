package compiler;

import intermediary.Program;
import intermediary.Variable;

public class LCompiler {
	private Registers registers = new Registers();

	public String Compile(Program p) {
		return String.join("\n", "",
				".data",
				"    .string \"hello, world!\"",
//			"section .bss",
				".text",
				"    .globl main",
				Assembly.function("main", String.join("\n", "",
						"        movq %rsp, %rbp",
						"        leaq .data(%rip), %rdi",
						"        call puts@PLT",
						Assembly.ret("$0")))
		);
	}

	private String getDataType(Variable variable) {
//		if (variable)
		return "";
	}
}

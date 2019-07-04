package compiler;

import intermediary.Program;
import intermediary.Variable;

public class LCompiler {
	private String[] registers = new String[]{};

	public String Compile(Program p) {
		return String.join("\n", "",
				".data",
				"    .string \"hello, world!\"",
//			"section .bss",
				".text",
				"    .globl main",
				"    main:",
				"		 pushq %rbp",
				"        movq %rsp, %rbp",
				"        leaq .data(%rip), %rdi",
				"        call puts@PLT",
				"        movq $0, %rax",
				"        popq %rbp",
				"        ret",
				"");
	}

	private String getDataType(Variable variable) {
//		if (variable)
		return "";
	}
}

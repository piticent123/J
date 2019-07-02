package compiler;

import intermediary.Program;
import intermediary.Variable;

public class LCompiler {
	public String Compile(Program p) {
		return String.join("\n", "",
			"global _start",
			"section .data",
			"    jv_hello_world: db \"hello, world!\", 0xA, 0x0",
			"    len: equ $ - jv_hello_world",
//			"section .bss",
			"section .text",
			"    _start:",
			"        mov eax, 4",
			"        mov ebx, 1",
			"        mov ecx, jv_hello_world",
			"        mov edx, len",
			"        int 0x80",
			"        mov eax, 1",
			"        int 0x80");
	}

	private String getDataType(Variable variable) {
//		if (variable)
		return "";
	}
}

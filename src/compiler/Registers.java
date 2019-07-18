package compiler;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

class Registers {
	private String[] variableRegisters = new String[]{"%rbx", "%rdi", "%rsi", "%rsp", "%r10", "%r11", "%r12", "%r13", "%r14", "%r15"};
	private int freeRegisters = 0;
	static String[] parameterRegisters = new String[]{"%rdi", "%rsi", "%rdx", "%rcx", "%r8", "%r9"};
	static String returnRegister = "%rax";

	private int nextFreeRegister() {
		for (int i = 0; i < variableRegisters.length; i++) {
			if ((freeRegisters & (1 << i)) == 1) return i;
		}

		return -1;
	}

	public String malloc(String val) throws Exception {
		int nextFreeRegister = nextFreeRegister();

		if (nextFreeRegister >= variableRegisters.length) {
			throw new Exception("Stack not implemented yet!");
		}

		freeRegisters += 1 << nextFreeRegister;
		return String.format("movq %s %s", val, variableRegisters[nextFreeRegister]);
	}

	public void free(String register) {
		int index = variableRegisters.length - 1;
		for (; index >= 0; index--) {
			if (variableRegisters[index].equals(register)) {
				freeRegisters -= 1 << index;
			}
		}
	}
}

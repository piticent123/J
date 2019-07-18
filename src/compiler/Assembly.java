package compiler;

import lombok.experimental.UtilityClass;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

@UtilityClass
public class Assembly {
	String ret(String val) {
		return String.join("\n", "",
				String.format("movq %s %s", val, Registers.returnRegister),
				"ret");
	}

	String function(String name, String body) {
		return String.join("\n", "",
				String.format("    %s:", name),
				"    pushq %rbp",
				body,
				"    popq %rbp");
	}

	public String call(String function, String... params) throws Exception {
		if (params.length >= Registers.parameterRegisters.length) {
			throw new Exception("Too many parameters!");
		}

		return IntStream.range(0, params.length)
				.mapToObj(i -> String.format("movq %s %s", params[i], Registers.parameterRegisters[i]))
				.collect(Collectors.joining("\n"));
	}
}

package cli;

import lombok.experimental.UtilityClass;

@UtilityClass
public class Flags {
	public final char INTERACTIVE = 'i';
	public final char COMPILE_TO_TOKENS = 't';
	public final char COMPILE_TO_INTERMEDIARY = 'p';
	public final char COMPILE_TO_ASSEMBLY = 'a';
	public final char EXECUTE = 'e';

	public FlagList parse(String[] args) {
		char lastStep = EXECUTE;
		boolean useFile = true;

		for (String arg : args) {
			switch (arg.charAt(1)) {
				case INTERACTIVE:
					useFile = false;
					break;
				case COMPILE_TO_TOKENS:
					lastStep = COMPILE_TO_TOKENS;
					break;
				case COMPILE_TO_INTERMEDIARY:
					lastStep = COMPILE_TO_INTERMEDIARY;
					break;
				case COMPILE_TO_ASSEMBLY:
					lastStep = COMPILE_TO_ASSEMBLY;
					break;
			}
		}

		return new FlagList(useFile, lastStep);
	}
}

package cli;

import lombok.experimental.UtilityClass;

@UtilityClass
public class Flags {
	private char USE_FILE = 'f';
	private char COMPILE_TO_TOKENS = 't';
	private char COMPILE_TO_INTERMEDIARY = 'i';
	private char COMPILE_TO_ASSEMBLY = 'a';
	private char EXECUTE = 'e';

	public FlagList parse(String[] args) {
		return new FlagList(false, "", EXECUTE);
	}
}

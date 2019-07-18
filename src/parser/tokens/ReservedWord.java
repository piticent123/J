package parser.tokens;

import lombok.Getter;
import parser.Token;

@Getter
public class ReservedWord extends Token<String> {
	public static final int VARIABLE_TYPE = 0;
	public static final int PACKAGE_TYPE = 1;
	public static final int NONE = 2;

	private ReservedWords word;

	public ReservedWord(String value) {
		super(value);
	}

	public enum ReservedWords {
		VAR, VAL, IMPORT, EXPORT
	}

	public int getType() {
		switch (word) {
			case VAL:
			case VAR:
				return VARIABLE_TYPE;
			case IMPORT:
			case EXPORT:
				return PACKAGE_TYPE;
			default:
				return NONE;
		}
	}
}

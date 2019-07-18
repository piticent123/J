package parser.tokens;

import lombok.Getter;
import parser.Token;

@Getter
public class PairedCharacter extends Token<Letters> {
	public static final int NONE = 0;
	public static final int LEFT = 1;
	public static final int RIGHT = 2;

	PairedCharacters enumValue;

	public PairedCharacter(Letters value) {
		super(value);
	}

	public enum PairedCharacters {
		LEFT_BRACE, RIGHT_BRACE, LEFT_PARENTHESIS, RIGHT_PARENTHESIS, LEFT_BRACKET, RIGHT_BRACKET, QUOTE
	}

	public int getDirection() {
		switch(enumValue) {
			case LEFT_BRACE:
			case LEFT_BRACKET:
			case LEFT_PARENTHESIS:
				return LEFT;
			case RIGHT_BRACE:
			case RIGHT_BRACKET:
			case RIGHT_PARENTHESIS:
				return RIGHT;
			case QUOTE:
			default:
				return NONE;
		}
	}
}

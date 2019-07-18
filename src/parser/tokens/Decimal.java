package parser.tokens;

import parser.Token;

public class Decimal extends Token<Long> {
	public Decimal(Long value) {
		super(value);
	}
}

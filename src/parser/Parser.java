package parser;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class Parser {
	public List<Token<?>> Parse(InputStream inputStream) {
		List<Token<?>> program = new ArrayList<>();
		Token<?> t;
		JParsingInputStream parsingStream = new JParsingInputStream(inputStream);

		while ((t = getNextToken(parsingStream)) != null) program.add(t);

		return program;
	}

	private Token<?> getNextToken(JParsingInputStream stream) {
		return null;
	}
}

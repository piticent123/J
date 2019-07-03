package parser;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class Parser {
	public List<Token> Parse(InputStream inputStream) {
		List<Token> program = new ArrayList<>();
		JParsingInputStream parsingStream = new JParsingInputStream(inputStream);

		try {
			String x = parsingStream.readLine();
			System.out.println(x);
		} catch (IOException e) {
			e.printStackTrace();
		}

		return program;
	}
}

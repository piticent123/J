package parser;

import lombok.AccessLevel;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.io.IOException;
import java.io.InputStream;

@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
class JParsingInputStream {
	@NonNull InputStream inputStream;
	int newLine = Character.codePointAt("\n", 0);

	int currentCharacter;
	int nextCharacter;

	/**
	 * Reads one line from the input stream. *Does* include the newline character
	 *
	 * @return One line from the input stream
	 * @throws IOException From inputStream.read()
	 */
	String readLine() throws IOException {
		StringBuilder builder = new StringBuilder();
		int character;

		while ((character = inputStream.read()) != -1) {
			builder.append(Character.toChars(character));
			if (character == newLine) break;
		}

		return builder.toString();
	}

	String peak() {
		return String.valueOf(nextCharacter);
	}
}

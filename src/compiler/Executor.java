package compiler;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;

import static java.nio.file.Files.*;

public class Executor {
	public void Execute(String assembly) {
		try {
			Path tmpDirectory = createTempDirectory("cc");
			String dir = tmpDirectory.toAbsolutePath().toString();

			Path tmpFile = createTempFile("code", "s");
			FileWriter writer = new FileWriter(tmpFile.toFile());
			writer.write(assembly);
			writer.close();

			Runtime.getRuntime().exec(new String[]{"gcc -o " + dir + "/j-binary " + dir + "/code.s", dir + "/j-binary"});
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

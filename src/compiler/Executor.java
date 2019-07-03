package compiler;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;

import static java.nio.file.Files.*;

public class Executor {
	private Path tmpDirectory = createTempDirectory("jcc-");

	public Executor() throws IOException {
	}

	private String getPath(String f) {
		return new File(tmpDirectory.toFile(), f).getAbsolutePath();
	}

	public void Execute(String assembly) {
		try {
			Path tmpFile = createTempFile(tmpDirectory.toAbsolutePath(), "j-code-", ".s");
			BufferedWriter writer = new BufferedWriter(new FileWriter(tmpFile.toFile()));
			writer.write(assembly);
			writer.close();

			Runtime.getRuntime().exec(new String[]{
				"gcc -o " + getPath("j-binary") + " " + tmpFile.toAbsolutePath().toString(),
				getPath("j-binary")
			});
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

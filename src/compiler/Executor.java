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
		return new File(tmpDirectory.toFile(), f).getAbsolutePath()
				.replace("C:\\", "/mnt/c/")
				.replace("\\", "/");
	}

	public void Execute(String assembly) throws InterruptedException {
		try {
			File tmpFile = File.createTempFile("j-code-", ".s", tmpDirectory.toFile());
//			tmpFile.deleteOnExit();
//			tmpDirectory.toFile().deleteOnExit();

			BufferedWriter writer = new BufferedWriter(new FileWriter(tmpFile));
			writer.write(assembly);
			writer.close();

			new ProcessBuilder().command("bash", "-c",
				"gcc -o " + getPath("j-binary") + " " + getPath(tmpFile.getName()) + " && " + getPath("j-binary"))
				.inheritIO().start().waitFor();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

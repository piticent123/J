package compiler;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.nio.file.Path;

import static java.nio.file.Files.*;

public class Executor {
	private String path(Path parent, String f) {
		return new File(parent.toFile(), f).getAbsolutePath()
				.replace("C:\\", "/mnt/c/")
				.replace("\\", "/");
	}

	private void cleanUp(Path tmpDir) {
		for (File file : tmpDir.toFile().listFiles()) file.delete();
		tmpDir.toFile().delete();
	}
	public void Execute(String assembly) {
		try {
			Path tmpDir = createTempDirectory("jcc-");
			File tmpFile = File.createTempFile("j-code-", ".s", tmpDir.toFile());
			BufferedWriter writer = new BufferedWriter(new FileWriter(tmpFile));
			writer.write(assembly);
			writer.close();

			new ProcessBuilder().command("bash", "-c",
				String.format("gcc -o %s %s && %s",
						path(tmpDir, "j-binary"), path(tmpDir, tmpFile.getName()), path(tmpDir, "j-binary")))
				.inheritIO().start().waitFor();

			cleanUp(tmpDir);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

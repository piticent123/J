import cli.FlagList;
import cli.Flags;
import cli.Pipeline;

import java.io.*;

public class J {
	public static void main(String[] args) {
		FlagList flags = Flags.parse(args);
		InputStream input = findInput(flags);

		new Pipeline(flags, input).fill();
	}

	private static InputStream findInput(FlagList flags) {
		try {
			return flags.isUseFile() ? new FileInputStream("index.j") : new BufferedInputStream(System.in);
		} catch (FileNotFoundException e) {
			System.out.println("File index.j does not exist. Using stdin instead");
			return new BufferedInputStream(System.in);
		}
	}
}

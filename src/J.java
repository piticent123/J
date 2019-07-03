import compiler.Executor;
import compiler.LCompiler;
import intermediary.HCompiler;
import intermediary.Program;
import parser.Parser;
import parser.Token;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class J {
	public static void main(String[] args) throws IOException {
		String flags = args.length > 0 ? args[0].toLowerCase() : "";

//		InputStream input;
//		try {
//			input = flags.contains(Flag.USE_FILE) ? new FileInputStream(args[0]) : new BufferedInputStream(System.in);
//		} catch (FileNotFoundException e) {
//			System.out.println("File " + args[0] + " does not exist.");
//			return;
//		} catch (IndexOutOfBoundsException e) {
//			System.out.println("The -f flag was passed, but no file was provided");
//			return;
//		}

		List<Token> p1 = new ArrayList<>();//new Parser().Parse(input);
		Program p2 = new HCompiler().Compile(p1);
		String asm = new LCompiler().Compile(p2);
		new Executor().Execute(asm);
	}
}

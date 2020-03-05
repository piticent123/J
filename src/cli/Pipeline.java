package cli;

import compiler.LCompiler;
import intermediary.HCompiler;
import intermediary.Program;
import parser.Parser;
import parser.Token;

import java.io.InputStream;
import java.util.List;

public class Pipeline {
	private InputStream inputStream;
	private FlagList flagList;

	public Pipeline(FlagList flags, InputStream inputStream) {
		this.inputStream = inputStream;
		flagList = flags;
	}

	public void fill() {
		List<Token<?>> parsedTree;
		Program hCompiledTree;
		String asm;

		switch (flagList.getCompileTo()) {
			case Flags.COMPILE_TO_TOKENS:
				parsedTree = new Parser().Parse(inputStream);
				System.out.println(parsedTree);
				break;
			case Flags.COMPILE_TO_INTERMEDIARY:
				parsedTree = new Parser().Parse(inputStream);
				hCompiledTree = new HCompiler().Compile(parsedTree);
				System.out.println(hCompiledTree);
				break;
			case Flags.COMPILE_TO_ASSEMBLY:
				parsedTree = new Parser().Parse(inputStream);
				hCompiledTree = new HCompiler().Compile(parsedTree);
				asm = new LCompiler().Compile(hCompiledTree);
				System.out.println(asm);
				break;
			case Flags.EXECUTE:
				parsedTree = new Parser().Parse(inputStream);
				hCompiledTree = new HCompiler().Compile(parsedTree);
				asm = new LCompiler().Compile(hCompiledTree);
				new Executor().Execute(asm);
				break;
			default:
				System.out.println("Invalid output");
		}
	}
}

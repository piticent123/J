package cli;

import compiler.LCompiler;

import java.io.InputStream;

public class Pipeline {
	private InputStream inputStream;
	private FlagList flagList;

	public Pipeline(String[] flags, InputStream inputStream) {
		this.inputStream = inputStream;
		flagList = Flags.parse(flags);
	}

	public void fill() {
		String asm = new LCompiler().Compile(null);
		new Executor().Execute(asm);
	}
}

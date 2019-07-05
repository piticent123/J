package cli;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class FlagList {
	private boolean useFile;
	private String file;
	private char compileTo;
}
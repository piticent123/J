package cli;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class FlagList {
	private boolean useFile;
	private char compileTo;
}
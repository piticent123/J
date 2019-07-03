package intermediary;

import lombok.Data;

@Data
public class Variable {
	String name;
	Command value;
	boolean constant;

	@Data
	public class Reference {
		String name;
	}
}

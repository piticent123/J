package intermediary;

import lombok.Data;

import java.util.List;

@Data
public class Function {
	List<Variable> parameters;
	List<Command> body;

	@Data
	public class Call {
		List<Variable> parameters;
	}
}

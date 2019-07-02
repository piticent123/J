package intermediary;

import lombok.Data;

import java.util.List;

@Data
public class Program {
	List<Program> classes;
	List<Function> functions;
	List<Variable> variables;
	List<Command> commands;
}

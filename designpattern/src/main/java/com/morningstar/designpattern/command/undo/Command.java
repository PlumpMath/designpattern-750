package  com.morningstar.designpattern.command.undo;

public interface Command {
	public void execute();
	public void undo();
}

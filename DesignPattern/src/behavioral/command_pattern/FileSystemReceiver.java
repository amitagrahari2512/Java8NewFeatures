package behavioral.command_pattern;

public interface FileSystemReceiver {

	void openFile();
	void writeFile();
	void closeFile();
}
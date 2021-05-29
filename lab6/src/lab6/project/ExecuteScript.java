package lab6.project;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class ExecuteScript {

	private int scriptLenhgt;
	private List<String> scriptElements = new ArrayList<String>();

	public int execute_script_lenght() {
		return scriptLenhgt;
	}

	public String execute_script(int i) {
		return (scriptElements.get(i));
	}

	public ExecuteScript() throws IOException {

		FileInputStream fstream_school = new FileInputStream("script.txt");
		// FileInputStream fstream_school = new
		// FileInputStream(System.getenv("GoToLab5ScriptFile"));
		DataInputStream data_input = new DataInputStream(fstream_school);
		BufferedReader buffer = new BufferedReader(new InputStreamReader(data_input));
		String str_line;

		while ((str_line = buffer.readLine()) != null) {
			str_line = str_line.trim();
			if ((str_line.length() != 0)) {
				scriptElements.add(str_line);
			}
		}

		scriptLenhgt = scriptElements.size();
	}

}

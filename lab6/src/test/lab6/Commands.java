package test.lab6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Commands {

	private String ob;
	private String ret;

	ArrayList<String> commands = new ArrayList<String>();

	public void add() {
		commands.add("help");
		commands.add("exit");
	}

	public String inputRead() throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String com = reader.readLine();
		com = check(com);

		return com;
	}

	public String check(String ob) {
		add();
		if (commands.contains(ob)) {
			this.ret = ob;
		} else {
			this.ret = null;
		}
		commands.clear();
		return ret;
	}

}

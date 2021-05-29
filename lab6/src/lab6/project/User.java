package lab6.project;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class User {

	private String ret, com;
	private ArrayList<String> commands = new ArrayList<String>();
	private String replaceID, replaceIDNew;
	private BufferedReader reader;
	private Long id = 0L;

	public void add() {
		commands.add("help");
		commands.add("show");
		commands.add("info");
		commands.add("exit");
		commands.add("insert");
		commands.add("update");
		commands.add("remove");
		commands.add("clear");
		commands.add("execut_script");
		commands.add("remove_greater");
		commands.add("history");
		commands.add("replace_if_greater");
		commands.add("remove_all_by_birthday");
		commands.add("print_ascending");
		commands.add("print");
		commands.add("printb");
		commands.add("print_field_descending_birthday");
	}

	public String inputRead() throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		com = reader.readLine();
		com = check(com);
		return com;
	}

	public String check(String ob) {
		add();
		if (commands.contains(ob)) {
			ret = ob;
		} else {
			ret = null;
		}
		return ret;
	}

	public String inputID(String remOption) throws IOException {
		reader = new BufferedReader(new InputStreamReader(System.in));
		do {
			System.out.println("Enter ID you wannt to " + remOption + "!");
			com = reader.readLine();
			if (com != null && !com.isEmpty()) {
				try {
					id = Long.parseLong(com);
				} catch (NumberFormatException nfe) {
					System.out.print("Value is NOT VALID - ");
				}
			}
		} while (id == 0);

		return String.valueOf(id);
	}

	public String inputKey() throws IOException {
		reader = new BufferedReader(new InputStreamReader(System.in));
		do {
			System.out.println("Enter key from which you want to remove!");
			com = reader.readLine();

			if (com != null && !com.isEmpty()) {
				try {
					id = Long.parseLong(com);
				} catch (NumberFormatException nfe) {
					System.out.print("Value is NOT VALID - ");
				}
			}
		} while (id == 0);

		return String.valueOf(id);
	}

	public void inputGreaterID() throws IOException {
		reader = new BufferedReader(new InputStreamReader(System.in));
		Long id = 0L;
		Long idNew = 0L;
		while (id >= idNew) {
			do {
				System.out.println("Enter ID to replace!");
				com = reader.readLine();

				if (com != null && !com.isEmpty()) {
					try {
						id = Long.parseLong(com);
					} catch (NumberFormatException nfe) {
						System.out.print("Value is NOT VALID - ");
					}
				}
			} while (id == 0);

			do {
				System.out.println("Enter NEW ID!");
				com = reader.readLine();

				if (com != null && !com.isEmpty()) {
					try {
						idNew = Long.parseLong(com);
					} catch (NumberFormatException nfe) {
						System.out.print("Value is NOT VALID - ");
					}
				}
				if (id >= idNew) {
					System.out.print("The New ID is not greater then the old one - ");
				}
			} while (idNew == 0);
		}

		replaceID = String.valueOf(id);
		replaceIDNew = String.valueOf(idNew);

	}

	public String getRepId() {
		return replaceID;
	}

	public String getNewId() {
		return replaceIDNew;
	}

}

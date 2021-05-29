package lab6.project;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import obj.Objects;
import obj.Person;
import obj.PrintOut;

public class ExecuteMethod {

	private Objects resMsg, msg;
	private PrintOut resMsgPO;
	private User com = new User();
	private ObjectOutputStream outStream;
	private ObjectInputStream inStream;
	private EnterNewPerson newPers;

	public ExecuteMethod(ObjectOutputStream outStream, ObjectInputStream inStream) throws Exception {
		this.outStream = outStream;
		this.inStream = inStream;
	}

	public void script() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException, Exception {
		ExecuteScript ex = new ExecuteScript();
		for (int i = 0; i < ex.execute_script_lenght(); i++) {
			System.out.println(ex.execute_script(i));
			Method m = ExecuteMethod.class.getDeclaredMethod(ex.execute_script(i));
			m.invoke(new ExecuteMethod(outStream, inStream));
		}
	}

	public void help() throws Exception {
		msg = new Objects("printOut");
		outStream.reset();
		outStream.writeObject(msg);
		resMsgPO = (PrintOut) inStream.readObject();
		resMsgPO.help();
	}

	public void show() throws Exception {
		msg = new Objects("printOut");
		outStream.reset();
		outStream.writeObject(msg);
		resMsgPO = (PrintOut) inStream.readObject();
		resMsgPO.show();
	}

	public void info() throws Exception {
		msg = new Objects("printOut");
		outStream.writeObject(msg);
		resMsgPO = (PrintOut) inStream.readObject();
		resMsgPO.info();
	}

	public void insert(Long id) throws Exception {
		msg = new Objects("insert");
		outStream.writeObject(msg);
		resMsg = (Objects) inStream.readObject();
		Long l = Long.valueOf(resMsg.message);
		if (id == null) {
			newPers = new EnterNewPerson(l);
		} else {
			newPers = new EnterNewPerson(id);
		}
		newPers.getPersonInfo();
		Person p = new Person(newPers.getID(), newPers.getName(), newPers.getCord(), newPers.getHeight(),
				newPers.getPassportID(), newPers.getEyeColor(), newPers.getLocation());
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
		p.FsetDateTimeBirthString(LocalDate.parse(newPers.getBirthsday(), formatter));
		outStream.writeObject(p);
		resMsg = (Objects) inStream.readObject();
		System.out.println(resMsg.message);
	}

	public void remove(String rem) throws Exception {
		msg = new Objects("remove");
		outStream.writeObject(msg);
		do {
			msg = new Objects(com.inputID(rem));
			outStream.writeObject(msg);
			resMsg = (Objects) inStream.readObject();
			if (resMsg.message.equals("1")) {
				System.out.print("Entered ID does not exist - ");
			}
		} while (resMsg.message.equals("1"));
		resMsg = (Objects) inStream.readObject();
		System.out.println(resMsg.message);
	}

	public void remove_greater() throws Exception {
		msg = new Objects("remove_greater");
		outStream.writeObject(msg);
		do {
			msg = new Objects(com.inputKey());
			outStream.writeObject(msg);
			resMsg = (Objects) inStream.readObject();
			if (resMsg.message.equals("1")) {
				System.out.print("Entered Key does not exist - ");
			}
		} while (resMsg.message.equals("1"));
		resMsg = (Objects) inStream.readObject();
		System.out.println(resMsg.message);
	}

	public void clear() throws Exception {
		msg = new Objects("clear");
		outStream.writeObject(msg);
		resMsg = (Objects) inStream.readObject();
		System.out.println(resMsg.message);
	}

	public void replace_if_greater() throws Exception {
		msg = new Objects("replace_if_greater");
		outStream.writeObject(msg);
		do {
			com.inputGreaterID();
			msg = new Objects(com.getRepId());
			outStream.writeObject(msg);
			msg = new Objects(com.getNewId());
			outStream.writeObject(msg);
			resMsg = (Objects) inStream.readObject();
			if (resMsg.message.equals("1")) {
				System.out.print("Entered ID does not exist - ");
			}
		} while (resMsg.message.equals("1"));
		resMsg = (Objects) inStream.readObject();
		System.out.println(resMsg.message);
		insert(Long.valueOf(com.getNewId()));
	}

	public void remove_all_by_birthday() throws Exception {
		msg = new Objects("remove_all_by_birthday");
		outStream.writeObject(msg);
		newPers = new EnterNewPerson(0L);
		newPers.enterNewBirthsday();
		msg = new Objects(newPers.getBirthsday2());
		outStream.writeObject(msg);
		resMsg = (Objects) inStream.readObject();
		System.out.println(resMsg.message);
	}

	public void print_ascending() throws Exception {
		msg = new Objects("printOut");
		outStream.reset();
		outStream.writeObject(msg);
		resMsgPO = (PrintOut) inStream.readObject();
		resMsgPO.print_ascending();
	}

	public void print_field_descending_birthday() throws Exception {
		msg = new Objects("printOut");
		outStream.reset();
		outStream.writeObject(msg);
		resMsgPO = (PrintOut) inStream.readObject();
		resMsgPO.print_field_descending_birthday();
	}

}

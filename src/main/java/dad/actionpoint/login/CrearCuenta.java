package dad.actionpoint.login;

import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Scanner;

public class CrearCuenta {

	Scanner sc;
	String filename = "BaseDeUsuarios.csv";

	public CrearCuenta() {
		try {
			Path path = Paths.get(filename.toString());
			OutputStream output = new BufferedOutputStream(Files.newOutputStream(path, StandardOpenOption.CREATE));
			BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(output));
			System.out.println("put a username");
			String username = sc.nextLine();
			System.out.println("enter a password");
			String pass = sc.nextLine();

			writer.write(username + "," + pass);
			writer.newLine();
			System.out.println("Account create");
			output.close();
			writer.close();

		} catch (Exception e) {
			// TODO: handle exception
		}

	}
}

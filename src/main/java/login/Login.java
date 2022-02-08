package login;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class Login {

	// File guardado=new File("Usuarios");

	Model modeloda;
	Scanner sc;
	String filename = "BaseDeUsuarios.txt";

	public void login() {

		try {
			Path path = Paths.get(filename.toString());
			InputStream input = Files.newInputStream(path);
			BufferedReader reader = new BufferedReader(new InputStreamReader(input));
			System.out.println("nombre de Usuario");
			String username = sc.nextLine();
			System.out.println("Contrasena:");
			String pasword = sc.nextLine();
			String temp = null;
			String user;
			String pass;
			String correo;
			boolean found = false;
			boolean userBoolean = false;
			boolean passBoolean = false;
			while ((temp = reader.readLine()) != null) {
				String[] account = temp.split(",");
				user = account[0];
				correo= account[1];
				pass = account[2];
				if (user.equals(username) || correo.equals(username)) {
					userBoolean = true;
					if (pass.equals(pasword)) {
						passBoolean = true;
						found = true;
					}
				}
				if (userBoolean == true) {
				} else {
					System.out.println("user or email wrong!");
				}
				if (passBoolean == true) {
				} else {
					System.out.println("password incorrect");
				}
				if (found == true) {
					System.out.println("granted access");
				} else {
					System.out.println("access denied");
				}
			}

		} catch (Exception e) {
			System.out.println("algo");
		}

	}

}

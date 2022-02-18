package dad.actionpoint.login;

import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class PrimeraVezLogin {

	Scanner sc;
	String filename= "BaseDeUsuarios.txt";
	
	public PrimeraVezLogin() {
	try {
		Path path=Paths.get(filename.toString());
		OutputStream output=new BufferedOutputStream(Files.newOutputStream(path /*APPEND*/));
		BufferedWriter writter=new BufferedWriter(new OutputStreamWriter(output));
		System.out.println("Intoduce tu Usuario");
		String username = sc.nextLine();
		System.out.println("Intoduce tu correo");
		String correo = sc.nextLine();
		while(!ValidarCorreo.validacion(correo)) {
			System.out.println("Intoduce tu correo");
			correo = sc.nextLine();
		}
		System.out.println("Intoduce tu contraseña");
		String pass = sc.nextLine();
		
		writter.write(username+","+correo+","+pass);
		writter.newLine();
		writter.close();
		output.close();
		
	}
	catch (Exception e){
		System.out.println("algo");
	}
	
	
	}
}

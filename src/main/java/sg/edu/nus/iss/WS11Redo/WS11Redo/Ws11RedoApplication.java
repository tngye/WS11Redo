package sg.edu.nus.iss.WS11Redo.WS11Redo;

import java.util.Collections;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.DefaultApplicationArguments;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Ws11RedoApplication {
	private static final String Default_Port_Number = "3000";
	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(Ws11RedoApplication.class);
		String portNumber = null;
		String port = null;

		ApplicationArguments cliOpts = new DefaultApplicationArguments(args);
		if (cliOpts.containsOption("port")){
			port = cliOpts.getOptionValues("port").get(0);
		}
		if (port == null){
			portNumber = System.getProperty("PORT", Default_Port_Number);
		}else {
			portNumber = (String)port;
		}

		if(portNumber != null){
			app.setDefaultProperties(Collections.singletonMap("server.port", portNumber));
		}
		
		app.run(args);	
	}

}

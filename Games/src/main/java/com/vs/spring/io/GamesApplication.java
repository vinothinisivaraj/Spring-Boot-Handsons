package com.vs.spring.io;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.vs.spring.io.enterprise.example.web.MyWebController;
import com.vs.spring.io.game.GameRunner;

@SpringBootApplication
//@ComponentScan("com.vs.spring.io ")
public class GamesApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(GamesApplication.class, args);
		// MarioGame game = new MarioGame();
		// SuperContraGame game = new SuperContraGame();
		// PacManGame game = new PacManGame();
		//GamingConsole game = new SuperContraGame(); /* implementation */
		//GameRunner runner = new GameRunner(game); /* passing over constructor */
		GameRunner runner = context.getBean(GameRunner.class);
		runner.run();
		MyWebController myWebController = context.getBean(MyWebController.class);
		System.out.println(myWebController.returnValueFromBusinessService());
	}

}

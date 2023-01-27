package com.vs.spring.io.game;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component /* instead of creating implementation and passing that object into constructor */
@Primary
public class SuperContraGame implements GamingConsole {
	public void up() {
		System.out.println("SuperContraGame Up");
	}

	public void down() {
		System.out.println("SuperContraGame Down");
	}

	public void left() {
		System.out.println("SuperContraGame Left");
	}

	public void right() {
		System.out.println("SuperContraGame right");
	}
}

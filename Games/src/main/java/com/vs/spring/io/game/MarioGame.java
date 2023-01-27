package com.vs.spring.io.game;

import org.springframework.stereotype.Component;

@Component
public class MarioGame implements GamingConsole{
	public void up() {
		System.out.println("Jump");
	}
	
	public void down() {
		System.out.println("Down into the hole");
	}
	
	public void left() {
		System.out.println("stop");
	}
	
	public void right() {
		System.out.println("Accelerate");
	}
	
}

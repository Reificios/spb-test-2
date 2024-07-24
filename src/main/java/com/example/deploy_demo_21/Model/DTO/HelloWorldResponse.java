package com.example.deploy_demo_21.Model.DTO;

public class HelloWorldResponse {
	
	String helloWorld;
	

	public HelloWorldResponse(String helloWorld) {
		super();
		this.helloWorld = helloWorld;
	}

	public String getHelloWorld() {
		return helloWorld;
	}

	public void setHelloWorld(String helloWorld) {
		this.helloWorld = helloWorld;
	}

	@Override
	public String toString() {
		return "HelloWorldResponse [helloWorld=" + helloWorld + "]";
	}
}

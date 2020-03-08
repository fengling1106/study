package com.ioc;

public class Chinaese implements Person {

	private Axe axe;
	
	public void setAxe(Axe axe)
	{
		this.axe = axe;
	}
	
	
	public void userAxe() {
		
		System.out.println(axe.chop());

	}

}

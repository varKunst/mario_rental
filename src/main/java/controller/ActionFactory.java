package controller;

import controller.action.*;

public class ActionFactory {
	
	private ActionFactory() {}
	private static ActionFactory instance = new ActionFactory();
	public static ActionFactory getInstance() {
		return instance;
	}
	
	public Action getAction(String command) {
		Action action = null;
		
		if(command.equals("join"))
			action = new JoinAction();
		else if(command.equals("logIn"))
			action = new LogInAction();
		else if(command.equals("logOut"))
			action = new LogOutAction();
		else if(command.equals("update"))
			action = new UpdateAction();
		else if(command.equals("write"))
			action = new WriteAction();
		else if(command.equals("modify"))
			action = new ModifyAction();
		else if(command.equals("rental"))
			action = new RentalAction();
			
		return action;
	}
}
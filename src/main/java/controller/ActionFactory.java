package controller;

import controller.action.Action;
import controller.action.JoinAction;
import controller.action.LogInAction;
import controller.action.LogOutAction;
import controller.action.UpdateAction;

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
			
		return action;
	}
}
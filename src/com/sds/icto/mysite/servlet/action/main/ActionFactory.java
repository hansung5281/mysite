package com.sds.icto.mysite.servlet.action.main;

import com.sds.icto.web.Action;

public class ActionFactory {
	private static ActionFactory instance;
	static {
		instance = new ActionFactory();
	}
	private ActionFactory(){
		
	}

	public static ActionFactory getInstance() {
//		if(instance == null){
//			instance = new ActionFactory();
//		}
		return instance;
	}
	
	public Action getAction(String a){
		Action action = null;
		if("form".equals(a)){
			//action = new FormAction();
		}else if("insert".equals(a)){
			//action = new InsertAction();
		}else{
			action = new IndexAction();
		}
		return action;
	}
}

package com.student.demo.bean;
import java.util.*;

public class State implements Comparator<State> {
	
	private String stateCode;
	private String stateName;
	
	public State(){
		
	}
	
	public State(String stateCode, String stateName){
		this.stateCode = stateCode;
		this.stateName = stateName;
		
	}

	public String getStateCode() {
		return stateCode;
	}

	public void setStateCode(String stateCode) {
		this.stateCode = stateCode;
	}

	public String getStateName() {
		return stateName;
	}

	public void setStateName(String stateName) {
		this.stateName = stateName;
	}

	@Override
	public int compare(State s1, State s2) {
		return s1.getStateCode().compareTo(s2.getStateCode());
	}

}

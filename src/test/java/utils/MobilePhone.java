package utils;

import java.io.Serializable;

import org.json.JSONObject;

public class MobilePhone implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	

	private String name;
	private JSONObject data;
	private int id;


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public JSONObject getData() {
		return data;
	}


	public void setData(JSONObject data) {
		this.data = data;
	}
	
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}

	public MobilePhone(String name, JSONObject json) {
		this.name = name;
		this.data = json;
	}
	
	public MobilePhone(int id, String name, JSONObject json) {
		this.id=id;
		this.name = name;
		this.data = json;
	}

}

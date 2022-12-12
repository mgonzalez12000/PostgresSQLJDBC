package model;

public class Instrument {
	
	private int inst_id;
	private String name;
	private String musical_key;
	
	public Instrument(int inst_id, String name, String musical_key) {
		this.inst_id = inst_id;
		this.name = name;
		this.musical_key = musical_key;
	}

	public int getInst_id() {
		return inst_id;
	}

	public void setInst_id(int inst_id) {
		this.inst_id = inst_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMusical_key() {
		return musical_key;
	}

	public void setMusical_key(String musical_key) {
		this.musical_key = musical_key;
	}	

}

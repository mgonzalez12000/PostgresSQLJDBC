package model;

public class Plays {
	private int musician_ssn;
	private int inst_id;
	
	public Plays(int musician_ssn, int inst_id) {
		this.musician_ssn = musician_ssn;
		this.inst_id = inst_id;
	}

	public int getMusician_ssn() {
		return musician_ssn;
	}

	public void setMusician_ssn(int musician_ssn) {
		this.musician_ssn = musician_ssn;
	}

	public int getInst_id() {
		return inst_id;
	}

	public void setInst_id(int inst_id) {
		this.inst_id = inst_id;
	}
}

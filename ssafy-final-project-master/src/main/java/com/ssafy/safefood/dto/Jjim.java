package com.ssafy.safefood.dto;

public class Jjim {
	private int idx;
	private String id;
	private int code;
	private int amount;
	private String foodname;
	private String check;
	private String allergy;

	public String getAllergy() {
		return allergy;
	}

	public void setAllergy(String allergy) {
		this.allergy = allergy;
	}

	public String getCheck() {
		return check;
	}

	public void setCheck(String check) {
		this.check = check;
	}

	public String getFoodname() {
		return foodname;
	}

	public void setFoodname(String foodname) {
		this.foodname = foodname;
	}

	public int getIdx() {
		return idx;
	}

	public void setIdx(int idx) {
		this.idx = idx;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	@Override
	public String toString() {
		return "Eat [idx=" + idx + ", id=" + id + ", code=" + code + ", amount=" + amount + ", foodname=" + foodname
				+ "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + amount;
		result = prime * result + code;
		result = prime * result + ((foodname == null) ? 0 : foodname.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + idx;
		return result;
	}

	public Jjim(int idx, String id, int code, int amount, String foodname, String check, String allergy) {
		super();
		this.idx = idx;
		this.id = id;
		this.code = code;
		this.amount = amount;
		this.foodname = foodname;
		this.check = check;
		this.allergy = allergy;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Jjim other = (Jjim) obj;
		if (amount != other.amount)
			return false;
		if (code != other.code)
			return false;
		if (foodname == null) {
			if (other.foodname != null)
				return false;
		} else if (!foodname.equals(other.foodname))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (idx != other.idx)
			return false;
		return true;
	}

	public Jjim() {

	}

}

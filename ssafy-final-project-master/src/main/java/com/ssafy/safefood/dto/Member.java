package com.ssafy.safefood.dto;

import java.util.List;

public class Member {
	private String id;
	private String pw;
	private String name;
	private String phone;
	private String email;
	private String allergy;
	private Integer auth;
	
	private List<Eat> eatlist;
	
	public List<Eat> getEatlist() {
		return eatlist;
	}

	public void setEatlist(List<Eat> eatlist) {
		this.eatlist = eatlist;
	}

	public Member() {
		
	}
	
	public Member(String id, String pw, String name, String phone, String email, String allergy) {
		super();
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.phone = phone;
		this.email = email;
		this.allergy = allergy;
	}

	

	public String getAllergy() {
		return allergy;
	}

	public void setAllergy(String allergy) {
		this.allergy = allergy;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Member [id=" + id + ", pw=" + pw + ", name=" + name + ", phone=" + phone + ", email=" + email
				+ ", allergy=" + allergy + ", eatlist=" + eatlist + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((allergy == null) ? 0 : allergy.hashCode());
		result = prime * result + ((eatlist == null) ? 0 : eatlist.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((phone == null) ? 0 : phone.hashCode());
		result = prime * result + ((pw == null) ? 0 : pw.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Member other = (Member) obj;
		if (allergy == null) {
			if (other.allergy != null)
				return false;
		} else if (!allergy.equals(other.allergy))
			return false;
		if (eatlist == null) {
			if (other.eatlist != null)
				return false;
		} else if (!eatlist.equals(other.eatlist))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (phone == null) {
			if (other.phone != null)
				return false;
		} else if (!phone.equals(other.phone))
			return false;
		if (pw == null) {
			if (other.pw != null)
				return false;
		} else if (!pw.equals(other.pw))
			return false;
		return true;
	}

	public Integer getAuth() {
		return auth;
	}

	public void setAuth(Integer auth) {
		this.auth = auth;
	}

	

}

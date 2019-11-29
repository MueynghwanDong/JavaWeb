package com.ssafy.jdbc.day3;

import java.sql.Date;

public class Country {
	private Integer countryId; // DB에서는 int형에도 null이 올 수 있기 때문에 int라고 쓰지 말고 Integer로 써야 알맞게 매핑될 수 있다.
	private String country;
	private Date last_update;

	public Country() {
	}

	public Country(Integer countryId, String country, Date last_update) {
		this.countryId = countryId;
		this.country = country;
		this.last_update = last_update;
	}

	public Integer getCountryId() {
		return countryId;
	}

	public void setCountryId(Integer countryId) {
		this.countryId = countryId;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public Date getLast_update() {
		return last_update;
	}

	public void setLast_update(Date last_update) {
		this.last_update = last_update;
	}

	@Override
	public String toString() {
		return "Country [countryId=" + countryId + ", country=" + country + ", last_update=" + last_update + "]";
	}

}

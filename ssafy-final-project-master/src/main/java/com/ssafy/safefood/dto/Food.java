package com.ssafy.safefood.dto;

/** 식품 정보 */
public class Food {
	/**식품을 구별하는 코드 */
	protected int code;
	/**식품 이름*/
	protected String name;
	/**일회 제공 량*/
	protected double supportpereat;
	/**일회 제공되는 칼로기*/
	protected double calory;
	/**일회 제공되는 탄수화물*/
	protected double carbo;
	/**일회 제공되는 단백질*/
	protected double protein;
	/**일회 제공되는 지방*/
	protected double fat;
	/**일회 제공되는 당류*/
	protected double sugar;
	/**일회 제공되는 나트륨*/
	protected double natrium;
	/**일회 제공되는 콜레스테롤*/
	protected double chole;
	/**일회 제공되는 포화지방산*/
	protected double fattyacid;
	/**일회 제공되는 트렌스지방*/
	protected double transfat;
	/**제조사*/
	protected String maker;
	/**원료*/
	protected String material;
	/**이미지 경로*/
	protected String img;
	protected String allergy;
	/**클릭 빈도*/
	protected int frequency;
	protected int sfreq;
	



	public Food(int code, String name, double supportpereat, double calory, double carbo, double protein, double fat,
			double sugar, double natrium, double chole, double fattyacid, double transfat, String maker,
			String material, String img, String allergy, int frequency, int sfreq) {
		super();
		this.code = code;
		this.name = name;
		this.supportpereat = supportpereat;
		this.calory = calory;
		this.carbo = carbo;
		this.protein = protein;
		this.fat = fat;
		this.sugar = sugar;
		this.natrium = natrium;
		this.chole = chole;
		this.fattyacid = fattyacid;
		this.transfat = transfat;
		this.maker = maker;
		this.material = material;
		this.img = img;
		this.allergy = allergy;
		this.frequency = frequency;
		this.sfreq = sfreq;
	}

	public Food() {
	}
	
	public Food(int code) {
		super();
		this.code = code;
	}
	
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getSupportpereat() {
		return supportpereat;
	}
	public void setSupportpereat(double supportpereat) {
		this.supportpereat = supportpereat;
	}
	public double getCalory() {
		return calory;
	}
	public void setCalory(double calory) {
		this.calory = calory;
	}
	public double getCarbo() {
		return carbo;
	}
	public void setCarbo(double carbo) {
		this.carbo = carbo;
	}
	public double getProtein() {
		return protein;
	}
	public void setProtein(double protein) {
		this.protein = protein;
	}
	public double getFat() {
		return fat;
	}
	public void setFat(double fat) {
		this.fat = fat;
	}
	public double getSugar() {
		return sugar;
	}
	public void setSugar(double sugar) {
		this.sugar = sugar;
	}
	public double getNatrium() {
		return natrium;
	}
	public void setNatrium(double natrium) {
		this.natrium = natrium;
	}
	public double getChole() {
		return chole;
	}
	public void setChole(double chole) {
		this.chole = chole;
	}
	public double getFattyacid() {
		return fattyacid;
	}
	public void setFattyacid(double fattyacid) {
		this.fattyacid = fattyacid;
	}
	public double getTransfat() {
		return transfat;
	}
	public void setTransfat(double transfat) {
		this.transfat = transfat;
	}
	public String getMaker() {
		return maker;
	}
	public void setMaker(String maker) {
		this.maker = maker;
	}
	public String getMaterial() {
		return material;
	}
	public void setMaterial(String material) {
		this.material = material;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	
	public String getAllergy() {
		return allergy;
	}
	public void setAllergy(String allergy) {
		this.allergy = allergy;
	}
	
	//추가
	public int getFrequency() {
		return frequency;
	}
	public void setFrequency(int frequency) {
		this.frequency = frequency;
	}
	
	public int getSfreq() {
		return sfreq;
	}
	public void setSfreq(int sfreq) {
		this.sfreq = sfreq;
	}




	@Override
	public String toString() {
		return "Food [code=" + code + ", name=" + name + ", supportpereat=" + supportpereat + ", calory=" + calory
				+ ", carbo=" + carbo + ", protein=" + protein + ", fat=" + fat + ", sugar=" + sugar + ", natrium="
				+ natrium + ", chole=" + chole + ", fattyacid=" + fattyacid + ", transfat=" + transfat + ", maker="
				+ maker + ", material=" + material + ", img=" + img + ", allergy=" + allergy + ", frequency="
				+ frequency + ", sfreq=" + sfreq + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((allergy == null) ? 0 : allergy.hashCode());
		long temp;
		temp = Double.doubleToLongBits(calory);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(carbo);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(chole);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + code;
		temp = Double.doubleToLongBits(fat);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(fattyacid);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + frequency;
		result = prime * result + ((img == null) ? 0 : img.hashCode());
		result = prime * result + ((maker == null) ? 0 : maker.hashCode());
		result = prime * result + ((material == null) ? 0 : material.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		temp = Double.doubleToLongBits(natrium);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(protein);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + sfreq;
		temp = Double.doubleToLongBits(sugar);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(supportpereat);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(transfat);
		result = prime * result + (int) (temp ^ (temp >>> 32));
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
		Food other = (Food) obj;
		if (allergy == null) {
			if (other.allergy != null)
				return false;
		} else if (!allergy.equals(other.allergy))
			return false;
		if (Double.doubleToLongBits(calory) != Double.doubleToLongBits(other.calory))
			return false;
		if (Double.doubleToLongBits(carbo) != Double.doubleToLongBits(other.carbo))
			return false;
		if (Double.doubleToLongBits(chole) != Double.doubleToLongBits(other.chole))
			return false;
		if (code != other.code)
			return false;
		if (Double.doubleToLongBits(fat) != Double.doubleToLongBits(other.fat))
			return false;
		if (Double.doubleToLongBits(fattyacid) != Double.doubleToLongBits(other.fattyacid))
			return false;
		if (frequency != other.frequency)
			return false;
		if (img == null) {
			if (other.img != null)
				return false;
		} else if (!img.equals(other.img))
			return false;
		if (maker == null) {
			if (other.maker != null)
				return false;
		} else if (!maker.equals(other.maker))
			return false;
		if (material == null) {
			if (other.material != null)
				return false;
		} else if (!material.equals(other.material))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (Double.doubleToLongBits(natrium) != Double.doubleToLongBits(other.natrium))
			return false;
		if (Double.doubleToLongBits(protein) != Double.doubleToLongBits(other.protein))
			return false;
		if (sfreq != other.sfreq)
			return false;
		if (Double.doubleToLongBits(sugar) != Double.doubleToLongBits(other.sugar))
			return false;
		if (Double.doubleToLongBits(supportpereat) != Double.doubleToLongBits(other.supportpereat))
			return false;
		if (Double.doubleToLongBits(transfat) != Double.doubleToLongBits(other.transfat))
			return false;
		return true;
	}
	
	
}

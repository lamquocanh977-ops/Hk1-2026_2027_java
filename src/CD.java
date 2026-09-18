package tuan5.TH;

public class CD {
	private int maCD;
	private String tuaCD;
	private int soBaiHat;
	private double giaThanh;
	// Hang so mac dinh 
	public static final int MA_CD_MAC_DINH = 999999;
	public static final String TUA_CD_MAC_DINH = "Chua xac dinh";
	

	
	
	public CD() {
		this.maCD = MA_CD_MAC_DINH;
		this.tuaCD = TUA_CD_MAC_DINH;
		this.soBaiHat = 1;
		this.giaThanh = 1.0;
	}
	public CD(int maCD, String tuaCD, int soBaiHat, double giaThanh) {
		setMaCD(maCD);
		setTuaCD(tuaCD);
		setSoBaiHat(soBaiHat);
		setGiaThanh(giaThanh);
		
	}
	



	public int getMaCD() {
		return maCD;
	}
	public void setMaCD(int maCD) {
		if(maCD <= 0)
			throw new IllegalArgumentException("Loi: Ma CD phai >0!");
		this.maCD = maCD;
	}
	public String getTuaCD() {
		return tuaCD;
	}
	public void setTuaCD(String tuaCD) {
		if(tuaCD == null || tuaCD.trim().isEmpty())
			throw new IllegalArgumentException("Loi: Ma CD phai >0!");
		this.tuaCD = tuaCD;
	}
	public int getSoBaiHat() {
		return soBaiHat;
	}
	public void setSoBaiHat(int soBaiHat) {
		if(soBaiHat <= 0) 
			throw new IllegalArgumentException("Loi: Ma CD phai >0!");
		this.soBaiHat = soBaiHat;
		
	}
	public double getGiaThanh() {
		return giaThanh;
	}
	public void setGiaThanh(double giaThanh) {
		if(giaThanh<= 0)
			throw new IllegalArgumentException("Loi: Ma CD phai >0!");
		this.giaThanh = giaThanh;
	}
	public static int getMaCdMacDinh() {
		return MA_CD_MAC_DINH;
	}
	public static String getTuaCdMacDinh() {
		return TUA_CD_MAC_DINH;
	}
	@Override
	public String toString(){
		return String.format(
				"| %-10d | %-25s | %-12d | %-15.2f |", 
				maCD, tuaCD, soBaiHat, giaThanh);
	}

}


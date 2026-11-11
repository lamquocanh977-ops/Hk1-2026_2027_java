/**
 * 
 */
package Vehicle;

/**
 * 
 */
public class Vehicle {

	/**
	 * @param args
	 */
	private String chuXe;
	private String loaiXe;
	private int dungTich;
	private double triGia;
	
	
	/**
	 * @return the chuXe
	 */
	public Vehicle() {
	    this.chuXe = "";
	    this.loaiXe = "";
	    this.dungTich = 0;
	    this.triGia = 0.0;
	}

	public Vehicle(String chuXe, String loaiXe, int dungTich, double triGia) {
		super();
		this.chuXe = chuXe;
		this.loaiXe = loaiXe;
		this.dungTich = dungTich;
		this.triGia = triGia;
	}

	public String getChuXe() {
		return chuXe;
	}



	/**
	 * @param chuXe
	 * @param loaiXe
	 * @param dungTich
	 * @param triGia
	 */

	/**
	 * @param chuXe the chuXe to set
	 */
	public void setChuXe(String chuXe) {
		this.chuXe = chuXe;
	}


	/**
	 * @return the loaiXe
	 */
	public String getLoaiXe() {
		return loaiXe;
	}


	/**
	 * @param loaiXe the loaiXe to set
	 */
	public void setLoaiXe(String loaiXe) {
		this.loaiXe = loaiXe;
	}


	/**
	 * @return the dungTich
	 */
	public int getDungTich() {
		return dungTich;
	}


	/**
	 * @param dungTich the dungTich to set
	 */
	public void setDungTich(int dungTich) {
		this.dungTich = dungTich;
	}


	/**
	 * @return the triGia
	 */
	public double getTriGia() {
		return triGia;
	}


	/**
	 * @param triGia the triGia to set
	 */
	public void setTriGia(double triGia) {
		this.triGia = triGia;
	}
	public double tinhThue() {
		if(dungTich < 100) {
			return triGia *0.01;
		} else if( dungTich <= 200) {
			return triGia * 0.03;
		} else {
			return triGia * 0.05;
		}
	}
	


	@Override
	public String toString() {
		return "Vehicle [chuXe=" + chuXe + ", loaiXe=" + loaiXe + ", dungTich=" + dungTich + ", triGia=" + triGia + ", thue= "+ tinhThue() +"]";
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Vehicle xe1 = new Vehicle("Nguyen Thu Loan","Future Neo", 100, 35000000);
	    Vehicle xe2 = new Vehicle("Le Minh Tinh", "Ford Ran", 3000, 250000000);
	    Vehicle xe3 = new Vehicle("Nguyen Minh Triet", "Landscape", 1500, 100000000);
	    System.out.println(xe1);
	    System.out.println(xe2);
	    System.out.println(xe3);

	}

}

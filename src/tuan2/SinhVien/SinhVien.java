/**
 * 
 */
package tuan2.SinhVien;

/**
 * 
 */
import java.util.Scanner;
public class SinhVien {
	private int MaSV;
	private String HoTen;
	private float diemLT;
	private float diemTH;
	
/**
	 * @return the maSV
	 */
public SinhVien() {
	this.MaSV = 1;
	this.HoTen = "Chua cap nhat";
	this.diemLT = 0.0f;
	this.diemTH = 0.0f;
}
	public int getMaSV() {
		return MaSV;
	}

	/**
	 * @param maSV the maSV to set
	 */
	public void setMaSV(int maSV) {
		if(maSV > 0) {
		this.MaSV = maSV;
	} else {
		this.MaSV = 1;
	}
	}

	/**
	 * @return the hoTen
	 */
	public String getHoTen() {
		return HoTen;
	}

	/**
	 * @param hoTen the hoTen to set
	 */
	public void setHoTen(String hoTen) {
		if(hoTen != null && !hoTen.trim().isEmpty()) {
		this.HoTen = hoTen;
	} else {
		this.HoTen = "Chua cap nhat";
	}
	}
	/**
	 * @return the diemLT
	 */
	public double getDiemLT() {
		return diemLT;
	}

	/**
	 * @param diemLT the diemLT to set
	 */
	public void setDiemLT(float diemLT) {
		if(diemLT >= 0.0f && diemLT <= 10.0f) {
		this.diemLT = diemLT;
	} else {
		this.diemLT = 0.0f;
	}
	}
	/**
	 * @return the diemTH
	 */
	public double getDiemTH() {
		return diemTH;
	}

	/**
	 * @param diemTH the diemTH to set
	 */
	public void setDiemTH(float diemTH) {
		if(diemTH >= 0 && diemTH <= 10) {
			this.diemTH =diemTH;
		} else {
			this.diemTH = 0.0f;
		}
	}


	/**
 * @param maSV
 * @param hoTen
 * @param diemLT
 * @param diemTH
 */
	public float tinhdiemTB() {
		return (diemLT + diemTH) /2;
	}
public SinhVien(int maSV, String hoTen, float diemLT, float diemTH) {
	setMaSV(maSV);
	setHoTen(hoTen);
	setDiemLT(diemLT);
	setDiemTH(diemTH);
}


	
@Override 
public String toString() {
	return String.format("%-10d %-25s %-10.2f %-10.2f %-10.2f", MaSV, HoTen, diemLT, diemTH, tinhdiemTB());
	
}
public static void main(String[] args) {
	// TODO Auto-generated method stub
	System.out.println("Nhap thong tin:");


}


public static final void nhapXuat()
{
	System.out.println("Nhap thong tin sinh vien:");
	Scanner sc = new Scanner(System.in);
	System.out.println("Nhap ma sinh vien:");
	int MaSV = sc.nextInt();
	sc.nextLine();
	System.out.print("Nhap Ho Ten:");
	String hoTen =sc.nextLine();
	System.out.print("Nhap diemly thuyet(0-10):");
	float diemLT = sc.nextFloat();
	System.out.println("Nhap diem thuc hanh(0-10):");
	float diemTH =sc.nextFloat();
	SinhVien sv= new SinhVien(MaSV, hoTen, diemLT, diemTH);
	System.out.println(sv.toString());
	
}
}


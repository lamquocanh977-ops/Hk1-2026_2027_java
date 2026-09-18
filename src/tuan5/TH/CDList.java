package tuan5.TH;

public class CDList {
	private CD[] danhSachCD;
	private int soLuong;
	private int khaNang;
	private static final int KICH_THUOC_BAN_DAU = 5;
	

	public CDList() {
		// TODO Auto-generated constructor stub
		khaNang = KICH_THUOC_BAN_DAU;
		danhSachCD = new CD[khaNang];
		soLuong = 0;
	}
	int laySoluong() {
		return soLuong;
	}
	public CD lyCDTaiViTRi(int i) {
		return danhSachCD[i];
		
	}
	public void moRongMang() {
		int kichThuocMoi = khaNang * 2;
		CD[] mangMoi = new CD[kichThuocMoi];
		for(int i = 0; i < soLuong; i++)
			mangMoi[i] = danhSachCD[i];
		danhSachCD = mangMoi;
		System.out.println("Da ma rong mang len" + khaNang + "phan tu.");
		
	}
	public int timViTriTheoMa(int maCD)
	{
		for(int i = 0; i< soLuong; i++)
			if(danhSachCD[i].getMaCD() == maCD)
				return i;
		return -1;
		
	}
	public boolean themCD(CD cd) {
		if(timViTriTheoMa(cd.getMaCD()) != -1) {
			System.out.println("Loi : Ma CD" + cd.getMaCD() + "Da ton tai!");
		return false;
		}
		if (soLuong == khaNang) moRongMang();
		danhSachCD[soLuong] =cd;
		soLuong++;
		return true;
		
	}
	
public boolean xoaCD (int maCD){
		int viTri = timViTriTheoMa(maCD);
		if(viTri== -1) {
			System.out.println("Khong tim thay CD ma" + maCD);
			return false;
		}
		for(int i =viTri; i< soLuong - 1; i++)
			danhSachCD[i] = danhSachCD[i+1];
		danhSachCD[soLuong -1] = null;
	    soLuong--;
		return true;
	}
public boolean capNhatCD(int maCD, String tuaMoi,int soBaiHat, double giaMoi) {
	int viTri = timViTriTheoMa(maCD);
	if(viTri == -1) {
		System.out.println("Khong tim thay ma CD" + maCD);
		return false;
	}
	CD cd = danhSachCD[viTri];
	cd.setTuaCD(tuaMoi);
	cd.setSoBaiHat(soBaiHat);
	cd.setGiaThanh(viTri);
	return true;
}
public CD timTheomA(int maCD) {
	int viTri = timViTriTheoMa(maCD);
	return(viTri == -1) ? null : danhSachCD[viTri];
	
}
public CDList timTheoTienTo(String tuKhoa) {
	CDList ketQua = new CDList();
	String tk = tuKhoa.toLowerCase();
	for(int i=0; i < soLuong; i++) {
		if(danhSachCD[i].getTuaCD().toLowerCase().startsWith(tk)) {
			ketQua.themCD(danhSachCD[i]);
		}
	}
	return ketQua;
}
public CDList timTheoHauTo(String tuKhoa) {
	CDList ketQua = new CDList();
	String tk = tuKhoa.toLowerCase();
	for(int i = 0; i< soLuong; i++) {
		if(danhSachCD[i].getTuaCD().toLowerCase().endsWith(tk)) {
			ketQua.themCD(danhSachCD[i]);
			
		}
	}
	return ketQua;
}
public CDList timGanGiong(String tuKhoa) {
	CDList ketQua = new CDList();
	String tk = tuKhoa.toLowerCase();
	for(int i = 0; i < soLuong; i++) {
		if(danhSachCD[i].getTuaCD().toLowerCase().contains(tk)) {
			ketQua.themCD(danhSachCD[i]);
		}
	}
	return ketQua;
}
public int tinhSoLuong() {
	return soLuong;
}
public double tinhTongGiaThanh() {
	double tong = 0;
	for(int i = 0; i < soLuong; i++)
		tong+= danhSachCD[i].getGiaThanh();
	return tong;
	}
public double tinhGiaTrungBinh() {
	return (soLuong == 0) ? 0 : tinhTongGiaThanh() / soLuong;
	
}
public CD timCDDatNhat() {
	if(soLuong ==0) return null;
	CD max = danhSachCD[0];
	for(int i = 1; i < soLuong; i++) 
		if (danhSachCD[i].getGiaThanh() > max.getGiaThanh())
			max = danhSachCD[i];
	return max;
}
public CD timCDReNhat() {
	if(soLuong == 0) return null;
	CD min = danhSachCD[0];
	for(int i =1; i < soLuong; i++) 
		if(danhSachCD[i].getGiaThanh() < min.getGiaThanh())
			min = danhSachCD[i];
	return min;
}
public void hienThiDanhSach() {
	if(soLuong == 0) {
		System.out.println("Danh sach CD trong !");
		return;
	}
	System.out.println("\n+------------+-----------------------------------+-------------------+-------------+-----------+");
	System.out.println("|   Ma CD   |            Tua CD              | So Bai Hat   |   Gia Thanh |");
	System.out.println("\n+------------+-----------------------------------+-------------------+-------------+-----------+");
	
}
public void sapXepGiamDanTheoGia() {
	for(int i = 0; i < soLuong - 1; i++) 
		for(int j = i + 1; j <soLuong; j++)
			if(danhSachCD[i].getGiaThanh() < danhSachCD[i].getGiaThanh()) {
				CD temp = danhSachCD[i];
				danhSachCD[i] = danhSachCD[j];
				danhSachCD[j]= temp;
			}
	System.out.println("Da sap xep giam dan theo gia thanh.");
}
public void sapXepTangDanTheoTua() {
	for(int i = 0; i <soLuong - 1; i++)
		for(int j = i + 1; j < soLuong; j++)
			if(danhSachCD[i].getTuaCD().compareToIgnoreCase(danhSachCD[i].getTuaCD()) >0 ) {
				CD temp = danhSachCD[i];
				danhSachCD[i] = danhSachCD[j];
				danhSachCD[j] = temp;
			}
}
}

	


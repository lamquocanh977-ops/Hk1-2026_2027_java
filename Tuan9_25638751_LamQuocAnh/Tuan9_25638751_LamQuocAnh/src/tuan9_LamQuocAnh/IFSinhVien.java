package tuan9_LamQuocAnh;

import java.util.List;

public interface IFSinhVien {
	
	// them sua xoa tra ve boolean
	boolean them(SinhVien sv);
	boolean sua(String maSV, SinhVien svMoi);
	boolean xoa(String maSV);
	boolean xoaTatCa();
	
	//===========Tim kiem ==========
	List<SinhVien> layTatCa();
	SinhVien timTheoMa(String maSV);
	List<SinhVien> timTheoTen(String tuKhoa);
	List<SinhVien> timTheoLop(String lop);
	List<SinhVien> timTheoLoai(String loai);
	List<SinhVien> timTheoMon(MonHoc monHoc);
	
	//========Thong ke==========
	int tongSoLuong();
	double tongThanhTien();
	
	//===========Sap xep ==========
	List<SinhVien> sapXepTheoTen();
	List<SinhVien> sapXepTheoThanhTienGiamDan();
	

}

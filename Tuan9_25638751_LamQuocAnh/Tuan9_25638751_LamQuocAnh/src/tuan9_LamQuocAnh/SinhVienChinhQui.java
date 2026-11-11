package tuan9_LamQuocAnh;

import java.time.LocalDate;

public class SinhVienChinhQui extends SinhVien {
	private String hocTrucTiep;

	public SinhVienChinhQui(String maSV, String hoTen, LocalDate ngaySinh, String lop, int soTinChi, MonHoc monHoc,
			String hocTrucTiep) {
		super(maSV, hoTen, ngaySinh, lop, soTinChi, monHoc);
		this.hocTrucTiep = hocTrucTiep;
	}

	public String getHocTrucTiep() {
		return hocTrucTiep;
	}

	public void setHocTrucTiep(String hocTrucTiep) {
		this.hocTrucTiep = hocTrucTiep;
	}

	@Override
	public String getLoai() {
		// TODO Auto-generated method stub
		return "Chinh Qui";
	}

	@Override
	public String getThongTinRieng() {
		// TODO Auto-generated method stub
		return "Hoc truc tiep tai: " + hocTrucTiep;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString() + " | Truong Hoc " + getThongTinRieng();
	}
	

}

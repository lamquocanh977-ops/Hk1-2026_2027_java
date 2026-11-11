package m36.LamQuocAnh;

import java.time.LocalDate;

public class GiaoDichDat extends GiaoDich {
	private String loaiDat;

	public GiaoDichDat(String maGiaoDich, LocalDate ngayGiaoDich, double donGia, double dienTich, String loaiDat) {
		super(maGiaoDich, ngayGiaoDich, donGia, dienTich);
		this.loaiDat = loaiDat;
	}

	@Override
	public double thanhTien() {
		// TODO Auto-generated method stub
		if(loaiDat.equalsIgnoreCase("A")) {
			return dienTich * donGia * 1.5;
		}
		return dienTich * donGia;
	
	}

	@Override
	public String toString() {
		return "[Dat]" + super.toString() + " | Loai: "+ loaiDat;
		
	}
	
	

}

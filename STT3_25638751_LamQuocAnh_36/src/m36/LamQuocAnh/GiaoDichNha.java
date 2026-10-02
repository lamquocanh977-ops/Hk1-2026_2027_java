package m36.LamQuocAnh;

import java.time.LocalDate;

public class GiaoDichNha extends GiaoDich{
	private String loaiNha;
	private String diaChi;
	

	public GiaoDichNha(String maGiaoDich, LocalDate ngayGiaoDich, double donGia, double dienTich, String loaiNha,
			String diaChi) {
		super(maGiaoDich, ngayGiaoDich, donGia, dienTich);
		this.loaiNha = loaiNha;
		this.diaChi = diaChi;
	}


	public double thanhTien() {
		if (loaiNha.equalsIgnoreCase("Cao Cap")) {
			return dienTich * donGia;
		}
		return dienTich * donGia;
	}


	@Override
	public String toString() {
		return "[Nha:]" + super.toString() + "| Loai nha: " + loaiNha + "DC: " + diaChi;
				
	}
	

}

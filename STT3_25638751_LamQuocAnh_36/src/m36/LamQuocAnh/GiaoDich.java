package m36.LamQuocAnh;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public abstract class GiaoDich {
	protected String maGiaoDich;
	protected LocalDate ngayGiaoDich;
	protected double donGia;
	protected double dienTich;
	
	
	
	public GiaoDich(String maGiaoDich, LocalDate ngayGiaoDich, double donGia, double dienTich) {
		this.maGiaoDich = maGiaoDich;
		this.ngayGiaoDich = ngayGiaoDich;
		this.donGia = donGia;
		this.dienTich = dienTich;
	}
	public abstract double thanhTien();
	public String getMaGiaoDich() {
		return maGiaoDich;
	}
	public void setMaGiaoDich(String maGiaoDich) {
		this.maGiaoDich = maGiaoDich;
	}
	public LocalDate getNgayGiaoDich() {
		return ngayGiaoDich;
	}
	public void setNgayGiaoDich(LocalDate ngayGiaoDich) {
		this.ngayGiaoDich = ngayGiaoDich;
	}
	public double getDonGia() {
		return donGia;
	}
	public void setDonGia(double donGia) {
		this.donGia = donGia;
	}
	public double getDienTich() {
		return dienTich;
	}
	public void setDienTich(double dienTich) {
		this.dienTich = dienTich;
	}
	@Override
	public String toString() {
		return String.format("Mã: %-6s| Ngày: %s | Đơn Gía: %.0f | DT: %.1f | Thành Tiền: %.2f", maGiaoDich, ngayGiaoDich.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")),
				donGia, dienTich, thanhTien());
	}
	
	
	

}

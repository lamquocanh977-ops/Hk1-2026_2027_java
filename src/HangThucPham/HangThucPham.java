package HangThucPham;

public class HangThucPham {
	private String maHang;
	private String tenHang;
	private double donGia;
	private String ngaySX;
	/**
	 * @param maHang
	 * @param tenHang
	 * @param donGia
	 * @param ngaySX
	 */
	public HangThucPham(String maHang, String tenHang, double donGia, String ngaySX) {
		super();
		this.maHang = maHang;
		this.tenHang = tenHang;
		this.donGia = donGia;
		this.ngaySX = ngaySX;
	}
	/**
	 * @return the maHang
	 */
	public String getMaHang() {
		return maHang;
	}
	/**
	 * @param maHang the maHang to set
	 */
	public void setMaHang(String maHang) {
		this.maHang = maHang;
	}
	/**
	 * @return the tenHang
	 */
	public String getTenHang() {
		return tenHang;
	}
	/**
	 * @param tenHang the tenHang to set
	 */
	public void setTenHang(String tenHang) {
		this.tenHang = tenHang;
	}
	/**
	 * @return the donGia
	 */
	public double getDonGia() {
		return donGia;
	}
	/**
	 * @param donGia the donGia to set
	 */
	public void setDonGia(double donGia) {
		this.donGia = donGia;
	}
	/**
	 * @return the ngaySX
	 */
	public String getNgaySX() {
		return ngaySX;
	}
	/**
	 * @param ngaySX the ngaySX to set
	 */
	public void setNgaySX(String ngaySX) {
		this.ngaySX = ngaySX;
	}
	

}

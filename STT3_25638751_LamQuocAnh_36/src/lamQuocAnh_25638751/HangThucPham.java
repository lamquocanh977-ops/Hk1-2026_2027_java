package lamQuocAnh_25638751;
import java.time.LocalDate;

public class HangThucPham implements Comparable<HangThucPham> {
	private int id;
	private final String maHang;
	private String tenHang;
	private LocalDate ngaySX;
	private LocalDate ngayHH;
	private float gia;
	private static int demSoLuong=0;
	
    //constructor mac dinh
	
	public int getId() {
		return id;
	}
	public HangThucPham() {
		this.id = ++demSoLuong;
		this.maHang = "MAC_DINH";
		this.tenHang = "Hang mac dinh";
		this.ngaySX = LocalDate.now();
		this.ngayHH = LocalDate.now().plusDays(7);
		this.gia = 1.0f;
	}
	
	public HangThucPham(String maHang, String tenHang, LocalDate ngaySX, LocalDate ngayHH,float gia) {
		this.id = ++demSoLuong;
		if(maHang == null || maHang.trim().isEmpty())
			throw new IllegalArgumentException("Ma hangkhong duoc de trong!");
		if(tenHang ==null || tenHang.trim().isEmpty())
			throw new IllegalArgumentException("Ten hang khong duoc de trong!");
		if(gia <= 0)
			throw new IllegalArgumentException("Gia phai lon hon 0 !");
		if(!kiemTrangaySX(ngaySX))
			throw new IllegalArgumentException("Ngay sx khong duoc la tuonglai!");
		if(!kiemTrangayHH(ngayHH, ngayHH))
			throw new IllegalArgumentException("Ngay het han phai sau ngay sx!");
		
		this.maHang = maHang;
		this.tenHang = tenHang;
		this.ngaySX = ngaySX;
		this.ngayHH = ngayHH;
		this.gia = gia;
	}
	
	
	private boolean kiemTrangayHH(LocalDate ngayHH2, LocalDate ngayHH3) {
		// TODO Auto-generated method stub
		return ngaySX != null && !ngaySX.isAfter(LocalDate.now());
	
	}
	private boolean kiemTrangaySX(LocalDate ngaySX2) {
		// TODO Auto-generated method stub
		
		return ngayHH != null && ngayHH != null && !ngayHH.isAfter(ngaySX);
	}
	public String getTenHang() {
		if(maHang == null || maHang.trim().isEmpty())
			throw new IllegalArgumentException("Ma hangkhong duoc de trong!");
		return tenHang;
	}
	public void setTenHang(String tenHang) {
		if(tenHang ==null || tenHang.trim().isEmpty())
			throw new IllegalArgumentException("Ten hang khong duoc de trong!");
		this.tenHang = tenHang;
	}
	public LocalDate getNgaySX() {
		return ngaySX;
	}
	public void setNgaySX(LocalDate ngaySX) {
		if(!kiemTrangaySX(ngaySX))
			throw new IllegalArgumentException("Ngay sx khong duoc la tuonglai!");
		if(this.ngayHH != null && !kiemTrangayHH(ngaySX, this.ngayHH))
			throw new IllegalArgumentException("Ngay SX pha truoc ngay HH");
		
		this.ngaySX = ngaySX;
	}
	public LocalDate getNgayHH() {
		return ngayHH;
	}
	public void setNgayHH(LocalDate ngayHH) {
		if(this.ngaySX == null) 
			throw new IllegalArgumentException("Chua co ngay SX!");
		if(!kiemTrangayHH(ngayHH, ngayHH))
			throw new IllegalArgumentException("Ngay het han phai sau ngay sx!");
		this.ngayHH = ngayHH;
	}
	public float getGia() {
		return gia;
	}
	public void setGia(float gia) {
		if(gia <= 0)
			throw new IllegalArgumentException("Gia phai lon hon 0 !");
		this.gia = gia;
	}
	public static int getDemSoLuong() {
		return demSoLuong;
	}
	public static void setDemSoLuong(int demSoLuong) {
		HangThucPham.demSoLuong = demSoLuong;
	}
	public String getMaHang() {
		return maHang;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public boolean kiemTrangayHH() {
		return LocalDate.now().isAfter(this.ngayHH);
	}
	
	public String trangThaiChiTiet() {
		LocalDate homNay = LocalDate.now();
		if(homNay.isBefore(ngaySX))
			return "Chua san xuat";
		if(homNay.isAfter(ngayHH)) 
			return "Het han";
		if(homNay.isEqual(ngayHH))
			return "Het han hom nay";
		long con = ngayHH.toEpochDay() - homNay.toEpochDay();
		return "Con" + con +  "Ngay";
		
	}
	protected Object clone() throws CloneNotSupportedException {
		throw new CloneNotSupportedException("Khong the sao chep HangThucPham!");
		
		
	}
	public int compareTo(HangThucPham o) {
		return Integer.compare(this.id, o.id);
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return String.format(
				"| %-4d | %-10s | %-18s| %-12s | %-12s | %-10.0f |",
				id, maHang, tenHang, ngaySX, ngayHH, gia);
	}
	
}


package tuan9_LamQuocAnh;

import java.time.LocalDate;

public class SinhVien {

    protected String maSV;
    protected String hoTen;
    protected LocalDate ngaySinh;
    protected String lop;
    protected int soTinChi;
    protected MonHoc monHoc;

    public SinhVien(String maSV, String hoTen, LocalDate ngaySinh,
                    String lop, int soTinChi, MonHoc monHoc) {

        super();

        this.maSV = maSV;
        this.hoTen = hoTen;
        this.ngaySinh = ngaySinh;
        this.lop = lop;
        this.soTinChi = soTinChi;
        this.monHoc = monHoc;
    }

    public double thanhTien() {

        if (monHoc == null)
            return 0;

        return soTinChi * monHoc.getDonGia();
    }

    public String getLoai() {
        return "Sinh vien";
    }

    public String getThongTinRieng() {
        return "";
    }

    public String getMaSV() {
        return maSV;
    }

    public void setMaSV(String maSV) {
        this.maSV = maSV;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public LocalDate getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(LocalDate ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public String getLop() {
        return lop;
    }

    public void setLop(String lop) {
        this.lop = lop;
    }

    public int getSoTinChi() {
        return soTinChi;
    }

    public void setSoTinChi(int soTinChi) {
        this.soTinChi = soTinChi;
    }

    public MonHoc getMonHoc() {
        return monHoc;
    }

    public void setMonHoc(MonHoc monHoc) {
        this.monHoc = monHoc;
    }

    @Override
    public String toString() {

        return String.format(
            "[%s] %s | Lop: %s | NS: %s | Mon: %s (%d tin * %,.0f VND) | Thanh tien: %,.0f VND",
            maSV,
            hoTen,
            lop,
            ngaySinh,
            monHoc != null ? monHoc.getTenMon() : "Chua co mon hoc",
            soTinChi,
            monHoc != null ? monHoc.getDonGia() : 0,
            thanhTien()
        );
    }
}
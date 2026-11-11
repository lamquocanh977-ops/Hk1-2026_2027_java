
package lamQuocAnh_25638751;

import java.time.LocalDate;

public abstract class KhachHang {

    protected String maKh;
    protected String hoTen;
    protected LocalDate ngayLapHD;
    protected double soKW;
    protected double donGia;

    public KhachHang(String maKh, String hoTen,
            LocalDate ngayLapHD, double soKW, double donGia) {

        setMaKh(maKh);
        setHoTen(hoTen);
        setNgayLapHD(ngayLapHD);
        setSoKW(soKW);
        setDonGia(donGia);
    }

    public abstract double thanhTien();

    public String getMaKh() {
        return maKh;
    }

    public void setMaKh(String maKh) {
        if (maKh == null || maKh.trim().isEmpty()) {
            throw new IllegalArgumentException("Ma khong duoc rong!");
        }
        this.maKh = maKh.trim();
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        if (hoTen == null || hoTen.trim().isEmpty()) {
            throw new IllegalArgumentException("Ho ten khong duoc rong!");
        }
        this.hoTen = hoTen.trim();
    }

    public LocalDate getNgayLapHD() {
        return ngayLapHD;
    }

    public void setNgayLapHD(LocalDate ngayLapHD) {
        if (ngayLapHD == null) {
            throw new IllegalArgumentException("Ngay lap HD khong hop le!");
        }
        this.ngayLapHD = ngayLapHD;
    }

    public double getSoKW() {
        return soKW;
    }

    public void setSoKW(double soKW) {
        if (!Double.isFinite(soKW) || soKW < 0) {
            throw new IllegalArgumentException("So KW khong hop le!");
        }
        this.soKW = soKW;
    }

    public double getDonGia() {
        return donGia;
    }

    public void setDonGia(double donGia) {
        if (!Double.isFinite(donGia) || donGia <= 0) {
            throw new IllegalArgumentException("Don gia phai lon hon 0!");
        }
        this.donGia = donGia;
    }

    @Override
    public String toString() {
        return String.format(
            "%s | %s | Ngay: %s | So KW: %.1f | Don gia: %,.0f | Thanh tien: %,.0f",
            maKh, hoTen, ngayLapHD, soKW, donGia, thanhTien()
        );
    }
}

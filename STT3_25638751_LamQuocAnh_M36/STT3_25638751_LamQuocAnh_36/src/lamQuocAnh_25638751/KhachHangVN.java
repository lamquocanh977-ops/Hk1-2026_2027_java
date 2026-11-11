
package lamQuocAnh_25638751;

import java.time.LocalDate;

public class KhachHangVN extends KhachHang {

    private String doiTuong;
    private double dinhMuc;

    public KhachHangVN(String maKh, String hoTen,
            LocalDate ngayLapHD, double soKW,
            double donGia, String doiTuong, double dinhMuc) {

        super(maKh, hoTen, ngayLapHD, soKW, donGia);

        setDoiTuong(doiTuong);
        setDinhMuc(dinhMuc);
    }

    public String getDoiTuong() {
        return doiTuong;
    }

    public void setDoiTuong(String doiTuong) {
        if (doiTuong == null || doiTuong.trim().isEmpty()) {
            throw new IllegalArgumentException("Doi tuong khong duoc rong!");
        }
        this.doiTuong = doiTuong.trim();
    }

    public double getDinhMuc() {
        return dinhMuc;
    }

    public void setDinhMuc(double dinhMuc) {
        if (!Double.isFinite(dinhMuc) || dinhMuc < 0) {
            throw new IllegalArgumentException("Dinh muc khong hop le!");
        }
        this.dinhMuc = dinhMuc;
    }

    @Override
    public double thanhTien() {

        if (soKW <= dinhMuc) {
            return soKW * donGia;
        }

        return dinhMuc * donGia
                + (soKW - dinhMuc) * donGia * 2.5;
    }

    @Override
    public String toString() {
        return super.toString()
                + " | Doi tuong: " + doiTuong
                + " | Dinh muc: " + dinhMuc;
    }
}


package lamQuocAnh_25638751;

import java.time.LocalDate;

public class KhachHangNN extends KhachHang {

    private String quocTich;

    public KhachHangNN(String maKh, String hoTen,
            LocalDate ngayLapHD, double soKW,
            double donGia, String quocTich) {

        super(maKh, hoTen, ngayLapHD, soKW, donGia);
        setQuocTich(quocTich);
    }

    public String getQuocTich() {
        return quocTich;
    }

    public void setQuocTich(String quocTich) {
        if (quocTich == null || quocTich.trim().isEmpty()) {
            throw new IllegalArgumentException("Quoc tich khong duoc rong!");
        }
        this.quocTich = quocTich.trim();
    }

    @Override
    public double thanhTien() {
        return getSoKW() * getDonGia();
    }

    @Override
    public String toString() {
        return super.toString()
                + " | Quoc tich: " + quocTich;
    }
}


package lamQuocAnh_25638751;

import java.util.ArrayList;
import java.util.List;

public class QuanLyKhachHang implements IQuanLy<KhachHang> {

    private List<KhachHang> danhSach = new ArrayList<>();

    // Ham phu tim khach hang theo ma
    private KhachHang timTheoMa(String ma) {

        if (ma == null || ma.trim().isEmpty()) {
            return null;
        }

        return danhSach.stream()
                .filter(kh -> kh.getMaKh().equalsIgnoreCase(ma.trim()))
                .findFirst()
                .orElse(null);
    }

    // Them khach hang
    @Override
    public void them(KhachHang t) {

        if (t == null) {
            throw new IllegalArgumentException("Khach hang khong duoc null!");
        }

        if (timTheoMa(t.getMaKh()) != null) {
            System.out.println("Ma khach hang da ton tai!");
            return;
        }

        danhSach.add(t);
        System.out.println("Them thanh cong!");
    }

    // Xoa khach hang
    @Override
    public boolean xoa(String ma) {

        KhachHang kh = timTheoMa(ma);

        if (kh == null) {
            return false;
        }

        danhSach.remove(kh);
        return true;
    }

    // Sua khach hang
    @Override
    public boolean sua(String ma, KhachHang tMoi) {

        if (tMoi == null) {
            return false;
        }

        for (int i = 0; i < danhSach.size(); i++) {

            if (danhSach.get(i).getMaKh().equalsIgnoreCase(ma)) {

                // Khong cho sua thanh ma khac
                if (!tMoi.getMaKh().equalsIgnoreCase(ma)) {
                    return false;
                }

                danhSach.set(i, tMoi);
                return true;
            }
        }

        return false;
    }

    // Tim kiem theo ma chinh xac
    @Override
    public KhachHang timKiemTheoMa(String ma) {
        return timTheoMa(ma);
    }

    // Tim kiem theo ten
    @Override
    public List<KhachHang> timKiemTheoTen(String ten) {

        if (ten == null || ten.trim().isEmpty()) {
            return new ArrayList<>();
        }

        return danhSach.stream()
                .filter(kh -> kh.getHoTen()
                        .toLowerCase()
                        .contains(ten.trim().toLowerCase()))
                .toList();
    }

    // Tim kiem theo ma bat dau bang prefix
    @Override
    public List<KhachHang> timKiemTheoMaPrefix(String prefix) {

        if (prefix == null || prefix.trim().isEmpty()) {
            return new ArrayList<>();
        }

        return danhSach.stream()
                .filter(kh -> kh.getMaKh()
                        .toLowerCase()
                        .startsWith(prefix.trim().toLowerCase()))
                .toList();
    }

    // Lay danh sach khach hang
    @Override
    public List<KhachHang> getDanhSach() {
        return new ArrayList<>(danhSach);
    }
}

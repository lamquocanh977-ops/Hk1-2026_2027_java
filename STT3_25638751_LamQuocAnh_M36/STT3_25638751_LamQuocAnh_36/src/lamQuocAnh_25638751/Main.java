
package lamQuocAnh_25638751;

import java.time.LocalDate;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        QuanLyKhachHang ql = new QuanLyKhachHang();

        // 1. Them khach hang
        ql.them(new KhachHangVN(
                "VN01", "Nguyen Van A",
                LocalDate.of(2018, 9, 5),
                100, 2000, "Sinh hoat", 50));

        ql.them(new KhachHangVN(
                "VN02", "Tran Van B",
                LocalDate.of(2018, 8, 15),
                80, 2500, "Kinh doanh", 100));

        ql.them(new KhachHangVN(
                "VN03", "Le Van C",
                LocalDate.of(2018, 9, 20),
                150, 3000, "San xuat", 100));

        ql.them(new KhachHangNN(
                "NN01", "John",
                LocalDate.of(2018, 9, 10),
                120, 3000, "My"));

        ql.them(new KhachHangNN(
                "NN02", "David",
                LocalDate.of(2018, 7, 12),
                200, 3500, "Han Quoc"));

        ql.them(new KhachHangNN(
                "NN03", "Anna",
                LocalDate.of(2018, 9, 25),
                90, 4000, "Anh"));

        // 2. Xuat danh sach
        System.out.println("\n===== DANH SACH HOA DON =====");

        for (KhachHang kh : ql.getDanhSach()) {
            System.out.println(kh);
        }

        // 3. Dem so luong khach hang
        int demVN = 0;
        int demNN = 0;

        for (KhachHang kh : ql.getDanhSach()) {

            if (kh instanceof KhachHangVN) {
                demVN++;
            } else if (kh instanceof KhachHangNN) {
                demNN++;
            }
        }

        System.out.println("\n===== SO LUONG KHACH HANG =====");
        System.out.println("Khach hang Viet Nam: " + demVN);
        System.out.println("Khach hang nuoc ngoai: " + demNN);

        // 4. Tinh trung binh thanh tien khach hang nuoc ngoai
        double tongTienNN = 0;

        for (KhachHang kh : ql.getDanhSach()) {

            if (kh instanceof KhachHangNN) {
                tongTienNN += kh.thanhTien();
            }
        }

        System.out.println("\n===== TRUNG BINH THANH TIEN =====");

        if (demNN > 0) {
            System.out.printf(
                    "Trung binh khach hang nuoc ngoai: %,.0f%n",
                    tongTienNN / demNN);
        } else {
            System.out.println("Khong co khach hang nuoc ngoai!");
        }

        // 5. Hoa don thang 09/2018
        System.out.println("\n===== HOA DON THANG 09/2018 =====");

        for (KhachHang kh : ql.getDanhSach()) {

            if (kh.getNgayLapHD().getMonthValue() == 9
                    && kh.getNgayLapHD().getYear() == 2018) {

                System.out.println(kh);
            }
        }

        // 6. Tim kiem theo ma
        System.out.println("\n===== TIM KIEM THEO MA =====");

        KhachHang tim = ql.timKiemTheoMa("VN01");

        if (tim != null) {
            System.out.println(tim);
        } else {
            System.out.println("Khong tim thay!");
        }

        // 7. Tim kiem theo ten
        System.out.println("\n===== TIM KIEM THEO TEN =====");

        List<KhachHang> dsTen = ql.timKiemTheoTen("an");

        for (KhachHang kh : dsTen) {
            System.out.println(kh);
        }

        // 8. Tim kiem theo prefix
        System.out.println("\n===== TIM KIEM THEO PREFIX =====");

        List<KhachHang> dsPrefix = ql.timKiemTheoMaPrefix("VN");

        for (KhachHang kh : dsPrefix) {
            System.out.println(kh);
        }

        // 9. Xoa khach hang
        System.out.println("\n===== XOA KHACH HANG =====");

        if (ql.xoa("NN03")) {
            System.out.println("Xoa thanh cong!");
        } else {
            System.out.println("Khong tim thay ma!");
        }

        // 10. Kiem tra danh sach sau khi xoa
        System.out.println("\n===== DANH SACH SAU KHI XOA =====");

        for (KhachHang kh : ql.getDanhSach()) {
            System.out.println(kh);
        }
    }
}

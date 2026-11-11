package tuan9_LamQuocAnh;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main {

    static Scanner sc = new Scanner(System.in);
    static ListSinhVien ds = new ListSinhVien();

    // ================= TAO DU LIEU MAU =================
    public static void taoDuLieuMau() {

        ds.them(new SinhVienChinhQui(
            "SV01", "Nguyen Van An",
            LocalDate.of(2005, 1, 10),
            "KTPM21A", 20,
            MonHoc.LAP_TRINH_JAVA, "Co so 1"
        ));

        ds.them(new SinhVienTuXa(
            "SV02", "Tran Thi Binh",
            LocalDate.of(2005, 5, 15),
            "KTPM21A", 18,
            MonHoc.CO_SO_DU_LIEU, "Google Meet"
        ));

        ds.them(new SinhVienChinhQui(
            "SV03", "Le Van Cuong",
            LocalDate.of(2004, 8, 20),
            "KHMT21A", 22,
            MonHoc.MANG_MAY_TINH, "Co so 3"
        ));

        ds.them(new SinhVienTuXa(
            "SV04", "Pham Thi Dung",
            LocalDate.of(2005, 3, 12),
            "KHMT21A", 15,
            MonHoc.LAP_TRINH_WEB, "Microsoft Teams"
        ));

        ds.them(new SinhVienChinhQui(
            "SV05", "Hoang Van Em",
            LocalDate.of(2004, 12, 5),
            "KTPM21A", 21,
            MonHoc.TRI_TUE_NHAN_TAO, "Co so 2"
        ));

        System.out.println("Da tao du lieu mau!");
    }

    // ================= NHAP SINH VIEN =================
    public static SinhVien nhapSinhVien() {

        System.out.print("Nhap ma sinh vien: ");
        String ma = sc.nextLine();

        System.out.print("Nhap ho ten: ");
        String ten = sc.nextLine();

        System.out.print("Nhap ngay sinh (yyyy-MM-dd): ");
        LocalDate ns = LocalDate.parse(sc.nextLine());

        System.out.print("Nhap lop: ");
        String lop = sc.nextLine();

        System.out.print("Nhap so tin chi: ");
        int tinChi = Integer.parseInt(sc.nextLine());

        System.out.println("Danh sach mon hoc:");

        MonHoc[] dsMon = MonHoc.values();

        for (int i = 0; i < dsMon.length; i++) {
            System.out.println((i + 1) + ". " + dsMon[i]);
        }

        System.out.print("Chon mon hoc: ");
        int chonMon = Integer.parseInt(sc.nextLine());

        if (chonMon < 1 || chonMon > dsMon.length)
            return null;

        MonHoc mh = dsMon[chonMon - 1];

        System.out.println("1. Sinh vien chinh quy");
        System.out.println("2. Sinh vien tu xa");

        System.out.print("Chon loai sinh vien: ");
        int loai = Integer.parseInt(sc.nextLine());

        if (loai == 1) {

            System.out.print("Nhap noi hoc truc tiep: ");
            String noiHoc = sc.nextLine();

            return new SinhVienChinhQui(
                ma, ten, ns, lop, tinChi, mh, noiHoc
            );

        } else if (loai == 2) {

            System.out.print("Nhap nen tang hoc online: ");
            String nenTang = sc.nextLine();

            return new SinhVienTuXa(
                ma, ten, ns, lop, tinChi, mh, nenTang
            );
        }

        return null;
    }

    // ================= XUAT DANH SACH =================
    public static void xuatDanhSach(List<SinhVien> ds) {

        if (ds.isEmpty()) {
            System.out.println("Danh sach rong!");
            return;
        }

        for (SinhVien sv : ds) {
            System.out.println(sv);
        }
    }

    // ================= MENU =================
    public static void menu() {

        int chon;

        do {

            System.out.println("\n========== QUAN LY SINH VIEN ==========");
            System.out.println("1. Them sinh vien");
            System.out.println("2. Sua sinh vien");
            System.out.println("3. Xoa sinh vien");
            System.out.println("4. Xoa tat ca sinh vien");
            System.out.println("5. Xuat danh sach");
            System.out.println("6. Tim sinh vien theo ma");
            System.out.println("7. Tim sinh vien theo ten");
            System.out.println("8. Tim sinh vien theo lop");
            System.out.println("9. Tim sinh vien theo loai");
            System.out.println("10. Tim sinh vien theo mon hoc");
            System.out.println("11. Thong ke so luong va thanh tien");
            System.out.println("12. Sap xep theo ten");
            System.out.println("13. Sap xep theo thanh tien giam dan");
            System.out.println("14. Tao Map sinh vien");
            System.out.println("15. Group By lop");
            System.out.println("16. Having so luong sinh vien");
            System.out.println("17. Having tong thanh tien");
            System.out.println("0. Thoat");
            System.out.println("=======================================");

            System.out.print("Nhap lua chon: ");
            chon = Integer.parseInt(sc.nextLine());

            switch (chon) {

                case 1: {
                    SinhVien sv = nhapSinhVien();

                    if (sv != null && ds.them(sv))
                        System.out.println("Them thanh cong!");
                    else
                        System.out.println("Them that bai!");

                    break;
                }

                case 2: {
                    System.out.print("Nhap ma sinh vien can sua: ");
                    String ma = sc.nextLine();

                    System.out.println("Nhap thong tin moi:");
                    SinhVien svMoi = nhapSinhVien();

                    if (svMoi != null && ds.sua(ma, svMoi))
                        System.out.println("Sua thanh cong!");
                    else
                        System.out.println("Sua that bai!");

                    break;
                }

                case 3: {
                    System.out.print("Nhap ma sinh vien can xoa: ");
                    String ma = sc.nextLine();

                    if (ds.xoa(ma))
                        System.out.println("Xoa thanh cong!");
                    else
                        System.out.println("Khong tim thay sinh vien!");

                    break;
                }

                case 4: {

                    if (ds.xoaTatCa())
                        System.out.println("Da xoa tat ca!");
                    else
                        System.out.println("Danh sach dang rong!");

                    break;
                }

                case 5: {
                    xuatDanhSach(ds.layTatCa());
                    break;
                }

                case 6: {
                    System.out.print("Nhap ma sinh vien: ");
                    String ma = sc.nextLine();

                    SinhVien sv = ds.timTheoMa(ma);

                    if (sv != null)
                        System.out.println(sv);
                    else
                        System.out.println("Khong tim thay!");

                    break;
                }

                case 7: {
                    System.out.print("Nhap tu khoa ten: ");
                    String ten = sc.nextLine();

                    xuatDanhSach(ds.timTheoTen(ten));

                    break;
                }

                case 8: {
                    System.out.print("Nhap lop: ");
                    String lop = sc.nextLine();

                    xuatDanhSach(ds.timTheoLop(lop));

                    break;
                }

                case 9: {
                    System.out.print("Nhap loai (Chinh Qui / Tu Xa / Sinh vien): ");
                    String loai = sc.nextLine();

                    xuatDanhSach(ds.timTheoLoai(loai));

                    break;
                }

                case 10: {
                    MonHoc[] dsMon = MonHoc.values();

                    for (int i = 0; i < dsMon.length; i++) {
                        System.out.println((i + 1) + ". " + dsMon[i]);
                    }

                    System.out.print("Chon mon hoc: ");
                    int n = Integer.parseInt(sc.nextLine());

                    if (n >= 1 && n <= dsMon.length)
                        xuatDanhSach(ds.timTheoMon(dsMon[n - 1]));
                    else
                        System.out.println("Lua chon khong hop le!");

                    break;
                }

                case 11: {
                    System.out.println("Tong so sinh vien: " + ds.tongSoLuong());

                    System.out.printf(
                        "Tong thanh tien: %,.0f VND%n",
                        ds.tongThanhTien()
                    );

                    break;
                }

                case 12: {
                    System.out.println("Danh sach sau khi sap xep theo ten:");
                    xuatDanhSach(ds.sapXepTheoTen());

                    break;
                }

                case 13: {
                    System.out.println("Danh sach thanh tien giam dan:");
                    xuatDanhSach(ds.sapXepTheoThanhTienGiamDan());

                    break;
                }

                case 14: {
                    Map<String, SinhVien> map = ds.taoMapSinhVien();

                    for (Map.Entry<String, SinhVien> entry : map.entrySet()) {
                        System.out.println(
                            "Key: " + entry.getKey() +
                            " | Value: " + entry.getValue()
                        );
                    }

                    break;
                }

                case 15: {
                    Map<String, List<SinhVien>> map = ds.groupByLop();

                    for (Map.Entry<String, List<SinhVien>> entry : map.entrySet()) {

                        System.out.println("\nLop: " + entry.getKey());

                        xuatDanhSach(entry.getValue());
                    }

                    break;
                }

                case 16: {
                    System.out.print("Nhap so luong sinh vien toi thieu: ");
                    int soLuong = Integer.parseInt(sc.nextLine());

                    Map<String, List<SinhVien>> map =
                        ds.havingSoLuongSinhVien(soLuong);

                    for (Map.Entry<String, List<SinhVien>> entry : map.entrySet()) {

                        System.out.println("\nLop: " + entry.getKey());

                        xuatDanhSach(entry.getValue());
                    }

                    break;
                }

                case 17: {
                    System.out.print("Nhap muc tien: ");
                    double mucTien = Double.parseDouble(sc.nextLine());

                    Map<String, Double> map =
                        ds.havingTongThanhTien(mucTien);

                    for (Map.Entry<String, Double> entry : map.entrySet()) {

                        System.out.printf(
                            "Lop: %s | Tong thanh tien: %,.0f VND%n",
                            entry.getKey(),
                            entry.getValue()
                        );
                    }

                    break;
                }

                case 0:
                    System.out.println("Ket thuc chuong trinh!");
                    break;

                default:
                    System.out.println("Lua chon khong hop le!");
            }

        } while (chon != 0);
    }

    // ================= MAIN =================
    public static void main(String[] args) {

        taoDuLieuMau();

        menu();

        sc.close();
    }
}
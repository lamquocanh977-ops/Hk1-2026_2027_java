package lamQuocAnh_25638751;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;


public class Main {
	static Scanner sc = new Scanner(System.in);
	static QuanLyThucPham ql = new QuanLyThucPham();
	static DateTimeFormatter df = DateTimeFormatter.ofPattern("dd//MM//yyyy");
	public static void main(String[] args) {
		duLieuMau();
		int chon =-1;
		do {
			menu();
			try {chon = Integer.parseInt(sc.nextLine()); }
				catch (NumberFormatException e) {System.out.println("Vui long nhap so!");
				continue;
				}
				switch(chon) {
				case 1: themThucPham(); break;
				case 2: xoaThucPham(); break;
				case 3: suaThucPham(); break;
				case 4: ql.hienThiDanhSach(); break;
				case 5: sapXepMenu(); break;
				case 6: timKiemMenu(); break;
				case 7: trichLocTheoNgay(); break;
				case 8: thongKe(); break;
				case 0: System.out.println("Tam biet!"); break;
				default: System.out.println("Lua chon khong hop le!");
				
				}
			} while (chon != 0);
			sc.close();
		}
	static void menu() {
		System.out.println("\n=================Quan ly thuc pham================");
		System.out.println("|| 1. Them thuc pham                                ||");
		System.out.println("|| 2. Xoa theo id                                   ||");
		System.out.println("|| 3. Sua theo id                                   ||");
		System.out.println("|| 4. Hien thi danh sach                            ||");
		System.out.println("|| 5. Sap xep                                       ||");
		System.out.println("|| 6. Tim kiem theo ten                             ||");
		System.out.println("|| 7. Trich loc theo khoang ngay                    ||");
		System.out.println("|| 8. Thong ke                                      ||");
		System.out.println("|| 0. Thoat                                         ||");
		System.out.println("=====================================================");
	}
	static void duLieuMau() {
        ql.them(new HangThucPham("TP001", "sua tuoi",
                LocalDate.of(2026, 1, 15),
                LocalDate.of(2026, 2, 15), 25000));
        ql.them(new HangThucPham("TP002", " Oreo",
                LocalDate.of(2026, 3, 5),
                LocalDate.of(2026, 6, 5), 15000));
        ql.them(new HangThucPham("TP003", "Coca",
                LocalDate.of(2026, 1, 20),
                LocalDate.of(2026, 9, 20), 12000));
        ql.them(new HangThucPham("TP004", "TH True",
                LocalDate.of(2026, 5, 10),
                LocalDate.of(2026, 5, 25), 8000));
        ql.them(new HangThucPham("TP005", "Banh Mi ",
                LocalDate.of(2026, 8, 1),
                LocalDate.of(2026, 8, 15), 20000));
        System.out.println("Da nap 5 sp mau.");
    }

    static void themThucPham() {
        try {
            System.out.print("Ma hang: "); String ma = sc.nextLine();
            System.out.print("Ten hang: "); String ten = sc.nextLine();
            System.out.print("Ngày SX (dd/MM/yyyy): ");
            LocalDate sx = LocalDate.parse(sc.nextLine(), df);
            System.out.print("Ngay HH (dd/MM/yyyy): ");
            LocalDate hh = LocalDate.parse(sc.nextLine(), df);
            System.out.print("Gia: "); float gia = Float.parseFloat(sc.nextLine());

            HangThucPham h = new HangThucPham(ma, ten, sx, hh, gia);
            if (ql.them(h)) System.out.println("Them thanh cong");
        } catch (Exception e) { System.out.println("Loi: " + e.getMessage()); }
    }

    static void xoaThucPham() {
        try {
            System.out.print("Nhap id can xoa: ");
            int id = Integer.parseInt(sc.nextLine());
            if (ql.xoa(id)) System.out.println("Da xoa id" + id);
        } catch (NumberFormatException e) { System.out.println("ID phai la so"); }
    }

    static void suaThucPham() {
        try {
            System.out.print("Nhap id can sua: ");
            int id = Integer.parseInt(sc.nextLine());
            System.out.print("Ten moi: "); String ten = sc.nextLine();
            System.out.print("Ngay sx moi(dd/MM/yyyy): ");
            LocalDate sx = LocalDate.parse(sc.nextLine(), df);
            System.out.print("Ngay hh moi(dd/MM/yyyy): ");
            LocalDate hh = LocalDate.parse(sc.nextLine(), df);
            System.out.print("Gia moi: "); float gia = Float.parseFloat(sc.nextLine());

            if (ql.sua(id, ten, sx, hh, gia)) System.out.println("Da sua id" + id);
        } catch (Exception e) { System.out.println("Loi " + e.getMessage()); }
    }

    static void sapXepMenu() {
        System.out.println("  a. Gia tang | b. Gia giam");
        System.out.println("  c. Ngay sx tang | d. Ngay SX giam");
        System.out.println("  e. Ngay HH tang | f. Ngay HH giam");
        System.out.print("  Chon: ");
        String c = sc.nextLine().toLowerCase();
        switch (c) {
            case "a": ql.sapXepTheoGia(true); break;
            case "b": ql.sapXepTheoGia(false); break;
            case "c": ql.sapXepTheoNgaySanXuat(true); break;
            case "d": ql.sapXepTheoNgaySanXuat(false); break;
            case "e": ql.sapXepTheoNgayHetHan(true); break;
            case "f": ql.sapXepTheoNgayHetHan(false); break;
            default: System.out.println("Khong hop le"); return;
        }
        ql.hienThiDanhSach();
    }

    static void timKiemMenu() {
        System.out.println("  a. Tien to  | b. Hau to | c. Gan giong");
        System.out.print("  Chon: ");
        String c = sc.nextLine().toLowerCase();
        System.out.print("  Nhap tu khoa: ");
        String tk = sc.nextLine();

        QuanLyThucPham kq;
        switch (c) {
            case "a": kq = ql.timTheoTienTo(tk); break;
            case "b": kq = ql.timTheoHauTo(tk); break;
            case "c": kq = ql.timGanGiong(tk); break;
            default: System.out.println("Khong hop le"); return;
        }
        System.out.println("Tim thay" + kq.laySoLuong() + " ket quaả:");
        kq.hienThiDanhSach();
    }

    static void trichLocTheoNgay() {
        try {
            System.out.println("  a. Loc theo ngay sx | b.Loc theo ngay hh");
            System.out.print("  Chon: ");
            String c = sc.nextLine().toLowerCase();
            System.out.print("  Tu ngay (dd/MM/yyyy): ");
            LocalDate tu = LocalDate.parse(sc.nextLine(), df);
            System.out.print("  Den ngay (dd/MM/yyyy): ");
            LocalDate den = LocalDate.parse(sc.nextLine(), df);

            QuanLyThucPham kq;
            if (c.equals("a")) kq = ql.trichLocTheoNgaySanXuat(tu, den);
            else if (c.equals("b")) kq = ql.trichLocTheoNgayHetHan(tu, den);
            else { System.out.println(" Ko hop le!"); return; }

            System.out.println("Trich lo duoc " + kq.laySoLuong() + "ket qua:");
            kq.hienThiDanhSach();
        } catch (Exception e) { System.out.println("Loi: " + e.getMessage()); }
    }

    static void thongKe() {
        System.out.println("\n===== Thong Ke =====");
        System.out.println("Tong so sp: " + ql.tinhTongSoLuong());
        System.out.printf("Tong gia tri %,.0f VNĐ\n", ql.tinhTongGiaTri());
        if (ql.tinhTongSoLuong() > 0)
            System.out.printf("Gia trung binh %,.0f VNĐ\n",
                ql.tinhTongGiaTri() / ql.tinhTongSoLuong());
        ql.thongKeTheoThang();
    }
}
		


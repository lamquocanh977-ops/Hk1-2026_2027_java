package m36.LamQuocAnh;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class QuanLyGiaoDich {

    public static void main(String[] args) {

        List<GiaoDich> danhSach = new ArrayList<>();

        // Giao dich dat
        danhSach.add(new GiaoDichDat("GD001",
                LocalDate.of(2011, 12, 1), 10_000_000, 120, "A"));

        danhSach.add(new GiaoDichDat("GD009",
                LocalDate.of(2015, 7, 6), 8_000_000, 150, "B"));

        danhSach.add(new GiaoDichDat("GD002",
                LocalDate.of(2020, 7, 8), 6_000_000, 180, "C"));

        // Giao dich nha
        danhSach.add(new GiaoDichNha("Nha1",
                LocalDate.of(2023, 5, 11), 6_000_000, 158,
                "Cao Cap", "An Dong"));

        danhSach.add(new GiaoDichNha("Nha2",
                LocalDate.of(2024, 6, 7), 180_000_000, 145,
                "Trung cap", "Go Vap"));

        danhSach.add(new GiaoDichNha("Nha3",
                LocalDate.of(2025, 5, 11), 15_000_000, 150,
                "Cao Cap", "Quan 1"));

        // Dem so luong giao dich
        int soLuongDat = 0;
        int soLuongNha = 0;

        for (GiaoDich gd : danhSach) {
            if (gd instanceof GiaoDichDat) {
                soLuongDat++;
            } else if (gd instanceof GiaoDichNha) {
                soLuongNha++;
            }
        }

        System.out.println("So luong dat: " + soLuongDat);
        System.out.println("So luong nha: " + soLuongNha);

        // Tinh trung binh thanh tien giao dich dat
        double tongTienDat = 0;

        for (GiaoDich gd : danhSach) {
            if (gd instanceof GiaoDichDat) {
                tongTienDat += gd.thanhTien();
            }
        }

        double trungBinh = (soLuongDat > 0)
                ? tongTienDat / soLuongDat : 0;

        System.out.printf("Trung binh tong tien dat: %.0f%n", trungBinh);

        // Xuat giao dich thang 6 nam 2024
        System.out.println("\nGiao dich thang 6 nam 2024:");

        for (GiaoDich gd : danhSach) {
            if (gd.getNgayGiaoDich().getMonthValue() == 6
                    && gd.getNgayGiaoDich().getYear() == 2024) {

                System.out.println(gd);
            }
        }
    }
}

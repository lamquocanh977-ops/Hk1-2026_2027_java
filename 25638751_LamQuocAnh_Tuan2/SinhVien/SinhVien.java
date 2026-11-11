
package tuan2.SinhVien;

import java.util.Scanner;

public class SinhVien {
    private int MaSV;
    private String HoTen;
    private float diemLT;
    private float diemTH;

    public SinhVien() {
        this.MaSV = 1;
        this.HoTen = "Chua cap nhat";
        this.diemLT = 0.0f;
        this.diemTH = 0.0f;
    }

    public int getMaSV() {
        return MaSV;
    }

    public void setMaSV(int maSV) {
        if (maSV > 0) {
            this.MaSV = maSV;
        } else {
            this.MaSV = 1;
        }
    }

    public String getHoTen() {
        return HoTen;
    }

    public void setHoTen(String hoTen) {
        if (hoTen != null && !hoTen.trim().isEmpty()) {
            this.HoTen = hoTen;
        } else {
            this.HoTen = "Chua cap nhat";
        }
    }

    public double getDiemLT() {
        return diemLT;
    }

    public void setDiemLT(float diemLT) {
        if (diemLT >= 0 && diemLT <= 10) {
            this.diemLT = diemLT;
        } else {
            this.diemLT = 0.0f;
        }
    }

    public double getDiemTH() {
        return diemTH;
    }

    public void setDiemTH(float diemTH) {
        if (diemTH >= 0 && diemTH <= 10) {
            this.diemTH = diemTH;
        } else {
            this.diemTH = 0.0f;
        }
    }

    public SinhVien(int maSV, String hoTen, float diemLT, float diemTH) {
        setMaSV(maSV);
        setHoTen(hoTen);
        setDiemLT(diemLT);
        setDiemTH(diemTH);
    }

    public float tinhDiemTB() {
        return (diemLT + diemTH) / 2;
    }

    @Override
    public String toString() {
        return String.format(
            "%-10d %-25s %-10.2f %-10.2f %-10.2f",
            MaSV, HoTen, diemLT, diemTH, tinhDiemTB()
        );
    }

    public static void nhapXuat() {
        Scanner sc = new Scanner(System.in);

        System.out.println("Nhap thong tin sinh vien:");

        System.out.print("Nhap ma sinh vien: ");
        int maSV = sc.nextInt();
        sc.nextLine();

        System.out.print("Nhap ho ten: ");
        String hoTen = sc.nextLine();

        System.out.print("Nhap diem ly thuyet (0-10): ");
        float diemLT = sc.nextFloat();

        System.out.print("Nhap diem thuc hanh (0-10): ");
        float diemTH = sc.nextFloat();

        SinhVien sv = new SinhVien(maSV, hoTen, diemLT, diemTH);

        System.out.println("\n===== THONG TIN SINH VIEN =====");
        System.out.printf("%-10s %-25s %-10s %-10s %-10s\n",
                "Ma SV", "Ho Ten", "Diem LT", "Diem TH", "Diem TB");
        System.out.println(sv.toString());
    }

    public static void main(String[] args) {
        nhapXuat();
    }
}

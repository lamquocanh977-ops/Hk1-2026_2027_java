package tuan9_LamQuocAnh;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ListSinhVien implements IFSinhVien {

    private ArrayList<SinhVien> danhSach;

    // Constructor mac dinh
    public ListSinhVien() {
        this.danhSach = new ArrayList<>();
    }

    // Constructor co tham so
    public ListSinhVien(ArrayList<SinhVien> ds) {
        this.danhSach = (ds != null) ? ds : new ArrayList<>();
    }

    // ================= THEM SINH VIEN =================
    @Override
    public boolean them(SinhVien sv) {

        if (sv == null || sv.getMaSV() == null)
            return false;

        if (timTheoMa(sv.getMaSV()) != null)
            return false;

        return danhSach.add(sv);
    }

    // ================= SUA SINH VIEN =================
    @Override
    public boolean sua(String maSV, SinhVien svMoi) {

        if (maSV == null || svMoi == null || svMoi.getMaSV() == null)
            return false;

        for (int i = 0; i < danhSach.size(); i++) {

            if (danhSach.get(i).getMaSV().equalsIgnoreCase(maSV)) {

                // Kiem tra ma sinh vien moi co bi trung khong
                SinhVien svTrung = timTheoMa(svMoi.getMaSV());

                if (svTrung != null &&
                    !svMoi.getMaSV().equalsIgnoreCase(maSV))
                    return false;

                danhSach.set(i, svMoi);

                return true;
            }
        }

        return false;
    }

    // ================= XOA SINH VIEN =================
    @Override
    public boolean xoa(String maSV) {

        if (maSV == null)
            return false;

        return danhSach.removeIf(
            sv -> sv.getMaSV() != null &&
                  sv.getMaSV().equalsIgnoreCase(maSV)
        );
    }

    // ================= XOA TAT CA =================
    @Override
    public boolean xoaTatCa() {

        if (danhSach.isEmpty())
            return false;

        danhSach.clear();

        return true;
    }

    // ================= LAY TAT CA SINH VIEN =================
    @Override
    public List<SinhVien> layTatCa() {

        return new ArrayList<>(danhSach);
    }

    // ================= TIM THEO MA =================
    @Override
    public SinhVien timTheoMa(String maSV) {

        if (maSV == null)
            return null;

        for (SinhVien sv : danhSach) {

            if (sv.getMaSV() != null &&
                sv.getMaSV().equalsIgnoreCase(maSV))
                return sv;
        }

        return null;
    }

    // ================= TIM KIEM PREDICATE =================
    // Co the tim theo nhieu dieu kien khac nhau
    public List<SinhVien> tim(Predicate<SinhVien> dieuKien) {

        List<SinhVien> kq = new ArrayList<>();

        if (dieuKien == null)
            return kq;

        for (SinhVien sv : danhSach) {

            if (dieuKien.test(sv))
                kq.add(sv);
        }

        return kq;
    }

    // ================= TIM THEO TEN =================
    @Override
    public List<SinhVien> timTheoTen(String tuKhoa) {

        List<SinhVien> kq = new ArrayList<>();

        if (tuKhoa == null)
            return kq;

        for (SinhVien sv : danhSach) {

            if (sv.getHoTen() != null &&
                sv.getHoTen().toLowerCase()
                .contains(tuKhoa.toLowerCase())) {

                kq.add(sv);
            }
        }

        return kq;
    }

    // ================= TIM THEO LOP =================
    @Override
    public List<SinhVien> timTheoLop(String lop) {

        List<SinhVien> kq = new ArrayList<>();

        if (lop == null)
            return kq;

        for (SinhVien sv : danhSach) {

            if (sv.getLop() != null &&
                sv.getLop().equalsIgnoreCase(lop))
                kq.add(sv);
        }

        return kq;
    }

    // ================= TIM THEO LOAI =================
    @Override
    public List<SinhVien> timTheoLoai(String loai) {

        List<SinhVien> kq = new ArrayList<>();

        if (loai == null)
            return kq;

        for (SinhVien sv : danhSach) {

            if (sv.getLoai().equalsIgnoreCase(loai))
                kq.add(sv);
        }

        return kq;
    }

    // ================= TIM THEO MON HOC =================
    @Override
    public List<SinhVien> timTheoMon(MonHoc monHoc) {

        List<SinhVien> kq = new ArrayList<>();

        if (monHoc == null)
            return kq;

        for (SinhVien sv : danhSach) {

            if (sv.getMonHoc() == monHoc)
                kq.add(sv);
        }

        return kq;
    }

    // ================= TONG SO LUONG =================
    @Override
    public int tongSoLuong() {

        return danhSach.size();
    }

    // ================= TONG THANH TIEN =================
    @Override
    public double tongThanhTien() {

        double tong = 0;

        for (SinhVien sv : danhSach) {

            tong += sv.thanhTien();
        }

        return tong;
    }

    // ================= SAP XEP THEO COMPARATOR =================
    public void sapXep(Comparator<SinhVien> cmp) {

        if (cmp != null)
            danhSach.sort(cmp);
    }

    // ================= SAP XEP GIAM DAN =================
    public void sapXepGiamDan(Comparator<SinhVien> cmp) {

        if (cmp != null)
            danhSach.sort(cmp.reversed());
    }

    // ================= SAP XEP THEO TEN =================
    @Override
    public List<SinhVien> sapXepTheoTen() {

        List<SinhVien> kq = new ArrayList<>(danhSach);

        kq.sort(Comparator.comparing(SinhVien::getHoTen,
                Comparator.nullsLast(String.CASE_INSENSITIVE_ORDER)));

        return kq;
    }

    // ================= SAP XEP THEO THANH TIEN GIAM DAN =================
    @Override
    public List<SinhVien> sapXepTheoThanhTienGiamDan() {

        List<SinhVien> kq = new ArrayList<>(danhSach);

        kq.sort(
            Comparator.comparingDouble(SinhVien::thanhTien).reversed()
        );

        return kq;
    }

    // ================= MAP =================
    // Tao Map voi Key la ma sinh vien, Value la doi tuong SinhVien
    public Map<String, SinhVien> taoMapSinhVien() {

        Map<String, SinhVien> map = new HashMap<>();

        for (SinhVien sv : danhSach) {

            map.put(sv.getMaSV(), sv);
        }

        return map;
    }

    // ================= GROUP BY LOP =================
    // Gom nhom sinh vien theo lop
    public Map<String, List<SinhVien>> groupByLop() {

        return danhSach.stream()
                .collect(Collectors.groupingBy(SinhVien::getLop));
    }

    // ================= HAVING SO LUONG SINH VIEN =================
    // Chi lay lop co so luong sinh vien >= soLuong
    public Map<String, List<SinhVien>> havingSoLuongSinhVien(int soLuong) {

        Map<String, List<SinhVien>> map = groupByLop();

        map.entrySet().removeIf(
            entry -> entry.getValue().size() < soLuong
        );

        return map;
    }

    // ================= HAVING TONG THANH TIEN =================
    // Chi lay lop co tong thanh tien > mucTien
    public Map<String, Double> havingTongThanhTien(double mucTien) {

        Map<String, Double> map = new HashMap<>();

        for (SinhVien sv : danhSach) {

            String lop = sv.getLop();

            map.put(
                lop,
                map.getOrDefault(lop, 0.0) + sv.thanhTien()
            );
        }

        map.entrySet().removeIf(
            entry -> entry.getValue() <= mucTien
        );

        return map;
    }
}
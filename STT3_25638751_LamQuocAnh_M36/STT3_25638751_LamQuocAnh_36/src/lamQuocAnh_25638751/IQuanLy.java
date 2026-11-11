
package lamQuocAnh_25638751;

import java.util.List;

public interface IQuanLy<T> {

    // Them, sua, xoa
    void them(T t);
    boolean xoa(String ma);
    boolean sua(String ma, T tMoi);

    // Tim kiem
    T timKiemTheoMa(String ma);
    List<T> timKiemTheoTen(String ten);
    List<T> timKiemTheoMaPrefix(String prefix);

    // Lay danh sach
    List<T> getDanhSach();
}

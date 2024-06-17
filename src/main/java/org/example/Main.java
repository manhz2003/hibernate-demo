//package org.example;
//
//import org.hibernate.Session;
//import org.hibernate.SessionFactory;
//import org.hibernate.cfg.Configuration;
//
//import java.util.List;
//
//public class Main {
//    private SessionFactory factory;
//
//    public Main() {
//        factory = new Configuration()
//                .configure("hibernate.cfg.xml")
//                .addAnnotatedClass(KhachHang.class)
//                .buildSessionFactory();
//    }
//
//    public Long themKhachHang(String name, String address, String phone) {
//        Session session = factory.getCurrentSession();
//        session.beginTransaction();
//
//        KhachHang khachHang = new KhachHang(name, address, phone);
//        Long id = (Long) session.save(khachHang);
//
//        session.getTransaction().commit();
//        return id;
//    }
//
//    public List<KhachHang> xemDanhSachKhachHang() {
//        Session session = factory.getCurrentSession();
//        session.beginTransaction();
//
//        List<KhachHang> khachHangs = session.createQuery("from KhachHang").getResultList();
//
//        session.getTransaction().commit();
//        return khachHangs;
//    }
//
//    public void suaThongTinKhachHang(Long id, String name, String address, String phone) {
//        Session session = factory.getCurrentSession();
//        session.beginTransaction();
//
//        KhachHang khachHang = session.get(KhachHang.class, id);
//        khachHang.setName(name);
//        khachHang.setAddress(address);
//        khachHang.setPhone(phone);
//
//        session.getTransaction().commit();
//    }
//
//    public void xoaKhachHang(Long id) {
//        Session session = factory.getCurrentSession();
//        session.beginTransaction();
//
//        KhachHang khachHang = session.get(KhachHang.class, id);
//        session.delete(khachHang);
//
//        session.getTransaction().commit();
//    }
//
//    public void xoaTatCaKhachHang() {
//        Session session = factory.getCurrentSession();
//        session.beginTransaction();
//
//        session.createQuery("delete from KhachHang").executeUpdate();
//
//        session.getTransaction().commit();
//    }
//
//    public List<KhachHang> timKiemKhachHangTheoTen(String name) {
//        Session session = factory.getCurrentSession();
//        session.beginTransaction();
//
//        List<KhachHang> khachHangs = session.createQuery("from KhachHang kh where kh.name = :name")
//                .setParameter("name", name)
//                .getResultList();
//
//        session.getTransaction().commit();
//        return khachHangs;
//    }
//
//    public static void main(String[] args) {
//        Main app = new Main();
//
////        tạo khách hàng có id
//        Long khachHangId = app.themKhachHang("Nguyen Van A", "Ha Noi", "0123456789");
//
//        // Thêm khách hàng
//        System.out.println("Đã thêm khách hàng có ID: " + khachHangId);
//        System.out.println("Danh sách khách hàng sau khi thêm:");
//        app.xemDanhSachKhachHang().forEach(kh -> System.out.println(kh));
//
//        // Sửa thông tin khách hàng
////        app.suaThongTinKhachHang(khachHangId, "Nguyen Van B", "Ho Chi Minh", "0987654321");
////        System.out.println("Đã sửa thông tin khách hàng có ID: " + khachHangId);
////        System.out.println("Danh sách khách hàng sau khi sửa:");
////        app.xemDanhSachKhachHang().forEach(kh -> System.out.println(kh));
//
//        // Xóa khách hàng
////        app.xoaKhachHang(khachHangId);
////        System.out.println("Đã xóa khách hàng có ID: " + khachHangId);
////        System.out.println("Danh sách khách hàng sau khi xóa:");
////        app.xemDanhSachKhachHang().forEach(kh -> System.out.println(kh));
//
//        // Xóa tất cả khách hàng
////        app.xoaTatCaKhachHang();
////        System.out.println("Đã xóa tất cả khách hàng");
////        System.out.println("Danh sách khách hàng sau khi xóa tất cả:");
////        app.xemDanhSachKhachHang().forEach(kh -> System.out.println(kh));
//
//        // Tìm kiếm khách hàng theo tên
////        String searchName = "Nguyen Van A";
////        List<KhachHang> khachHangs = app.timKiemKhachHangTheoTen(searchName);
////        System.out.println("Kết quả tìm kiếm thông tin khách hàng có tên là': "+ searchName);
////        khachHangs.forEach(kh -> System.out.println(kh));
//    }
//}

package org.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class Main {
    private SessionFactory factory;

    public Main() {
        factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(KhachHang.class)
                .addAnnotatedClass(Sach2.class)
                .buildSessionFactory();
    }

    // các phương thức liên quan đến KhachHang...

    public Long themSach2(String tenSach, String tacGia, double giaBan) {
        Session session = factory.getCurrentSession();
        session.beginTransaction();

        Sach2 sach2 = new Sach2(tenSach, tacGia, giaBan);
        Long id = (Long) session.save(sach2);

        session.getTransaction().commit();
        return id;
    }

    public List<Sach2> xemDanhSachSach2() {
        Session session = factory.getCurrentSession();
        session.beginTransaction();

        List<Sach2> sach2s = session.createQuery("from Sach2").getResultList();

        session.getTransaction().commit();
        return sach2s;
    }

    public void suaThongTinSach2(Long id, String tenSach, String tacGia, double giaBan) {
        Session session = factory.getCurrentSession();
        session.beginTransaction();

        Sach2 sach2 = session.get(Sach2.class, id);
        sach2.setTenSach(tenSach);
        sach2.setTacGia(tacGia);
        sach2.setGiaBan(giaBan);

        session.getTransaction().commit();
    }

    public void xoaSach2(Long id) {
        Session session = factory.getCurrentSession();
        session.beginTransaction();

        Sach2 sach2 = session.get(Sach2.class, id);
        session.delete(sach2);

        session.getTransaction().commit();
    }

    public void xoaTatCaSach2() {
        Session session = factory.getCurrentSession();
        session.beginTransaction();

        session.createQuery("delete from Sach2").executeUpdate();

        session.getTransaction().commit();
    }

    public List<Sach2> timKiemSach2TheoTen(String tenSach) {
        Session session = factory.getCurrentSession();
        session.beginTransaction();

        List<Sach2> sach2s = session.createQuery("from Sach2 s where s.tenSach = :tenSach")
                .setParameter("tenSach", tenSach)
                .getResultList();

        session.getTransaction().commit();
        return sach2s;
    }

    public static void main(String[] args) {
        Main app = new Main();

        // Thêm sách
        Long sachId = app.themSach2("Dế Mèn Phiêu Lưu Ký", "Tô Hoài", 50000);
        System.out.println("Đã thêm sách có ID: " + sachId);
        System.out.println("Danh sách sách sau khi thêm:");
        app.xemDanhSachSach2().forEach(sach -> System.out.println(sach));

        // Sửa thông tin sách
        app.suaThongTinSach2(sachId, "Dế Mèn Phiêu Lưu Ký (tái bản)", "Tô Hoài", 55000);
        System.out.println("Đã sửa thông tin sách có ID: " + sachId);
        System.out.println("Danh sách sách sau khi sửa:");
        app.xemDanhSachSach2().forEach(sach -> System.out.println(sach));

        // Xóa sách
        app.xoaSach2(sachId);
        System.out.println("Đã xóa sách có ID: " + sachId);
        System.out.println("Danh sách sách sau khi xóa:");
        app.xemDanhSachSach2().forEach(sach -> System.out.println(sach));

        // Xóa tất cả sách
        app.xoaTatCaSach2();
        System.out.println("Đã xóa tất cả sách");
        System.out.println("Danh sách sách sau khi xóa tất cả:");
        app.xemDanhSachSach2().forEach(sach -> System.out.println(sach));

        // Tìm kiếm sách theo tên
        String searchName = "Dế Mèn Phiêu Lưu Ký";
        List<Sach2> sach2s = app.timKiemSach2TheoTen(searchName);
        System.out.println("Kết quả tìm kiếm sách có tên là': "+ searchName);
        sach2s.forEach(sach -> System.out.println(sach));
    }

}
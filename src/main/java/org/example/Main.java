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
                .buildSessionFactory();
    }

    public Long themKhachHang(String name, String address, String phone) {
        Session session = factory.getCurrentSession();
        session.beginTransaction();

        KhachHang khachHang = new KhachHang(name, address, phone);
        Long id = (Long) session.save(khachHang);

        session.getTransaction().commit();
        return id;
    }

    public List<KhachHang> xemDanhSachKhachHang() {
        Session session = factory.getCurrentSession();
        session.beginTransaction();

        List<KhachHang> khachHangs = session.createQuery("from KhachHang").getResultList();

        session.getTransaction().commit();
        return khachHangs;
    }

    public void suaThongTinKhachHang(Long id, String name, String address, String phone) {
        Session session = factory.getCurrentSession();
        session.beginTransaction();

        KhachHang khachHang = session.get(KhachHang.class, id);
        khachHang.setName(name);
        khachHang.setAddress(address);
        khachHang.setPhone(phone);

        session.getTransaction().commit();
    }

    public void xoaKhachHang(Long id) {
        Session session = factory.getCurrentSession();
        session.beginTransaction();

        KhachHang khachHang = session.get(KhachHang.class, id);
        session.delete(khachHang);

        session.getTransaction().commit();
    }

    public void xoaTatCaKhachHang() {
        Session session = factory.getCurrentSession();
        session.beginTransaction();

        session.createQuery("delete from KhachHang").executeUpdate();

        session.getTransaction().commit();
    }

    public List<KhachHang> timKiemKhachHangTheoTen(String name) {
        Session session = factory.getCurrentSession();
        session.beginTransaction();

        List<KhachHang> khachHangs = session.createQuery("from KhachHang kh where kh.name = :name")
                .setParameter("name", name)
                .getResultList();

        session.getTransaction().commit();
        return khachHangs;
    }

    public KhachHang timKiemKhachHangTheoId(long id) {
        Session session = factory.getCurrentSession();
        session.beginTransaction();

        KhachHang khachHang = session.get(KhachHang.class, id);

        session.getTransaction().commit();
        return khachHang;
    }

    public static void main(String[] args) {
        Main app = new Main();

//        tạo khách hàng có id
        Long khachHangId = app.themKhachHang("Nguyen Van A", "Ha Noi", "0123456789");

        // Thêm khách hàng
        System.out.println("Đã thêm khách hàng có ID: " + khachHangId);
        System.out.println("Danh sách khách hàng sau khi thêm:");
        app.xemDanhSachKhachHang().forEach(kh -> System.out.println(kh));

        // Sửa thông tin khách hàng
//        app.suaThongTinKhachHang(khachHangId, "Nguyen Van B", "Ho Chi Minh", "0987654321");
//        System.out.println("Đã sửa thông tin khách hàng có ID: " + khachHangId);
//        System.out.println("Danh sách khách hàng sau khi sửa:");
//        app.xemDanhSachKhachHang().forEach(kh -> System.out.println(kh));

        // Xóa khách hàng
//        app.xoaKhachHang(11L);
//        System.out.println("Đã xóa khách hàng có ID: " + khachHangId);
//        System.out.println("Danh sách khách hàng sau khi xóa:");
//        app.xemDanhSachKhachHang().forEach(kh -> System.out.println(kh));

        // Xóa tất cả khách hàng
//        app.xoaTatCaKhachHang();
//        System.out.println("Đã xóa tất cả khách hàng");
//        System.out.println("Danh sách khách hàng sau khi xóa tất cả:");
//        app.xemDanhSachKhachHang().forEach(kh -> System.out.println(kh));

        // Tìm kiếm khách hàng theo tên
//        String searchName = "Nguyen Van A";
//        List<KhachHang> khachHangs = app.timKiemKhachHangTheoTen(searchName);
//        System.out.println("Kết quả tìm kiếm thông tin khách hàng có tên là': "+ searchName);
//        khachHangs.forEach(kh -> System.out.println(kh));

        // Tìm kiếm khách hàng theo id
//        KhachHang khachHangById = app.timKiemKhachHangTheoId(11L);
//        System.out.println("Kết quả tìm kiếm thông tin khách hàng có ID: "+ khachHangById);
    }
}
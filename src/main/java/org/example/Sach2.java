package org.example;

import javax.persistence.*;

@Entity
@Table(name = "sach2")
public class Sach2 {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "ten_sach")
    private String tenSach;

    @Column(name = "tac_gia")
    private String tacGia;

    @Column(name = "gia_ban")
    private double giaBan;


    public Sach2() {
    }

    public Sach2(String tenSach, String tacGia, double giaBan) {
        this.tenSach = tenSach;
        this.tacGia = tacGia;
        this.giaBan = giaBan;
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTenSach() {
        return tenSach;
    }

    public void setTenSach(String tenSach) {
        this.tenSach = tenSach;

    }

    public String getTacGia() {
        return tacGia;
    }

    public void setTacGia(String tacGia) {
        this.tacGia = tacGia;
    }

    public double getGiaBan() {
        return giaBan;
    }

    public void setGiaBan(double giaBan) {
        this.giaBan = giaBan;
    }



    @Override
    public String toString() {
        return "Sach2{" +
                "id=" + id +
                ", tenSach='" + tenSach + '\'' +
                ", tacGia='" + tacGia + '\'' +
                ", giaBan=" + giaBan +
                '}';
    }
}
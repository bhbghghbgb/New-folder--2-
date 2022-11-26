package ThuVien;

import java.util.Scanner;

public abstract class adminDocument {
    static Scanner scanner = new Scanner(System.in);
    private long ma;
    private String ten;
    private int soLuongBanSao;
    private boolean trangThai;
    private TacGia tacGia;
    private int namXuatBan;

    public adminDocument(long ma, String ten, int soLuongBanSao, boolean trangThai, TacGia tacGia, int namXuatBan) {
        this.ma = ma;
        this.ten = ten;
        this.soLuongBanSao = soLuongBanSao;
        this.trangThai = trangThai;
        this.tacGia = tacGia;
        this.namXuatBan = namXuatBan;
    }

    public adminDocument() {
    }

    public long getMa() {
        return ma;
    }

    public void setMa(long ma) {
        this.ma = ma;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public int getSoLuongBanSao() {
        return soLuongBanSao;
    }

    public void setSoLuongBanSao(int soLuongBanSao) {
        this.soLuongBanSao = soLuongBanSao;
    }

    public boolean isTrangThai() {
        return trangThai;
    }

    public TacGia getTacGia() {
        return tacGia;
    }

    public void setTacGia(TacGia tacGia) {
        this.tacGia = tacGia;
    }

    public int getNamXuatBan() {
        return namXuatBan;
    }

    public void setNamXuatBan(int namXuatBan) {
        this.namXuatBan = namXuatBan;
    }

    public void setTrangThai(boolean trangThai) {
        this.trangThai = trangThai;
    }

    abstract void insertDoc(long ma, String ten, int soLuongBanSao, boolean trangThai, TacGia tacGia, int namXuatBan);

    abstract void removeDoc(long ma);

    abstract void updateDoc(long ma, String ten, int newSoLuongBanSao, boolean newTrangThai, TacGia tacGia, int newNamXuatBan);

    abstract void searchDoc(long ma);

    abstract void sort();

    @Override
    public String toString() {
        return String.format("%-10s|%-10s|%-10s|%-10s|%-10s|%-10s", ma, ten, soLuongBanSao, trangThai, tacGia, namXuatBan);
    }
}

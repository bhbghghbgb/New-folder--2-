package ThuVien;

import java.util.Arrays;

public class adminDoc_menu extends adminDocument {
    static adminDoc_menu[] docList = new adminDoc_menu[][0];

    public adminDoc_menu(long ma, String ten, int soLuongBanSao, boolean trangThai, TacGia tacGia, int namXuatBan) {
        super(ma, ten, soLuongBanSao, trangThai, tacGia, namXuatBan);
    }
    public adminDoc_menu(){}

    @Override
    public void insertDoc(long ma, String ten, int soLuongBanSao, boolean trangThai, TacGia tacGia, int namXuatBan) {
        boolean found = false;
        for (int i = 0; i < docList.length; i++)
            if (docList[i].getTen().equals(ten)) {
                found = true;
                if (!docList[i].getPhone().equals(phone))
                    phoneList[i].setPhone(phoneList[i].getPhone() + " : " + phone);
                break;
            }
        if (!found) {
            phoneList = Arrays.copyOf(phoneList, phoneList.length + 1);
            phoneList[phoneList.length - 1] = new PhoneBook(name, phone);
        }
    }

    @Override
    public void removeDoc(String name) {
        boolean found = false;
        for (int i = 0; i < phoneList.length; i++)
            if (phoneList[i].getName().equals(name)) {
                found = true;
                for (int j = i; j < phoneList.length - 1; j++)
                    phoneList[j] = phoneList[j + 1];
                phoneList = Arrays.copyOf(phoneList, phoneList.length - 1);
                break;
            }
        if (!found)
            System.out.println("Name not found!");
    }

    @Override

    public void updateDoc(String name, String newphone) {
        boolean found = false;
        for (int i = 0; i < phoneList.length; i++)
            if (phoneList[i].getName().equals(name)) {
                found = true;
                phoneList[i].setPhone(newphone);
                break;
            }
        if (!found)
            System.out.println("Name not found!");
    }

    @Override
    public void searchDoc(String name) {
        boolean found = false;
        for (int i = 0; i < phoneList.length; i++)
            if (phoneList[i].getName().equals(name)) {
                found = true;
                System.out.println("Name:" + phoneList[i].getName());
                System.out.println("Phone:" + phoneList[i].getPhone());
                break;
            }
        if (!found)
            System.out.println("Name not found!");
    }

    @Override
    public void sort() {
        for (int i = 0; i < phoneList.length - 1; i++)
            for (int j = i + 1; j < phoneList.length; j++)
                if (phoneList[i].getName().compareTo(phoneList[j].getName()) > 0) {
                    PhoneBook tmp = phoneList[i];
                    phoneList[i] = phoneList[j];
                    phoneList[j] = tmp;
                    break;
                }
    }

    public void display() {
        for (int i = 0; i < phoneList.length; i++)
            System.out.println(phoneList[i].toString());
    }
}
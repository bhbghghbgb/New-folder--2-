package ThuVien;

import Polyfill.StringHelper;

public class Login {
    public void login() {
        System.out.println("Ban la: ");
        int dangNhap = 0;
        int userInp = StringHelper.acceptInput("Quan ly", "Thu Ngan", "Doc Gia", "CEO");
        switch (userInp) {
            case 1 -> dangNhap = new Managers().login();
            case 2 -> dangNhap = new Cashiers().login();
            case 3 -> dangNhap = new Readers().login();
            case 4 -> dangNhap = new Owner().login();
        }

        if (dangNhap != -1) {
            System.out.println("Dang nhap thanh cong");
        }

        else {
            System.out.println("Dang nhap khong thanh cong");
        }
    }
    //Sau khi dang nhap thanh cong, gọi dashboard
}

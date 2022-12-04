package ThuVien;

import Polyfill.KhoangThoiGian;
import Polyfill.StringHelper;
import Polyfill.ThoiGian;

public abstract class Account extends People {
//    Khởi tạo tài khoản bời tên và id
//    thời gian khởi tạo: hiện tại
    public Account(int id, String username) {
        this(id, username, ThoiGian.now());
    }

//    Khởi tạo có thời gian
    protected Account(int id, String username, ThoiGian registration) {
        super(id);
        this.username = username;
        this.registration = registration;
    }

    public String getUsername() {
        return username;
    }

//    Nếu pass không được nhập hoặc k đúng trả về false
    public boolean checkPassword(String password) {
        return StringHelper.isNullOrBlank(this.password) || this.password.equals(password);
    }

    public boolean changePassword(String oldPassword, String newPassword) {
        if (oldPassword == null) {//TH không có pass cũ
            oldPassword = "";
        }
        if (!checkPassword(oldPassword.trim())) {//Nếu pass cũ k null hoặc k đúng
            return false;
        }
        password = newPassword.trim();//trim: loại bỏ các dấu cách
        return true;
    }

    protected String getPassword() {
        return password;
    }

    public ThoiGian getRegistration() {
        return registration;
    }

    @Override
    public String toString() {
        return StringHelper.liner(super.toString(),
                StringHelper.itemer("Username", username),
                StringHelper.itemer("Password", StringHelper.spacer("[" + password.length(), "character]")),
                StringHelper.itemer("Registration date", registration),
                StringHelper.itemer("Registered", KhoangThoiGian.between(registration, ThoiGian.now())));
    }

    private final String username;
    private String password;
    private final ThoiGian registration;//Thời gian đăng ký
}

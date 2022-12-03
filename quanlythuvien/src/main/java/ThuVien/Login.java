package ThuVien;

import Polyfill.StringHelper;

public class Login {
    public static void login() {
        int index = 0;
        Object o;
        while (true) {
            System.out.println("Ban la: ");
            int userInp = StringHelper.acceptInput("Quan ly", "Thu Ngan", "Doc Gia", "CEO");
            switch (userInp) {
                case 1 -> {
                    o = (Object) new Managers();
                    Managers managers = (Managers) o;//Downcasting
                    if ((index = managers.login()) != -1) {
                        Manager manager = Global.managers.instance.at(index);
                        if (manager.dashboard() == 0)
                            continue;
                    }
                }
                case 2 -> {
                    o = (Object) new Cashiers();
                    Cashiers cashiers = (Cashiers) o;
                    if ((index = cashiers.login()) != -1) {
                        Cashier cashier = Global.cashiers.instance.at(index);
                        if (cashier.dashboard() == 0)
                            continue;
                    }
                }
                case 3 -> {
                    o = (Object) new Readers();
                    Readers readers = (Readers) o;
                    if ((index = readers.login()) != -1) {
                        Reader reader = Global.readers.instance.at(index);
                        if (reader.dashboard() == 0) {
                            continue;
                        }
                    }
                }
                case 4 -> {
                    o = (Object) new Owner();
                    Owner owner = (Owner) o;
                    if ((index = owner.login()) != -1) {
                        if (owner.dashboard() == 0) {
                            continue;
                        }
                    }
                }
            }
        }
    }
    //Sau khi dang nhap thanh cong, gọi dashboard
}

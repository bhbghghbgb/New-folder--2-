package ThuVien;

import Polyfill.PFArray;
import Polyfill.ThoiGian;

import java.util.stream.IntStream;

import static ThuVien.DangNhap.scanner;

public class Documents extends Management<Document> {
    public Documents() {
    }


    private Document acccessInpDoc() {
        Document document = null;
        System.out.println("Nhap ten sach: ");
        document.setName(scanner.nextLine());

        System.out.println("Nhap so luong tac gia: ");
        Author[] authors = new Author[Integer.parseInt(scanner.nextLine())];
        document.setAuthors(authors);

        System.out.println("Nhap so luong ban sao: ");
        document.setCopies(Integer.parseInt(scanner.nextLine()));

        System.out.println("Nhap thoi gian xuat ban: ");
        document.setPublication(ThoiGian.parseTG(scanner.nextLine()));

        instance.push_back(document);

        return document;
    }

    public int menuEdit() {
        System.out.println("1. Ten  sach");
        System.out.println("2. Tac gia");
        System.out.println("3. Nam xuat ban");
        System.out.println("4. So luong ban sao");
        return Integer.parseInt(scanner.nextLine());
    }

    public Author accessInpAuthor() {
        System.out.println("Nhap ma tac gia: ");
        Author author = new Author(Integer.parseInt(scanner.nextLine()));
        System.out.println("Nhap ten tac gia: ");
        author.setName(scanner.nextLine());
        System.out.println("Nhap ngo ngu: ");
        author.setLanguage(Languages.parseLang(scanner.nextLine()));
        System.out.println("Nhap web: ");
        author.setWebsite(scanner.nextLine());
        System.out.println("Nhap ngay sinh: ");
        author.setBirth(ThoiGian.parseTG(scanner.nextLine()));
        author.setAddress(scanner.nextLine());
        System.out.println("Nhap email: ");
        author.setEmail(scanner.nextLine());
        System.out.println("Nhap so dien thoai: ");
        author.setPhone(scanner.nextLine());
        return author;
    }


    @Override
    public Document add() {
        Document document = acccessInpDoc();
        instance.push_back(document);
        return acccessInpDoc();
    }

    @Override
    public Document remove() {
        Document document = acccessInpDoc();
        int index = search(document.getId());
        if (index != -1) {
            instance.erase(index);
        }

        return document;
    }

    @Override
    public Document edit() {
        Document document = acccessInpDoc();
        int index = search(document.getId());
        if (index != -1) {

            document = instance.at(index);

            switch (menuEdit()) {
                case 1 -> document.setName(scanner.nextLine());
                case 2 -> {
                    System.out.println("Nhap so luong tac gia: ");
                    Author[] authors = new Author[Integer.parseInt(scanner.nextLine())];
                    IntStream.range(0, authors.length).forEach(i -> {
                        authors[i] = accessInpAuthor();
                    });

                    document.setAuthors(authors);
                }
                case 3 -> document.setPublication(ThoiGian.parseTG(scanner.nextLine()));
                case 4 -> document.setCopies(Integer.parseInt(scanner.nextLine()));
            }
        }

        return document;
    }

    @Override
    public int[] search() {
        return new int[0];
    }


    private PFArray<Document> instance;

    public static final class Type {
        public static final int BOOK = 1;
        public static final int MAGAZINE = 2;
        public static final int NATIVE_BOOK = 3;
        public static final int FOREIGN_TRANSLATED_BOOK = 4;
        public static final int FOREIGN_BOOK = 5;
    }
}

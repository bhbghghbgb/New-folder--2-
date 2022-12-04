package ThuVien;

import java.util.stream.Collectors;

import Polyfill.PFArray;
import Polyfill.StringHelper;

public class VirtualHoaDon extends AnyId {
    public VirtualHoaDon(int id, Reader creator) {
        super(id);
        this.creator = creator;
    }

    public PFArray<Document> getBorrows() {
        return borrows;
    }

    public boolean addBorrows(Document document) {
        if (!document.borrowable()) {
            return false;
        }
        borrows.push_back(document);
        return true;
    }

    protected VirtualHoaDon setBorrows(PFArray<Document> borrows) {
        this.borrows = borrows;
        return this;
    }

    public Reader getCreator() {
        return creator;
    }

    public String toString() {
        return StringHelper.liner(super.toString(),
                StringHelper.itemer("Creator", creator),
                StringHelper.itemer("Borrows",
                        borrows.stream().map(Object::toString).collect(Collectors.joining("\n"))));
    }

    private Reader creator;
    private PFArray<Document> borrows = new PFArray<>();//Danh sách tài liệu mượn
}

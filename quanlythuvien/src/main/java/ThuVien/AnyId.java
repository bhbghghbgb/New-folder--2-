package ThuVien;

import Polyfill.StringHelper;

public abstract class AnyId implements Comparable<AnyId> {
    public int getId() {
        return id;
    }

    public AnyId(int id) {
        this.id = id;
    }

    @Override
    public int compareTo(AnyId e) {
        return Integer.compare(id, e.getId());
    }//compare: so sánh 2 số ( returns the value zero if (x==y), if (x < y) then it returns a value less than zero and
//if (x > y) then it returns a value greater than zero.)

    @Override
    public String toString() {
        return StringHelper.itemer("ID", id);
    }

    public abstract String toStringMinified();

    private int id;
}

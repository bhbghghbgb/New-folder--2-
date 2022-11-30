package ThuVien;

import Polyfill.KhoangThoiGian;
import Polyfill.StringHelper;
import Polyfill.ThoiGian;

public class Card extends AnyId implements IDataProcess<Card> {
    public Card(int id) {
        this(id, ThoiGian.now());
    }

    protected Card(int id, ThoiGian tg) {
        super(id);
        creation = expiration = tg;
    }

    public float getPrice_multiplier() {
        return price_multiplier;
    }

    protected Card setPrice_multiplier(float price_multiplier) {
        this.price_multiplier = price_multiplier;
        return this;
    }

    public ThoiGian getCreation() {
        return creation;
    }

    public ThoiGian getExpiration() {
        return expiration;
    }

    public Reader getReader() {
        return reader;
    }

    public Card setReader(Reader reader) {
        this.reader = reader;
        return this;
    }



    public Card extendExpiration(KhoangThoiGian ktg) {
        expiration = expiration.plusKhoangThoiGian(ktg);
        return this;
    }

    protected Card setExpiration(ThoiGian tg) {
        expiration = tg;
        return this;
    }

    public String[] toBlob() {
        return new String[] { String.valueOf(getId()), getCreation().toString(), getExpiration().toString(),
                String.valueOf(price_multiplier) };
    }

    public static Card fromBlob(String[] inp) {
        int id = Integer.parseInt(inp[0]);
        ThoiGian creation = ThoiGian.parseTG(inp[1]);
        ThoiGian expiration = ThoiGian.parseTG(inp[2]);
        float price_multiplier = Float.parseFloat(inp[3]);
        int id_reader = Integer.parseInt(inp[4]);
        String name_reader = inp[5];
        Reader reader = new Reader(id_reader, name_reader);
        return new Card(id, creation).setExpiration(expiration).setPrice_multiplier(price_multiplier).setReader(reader);
    }

    public String toString() {
        return StringHelper.liner(super.toString(),
                StringHelper.itemer("Price multiplier", price_multiplier),
                StringHelper.itemer("Creation", creation),
                StringHelper.itemer("Expiration", expiration))
                + reader.toString();
    }

    private float price_multiplier = 1.f;
    private ThoiGian creation, expiration;
    private Reader reader;
}

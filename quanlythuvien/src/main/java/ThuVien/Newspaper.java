package ThuVien;

import java.util.logging.Logger;
import java.util.stream.Stream;

import Polyfill.StringHelper;
import Polyfill.ThoiGian;

public class Newspaper extends Document {
    private static final Logger LOGGER = Logger.getLogger(Newspaper.class.getName());

    public Newspaper(int id) {
        super(id);
    }

    public String getEditorial() {
        return editorial;
    }

    public Newspaper setEditorial(String editorial) {
        this.editorial = editorial;
        return this;
    }

    public static Newspaper input() {
        // TODO:
        return null;
    }

    public String[] toBlob() {
        return new String[] { String.valueOf(Documents.Type.MAGAZINE), String.valueOf(getId()), getName(),
                StringHelper.lv1Join((Object) getAuthors()), getEditorial(), getPublication().toString(),
                String.valueOf(getCopies()), String.valueOf(getBorrowed()) };
    }

    public static Newspaper fromBlob(String[] inp) {
        int type = Integer.parseInt(inp[0]);
        if (type != Documents.Type.MAGAZINE) {
            LOGGER.severe(
                    String.format("Incorrect Document Blob type, got %d, expected %d", type, Documents.Type.MAGAZINE));
            throw new IllegalArgumentException("Incorrect Document type");
        }
        int id = Integer.parseInt(inp[1]);
        String name = inp[2];
        //Dùng stream of để trả về một gt stream (id tác giả)
        // r sau đó map với authors, trả về một array author
        Author[] authors = Stream.of(StringHelper.lv1Split(inp[3]))
                .map(e -> Global.authors.getById(Integer.parseInt(e))).toArray(Author[]::new);
        String editorial = inp[4];
        ThoiGian publication = ThoiGian.parseTG(inp[5]);
        int copies = Integer.parseInt(inp[6]);
        int borrowed = Integer.parseInt(inp[7]);
        Newspaper __ = new Newspaper(id).setEditorial(editorial);
        __.setName(name).setAuthors(authors).setPublication(publication).setCopies(copies).setBorrowed(borrowed);
        return __;
    }

    private String editorial;

}

package ThuVien;

import java.util.logging.Logger;
import java.util.stream.Stream;

import Polyfill.StringHelper;
import Polyfill.ThoiGian;

public class ForeignNontranslatedBook extends ForeignBook {
    private static final Logger LOGGER = Logger.getLogger(NativeBook.class.getName());

    public ForeignNontranslatedBook(int id) {
        super(id);
    }

    public String[] toBlob() {
        return new String[] { String.valueOf(Documents.Type.FOREIGN_NONTRANSLATED_BOOK), String.valueOf(getId()),
                getName(), StringHelper.lv1Join((Object) getAuthors()), getPublisher(), getOriginLanguage().toString(),
                getPublication().toString(), getOriginPublication().toString(), String.valueOf(getCopies()),
                String.valueOf(getBorrowed()) };
    }

    public static ForeignNontranslatedBook fromBlob(String[] inp, Authors authors_instance) {
        int type = Integer.parseInt(inp[0]);
        if (type != Documents.Type.FOREIGN_NONTRANSLATED_BOOK) {
            LOGGER.severe(
                    String.format("Incorrect Document Blob type, got {}, expected {}", type,
                            Documents.Type.FOREIGN_NONTRANSLATED_BOOK));
            throw new IllegalArgumentException("Incorrect Document type");
        }
        int id = Integer.parseInt(inp[1]);
        String name = inp[2];
        Author[] authors = Stream.of(StringHelper.lv1Split(inp[3]))
                .map(e -> authors_instance.getById(Integer.parseInt(e))).toArray(Author[]::new);
        String publisher = inp[4];
        Language originLanguage = Languages.parseLang(inp[5]);
        ThoiGian publication = ThoiGian.parseTG(inp[6]);
        ThoiGian originPublication = ThoiGian.parseTG(inp[7]);
        int copies = Integer.parseInt(inp[8]);
        int borrowed = Integer.parseInt(inp[9]);
        ForeignNontranslatedBook __ = new ForeignNontranslatedBook(id);
        __.setOriginLanguage(originLanguage).setOriginPublication(originPublication).setPublication(publication);
        __.setPublisher(publisher);
        __.setName(name).setAuthors(authors).setPublication(publication).setCopies(copies).setBorrowed(borrowed);
        return __;
    }
}
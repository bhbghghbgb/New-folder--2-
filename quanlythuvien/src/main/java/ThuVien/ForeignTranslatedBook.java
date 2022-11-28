package ThuVien;

import java.util.logging.Logger;
import java.util.stream.Stream;

import Polyfill.StringHelper;
import Polyfill.ThoiGian;

public class ForeignTranslatedBook extends ForeignBook {
    private static final Logger LOGGER = Logger.getLogger(ForeignTranslatedBook.class.getName());

    public ForeignTranslatedBook(int id) {
        super(id);
    }

    public Language getTranslatedLanguage() {
        return translatedLanguage;
    }

    protected ForeignTranslatedBook setTranslatedLanguage(Language translatedLanguage) {
        this.translatedLanguage = translatedLanguage;
        return this;
    }

    public String getTranslator() {
        return translator;
    }

    protected ForeignTranslatedBook setTranslator(String translator) {
        this.translator = translator;
        return this;
    }
    public static ForeignTranslatedBook input() {
        // TODO:
    }
    public String[] toBlob() {
        return new String[] { String.valueOf(Documents.Type.FOREIGN_TRANSLATED_BOOK), String.valueOf(getId()),
                getName(), StringHelper.lv1Join((Object) getAuthors()), getPublisher(), getOriginLanguage().toString(),
                getTranslatedLanguage().toString(), getTranslator(), getPublication().toString(),
                getOriginPublication().toString(), String.valueOf(getCopies()), String.valueOf(getBorrowed()) };
    }

    public static ForeignTranslatedBook fromBlob(String[] inp, Authors authors_instance) {
        int type = Integer.parseInt(inp[0]);
        if (type != Documents.Type.FOREIGN_TRANSLATED_BOOK) {
            LOGGER.severe(
                    String.format("Incorrect Document Blob type, got %d, expected %d", type,
                            Documents.Type.FOREIGN_TRANSLATED_BOOK));
            throw new IllegalArgumentException("Incorrect Document type");
        }
        int id = Integer.parseInt(inp[1]);
        String name = inp[2];
        Author[] authors = Stream.of(StringHelper.lv1Split(inp[3]))
                .map(e -> authors_instance.getById(Integer.parseInt(e))).toArray(Author[]::new);
        String publisher = inp[4];
        Language originLanguage = Languages.parseLang(inp[5]);
        Language translatedLanguage = Languages.parseLang(inp[6]);
        String translator = inp[7];
        ThoiGian publication = ThoiGian.parseTG(inp[8]);
        ThoiGian originPublication = ThoiGian.parseTG(inp[9]);
        int copies = Integer.parseInt(inp[10]);
        int borrowed = Integer.parseInt(inp[11]);
        ForeignTranslatedBook __ = new ForeignTranslatedBook(id).setTranslatedLanguage(translatedLanguage)
                .setTranslator(translator);
        __.setOriginLanguage(originLanguage).setOriginPublication(originPublication).setPublication(publication);
        __.setPublisher(publisher);
        __.setName(name).setAuthors(authors).setPublication(publication).setCopies(copies).setBorrowed(borrowed);
        return __;
    }

    private Language translatedLanguage;
    private String translator;

}

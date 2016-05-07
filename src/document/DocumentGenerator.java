package document;

import java.io.OutputStream;

/**
 * Created by Антон on 06.05.2016.
 */
public interface DocumentGenerator {
    public abstract void generatePriceList(OutputStream outputStream);
    public abstract void generateListOfStudents(OutputStream outputStream);
    public abstract void generateCertificate(OutputStream outputStream);
    public abstract void generateRecommendation(OutputStream outputStream);
    public abstract void generateListOfLecturers(OutputStream outputStream);
}

package action.document;

import com.opensymphony.xwork2.ActionSupport;
import document.PDFGenerator;

/**
 * Created by Антон on 04.05.2016.
 */
public class GeneratePdfAction extends ActionSupport{

    public String generatePriceList(){
        PDFGenerator generator = PDFGenerator.getInstance();
        generator.generatePriceList();
        return SUCCESS;
    }


    public String generateListOfStudents() {
        return SUCCESS;
    }


    public String generateCertificate() {
        return SUCCESS;
    }

    public String generateRecommendation() {
        return SUCCESS;
    }

    public String generateListOfLecturers() {
        return SUCCESS;
    }
}

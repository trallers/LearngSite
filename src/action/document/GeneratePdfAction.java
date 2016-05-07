package action.document;

import com.opensymphony.xwork2.ActionSupport;
import document.PDFGenerator;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;

/**
 * Created by Антон on 04.05.2016.
 */
public class GeneratePdfAction extends ActionSupport{

    public String generatePriceList() throws IOException {
        HttpServletRequest request = ServletActionContext.getRequest();
        HttpServletResponse response = ServletActionContext.getResponse();
        String fileName = URLEncoder.encode("PriceList.pdf", "UTF-8");
        response.setContentType("application/pdf");
        response.setHeader("Content-Disposition", "attachment;filename=" + fileName);
        PDFGenerator generator = PDFGenerator.getInstance();
        generator.generatePriceList(response.getOutputStream());
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

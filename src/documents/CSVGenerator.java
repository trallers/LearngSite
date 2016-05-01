package documents;

import com.opensymphony.xwork2.ActionSupport;
import util.DBUtil;

import java.io.FileWriter;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CSVGenerator  extends ActionSupport {
    private static final String getColumnsNames = "SELECT * FROM ";

    private String path;
    private String tableName;

    public void setPath(String _path){
        this.path = _path;
    }

    public void setTableName(String _tableName){
        this.tableName = _tableName;
    }

    public String generate(){
       return generate(path, tableName);
    }

    public String generate(String path, String tableName) {
        try {
            FileWriter writer = new FileWriter(path);

            PreparedStatement statements = DBUtil.getConnection().prepareStatement(getColumnsNames + tableName);
            ResultSet rs = statements.executeQuery();
            for(int i = 1; i <= rs.getMetaData().getColumnCount(); i++){
                writer.append(rs.getMetaData().getColumnName(i));
                if(i != rs.getMetaData().getColumnCount())
                    writer.append(";");
            }
            writer.append("\n");
            while(rs.next()){
                for(int i = 1; i <= rs.getMetaData().getColumnCount(); i++){
                    writer.append(rs.getString(i));
                    if(i != rs.getMetaData().getColumnCount())
                        writer.append(";");
                }
                writer.append("\n");
            }
            writer.flush();
            writer.close();
            return SUCCESS;
        } catch (IOException e) {
            //
            return ERROR;
        } catch (SQLException e) {
            //
            return ERROR;
        }
    }
}

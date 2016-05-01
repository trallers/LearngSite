package documents;

import util.DBUtil;

import java.io.FileWriter;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CSVGenerator {
    private static FileWriter writer;
    private static final String getColumnsNames = "SELECT * FROM ";

    public static boolean generate(String path, String tableName) {
        try {
            writer = new FileWriter(path);

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
            return true;
        } catch (IOException e) {
            //
            return false;
        } catch (SQLException e) {
            //
            return false;
        }
    }
}

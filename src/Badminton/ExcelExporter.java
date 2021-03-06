package Badminton;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JTable;
import javax.swing.table.TableModel;

public class ExcelExporter  
{
    public ExcelExporter() { }
    
    public void exportTable(JTable table, File file) throws IOException 
    {  
        TableModel model = table.getModel();          
        BufferedWriter bWriter = new BufferedWriter(new FileWriter(file,true));    
        
        //获取表格的列名称
        for(int i=0; i < model.getColumnCount(); i++) 
        {  
            bWriter.write(""+ table.getColumnModel().getColumn(i).getHeaderValue());  
            bWriter.write("\t");  
        } 
        
        bWriter.newLine(); 
        
        //获取表格内容
        for(int i=0; i< model.getRowCount(); i++) 
        {  
            for(int j=0; j < model.getColumnCount(); j++) 
            {  
                bWriter.write(""+model.getValueAt(i,j));  
                bWriter.write("\t");  
            }  
            bWriter.newLine();            
        } 
        bWriter.newLine(); 
        bWriter.close();  
        System.out.println("write out to: " + file);  
    }  
}

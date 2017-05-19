package softwarepulse.app.dialog;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.SQLException;

import softwarepulse.app.dialog.BusinessInfo;


public class FileWriterHtml {

	public static String str = "";
	String html = "";
	
	String dirName = "Invoices";
	File dir = new File (dirName);
	File f = new File(dirName, "test.html");
	
	public FileWriterHtml(File f) throws IOException {	
		super();	
		this.f = f;
	}
	
	public static String PrintTableData() {
		
		String result = "<tbody>";
		
		int numCols = Table.getColumnCount();
		for (int row = 0; row < NewInvoice.rowCtr; row++) {
			result += "<tr>";
			for (int col = 0; col < numCols; col++) {
				Object value = "";
				 value = Table.rowData[row][col];	
				 result += "<td>" + value +"</td>";
			}
			result += "</tr>";
		}
		result += "</tbody>";
		return  result;
	}
	
	public static void writeFile() throws IOException {	
		
		String newData = PrintTableData();
		
		try {
			BusinessInfo.populatebusinessInfo();
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		File f = new File("test.html");
		
		String html = "";
		
		html = "<html><head><title></title>";
		
		html += "<link rel=" + "stylesheet" + " " + "href=" + "\"" + "styles.css"+ "\"" + ">" + "</head>";
		
		html += "<body>";
		
		html += "<section id=" + "\"" + "ct1" + "\"" + ">";
		
		html += " <section id="  + "\"" + "sec1"  + "\"" + ">" + "<div id=" + "\"" + "title" + "\"" + ">" + "<h1>Invoice</h1></div></section>";
		
		html += "<section id=" + "\"" + "sec2" + "\"" + ">" + "<div id=" + "\"" + "BusinessInfo" + "\"" + ">" ;	
		
		html += "<h6>" + BusinessInfo.businessName + "</h6>" + "<h6>" + BusinessInfo.businessAddress + "</h6>" + "<h6>" + BusinessInfo.businessCityAndState + "</h6>" + "<h6>" + BusinessInfo.businessPhoneNumber + "</h6>" + "</div>";

		html += " <div id=" + "\"" + "InvoiceMetadata" + "\"" + ">" + "<h6>Date: </h6>" + "<h6>Invoice No:</h6>" + "<h6>Customer PO: " + NewInvoice.Cust_PO + "</h6>" + "<h6>No: </h6>" + "</div>"+ "</section>";
		 
		html += "<section id=" + "\"" + "sec3" + "\"" + ">" + "<div id=" + "\"" + "billTo" + "\"" + ">" + "<h6>Bill TO: </h6>" + "<h6>" + NewInvoice.customerName + "</h6>" + " </div>" + "<div id=" + "\"" + "shipTo" + "\"" + ">";
		
		html += "<h6>Ship To: </h6>" + "<h6>Shipping Address</h6>" + "</div>" + "</section>"; 
		// start of table 
		html += "<section id=" + "\"" + "sec4" + "\"" + ">" + "<table id=" + "\"" + "table-example-1" + "\"" + ">" + "<thead>"  + "<tr>" + "<th  id=" + "\"" +"th1" + "\"" + "rowspan=" + "\"" + "2" + "\"" + ">Qty</th>";
		
		html += "<th  id=" + "\"" + "th2" + "\"" + "rowspan=" + "\"" + "2" + "\"" + ">Item</th><th  id=" + "\"" + "th3" + "\"" + " rowspan=" + "\"" + "4" + "\"" + " >Description</th>" + "<th rowspan=" + "\"" + "2" + "\"" + ">Unit Price</th><th rowspan=" + "\"" + "2" + "\"" + 
		         " >Discount</th><th rowspan=" + "\"" + "2" + "\"" + ">Tax</th><th rowspan=" + "\"" + "2" + "\"" + ">Total</th>";
		// start of row data
		html += "</tr></thead>";
		
		html += newData;
		
		html += "</table>"+ "<section id=" + "\"" +  "sec5" + "\"" + ">" ;
		
		html += " <div id=" + "\"" + "total"  + "\"" + ">" + "<h6>Total</h6>" + "<h6>" + NewInvoice.InvoiceTotal + "</h6>" +  " </div>"  +  "</section></section></section></body></html>";
		
		BufferedWriter bw = null;
		try {
			bw = new BufferedWriter(new FileWriter(f));
		} catch (IOException e) {
			e.printStackTrace();
		}
		bw.write(html);
		bw.close();		
	}	
}

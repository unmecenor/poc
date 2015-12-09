package com.guilloux.poc.test.rgconseil;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class AuditCpaWriter {

	public void write(List<Invoice2GoReceipt> list) {
		// InputStream inp = new FileInputStream();
		int indexNote = 13;
		String noteDeFraisFile = "\\\\NAS-RGC/drive/richard.guilloux/AUDIT CPA/NOTE-DE-FRAIS/NOTE-DE-FRAIS-" + indexNote
				+ ".xlsx";
		try (InputStream inp = getClass().getResourceAsStream("TEMPLATE-NOTE-DE-FRAIS.xlsx");
				FileOutputStream fileOut = new FileOutputStream(noteDeFraisFile)) {

			Workbook wb = WorkbookFactory.create(inp);
			Sheet sheet = wb.getSheetAt(0);
			Date from = null;
			Date to = null;
			for (int i = 0; i < list.size(); i++) {
				Invoice2GoReceipt receipt = list.get(i);
				Row row = sheet.getRow(i + 10);
				if (from == null || receipt.getDate().before(from)) {
					from = receipt.getDate();
				}
				if (to == null || receipt.getDate().after(to)) {
					to = receipt.getDate();
				}
				row.getCell(1).setCellValue(receipt.getDate());
				StringBuilder description = new StringBuilder(receipt.getSupplier());
				if (StringUtils.isNotBlank(receipt.getDescription())) {
					description.append(" - ");
					description.append(receipt.getDescription());
				}
				row.getCell(2).setCellValue(description.toString());
				double ht = receipt.getTotal() - receipt.getTva();
				switch (receipt.getCategory()) {
				case "Nourriture et boissons":
					row.getCell(6).setCellValue(ht);
					break;
				case "Transports":
					row.getCell(4).setCellValue(ht);
					break;
				case "Telephone + Internet":
					row.getCell(7).setCellValue(ht);
					break;
				case "Fournitures de bureau":
					row.getCell(8).setCellValue(ht);
					break;
				case "Logement":
					row.getCell(9).setCellValue(ht);
					break;

				default:
					break;
				}
				row.getCell(10).setCellValue(receipt.getTva());
				row.getCell(11).setCellValue(receipt.getTotal());

			}

			sheet.getRow(3).getCell(11).setCellValue(from);
			sheet.getRow(4).getCell(11).setCellValue(to);
			sheet.getRow(3).getCell(6).setCellValue(indexNote);

			// Write the output to a file
			wb.write(fileOut);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InvalidFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void main(String[] args) {
		List<Invoice2GoReceipt> list = new Invoice2GoReader().readCsv("C:/Users/user/Downloads/expensesReport.CSV");
		new AuditCpaWriter().write(list);
		System.out.println("terminé");
	}

}

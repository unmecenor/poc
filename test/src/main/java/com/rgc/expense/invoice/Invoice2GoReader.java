package com.rgc.expense.invoice;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.google.common.collect.Lists;

public class Invoice2GoReader {

	public List<Invoice2GoReceipt> readCsv(String file){
		List<Invoice2GoReceipt> list = Lists.newArrayList();
		try (BufferedReader br = new BufferedReader(new FileReader(file)))
		{
			SimpleDateFormat dateFormat = new SimpleDateFormat("d MMM yyyy");
			
			
			Invoice2GoReceipt receipt;
 			String line = br.readLine();
 			while((line=br.readLine())!=null){
 				String[] result = line.split("\"");
 				receipt = new Invoice2GoReceipt();
 				receipt.setDate(dateFormat.parse(result[1]));
 				receipt.setCategory(result[3]);
 				receipt.setSupplier(result[5]);
 				receipt.setDescription(result[7]);
 				receipt.setTva(Double.valueOf(result[9].replace(",", ".")));
 				receipt.setTotal(Double.valueOf(result[13].replace(",", ".")));
 				list.add(receipt);
 			}

		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		Collections.sort(list, new Comparator<Invoice2GoReceipt>() {
			@Override
			public int compare(Invoice2GoReceipt o1, Invoice2GoReceipt o2) {
				return o1.getDate().compareTo(o2.getDate());
			}
		});
		return list;
	}
	
	
//	public static void main(String[] args) {
//		new Invoice2GoReader().readCsv("C:/Users/user/Downloads/expensesReport.CSV");
//		System.out.println(Double.valueOf("0.88"));
//				
//		//SimpleDateFormat dateFormat = new SimpleDateFormat("d MMM yyyy");
//		SimpleDateFormat dateFormat = new SimpleDateFormat("d MMM yyyy");
//		try {
//			//System.out.println(dateFormat.parse("2 Oct 2014"));
//			System.out.println(Locale.getDefault());
//			System.out.println(dateFormat.format(new Date()));
//			System.out.println(dateFormat.parse("9 déc. 2014"));
//		} catch (ParseException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//	}
}

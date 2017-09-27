package com.rgc.expense.invoice;

import java.io.BufferedReader;
import java.io.FileReader;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;

import com.google.common.collect.Lists;

public class Invoice2GoReader {

	public List<Invoice2GoReceipt> readCsv(String file) {
		List<Invoice2GoReceipt> list = Lists.newArrayList();
		String line = null;
		try (BufferedReader br = new BufferedReader(new FileReader(file))) {
			SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yy", Locale.US);

			Invoice2GoReceipt receipt;
			line = br.readLine();
			while ((line = br.readLine()) != null) {
				String[] result = line.split(";");
				receipt = new Invoice2GoReceipt();
				receipt.setDate(dateFormat.parse(result[0]));
				receipt.setCategory(result[1]);
				receipt.setSupplier(result[2]);
				receipt.setDescription(result[3]);
				receipt.setTva(Double.valueOf(result[4].replace(",", ".")));
				Double total = Double.valueOf(result[6].replace(",", "."));
				if (!Double.valueOf(0).equals(total)) {
					receipt.setTotal(Double.valueOf(result[6].replace(",", ".")));
					list.add(receipt);
				}
			}

		} catch (Exception e) {
			System.out.println(line);
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

	// public static void main(String[] args) {
	// new
	// Invoice2GoReader().readCsv("C:/Users/user/Downloads/expensesReport.CSV");
	// System.out.println(Double.valueOf("0.88"));
	//
	// //SimpleDateFormat dateFormat = new SimpleDateFormat("d MMM yyyy");
	// SimpleDateFormat dateFormat = new SimpleDateFormat("d MMM yyyy");
	// try {
	// //System.out.println(dateFormat.parse("2 Oct 2014"));
	// System.out.println(Locale.getDefault());
	// System.out.println(dateFormat.format(new Date()));
	// System.out.println(dateFormat.parse("9 déc. 2014"));
	// } catch (ParseException e) {
	// // TODO Auto-generated catch block
	// e.printStackTrace();
	// }
	//
	// }
}

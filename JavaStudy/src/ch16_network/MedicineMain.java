package ch16_network;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
//import java.util.Scanner;

public class MedicineMain {
	public static void main(String[] args) throws IOException {
		String path = System.getProperty("user.dir");
		String txtPath = path + "\\src\\files\\medicine.txt";

		BufferedReader buffReader = new BufferedReader(new FileReader(txtPath));

		ArrayList<Medicine> mediList = new ArrayList<>();

		while (true) {
			String line = buffReader.readLine();

			if (line == null || line.isEmpty()) {
				break;
			}

			String[] mediArray = line.split("\\|");

			Medicine medicine = new Medicine();

			medicine.setItemSeq(mediArray[0]);
			medicine.setEntpName(mediArray[1]);
			medicine.setItemName(mediArray[2]);
			medicine.setEfcyQesitm(mediArray[3]);

			mediList.add(medicine);
		}
		buffReader.close();

//		Scanner scan = new Scanner(System.in);
//		System.out.print("증상 입력 : ");
//		String answer = scan.nextLine();
//		
//		ArrayList<Medicine> myList = new ArrayList<>();
//		for(Medicine m : mediList) {
//			if(m.getEfcyQesitm().contains(answer)) {
//				myList.add(m);
//			}
//		}
//		if(myList.size()==0) {
//			System.out.println("해당 증상에 맞는 의약품이 존재하지 않습니다.");
//		}else {
//			System.out.println("의약품 목록 ======\n");
//			for(Medicine m: myList) {
//				System.out.println(m.getEntpName()+" | "+m.getItemName());
//			}
//			System.out.println("\n==================");
//		}
//		scan.close();

		HashMap<String, Integer> numOfMedicine = new HashMap<>();
		for (Medicine m : mediList) {
			numOfMedicine.put(m.getEntpName(), 0);
		}

		for (Medicine m : mediList) {
			int n = numOfMedicine.get(m.getEntpName());
			n++;
			numOfMedicine.put(m.getEntpName(), n);
		}

		ArrayList<String> keySet = new ArrayList<>(numOfMedicine.keySet());

		keySet.sort((o1, o2) -> numOfMedicine.get(o2).compareTo(numOfMedicine.get(o1)));

		int rank = 1;
		for (String key : keySet) {
			System.out.println(rank + ". " + key + " " + numOfMedicine.get(key) + "개");
			rank++;
		}

	}
}
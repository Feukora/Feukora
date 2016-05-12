package projekt.feukora.server.persister;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import javax.persistence.EntityManager;

import projekt.feukora.server.model.Town;

public class TownData {

	public static void loadTownData(String fileName) {

		File file = new File(fileName);

		if (!file.canRead() || !file.isFile())
			System.exit(0);

		BufferedReader in = null;
		try {
			TownPersister p = new TownPersisterImpl();
			in = new BufferedReader(new FileReader(fileName));
			
			String zeile = null;
			while ((zeile = in.readLine()) != null) {
				String[] splited = zeile.split("\t");
				Town t = new Town();
				int zip = Integer.parseInt(splited[0]);
				String name = splited[1];
				t.setzip(zip);;
				t.setName(name);
				
				try {
					p.saveTown(t);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (in != null)
				try {
					in.close();
				} catch (IOException e) {
				}
		}
	}

}

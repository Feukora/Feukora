package projekt.feukora.server.persister;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.apache.log4j.Logger;

import projekt.feukora.server.model.Town;

/**
 * This class includes Town data
 * @version 1.5
 * @author Sandro
 */

public class TownData {

	private static final Logger logger = Logger
			.getLogger(TownData.class);

	public static void loadTownData() {

		BufferedReader in = null;
		try {
			TownPersister p = new TownPersisterImpl();

			InputStream is = TownData.class.getClass().getResourceAsStream("/ZIP.txt");

			in = new BufferedReader(new InputStreamReader( is ));

			String zeile = null;
			while ((zeile = in.readLine()) != null) {
				String[] splited = zeile.split("\t");
				Town t = new Town();
				int zip = Integer.parseInt(splited[0]);
				String name = splited[1];
				t.setZip(zip);;
				t.setName(name);

				try {
					p.saveTown(t);
				} catch (Exception e) {
					logger.error("Aktion konnte nicht durchgeführt werden ",
							e);
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
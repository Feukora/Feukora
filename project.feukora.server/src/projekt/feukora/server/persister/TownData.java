package projekt.feukora.server.persister;
import java.io.BufferedReader; 
import java.io.File; 
import java.io.FileReader; 
import java.io.IOException;

import javax.persistence.EntityManager;


public class TownData {
  

	    public static void loadTownData(String fileName) { 
	    	
	        File file = new File(fileName); 

	        if (!file.canRead() || !file.isFile()) 
	            System.exit(0); 

	            BufferedReader in = null; 
	        try { 
	            in = new BufferedReader(new FileReader(fileName)); 
	            
	            String zeile = null; 
	            while ((zeile = in.readLine()) != null) { 
	                String[] splited = zeile.split("\t");
	                	EntityManager em = JpaUtil.createEntityManager();
	                	
	                	em.getTransaction().begin();
	                	em.createNativeQuery("INSERT INTO Town VALUES " + splited[0] + ", " + splited[1]);
	                	em.getTransaction().commit();
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

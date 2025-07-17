package excersises.chapter10.meldeamt;

import java.io.*;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class CitizenListOperations {

    private static final String CITIZEN_LIST_FILE_PATH = System.getProperty("user.dir") + File.separator + "EinwohnerListe.dat";

    private static Set<Citizen> citizenSet = new TreeSet<>();

    private static Citizen findCitizenByName(String lastName, String firstName){
        Citizen citizen;

        Iterator<Citizen> i = citizenSet.iterator();
        while(i.hasNext()){
            citizen = i.next();
            if((lastName.equals(citizen.getLastName()) &&
                    firstName.equals(citizen.getFirstName()))){
                return citizen;
            }
        }

        return null;
    }

    public static boolean addNewCitizen(String lastName, String firstName, String birthLastName, String email, Title title, MaritalStatus maritalStatus){
        Citizen citizen = new Citizen(lastName, firstName, birthLastName, email, title, maritalStatus);
        boolean result = citizenSet.add(citizen);
        return result;
    }

    public static boolean showCitizen(String lastName, String firstName){
        Citizen citizen = findCitizenByName(lastName, firstName);

        if(citizen == null){
            return false;
        }else{
            System.out.println(citizen);
            return true;
        }
    }

    public static boolean searchCitizenByName(String lastName, String firstName){
        Citizen citizen = findCitizenByName(lastName, firstName);
        return citizen != null;
    }

    public static boolean deleteCitizenByName(String lastName, String firstName){
        Citizen citizen = findCitizenByName(lastName, firstName);

        if(citizen == null){
            return false;
        }else{
            citizenSet.remove(citizen);
            return true;
        }
    }

    public static void printCitizenList(){
        if(citizenSet.size() > 0){
            System.out.println("Einwohner:");

            for(Citizen citizen : citizenSet){
                System.out.println(citizen);
            }
        }else{
            System.out.println("Die Liste ist leer!");
        }
    }

    protected static void saveCitizenDataToFile(){

        File citizenDataFile = new File(CITIZEN_LIST_FILE_PATH);

        if(!citizenDataFile.exists()){
            try{
                citizenDataFile.createNewFile();
            }catch(IOException e){
                System.out.println("Datei: " + citizenDataFile.getName() + " konnte nicht erstellt werden.");
                return;
            }
        }

        try(FileOutputStream citizenDateFileOutputStream = new FileOutputStream(citizenDataFile);
            ObjectOutputStream citizenObjectStream = new ObjectOutputStream(citizenDateFileOutputStream)){

            citizenObjectStream.writeObject(citizenSet);

        } catch(IOException e){
            System.out.println("Fehler beim schreiben der Einwohnerdaten.");
            return;
        }

        System.out.println(citizenSet.size() + " Einwohner in " + citizenDataFile.getPath() + " gespeichert.");
    }

    protected static void loadCitizenDataFromFile(){

        File citizenDataFile = new File(CITIZEN_LIST_FILE_PATH);

        if(!citizenDataFile.exists()){
            System.out.println("Keine Einwohner-Datei gefunden.");
            return;
        }

        try(FileInputStream citizenDataFileInputStream = new FileInputStream(citizenDataFile);
            ObjectInputStream citizenDataObjectInputStream = new ObjectInputStream(citizenDataFileInputStream)){

            citizenSet = (Set<Citizen>)citizenDataObjectInputStream.readObject();
            System.out.println(citizenSet.size() + " Einwohner von " + citizenDataFile.getPath() + " geladen.");

        }catch(Exception e){
            System.out.println("Fehler beim lesen der Datei " + citizenDataFile.getName());
        }

    }
}

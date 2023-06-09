package oskar.vetservice.startup;

import oskar.vetservice.Application;

import java.io.*;

public class StartupData {
    private int nextPhotoId;
    private static String FILE_NAME = "startupfiles/startup_data.txt";
    private static StartupData instance = new StartupData();

    private StartupData(){
    };
    public static StartupData getInstance(){return instance;}

    public boolean readStartupData(){
        try {
            BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME));
            nextPhotoId = Integer.parseInt(reader.readLine());
            reader.close();
            return true;
        } catch (FileNotFoundException e) {
            // File doesn't exist, initialize with default values
            nextPhotoId = 1;
            return true;
        } catch (IOException e) {
            System.out.println("Couldn't open startup file: " + e.getMessage());
            return false;
        }
    }

    public void saveStartupData() {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME));
            writer.write(Integer.toString(nextPhotoId));
            writer.close();
        } catch (IOException e) {
            System.out.println("Couldn't save startup file: " + e.getMessage());
        }
    }

    public int getNextPhotoId() {
        return nextPhotoId++;
    }

}

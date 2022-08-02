package workWithFiles.serialization;

import java.io.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class GameProgress implements Serializable {
    private static final long serialVersionUID = 1L;

    private int health;
    private int weapons;
    private int lvl;
    private double distance;

    public GameProgress(int health, int weapons, int lvl, double distance) {
        this.health = health;
        this.weapons = weapons;
        this.lvl = lvl;
        this.distance = distance;
    }

    @Override
    public String toString() {
        return "GameProgress{" +
                "health=" + health +
                ", weapons=" + weapons +
                ", lvl=" + lvl +
                ", distance=" + distance +
                '}';
    }

    public static void saveGame(String path, GameProgress gameProgress) {
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(path))) {
            outputStream.writeObject(gameProgress);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void zipFiles(String zipPath, String... path) {
        for (int i = 0; i < path.length; i++) {
            try (ZipOutputStream zipOutputStream = new ZipOutputStream(
                    new FileOutputStream(zipPath+"/zip"+(i+1)+".zip"));
                 FileInputStream fileInputStream = new FileInputStream(path[i])) {
                ZipEntry entry = new ZipEntry(path[i]);
                zipOutputStream.putNextEntry(entry);
                //считываем содержимое файла в  массив byte
                byte[] buffer = new byte[fileInputStream.available()];
                fileInputStream.read(buffer);
                //добавляем содержимое к архиву
                zipOutputStream.write(buffer);
                //закрываем текущую запись
                zipOutputStream.closeEntry();
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }


    }


}

package workWithFiles.serialization;


import java.io.File;

public class Main {
    public static void main(String[] args) {
        GameProgress gameProgress1 = new GameProgress(100, 80, 2, 185.68);
        GameProgress gameProgress2 = new GameProgress(60, 90, 4, 683.86);
        GameProgress gameProgress3 = new GameProgress(30, 195, 3, 483.54);

        String path1 = "/Users/sasha/IdeaProjects/netologyCourse/Games/savegames/save1.dat";
        String path2 = "/Users/sasha/IdeaProjects/netologyCourse/Games/savegames/save2.dat";
        String path3 = "/Users/sasha/IdeaProjects/netologyCourse/Games/savegames/save3.dat";

        GameProgress.saveGame(path1, gameProgress1);
        GameProgress.saveGame(path2, gameProgress2);
        GameProgress.saveGame(path3, gameProgress3);

        String zipPath = "/Users/sasha/IdeaProjects/netologyCourse/Games/savegames";

        GameProgress.zipFiles(zipPath, path1, path2, path3);

        File file1 = new File(path1);
        File file2 = new File(path2);
        File file3 = new File(path3);

        if (file1.delete()) {
            System.out.println("File " + file1.getName() + " was deleted");
        }
        if (file2.delete()) {
            System.out.println("File " + file2.getName() + " was deleted");
        }
        if (file3.delete()) {
            System.out.println("File " + file3.getName() + " was deleted");
        }
    }
}

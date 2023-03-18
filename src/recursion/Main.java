package recursion;

import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        String dir = "Proba";
        String file = "Main.java";
        File f = new File("Proba");
        System.out.println(checkIfExist(file, f, dir));
    }
    private static boolean checkIfExist(String file, File directory, String dir) {
        String[] list = directory.list();
        for (int i = 0; i < list.length; i++) {
            File newFile = new File(dir+"/"+list[i]);
            if(newFile.isDirectory()) {
                if(checkIfExist(file, newFile, dir+"/"+list[i])) {
                    return true;
                }
            }
            else {
                if(list[i].equals(file)) {
                    return true;
                }
            }
        }
        return false;
    }
//    private static void checkIfExist(String file, File directory, String dir) {
//        boolean exist = false;
//        if(exist) {
//            exist = true;
//            System.out.println(exist);
//        }
//        String[] list = directory.list();
//        for (int i = 0; i < list.length; i++) {
//            File newFile = new File(dir+"/"+list[i]);
//            if(newFile.isDirectory()) {
//                checkIfExist(file, newFile, dir+"/"+list[i]);
//            }
//            else {
//                if(list[i].equals(file)) {
//                    exist = true;
//                    System.out.println(exist);
//                    break;
//                }
//            }
//        }
//    }
}
package jav;

import java.nio.file.Path;
import java.nio.file.Paths;

public class TestNioPath {
    public static void main(String[] args) {
        Path listing = Paths.get("C:\\SAPDevelop\\orca_cloud");
        System.out.println("File Name [" + listing.getFileName() + "]");
        System.out.println("Number of Name Elements in the path [" + listing.getNameCount() + "]");
        System.out.println("Parent path [" + listing.getParent() + "]");
        System.out.println("Root of path [" + listing.getRoot() + "]");
        System.out.println("Subpath from root, 2 elements deep [" + listing.subpath(0, 2) + "]");
    }
}
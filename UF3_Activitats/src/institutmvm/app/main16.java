package institutmvm.app;

import institutmvm.utils.MyFile;

public class main16 {

    public static void main(String[] args) {
        int noOfLines = 10000;
        String data = "Afegeixo aquest text";
        MyFile mf = new MyFile();
        mf.writeUsingFileWriter(data);
        mf.writeUsingBufferedWriter(data, noOfLines);
        mf.writeUsingFiles(data);
        mf.writeUsingOutputStream(data);
        System.out.println("Finalitzat");
    }
}

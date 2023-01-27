import java.util.ArrayList;
import org.apache.poi.xwpf.usermodel.*;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.io.IOException;


public class TraceGenerator {

    Reader docreader = new Reader();


    public void TraceGenerate() throws IOException {
        ArrayList<String> testadimvegereksinimno = new ArrayList<String>();

        testadimvegereksinimno = docreader.Reader("C:\\Users\\admin\\Desktop\\excel\\readdoc.docx");
        System.out.println("Dokümandan okunan gereksinimler: " + testadimvegereksinimno);


    }





}

import org.apache.poi.xwpf.usermodel.*;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.io.IOException;


public class Reader<T> {




    ArrayList<String> tumadimlar = new ArrayList<String>();

    ArrayList<ArrayList<String >>  tumgereksinimler= new ArrayList<ArrayList<String>>();

    ArrayList<String > hucredekigereksinimler = new ArrayList<String>();
    ArrayList<ArrayList<String >>  totalread= new ArrayList<ArrayList<String>>();



    int cellindex = 0;


    public ArrayList<ArrayList<String>> Reader(String fileName) throws IOException {

        try (
                XWPFDocument doc = new XWPFDocument(Files.newInputStream(Paths.get(fileName)))) {

            /*XWPFWordExtractor xwpfWordExtractor = new XWPFWordExtractor(doc);
            String docText = xwpfWordExtractor.getText();
            System.out.println(docText);*/

            Iterator<IBodyElement> docElementsIterator = doc.getBodyElementsIterator();

            //Iterate through the list and check for table element type
            while (docElementsIterator.hasNext()) {
                IBodyElement docElement = docElementsIterator.next();

                //element table vs eğerki doc element tablo ise aşağıdaki döngüye gir.

                if ("TABLE".equalsIgnoreCase(docElement.getElementType().name())) {
                    //Get List of table and iterate it


                    List<XWPFTable> xwpfTableList = docElement.getBody().getTables(); // tüm tablolar XWPFTable listinde tutuluyor.
                    for (XWPFTable xwpfTable : xwpfTableList) {
                        System.out.println("Total Rows : " + xwpfTable.getNumberOfRows());
                        for (XWPFTable tbl : doc.getTables()) {

                            int rowindex = 0;
                            for (XWPFTableRow row : tbl.getRows()) {

                                cellindex = 0;

                                for (XWPFTableCell cell : row.getTableCells()) {
                                    cellindex++;

                                    for (XWPFParagraph p : cell.getParagraphs()) {


                                        for (XWPFRun r : p.getRuns()) {

                                            String text = r.getText(0);
                                            if (text != null) {

                                                //System.out.println(cellindex + ". = " + text);


                                                if(cellindex == 1){
                                                    tumadimlar.add(text);
                                                }
                                                if(cellindex == 6){
                                                    hucredekigereksinimler.add(text);
                                                }
                                            }

                                        }



                                }

                                }
                               System.out.println("Hücredeki Gereksinimler: "+hucredekigereksinimler);
                                tumgereksinimler.add(new ArrayList<String>(hucredekigereksinimler));
                                //tumgereksinimler.add(hucredekigereksinimler);
                                hucredekigereksinimler.clear();


                            }
                        }
                    }
                }
            }
        }
        //testadimvegereksinim.add(String.valueOf(gereksinimno));
        //System.out.println("TEST ADIMLARI"+tumadimlar);

        //System.out.println("GEREKSİNİMLER"+ tumgereksinimler);


        totalread.add(tumadimlar);
        //System.out.println(tumgereksinimler.get(0));



        for(int i = 0;  i<Integer.parseInt(String.valueOf(tumgereksinimler.size())); i++)
        {
            totalread.add(tumgereksinimler.get(i));


        }

       return totalread;
    }
}

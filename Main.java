import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;


public class Main {
    public static void main(String[] args) throws IOException {

        ArrayList<ArrayList<String>> tumgereksinimler = new ArrayList<ArrayList<String>>();
        ArrayList<String> tumadimlar = new ArrayList<String>();
        ArrayList<ArrayList<String>> totalread = new ArrayList<ArrayList<String>>();
        ArrayList<ArrayList<String>> tumgereksinimlerindogrulandigiadimlar = new ArrayList<ArrayList<String>>();
        ArrayList<String>  gereksinimlerindogrulandigiadim = new ArrayList<String>();
        ArrayList<String> tekrarlamayangereksinimler = new ArrayList<String>();

        Reader docreader = new Reader();
        totalread = docreader.Reader("C:\\Users\\admin\\Desktop\\excel\\version3\\readdoc.docx");

        tumadimlar = totalread.get(0); // fonksiyon bu şekilde dönüyor totalread'in ilk elemanı tum adimlar
        totalread.remove(0);
        System.out.println("TUM ADIMLAR: " + tumadimlar);


        tumgereksinimler = totalread;
        System.out.println("TUM GEREKSİNİMLER" + tumgereksinimler);
//Dokümandan okunan tüm gereksinimler kullanılarak, tekrarlayanlar silinerek yeni gereksinim seti oluşturuluyor.

        for(int i = 0; i < tumgereksinimler.size(); i++) {
            for(int j=0;j<tumgereksinimler.get(i).size();j++)
            { tekrarlamayangereksinimler.add(tumgereksinimler.get(i).get(j));   }}
        Set<String> stringSet = new HashSet<>();
        for (String x : tekrarlamayangereksinimler)
            stringSet.add(x);
        ArrayList<String> tekrarlanamayangereksinimler  = new ArrayList<>(stringSet); // tekrar array'e dönüyoruz.

        System.out.println("TEKRARLANAMAYAN GEREKSİNİMLER"+ tekrarlanamayangereksinimler);


            for(int k = 0; k<tekrarlanamayangereksinimler.size(); k++)
            {

                //System.out.println(tumgereksinimler.get(k).size());
                for (int i=0; i < tumgereksinimler.size();i++)
                {
                    //System.out.println(k +". indisin"+ i+". indisi  ");

                    for (int j = 0; j < tumgereksinimler.get(i).size(); j++) {

                        if(Objects.equals(tumgereksinimler.get(i).get(j), tekrarlanamayangereksinimler.get(k)))
                        {
                            //System.out.println(tekrarlanamayangereksinimler.get(k)+" gereksiniminin doğrulandığı test adımları");
                           // System.out.println(tumadimlar.get(i));
                           gereksinimlerindogrulandigiadim.add(tumadimlar.get(i));



                        }




                    }


                }



               // gereksinimlerindogrulandigiadim.clear();
                System.out.println("_________________***************________________________");
               System.out.println(tekrarlanamayangereksinimler.get(k)+" Gereksiniminin doğrulandıgi adimlar :"+gereksinimlerindogrulandigiadim);
                new ArrayList<String>(gereksinimlerindogrulandigiadim);
                gereksinimlerindogrulandigiadim.clear();





            }









       /*
            for (int j = 0; j < tumgereksinimler.get(0).size(); j++) {

                for
                //tekrarlamayangereksinimler.add(tumgereksinimler.get(j).get(j));
                tekrarlamayangereksinimler.get(i) = ? tumgereksinimler.get(0).get(0) ?
                tekrarlamayangereksinimler.get(i) = ? tumgereksinimler.get(0).get(1) ?
                tekrarlamayangereksinimler.get(i) = ? tumgereksinimler.get(0).get(2) ?


                        tekrarlamayangereksinimler.get(i) = ? tumgereksinimler.get(1).get(0) ?
                        tekrarlamayangereksinimler.get(i) = ? tumgereksinimler.get(1).get(1) ?


                        System.out.println("sayaç"+j);
            }


*/



        // TEKRARLANAMAYAN GEREKSNİMLER KULLANILARAK BİR GEREKSİNİMİN HANGİ TEST ADIMLARINDA DOĞRULANDIĞININ LİSTESİ OLUŞTURULUYOR.



        // TEKRARLANAMAYAN GEREKSNİMLER KULLANILARAK BİR GEREKSİNİMİN HANGİ TEST ADIMLARINDA DOĞRULANDIĞININ LİSTESİ OLUŞTURULDU




/*
                //Blank Document
                XWPFDocument document = new XWPFDocument();

                //Write the Document in file system
                FileOutputStream out = new FileOutputStream(new File("create_table.docx"));

                //create table
                XWPFTable table = document.createTable(100,2);


            XWPFTableRow tableRowOne = table.getRow(0);
            tableRowOne.getCell(0).setText("Cell 1");
            tableRowOne.getCell(1).setText("Cell 2");
                document.write(out);
                out.close();
                System.out.println("create_table.docx written successully");


 */
        }
    }












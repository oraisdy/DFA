import java.io.*;

/**
 * Created by Dora on 2016/10/22.
 */
public class Main {

    public static void main(String[] args) {

        try {

            //get input
            BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream("input.txt")));
            String line;
            String str = "";
            while((line = reader.readLine()) != null )
                str += line;

            Token in = new Token(str);
            State s;

            //output
            File outputFile = new File("output.txt");
            if (!outputFile.exists())
                outputFile.createNewFile();
            BufferedWriter bw = new BufferedWriter(new FileWriter(outputFile, false));


            while(in.hasNext()){
                for (s = new OriginState(); !(s instanceof FinalState); s = s.next(in)) {
                }

                if(s==FinalState.accept) {
                }
                else {
                    System.out.println(s + "\t\t" + in.getWord() );
                    bw.write(s + "\t\t" + in.getWord());
                    bw.newLine();
                }
                in.setPrevious(in.getCurrent());

            }

            bw.flush();
            bw.close();

        } catch (IOException e) {
            e.printStackTrace();
        }




    }
}

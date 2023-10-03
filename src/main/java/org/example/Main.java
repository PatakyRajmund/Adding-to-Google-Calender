package main.java.org.example;

import java.io.*;




public class Main {
    private static boolean asd(String line, String pattern)
    {
        if(pattern.length()>line.length())return false;
        for (int i=0; i<line.length()-pattern.length()+1; i++)
        {
            if(line.substring(i, i+pattern.length()).matches(pattern))return true;
        }
        return false;
    }

    public static void main(String[] args) throws IOException {



        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = null;
        String pattern = "";
        String output = null;
        while (true) {
            try {
                String buffer = br.readLine();
                String[] line = buffer.split(" ");
                input = null;
                output = null;
                pattern = "";
                for (int i = 0; i < line.length; i++) {
                    if ((i + 1 < line.length) && line[i].equals("-i")) {
                        i++;
                        input = line[i];
                    } else if ((i + 1 < line.length) && line[i].equals("-o")) {
                        i++;
                        output = line[i];
                    } else if ((i + 1 < line.length) && line[i].equals("-p")) {
                        i++;
                        pattern = line[i];
                    }
                }


                if (input == null || output == null || pattern.isEmpty())
                    throw new NotEnoughDataException("Not enough data");
                else break;
            } catch (NotEnoughDataException e) {
                System.out.println(e.getMessage());
            }
            catch(IOException l) {
                System.out.println("not possible to read");
            }

        }

        if (input.equals("System.in")) {
           try {
               br = new BufferedReader(new InputStreamReader(System.in));
               while (true) {

                   String linee = br.readLine();
                   if (linee.equals("exit")) break;
                   if (asd(linee, pattern)) System.out.println(linee);
               }
           }catch (IOException e){
               System.out.println("Not possible reading.");
           }

        } else {
            String linee = "";
            BufferedReader fr = new BufferedReader(new FileReader(input));
            FileWriter fw = new FileWriter(output);
            PrintWriter pw = new PrintWriter(fw);
            try {

                while (true) {

                    linee = fr.readLine();
                    if (linee == null) break;
                    if (asd(linee,pattern)) pw.println(linee);

                }
            }catch(IOException e){
                System.out.println("File does not exist");
            }
            finally{pw.close();
                fr.close();
            }

        }


    }
}
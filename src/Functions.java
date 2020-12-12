import java.io.FileWriter;
import java.io.IOException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class Functions {

    //not used
    protected static int euclidGCD(int a, int b){
        //if(a != 0) {
        int result = 0;

        if (a == 0) result = b;
        else if(b == 0) result = a;
        else if (a % b == 0) result = b;
        else if (a > b) result = euclidGCD(b, a % b);
        else if (a < b) result = euclidGCD(b, a);
            System.out.println(result);
        return result;
    }

    //not used
    public long trueH(int q, long a, long s) {
        int min = 2;
        // long s;
        long h;

        int max = q - 1;
        //System.out.println("q=" + q);
        //int max = 50;
        //s = (long) (Math.random() * (max - min + 1) + min);
        long hfinal = 0;
        BigInteger h1p = BigInteger.valueOf((long) Math.pow(a, s));
        h = mod(String.valueOf(h1p.longValue()), q);

        if ((s != h) && (h != 0)) {
            hfinal = h;
            System.out.println("h if" + h);
            System.out.println("hfinal if " + hfinal);
        } else {
            s = (long) (Math.random() * (max - min + 1) + min);
            System.out.println("h else " + h);
            hfinal = trueH(q, a, s);
        }
        return hfinal;
    }

    //used
    public  ArrayList<BigInteger> try100(BigInteger q) {
        int o = 1;
        int k;
        ArrayList<BigInteger> roots = new ArrayList<>();
        int z = 0;



            for (int r = 2; r < q.longValue(); r++) {
                k = (int) Math.pow(r, o);
                k %= q.longValue();
                while (k > 1) {
                    o++;
                    k *= r;
                    k %= q.longValue();
                }
                if (o == (q.longValue() - 1)) {
                    roots.add(BigInteger.valueOf(r));
                    z++;
                }
                o = 1;
            }

            for (int y = 0; y < z; y++) {
                System.out.print(roots.get(y) + ", ");
            }
            return roots;
    }
    //not used
    public  int computeAlpha(int q1){
        int alphA = 0;
        int alphaB = 0;

            int max = q1 - 1;
           alphA = ThreadLocalRandom.current().nextInt(0, max + 1);
            System.out.println("alp " + alphA);
            //int i =;
         //   System.out.println("i=" + i);
           // if (euclidGCD(alphA,q1) != 1) alphaB = alphA;
            //else computeAlpha(q1);

            while (euclidGCD(q1, alphA) == 1) {
                int i = 0;
                i++;
                alphA = (int) (Math.random() * (max - 1) + 2);
                System.out.println("a="+i+ "=" +alphA);
            };

        return alphaB;
    }

    //used
    public  List<BigInteger> calculatingTerms(BigInteger q){
    List<BigInteger> list = new ArrayList<>();
    int min = 2;
    long s;
    BigInteger alpha;
    BigInteger h;

    List<BigInteger> array;
        try {
        //q1 = Integer.parseInt(txtText.getText());

        int max = q.intValue() - 1;
        System.out.println("qx=" + q);
        //int max = 50;
       s = (long) (Math.random() * (max - min + 1) + min);
           // s1 = 2;
        System.out.println("s=" + s);
        array = try100(q);

            alpha = array.get((int) (Math.random() * (array.size()- min -2 ) + min));

        System.out.println("a=" + alpha);
        //Double a = alpha.doubleValue();
        BigInteger h1p = power(alpha,s);
        h =h1p.mod(q);
       // h1 = mod(String.valueOf(h1p), q);
        System.out.println("h=" + h);
        list.add( q);
        list.add( BigInteger.valueOf(s));
        list.add(alpha);
        list.add( h);
    }catch(NumberFormatException ex){};
        return list;

    }
        //used
    public  List<BigInteger> cripting (BigInteger m, List<BigInteger> listC){
        BigInteger c11;
        BigInteger c12;
        BigInteger k;
        List<BigInteger> list = new ArrayList<BigInteger>();
        try {
            int max = listC.get(0).intValue() - 1;

            k = BigInteger.valueOf((long) (Math.random() * max + 1));
            System.out.println("k= " +k );
            BigInteger c11p = power(listC.get(2),k.longValue());
            c11 = c11p.mod(listC.get(0));

            BigInteger c12p = power(listC.get(3),k.longValue());

            System.out.println("c12p=" + c12p);

            System.out.println("m=" + m);
            BigInteger c12pp = m.multiply(c12p);
            System.out.println("c12pp " + c12pp);
            c12 =c12pp.mod(listC.get(0));
            //list.add(k);
            list.add(c11);
            list.add(c12);
        }catch(NumberFormatException e){}
        System.out.println("c1,c2:" +list);
        return list;
    }

    //used
    static long mod(String num, long a)
    {

        // Initialize result
        long res = 0;

        // One by one process all digits of 'num'
        for (int i = 0; i < num.length(); i++)
            res = (res * 10 + (int)num.charAt(i)
                    - '0') % a;

        return res;
    }

            //used
    public BigInteger decript(List<BigInteger> list, List<BigInteger> list2){
        System.out.println("c1 =" + list2.get(0) + "; c2=" + list2.get(1) + "; q = " + list.get(0) + " s=" + list.get(1));
        BigInteger c1 = list2.get(0);
        BigInteger c2 = list2.get(1);
        BigInteger q =  list.get(0);
        BigInteger s = list.get(1);
        BigInteger m ;
        BigInteger intermidiator = power(c1,s.longValue());
        System.out.println("intermidiator: " + intermidiator);

        BigInteger intermidiator2 = intermidiator.mod(q);
        System.out.println("intermidiator2: " + intermidiator2);

        BigInteger intermidiator3 = power(intermidiator2, (q.longValue()-2));
        System.out.println("intermidiator3: " + intermidiator3);
        BigInteger mp = c2.multiply(intermidiator3);
        m =mp.mod(q);
        System.out.println("list =" +list + "\nlist2 ="+list2);
        System.out.println("mD: " + m );
        int compare = m.compareTo(BigInteger.valueOf(122));

        if( compare != 0) {System.out.println("NU E DECRIPTAT COREEEEEEEEECT!!!!!!!!!!!!!!!!!");};
        return m;
    }

            //used
    public BigInteger power (BigInteger base, long exponent){

        BigInteger result = BigInteger.valueOf(1);

        while (exponent != 0)
        {
            result =result.multiply(new BigInteger(String.valueOf(base)));
            --exponent;
        }
        return result;
    }

    public static void main(String[] args){
       //System.out.println(computeAlpha(13));
        //try100(13);
        //for(int k=0; k <6; k++){
        int i[] = {7,
                11,
                13,
                17,
                19,
                23,
                29,
                31,
                37,
                41,
                43,
                47,
                53,
                59,
                61,
                67,
                71,
                73,
                79,
                83,
                89,
                97,
                101,
                103,
                107,
                109,
                113,
                127,
                131,
                137,
                139,
                149,
                151,
                157,
                163,
                167,
                173,
                179,
                181,
                191,
                193,
                197,
                199,
                211,
                223,
                227,
                229,
                233,
                239,
                241,
                251,
                257,
                263,
                269,
                271,
                277,
                281,
                283,
                293,
                307,
                311,
                313,
                317,
                331,
                337,
                347,
                349,
                353,
                359,
                367,
                373,
                379,
                383,
                389,
                397,
                401,
                409,
                419,
                421,
                431,
                433,
                439,
                443,
                449,
                457,
                461,
                463,
                467,
                479,
                487,
                491,
                499};
        Functions f = new Functions();
       // int q = 11;
        try {
            FileWriter myWriter = new FileWriter("test"  +".txt");


        for (int j = 0; j < i.length; j++) {
            System.out.println("*******************************************************");
            //myWriter.write("*******************************************************\n");
            System.out.println("Test " +j);
            //myWriter.write("\nTest" + j);
            System.out.println("********************************************************");
            //myWriter.write("*******************************************************\n");

            List<BigInteger> list1 = f.calculatingTerms(BigInteger.valueOf(i[j]));
            //myWriter.write("\n"+String.valueOf(list1));
            List<BigInteger> listCript = f.cripting(BigInteger.valueOf(122), list1);
            //myWriter.write("\n"+String.valueOf(listCript));
            BigInteger m = f.decript(list1, listCript);
            //myWriter.write("\n" + String.valueOf(m));

            System.out.println("\n");
            System.out.println("**********************************************************");
            //myWriter.write("\n*******************************************************\n");

            System.out.println("\n");

        }
            myWriter.close();
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        //}
    }


    }

}

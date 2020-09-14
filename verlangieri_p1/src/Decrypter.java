public class Decrypter {
    public static String decrypt(String number){

        String a[] = new String[4];
        int b[] = new int[4];

        for(int i = 0; i < 4; i++){
            a[i] = number.substring(i,i+1);
            b[i] = Integer.parseInt(a[i]);
        }

        int temp = b[0];
        b[0] = b[2];
        b[2] = temp;

        int temp2 = b[1];
        b[1] = b[3];
        b[3] = temp2;

        for(int i = 0; i < 4; i++){

            b[i] = (b[i] + 3) % 10;
            a[i] = Integer.toString(b[i]);

        }

        String result = String.join("", a);

        System.out.printf("D FINAL!! " + result);

        return result;
    }
}

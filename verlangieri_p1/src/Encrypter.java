public class Encrypter  {
    public static String encrypt(String number){

        String a[] = new String[4];
        int b[] = new int[4];

        for(int i = 0; i < 4; i++){
            a[i] = number.substring(i,i+1);
            b[i] = Integer.parseInt(a[i]);
            b[i] = (b[i] + 7) % 10;
        }

        int temp = b[0];
        b[0] = b[2];
        b[2] = temp;

        int temp2 = b[1];
        b[1] = b[3];
        b[3] = temp2;

        for(int i = 0; i < 4; i++){

            a[i] = Integer.toString(b[i]);

        }

        String result = String.join("", a);

        System.out.printf("E FINAL!! " + result + "\n");

        return result;

    }

}

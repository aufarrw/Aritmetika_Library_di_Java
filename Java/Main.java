//C:\Program Files\Eclipse Adoptium\jdk-17.0.4.101-hotspot\
//java -classpath "D:\magang\22-26 Agustus 2022\25 Agustus 2022\Java\jna-5.12.1.jar;D:\magang\22-26 Agustus 2022\25 Agustus 2022\Java" Main
//javac -classpath jna-5.12.1.jar Main.java
import com.sun.jna.Library;
import com.sun.jna.Native;
import com.sun.jna.Platform;

class Main{
    public interface SharedObject extends Library{
        public double tambah (double a, double b);
        public double kurang (double a, double b);
        public double kali (double a, double b);
        public double bagi (double a, double b);
        public int bagi_integer (int a, int b);
        public int sisabagi (int a, int b);
    }

    public static void main(String[] args) {
        SharedObject lib = (SharedObject) Native.loadLibrary("aritmetika.dll", SharedObject.class);
        double a = 6.25;
        double b = 0.25;
        int c = 10;
        int d = 3;

        System.out.println(a + " + " + b + " = " + lib.tambah(a, b));
        System.out.println(a + " - " + b + " = " + lib.kurang(a, b));
        System.out.println(a + " * " + b + " = " + lib.kali(a, b));
        System.out.println(a + " / " + b + " = " + lib.bagi(a, b));
        System.out.println(c + " / " + d + " = " + lib.bagi_integer(c, d));
        System.out.println(c + " % " + d + " = " + lib.sisabagi(c, d));
    }
}
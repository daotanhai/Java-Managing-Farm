import javax.swing.plaf.IconUIResource;
import java.util.Scanner;

public class GiaSuc {
    protected String maSo;
    protected double canNang;
    protected int tuoi;

    // Phuong thuc khoi tao 0 tham so
// Active biến
    public GiaSuc() {
       // maSo = "123a";
       //canNang = 80;
        //tuoi = 5;
    }

    // Phuong thuc khoi tao co tham so
    public GiaSuc(String maSo, double canNang, int tuoi)
    {
        this.maSo = maSo;
        this.canNang = canNang;
        this.tuoi = tuoi;
    }
    //properties cho thuoc tinh
    public String getMaSo() {
        return maSo;
    }

    public void setMaSo(String maSo) {
        this.maSo = maSo;
    }

    public double getCanNang() {
        return canNang;
    }

    public void setCanNang(double canNang) {
        this.canNang = canNang;
    }

    public int getTuoi() {
        return tuoi;
    }

    public void setTuoi(int tuoi) {
        this.tuoi = tuoi;
    }
    public void nhapDuLieu()
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập mã số: ");
        maSo = sc.nextLine();
        System.out.println("Nhập cân nặng: ");
        canNang = Double.parseDouble(sc.nextLine());
        do {
            System.out.println("Nhập tuổi: ");
            tuoi = Integer.parseInt(sc.nextLine());
            if (tuoi<=0||tuoi>=30)
                System.out.println("Hãy nhập lại tuổi");
        }while (tuoi<=0||tuoi>=30);
        //System.out.println("Nhập tuổi: ");
        //tuoi = Integer.parseInt(sc.nextLine());
    }
    public void xuatDuLieu()
    {
        System.out.println("Mã số: "+maSo);
        System.out.println("Cân nặng: "+canNang);
        System.out.println("Tuổi: " +tuoi);
        System.out.println("Lượng sữa: "+tinhLuongSua());
    }
    public double tinhLuongSua()
    {
        return 0;
    }
}


import java.util.Scanner;

public class Bo extends GiaSuc {
    //protected String dacDiem;

    public void nhapDuLieu()
    {
        Scanner sc = new Scanner (System.in);
        super.nhapDuLieu();
        //System.out.println("Nhập đặc điểm: ");
       // dacDiem = sc.nextLine();
    }

    public void xuatDuLieu()
    {
        super.xuatDuLieu();
        //System.out.println("Đặc điểm con bò: "+dacDiem);

    }

    public static void main(String[] args)
    {
        GiaSuc bo1 = new Bo();//Tính đa hình, Có thể thay Bo thành GiaSuc
        bo1.nhapDuLieu();
        bo1.xuatDuLieu();
        System.out.println("Lượng sữa bò: "+bo1.tinhLuongSua());

    }
    public double tinhLuongSua()
    {
        double luongSua = 0;
        if (tuoi<=5 && tuoi >=2)
            luongSua = (canNang - tuoi)/10;

        return luongSua;
    }
}

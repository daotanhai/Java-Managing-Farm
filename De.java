public class De extends GiaSuc {

    public void nhapDuLieu ()
    {
        super.nhapDuLieu();
    }

    public void xuatDuLieu()
    {
        super.xuatDuLieu();
    }

    public static void main(String[] args)
    {
        GiaSuc de1 = new De(); //Tính đa hình, Có thể thay De thành GiaSuc
        de1.nhapDuLieu();
        de1.xuatDuLieu();
        System.out.println("Lượng sữa là: "+de1.tinhLuongSua());
    }
    public double tinhLuongSua()
    {
        double luongSua = 0;
        if (tuoi >=1 && tuoi<=2)
            luongSua = canNang/10;
        if (tuoi >2 && tuoi<=4)
            luongSua = canNang/15;
        return luongSua;
    }
}

import java.sql.SQLOutput;
import java.util.*;

public class NongTrai {
    List <GiaSuc> giaSucList = new Vector<GiaSuc>();// mảng động kiểu vector. 3 kiểu: 1.ArrayList; 2.LikedList; 3.Vector
    Scanner sc = new Scanner(System.in);
    public void nhapNongTrai()
    {
        Scanner sc = new Scanner(System.in);
        int loaiGiaSuc=0, tiepTuc = 1;
       do {
           System.out.println("1. Nhập bò\n2. Nhập dê");
           loaiGiaSuc = Integer.parseInt(sc.nextLine());
           if (loaiGiaSuc==1)
           {
               System.out.println("Bò");
               Bo bo1 = new Bo();
               bo1.nhapDuLieu();
               giaSucList.add(bo1);// Lưu dữ liệu vào list
               System.out.println("Bò Done!");
           }
           if (loaiGiaSuc==2)
           {
               System.out.println("Dê");
               De de1 = new De();
               de1.nhapDuLieu();
               giaSucList.add(de1);
               System.out.println("Dê Done!");
           }
           System.out.println("Do you want to continue? Y(1)/N(2)");
           tiepTuc = Integer.parseInt(sc.nextLine());
           if (tiepTuc !=1)
               break;
       } while (tiepTuc==1);
    }
    public void xuatNongTrai()
    {
        /*
        for (int i=0; i<giaSucList.size();i++){
            System.out.println("Loai gia suc: "+giaSucList.get(i).getClass().getSimpleName());
            giaSucList.get(i).xuatDuLieu();
        }
         */
        if ( giaSucList.size() == 0)
        {
            System.out.println("Nông trại đang không có gia súc, mời nhập lại!");
            nhapNongTrai();
        }
        for (GiaSuc gs:giaSucList)
        {
            System.out.println("\nLoai gia suc: " +gs.getClass());
            gs.xuatDuLieu();
        }
    }

    // Cau 6 & 7. Duyệt hết mảng; if bò SUM tinhLuongSua(); else dê SUM
    public void tongLuongSua()
    {
        if ( giaSucList.size() == 0)
        {
            System.out.println("Nông trại đang không có gia súc, mời nhập lại!");
            nhapNongTrai();
        }
        //
        double sumBo = 0,sumDe = 0;
        for (int i=0; i < giaSucList.size();i++)
        {
            String loaiGiaSuc = giaSucList.get(i).getClass().getSimpleName();
            if (loaiGiaSuc.equals("Bo")) // So sánh chuỗi, nếu bò..., nếu dê...
            {
                sumBo += giaSucList.get(i).tinhLuongSua();
            }
            else if (loaiGiaSuc.equals("De"))
            {
                sumDe += giaSucList.get(i).tinhLuongSua();
            }
        }
        System.out.println("Tổng sữa bò nè: "+sumBo);
        System.out.println("Tổng sữa dê nè: "+sumDe);
    }
    public void suaCaoNhat()
    {
        if ( giaSucList.size() == 0)
        {
            System.out.println("Nông trại đang không có gia súc, mời nhập lại!");
            nhapNongTrai();
        }
        GiaSuc giaSucMaxSua = new GiaSuc();
        giaSucMaxSua = giaSucList.get(0);
        int count=0;
        // Xuất DANH SÁCH những con có lượng sữa cao nhất, kể cả trùng nhau về lượng sữa
        System.out.println("Danh sách gia súc có lượng sữa cao nhất: ");
        for (int i=0; i < giaSucList.size();i++)
        {
            if ( giaSucMaxSua.tinhLuongSua() <= giaSucList.get(i).tinhLuongSua())
            {
                count ++;
                giaSucMaxSua = giaSucList.get(i);
                giaSucMaxSua.xuatDuLieu();
                System.out.println("_______________________");
            }
        }
        System.out.println("Có "+count+" con");
        // Xuất ra số liệu lượng sữa cao nhất
        System.out.println("lượng sữa cao nhất: "+giaSucMaxSua.tinhLuongSua());
    }
    public void timGiaSucTheoMaSo()
    {
        if ( giaSucList.size() == 0)
        {
            System.out.println("Nông trại đang không có gia súc, mời nhập lại!");
            nhapNongTrai();
        }
        String maSoCanTim;
        System.out.println("Nhập mã số cần tìm: ");
        maSoCanTim = sc.nextLine();
        GiaSuc giaSucMaSo = new GiaSuc();
        int count = 0;
        for (int i=0; i < giaSucList.size();i++)
        {
            String yeuCau = giaSucList.get(i).getMaSo();
            if ( maSoCanTim.equalsIgnoreCase(yeuCau)) // So sánh k phân biệt hoa thường, ignoreCase
            {
                count ++;
                giaSucMaSo = giaSucList.get(i);
                giaSucMaSo.xuatDuLieu();
                System.out.println("_______________________");
            }
        }
        if (count==0){
            System.out.println("INVALID");
        }
    }

    public void timGiaSucTheoTuoi()
    {
        if ( giaSucList.size() == 0)
        {
            System.out.println("Nông trại đang không có gia súc, mời nhập lại!");
            nhapNongTrai();
        }
        int nhapTuoi = 0,count=0;
        System.out.println("Nhập tuổi gia súc cần tìm: ");
        nhapTuoi = Integer.parseInt(sc.nextLine());
        for (int i=0; i < giaSucList.size(); i++)
        {
            int yeuCau = giaSucList.get(i).getTuoi();
            if (nhapTuoi >= yeuCau )
            {
                count++;
                giaSucList.get(i).xuatDuLieu();
                System.out.println("_______________________");
            }
        }
        if (count==0){
            System.out.println("INVALID");
        }
    }
    // CÒN 11vs12
    // 11. Viết phương thức Sắp xếp các gia súc trong nông trại tăng dần theo lượng sữa
    public void sapXepSuaTangDan ()
    {
        if ( giaSucList.size() == 0)
        {
            System.out.println("Nông trại đang không có gia súc, mời nhập lại!");
            nhapNongTrai();
        }
        Collections.sort(giaSucList, new Comparator<GiaSuc>() {
            @Override
            public int compare(GiaSuc o1, GiaSuc o2) {
                return o1.tinhLuongSua() >= o2.tinhLuongSua()? 1 : -1; // ? = if ( o1.ThuocTinh >= o2.ThuocTinh) { swap vi tri }
                // 1 là thay đổi; -1 là giữ nguyên
            }
        });
        xuatNongTrai();
    }
    // 12. Viết phương thức Sắp xếp các gia súc trong nông trại giảm dần theo tuổi
    public void sapXepTuoiGiamDan ()
    {
        if ( giaSucList.size() == 0)
        {
            System.out.println("Nông trại đang không có gia súc, mời nhập lại!");
            nhapNongTrai();
        }
        Collections.sort(giaSucList, new Comparator<GiaSuc>() {
            @Override
            public int compare(GiaSuc o1, GiaSuc o2) {
                return o1.getTuoi() <= o2.getTuoi() ? 1 : -1;
            }
        });
        xuatNongTrai();
    }
    static int userChoice()
    {
        Scanner sc = new Scanner(System.in);
        int choice;
        System.out.println("---------- Menu ---------- ");
        System.out.println("(1). Nhập dữ liệu");
        System.out.println("(2). Xuất dữ liệu");
        System.out.println("(3). Thống kê lượng sữa");
        System.out.println("(4). Tìm kiếm gia súc");
        System.out.println("(5). Sắp xếp theo tiêu chí");
        System.out.println("(0). Thoát");
        System.out.println("Nhập sự lựa chọn: ");
        choice = Integer.parseInt(sc.nextLine());
        return choice;
    }
    public static void main(String[] args) {
        NongTrai nt = new NongTrai();
        Scanner sc = new Scanner(System.in);
        int tiepTuc =1;
        System.out.println("Mời nhập dữ liệu");
        nt.nhapNongTrai();
        do {
            switch (userChoice())
            {
                case 0:
                {
                    System.out.println("Case 0");
                    System.out.println("Are you sure to exit? Y(1)/N(2) ?");
                    tiepTuc = Integer.parseInt(sc.nextLine());
                    if (tiepTuc ==1)
                    {
                        System.out.println("Now you are exited!");
                        break;
                    }
                    else if (tiepTuc ==2)
                    {
                        System.out.println("Chào mừng quay lại hệ thống menu");
                        break;
                    }
                }
                case 1: {
                    System.out.println("Case 1");
                    nt.nhapNongTrai();
                    break;
                }
                case 2:
                {
                    System.out.println("Case 2");
                    nt.xuatNongTrai();
                    break;
                }
                case 3:
                {
                    //
                    int choice=0;
                    System.out.println("Case 3");
                    do {
                        System.out.println("(1). Show tổng lượng sữa");
                        System.out.println("(2). Show sữa cao nhất");
                        choice = Integer.parseInt(sc.nextLine());
                        if (choice == 1)
                        {
                            nt.tongLuongSua();
                            break;
                        }
                        else if (choice == 2)
                        {
                            nt.suaCaoNhat();
                            break;
                        }

                        else
                            System.out.println("Đã nhập sai, mời nhập lại!");

                    } while ( choice != 1 || choice != 2 );
                    break;
                }
                case 4:
                {
                    int choice = 0;
                    System.out.println("Case 4");
                    do
                    {
                        System.out.println("(1). Tìm kiếm theo tuổi");
                        System.out.println("(2). Tìm kiếm theo mã số");
                        choice = Integer.parseInt(sc.nextLine());
                        if (choice == 1)
                        {
                            nt.timGiaSucTheoTuoi();
                            break;
                        }
                        else if (choice == 2)
                        {
                            nt.timGiaSucTheoMaSo();
                            break;
                        }
                        else
                            System.out.println("Đã nhập sai, mời nhập lại!");
                    } while ( choice != 1 || choice != 2 );
                    break;
                }
                case 5:
                {
                    int choice = 0;
                    System.out.println("Case 5");
                    do
                    {
                        System.out.println("(1). Sắp xếp tuổi giảm dần");
                        System.out.println("(2). Sắp xếp sữa tăng dần");
                        choice = Integer.parseInt(sc.nextLine());
                        if (choice == 1)
                        {
                            nt.sapXepTuoiGiamDan();
                            break;
                        }
                        else if (choice == 2)
                        {
                            nt.sapXepSuaTangDan();
                            break;
                        }
                        else
                            System.out.println("Đã nhập sai, mời nhập lại!");
                    } while ( choice != 1 || choice != 2 );
                    break;
                }
                default:
                {
                    System.out.println("No cases");
                    break;
                }
            }

        } while (tiepTuc !=1); // chỉ khi tiepTuc !=1 thì mới tiếp tục lặp lại DO | Nếu ko, tiepTuc ==1 thì sẽ break
        // TRONG KHI tiepTuc !=1 thì mới làm DO; Otherwise, out DO loop

    }
}

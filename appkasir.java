package finalprojectsem1;
import java.util.Scanner;
public class appkasir {
    Scanner sc = new Scanner(System.in);
    int pilihperan=0;
    static String menu[]={"TepungTerigu", "TepungPanir", "TepungBeras", "TepungKetan", "TepungSagu"};
    static int harga[]={10000, 9000, 7500, 10500, 17000};
    static int jumlahterjual[] = new int[menu.length];
    static double grandtotal=0;
    
   
    public static void urutkan(String menu[]) {
        for (int i = 0; i < menu.length-1; i++) {
            for (int j = i+1; j < menu.length; j++) {
                if (menu[j].compareToIgnoreCase(menu[i]) < 0) {
                    // Tukar nama barang
                    String tempNama = menu[j];
                    menu[j] = menu[i];
                    menu[i] = tempNama;

                    // Tukar harga barang
                    int tempHarga = harga[j];
                    harga[j] = harga[i];
                    harga[i] = tempHarga;

                    // Tukar jumlah terjual
                    int tempJumlah = jumlahterjual[j];
                    jumlahterjual[j] = jumlahterjual[i];
                    jumlahterjual[i] = tempJumlah;
                }
            }
        }
    }
    
    public static void urutkan(int data[]){
        for (int i = 0; i < data.length-1; i++) {
            for (int j = i+1; j < data.length; j++) {
                if(data[i]<data[j]){
                    int tempjumlahterjual=data[j];
                    data[j]=data[i];
                    data[i]=tempjumlahterjual;
                    //urutkan menu
                    String tempmenuterjual=menu[j];
                    menu[j]=menu[i];
                    menu[i]=tempmenuterjual;
                }
            }
        }
    }
    
    public static int getIndexBarang(String nama) {
        for (int i = 0; i < menu.length; i++) {
            if (menu[i].equalsIgnoreCase(nama)) {
                return i;
            }
        }
        return -1; // Jika tidak ditemukan
    }
    
    
    public static void tampilkanBarang() {
        
        System.out.println("\n=== Daftar Barang ===");
        for (int i = 0; i < menu.length; i++) {
            System.out.println((i + 1) + ". " + menu[i] + " - Rp" + harga[i]);
        }
        System.out.println("====================\n");
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int pilihperan=0;
        do{
            System.out.println("===== pilih peran =====");
            System.out.println("1. kasir");
            System.out.println("2. admin");
            System.out.println("3. owner");
            System.out.println("4. exit");
            System.out.print("pilih : ");
            pilihperan =sc.nextInt();
            switch(pilihperan){
                case 1:
                    //kasir
                    System.out.print("masukkan pin kasir : ");
                    int pinkasir=sc.nextInt();
                    if(pinkasir!=123456){
                        System.out.println("pin salah! akses ditolak");
                        break;
                    }
                    int pilihulangkasir;
                    do{
                    String belanja[] = new String[10];
                    int jumlah[] = new int[10];
                    double total[]=new double[10];
                    double totalbelanja = 0, uang, kembalian;
                    int jum=0, item=0;
                    
                    while(true){
                        tampilkanBarang();
                        System.out.print("Pilih barang (1-" + menu.length + ", 0 untuk selesai): ");
                        int pilihbarang = sc .nextInt();
                        if (pilihbarang == 0) break;
                        if (pilihbarang < 1 || pilihbarang > menu.length) {
                            System.out.println("Pilihan tidak tersedia");
                            continue;
                        }
                        System.out.print("Masukkan jumlah: ");
                        jum = sc.nextInt();
                        belanja[item] = menu[pilihbarang - 1];
                        jumlah[item] = jum;
                        item++;
                        totalbelanja=totalbelanja+harga[pilihbarang-1]*jum;
                        jumlahterjual[pilihbarang-1]=jumlahterjual[pilihbarang-1]+jum;
                    }
                    System.out.println("                              Daftar belanja                             ");
                        System.out.println("-------------------------------------------------------------------------");
                        System.out.println("no\tbarang\t\t\tharga\t\tjumlah\t\ttotal");
                        System.out.println("-------------------------------------------------------------------------");
                        for (int i = 0; i < item; i++) {
                            System.out.print((i+1)+"\t"+belanja[i]);
                            System.out.print("\t\t["+harga[getIndexBarang(belanja[i])]+"]");
                            System.out.print("\t\t["+jumlah[i]+"]");
                            System.out.println("\t\t["+jumlah[i]*harga[getIndexBarang(belanja[i])]+"]");
                        }
                        System.out.println("-------------------------------------------------------------------------");
                        System.out.println("total belanja :                                                "+totalbelanja);
                        System.out.println("-------------------------------------------------------------------------");
                        System.out.print("uang :                                                       ");
                        uang = sc.nextDouble();
                        if(uang<totalbelanja){
                            System.out.println("Uang tidak cukup");
                        }else if(uang>totalbelanja){
                            kembalian=uang-totalbelanja;
                            System.out.println("Kembalian :                                                  "+kembalian);
                            System.out.println("-------------------------------------------------------------------------");
                            System.out.println("                              Terima kasih                              ");
                        }else{
                            System.out.println("uang pas");
                            System.out.println("-------------------------------------------------------------------------");
                            System.out.println("                              Terima kasih                              ");
                        }
                        grandtotal=grandtotal+totalbelanja;
                        System.out.print("Apakah Anda ingin melanjutkan sebagai kasir? (ya=1/no=0): ");
                        pilihulangkasir=sc.nextInt();
                    }while(pilihulangkasir==1);               
                    break;
                case 2:
                    //admin
                    System.out.print("masukkan pin admin : ");
                    int pinadmin=sc.nextInt();
                    if(pinadmin!=300911){
                        System.out.println("pin salah! akses ditolak");
                        break;
                    }
                    int pilihadmin=0, pilihadmin2;
                    do{
                        System.out.println("\n=== Menu Admin ===");
                        System.out.println("1. Tampilkan Barang");
                        System.out.println("2. Tambah Barang");
                        System.out.println("3. Ubah Barang");
                        System.out.println("4. Hapus Barang");
                        System.out.println("5. Kembali ke menu utama");
                        System.out.print("Pilih menu: ");
                        pilihadmin = sc.nextInt();

                        switch (pilihadmin) {
                            case 1:
                                tampilkanBarang();
                                System.out.println("1. urutkan barang");
                                System.out.println("2. urutkan harga");
                                System.out.println("3. kembali ke menu admin");
                                System.out.print("pilih : ");
                                pilihadmin2=sc.nextInt();
                                switch(pilihadmin2){
                                    case 1:
                                        urutkan(menu);
                                        tampilkanBarang();
                                        break;
                                    case 2:
                                        urutkan(harga);
                                        tampilkanBarang();
                                        break;
                                    case 3:
                                        break;
                                }
                            break;
                            case 2:
                                //tambah barang
                                System.out.print("Masukkan nama barang baru: ");
                                sc.nextLine(); // Consume newline
                                String namabarangbaru = sc.nextLine();
                                System.out.print("Masukkan harga barang baru: ");
                                int hargabarangbaru = sc.nextInt();

                                String tempNama[]= new String[menu.length + 1];
                                int tempHarga[]= new int[harga.length + 1];
                                int tempJumlah[]= new int[jumlahterjual.length + 1];

                                for (int i = 0; i < menu.length; i++) {
                                    tempNama[i] = menu[i];
                                    tempHarga[i] = harga[i];
                                    tempJumlah[i] = jumlahterjual[i];
                                }

                                tempNama[tempNama.length - 1] = namabarangbaru;
                                tempHarga[tempHarga.length - 1] = hargabarangbaru;
                                tempJumlah[tempJumlah.length - 1] = 0;

                                menu = tempNama;
                                harga = tempHarga;
                                jumlahterjual = tempJumlah;

                                System.out.println("Barang berhasil ditambahkan.");
                                break;
                            case 3:
                                //ubah barang
                                System.out.println("ubah barang");
                                System.out.print("Masukkan nama barang yang ingin diubah : ");
                                String nama=sc.next();
                                boolean ketemu=false;
                                for (int i = 0; i < menu.length; i++) {
                                    if(nama.equalsIgnoreCase(menu[i])){
                                        ketemu=true;
                                        System.out.print("masukkan nama baru : ");
                                        menu[i]=sc.next();
                                        System.out.print("harga baru = ");
                                        harga[i]=sc.nextInt();
                                        break;
                                    }
                                }
                                if(ketemu)
                                    System.out.println("harga berhasil diubah");
                                else
                                    System.out.println("Barang tidak ada");
                                break;
                            case 4:
                                //hapus barang
                                System.out.print("Masukkan nama barang yang ingin dihapus: ");
                                sc.nextLine(); // Consume newline
                                String barangdihapus = sc.nextLine();
                                int index = getIndexBarang(barangdihapus);

                                if (index == -1) {
                                    System.out.println("Barang tidak ditemukan.");
                                    return;
                                }

                                String[] tempnamadihapus = new String[menu.length - 1];
                                int[] temphargadihapus = new int[harga.length - 1];
                                int[] tempjumlahdihapus = new int[jumlahterjual.length - 1];

                                for (int i = 0, j = 0; i < menu.length; i++) {
                                    if (i == index) continue;
                                    tempnamadihapus[j] = menu[i];
                                    temphargadihapus[j] = harga[i];
                                    tempjumlahdihapus[j] = jumlahterjual[i];
                                    j++;
                                }

                                menu = tempnamadihapus;
                                harga = temphargadihapus;
                                jumlahterjual = tempjumlahdihapus;

                                System.out.println("Barang berhasil dihapus.");
                                break;
                            case 5:
                                break;
                            default:
                                System.out.println("Pilihan tidak valid. Coba lagi.");
                        }
                    }while(pilihadmin!=5);
                    break;
                case 3:
                    //owner
                    System.out.print("masukkan pin owner : ");
                    int pinowner=sc.nextInt();
                    if(pinowner!=547426){
                        System.out.println("pin salah! akses ditolak");
                        break;
                    }
                    System.out.println("\n=== Laporan Owner ===");
                    System.out.println("Total pemasukan: " + grandtotal);
                    urutkan(jumlahterjual);
                    //tampilkan hasil
                    System.out.println("\n=== barang terlaris ===");
                    for (int i = 0; i < menu.length; i++) {
                        System.out.println((i+1)+"."+menu[i]+" ["+harga[i]+"] = "+jumlahterjual[i]);
                    }
                    System.out.println("=======================\n");
                    break;
                case 4:
                    System.out.println("terimakasih telah menggunakan program kasir");
                    break;
            }
         }while(pilihperan!=4);
    }
}

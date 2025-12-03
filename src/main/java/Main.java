import model.vendedor.IdVendedor;
import model.vendedor.Vendedor;
import model.vendedor.VendedorInfo;

public class Main {
    public static void main(String[] args) {

        IdVendedor idVendedor = new IdVendedor(88);
        VendedorInfo vendedorInfo = new VendedorInfo("N", "54323445324");
        Vendedor vende = new Vendedor(idVendedor, vendedorInfo);

        System.out.println(vende);
    }
}
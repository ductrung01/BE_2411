package vn.com.t3h.controller.cms.product.insert;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import vn.com.t3h.model.Product;
import vn.com.t3h.service.ProductService;

@Controller
public class AddProductController {
    @Autowired
    private ProductService productService;
    @PostMapping("/cms/insert")
    public String insert(HttpServletRequest request, Model model) {
        //get param ra
      String tenSach = request.getParameter("tenSach");
      String tacGia = request.getParameter("tacGia");
      int soTrang = Integer.parseInt(request.getParameter("soTrang"));
      String nhaXuatBan = request.getParameter("nhaXuatBan");
      String theLoai  = request.getParameter("theLoai");
      int namXuatBan = Integer.parseInt(request.getParameter("namXuatBan"));
      int soLuotMua = Integer.parseInt(request.getParameter("soLuotMua"));
      double giaBan = Double.parseDouble(request.getParameter("gia"));
      int soLuongTrongKho = Integer.parseInt(request.getParameter("soLuongTrongKho"));
      String moTa = request.getParameter("moTa");
      String hinhAnh = request.getParameter("hinhAnh");
      double khuyenMai = Double.parseDouble(request.getParameter("khuyenMai"));

        Product product = new Product();
        product.setBookTitle(tenSach);
        product.setAuthor(tacGia);
        product.setPageCount(soTrang);
        product.setPublisher(nhaXuatBan);
        product.setGenre(theLoai);
        product.setPublicationYear(namXuatBan);
        product.setStockQuantity(soLuotMua);
        product.setPrice(giaBan);
        product.setStockQuantity(soLuongTrongKho);
        product.setDescription(moTa);
        product.setImage(hinhAnh);
        product.setDiscount(khuyenMai);
        productService.addProduct(product);
        return "redirect:/cms/product";
    }
}
//package vn.com.t3h.controller.cms.product.insert;
//
//import jakarta.servlet.http.HttpServletRequest;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.ui.Model;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.PostMapping;
//import vn.com.t3h.model.Product;
//import vn.com.t3h.service.ProductService;
//
//@Controller
//public class AddProductController {
//    @Autowired
//    private ProductService productService;
//
//    @PostMapping("/cms/insert")
//    public String insert(HttpServletRequest request, Model model) {
//        // Get parameters from request
//        String tenSach = request.getParameter("tenSach");
//        String tacGia = request.getParameter("tacGia");
//        int soTrang = parseInteger(request.getParameter("soTrang"));
//        String nhaXuatBan = request.getParameter("nhaXuatBan");
//        String theLoai = request.getParameter("theLoai");
//        int namXuatBan = parseInteger(request.getParameter("namXuatBan"));
//        int soLuotBan = parseInteger(request.getParameter("soLuotBan"));
//        double giaBan = parseDouble(request.getParameter("gia"));
//        int soLuongTrongKho = parseInteger(request.getParameter("soLuongTrongKhoan"));
//        String moTa = request.getParameter("moTa");
//        String hinhAnh = request.getParameter("hinhAnh");
//        double khuyenMai = parseDouble(request.getParameter("khuyenMai"));
//
//        // Create and set product details
//        Product product = new Product();
//        product.setBookTitle(tenSach);
//        product.setAuthor(tacGia);
//        product.setPageCount(soTrang);
//        product.setPublisher(nhaXuatBan);
//        product.setGenre(theLoai);
//        product.setPublicationYear(namXuatBan);
//        product.setStockQuantity(soLuotBan);
//        product.setPrice(giaBan);
//        product.setStockQuantity(soLuongTrongKho);
//        product.setDescription(moTa);
//        product.setImage(hinhAnh);
//        product.setDiscount(khuyenMai);
//
//        // Add product to the service
//        productService.addProduct(product);
//
//        return "redirect:/cms/product";
//    }
//
//    // Safe parsing methods
//    private int parseInteger(String value) {
//        if (value == null || value.isEmpty()) {
//            return 0; // Hoặc ném ngoại lệ tùy chỉnh nếu cần
//        }
//        return Integer.parseInt(value);
//    }
//
//    private double parseDouble(String value) {
//        if (value == null || value.isEmpty()) {
//            return 0.0; // Hoặc ném ngoại lệ tùy chỉnh nếu cần
//        }
//        return Double.parseDouble(value);
//    }
//}

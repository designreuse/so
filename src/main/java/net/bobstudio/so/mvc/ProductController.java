/**
 * 
 */
package net.bobstudio.so.mvc;

import java.util.Map;

import javax.servlet.ServletRequest;

import net.bobstudio.so.domain.Product;
import net.bobstudio.so.domain.ProductInstock;
import net.bobstudio.so.domain.ProductOutstock;
import net.bobstudio.so.dto.PageVo;
import net.bobstudio.so.dto.ProductInstockVo;
import net.bobstudio.so.dto.ProductOutstockVo;
import net.bobstudio.so.dto.ProductVo;
import net.bobstudio.so.dto.Status;
import net.bobstudio.so.service.ProductService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springside.modules.mapper.BeanMapper;
import org.springside.modules.web.Servlets;

import com.google.common.collect.Maps;

/**
 * @author Walter <zhanggx2003@126.com> 2016年9月29日
 */
@Controller
@RequestMapping("/products")
public class ProductController {

	private static Map<String, String> sortTypes = Maps.newLinkedHashMap();
	static {
		sortTypes.put("auto", "自动");
		sortTypes.put("name", "名称");
	}

	@Autowired
	private ProductService productService;

	@GetMapping("main")
	public ModelAndView list(@ModelAttribute ProductVo productVo,
			@RequestParam(value = "page", defaultValue = "1") int pageNumber,
			@RequestParam(value = "page.size", defaultValue = PageVo.PAGE_SIZE) int pageSize,
			@RequestParam(value = "sortType", defaultValue = "auto") String sortType, Model model,
			ServletRequest request) {
		Map<String, Object> searchParams = Servlets.getParametersStartingWith(request, "search_");

		Page<Product> products = productService.findAll(searchParams, pageNumber, pageSize, sortType);
		model.addAttribute("allStatus", Status.values());
		model.addAttribute("sortType", sortType);
		model.addAttribute("sortTypes", sortTypes);
		model.addAttribute("page", new PageVo("/products", products));

		return new ModelAndView("products/productsList", "products", BeanMapper.mapList(products.getContent(), ProductVo.class));
	}

	@GetMapping("/instocks/main")
	public ModelAndView listInstock(@RequestParam(value = "page", defaultValue = "1") int pageNumber,
			@RequestParam(value = "page.size", defaultValue = PageVo.PAGE_SIZE) int pageSize,
			@RequestParam(value = "sortType", defaultValue = "auto") String sortType, Model model,
			ServletRequest request) {
		Map<String, Object> searchParams = Servlets.getParametersStartingWith(request, "search_");

		Page<ProductInstock> prodInstocks = productService.findAllInstock(searchParams, pageNumber, pageSize, sortType);

		PageVo page = new PageVo("/products/instocks", prodInstocks);
		model.addAttribute("page", page);
		model.addAttribute("sortType", sortType);
		model.addAttribute("sortTypes", sortTypes);

		return new ModelAndView("products/prodInstocksList", "prodInstocks",
				BeanMapper.mapList(prodInstocks.getContent(), ProductInstockVo.class));
	}

	@GetMapping("/outstocks/main")
	public ModelAndView listOutstock(@RequestParam(value = "page", defaultValue = "1") int pageNumber,
			@RequestParam(value = "page.size", defaultValue = PageVo.PAGE_SIZE) int pageSize,
			@RequestParam(value = "sortType", defaultValue = "auto") String sortType, Model model,
			ServletRequest request) {
		Map<String, Object> searchParams = Servlets.getParametersStartingWith(request, "search_");

		model.addAttribute("sortType", sortType);
		model.addAttribute("sortTypes", sortTypes);
		Page<ProductOutstock> prodOutstocks = productService.findAllOutstock(searchParams, pageNumber, pageSize,
				sortType);

		PageVo page = new PageVo("/products/outstocks", prodOutstocks);
		model.addAttribute("page", page);

		return new ModelAndView("products/prodOutstocksList", "prodOutstocks",
				BeanMapper.mapList(prodOutstocks.getContent(), ProductOutstockVo.class));
	}

}

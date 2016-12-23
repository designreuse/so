package net.bobstudio.so.mvc;

import java.util.Map;

import org.springframework.ui.Model;

import com.google.common.collect.Maps;

import net.bobstudio.so.dto.PageVo;
import net.bobstudio.so.dto.Status;

public class PageModel {
	private static Map<String, String> sortTypes = Maps.newLinkedHashMap();
	static {
		sortTypes.put("auto", "自动");
		sortTypes.put("name", "名称");
	}

	protected static void setModelForPage(String sortType, Model model, PageVo page) {
		model.addAttribute("allStatus", Status.values());
		model.addAttribute("sortType", sortType);
		model.addAttribute("sortTypes", sortTypes);
		model.addAttribute("page", page);
		
	}
}
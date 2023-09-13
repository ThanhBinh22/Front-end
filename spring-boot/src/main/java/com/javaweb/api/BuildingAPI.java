package com.javaweb.api;

import java.util.HashMap;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.javaweb.bean.BuildingBean;
import com.javaweb.customexception.FileRequiredException;

@RestController
@RequestMapping(value = "/api/building")

public class BuildingAPI {
	@GetMapping
	public Object getBuidings(@RequestParam(value = "name", required = false) String nameBuilding,
			@RequestParam(value = "numberOfBasement", required = false) Long numberOfBasement) {
		BuildingBean buildingBean = new BuildingBean();
		buildingBean.setName(nameBuilding);
		buildingBean.setNumOfBasement(numberOfBasement);
		valiData(buildingBean);
//		try {
//			System.out.println(10 / 0);
//			
//			
//		} catch (Exception ex) {
//			ErrorDetail errorDetail = new ErrorDetail();
//			errorDetail.setError(ex.getMessage());
//			List<String> details = new ArrayList<>();
//			details.add("Tên tòa nhà hoặc số hầm không được thiếu khi gửi về cho BE");
//			errorDetail.setDetails(details);
//			return errorDetail;
//		}
		return buildingBean;
	}

	private void valiData(BuildingBean buildingBean) {
		if (buildingBean.getName() == null || buildingBean.getName() == "" || buildingBean.getNumOfBasement() == null) {
			throw new FileRequiredException("Name or Number of Basement is null");
		}
	}

	@PostMapping
	public BuildingBean createBuildings(@RequestBody HashMap<String, String> mp) {
//		try {
//			System.out.println(10 / 0);
//		} catch (RuntimeException ex) {
//			System.out.println(ex.getMessage());
//		}
		System.out.println(10 / 0);
		return null;
	}

	@GetMapping("/{name}")
	public BuildingBean getBuildings(@PathVariable("name") String nameBuilding) {
		return null;
	}
}

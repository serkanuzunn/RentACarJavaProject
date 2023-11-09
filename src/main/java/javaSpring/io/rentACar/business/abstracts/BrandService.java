package javaSpring.io.rentACar.business.abstracts;

import java.util.List;

import javaSpring.io.rentACar.business.requests.CreateBrandRequest;
import javaSpring.io.rentACar.business.requests.UpdateBrandRequest;
import javaSpring.io.rentACar.business.responses.GetAllBrandsResponse;
import javaSpring.io.rentACar.business.responses.GetByIdBrandResponse;

public interface BrandService {
	List<GetAllBrandsResponse> getAll();
	GetByIdBrandResponse getById(int id);
	void add(CreateBrandRequest createBrandRequest);
	void update(UpdateBrandRequest updateBrandRequest);
	void delete(int id);
}

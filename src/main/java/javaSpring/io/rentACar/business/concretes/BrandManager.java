package javaSpring.io.rentACar.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import javaSpring.io.rentACar.business.abstracts.BrandService;
import javaSpring.io.rentACar.business.requests.CreateBrandRequest;
import javaSpring.io.rentACar.business.requests.UpdateBrandRequest;
import javaSpring.io.rentACar.business.responses.GetAllBrandsResponse;
import javaSpring.io.rentACar.business.responses.GetByIdBrandResponse;
import javaSpring.io.rentACar.business.rules.BrandBusinessRules;
import javaSpring.io.rentACar.core.utilities.mappers.ModelMapperService;
import javaSpring.io.rentACar.dataAccess.abstracts.BrandRepository;
import javaSpring.io.rentACar.entities.concretes.Brand;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class BrandManager implements BrandService{
	private BrandRepository brandRepository;
	private ModelMapperService modelMapperService;
	private BrandBusinessRules brandBusinessRules;
	

	@Override
	public List<GetAllBrandsResponse> getAll() {
		List<Brand> brands = brandRepository.findAll();
		
		List<GetAllBrandsResponse> brandsResponse=brands.stream()
				.map(brand-> this.modelMapperService.forResponse()
						.map(brand, GetAllBrandsResponse.class)).collect(Collectors.toList());
		
		return brandsResponse;
	}

	@Override
	public void add(CreateBrandRequest createBrandRequest) {
		this.brandBusinessRules.checkIfBrandNameExists(createBrandRequest.getName());
		
		Brand brand = this.modelMapperService.forRequest().map(createBrandRequest, Brand.class);
		
		this.brandRepository.save(brand);
	}

	@Override
	public GetByIdBrandResponse getById(int id) {
		Brand brand = this.brandRepository.findById(id).orElseThrow();
		
		GetByIdBrandResponse response = this.modelMapperService.forResponse().map(brand, GetByIdBrandResponse.class);
		
		return response;
	}

	@Override
	public void update(UpdateBrandRequest updateBrandRequest) {
		Brand brand = this.modelMapperService.forRequest().map(updateBrandRequest, Brand.class);
		this.brandRepository.save(brand);
	}

	@Override
	public void delete(int id) {
		this.brandRepository.deleteById(id);
		
	}
	
}

package javaSpring.io.rentACar.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import javaSpring.io.rentACar.business.abstracts.ModelService;
import javaSpring.io.rentACar.business.requests.CreateModelRequest;
import javaSpring.io.rentACar.business.responses.GetAllModelsResponse;
import javaSpring.io.rentACar.core.utilities.mappers.ModelMapperService;
import javaSpring.io.rentACar.dataAccess.abstracts.ModelRepository;
import javaSpring.io.rentACar.entities.concretes.Model;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ModelManager implements ModelService{
	private ModelRepository modelRepository;
	private ModelMapperService modelMapperService;

	@Override
	public List<GetAllModelsResponse> getAll() {
		List<Model> models = modelRepository.findAll();
		
		List<GetAllModelsResponse> modelsResponse=models.stream()
				.map(model-> this.modelMapperService.forResponse()
						.map(model, GetAllModelsResponse.class)).collect(Collectors.toList());
		
		return modelsResponse;
	}

	@Override
	public void add(CreateModelRequest createModelRequest) {
		Model model = this.modelMapperService.forRequest().map(createModelRequest, Model.class);
		
		this.modelRepository.save(model);
		
	}

}

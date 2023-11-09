package javaSpring.io.rentACar.business.abstracts;

import java.util.List;

import javaSpring.io.rentACar.business.requests.CreateModelRequest;
import javaSpring.io.rentACar.business.responses.GetAllModelsResponse;

public interface ModelService {
	List<GetAllModelsResponse> getAll();
	void add(CreateModelRequest createModelRequest);
}

package guru.springframework.sfgdi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

import com.springframework.pets.PetService;

/**
 * Created by jt on 12/28/19.
 */
@Controller
public class PetController {

	private final PetService petService;

	@Autowired
	public PetController(@Qualifier("petService") PetService petService) {
		super();
		this.petService = petService;
	}

	public String whichPetIsTheBest() {
		return petService.getPetType();
	}
}

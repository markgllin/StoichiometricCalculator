package stoichiometry;

import java.util.Arrays;
import java.util.List;

public class Equations {
	List<String> reactants;
	List<String> products;
	
	public List<String> getReactants(){
		return reactants;
	}
	
	public void setReactants(String eqReactants){
		String[] arrayCompounds = Parser.splitEquation(eqReactants);
		reactants = Arrays.asList(arrayCompounds);
	}
	
	public List<String> getProducts(){
		return products;
	}
	
	
	
}

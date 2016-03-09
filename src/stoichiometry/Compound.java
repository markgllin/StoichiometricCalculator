package stoichiometry;

import java.util.List;

public class Compound {
	private String formula;
	private String name;
	private double mass;
	List<List<String>> parsedCompound;
	List<Element> elementList;
	
	public void setElementList(List<Element> elements){
		elementList = elements;
	}
	
	public List<Element> getElementList(){
		return elementList;
	}
	
	public void setFormula(String compoundFormula){
		formula = compoundFormula;
	}
	
	public String getFormula(){
		return formula;
	}
	
	public void setName(String compoundName){
		name = compoundName;
	}
	
	public String getName(){
		return name;
	}
	
	public void setMass(double compoundMass){
		mass = compoundMass;
	}
	
	public double getMass(){
		return mass;
	}

	public void setParsedFormula(List<List<String>> parsed){
		parsedCompound = parsed;
	}
	
	public List<List<String>> getParsedFormula(){
		return parsedCompound;
	}

}

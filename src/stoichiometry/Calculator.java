package stoichiometry;

import java.util.List;

public class Calculator {

	/* calcs the mass of a compound. Compound is taken in as a List
	 * of list of string, in the same format that is returned from
	 * parseFormula(). Mass is returned as a double.
	 */
 	public static double calcCompoundMass(List<List<String>> compound, List<Element> elementList){
 		int ELEM_SYM=0, ELEM_MULT=1;
 		double elementMass, mass = 0;

 		//search for each element and calc the mass
 		for (List<String> curElement:compound){
 			for (Element elemList:elementList){
				if(elemList.getSymbol().equals(curElement.get(ELEM_SYM))){
 					elementMass = Parser.parseMass(elemList.getMass());
 		 			mass = mass + (elementMass *Double.parseDouble(curElement.get(ELEM_MULT)));
 		 			break;
				}
 			}
 		}

		return mass;
	}
	
	/* calculates the subtotal mass of an element in a compound.
	 * takes in a compound list (e.g. {<symbol>, <multiplier>}) and
	 * searches for the corresponding element in the element list, using that
	 * to calculate the subtotal mass once found.
	 */
	public static double calcElementMass(List<String> compound, List<Element> elementList){
 		int ELEM_SYM=0, ELEM_MULT=1;
 		double elementMass;

 		//search for each element and calc the mass
		for (Element elemList:elementList){
			if(elemList.getSymbol().equals(compound.get(ELEM_SYM))){
				elementMass = Parser.parseMass(elemList.getMass());
	 			return (elementMass *Double.parseDouble(compound.get(ELEM_MULT)));
			}
		}
 		
		return 0;
	}
 	
	/* calculates the percent composition an element is in a compound.
	 * requires the total mass of the element in the compound as well
	 * as the total mass of compound. If an uncaught error occured earlier
	 * that resulted int total compound mass being 0, function returns -1
	 * to indicate an error.
	 */
 	public static double calcPercentMass(double compMass, double elemMass){
 		//if division by 0, return -1
 		if (compMass<1) return -1;
 		return (elemMass/compMass)*100;
 	}

}

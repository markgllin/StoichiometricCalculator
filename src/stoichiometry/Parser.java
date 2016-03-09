package stoichiometry;

import java.util.ArrayList;
import java.util.List;

public class Parser {

	/* takes in the mass of an element in string format
	 * and removes all square brackets and round brackets
	 * (+ whatever is in them). Characters in square brackets
	 * are not removed, only the brackets themselves.
	 * Resulting string is then converted into a double.
	 */
	public static double parseMass(String sMass){
		double iMass;
		sMass = sMass.replaceAll("\\(.+?\\)","").replaceAll("\\[", "").replaceAll("\\]", "");
		iMass = Double.parseDouble(sMass);
		return iMass;
	}
		
	/* takes in a compound formula (e.g. Al2(SO5)2) and parses
	 * each element into a list of lists of element symbols and multiplier.
	 * (e.g. { {<element symbol, element multiplier}...{...}...}
	 * Order of the elements is backwards (e.g. { {O,10}, {S,2}, {Al,2}}
	 */
	public static List<List<String>> parseFormula(String formula){
		String[] splitFormula = splitCompound(formula);
		List<List<String>> multipliedFormula = new ArrayList<List<String>>();
		String[] splitComp;
		double multiplier = 1;
		int COMP = 0;
		int MULT = 1;
		List<String> curCompound;

		for(int i = splitFormula.length-1;  i>=0; i--){
			//if empty string, multiplier no longer applies
			if (splitFormula[i].length()==0){
				multiplier = 1;
			}
			//if first char is a digit,new multiplier was encountered
			else if (Character.isDigit(splitFormula[i].charAt(0))){
				multiplier = Double.parseDouble(splitFormula[i]);
			}
			//if first char is a letter, new compound encountered
			else if (Character.isLetter(splitFormula[i].charAt(0))){
				splitComp = splitFactor(splitFormula[i]);
				
				curCompound = new ArrayList<String>();
				curCompound.add(splitComp[COMP]);				
				
				//if compound length ==1, only compound present
				if ((splitComp.length)==1){
					curCompound.add(String.valueOf(multiplier));
					
				//if compound length==2, compound and multiplier present
				} else if (splitComp.length==2){
					curCompound.add(String.valueOf(Double.parseDouble(splitComp[MULT])*multiplier));
				//if compouned length != 1 != 2, parsed incorrectly
				} else{
					System.out.println("String was parsed incorrectly");
					System.exit(0);
				}
				
				multipliedFormula.add(curCompound);
			}
		}
		
		return multipliedFormula;
	}
		
	/*splits a compound into respective elements.
	 * e.g. Al(SO4)2 -> {Al, "", S, O4, 2}
	 */
	public static String[] splitCompound(String compound){
		return compound.split("\\(|\\)|(?=\\p{Upper})");
	}
	
	/* takes in a compound (e.g. "Al4") and splits it b/w # and
	 * value (e.g. {"Al", "4'})
	 */
	public static String[] splitFactor(String compound){
		return compound.split("(?<=[a-zA-Z])(?=\\d)|(?<=\\d)(?=[a-zA-Z])");
	}
	
	/*takes in a chemical equation as a string and splits it into
	 * individual compounds as a string, returning it as a list
	 * of compounds (as strings)
	 */
	public static String[] splitEquation(String equation){
		String[] equationCompounds = equation.split("\\+");
		
		for(int i=0; i < equationCompounds.length; i++)
			equationCompounds[i]=equationCompounds[i].trim();
		
		return equationCompounds;
	}
}

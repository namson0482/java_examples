public class BalancedParentheses {
//
	private static String[] checkBalancedParentheses(String[] values){
		
		String []result = new String[values.length];
		for(int k=0;k<values.length;k++) {
			String input = values[k];
			String response = "NO";
			if(input == null){
	        	response = "NO";
	        } else if(input.length()==0){
	            response = "YES";
	        } else {
	        	java.util.Stack<String> stack = new java.util.Stack<String>();
				for(int i=0; i < input.length(); i++){
					String str = ""+input.charAt(i);		
					if(str.equals("(") || str.equals("[") || str.equals("{")){
						stack.push(str);
					}
					if(str.equals(")") || str.equals("]") || str.equals("}")){
						if(stack.isEmpty()){
							response = "NO";
							break;
						}
						String opening = stack.peek();
						if(str.equals(")") && opening.equals("(")){
							stack.pop();
						}
						if(str.equals("]") && opening.equals("[")){
							stack.pop();
						}
						if(str.equals("}") && opening.equals("{")){
							stack.pop();
						}
					}			
				}
				if(input.length() > 0 && stack.isEmpty()){
					response = "YES";
				}
	        }
			result[k] = response;
		}
		return result;
	}
	
//	private static String[] checkBalancedParentheses(String[] values){
//		String []result = new String[values.length];
//		
//		for(int k=0;k<values.length;k++) {
//			String value = values[k];
//			java.util.Stack<Character> specialCharStack = new java.util.Stack<Character>();
//	        String response = "NO";
//	        char tempChar;
//	        Character[] openingBraces = {'[','(','{'};
//	        Character[] closingBraces = {']',')','}'};
//	        List<Character> openingBracesList = Arrays.asList(openingBraces);
//	        List<Character> closingBracesList = Arrays.asList(closingBraces);
//	        if(value == null){
//	        	response = "NO";
//	        } else if(value.length()==0){
//	            response = "YES";
//	        } else{
//	            for(int i=0; i < value.length(); i++) {
//	                tempChar = value.charAt(i);
//	                 
//	                if(openingBracesList.contains(tempChar)){
//	                    specialCharStack.push(tempChar);
//	                }else if(closingBracesList.contains(tempChar)){
//	                    if(!specialCharStack.isEmpty()){
//	                        if(tempChar==')' && '(' != specialCharStack.pop()){
//	                            break;
//	                        }else if(tempChar=='}' && '{' !=specialCharStack.pop()){
//	                        	break;
//	                        }else if(tempChar==']' && '[' != specialCharStack.pop()){
//	                        	break;
//	                        }
//	                    }else{
//	                    	break;
//	                    }
//	                }else{
//	                	break;
//	                }
//	            }
//	            if( specialCharStack.isEmpty()){
//		            response = "YES";
//		            
//		        }
//	        }
//	        result[k] = response;
//	        
//		}
//		return result;
//		
//	}

	public static void main(String[] args) {
		String[] inputs = null;//{"{[()]}","{[(])}","{{[[(())]]}}"};		
		String []results = checkBalancedParentheses(inputs);
		for(String input : results){
			System.out.println(input);
					
		}
	}
}
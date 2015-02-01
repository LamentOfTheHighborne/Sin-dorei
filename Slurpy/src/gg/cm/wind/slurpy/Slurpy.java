package gg.cm.wind.slurpy;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Slurpy {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int strCount = sc.nextInt();
		sc.nextLine();
		String[] strArray = new String[strCount];
		for(int i = 0;i < strArray.length;i++)
		{
			strArray[i] = sc.nextLine();
		}
		sc.close();
		System.out.println("SLURPYS OUTPUT");
		for(int i = 0;i < strArray.length;i++)
		{
			System.out.println(isSlurpy(strArray[i]));
		}
		System.out.println("END OF OUTPUT");
		
		
		
	}
	
	public static String isSlurpy(String str){
		for(int i = 0;i < str.length();i++)
		{
			if(isSlimp(str.substring(0,i)))
			{
				String restStr = str.substring(i,str.length());
				if(isSlump(restStr))
				{
					return "YES";
				}				
			}			
		}
		return "NO";
	}
	
	public static boolean isSlump(String str)
	{
		Pattern patSlump = Pattern.compile("^[DE]F+");
		Matcher matcherSlump = patSlump.matcher(str);
		String restStr;
		if (matcherSlump.find()){
			restStr = matcherSlump.replaceFirst("");
		}
		else{
			return false;
		}
		if(restStr.equals(""))
		{
			return false;
		}
		else
		{
			if(restStr.equals("G"))
			{
				return true;
			}
			else
			{
				return isSlump(restStr);
			}
		}	
	}
	
	public static boolean isSlimp(String str)
	{
		if(str.equals("AH"))
		{
			return true;
		}		
		
		Pattern patSlimp = Pattern.compile("^[A][B]\\w*[C]");
		Matcher matcherSlimp = patSlimp.matcher(str);			
		if (matcherSlimp.matches())
		{
			String restStr = str.substring(2,str.length() - 1);
			return isSlimp(restStr);
		}
		else
		{
			if(!str.equals("") && str.charAt(0) == 'A' && str.charAt(str.length() - 1) == 'C')
			{
				String restStr = str.substring(1, str.length() - 1);
				return isSlump(restStr);
			}
			else
			{
				return false;
			}
		}

	}
}

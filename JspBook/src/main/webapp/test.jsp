<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>

<%
	int fat = 25;
	int carbohydrate = 520;
	int protein = 45;
	
	int kcal = (fat*9) + (carbohydrate*4) + (protein*4);
	
	out.print("총 칼로리 : " + kcal + " cal");
	
	out.print("<br>==================<br>");
	
	
	String fat1 = "25";
	String carbohydrate1 = "520";
	String protein1 = "45";
	
	int fatr = Integer.parseInt(fat1);
	int carbohydrater = Integer.parseInt(carbohydrate1);
	int proteinr = Integer.parseInt(protein1);
	
	int kcal2 = (fat*9) + (carbohydrate*4) + (protein*4);
	//out.print("총 칼로리 : " + kcal2 + " cal");
	
	out.print((fat*9) + (carbohydrate*4) + (protein*4));
	//out.print( (fat1*9)+ (carbohydrate1*4) + (protein1*4) );

	

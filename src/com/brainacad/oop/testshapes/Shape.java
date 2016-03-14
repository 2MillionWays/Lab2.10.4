package com.brainacad.oop.testshapes;

import java.util.Objects;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class Shape implements Drawable {
    private String shapeColor;

    public String getShapeColor() {
        return shapeColor;
    }

    public Shape(String shapeColor) {
        this.shapeColor = shapeColor;
    }

    @Override
    public String toString() {
        return "This is Shape, color is: " + shapeColor;
    }

    public abstract double calcArea();

    //Lab 2.10.4

    public static Shape parseShape(String str) throws InvalidShapeStringException{

        StringTokenizer stringTokenizer = new StringTokenizer(str, ":, ");
        String type = stringTokenizer.nextToken();

        if (type.equals("Rectangle")){                               //it's better idea to use case instead of many if...if...if
            String conditionRec = "(Rectangle):[A-Z]+:\\d+,\\d+";
            Pattern patternOne = Pattern.compile(conditionRec);      //very good idea!
            Matcher matcherOne = patternOne.matcher(str);

            if (!matcherOne.matches())
                throw new InvalidShapeStringException("Invalid input");

            String color = stringTokenizer.nextToken();
            double width = Double.parseDouble(stringTokenizer.nextToken());
            double height = Double.parseDouble(stringTokenizer.nextToken());
            return new Rectangle(color,width,height);
        }

        if (type.equals("Triangle")){
            String conditionTri = "(Triangle):[A-Z]+:\\d+,\\d+,\\d+";
            Pattern patternTwo = Pattern.compile(conditionTri);
            Matcher matcherTwo = patternTwo.matcher(str);

            if (!matcherTwo.matches())
                throw new InvalidShapeStringException("Invalid input");

            String color = stringTokenizer.nextToken();
            double a = Double.parseDouble(stringTokenizer.nextToken());
            double b = Double.parseDouble(stringTokenizer.nextToken());
            double c = Double.parseDouble(stringTokenizer.nextToken());
            return new Triangle(color,a,b,c);
        } else {
            String conditionCirc = "(Circle):[A-Z]+:\\d+";
            Pattern patternThree = Pattern.compile(conditionCirc);
            Matcher matcherThree = patternThree.matcher(str);

            if (!matcherThree.matches())
                throw new InvalidShapeStringException("Invalid input");

            String color = stringTokenizer.nextToken();
            double radius = Double.parseDouble(stringTokenizer.nextToken());
            return new Circle(color,radius);
        }
    }
}

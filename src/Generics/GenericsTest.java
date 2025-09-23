package Generics;

import java.util.ArrayList;
import java.util.List;

public class GenericsTest {

    public static  void main(String[]  args)
    {
        Painter<Rectangle> p1 = new Painter<Rectangle>(40);
        System.out.print(p1.cost(new Rectangle(40,50)));

     //   List<T extends Shape> list = new ArrayList<>(T extends Shape);

        totalArea(List.of(new Square(4),new Rectangle(4,5)));

        totalArea(new Square(4),new Rectangle(5,6));


        List<Integer> src = new ArrayList<Integer>(List.of(1,2,3));
        List<Number> dst = new ArrayList<>();
        copy(src,dst);

    }

//wildcards

public static <T> void copy(List<? extends T> src, List<? super T> dst)
{
  for(T t:src)
  {
      dst.add(t);
  }

}




    static  <T extends Shape> double totalArea(List<T>  Shape)
{
System.out.println(Shape.size());
return Shape.size();

}

static  <T extends  Shape> double totalArea(T t1, T t2)
{
return t1.getArea() + t2.getArea();
}






}

class Painter<T extends Shape>
{
    public int costPerSqUnit;

    public Painter(int costPerSqUnit)
    {
        this.costPerSqUnit = costPerSqUnit;
    }

    public double cost(T shape)
    {
        return  this.costPerSqUnit * shape.getArea();
    }
}


interface  Shape
{
    double getperimeter();
    double getArea();
}


class circle implements Shape
{
    public double radius;


    public circle(double radius)
    {
        this.radius = radius;
    }

    @Override
    public double getperimeter() {
        return 2 * 3.142 * this.radius;
    }

    @Override
    public double getArea() {
        return 2 * this.radius * this.radius;


    }
}

class Rectangle implements  Shape{

    public double length;
    public double breadth;

    public Rectangle(double length , double breadth)
    {
        this.length = length;
        this.breadth = breadth;

    }
    @Override
    public double getperimeter() {
        return 2* (this.length * this.breadth);
    }

    @Override
    public double getArea() {
        return this.length * this.breadth;
    }
}

class Square implements  Shape
{
    public double edge;

    public Square(double edge)
    {
        this.edge = edge;

    }

    @Override
    public double getperimeter() {
        return 4*this.edge;
    }

    @Override
    public double getArea() {
        return this.edge *  this.edge;
    }
}
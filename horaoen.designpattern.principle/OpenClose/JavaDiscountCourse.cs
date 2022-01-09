﻿
namespace DesignPattern.Principle.OpenClose;
public class JavaDiscountCourse : JavaCourse
{
    private double _price;
    public new double Price
    {
        get => _price;
        set => _price = value * 0.8;
    }

    public JavaDiscountCourse(int id, string name, double price) : base(id, name, price)
    {
        Price = price;
    }
}
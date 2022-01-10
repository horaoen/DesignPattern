using System;

namespace DesignPattern.Principle.OpenClose;
internal interface ICourse
{
    int Id { get; set; }
    String Name { get; set; }
    double Price { get; set; }
}
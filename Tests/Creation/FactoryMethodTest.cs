using DesignPattern.Creation.FactoryMethod;
using Xunit;

namespace Tests.Creation;

public class FactoryMethodTest
{
    [Fact]
    public void FactoryMethod()
    {
        //Arrange
        var stuVideoFactory = new JavaVideoFactory();

        //Act
        var actualJavaVideoProduct = stuVideoFactory.GetVideo().Produce();

        //Assert
        Assert.Equal("Java", actualJavaVideoProduct);
    }
    
}
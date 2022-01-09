using DesignPattern.Principle.OpenClose;
using Xunit;

namespace Tests.Principle;
public class OpenCloseTest
{
    [Fact]
    public void DiscountPrice()
    {
        //Arrange
        var mockJavaDiscountCourse = new JavaDiscountCourse(1, "�����ģʽ", 20.0);
        double discountPrice = 20 * 0.8;
        
        //Assert
        Assert.Equal(discountPrice, mockJavaDiscountCourse.Price);
    }
}
using DesignPattern.Principle.SingleResponsibility;
using Xunit;

namespace Tests.Principle
{
    public class SingleResponsibilityTest
    {
        [Fact]
        public void SingleResponsibilityOfClass()
        {
            //Arrange
            var mockFlyBird = new FlyBird();
            var mockWalkBird = new WalkBird();

            //Act 
            var expectedFlyBird = "翅膀";
            var expectedWalkBird = "脚";

            //Assert
            Assert.Equal(expectedFlyBird, mockFlyBird.MainMoveMode());
            Assert.Equal(expectedWalkBird, mockWalkBird.MainMoveMode());
        }
    }
}

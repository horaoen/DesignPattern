using DesignPattern.Principle.Demeter;
using Xunit;

namespace Tests.Principle
{
    public class DemeterTest
    {
        [Fact]
        public void CommandCheckNumber()
        {
            //Arrange 
            var mockBoss = new Boss();
            var courseNum = 20;
            var stuTeamLeader = new TeamLeader(courseNum);

            //Act
            var expected = courseNum;
            var actual = mockBoss.CommandCheckNumber(stuTeamLeader);

            //Assert
            Assert.Equal(expected, actual);
        }
    }
}

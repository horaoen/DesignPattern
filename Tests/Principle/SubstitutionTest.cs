using DesignPattern.Principle.Substitution;
using Xunit;
using Xunit.Abstractions;

namespace Tests.Principle;

public class SubstitutionTest
{
    public SubstitutionTest(ITestOutputHelper testOutputHelper)
    {
        TestOutputHelper = testOutputHelper;
    }

    [Theory]
    [InlineData(10, 100)]
    public void Resize(long height, long width)
    {
        var rectangle = new Rectangle() {Height = height, Width = width};
        while (rectangle.Width >=rectangle.Height)
        {
            rectangle.Height++;
            TestOutputHelper.WriteLine($"Height:{rectangle.Height},Weight:{rectangle.Width}");
        }

        TestOutputHelper.WriteLine($"Height:{rectangle.Height},Weight:{rectangle.Width}");
    }

    public ITestOutputHelper TestOutputHelper;
}
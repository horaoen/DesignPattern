namespace DesignPattern.Principle.Substitution;

public class Square : IQuadrilateral
{
    public long Width => Length;

    public long Height => Length;

    public long Length { get; set; }
}
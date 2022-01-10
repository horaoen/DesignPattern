using System;

namespace DesignPattern.Principle.InterfaceSegregation
{
    internal class Dog : IEatAnimalAction, ISwimAnimalAction
    {
        public void Eat()
        {
            throw new NotImplementedException();
        }

        public void Swim()
        {
            throw new NotImplementedException();
        }
    }
}

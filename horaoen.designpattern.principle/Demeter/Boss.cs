using System.Collections.Generic;

namespace DesignPattern.Principle.Demeter
{
    public class Boss
    {
        public int CommandCheckNumber(TeamLeader leader)
        {
            return leader.CheckNumberOfCourse();
        }
    }
}

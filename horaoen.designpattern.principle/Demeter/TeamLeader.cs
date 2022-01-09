using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace DesignPattern.Principle.Demeter
{
    public class TeamLeader
    {
        public List<Course> Courses { get; set; }

        public TeamLeader(int courseNum)
        {
            Courses = new List<Course>();
            for (int i = 0; i < courseNum; i++)
            {
                Courses.Add(new Course());
            }
        }

        public int CheckNumberOfCourse()
        {
            return Courses.Count;
        }
    }
}
